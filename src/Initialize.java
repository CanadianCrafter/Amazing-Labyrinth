import java.io.*;
import java.util.*;

public class Initialize {
		
		static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		static StringTokenizer st;
		
		public static Tile allTiles[] = new Tile [50];
		public static Card allCards[] = new Card [24];
		
		public static Map<String, Integer> tileNameToID = new HashMap();
		
		
		public Initialize() throws IOException {
			
			initializeTiles();
			initializeCards();
			initializeTileNameToID();
			
		}
		

		private void initializeTiles() {
			
			int index=0;

			//Adds: bat, dragon, ghostbottle, ghost waving, ladypig, sorceress (T-Shaped)
			for(int i=0; i<6;i++) 
				allTiles[index++]=new Tile(index, 0, true, (int)(4*Math.random()));
				
			//Adds: lizard, moth, owl, scarab, rat, spider (L-shaped)
			for(int i=0; i<6; i++) 
				allTiles[index++]=new Tile(index, 2, true, (int)(4*Math.random()));
			
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
			
			//L shaped Tiles
			for(int i=0; i<9; i++) 
				allTiles[index++]=new Tile(index, 2, true, (int)(4*Math.random()));
			
			//I shaped Tiles
			for(int i=0; i<13; i++) 
				allTiles[index++]=new Tile(index, 1, true, (int)(4*Math.random()));
			
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

		
}
