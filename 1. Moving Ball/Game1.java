/**
* Filename: Game1.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Draw a frame
*/

// Import Swing JFrame component for GUI
import javax.swing.JFrame;

public class Game1 {
   public static void main(String[] args) {

      // Create a JFrame object called frame
      JFrame frame = new JFrame("Simple Pong");

      // Set the size of the frame in pixels x, y
      frame.setSize(300, 300);

      // Make the frame visible
      frame.setVisible(true);

      // Exit the program when the frame is closed
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
