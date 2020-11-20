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
	private  JButton[][] nums; //the "blocks" of numbers
	
	//stores the pictures
	private final static ImageIcon imageArr[][] = new ImageIcon[4][50];
	
	//menubar stuff
	private static JMenuBar mb = new JMenuBar();
	private static JMenu menu = new JMenu();;
	private static JMenuItem save;
	private static JMenuItem exit;
	private static JMenuItem restart;
	
	
	// constructor method
	public GameGUI(Boolean ifLoad) throws IOException {
    	//setup
		nums = new JButton[7][7];
    	frame = new JFrame(); 
    	screen = new JPanel();
    	loadImages();
    	menuBar();
    	frameSetup();
    	panelDesign();
    	if(ifLoad) loadSaveState();
    	panelUpdate();
    	
    }
    
	//puts the images stored in the "Images" folder into the imageArr, array
	private static void loadImages() {
//		imageArr[0] = new ImageIcon(new ImageIcon("Images/blank.png").getImage());
//		imageArr[1] = new ImageIcon(new ImageIcon("Images/2.png").getImage());
//		imageArr[2] = new ImageIcon(new ImageIcon("Images/4.png").getImage());
//		imageArr[3] = new ImageIcon(new ImageIcon("Images/8.png").getImage());
//		imageArr[4] = new ImageIcon(new ImageIcon("Images/16.png").getImage());
//		imageArr[5] = new ImageIcon(new ImageIcon("Images/32.png").getImage());
//		imageArr[6] = new ImageIcon(new ImageIcon("Images/64.png").getImage());
//		imageArr[7] = new ImageIcon(new ImageIcon("Images/128.png").getImage());
//		imageArr[8] = new ImageIcon(new ImageIcon("Images/256.png").getImage());
//		imageArr[9] = new ImageIcon(new ImageIcon("Images/512.png").getImage());
//		imageArr[10] = new ImageIcon(new ImageIcon("Images/1024.png").getImage());
//		imageArr[11] = new ImageIcon(new ImageIcon("Images/2048.png").getImage());
//		imageArr[12] = new ImageIcon(new ImageIcon("Images/4096.png").getImage());
		
		imageArr[0][0] = new ImageIcon(new ImageIcon("TileImages/Bat0.png").getImage());
		imageArr[0][1] = new ImageIcon(new ImageIcon("TileImages/Bat1.png").getImage());
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
				nums[i][j]=new JButton();
				nums[i][j].addActionListener(this);
				nums[i][j].setBounds(10 + 60 * j, 10+60*i, 50, 50);  //location moves so labels don't overlap
				//the imagesArr index corresponds with the value on the board
				nums[i][j].setIcon(imageArr[Initialize.allTiles[Board.board[i][j]].getOrientation()][Board.board[i][j]]); 
				
				screen.add(nums[i][j]);
			}
		}
		frame.repaint();
	}
	
	//updates the board again
	private void panelUpdate() {
		for(int i =0;i<7;i++) {
			for(int j =0;j<7;j++){
				nums[i][j].setIcon(imageArr[Initialize.allTiles[Board.board[i][j]].getOrientation()][Board.board[i][j]]); 
				screen.add(nums[i][j]);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		panelUpdate();
		frame.repaint();
		panelUpdate();
		if(checkWin()) { //check if the game is over after a successful move, and a new block has spawned
			frame.setVisible(false);
			new EndScreen();
		}
		
		
	}

	public void keyPressed(KeyEvent key) {
	}

	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
}