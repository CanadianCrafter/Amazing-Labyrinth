
public class Player {
	
	private Card[] playCards;
	private int row;
	private int column;
	
	public Player(Card[] playCards, int row, int column) {
		
		this.playCards=playCards;
		setRow(row);
		setColumn(column);
	}

	public Card[] getPlayCards() {
		return playCards;
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
	
	
	
	
	

}
