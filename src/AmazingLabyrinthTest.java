import java.io.IOException;
/* 
 * Git Hub: https://github.com/CanadianCrafter/Amazing-Labyrinth
 * 
 * 
 * Names and Work Distribution:
 * Bryan (50%): 
 * Created the program's foundation/infrastructure:
 *      - Made the Board, Board Graph, Game GUI, and part of the Initialize class
 *      - Took care of most of the game/board simulation
 *      - Designed the relationship between classes
 *      - Organized how the game data is stored and utilized 
 * 
 * Designed the structure and layout of the program
 * Created the template for all of the program's GUIs (Buttons, Labels, colours, sizes, music, design etc.) 
 * Solely made the GUI for several of the classes.
 * Added countless other GUI features like a menubar with the option to turn of music etc.
 *  Made the background images and artistic elements
 *  
 * Made the save game feature (using buffered reader to be extra speedy) 
 * 
 * Given tiles, made a graph, and used BFS to find all possible paths
 * 
 * Made the animations in the SplashGUI class
 * 
 * Added/tweaked the music classes. The classes are originally Alan Sun's (orz) 
 * and I wanted to include his code in the prohect
 * 
 * Cleaned up, managed, commented, and debugged 90% of the code
 * 
 *   
 * 
 * Oscar (35%):     
 *
 * Setting methods in board class.
 * Declaring icons in the CardImages class
 * Setting up card labels, player labels, insert buttons, free tile labels and rotation buttons in GameGUI class.
 * Setting up GameSetUpGUI class with buttons in the right positions and right functions.
 * Setting methods in the player class.
 * Setting methods in the tile class.
 * Editing tile images and card images in exact sizes
 * 
 * 
 * Lily (15%):
 * Helped with setting preset values for tiles
 * Helped with the GameSetUpGUI
 * 
 * 
 * 
 * Date:
 * November, 29, 2020
 * 
 * 
 * Course Code:
 * ICS4U1-01 | Mr. Fernandes
 * 
 * 
 * Title: The Amazing Labyrinth 
 * 
 * 
 * Description:
 * The program mimics the board game "The Amazing Labyrinth".
 * The Amazing Labyrinth is a maze board game that can be played with two players.
 * Currently, there is no AI, so it must be played with in two player mode.
 * Each player starts off with a randomly assigned deck of treasures they are tasked to retrieve.
 * The person who finds all their treasures first wins.
 * Players can manipulate the play space by shifting the tiles around in order to create a path to a treasure or block an opponent.
 * 
 * 
 * Features:
 * Animated splash screen
 * Audio and Background Music (that you can turn off in a menubar)
 * Highlights possible paths
 * Allows for saving
 * Custom art/design
 * AI to be implemented
 * 
 * 
 * 
 * Major Skills:
 * Graph Theory and Graph Traversal
 * Playing Music
 * Animations
 * Creating complex GUIs using the Swing library
 * File input and output using buffered reader
 * Object Oriented Programming
 * Git Hub
 * Data structures
 * 
 * Areas of Concern:
 * We found out late into the development cycle that the game was meant for 4 players, not 2
 * I made sure that we used constants to denote number of players in case this would happen, 
 * however, some GUI art assets wouldn't be easily scaled to 4 players (in the GameSetUpGUI)(
 * Thus, we currently only support 2 players, though it will be quickly fixed
 * 
 * 
 */



public class AmazingLabyrinthTest {
	
	public static void main(String[] args) throws IOException {
		
		new SplashGUI();

	}
	
}
