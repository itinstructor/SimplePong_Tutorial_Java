
/**
* Filename: Game2.java
* Written by:	William Loring
* Written on:	02-10-2018
* Revised:		
* Simple frame with drawing objects
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game2 extends JPanel {
	private static final long serialVersionUID = 1L;

	// Override the default paint method of the program
	@Override
	public void paint(Graphics g) {

		// Create a Graphics2D object to draw on screen
		Graphics2D g2d = (Graphics2D) g;

		// Set the color to RED, a Java constant
		g2d.setColor(Color.RED);

		// Create objects at (x, y, width, height)
		g2d.fillOval(0, 0, 30, 35);
		g2d.drawOval(0, 50, 30, 40);
		g2d.fillRect(50, 0, 20, 30);
		g2d.drawRect(50, 50, 30, 30);

		// Draw a circle using the Ellipse object
		g2d.draw(new Ellipse2D.Double(0, 100, 30, 35));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Simple Pong");
		frame.add(new Game2());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
