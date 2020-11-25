
import java.util.ArrayList;

public class Tile {
	
	private int id;
	private String object;
	private int shape;
	private boolean move;
	private int orientation;
	
	
	public Tile(int id, int shape, boolean move, int orientation) {
		
		//Not changeable
		this.id=id;
		this.move=move;
		
		//0=T, 1=I, 2=L
		this.shape=shape;
		
		//Changeable
		setOrientation(orientation);
	}


	public int getID() {
		return id;
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
		//1= -| /  -  / r
		//2= _|_  /  I  /  7
		//3= |-  /  - /  _|
		
		if(isMove()) {
			this.orientation = orientation;
		}
	}
	
	public static Tile findTileWithID(ArrayList<Tile> list, int id) {
		
		for(Tile t: list) {
			if(t.getID()==id) {
				return t;
			}
		}
		
		return null;
	}
	
	
	
	
	

}
