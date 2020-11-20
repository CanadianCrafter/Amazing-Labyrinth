
public class Card {
	
	private int id;
	private boolean solve;
	
	public Card(int id, boolean solve) {
		
		this.id=id;
		this.solve=solve;
	}

	public int getId() {
		return id;
	}

	public boolean isSolve() {
		return solve;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSolve(boolean solve) {
		this.solve = solve;
	}
	
	

}
