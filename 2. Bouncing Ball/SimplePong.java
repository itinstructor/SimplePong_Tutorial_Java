/**
* Filename: SimplePong.java
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

public class SimplePong extends JPanel {
	private static final long serialVersionUID = 1L;

	// Diameter of the ball
	final int BALL_DIAMETER = 30;
	final int MOVE = 3;

	// Starting coordinates of the circle
	// Upper left hand side of the JPanel
	int BallX = 0;
	int BallY = 0;

	// Variables to control the speed and direction
	// of the x & y movement of the ball
	int MoveX = MOVE;
	int MoveY = MOVE;

	private void moveBall() {
		// If the ball runs into the left border, reverse direction
		if (BallX + MoveX < 0) {
			MoveX = MOVE;
		}
		// If the ball runs into the right border, reverse direction
		else if (BallX + MoveX > getWidth() - BALL_DIAMETER) {
			MoveX = -MOVE;
		}
		// If the ball runs into the top border, reverse direction
		if (BallY + MoveY < 0) {
			MoveY = MOVE;
		}
		// If the ball runs into the bottom border, reverse direction
		else if (BallY + MoveY > getHeight() - BALL_DIAMETER) {
			MoveY = -MOVE;
		}
		// Set the movement direction based on the previous decisions
		BallX = BallX + MoveX;
		BallY = BallY + MoveY;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// Create a Graphics2D object to access methods
		Graphics2D g2d = (Graphics2D) g;

		// Turn on antialiasing and hinting to help rendering of graphics
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);

		// Paint new position of the ball
		g.fillOval(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Simple Pong");
		SimplePong simplePong = new SimplePong();
		frame.add(simplePong);
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// An infinite "Game Loop"
		while (true) {

			// Move the ball
			simplePong.moveBall();

			// Repaint the JPanel
			simplePong.repaint();

			// Sleep this thread for 17 ms (Approximately 60 FPS)
			// Other threads can process, redrawing the screen
			Thread.sleep(17);
		}
	}
}
