import javax.swing.*;

public class CardImages {
	
	public static final ImageIcon cardImages[]=new ImageIcon[23];
	
	public CardImages() {
		loadImages();
	}
	
	private void loadImages() {
		int index=0;
		
		cardImages[index]=new ImageIcon(new ImageIcon("CardImages/Bat.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Dragon.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/GhostBottle.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/GhostWaving.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/LadyPig.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Sorceress.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImage/Lizard.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Moth.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Owl.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Scarab.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Rat.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Spider.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/GoldCoins.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Book.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Crown.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Menorah.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Ring.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Helmet.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Jewel.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Keys.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Skull.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/Sword.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/TreasureChest.png").getImage().getScaledInstance(45, 70, 0));
		cardImages[index++]=new ImageIcon(new ImageIcon("CardImages/TreasureMap.png").getImage().getScaledInstance(45, 70, 0));
		
		
	}

}
