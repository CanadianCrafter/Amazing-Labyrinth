
public class Tile {
	
	private int id;
	private String object;
	private int shape;
	private boolean move;
	private int orientation;
	
	
	public Tile(int id, String object, int shape, boolean move, int orientation) {
		
		//Not changeable
		this.id=id;
		this.object=object;
		this.move=move;
		
		//1=T, 2=I, 3=L
		this.shape=shape;
		
		//Changeable
		setOrientation(orientation);
	}


	public int getId() {
		return id;
	}


	public String getObject() {
		return object;
	}


	public int getShape() {
		return shape;
	}


	public boolean isMove() {
		return move;
	}


	public int getOrientation() {
		return orientation;
	}



	public void setOrientation(int orientation) {
		
		//0= T / I / L
		//1= T with exits up/down/right  /  I with exits left/right  / L with exit up and left
		//2= T with exits up/left/right  /  I  /  L with exits left/down
		//3= T with exits up/left/down   /  I with exits left/right /  L with exit down and right
		
		if(isMove()) {
			this.orientation = orientation;
		}
	}
	
	
	
	
	

}
