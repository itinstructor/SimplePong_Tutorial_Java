import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyboardExample extends JPanel {
	private static final long serialVersionUID = 1L;

	public KeyboardExample() {
		// Create new KeyListener object
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			// Listen to key pressed events and get key pressed
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed=" + KeyEvent.getKeyText(e.getKeyCode()));
			}

			// Listen to key released events and get key released
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased=" + KeyEvent.getKeyText(e.getKeyCode()));
			}
		};
		// Register KeyListener to JPanel
		addKeyListener(listener);
		// Allow focus to JPanel
		setFocusable(true);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Keyboard Events");
		KeyboardExample keyboardExample = new KeyboardExample();
		frame.add(keyboardExample);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

