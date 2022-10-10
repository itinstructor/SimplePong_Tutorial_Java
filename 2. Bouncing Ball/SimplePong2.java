
/**
* Filename: SimplePong2.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Refactor the program, move all ball logic into ball class
*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimplePong2 extends JPanel {
	private static final long serialVersionUID = 1L;
	// Constants for the size of the JFrame
	final static int GAME_WIDTH = 600;
	final static int GAME_HEIGHT = 400;

	// Approximately 60 FPS (Frames per Second)
	private static int gameSpeed = 17;

	// Create a Ball object
	Ball ball = new Ball(this);

	// Call the Ball.move method
	private void move() {
		ball.move();
	}

	@Override // Override the default paint method
	public void paint(Graphics g) {
		super.paint(g);
		// Create a Graphics2D object to access methods
		Graphics2D g2d = (Graphics2D) g;
		// Turn on antialiasing and hinting to help rendering of graphics
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d); // Paint the ball on the screen
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Simple Pong");
		SimplePong2 simplePong = new SimplePong2(); // Create a game object
		frame.add(simplePong);
		frame.setSize(GAME_WIDTH, GAME_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Game loop, loops forever
		while (true) {
			simplePong.move(); // Call the move methods
			simplePong.repaint(); // Repaint the application screen
			Thread.sleep(gameSpeed); // Pause for to let Frame redraw
		}
	}
}