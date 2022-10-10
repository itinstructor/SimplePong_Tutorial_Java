
/**
* Filename: MovingBall.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Move a ball across the frame
*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovingBall extends JPanel {
	private static final long serialVersionUID = 1L;

	// Diameter of the ball
	private final int BALL_DIAMETER = 30;
	private final int MOVE = 3;
	
	// Starting coordinates of the ball
	// Upper left hand side of the JPanel
	int BallX = 0;
	int BallY = 0;

	// Method to move the circle 1 pixel down and to the right
	// Move the circle diagonally
	private void moveBall() {
		BallX = BallX + MOVE;
		BallY = BallY + MOVE;
	}

	// Override the default object paint method.
	@Override
	public void paint(Graphics g) {
		// Clear JPanel
		super.paint(g);
		// Create Graphics2D object for better drawing to screen
		Graphics2D g2d = (Graphics2D) g;
		// Turn on anti aliasing, makes the circle bitmap smoother
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Paint new position of the ball
		g2d.fillOval(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Simple Pong");
		MovingBall game = new MovingBall();
		frame.add(game);
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// An infinite "Game Loop"
		while (true) {
			// Move the ball
			game.moveBall();
			// Repaint the JPanel
			game.repaint();
			// Sleep this thread for 17 ms (Approximately 60 FPS)
			// Other threads can process, redrawing the screen
			Thread.sleep(17);
		}
	}
}