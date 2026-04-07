package src;
import javax.swing.*;
public class PowerGridFrame extends JFrame {
	private final int WIDTH = 2048;
	private final int HEIGHT = 1152;
	public PowerGridFrame(String frameName) {
		super(frameName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		GameState.initialPanel = new InitialPanel();
		add(GameState.initialPanel);
		setVisible(true);
	}
	public static void main(String[] args) {
		System.out.println("Power Grid");
    }
}