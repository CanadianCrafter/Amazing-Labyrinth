
//imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import audio.AudioPlayer;
import audio.MusicPlayer;

public class GameGUI extends JFrame implements ActionListener {

	// Buffered Reader
	static StringTokenizer st;

	// gui stuff
	static JFrame frame; // JFrame
	private static JPanel screen; // JPanel
	private JLabel freeTileLabel; // this label is for the free tile
	private JButton[][] tileButtons; // the tiles on the board (row, column)
	private JButton[] insertButtons; // the buttons that push tiles onto the board (0 to 11)
	private JButton[] rotateButtons; // the buttons that rotate the free tile (two buttons)
	private JLabel[][] cardLabels; // the labels for the cards (player, number of cards at the start);
	private JLabel[] playerIndicationLabel; // organizes the cards by player

	// menubar stuff
	private static JMenuBar mb = new JMenuBar();
	private static JMenu menu = new JMenu();
	private static JMenuItem save;
	private static JMenuItem exit;
	private static JMenuItem music;
	private static boolean playingMusic = true;

	// Game Rules
	public static int currentPlayer = 0; // The current player
	private int disabledInsertButton = -1; // The insert button that should be disabled in the following round
	private boolean hasInsertTile = false; // Whether the player has inserted the tile

	// constructor method
	public GameGUI() throws IOException {
		// Initialize
		tileButtons = new JButton[7][7];
		insertButtons = new JButton[12];
		cardLabels = new JLabel[Initialize.NUM_PLAYERS][Initialize.cardsPerPlayer]; // player ID, player's cards
		playerIndicationLabel = new JLabel[Initialize.NUM_PLAYERS];
		rotateButtons = new JButton[2];
		freeTileLabel = new JLabel();
		frame = new JFrame();
		screen = new JPanel();
		// Set up Menu Bar
		menuBar();
		// Set up the frame
		frameSetup();
		// Set up panel/labels/buttons
		panelDesign();
		// Update the panel
		panelUpdate();

	}

	// loads saved data(block values and positions) from a text file

