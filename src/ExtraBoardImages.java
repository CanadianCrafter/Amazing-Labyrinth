
/**
 * ExtraBoardImages holds the other images used in the game
 */

import javax.swing.ImageIcon;

public class ExtraBoardImages {

	// The array containing rotation sign images (clockwise and counter-clockwise)
	public static ImageIcon rotationImages[] = new ImageIcon[2];

	// The array contains arrow sign (up/down/left/right)
	public static ImageIcon arrows[] = new ImageIcon[4];

	// The array contains the start screen images used in the GameSetUpGUI class
	public static ImageIcon startScreenImages[] = new ImageIcon[4];

	// Constructor
	public ExtraBoardImages() {

		// load the images
		loadImages();

	}

	// Load all other images used in the game
	private void loadImages() {

		// arrows for turning clockwise/counterclockwise
		rotationImages[0] = new ImageIcon(
				new ImageIcon("OtherImages/clockwise.png").getImage().getScaledInstance(30, 30, 0));
		rotationImages[1] = new ImageIcon(
				new ImageIcon("OtherImages/counterClockwise.png").getImage().getScaledInstance(30, 30, 0));

		// inserting buttons icons (up/down/left/right)
		arrows[0] = new ImageIcon(new ImageIcon("OtherImages/Arrow0.png").getImage().getScaledInstance(24, 16, 0));
		arrows[1] = new ImageIcon(new ImageIcon("OtherImages/Arrow1.png").getImage().getScaledInstance(16, 24, 0));
		arrows[2] = new ImageIcon(new ImageIcon("OtherImages/Arrow2.png").getImage().getScaledInstance(24, 16, 0));
		arrows[3] = new ImageIcon(new ImageIcon("OtherImages/Arrow3.png").getImage().getScaledInstance(16, 24, 0));

		// The start screen images used in the GameSetUpGUI class
		startScreenImages[0] = new ImageIcon(
				new ImageIcon("OtherImages/SetupScreen.png").getImage().getScaledInstance(750, 500, 0));
		startScreenImages[1] = new ImageIcon(
				new ImageIcon("OtherImages/SetupScreenError1.png").getImage().getScaledInstance(750, 500, 0));
		startScreenImages[2] = new ImageIcon(
				new ImageIcon("OtherImages/SetupScreenError2.png").getImage().getScaledInstance(750, 500, 0));
		startScreenImages[3] = new ImageIcon(
				new ImageIcon("OtherImages/SetupScreenError3.png").getImage().getScaledInstance(750, 500, 0));
	}
}
