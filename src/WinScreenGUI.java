//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

import audio.AudioPlayer;
import audio.MusicPlayer;

public class WinScreenGUI extends JFrame implements ActionListener {
	//gui stuff
	JPanel winScreen = new JPanel();
	JButton screenButton = new JButton();
	ImageIcon winScreenImages[];
	
	int winningPlayer;

	//constructor method
	public WinScreenGUI(int winningPlayer) {
		this.winningPlayer = winningPlayer;
		AudioPlayer.playAudio("Audio/SE/SlotsBigWin.wav");
		frameSetup();
		panelDesign();

	}

	//sets up the frame
	private void frameSetup() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(750, 500);
		setLayout(null);
		add(winScreen);
		setVisible(true);
		setResizable(false);
	}

	//sets up the panel
	private void panelDesign() {
		
		//add features for the screen
		winScreen.setBorder(null);
		winScreen.setBackground(Color.BLACK);
		winScreen.setBounds(0, 0, 750, 500);
		winScreen.setLayout(null);

		//add features for the button. The entire screen is the button so they can click anywhere to continue
		screenButton.addActionListener(this);
		screenButton.setIcon(new ImageIcon(new ImageIcon(String.format("OtherImages/WinScreen%d.png",winningPlayer)).getImage().getScaledInstance(750, 500, 0)));
		screenButton.setBounds(0, 0, 750, 500); //the button fills the entire screen
		screenButton.setContentAreaFilled(false);
		screenButton.setBorderPainted(false);
		winScreen.add(screenButton);

	}

	//restarts the game
	public void actionPerformed(ActionEvent arg0) {
		
		GameGUI.frame.dispose();
		dispose();
		new GameSetUpGUI();
	
	}
}