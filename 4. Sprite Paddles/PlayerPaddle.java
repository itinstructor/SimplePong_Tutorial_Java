
/**
* Filename: PlayerPaddle.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Add a Player paddle class
*/
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class PlayerPaddle {

	// Create a reference to the game object
	private SimplePong simplePong;

	// Set horizontal position of racquet from left side of window
	private final int PADDLE_X = 5;

	// How many pixels at a time an object moves
	private final int MOVE = 3;

	// Create custom RGB color, Cougar Blue
	private final Color COUGAR_BLUE = new Color(0, 58, 112);

	// Store vertical position
	private int PaddleY = 0;
	// Store vertical movement
	private int MoveY = 0;

	// Create object with Game reference
	public PlayerPaddle(SimplePong simplePong) {
		this.simplePong = simplePong;
	}

	public void move() {
		// If the paddle is not outside the top or bottom border, allow movement
		if (PaddleY + MoveY > 0 && PaddleY + MoveY < simplePong.getHeight() - SimplePong.PADDLE_HEIGHT) {
			PaddleY = PaddleY + MoveY;
		}
	}

	// Draw paddle rectangle
	public void paint(Graphics2D g) {
		g.setColor(COUGAR_BLUE); // Use custom RGB color, Cougar Blue
		g.fillRect(PADDLE_X, PaddleY, SimplePong.PADDLE_WIDTH, SimplePong.PADDLE_HEIGHT);
	}

	// Stop movement when key is released
	public void keyReleased(KeyEvent e) {
		MoveY = 0;
	}

	// Get which cursor key is pressed, change vertical movement variable
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			MoveY = -MOVE;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			MoveY = MOVE;
	}
}