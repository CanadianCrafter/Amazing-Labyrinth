//imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import audio.MusicPlayer;

public class GameGUI extends JFrame implements KeyListener, ActionListener{
	
	//Buffered Reader
	static StringTokenizer st;
	
	//gui stuff
	static JFrame frame;
	private static JPanel screen;
	private  JButton[][] tileButtons; //the "blocks" of numbers
	
	
	//menubar stuff
	private static JMenuBar mb = new JMenuBar();
	private static JMenu menu = new JMenu();;
	private static JMenuItem save;
	private static JMenuItem exit;
	private static JMenuItem restart;
	private static JMenuItem music;
	private static boolean playingMusic = true;
	private static long time;
	
	//Player
	public static int currentPlayer=0;
	
	
	// constructor method
	public GameGUI(Boolean ifLoad) throws IOException {
    	//setup
		tileButtons = new JButton[7][7];
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
		frame.addKeyListener(this);
		
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
		frame.repaint();
	}

	
	//checks if the game has been won after a move
	private static void checkWin() {
		if(Initialize.players[currentPlayer].getDeck().isEmpty()) {
			frame.setVisible(false);
			new WinScreenGUI(currentPlayer);
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
						currentPlayer = currentPlayer==0 ? 1:0;
					}
					break loop; 
					
				}
			}
		}
			
		
		panelUpdate();
		frame.repaint();
		panelUpdate();
		checkWin();
		
		
		
	}

	public void keyPressed(KeyEvent key) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
}