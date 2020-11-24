import java.io.*;
import java.util.*;

public class Initialize {
		
		static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		static StringTokenizer st;
		
		public final static int NUM_TILES=50;
		public final static int NUM_CARDS=24;
		public final static int NUM_PLAYERS=2;
		
		
		public static Tile allTiles[] = new Tile [NUM_TILES];
		public static Card allCards[] = new Card [NUM_CARDS];
		
		public static Player players[] = new Player [NUM_PLAYERS];
		
		public static Map<String, Integer> tileNameToID = new HashMap();
		
		private static int cardsPerPlayer;
		
		Boolean cardChosen[]=new Boolean[NUM_CARDS];
		
		private static int playerColours[];
		
		
		public Initialize(int cardsPerPlayer, int[] playerColours) throws IOException {
			this.cardsPerPlayer = cardsPerPlayer;
			this.playerColours  =playerColours;
			
			
			initializeTiles();
			
			initializeCards();
			
			initializeTileNameToID();
			
			initializePlayers();
			
			
			new Board();
			
			
			
			new TileImages();
			
			
			
		}
		

		private void initializeTiles() {
			
			int index=0;

			//Adds: bat, dragon, ghostbottle, ghost waving, ladypig, sorceress (T-Shaped)
			for(int i=0; i<6;i++) 
				allTiles[index++]=new Tile(index, 0, true, (int)(4*Math.random()));
				
			//Adds: lizard, moth, owl, scarab, rat, spider (L-shaped)
			for(int i=0; i<6; i++) 
				allTiles[index++]=new Tile(index, 2, true, (int)(4*Math.random()));
			
			
			
			//L shaped Tiles
			for(int i=0; i<9; i++) 
				allTiles[index++]=new Tile(index, 2, true, (int)(4*Math.random()));
			
			//I shaped Tiles
			for(int i=0; i<13; i++) 
				allTiles[index++]=new Tile(index, 1, true, (int)(4*Math.random()));
			
			//Unmovable treasures
			//Adds: goldcoins, book, crown, menorah, ring, helmet, jewel, keys, skull, sword, treasurechest
			//      treasuremap, yellow, red, green, blue
			
			allTiles[index++]=new Tile(index, 0, false, 1);
			allTiles[index++]=new Tile(index, 0, false, 0);
			allTiles[index++]=new Tile(index, 0, false, 1);
			allTiles[index++]=new Tile(index, 0, false, 2);
			allTiles[index++]=new Tile(index, 0, false, 2);
			allTiles[index++]=new Tile(index, 0, false, 2);
			allTiles[index++]=new Tile(index, 0, false, 3);
			allTiles[index++]=new Tile(index, 0, false, 0);
			allTiles[index++]=new Tile(index, 0, false, 3);
			allTiles[index++]=new Tile(index, 0, false, 3);
			allTiles[index++]=new Tile(index, 0, false, 2);
			allTiles[index++]=new Tile(index, 0, false, 1);
			allTiles[index++]=new Tile(index, 2, false, 2);
			allTiles[index++]=new Tile(index, 2, false, 3);
			allTiles[index++]=new Tile(index, 2, false, 0);
			allTiles[index++]=new Tile(index, 2, false, 1);
			
		}
		
		private void initializeCards() {
			
			int index=0;
			
			//Adds: bat, dragon, ghostbottle, ghost waving, ladypig, sorceress
			//		lizard, moth, owl, scarab, rat, spider
			//		goldcoins, book, crown, menorah, ring, helmet, jewel, keys, skull, sword, treasurechest
			//      treasuremap
			
			for(int i=0; i<NUM_CARDS; i++)
				allCards[index++] = new Card(index, false);
				
		}
		
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
		
		private void initializePlayers() {
			players[0] =new Player(0, 0);
			players[1] =new Player(0, 0);
			
			for(int i =0;i<NUM_PLAYERS;i++)
				players[i].setDeck(generateDeck(i));
			
			//Colour: 0-red, 1-yellow, 2-green, 3-blue
			
			for(int i =0;i<NUM_PLAYERS;i++) {
				if(playerColours[i]==0) {
					players[i].setLocation(0, 0);
				}else if(playerColours[i]==1) {
					players[i].setLocation(6, 0);
				}else if(playerColours[i]==2) {
					players[i].setLocation(0, 6);
				}else if(playerColours[i]==3) {
					players[i].setLocation(6, 6);
				}
			}
			
			
		}
		
		public ArrayList<Integer> generateDeck(int playerID) {
			
			ArrayList<Integer> cards=new ArrayList<Integer>();
			
			int cardIndex;
			
			Arrays.fill(cardChosen, false);
				
			for(int i=0; i<cardsPerPlayer; i++) {
				do {
					cardIndex=(int)(Math.random()*NUM_CARDS);
				}while(cardChosen[cardIndex]);
				
				cards.add(cardIndex);
				cardChosen[cardIndex]=true;
			}
			return cards;
			
		}
		
		
		
		
		public Tile[] getAllTiles() {
			return allTiles;
		}
		
		public Card[] getAllCards() {
			return allCards;
		}

		public static Map<String, Integer> getTileNameToID() {
			return tileNameToID;
		}

		public void setTileNameToID(Map<String, Integer> tileNameToID) {
			this.tileNameToID = tileNameToID;
		}
		
}
