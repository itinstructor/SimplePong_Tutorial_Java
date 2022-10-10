/**
* Filename: SimplePong.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Add scoring and speed
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SimplePong extends JPanel {
	private static final long serialVersionUID = 1L;

	// Constants for the JFrame size
	final static int GAME_WIDTH = 800;
	final static int GAME_HEIGHT = 500;

	// How many rounds it takes to win
	final static int WIN = 4;

	// Paddle size for player and computer
	final static int PADDLE_WIDTH = 10;
	final static int PADDLE_HEIGHT = 100;

	// Speed of the game loop
	// Decrease for faster, increase for slower
	final static int GAME_LOOP_SPEED = 17;

	// Variable for the speed of the game
	static int gameSpeed = 1;

	// Keep track of score
	int playerScore = 0;
	int computerScore = 0;

	// Create Ball and Paddle objects
	Ball ball = new Ball(this);
	Player player = new Player(this);
	Computer computer = new Computer(this);

	// Construct the Game application
	public SimplePong() {
		Sound.init(); 					 // Load all sound files in memory
		Sound.volume = Sound.Volume.LOW; // Set sound volume

		// Add KeyListener to the application
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				player.keyPressed(e);
			}
		});
		setFocusable(true); 	 // Allow keyboard events to be captured from JFrame
		Sound.BACKGROUND.loop(); // Loop background sound
	}

	// Move the Ball and Paddles
	private void move() {
		ball.move();
		player.move();
		computer.move();
	}

	@Override // Override the default paint method
	public void paint(Graphics g) {
		super.paint(g);	  			// Clear the window
		setBackground(Color.WHITE); // Set window background to White
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

		// Override the game objects paint methods
		ball.paint(g2d);
		player.paint(g2d);
		computer.paint(g2d);

		// Display score
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 14));
		g2d.drawString("Player Score: " + String.valueOf(playerScore), 40, 15);
		g2d.drawString("Computer Score: " + String.valueOf(computerScore),
                       GAME_WIDTH - 200, 15);
	}

	// Game Over called from Ball object
	public void gameOver() {
		Sound.BACKGROUND.stop();
		Sound.GAMEOVER.play();
		String msg = "Player score is: " + String.valueOf(playerScore)
                   + "\nComputer score is: " + String.valueOf(computerScore);
		JOptionPane.showMessageDialog(this, msg, "Game Over",
									  JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Simple Pong");
		SimplePong simplePong = new SimplePong();
		frame.add(simplePong);
		frame.setSize(GAME_WIDTH, GAME_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Game loop, loops forever
		while (true) {
			simplePong.move(); 				// Call the move methods
			simplePong.repaint(); 			// Repaint the application screen
			Thread.sleep(GAME_LOOP_SPEED);  // Pause thread to let JFrame redraw
		}
	}
}