
/**
* Filename: ComputerPaddle.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Add a Player paddle class
*/
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class ComputerPaddle {

	// Create a reference to the game object
	private SimplePong simplePong;

	// Set horizontal position of racquet from right side of window
	private final int PADDLE_X = SimplePong.GAME_WIDTH - 30;

	// Create custom RGB color, Cougar Gold
	private final Color COUGAR_GOLD = new Color(249, 190, 0);

	// Store vertical position
	private int PaddleY = 0;
	// Set Computer paddle speed
	private int MoveY = 3;

	// Create object with Game reference
	public ComputerPaddle(SimplePong simplePong) {
		this.simplePong = simplePong;
	}

	public void move() {
		// If the paddle is not outside the top or bottom border, allow movement
		if (PaddleY + MoveY > 0 && PaddleY + MoveY < simplePong.getHeight() - SimplePong.PADDLE_HEIGHT) {
			PaddleY = PaddleY + MoveY;
		} else {
			MoveY = -MoveY;
		}
	}

	// Draw paddle rectangle
	public void paint(Graphics2D g) {
		g.setColor(COUGAR_GOLD); // Use custom RGB color, Cougar Gold
		g.fillRect(PADDLE_X, PaddleY, SimplePong.PADDLE_WIDTH, SimplePong.PADDLE_HEIGHT);
	}

	// Used by Ball to get location of paddle rectangle
	public Rectangle getBounds() {
		return new Rectangle(PADDLE_X, PaddleY, SimplePong.PADDLE_WIDTH, SimplePong.PADDLE_HEIGHT);
	}

	// Allows the Game object to get left hand side of the paddle
	public int getLeftX() {
		return PADDLE_X - SimplePong.PADDLE_WIDTH;
	}
}