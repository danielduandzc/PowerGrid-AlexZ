package src;
import javax.swing.*;
public class PowerGridFrame extends JFrame {
	private final int WIDTH = 2048;
	private final int HEIGHT = 1152;
	public PowerGridFrame(String frameName) {
		super(frameName);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		GameState.initialPanel = new InitialPanel();
		add(GameState.initialPanel);
		setVisible(true);
	}
	
}
