//imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import audio.MusicPlayer;

public class GameSetUpGUI extends JFrame implements ActionListener {
	//gui stuff
	static JFrame frame;
	private static JPanel screen;
	
	private JLabel image1;
	private JLabel image2;
	private JLabel image3;
	private JLabel image4;
	
	private JButton playerOnly;
	private JButton easy;
	private JButton medium;
	private JButton hard;
	private JButton red0;
	private JButton red1;
	private JButton yellow0;
	private JButton yellow1;
	private JButton green0;
	private JButton green1;
	private JButton blue0;
	private JButton blue1;
	private JButton numC2;
	private JButton numC3;
	private JButton numC4;
	private JButton numC5;
	private JButton numC6;
	
	private JLabel statusLabel;
	
	JButton playButton;
	JButton loadButton;
	
	int[] playerColour=new int[2];
	int cardNum;
	
	

	// constructor method
	public GameSetUpGUI() {
		new ExtraBoardImages();
		MusicPlayer.playAudio("Audio/BGM/Actraiser - Birth of the People Medley.wav");
		frame=new JFrame();
		screen=new JPanel();
		
		image1=new JLabel();
		image2=new JLabel();
		image3=new JLabel();
		image4=new JLabel();
		
		
		playerOnly = new JButton ();
		easy = new JButton ();
		medium = new JButton ();
		hard = new JButton ();
		red0 = new JButton ();
		red1 = new JButton ();
		yellow0 = new JButton ();
		yellow1 = new JButton ();
		green0 = new JButton ();
		green1 = new JButton ();
		blue0 = new JButton ();
		blue1 = new JButton ();
		numC2 = new JButton ();
		numC3 = new JButton ();
		numC4 = new JButton ();
		numC5 = new JButton ();
		numC6= new JButton ();
		
		playButton=new JButton();
		loadButton=new JButton();
		
		statusLabel=new JLabel();
		
		frameSetup();
		panelDesign();
	}

	//set up the frame
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

	//set up the panel
	private void panelDesign() {
		//add features for the screen
		screen.setBorder(null);
		screen.setBackground(new java.awt.Color(47, 47, 47));
		screen.setBounds(0,0,750,500);
		screen.setLayout(null);
		
		
		
		//add features for the buttons
		playButton.addActionListener(this);
		playButton.setBounds(510, 270, 100, 50); 
		playButton.setOpaque(false); //The following three lines make the button completely invisible
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		screen.add(playButton); 
		
		loadButton.addActionListener(this);
		loadButton.setBounds(490, 340, 140, 50);
		loadButton.setOpaque(false); 
		loadButton.setContentAreaFilled(false);
		loadButton.setBorderPainted(false);
		screen.add(loadButton);
		
		playerOnly.setBounds(10,207,150,35);
		playerOnly.addActionListener(this);
		playerOnly.setOpaque(false); 
		playerOnly.setContentAreaFilled(false);
		playerOnly.setBorderPainted(false);
		screen.add(playerOnly);
		
		easy.setBounds(170,207,50,35);
		easy.addActionListener(this);
		easy.setOpaque(false); 
		easy.setContentAreaFilled(false);
		easy.setBorderPainted(false);
		screen.add(easy);
		
		medium.setBounds(220,207,75,35);
		medium.addActionListener(this);
		medium.setOpaque(false); 
		medium.setContentAreaFilled(false);
		medium.setBorderPainted(false);
		screen.add(medium);
		
		hard.setBounds(295,207,53,35);
		hard.addActionListener(this);
		hard.setOpaque(false); 
		hard.setContentAreaFilled(false);
		hard.setBorderPainted(false);
		screen.add(hard);
		
		red0.setBounds(140,270,45,35);
		red0.addActionListener(this);
		red0.setOpaque(false); 
		red0.setContentAreaFilled(false);
		red0.setBorderPainted(false);
		screen.add(red0);
		
		
		red1.setBounds(140,305,45,35);
		red1.addActionListener(this);
		red1.setOpaque(false); 
		red1.setContentAreaFilled(false);
		red1.setBorderPainted(false);
		screen.add(red1);
		
		
		yellow0.setBounds(185,270,75,35);
		yellow0.addActionListener(this);
		screen.add(yellow0);
		yellow0.setOpaque(false); 
		yellow0.setContentAreaFilled(false);
		yellow0.setBorderPainted(false);
		
		yellow1.setBounds(185,305,75,35);
		yellow1.addActionListener(this);
		screen.add(yellow1);
		yellow1.setOpaque(false); 
		yellow1.setContentAreaFilled(false);
		yellow1.setBorderPainted(false);
		
		green0.setBounds(260,270,60,35);
		green0.addActionListener(this);
		screen.add(green0);
		green0.setOpaque(false); 
		green0.setContentAreaFilled(false);
		green0.setBorderPainted(false);
		
		green1.setBounds(260,305,60,35);
		green1.addActionListener(this);
		screen.add(green1);
		green1.setOpaque(false); 
		green1.setContentAreaFilled(false);
		green1.setBorderPainted(false);
		
		blue0.setBounds(320,270,50,35);
		blue0.addActionListener(this);
		screen.add(blue0);
		blue0.setOpaque(false); 
		blue0.setContentAreaFilled(false);
		blue0.setBorderPainted(false);
		
		blue1.setBounds(320,305,50,35);
		blue1.addActionListener(this);
		screen.add(blue1);
		blue1.setOpaque(false); 
		blue1.setContentAreaFilled(false);
		blue1.setBorderPainted(false);
		
		numC2.setBounds(130,430,20,30);
		numC2.addActionListener(this);
		screen.add(numC2);
		numC2.setOpaque(false); 
		numC2.setContentAreaFilled(false);
		numC2.setBorderPainted(false);
		
		numC3.setBounds(155,430,20,30);
		numC3.addActionListener(this);
		screen.add(numC3);
		numC3.setOpaque(false); 
		numC3.setContentAreaFilled(false);
		numC3.setBorderPainted(false);
		
		numC4.setBounds(180,430,20,30);
		numC4.addActionListener(this);
		screen.add(numC4);
		numC4.setOpaque(false); 
		numC4.setContentAreaFilled(false);
		numC4.setBorderPainted(false);
		
		
		numC5.setBounds(205,430,20,30);
		numC5.addActionListener(this);
		screen.add(numC5);
		numC5.setOpaque(false); 
		numC5.setContentAreaFilled(false);
		numC5.setBorderPainted(false);
		
		
		numC6.setBounds(230,430,20,30);
		numC6.addActionListener(this);
		screen.add(numC6);
		numC6.setOpaque(false); 
		numC6.setContentAreaFilled(false);
		numC6.setBorderPainted(false);;
		
		image1.setBounds(0, 0, 750, 500);
		image1.setIcon(ExtraBoardImages.startScreenImages[0]);
		image1.setVisible(true);
		screen.add(image1);
		
		image2.setBounds(0, 0, 750, 500);
		image2.setIcon(ExtraBoardImages.startScreenImages[1]);
		image2.setVisible(false);
		screen.add(image2);
	
		image3.setBounds(0, 0, 750, 500);
		image3.setIcon(ExtraBoardImages.startScreenImages[2]);
		image3.setVisible(false);
		screen.add(image3);
		
		image2.setBounds(0, 0, 750, 500);
		image2.setIcon(ExtraBoardImages.startScreenImages[3]);
		image2.setVisible(false);
		screen.add(image4);
		
		statusLabel.setBounds(80, 360, 200, 50);
		statusLabel.setForeground(Color.red);
		statusLabel.setVisible(false);
		screen.add(statusLabel);
		
		frame.repaint();

	}
	
