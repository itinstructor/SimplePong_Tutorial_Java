
/**
* Filename: Ball.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* The Ball class
*/

import java.awt.Graphics2D;
import java.awt.Color;

public class Ball {
	private final int BALL_DIAMETER = 30;

	// Store the ball's x, y location
	private int BallX = 200;
	private int BallY = 200;

	// Store the ball's x, y movement
	private int MoveX = -3;
	private int MoveY = 3;

	// Create Game reference
	private SimplePong simplePong;

	// Create a ball object with a reference to the game board
	public Ball(SimplePong simplePong) {
		this.simplePong = simplePong;
	}

	void move() {
		// Move the ball by adding x, y integers to current location
		BallX = BallX + MoveX;
		BallY = BallY + MoveY;

		// If the ball runs into the left border, reverse direction
		if (BallX + MoveX < 0)
			MoveX = -MoveX;

		// If the ball runs into the right border, reverse direction
		if (BallX + MoveX > simplePong.getWidth() - BALL_DIAMETER)
			MoveX = -MoveX;

		// If the ball runs into the top border, reverse direction
		if (BallY + MoveY < 0)
			MoveY = -MoveY;

		// If the ball runs into the bottom border, reverse direction
		if (BallY + MoveY > simplePong.getHeight() - BALL_DIAMETER)
			MoveY = -MoveY;
	}

	// Paint the ball/circle
	public void paint(Graphics2D g) {
		g.setColor(Color.DARK_GRAY); // Change the paint color to DARK GRAY
		g.fillOval(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
	}
}