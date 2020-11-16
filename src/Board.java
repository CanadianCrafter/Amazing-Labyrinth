
import java.util.*;

public class Board {
	
	ArrayList<Tiles> gameBoard=new ArrayList<Tiles>();
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Tiles board[][]=new Tiles[7][7];
		board[1][1]=Tiles.Bat;
		System.out.print(board[1][1].getId());
	}
	

}
