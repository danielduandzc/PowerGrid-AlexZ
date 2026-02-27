package src;
import javax.swing.*;
public class PowerGrid extends JFrame {
	private final int WIDTH = 2048;
	private final int HEIGHT = 1152;
	public PowerGrid(String frameName) {
		super(frameName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		add(new PowerGridPanel());
		setVisible(true);
	}
	public static void main(String[] args) {
		System.out.println("Power Grid");
    }
}