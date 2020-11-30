import java.io.*;
import java.util.*;

public class Initialize {
		
		static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		static StringTokenizer st;
		
		//Constants
		public final static int NUM_TILES=50;
		public final static int NUM_CARDS=24;
		public final static int NUM_PLAYERS=2;
		
		//saves all the tiles
		public static Tile allTiles[] = new Tile [NUM_TILES];
		
		//saves all the players
		public static Player players[] = new Player [NUM_PLAYERS];
		
		// tile's string name as a key, tileID as value. This is to save time for coding
		public static Map<String, Integer> tileNameToID = new HashMap();
		
		//game set up options
		public static int cardsPerPlayer;
		static boolean cardChosen[]=new boolean[NUM_CARDS];
		public static int playerColours[] = new int [NUM_PLAYERS];
		
		//constructer method
		public Initialize(int cardsPerPlayer, int[] playerColours, boolean ifLoad) throws IOException {
			
			this.cardsPerPlayer = cardsPerPlayer;
			this.playerColours  =playerColours;
			
			initializeTiles();
			initializeTileNameToID();
			initializePlayers();
			
			new TileImages();
			new CardImages();
			new ExtraBoardImages();
			new Board();
			
			if(ifLoad) loadSaveState();
			
		}
		
		
		//this constructor is only called if there is a save file. this ifLoad is a little redundant
		public Initialize(boolean ifLoad) throws IOException {
			
			initializeTiles();
			initializeTileNameToID();
			
			
			new TileImages();
			new CardImages();
			new ExtraBoardImages();
			new Board();
			
			for(int i =0;i<NUM_PLAYERS;i++)
				players[i] =new Player();
			
			if(ifLoad) loadSaveState();
			
		}
		
		//initializes the tile data
		private void initializeTiles() {
			
			int index=0;

			//Adds: bat, dragon, ghostbottle, ghost waving, ladypig, sorceress (T-Shaped)
			for(int i=0; i<6;i++) 
				allTiles[index]=new Tile(index++, 0, true, (int)(4*Math.random()));
				
			//Adds: lizard, moth, owl, scarab, rat, spider (L-shaped)
			for(int i=0; i<6; i++) 
				allTiles[index]=new Tile(index++, 2, true, (int)(4*Math.random()));
			
			//Unmovable treasures
			//Adds: goldcoins, book, crown, menorah, ring, helmet, jewel, keys, skull, sword, treasurechest
			//      treasuremap, yellow, red, green, blue
			
			allTiles[index]=new Tile(index++, 0, false, 0);
			allTiles[index]=new Tile(index++, 0, false, 0);
			allTiles[index]=new Tile(index++, 0, false, 3);
			allTiles[index]=new Tile(index++, 0, false, 2);
			allTiles[index]=new Tile(index++, 0, false, 3);
			allTiles[index]=new Tile(index++, 0, false, 2);
			allTiles[index]=new Tile(index++, 0, false, 1);
			allTiles[index]=new Tile(index++, 0, false, 0);
			allTiles[index]=new Tile(index++, 0, false, 1);
			allTiles[index]=new Tile(index++, 0, false, 1);
			allTiles[index]=new Tile(index++, 0, false, 2);
			allTiles[index]=new Tile(index++, 0, false, 3);
			allTiles[index]=new Tile(index++, 2, false, 2);
			allTiles[index]=new Tile(index++, 2, false, 1);
			allTiles[index]=new Tile(index++, 2, false, 0);
			allTiles[index]=new Tile(index++, 2, false, 3);
			
			//L shaped Tiles
			for(int i=0; i<9; i++) 
				allTiles[index]=new Tile(index++, 2, true, (int)(4*Math.random()));
			
			//I shaped Tiles
			for(int i=0; i<13; i++) 
				allTiles[index]=new Tile(index++, 1, true, (int)(4*Math.random()));
			
		}
		
		//reads in the tile name and its corresponding tile ID. this simplifies some of the code later on
		private void initializeTileNameToID() throws IOException{
			BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/UnmovableTileIDs.txt")));
			
			for(int i =0;i<28;i++) {
				while (st == null || !st.hasMoreTokens())
		            st = new StringTokenizer(br.readLine().trim());
				String str = st.nextToken();
				
				while (st == null || !st.hasMoreTokens())
		            st = new StringTokenizer(br.readLine().trim());
				String strNum = st.nextToken();
				int num = Integer.parseInt(strNum);
				
				tileNameToID.put(str,num);
			}
			br.close();
				
		}
		
