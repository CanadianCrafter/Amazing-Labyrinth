
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
		
//		//Starting Points
//		board[0][0]=red;
//		board[0][6]=green;
//		board[6][0]=yellow;
//		board[6][6]=green;
//		
//		//Unmoveable Treasure
//		board[0][2]=book;
//		board[0][4]=goldCoins;
//		board[2][0]=treasureMap;
//		board[2][2]=crown;
//		board[2][4]=keys;
//		board[2][6]=skull;
//		board[4][0]=ring;
//		board[4][2]=treasurechest;
//		board[4][4]=jewel;
//		board[4][6]=sword;
//		board[6][2]=menorah;
//		board[6][4]=helmet;
		
		
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

