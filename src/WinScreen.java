//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import audio.MusicPlayer;

public class WinScreen extends JFrame implements ActionListener {
	//gui stuff
	JPanel splashScreen = new JPanel();
	JButton screenButton = new JButton();
	//win type
	int winningPlayer;

	//constructor method
	public WinScreen(int winningPlayer) {
		this.winningPlayer = winningPlayer;
		frameSetup();
		panelDesign();

	}

	//sets up the frame
	private void frameSetup() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(null);
		add(splashScreen);
		setVisible(true);
		setResizable(false);
	}

	//sets up the panel
	private void panelDesign() {
		//add features for the screen
		splashScreen.setBorder(null);
		splashScreen.setBackground(Color.BLACK);
		splashScreen.setBounds(0, 0, 500, 500);
		splashScreen.setLayout(null);

		//add features for the button
		screenButton.addActionListener(this);
		screenButton.setBounds(0, 0, 500, 500); //the button fills the entire screen
		
		//add labels to show winner
		
		splashScreen.add(screenButton);

	}

	//returns to continue the game
	//before the win screen was opened, the game was saved - that game is being loaded again
	public void actionPerformed(ActionEvent arg0) {
		GameGUI.frame.dispose();
		dispose();
		try {
			new GameGUI(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}