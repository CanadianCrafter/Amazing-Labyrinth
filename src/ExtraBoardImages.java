import javax.swing.ImageIcon;

public class ExtraBoardImages {
	
	public static ImageIcon rotationImages[]=new ImageIcon[2];
	public static ImageIcon arrows[]=new ImageIcon[4];
	
	
	public ExtraBoardImages() {
		loadImages();
		
	}

	private void loadImages() {
		//arrows for turning clockwise/counterclockwise
		rotationImages[0] = new ImageIcon(new ImageIcon("OtherImages/clockwise.png").getImage().getScaledInstance(30, 30, 0));
		rotationImages[1] =  new ImageIcon(new ImageIcon("OtherImages/counterClockwise.png").getImage().getScaledInstance(30, 30, 0));
		
		arrows[0]=new ImageIcon(new ImageIcon("OtherImages/Arrow0.png").getImage().getScaledInstance(24, 16, 0));
		arrows[1]=new ImageIcon(new ImageIcon("OtherImages/Arrow1.png").getImage().getScaledInstance(16, 24, 0));
		arrows[2]=new ImageIcon(new ImageIcon("OtherImages/Arrow2.png").getImage().getScaledInstance(24, 16, 0));
		arrows[3]=new ImageIcon(new ImageIcon("OtherImages/Arrow3.png").getImage().getScaledInstance(16, 24, 0));
	}
}
