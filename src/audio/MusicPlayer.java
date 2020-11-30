package audio;
//Partially by Lord ALAN SUN 
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
	
	public static Clip clip;
	private static Clip SE;
	private static AudioInputStream audioInput;
	private static long time;
	
	public static void playAudio(String audioLocation) {
	
		try {
			
			File sound = new File(audioLocation);
			
			audioInput = AudioSystem.getAudioInputStream(sound);
			
			clip = AudioSystem.getClip();
			
			clip.open(audioInput);

			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
			clip.start();
					
		} catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
	public static void stopMusic(){
		
		clip.stop();
		
	}
	
	//added by Bryan
	//pauses and unpauses the music
	public static void pauseMusic(){
		
		time = clip.getMicrosecondPosition();
		
		clip.stop();
		
	}
	public static void unpauseMusic(){
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		clip.setMicrosecondPosition(time);
		
		clip.start();
				
	}
	
	
}