	// sets up the JFrame
	private void frameSetup() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // program will end when exited
		frame.setSize(750, 500); // sets the size of the frame
		frame.setTitle("Amazing Labyrinth"); // The window name
		frame.setBounds(0, 0, 750, 500);
		frame.setLayout(null);
		frame.setResizable(false); // can't resize
		frame.add(screen); // add panel to the frame
		frame.validate();
		frame.repaint();
		frame.setVisible(true); // Visible
	}

	// creates menubar
	private void menuBar() {
		mb = new JMenuBar();
		menu = new JMenu("Menu");

		// menu items
		music = new JMenuItem("Toggle Music");
		save = new JMenuItem("Save and Exit");
		exit = new JMenuItem("Exit");

		// add to action listener for the menu items
		music.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);

		frame.setJMenuBar(mb); // add menu bar
		mb.add(menu); // add menu to menubar
		menu.add(music); // add items
		menu.add(save);
		menu.add(exit);

	}

	// sets up the panel
	private void panelDesign() {

		// Set up the panel
		screen.setBorder(null);
		screen.setBackground(new java.awt.Color(47, 47, 47));
		screen.setBounds(0, 0, 750, 500);
		screen.setLayout(null);

		// The array storing the tiles the current player can reach
		boolean reachableTiles[] = BoardGraph.possiblePaths(
				Board.board[Initialize.players[currentPlayer].getRow()][Initialize.players[currentPlayer].getColumn()]);

		// gives each block their label, and image
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				tileButtons[i][j] = new JButton();
				tileButtons[i][j].addActionListener(this);
				tileButtons[i][j].setBounds(30 + 55 * j, 30 + 55 * i, 50, 50); // location moves so labels don't overlap
				// the imagesArr index corresponds with the value on the board
				tileButtons[i][j]
						.setIcon(TileImages.tileImages[Board.board[i][j]][Initialize.allTiles[Board.board[i][j]]
								.getOrientation()]);

				// creates a border around the buttons.
				// if the tile is not reachable from the player's position, its border is the
				// same colour as the background to hide its existence.
				// if the tile is reachable, the tile is highlighted blue.
				// Colour: 0-red, 1-yellow, 2-green, 3-blue
				if (reachableTiles[Board.board[i][j]]) {
					int colourID = Initialize.players[currentPlayer].getColourID();
					if (colourID == 0)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(232, 17, 35), 3));
					else if (colourID == 1)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 185, 0), 3));
					else if (colourID == 2)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(16, 124, 16), 3));
					else if (colourID == 3)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 120, 215), 3));
				}

				else
					tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(47, 47, 47), 3));

				screen.add(tileButtons[i][j]);
			}

		}

		// Create a box with color to indicate which player cards they are
		// Create an indication where the token is at
		for (int i = 0; i < Initialize.NUM_PLAYERS; i++) {

			playerIndicationLabel[i] = new JLabel();

			// Set up the bounds
			playerIndicationLabel[i].setBounds(430, 230 + 100 * i, 305, 80);

			// Set the colour of the label border
			// Colour: 0-red, 1-yellow, 2-green, 3-blue
			int colourID = Initialize.players[i].getColourID();
			if (colourID == 0)
				playerIndicationLabel[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(232, 17, 35), 3));
			else if (colourID == 1)
				playerIndicationLabel[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 185, 0), 3));
			else if (colourID == 2)
				playerIndicationLabel[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(16, 124, 16), 3));
			else if (colourID == 3)
				playerIndicationLabel[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 120, 215), 3));

			// The location of the token
			int r = Initialize.players[i].getRow();
			int c = Initialize.players[i].getColumn();

			// Set the colour of the button border
			// Colour: 0-red, 1-yellow, 2-green, 3-blue
			if (colourID == 0)
				tileButtons[r][c].setBorder(BorderFactory.createLineBorder(new java.awt.Color(209, 52, 56), 7));
			else if (colourID == 1)
				tileButtons[r][c].setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 140, 0), 7));
			else if (colourID == 2)
				tileButtons[r][c].setBorder(BorderFactory.createLineBorder(new java.awt.Color(73, 130, 5), 7));
			else if (colourID == 3)
				tileButtons[r][c].setBorder(BorderFactory.createLineBorder(new java.awt.Color(45, 125, 154), 7));

			playerIndicationLabel[i].setOpaque(false);
			playerIndicationLabel[i].setVisible(true);
			screen.add(playerIndicationLabel[i]);

		}

		// Create the labels for the cards with the images
		for (int i = 0; i < Initialize.NUM_PLAYERS; i++) { // 2 Players
			for (int j = 0; j < Initialize.players[i].getDeck().size(); j++) { // The number of cards

				// Create labels
				cardLabels[i][j] = new JLabel();
				cardLabels[i][j].setBounds(435 + 50 * j, 235 + i * 100, 45, 70);
				cardLabels[i][j].setIcon(CardImages.cardImages[Initialize.players[i].getDeck().get(j)]);
				cardLabels[i][j].setVisible(true);
				screen.add(cardLabels[i][j]);

			}
		}

		// Free Tile Label
		freeTileLabel.setBounds(560, 100, 50, 50);
		freeTileLabel.setIcon(TileImages.tileImages[Board.freeTile][Board.tileFreeTile.getOrientation()]);
		freeTileLabel.setVisible(true);
		screen.add(freeTileLabel);

		// Rotate Buttons
		for (int i = 0; i < 2; i++) {
			rotateButtons[i] = new JButton();
			rotateButtons[i].addActionListener(this);
			rotateButtons[i].setBounds(520 + i * 100, 110, 30, 30);
			rotateButtons[i].setIcon(ExtraBoardImages.rotationImages[i]);
			rotateButtons[i].setVisible(true);
			rotateButtons[i].setContentAreaFilled(false);
			rotateButtons[i].setBorderPainted(false);
			screen.add(rotateButtons[i]);
		}

		// Push Tile Buttons
		int index = 0;
		for (int i = 0; i < 3; i++) {
			insertButtons[index] = new JButton();
			insertButtons[index].addActionListener(this);
			insertButtons[index].setBounds(100 + 110 * i, 10, 24, 16);
			insertButtons[index].setIcon(ExtraBoardImages.arrows[0]);
			insertButtons[index].setVisible(true);
			insertButtons[index].setContentAreaFilled(false);
			insertButtons[index].setBorderPainted(false);
			screen.add(insertButtons[index++]);
		}

		for (int i = 0; i < 3; i++) {
			insertButtons[index] = new JButton();
			insertButtons[index].addActionListener(this);
			insertButtons[index].setBounds(410, 100 + 110 * i, 16, 24);
			insertButtons[index].setIcon(ExtraBoardImages.arrows[1]);
			insertButtons[index].setVisible(true);
			insertButtons[index].setContentAreaFilled(false);
			insertButtons[index].setBorderPainted(false);
			screen.add(insertButtons[index++]);
		}

		for (int i = 0; i < 3; i++) {
			insertButtons[index] = new JButton();
			insertButtons[index].addActionListener(this);
			insertButtons[index].setBounds(100 + 110 * i, 415, 24, 16);
			insertButtons[index].setIcon(ExtraBoardImages.arrows[2]);
			insertButtons[index].setVisible(true);
			insertButtons[index].setContentAreaFilled(false);
			insertButtons[index].setBorderPainted(false);
			screen.add(insertButtons[index++]);
		}

		for (int i = 0; i < 3; i++) {
			insertButtons[index] = new JButton();
			insertButtons[index].addActionListener(this);
			insertButtons[index].setBounds(5, 100 + 110 * i, 16, 24);
			insertButtons[index].setIcon(ExtraBoardImages.arrows[3]);
			insertButtons[index].setVisible(true);
			insertButtons[index].setContentAreaFilled(false);
			insertButtons[index].setBorderPainted(false);
			screen.add(insertButtons[index++]);
		}

		frame.repaint();

	}

	// updates the board again
	private void panelUpdate() {

		// Refresh the board
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				// Setup the tile buttons images
				tileButtons[i][j]
						.setIcon(TileImages.tileImages[Board.board[i][j]][Initialize.allTiles[Board.board[i][j]]
								.getOrientation()]);

				// The tiles the current player can reach
				boolean reachableTiles[] = BoardGraph.possiblePaths(
						Board.board[Initialize.players[currentPlayer].getRow()][Initialize.players[currentPlayer]
								.getColumn()]);

				// Indicate the tiles the player can reach
				if (reachableTiles[Board.board[i][j]]) {
					int colourID = Initialize.players[currentPlayer].getColourID();
					if (colourID == 0)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(232, 17, 35), 3));
					else if (colourID == 1)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 185, 0), 3));
					else if (colourID == 2)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(16, 124, 16), 3));
					else if (colourID == 3)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 120, 215), 3));
				}

				else // If the player can't reach
					tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(47, 47, 47), 3));

				// Refresh the position of the token
				for (int k = 0; k < Initialize.NUM_PLAYERS; k++) {
					int colourID = Initialize.players[k].getColourID();
					int r = Initialize.players[k].getRow();
					int c = Initialize.players[k].getColumn();
					if (colourID == 0)
						tileButtons[r][c].setBorder(BorderFactory.createLineBorder(new java.awt.Color(209, 52, 56), 7));
					else if (colourID == 1)
						tileButtons[r][c].setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 140, 0), 7));
					else if (colourID == 2)
						tileButtons[r][c].setBorder(BorderFactory.createLineBorder(new java.awt.Color(73, 130, 5), 7));
					else if (colourID == 3)
						tileButtons[r][c]
								.setBorder(BorderFactory.createLineBorder(new java.awt.Color(45, 125, 154), 7));
				}
				screen.add(tileButtons[i][j]);
			}
		}

		// Refresh the insert buttons
		for (int i = 0; i < 12; i++)
			insertButtons[i].setVisible(true);
		if (disabledInsertButton != -1) // disable the button that is the opposite of last used button
			insertButtons[disabledInsertButton].setVisible(false);

		frame.repaint();
	}

	// update the card labels
	private void updateCardLabels() {

		// Recreate the card labels
		for (int i = 0; i < Initialize.players[currentPlayer].getDeck().size(); i++)
			cardLabels[currentPlayer][i]
					.setIcon(CardImages.cardImages[Initialize.players[currentPlayer].getDeck().get(i)]);

		for (int i = Initialize.players[currentPlayer].getDeck().size(); i < Initialize.cardsPerPlayer; i++)
			cardLabels[currentPlayer][i].setVisible(false);

	}

	// The insert button function
	public void insertTileToBoard(int row, int column) {

		// The row of the tile that becomes the new free tile
		int removeRow = 0;
		// The column of the tile that becomes the new free tile
		int removeColumn = 0;

		// Determine which tile becomes the free tile
		if (row == 0) {
			removeRow = 6;
			removeColumn = column;
		} else if (row == 6) {
			removeRow = 0;
			removeColumn = column;
		} else if (column == 0) {
			removeColumn = 6;
			removeRow = row;
		} else if (column == 6) {
			removeColumn = 0;
			removeRow = row;
		}

		// The tile that will become the free tile
		Tile newFreeTile = Initialize.allTiles[Board.board[removeRow][removeColumn]];

		// Move all tiles that need to be moved
		if (row == 0) {
			for (int x = 5; x >= 0; x--)
				Board.board[x + 1][column] = Board.board[x][column];

		} else if (row == 6) {
			for (int x = 1; x <= 6; x++)
				Board.board[x - 1][column] = Board.board[x][column];

		} else if (column == 0) {
			for (int y = 5; y >= 0; y--)
				Board.board[row][y + 1] = Board.board[row][y];

		} else if (column == 6)
			for (int y = 1; y <= 6; y++) {
				Board.board[row][y - 1] = Board.board[row][y];
			}

		// Move the player if necessary

		for (int i = 0; i < Initialize.NUM_PLAYERS; i++) {

			if (Initialize.players[i].getColumn() == column) {
				if (row == 0) {
					if (Initialize.players[i].getRow() != 6) {
						Initialize.players[i].setRow(Initialize.players[i].getRow() + 1);
					} else {
						Initialize.players[i].setRow(0);
					}
				} else if (row == 6) {
					if (Initialize.players[i].getRow() != 0) {
						Initialize.players[i].setRow(Initialize.players[i].getRow() - 1);
					} else {
						Initialize.players[i].setRow(6);
					}
				}
			}

			if (Initialize.players[i].getRow() == row) {

				if (column == 0) {
					if (Initialize.players[i].getColumn() != 6) {
						Initialize.players[i].setColumn(Initialize.players[i].getColumn() + 1);
					} else {
						Initialize.players[i].setColumn(0);
					}
				} else if (column == 6) {
					if (Initialize.players[i].getColumn() != 0) {
						Initialize.players[i].setColumn(Initialize.players[i].getColumn() - 1);
					} else {
						Initialize.players[i].setColumn(6);
					}
				}

			}
		}

		// Add the inserted piece
		Board.board[row][column] = Board.getFreeTile();

		// Set new free tile
		Board.setFreeTile(newFreeTile.getID());

		// Regenerate tile version board array
		Board.createTileBoard();

		// Set the icon of the free tile
		freeTileLabel.setIcon(TileImages.tileImages[Board.freeTile][Board.tileFreeTile.getOrientation()]);
		// Regenerate the board graoh
		BoardGraph.createBoardGraph();

		// Update the panel
		panelUpdate();

	}

	// checks if the game has been won after a move
	private static void checkWin() {
		if (Initialize.players[currentPlayer].getDeck().isEmpty()) {
			frame.setVisible(false);
			MusicPlayer.stopMusic();
			new WinScreenGUI(Initialize.players[currentPlayer].getColourID());
		}

	}

	// saves the game onto a text file
	private static void save() {
		try {
			BufferedWriter pr = new BufferedWriter(new FileWriter(new File("Files/Save.txt")));

			// saves board
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					pr.write(String.format("%d\n", Board.board[i][j]));
				}
			}
			// save free tile
			pr.write(String.format("%d\n", Board.freeTile));

			// save tile orientation
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					pr.write(String.format("%d\n", Board.tileBoard[i][j].getOrientation()));
				}
			}

			// saves player colours
			for (int i = 0; i < Initialize.NUM_PLAYERS; i++) {
				pr.write(String.format("%d\n", Initialize.players[i].getColourID()));
			}

			// saves number of cards per player
			pr.write(String.format("%d\n", Initialize.cardsPerPlayer));

			// saves the player's cards
			for (int i = 0; i < Initialize.NUM_PLAYERS; i++) {
				for (int j = 0; j < Initialize.players[i].getDeck().size(); j++)
					pr.write(String.format("%d\n", Initialize.players[i].getDeck().get(j)));

				for (int j = Initialize.players[i].getDeck().size(); j < Initialize.cardsPerPlayer; j++)
					pr.write(String.format("%d\n", -1));
			}

			// saves the player's positions
			for (int i = 0; i < Initialize.NUM_PLAYERS; i++) {
				// saves row
				pr.write(String.format("%d\n", Initialize.players[i].getRow()));

				// saves column
				pr.write(String.format("%d\n", Initialize.players[i].getColumn()));
			}

			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// carries out the actions for each of the menu bar buttons
	public void actionPerformed(ActionEvent event) {
		// saves the game
		if (event.getSource() == save) {
			save();
			System.exit(0);
		}
		// exits the game (doesn't auto save... to small of a game for people to really
		// want that)
		if (event.getSource() == exit) {
			System.exit(0);
		}

		// toggle the music
		if (event.getSource() == music) {
			if (playingMusic)
				MusicPlayer.pauseMusic();
			else
				MusicPlayer.unpauseMusic();
			playingMusic = !playingMusic;
		}

		// The rotation buttons
		for (int i = 0; i < 2; i++) {
			if (event.getSource() == rotateButtons[i]) {
				int k = i == 0 ? 1 : -1;
				Board.tileFreeTile.setOrientation((((Board.tileFreeTile.getOrientation() + k) % 4) + 4) % 4);
				freeTileLabel.setIcon(TileImages.tileImages[Board.freeTile][Board.tileFreeTile.getOrientation()]);
			}
		}

		// move a player
		if (hasInsertTile) {
			loop: for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if (event.getSource() == tileButtons[i][j]) {
						if (BoardGraph
								.canMove(
										Board.board[Initialize.players[currentPlayer]
												.getRow()][Initialize.players[currentPlayer].getColumn()],
										Board.board[i][j])) {
							Initialize.players[currentPlayer].setRow(i);
							Initialize.players[currentPlayer].setColumn(j);

							
							//check if the player moved onto a treasure they seek
							boolean flag = false;

							if (Board.board[i][j] < 24) {
								for (int k = 0; k < Initialize.players[currentPlayer].getDeck().size(); k++) {
									if (Board.board[i][j] == Initialize.players[currentPlayer].getDeck().get(k)) {
										Initialize.players[currentPlayer].getDeck().remove(k);
										updateCardLabels();
										flag = true;
									}
								}
							}
							checkWin();
							
							
							if (flag)
								AudioPlayer.playAudio("Audio/SE/Voltorb Flip Point.wav");
							else
								AudioPlayer.playAudio("Audio/SE/Voltorb Flip Mark.wav");

							currentPlayer = currentPlayer == 0 ? 1 : 0;
							hasInsertTile=!hasInsertTile;

						}
						break loop;

					}
				}
			}
		}

		// If the player has not inserted the tile
		if (!hasInsertTile) {
			// For the insert buttons on the top
			for (int i = 0; i < 3; i++) {
				if (event.getSource() == insertButtons[i] && i != disabledInsertButton) {
					// Run the function
					insertTileToBoard(0, 1 + 2 * i);
					// The opposite button is disabled
					disabledInsertButton = i + 6;
					panelUpdate();
					AudioPlayer.playAudio("Audio/SE/Switch Clack.wav");
					hasInsertTile = !hasInsertTile;
				}
			}

			// For the insert buttons on the right
			for (int i = 3; i < 6; i++) {
				if (event.getSource() == insertButtons[i] && i != disabledInsertButton) {
					// Run the function
					insertTileToBoard(1 + 2 * (i - 3), 6);
					// The opposite button is disabled
					disabledInsertButton = i + 6;
					panelUpdate();
					AudioPlayer.playAudio("Audio/SE/Switch Clack.wav");
					hasInsertTile = !hasInsertTile;
				}
			}

			// For the insert buttons on the bottom
			for (int i = 6; i < 9; i++) {
				if (event.getSource() == insertButtons[i] && i != disabledInsertButton) {
					// Run the function
					insertTileToBoard(6, 1 + 2 * (i - 6));
					// The opposite button is disabled
					disabledInsertButton = i - 6;
					panelUpdate();
					AudioPlayer.playAudio("Audio/SE/Switch Clack.wav");
					hasInsertTile = !hasInsertTile;
				}
			}

			// For the insert buttons on the left
			for (int i = 9; i < 12; i++) {
				if (event.getSource() == insertButtons[i] && i != disabledInsertButton) {
					// Run the function
					insertTileToBoard(1 + 2 * (i - 9), 0);
					// The opposite button is disabled
					disabledInsertButton = i - 6;
					panelUpdate();
					AudioPlayer.playAudio("Audio/SE/Switch Clack.wav");
					hasInsertTile = !hasInsertTile;
				}
			}
		}


		// Regenerate the panel
		panelUpdate();
		frame.repaint();
		panelUpdate();

		// Check if the user has won
		checkWin();

	}

}