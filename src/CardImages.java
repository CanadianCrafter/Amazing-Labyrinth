
/**
 * CardImages class holds the images of cards
 */

import javax.swing.*;

public class CardImages {

	// The array that contains all images of cards
	public static final ImageIcon cardImages[] = new ImageIcon[24];

	// Constructor
	public CardImages() {

		// Load all images
		loadImages();

	}

	// Load all card images
	private void loadImages() {

		// Card ID. Used for array index
		int index = 0;

		// Bat
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Bat.png").getImage().getScaledInstance(45, 70, 0));

		// Dragon
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Dragon.png").getImage().getScaledInstance(45, 70, 0));

		// Ghost Bottle
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/GhostBottle.png").getImage().getScaledInstance(45, 70, 0));

		// Ghost Waving
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/GhostWaving.png").getImage().getScaledInstance(45, 70, 0));

		// Lady Pig
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/LadyPig.png").getImage().getScaledInstance(45, 70, 0));

		// Sorceress
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Sorceress.png").getImage().getScaledInstance(45, 70, 0));

		// Lizard
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Lizard.png").getImage().getScaledInstance(45, 70, 0));

		// Moth
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Moth.png").getImage().getScaledInstance(45, 70, 0));

		// Owl
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Owl.png").getImage().getScaledInstance(45, 70, 0));

		// Scarab
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Scarab.png").getImage().getScaledInstance(45, 70, 0));

		// Rat
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Rat.png").getImage().getScaledInstance(45, 70, 0));

		// Spider
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Spider.png").getImage().getScaledInstance(45, 70, 0));

		// Gold Coins
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/GoldCoins.png").getImage().getScaledInstance(45, 70, 0));

		// Book
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Book.png").getImage().getScaledInstance(45, 70, 0));

		// Crown
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Crown.png").getImage().getScaledInstance(45, 70, 0));

		// Menorah
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Menorah.png").getImage().getScaledInstance(45, 70, 0));

		// Ring
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Ring.png").getImage().getScaledInstance(45, 70, 0));

		// Helmet
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Helmet.png").getImage().getScaledInstance(45, 70, 0));

		// Jewel
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Jewel.png").getImage().getScaledInstance(45, 70, 0));

		// Keys
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Keys.png").getImage().getScaledInstance(45, 70, 0));

		// Skull
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Skull.png").getImage().getScaledInstance(45, 70, 0));

		// Sword
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/Sword.png").getImage().getScaledInstance(45, 70, 0));

		// Treasure Chest
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/TreasureChest.png").getImage().getScaledInstance(45, 70, 0));

		// Treasure Map
		cardImages[index++] = new ImageIcon(
				new ImageIcon("CardImages/TreasureMap.png").getImage().getScaledInstance(45, 70, 0));

	}

}
