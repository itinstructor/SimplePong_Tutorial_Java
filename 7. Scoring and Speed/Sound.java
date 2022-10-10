import java.io.*; // Read from file system
import java.net.URL; // Get and manage URL (file) path
import javax.sound.sampled.AudioInputStream; // Create Audio input stream object
import javax.sound.sampled.AudioSystem; // Gets the Audio stream
import javax.sound.sampled.Clip; // In memory source for playing audio
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This enum encapsulates all the sound effects of a game, so as to separate the
 * sound playing code from the game code. 1. Define all your sound effect names
 * and the associated wave files. 2. To play a specific sound, simply invoke
 * Sound.SOUND_NAME.play(). 3. You can invoke the static method Sound.init() to
 * pre-load all the sound files, so that the play is not paused while loading
 * the file for the first time. 4. You can use the static variable Sound.volume
 * to mute the sound.
 */
public enum Sound {
   BALL("ball.wav"), // Ping Pong ball strike
   GAMEOVER("gameover.wav"), // Game is over
   BACKGROUND("background.wav"); // Continous background music for the game

   // Nested class for specifying volume
   public static enum Volume {
      MUTE, LOW, MEDIUM, HIGH
   }

   // Initialize the volume to low
   public static Volume volume = Volume.LOW;

   // Each sound effect has its own clip, loaded with its own sound file
   private Clip clip;

   // Constructor to construct each element of the enum with its own sound file.
   Sound(String soundFileName) {
      try {
         // Use URL to read the file path from the disk and JAR
         URL url = this.getClass().getClassLoader().getResource(soundFileName);
         // Set up an audio input stream piped from the sound file
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
         // Get a clip resource
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream
         clip.open(audioInputStream);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }

   // Play or Re-play the sound effect from the beginning, by rewinding
   public void play() {
      if (volume != Volume.MUTE) {
         if (clip.isRunning())
            clip.stop(); // Stop the player if it is still running
         clip.setFramePosition(0); // Rewind to the beginning
         clip.start(); // Start playing
      }
   }

   // Loop the sound effect continously
   public void loop() {
      if (volume != Volume.MUTE) {
         if (clip.isRunning())
            clip.stop(); // Stop the player if it is still running
         clip.setFramePosition(0); // Rewind to the beginning
         clip.loop(Clip.LOOP_CONTINUOUSLY); // Start the loop
      }
   }

   // Stop the sound
   public void stop() {
      clip.stop(); // Stop the player if it is still running
   }

   // Static method to pre-load all the sound files.
   static void init() {
      values(); // calls the constructor for all the elements
   }
}