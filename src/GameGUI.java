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
	private static JFrame frame;
	private static JPanel screen;
	private  JButton[][] tileButtons; //the "blocks" of numbers
	
	
	//menubar stuff
	private static JMenuBar mb = new JMenuBar();
	private static JMenu menu = new JMenu();;
	private static JMenuItem save;
	private static JMenuItem exit;
	private static JMenuItem restart;
	
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
    	if(ifLoad) {
    		loadSaveState();
    	}
    	
    	
    	//panelUpdate();
    	
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
		frame.setSize(450,450); // sets the size of the frame
		frame.setTitle("Amazing Labyrinth");
		frame.setBounds(0,0,456,502);
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
		save = new JMenuItem("Save and Exit");
		exit = new JMenuItem("Exit");
		restart = new JMenuItem("Restart");

		// add to action listener for the menu items
		save.addActionListener(this);
		exit.addActionListener(this);
		restart.addActionListener(this);
		
		frame.setJMenuBar(mb); // add menu bar
		mb.add(menu); // add menu to menubar
		menu.add(restart); //add items
		menu.add(save); 
		menu.add(exit);
		
	}

	//sets up the panel
	private void panelDesign() {
		screen.setBorder(null);
		screen.setBackground(new java.awt.Color(47, 47, 47));
		screen.setBounds(0,0,456,502);
		screen.setLayout(null);
		
		//gives each block their label, and image
		for(int i =0;i<7;i++) {
			for(int j =0;j<7;j++){
				tileButtons[i][j]=new JButton();
				tileButtons[i][j].addActionListener(this);
				tileButtons[i][j].setBounds(10 + 60 * j, 10+60*i, 50, 50);  //location moves so labels don't overlap
				//the imagesArr index corresponds with the value on the board
				tileButtons[i][j].setIcon(TileImages.tileImages[Board.board[i][j]][Initialize.allTiles[Board.board[i][j]].getOrientation()]);
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
				screen.add(tileButtons[i][j]);
			}
		}
		frame.repaint();
	}

	
	//checks if the game has been won
	private static boolean checkWin() {
		
		return false;
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
		
		for(int i =0;i<7;i++) {
			for(int j =0;j<7;j++) {
				if(event.getSource()==tileButtons[i][j]) {
					if(BoardGraph.canMove(
							Board.board[Initialize.players[currentPlayer].getRow()]
									[Initialize.players[currentPlayer].getColumn()],
							Board.board[i][j])) {
						Initialize.players[currentPlayer].setRow(i);
						Initialize.players[currentPlayer].setRow(j);
						
					}
					break; //this wont break out of all the loops. gonna consider a method and use return
				}
			}
		}
			
		
		panelUpdate();
		frame.repaint();
		panelUpdate();
		if(checkWin()) { //check if the game is over after a successful move, and a new block has spawned
			frame.setVisible(false);
			new 
			
			EndScreen();
		}
		
		
	}

	public void keyPressed(KeyEvent key) {
	}

	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	
	
	public static void main(String[] args) throws IOException {
		//Method that create and show a GUI should be
		//run from an event-dispatchinb thread
		
		int[] arr= {1,2};
		new Initialize(1, arr);
		
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(" "+Board.board[i][j]+" ");
			}
			System.out.println();
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					runGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void runGUI() throws IOException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		GameGUI greeting=new GameGUI(false);
	}
	
}

	
	
