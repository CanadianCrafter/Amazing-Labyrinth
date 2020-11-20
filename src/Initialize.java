import java.io.*;
import java.util.*;

public class Initialize {
		
		static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		static StringTokenizer st;
		
		public static Tile allTiles[] = new Tile [50];
		public static Card allCards[] = new Card [24];
		
		public static Player player1=new Player(0, 0);
		public static Player player2=new Player(0, 0);
		
		public static Map<String, Integer> tileNameToID = new HashMap();
		
		
		public Initialize(int numCard, int player1Colour, int player2Colour) throws IOException {
			
			initializeTiles();
			initializeCards();
			initializeTileNameToID();
			initializePlayer(numCard, player1Colour, player2Colour);
			
		}
		

		private void initializeTiles() {
			
			int index=0;

			//Adds: bat, dragon, ghostbottle, ghost waving, ladypig, sorceress (T-Shaped)
			for(int i=0; i<6;i++) 
				allTiles[index++]=new Tile(index, 1, true, (int)(4*Math.random()));
				
			//Adds: lizard, moth, owl, scarab, rat, spider (L-shaped)
			for(int i=0; i<6; i++) 
				allTiles[index++]=new Tile(index, 3, true, (int)(4*Math.random()));
			
			//Unmovable treasures
			//Adds: goldcoins, book, crown, menorah, ring, helmet, jewel, keys, skull, sword, treasurechest
			//      treasuremap, yellow, red, green, blue
			
			allTiles[index++]=new Tile(index, 1, false, 1);
			allTiles[index++]=new Tile(index, 1, false, 0);
			allTiles[index++]=new Tile(index, 1, false, 1);
			allTiles[index++]=new Tile(index, 1, false, 2);
			allTiles[index++]=new Tile(index, 1, false, 2);
			allTiles[index++]=new Tile(index, 1, false, 2);
			allTiles[index++]=new Tile(index, 1, false, 3);
			allTiles[index++]=new Tile(index, 1, false, 0);
			allTiles[index++]=new Tile(index, 1, false, 3);
			allTiles[index++]=new Tile(index, 1, false, 3);
			allTiles[index++]=new Tile(index, 1, false, 2);
			allTiles[index++]=new Tile(index, 1, false, 1);
			allTiles[index++]=new Tile(index, 3, false, 2);
			allTiles[index++]=new Tile(index, 3, false, 3);
			allTiles[index++]=new Tile(index, 3, false, 0);
			allTiles[index++]=new Tile(index, 3, false, 1);
			
			//L shaped Tiles
			for(int i=0; i<9; i++) 
				allTiles[index++]=new Tile(index, 3, true, (int)(4*Math.random()));
			
			//I shaped Tiles
			for(int i=0; i<13; i++) 
				allTiles[index++]=new Tile(index, 2, true, (int)(4*Math.random()));
			
		}
		
		private void initializeCards() {
			
			int index=0;
			
			//Adds: bat, dragon, ghostbottle, ghost waving, ladypig, sorceress
			//		lizard, moth, owl, scarab, rat, spider
			//		goldcoins, book, crown, menorah, ring, helmet, jewel, keys, skull, sword, treasurechest
			//      treasuremap
			
			for(int i=0; i<24; i++)
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
		
public void initializePlayer(int numCards, int player1Colour, int player2Colour) {
			
			ArrayList<Card> player1Card=new ArrayList<Card>();
			ArrayList<Card> player2Card=new ArrayList<Card>();
			Boolean cardChosen[]=new Boolean[allCards.length];
			
			int cardIndex;
				
			for(int x=0; x<numCards; x++) {
				do {
					cardIndex=(int)(Math.random()*(allCards.length+1));
				}while(cardChosen[cardIndex]);
				
				player1Card.add(allCards[cardIndex]);
				cardChosen[cardIndex]=true;
				
				do {
					cardIndex=(int)(Math.random()*(allCards.length+1));
				}while(!cardChosen[cardIndex]);
				
				player2Card.add(allCards[cardIndex]);
				cardChosen[cardIndex]=true;
					
			}
			
			player1.setPlayCards(player1Card);
			player2.setPlayCards(player2Card);
			
			//Colour: 0-red, 1-yellow, 2-green, 3-blue
			if(player1Colour==0) {
				player1.setLocation(0, 0);
			}else if(player1Colour==1) {
				player1.setLocation(6, 0);
			}else if(player1Colour==2) {
				player1.setLocation(0, 6);
			}else if(player1Colour==3) {
				player1.setLocation(6, 6);
			}
			
			if(player2Colour==0) {
				player2.setLocation(0, 0);
			}else if(player2Colour==1) {
				player2.setLocation(6, 0);
			}else if(player2Colour==2) {
				player2.setLocation(0, 6);
			}else if(player2Colour==3) {
				player2.setLocation(6, 6);
			}
			
		}

		
}
