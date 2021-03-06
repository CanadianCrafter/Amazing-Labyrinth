
import java.util.*;

public class Board {

	public static int freeTile;
	public static int board[][]=new int[7][7]; //board of tile IDs
	private static boolean vis[] = new boolean [Initialize.NUM_TILES];
	
	public static Tile tileBoard[][] = new Tile[7][7];
	public static Tile tileFreeTile;
	
	public Board() {
		
		createBoard();
		createTileBoard();
		new BoardGraph();
		
	}

	public static void createBoard() {
		//initialize board with -1 to indicate what positions don't have tiles
		for(int i =0; i<7; i++)
			Arrays.fill(board[i],-1);
		
		//Fixed Tiles:
		
		//Starting Points
		board[0][0]=Initialize.tileNameToID.get("Red");
		board[0][6]=Initialize.tileNameToID.get("Yellow");
		board[6][0]=Initialize.tileNameToID.get("Green");
		board[6][6]=Initialize.tileNameToID.get("Blue");
		
		//Unmoveable Treasure
		board[0][2]=Initialize.tileNameToID.get("Book");
		board[0][4]=Initialize.tileNameToID.get("Gold_Coins");
		board[2][0]=Initialize.tileNameToID.get("Treasure_Map");
		board[2][2]=Initialize.tileNameToID.get("Crown");
		board[2][4]=Initialize.tileNameToID.get("Keys");
		board[2][6]=Initialize.tileNameToID.get("Skull");
		board[4][0]=Initialize.tileNameToID.get("Ring");
		board[4][2]=Initialize.tileNameToID.get("Treasure_Chest");
		board[4][4]=Initialize.tileNameToID.get("Jewel");
		board[4][6]=Initialize.tileNameToID.get("Sword");
		board[6][2]=Initialize.tileNameToID.get("Menorah");
		board[6][4]=Initialize.tileNameToID.get("Helmet");
		
		//Unmovable tiles are already added; no need to add again
		//Unmovable Non-Treasure
		
		vis[Initialize.tileNameToID.get("Red")]=true;
		vis[Initialize.tileNameToID.get("Yellow")]=true;
		vis[Initialize.tileNameToID.get("Green")]=true;
		vis[Initialize.tileNameToID.get("Blue")]=true;
		
		//Unmovable Treasure
		vis[Initialize.tileNameToID.get("Book")]=true;
		vis[Initialize.tileNameToID.get("Gold_Coins")]=true;
		vis[Initialize.tileNameToID.get("Treasure_Map")]=true;
		vis[Initialize.tileNameToID.get("Crown")]=true;
		vis[Initialize.tileNameToID.get("Keys")]=true;
		vis[Initialize.tileNameToID.get("Skull")]=true;
		vis[Initialize.tileNameToID.get("Ring")]=true;
		vis[Initialize.tileNameToID.get("Treasure_Chest")]=true;
		vis[Initialize.tileNameToID.get("Jewel")]=true;
		vis[Initialize.tileNameToID.get("Sword")]=true;
		vis[Initialize.tileNameToID.get("Menorah")]=true;
		vis[Initialize.tileNameToID.get("Helmet")]=true;
		
		
		//fill in board with random, movable tiles.
		for(int i =0; i<7; i++) {
			for(int j =0; j<7; j++) {
				
				if(board[i][j]!=-1) continue;
				
				int index = (int)(Initialize.NUM_TILES*Math.random());
				
				while(vis[index])
					index = (int)(Initialize.NUM_TILES*Math.random());
				
				board[i][j]=index;
				vis[index]=true;
				
			}
		}
		
		for(int i =0;i<Initialize.NUM_TILES;i++) {
			if(!vis[i]) {
				freeTile=i;
				break;
			}
		}
	}

	//given the board, make a board of tiles
	public static void createTileBoard() {
		
		for(int i =0;i<7;i++) {
			for(int j =0;j<7;j++) {
				
				tileBoard[i][j]=Initialize.allTiles[board[i][j]];
				
			}
		}
		
		tileFreeTile = Initialize.allTiles[freeTile];
	}

	public static int[][] getBoard() {
		return board;
	}

	public static void setBoard(int[][] board) {
		Board.board = board;
	}

	public static int getFreeTile() {
		return freeTile;
	}

	public static void setFreeTile(int tile) {
		tileFreeTile = Initialize.allTiles[tile];
		freeTile = tile;
	}
	
	
	

}

