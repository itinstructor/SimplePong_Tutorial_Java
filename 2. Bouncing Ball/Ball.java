
/**
* Filename: Ball.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* The Ball class
*/

import java.awt.Graphics2D;

public class Ball {
	private final int BALL_DIAMETER = 30;
	private final int TOP_LEFT_BORDER = 0;
	private final int MOVE = 3;
	private int BallX = 0;
	private int BallY = 0;
	private int MoveX = MOVE;
	private int MoveY = MOVE;
	private SimplePong2 simplePong; // Create a Game2 reference

	// Create a ball object with a reference to the game board
	public Ball(SimplePong2 simplePong) {
		this.simplePong = simplePong;
	}

	void move() {
		// If the ball runs into the top border, change direction
		if (BallX + MoveX < TOP_LEFT_BORDER)
			MoveX = MOVE;

		// If the ball runs into the right border, change direction
		if (BallX + MoveX > simplePong.getWidth() - BALL_DIAMETER)
			MoveX = -MOVE;

		// If the ball runs into the top border, change direction
		if (BallY + MoveY < TOP_LEFT_BORDER)
			MoveY = MOVE;

		// If the ball runs into the bottom border, change direction
		if (BallY + MoveY > simplePong.getHeight() - BALL_DIAMETER)
			MoveY = -MOVE;

		// Set the movement direction based on the previous decisions
		BallX = BallX + MoveX;
		BallY = BallY + MoveY;
	}

	// Create the ball/circle
	public void paint(Graphics2D g) {
		// Paint new position of the ball
		g.fillOval(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
	}
}