
/**
* Filename: ComputerPaddle.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Add a Computer paddle class
*/
import java.awt.Graphics2D;
import java.awt.Color;

public class ComputerPaddle {

	// Create a reference to the game object
	private SimplePong simplePong;

	// Set horizontal position of racquet from right side of window
	private final int PADDLE_X = SimplePong.GAME_WIDTH - 30;

	// Create custom RGB color, Cougar Gold
	private final Color COUGAR_GOLD = new Color(249, 190, 0);

	// Store vertical positionS
	private int PaddleY = 0;
	// Set Computer paddle speed
	private int MoveY = 3;

	// Create object with Game reference
	public ComputerPaddle(SimplePong simplePong) {
		this.simplePong = simplePong;
	}

	// The Computer paddle continuously moves up and down
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
}
