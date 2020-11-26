import javax.swing.*;

public class TileImages {
	
	public static final ImageIcon tileImages[][] = new ImageIcon[50][4];
	
	public TileImages() {
		
		loadImages();
		
	}

	private void loadImages() {
		int index = 0;
		
	    //Bat
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Bat0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Bat1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Bat2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Bat3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Dragon
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Dragon0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Dragon1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Dragon2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Dragon3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Ghost Bottle
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/GhostBottle0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/GhostBottle1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/GhostBottle2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/GhostBottle3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Ghost Waving
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/GhostWaving0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/GhostWaving1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/GhostWaving2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/GhostWaving3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Lady Pig
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/LadyPig0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/LadyPig1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/LadyPig2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/LadyPig3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Sorceress
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Sorceress0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Sorceress1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Sorceress2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Sorceress3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Lizard
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Lizard0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Lizard1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Lizard2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Lizard3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Moth
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Moth0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Moth1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Moth2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Moth3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Owl
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Owl0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Owl1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Owl2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Owl3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Scarab
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Scarab0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Scarab1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Scarab2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Scarab3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Rat
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Rat0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Rat1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Rat2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Rat3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    //Spider
	    tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/Spider0.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/Spider1.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/Spider2.png").getImage().getScaledInstance(50, 50, 0));
	    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/Spider3.png").getImage().getScaledInstance(50, 50, 0));
	    
	    index+= 16;
	    
	    //Fixed Tiles
	    for(int i =0;i<4;i++) {
	    	index-=16;
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/GoldCoins.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Book.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Crown.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Menorah.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Ring.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Helmet.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Jewel.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Keys.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Skull.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Sword.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/TreasureChest.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/TreasureMap.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Yellow.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Red.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Green.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][i] = new ImageIcon(new ImageIcon("TileImages/Blue.png").getImage().getScaledInstance(50, 50, 0));
	    }
	    
	    //L shaped Tiles
		for(int i=0; i<9; i++) {
			tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/L0.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/L1.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/L2.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/L3.png").getImage().getScaledInstance(50, 50, 0));
		}    
		
		//I shaped Tiles
		for(int i=0; i<13; i++) {
			tileImages[index][0] = new ImageIcon(new ImageIcon("TileImages/I0.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index][1] = new ImageIcon(new ImageIcon("TileImages/I1.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index][2] = new ImageIcon(new ImageIcon("TileImages/I2.png").getImage().getScaledInstance(50, 50, 0));
		    tileImages[index++][3] = new ImageIcon(new ImageIcon("TileImages/I3.png").getImage().getScaledInstance(50, 50, 0));	    
		}
		
	}
    
}