	//carries out the actions for each of the buttons
	public void actionPerformed(ActionEvent event) {
		//starts a new game
		if(event.getSource()==playButton) {
			//wipes the save file
			try {
				new PrintWriter("Files/Save.txt").close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			dispose();
			try {
				//NEED TO double check that the array doesn't have two of the same values
				int arr[] = {1,0};
				frame.setVisible(false);
				new Initialize(5,arr);
				new GameGUI(false);//starts a game without loading saves
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
		//loads in a saved game
		else if(event.getSource()==loadButton) {
			//if the save file is empty, change the splash screen image to show an error message
			if(!checkLoad()) {
//				image.setIcon(new ImageIcon(new ImageIcon("Images/Splash Screen Error.png").getImage().getScaledInstance(500, 500, 0)));
			}
			//if the save file isn't empty, start a game that loads the save
			else {
				dispose();
				try {
					new GameGUI(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		else if(event.getSource()==red0) {
			playerColour[0]=0;
			System.out.print("0");
			statusLabel.setText("Player 1 sets red");
			statusLabel.setVisible(true);
		}
		
		else if(event.getSource()==red1) {
			playerColour[1]=0;
		}
		
		else if(event.getSource()==yellow0) {
			playerColour[0]=1;
		}
		
		else if(event.getSource()==yellow1) {
			playerColour[1]=1;
		}
		
		else if(event.getSource()==green0) {
			playerColour[0]=2;
		}
		
		else if(event.getSource()==green1) {
			playerColour[1]=2;
		}
		
		else if(event.getSource()==blue0) {
			playerColour[0]=3;
		}
		
		else if(event.getSource()==blue1) {
			playerColour[1]=3;
		}
		
		else if(event.getSource()==numC2) {
			cardNum=2;
		}
		else if(event.getSource()==numC3) {
			cardNum=3;
		}
		else if(event.getSource()==numC4) {
			cardNum=4;
		}
		else if(event.getSource()==numC5) {
			cardNum=5;
		}
		else if(event.getSource()==numC6) {
			
		}
	}
	
	//checks if the save file has data
	//if the save file is empty, return false
	private boolean checkLoad() {
		File newFile = new File("Save.txt");
	    if (newFile.length() == 0) return false;
		return true;
	}
}