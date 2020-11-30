
import java.util.*;

public class Player {

	private ArrayList<Integer> deck = new ArrayList<Integer>();//The cards the user is holding
	private int row; //The row the user is currently at
	private int column;// The column the user is currently at
	private int colourID; //The colour id of the user. Colour: 0-red, 1-yellow, 2-green, 3-blue

	// Constructor (Initialize all variables to initial values)
	public Player() {

	}

	// Return the Arraylist deck containing the cards user have
	public ArrayList<Integer> getDeck() {
		return deck;
	}

	// Set the Arraylist deck containing the cards user have
	public void setDeck(ArrayList<Integer> deck) {
		this.deck = deck;
	}

	// Return the row the player is currently at
	public int getRow() {
		return row;
	}

	// Set the row the player is currently at
	public void setRow(int row) {
		// For eligible row number
		if (row >= 0 && row <= 6) {
			this.row = row;
		} else {
			this.row = 0; // For all other row number
		}

	}

	// Return the column number the player is currently at
	public int getColumn() {
		return column;
	}

	// Set the column number the player is currently at
	public void setColumn(int column) {
		// For eligiblle column number
		if (column >= 0 && column <= 6) {
			this.column = column;
		} else {
			this.column = 0; // For all other column number
		}
	}

	// Set up the location (row and column number) the user is currently at
	public void setLocation(int row, int column) {
		// For eligible row number
		if (row >= 0 && row <= 6) {
			this.row = row;
		} else {
			this.row = 0; // For all other row number
		}

		// For eligible column number
		if (column >= 0 && column <= 6) {
			this.column = column;
		} else {
			this.column = 0; // For all other column number
		}
	}

	// Return the location the player is currently at as an integer array
	public int[] getLocation() {

		int[] location = new int[2];

		location[0] = row;
		location[1] = column;

		return (location);
	}

	// Return the colour id of the user
	public int getColourID() {
		return colourID; // Colour: 0-red, 1-yellow, 2-green, 3-blue
	}

	// Set the colour id of the user
	public void setColourID(int colourID) {
		this.colourID = colourID; // Colour: 0-red, 1-yellow, 2-green, 3-blue
	}

}
