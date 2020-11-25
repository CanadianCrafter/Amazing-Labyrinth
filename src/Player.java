
import java.util.*;

public class Player {
	
	private TreeSet <Integer> deck=new TreeSet<Integer>();
	private int row;
	private int column;
	
	public Player(int row, int column) {

		setRow(row);
		setColumn(column);
	}

	public TreeSet<Integer> getDeck() {
		return deck;
	}
	

	public void setDeck(TreeSet<Integer> deck) {
		this.deck = deck;
	}
	

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		if(row>=0 && row<=6) {
			this.row = row;
		}else {
			this.row=0;
		}
		
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		if(column>=0 && column<=6) {
			this.column= column;
		}else {
			this.column=0;
		}
	}
	
	public void setLocation(int row, int column) {
		if(row>=0 && row<=6) {
			this.row = row;
		}else {
			this.row=0;
		}
		
		if(column>=0 && column<=6) {
			this.column= column;
		}else {
			this.column=0;
		}
	}
	
	public int[] getLocation() {
		
		int[] location=new int[2];
				
		location[0]=row;
		location[1]=column;
		
		return(location);
	}
	
//	public boolean win() {
//		
//		for(Card currentCard: playCards) {
//			if(!currentCard.isSolve()) {
//				return false;
//			}
//		}
//		
//		return true;
//	}
	
	
	

}