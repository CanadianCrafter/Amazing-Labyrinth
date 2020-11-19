
import java.util.*;

public class Board {
	
	
	private int freeTile;
	private static int board[][]=new int[7][7];
	private static boolean vis[] = new boolean [33];
	
	public Board() {
		
		//initialize board with -1 to indicate what positions don't have tiles
		for(int i =0; i<7; i++)
			Arrays.fill(board[i],-1);
		
		//Fixed Tiles:
		
		//Starting Points
		board[0][0]=Initialize.getTileNameToID().get("Red");
		board[0][6]=Initialize.getTileNameToID().get("Yellow");
		board[6][0]=Initialize.getTileNameToID().get("Green");
		board[6][6]=Initialize.getTileNameToID().get("Blue");
		
		//Unmoveable Treasure
		board[0][2]=Initialize.getTileNameToID().get("Book");
		board[0][4]=Initialize.getTileNameToID().get("Gold_Coins");
		board[2][0]=Initialize.getTileNameToID().get("Treasure_Map");
		board[2][2]=Initialize.getTileNameToID().get("Crown");
		board[2][4]=Initialize.getTileNameToID().get("Keys");
		board[2][6]=Initialize.getTileNameToID().get("Skull");
		board[4][0]=Initialize.getTileNameToID().get("Ring");
		board[4][2]=Initialize.getTileNameToID().get("Treasure_Chest");
		board[4][4]=Initialize.getTileNameToID().get("Jewel");
		board[4][6]=Initialize.getTileNameToID().get("Sword");
		board[6][2]=Initialize.getTileNameToID().get("Menorah");
		board[6][4]=Initialize.getTileNameToID().get("Helmet");
		
		
		//fill in board with random, movable tiles.
		for(int i =0; i<7; i++) {
			for(int j =0; j<7; j++) {
				
				if(board[i][j]!=-1) continue;
				
				int index = (int)(33*Math.random());
				
				while(!vis[index])
					index = (int)(33*Math.random());
				
				board[i][j]=index;
				vis[index]=true;
				
			}
		}
		
		for(int i =0;i<33;i++) {
			if(!vis[i]) {
				freeTile=i;
				break;
			}
		}
		
	}
	

}

