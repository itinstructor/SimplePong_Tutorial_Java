
/**
* Filename: Ball.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Add a ball class
*/

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Ball {
	private final int BALL_DIAMETER = 30;

	// Store the ball's x, y location
	private int BallX = 400;
	private int BallY = 250;

	// Store the ball's x, y movement
	private int MoveX = -3;
	private int MoveY = 3;

	// Create Game variable
	private SimplePong simplePong;

	// Create a ball object with a reference to the game board
	public Ball(SimplePong simplePong) {
		this.simplePong = simplePong;
	}

	void move() {
		// Print the pixel movement
		// System.out.println(BallX + ", " + BallY);
		// Move the ball by adding x, y integers to current location
		BallX = BallX + MoveX;
		BallY = BallY + MoveY;

		// If the ball hits either paddle, reverse direction,
		if (simplePong.player.getBounds().intersects(getBounds())
				|| simplePong.computer.getBounds().intersects(getBounds())) {
			MoveX = -MoveX; // Reverse horizontal direction
		}

		// If the ball runs into the top or botton border, reverse direction
		if (BallY < 0 || BallY + BALL_DIAMETER > simplePong.getHeight()) {
			MoveY = -MoveY; // Reverse the vertical direction of the ball
		}

		// If the ball runs into the left border, Computer wins
		if (BallX + MoveX < 0) {
			simplePong.gameOver();
		}

		// If the ball runs into the right border, Player wins
		if (BallX + BALL_DIAMETER > simplePong.getWidth()) {
			simplePong.gameOver();
		}
	}

	// Paint the ball/circle
	public void paint(Graphics2D g) {
		g.setColor(Color.DARK_GRAY); // Change the paint color to DARK GRAY
		g.fillOval(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
	}
}