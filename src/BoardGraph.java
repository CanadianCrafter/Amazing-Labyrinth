import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Creates a graph based on the board's tile's shape and orientation
 * Using that graph, run BFS to see what tiles are reachable from a certain tile
 * 
 */

public class BoardGraph {
	
	public static ArrayList<Integer> adj[]= new ArrayList[Initialize.NUM_TILES]; //adjacency list
	private static int tempAdj[][]; //temporary adjacency matrix like structure
	
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
	
	
	public BoardGraph() {
		
		createBoardGraph();
		
	}

	public static void createBoardGraph() {
		
		//initialize adjacency list and matrix
		for(int i =0;i<Initialize.NUM_TILES;i++)
			adj[i] = new ArrayList<Integer>();
		
		tempAdj=new int [Initialize.NUM_TILES][Initialize.NUM_TILES];
		
		//for each tile t1, mark the adjacent tiles that t1 has paths leading to 
		//if two tiles both have paths leading to each other, then t1 and t2 is connected.
		//otherwise, one tile has a path, the other has a wall.
		for(int r =0;r<7;r++) {
			for(int c =0;c<7;c++) {
				for(int d=0;d<directions[Board.tileBoard[r][c].getShape()][Board.tileBoard[r][c].getOrientation()].length;d++) {
					
					//row of the adjacent tile
					int r2 = directions[Board.tileBoard[r][c].getShape()][Board.tileBoard[r][c].getOrientation()][d][0]+r;
					int c2 = directions[Board.tileBoard[r][c].getShape()][Board.tileBoard[r][c].getOrientation()][d][1]+c;
					
					if(r2<0||r2>=7||c2<0||c2>=7)continue; //if the adjacent tile is out of bounds; skip it
					
					tempAdj[Board.board[r][c]][Board.board[r2][c2]]++;
					tempAdj[Board.board[r2][c2]][Board.board[r][c]]++;
					
				}
				
			}
		}
		
		//using the temporary adjacency matrix, any dual connections becomes and edge
		for(int r =0;r<Initialize.NUM_TILES;r++) {
			for(int c =0;c<Initialize.NUM_TILES;c++) {
				if(tempAdj[r][c]==2) {
					adj[r].add(c);
					adj[c].add(r);
				}
			}
		}
		
	}
	
	//returns true if sId and dID contain an edge and are connected. Otherwise return false.
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
    	//can't go on the same spot as the other player, but can go over them
    	int otherPlayer = GameGUI.currentPlayer==0?1:0;
    	vis[Board.board[Initialize.players[otherPlayer].getRow()][Initialize.players[otherPlayer].getColumn()]] = false;
    	
    	return vis[dID];
		
	}
	
	//similar to the canMove method, but instead returns a boolean array
	//where reachable tiles are indicated with true
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
    	
    	//can't go on the same spot as the other player, but can go over them
    	int otherPlayer = GameGUI.currentPlayer==0?1:0;
    	vis[Board.board[Initialize.players[otherPlayer].getRow()][Initialize.players[otherPlayer].getColumn()]] = false;
    	
    	return vis;
	}
	
}
