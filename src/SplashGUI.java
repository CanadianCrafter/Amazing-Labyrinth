//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.Timer;

import audio.MusicPlayer;

//Creates an opening animation for the game. Yes, the image says Actraiser and not Amazing Labyrinth
//but the budget was too small for a personal animation

public class SplashGUI extends JFrame implements ActionListener {

	private JPanel splashScreen = new JPanel();
	private JButton playButton = new JButton(); //click the button to proceed
	private Timer animationTimer = new Timer(100, this); // the stop motion animation runs at 10 fps or every 0.1 seconds
	
	//timing for the animations
	private int index = 1;

	// constructor method
	public SplashGUI() {
		
		MusicPlayer.playAudio("Audio/BGM/Actraiser - Opening.wav"); // music
		frameSetup();
		panelDesign();
		animationTimer.start(); // starts timer for the animation

	}

	// this method sets up the frame
	private void frameSetup() {
		
		setTitle("Amazing Labyrinth");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(757, 529); // sets the dimensions of the frame
		setLayout(null);
		add(splashScreen);
		setVisible(true);
		setResizable(false);
	
	}

	// this method designs the panel
	private void panelDesign() {
		
		splashScreen.setBorder(null);
		splashScreen.setBounds(-12, -25, 800, 600); // sets the boundaries and location of the panel
		splashScreen.setLayout(null);
		
		//add features for the button. This button covers the entire screen so the user can click anywhere to skip the animation
		playButton.addActionListener(this);
		playButton.setBounds(-12, -25, 800, 600); 
		playButton.setOpaque(true); //The following three lines make the button completely invisible
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		playButton.setIcon(new ImageIcon(
				new ImageIcon("OpeningAnimationImages/# (1).png").getImage())); // frame1 of animation
		splashScreen.add(playButton); 

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == animationTimer) {
			
			// each 1/10 second, the frame updates with a new photo
			//the animation works by repeatedly changing the icon on the button
			if(index>=1&&index<=144)
				playButton.setIcon(new ImageIcon(new ImageIcon(String.format("OpeningAnimationImages/# (%d).png", index)).getImage()
						.getScaledInstance(750, 500, 0)));
			index++;
			repaint();

			//stops on the Click to Start image until the player clicks on it
			if(index==135)
				animationTimer.stop();

			//once the animation is over, open the next class
			if(index==150) {
				setVisible(false);
				MusicPlayer.stopMusic();
				new RulesGUI();
				animationTimer.stop();
			}
		}
		
		//when the player clicks on the screen, finish off the opening animation
		else if (event.getSource() == playButton) {
			animationTimer.start();
			index=135;
			
		}
	}
}
