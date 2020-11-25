import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BoardGraph {
	
//	private static final int NUM_BOARD_TILES = 49;
	
	public static ArrayList<Integer> adj[]= new ArrayList[Initialize.NUM_TILES];
	private static int tempAdj[][] = new int [Initialize.NUM_TILES][Initialize.NUM_TILES];
	
	//tile shape, orientation, movement directions
	private static int directions[][][][] = {
			{
				{{1,0},{0,1},{0,-1}}, //T0  "T"
				{{-1,0},{0,-1},{1,0}}, //T1  "-|"
				{{0,1},{0,-1},{-1,0}}, //T2   "_|_"
				{{-1,0},{0,1},{1,0}} //T3	 "|-"
			},
			{
				{{-1,0},{1,0}}, //I0   "I"
				{{0,1},{0,-1}}, //I1   "-"
				{{-1,0},{1,0}}, //I2   "I"
				{{0,1},{0,-1}}, //I3   "-"
			},
			{
				{{0,1},{-1,0}}, //L0   "L"
				{{1,0},{0,1}}, //L1   "r"
				{{1,0},{0,-1}}, //L2   "7"
				{{0,-1},{-1,0}}, //L3   "_|"
			}
			
		};
	//down, right, left, up
	private static int direction[][] = {{1,0},{0,1},{0,-1},{-1,0}};
	
	
	
	public BoardGraph() {
		
		createBoardGraph();
		
	}



	public static void createBoardGraph() {
		for(int i =0;i<Initialize.NUM_TILES;i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int r =0;r<7;r++) {
			for(int c =0;c<7;c++) {
				for(int d=0;d<directions[Board.tileBoard[r][c].getShape()][Board.tileBoard[r][c].getOrientation()].length;d++) {
					int r2 = directions[Board.tileBoard[r][c].getShape()][Board.tileBoard[r][c].getOrientation()][d][0]+r;
					int c2 = directions[Board.tileBoard[r][c].getShape()][Board.tileBoard[r][c].getOrientation()][d][1]+c;
					if(r2<0||r2>=7||c2<0||c2>=7)continue;
					tempAdj[Board.board[r][c]][Board.board[r2][c2]]++;
					tempAdj[Board.board[r2][c2]][Board.board[r][c]]++;
					
				}
				
			}
		}
		
		for(int r =0;r<Initialize.NUM_TILES;r++) {
			for(int c =0;c<Initialize.NUM_TILES;c++) {
				if(tempAdj[r][c]==2) {
					adj[r].add(c);
					adj[c].add(r);
				}
			}
		}
		
	}
	
	public static boolean canMove(int sID, int dID) {
		
		//BFS
		Queue<Integer> que = new LinkedList<Integer>();
    	que.add(sID);
    	boolean vis[] = new boolean[Initialize.NUM_TILES];
    	Arrays.fill(vis, false);
    	vis[sID]=true;
    	vis[Board.freeTile]=true;
    	while(!que.isEmpty()) {
    		int u = que.poll();
    		for(int v : adj[u]) {
    			if(!vis[v]) {
    				que.add(v);
    				vis[v]=true;
    			}
    		}
		}
    	return vis[dID];
		
		
	}
	
	public static boolean[] possiblePaths (int sID) {
		
		//BFS
		Queue<Integer> que = new LinkedList<Integer>();
    	que.add(sID);
    	boolean vis[] = new boolean[Initialize.NUM_TILES];
    	Arrays.fill(vis, false);
    	vis[sID]=true;
    	vis[Board.freeTile]=true;
    	while(!que.isEmpty()) {
    		int u = que.poll();
    		for(int v : adj[u]) {
    			if(!vis[v]) {
    				que.add(v);
    				vis[v]=true;
    			}
    		}
		}
    	return vis;
	}
	
}