		//initializes the players
		public static void initializePlayers() {
			
			for(int i =0;i<NUM_PLAYERS;i++)
				players[i] =new Player();
			
			
			for(int i =0;i<NUM_PLAYERS;i++)
				players[i].setDeck(generateDeck(i));
			
			//Colour: 0-red, 1-yellow, 2-green, 3-blue
			
			for(int i =0;i<NUM_PLAYERS;i++) {
				if(playerColours[i]==0) {
					players[i].setLocation(0, 0);
				}else if(playerColours[i]==1) {
					players[i].setLocation(0, 6);
				}else if(playerColours[i]==2) {
					players[i].setLocation(6, 0);
				}else if(playerColours[i]==3) {
					players[i].setLocation(6, 6);
				}
				players[i].setColourID(playerColours[i]);
			}
			
			
		}
		
		//randomly generates a deck of cards for the players to start off with
		public static ArrayList<Integer> generateDeck(int playerID) {
			
			ArrayList<Integer> cards=new ArrayList<Integer>();
			
			int cardIndex;
				
			for(int i=0; i<cardsPerPlayer; i++) {
				do {
					cardIndex=(int)(Math.random()*NUM_CARDS);
				}while(cardChosen[cardIndex]);
				
				cards.add(cardIndex);
				cardChosen[cardIndex]=true;
			}
			return cards;
			
		}
		
		//Loads in a save state
		private void loadSaveState() throws IOException {
			
			try {
				BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/Save.txt")));
				
				//load in board
				int tempBoard[][] = new int[7][7];
				for(int i =0;i<7;i++) {
					for(int j=0;j<7;j++) {
						while (st == null || !st.hasMoreTokens())
				            st = new StringTokenizer(br.readLine().trim());
						tempBoard[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				//load in free tile
				while (st == null || !st.hasMoreTokens())
		            st = new StringTokenizer(br.readLine().trim());
				Board.setFreeTile(Integer.parseInt(st.nextToken()));
				
				Board.setBoard(tempBoard);
				
				
				//load in tile orientation
				int tempOrientation[][] = new int[7][7];
				for(int i =0;i<7;i++) {
					for(int j=0;j<7;j++) {
						while (st == null || !st.hasMoreTokens())
				            st = new StringTokenizer(br.readLine().trim());
						int orientation = Integer.parseInt(st.nextToken());
						allTiles[Board.board[i][j]].setOrientation(orientation) ;
					}
				}
				
				Board.createTileBoard();
				BoardGraph.createBoardGraph();		
				
				
				//load in player colours
				for(int i =0;i<NUM_PLAYERS;i++) {
					while (st == null || !st.hasMoreTokens())
			            st = new StringTokenizer(br.readLine().trim());
					playerColours[i]=Integer.parseInt(st.nextToken());
					players[i].setColourID(playerColours[i]);
				}
				
				//load in number of cards per player
				while (st == null || !st.hasMoreTokens())
		            st = new StringTokenizer(br.readLine().trim());
				cardsPerPlayer=Integer.parseInt(st.nextToken());
				
				//loads in the player's cards
				for(int i =0;i<NUM_PLAYERS;i++) {
					for(int j=0;j<cardsPerPlayer;j++) {
						while (st == null || !st.hasMoreTokens())
				            st = new StringTokenizer(br.readLine().trim());
						int val = Integer.parseInt(st.nextToken());
						if(val!=-1)
							players[i].getDeck().add(val);
					}
				}
				
				
				//loads in player positions
				for(int i =0;i<NUM_PLAYERS;i++) {
					//sets row
					while (st == null || !st.hasMoreTokens())
			            st = new StringTokenizer(br.readLine().trim());
					players[i].setRow(Integer.parseInt(st.nextToken()));
					
					//sets column
					while (st == null || !st.hasMoreTokens())
			            st = new StringTokenizer(br.readLine().trim());
					players[i].setColumn(Integer.parseInt(st.nextToken()));
					
				}
				
				
				br.close();
				
			}
			
			// print the error if there is one
			catch (FileNotFoundException error) {
				System.out.println(error);
			}
			
			//after the data is extracted, the save is wiped so that, you cannot return to a used save.
			//saving merely pauses time; not reverse it
			try {
				new PrintWriter("Save.txt").close();
			} 
			
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		
		public Tile[] getAllTiles() {
			return allTiles;
		}
		
		public static Map<String, Integer> getTileNameToID() {
			return tileNameToID;
		}

		public void setTileNameToID(Map<String, Integer> tileNameToID) {
			this.tileNameToID = tileNameToID;
		}
		
}
