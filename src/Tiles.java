
public enum Tiles {
	
	
	Bat(1, "bat", 1);
	
	private final int id;
	private final String object;
	private final int shape;
	
	Tiles(int id, String object, int shape){
		this.id=id;
		this.object=object;
		this.shape=shape;
	}

	public int getId() {
		return id;
	}

	public String getObject() {
		return object;
	}

	public int getShape() {
		
		//1=T
		//2=I
		//3=L
		return shape;
	}
	
	

}
