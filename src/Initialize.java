
public class Initialize {
		
		private Tile allTiles[] = new Tile [50];
		private Card allCards[] = new Card [24];
		
		
		public Initialize() {
			
			initializeTiles();
			initializeCards();
			
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
			//      treasuremap, yellow, red, green, blue
			
			for(int i=0; i<24; i++)
				allCards[index++] = new Card(index, false);
				
		}

		
		public Tile[] getAllTiles() {
			return allTiles;
		}
		
		public Card[] getAllCards() {
			return allCards;
		}


		

		
}
