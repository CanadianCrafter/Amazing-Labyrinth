
public class Card {
	
	private int id;
	private String object;
	private boolean solve;
	
	public Card(int id, String object, boolean solve) {
		
		this.id=id;
		this.object=object;
		this.solve=solve;
	}

	public int getId() {
		return id;
	}

	public String getObject() {
		return object;
	}

	public boolean isSolve() {
		return solve;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public void setSolve(boolean solve) {
		this.solve = solve;
	}
	
	

}
