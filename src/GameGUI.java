//imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import audio.AudioPlayer;
import audio.MusicPlayer;

public class GameGUI extends JFrame implements ActionListener{
	
	//Buffered Reader
	static StringTokenizer st;
	
	//gui stuff
	static JFrame frame;
	private static JPanel screen;
	private JLabel freeTileLabel;
	private  JButton[][] tileButtons; //the "blocks" of numbers
	private JButton[] insertButtons;
	private JButton[] rotateButtons;
	private JLabel[] playerLabel;
	private JLabel[][] cardLabels; 
	private JLabel[] playerIndicationLabel;
	
	//menubar stuff
	private static JMenuBar mb = new JMenuBar();
	private static JMenu menu = new JMenu();
	private static JMenuItem save;
	private static JMenuItem exit;
	private static JMenuItem restart;
	private static JMenuItem music;
	private static boolean playingMusic = true;
	
	
	
	//Player
	public static int currentPlayer=0;
	private int disabledInsertButton=-1;
	
	
	// constructor method
	public GameGUI(Boolean ifLoad) throws IOException {
    	//setup
		tileButtons = new JButton[7][7];
		insertButtons=new JButton[12];
		playerLabel=new JLabel[Initialize.NUM_PLAYERS];
		cardLabels= new JLabel [Initialize.NUM_PLAYERS][Initialize.cardsPerPlayer]; //player ID, player's cards
		playerIndicationLabel=new JLabel[Initialize.NUM_PLAYERS];
		rotateButtons=new JButton[2];
		freeTileLabel=new JLabel();

    	frame = new JFrame(); 
    	screen = new JPanel();
    	menuBar();
    	frameSetup();
    	panelDesign();
    	if(ifLoad) loadSaveState();
    	panelUpdate();
    	
    }
    
	
    //loads saved data(block values and positions) from a text file
	private void loadSaveState() throws IOException {
		
		try {
			BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/Save.txt")));
			
			int tempBoard[][] = new int[7][7];
			
			for(int i =0;i<7;i++) {
				for(int j=0;j<7;j++) {
					while (st == null || !st.hasMoreTokens())
			            st = new StringTokenizer(br.readLine().trim());
					tempBoard[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Board.setBoard(tempBoard);
			
			while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine().trim());
			
			Board.setFreeTile(Integer.parseInt(st.nextToken()));
			
			br.close();
			
		}
		
		// print the error if there is one
		catch (FileNotFoundException error) {
			System.out.println(error);
		}
		
		//after the data is extracted, the save is wiped so that, you cannot return to a used save.
		//saving merely pauses time; not reverse it
		try {
			new PrintWriter("Save.txt").close();
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	//sets up the JFrame
	private void frameSetup() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //program will end when exited
		frame.setSize(750,500); // sets the size of the frame
		frame.setTitle("Amazing Labyrinth");
		frame.setBounds(0,0,750,500);
		frame.setLayout(null);
		frame.setResizable(false); // can't resize
		frame.add(screen); // add panel to the frame
		frame.validate();
		frame.repaint();
		frame.setVisible(true); 
	}
	
	//creates menubar
	private void menuBar() {
		mb = new JMenuBar();
		menu = new JMenu("Menu");
		
		//menu items
		music = new JMenuItem("Toggle Music");
		save = new JMenuItem("Save and Exit");
		exit = new JMenuItem("Exit");
		restart = new JMenuItem("Restart");
		
		// add to action listener for the menu items
		music.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		restart.addActionListener(this);
		
		frame.setJMenuBar(mb); // add menu bar
		mb.add(menu); // add menu to menubar
		menu.add(music); //add items
		menu.add(restart);
		menu.add(save); 
		menu.add(exit);
		
	}

	//sets up the panel
	private void panelDesign() {
		
		screen.setBorder(null);
		screen.setBackground(new java.awt.Color(47, 47, 47));
		screen.setBounds(0,0,750,500);
		screen.setLayout(null);
		
		boolean reachableTiles[] = BoardGraph.possiblePaths(Board.board[Initialize.players[currentPlayer].getRow()]
				[Initialize.players[currentPlayer].getColumn()]);
		
		//gives each block their label, and image
		for(int i =0;i<7;i++) {
			for(int j =0;j<7;j++){
				tileButtons[i][j]=new JButton();
				tileButtons[i][j].addActionListener(this);
				tileButtons[i][j].setBounds(30 + 55 * j, 30+55*i, 50, 50);  //location moves so labels don't overlap
				//the imagesArr index corresponds with the value on the board
				tileButtons[i][j].setIcon(TileImages.tileImages[Board.board[i][j]][Initialize.allTiles[Board.board[i][j]].getOrientation()]); 
				
				//creates a border around the buttons. 
				//if the tile is not reachable from the player's position, its border is the same colour as the background to hide its existence.
				//if the tile is reachable, the tile is highlighted blue.
				//Colour: 0-red, 1-yellow, 2-green, 3-blue
				if(reachableTiles[Board.board[i][j]]) {
					int colourID=Initialize.players[currentPlayer].getColourID();
					if(colourID==0)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(232, 17, 35), 3));
					else if(colourID==1)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 185, 0), 3));
					else if(colourID==2)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(16, 124, 16), 3));
					else if(colourID==3)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(0,120,215), 3));
				}
					
				else
					tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(47, 47, 47), 3)); 
				
				screen.add(tileButtons[i][j]);
				}
		
		}

		//player Piece
		for(int i=0; i<Initialize.NUM_PLAYERS; i++) {
			
			playerLabel[i]=new JLabel();
			
			playerLabel[i].setBounds(40+55*Initialize.players[i].getColumn(), 40+55*Initialize.players[i].getRow(), 30, 30);
			
			if(Initialize.players[i].getColourID()==0)
				playerLabel[i].setBackground(new java.awt.Color(232, 17, 35));
				
			else if(Initialize.players[i].getColourID()==1)
				playerLabel[i].setBackground(new java.awt.Color(255, 185, 0));
				
			else if(Initialize.players[i].getColourID()==2)
				playerLabel[i].setBackground(new java.awt.Color(16, 124, 16));
				
			else if(Initialize.players[i].getColourID()==3)
				playerLabel[i].setBackground(new java.awt.Color(0 ,120 ,215));
			
			playerLabel[i].setOpaque(true);
			playerLabel[i].setVisible(true);
			screen.add(playerLabel[i]);
			
		}
		
		for(int i=0; i<Initialize.NUM_PLAYERS; i++) {
			
			playerIndicationLabel[i]=new JLabel();
			
			playerIndicationLabel[i].setBounds(430, 230+100*i, 305, 80);
			
			int colourID=Initialize.players[i].getColourID();
			if(colourID==0)
				playerIndicationLabel[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(232, 17, 35), 3));
			else if(colourID==1)
				playerIndicationLabel[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 185, 0), 3));
			else if(colourID==2)
				playerIndicationLabel[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(16, 124, 16), 3));
			else if(colourID==3)
				playerIndicationLabel[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(0,120,215), 3));

			
			playerIndicationLabel[i].setOpaque(false);
			playerIndicationLabel[i].setVisible(true);
			screen.add(playerIndicationLabel[i]);
			
		}
		
		//add Cards
		for(int i =0;i<Initialize.NUM_PLAYERS;i++) {
			for(int j=0; j<Initialize.players[i].getDeck().size(); j++) {
				
				cardLabels[i][j]=new JLabel();
				cardLabels[i][j].setBounds(435+50*j, 235+i*100, 45, 70);
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
		
		
		//Rotate Buttons
		for(int i =0;i<2;i++) {
			rotateButtons[i]=new JButton();
			rotateButtons[i].addActionListener(this);
			rotateButtons[i].setBounds(520+i*100, 110, 30, 30);
			rotateButtons[i].setIcon(ExtraBoardImages.rotationImages[i]);
			rotateButtons[i].setVisible(true);
			rotateButtons[i].setContentAreaFilled(false);
			rotateButtons[i].setBorderPainted(false);
			screen.add(rotateButtons[i]);
		}
		
		
		//Push Tile Buttons
		int index=0;
		for(int i=0; i<3; i++) {
			insertButtons[index]=new JButton();
			insertButtons[index].addActionListener(this);
			insertButtons[index].setBounds(100+110*i, 10, 24, 16);
			insertButtons[index].setIcon(ExtraBoardImages.arrows[0]);
			insertButtons[index].setVisible(true);
			insertButtons[index].setContentAreaFilled(false);
			insertButtons[index].setBorderPainted(false);
			screen.add(insertButtons[index++]);
		}
			
		for(int i=0; i<3; i++) {
			insertButtons[index]=new JButton();
			insertButtons[index].addActionListener(this);
			insertButtons[index].setBounds(410, 100+110*i, 16, 24);
			insertButtons[index].setIcon(ExtraBoardImages.arrows[1]);
			insertButtons[index].setVisible(true);				
			insertButtons[index].setContentAreaFilled(false);
			insertButtons[index].setBorderPainted(false);
			screen.add(insertButtons[index++]);
		}
		
		for(int i=0; i<3; i++) {
			insertButtons[index]=new JButton();
			insertButtons[index].addActionListener(this);
			insertButtons[index].setBounds(100+110*i, 415, 24, 16);
			insertButtons[index].setIcon(ExtraBoardImages.arrows[2]);
			insertButtons[index].setVisible(true);
			insertButtons[index].setContentAreaFilled(false);
			insertButtons[index].setBorderPainted(false);
			screen.add(insertButtons[index++]);
		}
			
		for(int i=0; i<3; i++) {
			insertButtons[index]=new JButton();
			insertButtons[index].addActionListener(this);
			insertButtons[index].setBounds(5, 100+110*i, 16, 24);
			insertButtons[index].setIcon(ExtraBoardImages.arrows[3]);
			insertButtons[index].setVisible(true);
			insertButtons[index].setContentAreaFilled(false);
			insertButtons[index].setBorderPainted(false);
			screen.add(insertButtons[index++]);
		}
			
		frame.repaint();
		
	}
	
	//updates the board again
	private void panelUpdate() {
		
		for(int i =0;i<7;i++) {
			for(int j =0;j<7;j++){
				tileButtons[i][j].setIcon(TileImages.tileImages[Board.board[i][j]][Initialize.allTiles[Board.board[i][j]].getOrientation()]); 
				
				boolean reachableTiles[] = BoardGraph.possiblePaths(Board.board[Initialize.players[currentPlayer].getRow()]
						[Initialize.players[currentPlayer].getColumn()]);
				
				if(reachableTiles[Board.board[i][j]]) {
					int colourID=Initialize.players[currentPlayer].getColourID();
					if(colourID==0)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(232, 17, 35), 3));
					else if(colourID==1)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 185, 0), 3));
					else if(colourID==2)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(16, 124, 16), 3));
					else if(colourID==3)
						tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(0,120,215), 3));
				}
					
				else
					tileButtons[i][j].setBorder(BorderFactory.createLineBorder(new java.awt.Color(47, 47, 47), 3)); 
				
				screen.add(tileButtons[i][j]);
			}
		}
		
		for(int i=0; i<Initialize.NUM_PLAYERS; i++)
			playerLabel[i].setBounds(40+55*Initialize.players[i].getColumn(), 40+55*Initialize.players[i].getRow(), 30, 30);
		
		for(int i =0;i<12;i++)
			insertButtons[i].setVisible(true);
		if(disabledInsertButton!=-1)
			insertButtons[disabledInsertButton].setVisible(false);
		
		frame.repaint();
	}
	
	private void updateCardLabels() {
		for(int i=0; i<Initialize.players[currentPlayer].getDeck().size(); i++)
			cardLabels[currentPlayer][i].setIcon(CardImages.cardImages[Initialize.players[currentPlayer].getDeck().get(i)]);
		
		for(int i =Initialize.players[currentPlayer].getDeck().size();i<Initialize.cardsPerPlayer;i++)
			cardLabels[currentPlayer][i].setVisible(false);
		
	}
	
	public void insertTileToBoard(int row, int column) {
		
		// Tile Board Array AND Tile Free Tile is not updated in this method.
		
		int removeRow=0;
		int removeColumn=0;
		
//		notification.setText("Player "+currentPlayer+" moves!");
//		notification.setBounds(530, 200, 150, 20);
		
		if(row==0) {
			removeRow=6;
			removeColumn=column;
		}else if(row==6) {
			removeRow=0;
			removeColumn=column;
		}else if(column==0) {
			removeColumn=6;
			removeRow=row;
		}else if(column==6) {
			removeColumn=0;
			removeRow=row;
		}
				
		Tile newFreeTile=Initialize.allTiles[Board.board[removeRow][removeColumn]];
		
		if(row==0) {
			for(int x=5; x>=0; x--)
				Board.board[x+1][column]=Board.board[x][column];
			
		}else if(row==6) {
			for(int x=1; x<=6; x++)
				Board.board[x-1][column]=Board.board[x][column];
			
		}else if(column==0) {
			for(int y=5; y>=0; y--) 
				Board.board[row][y+1]=Board.board[row][y];
			
		}else if(column==6)
			for(int y=1; y<=6; y++) {
				Board.board[row][y-1]=Board.board[row][y];
		}
		
		
		for(int i=0; i<2; i++) {

			if(Initialize.players[i].getColumn()==column) {
				if(row==0) {
					if(Initialize.players[i].getRow()!=6) {
						Initialize.players[i].setRow(Initialize.players[i].getRow()+1);
					}else {
						Initialize.players[i].setRow(0);
					}
				}	else if(row==6) {
					if(Initialize.players[i].getRow()!=0) {
						Initialize.players[i].setRow(Initialize.players[i].getRow()-1);
					}else {
						Initialize.players[i].setRow(6);
					}
				}
			}
			
			if(Initialize.players[i].getRow()==row) {
				
				
				
				if(column==0) {
					if(Initialize.players[i].getColumn()!=6) {
						Initialize.players[i].setColumn(Initialize.players[i].getColumn()+1);
					}else {
						Initialize.players[i].setColumn(0);
					}
				}	else if(column==6) {
					if(Initialize.players[i].getColumn()!=0) {
						Initialize.players[i].setColumn(Initialize.players[i].getColumn()-1);
					}else {
						Initialize.players[i].setColumn(6);
					}
				}
			
			}
		}
		
		
		
		Board.board[row][column]=Board.getFreeTile();
		Board.setFreeTile(newFreeTile.getID());
		Board.createTileBoard();
		freeTileLabel.setIcon(TileImages.tileImages[Board.freeTile][Board.tileFreeTile.getOrientation()]);
		BoardGraph.createBoardGraph();
		panelUpdate();
		
	}

	
	//checks if the game has been won after a move
	private static void checkWin() {
		if(Initialize.players[currentPlayer].getDeck().isEmpty()) {
			frame.setVisible(false);
			MusicPlayer.stopMusic();
			new WinScreenGUI(Initialize.players[currentPlayer].getColourID());
		}
			
	}
	
	//saves the game onto a text file
	private static void save() {
		try {
			BufferedWriter pr = new BufferedWriter(new FileWriter(new File("Files/Save.txt")));
			//adds the values of the board delimited by commas, onto the save file
			for(int i =0;i<7;i++) {
				for(int j=0;j<7;j++) {
					pr.write(String.format("%d\n",Board.board[i][j]));
				}
			}
			pr.write(Board.freeTile);
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	//carries out the actions for each of the menu bar buttons
	public void actionPerformed(ActionEvent event) {
		//saves the game
		if(event.getSource() == save) {
			save();
			System.exit(0);
		}
		//exits the game (doesn't auto save... to small of a game for people to really want that)
		if(event.getSource()==exit) {
			System.exit(0);
		}
		//restart the game
		if(event.getSource()==restart) {
			frame.dispose();
			try {
				new GameGUI(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//toggle the music
		if(event.getSource()==music) {
			if(playingMusic) 
				MusicPlayer.pauseMusic();
			else
				MusicPlayer.unpauseMusic();
			playingMusic = !playingMusic;
		}
		
		for(int i = 0; i < 2; i++) {
			if(event.getSource()==rotateButtons[i]) {
				int k = i==0?1:-1;
				Board.tileFreeTile.setOrientation((((Board.tileFreeTile.getOrientation()+k)%4)+4)%4);
				freeTileLabel.setIcon(TileImages.tileImages[Board.freeTile][Board.tileFreeTile.getOrientation()]);
			}
		}
		
		//move a player
		loop:
		for(int i =0;i<7;i++) {
			for(int j =0;j<7;j++) {
				if(event.getSource()==tileButtons[i][j]) {
					if(BoardGraph.canMove(
							Board.board[Initialize.players[currentPlayer].getRow()]
									[Initialize.players[currentPlayer].getColumn()],
							Board.board[i][j])) {
						Initialize.players[currentPlayer].setRow(i);
						Initialize.players[currentPlayer].setColumn(j);
						
						
						boolean flag = false;
						
						if(Board.board[i][j]<24) {
							for(int k=0; k<Initialize.players[currentPlayer].getDeck().size(); k++) {
								if(Board.board[i][j]==Initialize.players[currentPlayer].getDeck().get(k)) {
									Initialize.players[currentPlayer].getDeck().remove(k);
									updateCardLabels();
									flag=true;
								}
							}
						}
						if(flag)
							AudioPlayer.playAudio("Audio/SE/Voltorb Flip Point.wav");
						else
							AudioPlayer.playAudio("Audio/SE/Voltorb Flip Mark.wav");
						
						changeTurn();
						
						
					}
					break loop; 
					
				}
			}
		}
		
		for(int i=0; i<3; i++) {
			if(event.getSource()==insertButtons[i]&&i!=disabledInsertButton) {
				insertTileToBoard(0,1+2*i);
				disabledInsertButton=i+6;
				panelUpdate();
				changeTurn();
				AudioPlayer.playAudio("Audio/SE/Switch Clack.wav");
			}
		}
		
		for(int i=3; i<6; i++) {
			if(event.getSource()==insertButtons[i]&&i!=disabledInsertButton) {
				insertTileToBoard(1+2*(i-3), 6);
				disabledInsertButton=i+6;
				panelUpdate();
				changeTurn();
				AudioPlayer.playAudio("Audio/SE/Switch Clack.wav");
			}
		}
		
		for(int i=6; i<9; i++) {
			if(event.getSource()==insertButtons[i]&&i!=disabledInsertButton) {
				insertTileToBoard(6,1+2*(i-6));
				disabledInsertButton=i-6;
				panelUpdate();
				changeTurn();
				AudioPlayer.playAudio("Audio/SE/Switch Clack.wav");
			}
		}
		
		for(int i=9; i<12; i++) {
			if(event.getSource()==insertButtons[i]&&i!=disabledInsertButton) {
				insertTileToBoard(1+2*(i-9), 0);
				disabledInsertButton=i-6;
				panelUpdate();
				changeTurn();
				AudioPlayer.playAudio("Audio/SE/Switch Clack.wav");
			}
		}
		
			
		
		panelUpdate();
		frame.repaint();
		panelUpdate();
		checkWin();
		
		
		
	}
	



	public void changeTurn(){
		currentPlayer = currentPlayer==0 ? 1:0;
	}
}