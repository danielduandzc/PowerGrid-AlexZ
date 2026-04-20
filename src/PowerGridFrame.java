//package src;
import javax.swing.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
public class PowerGridFrame extends JFrame {
	private final int WIDTH = 2048;
	private final int HEIGHT = 1152;
	public PowerGridFrame(String frameName) {
		super(frameName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		GameState.initialPanel = new InitialPanel();
		GameState.currentEvent.add("Title Screen");
		add(GameState.initialPanel);
		setVisible(true);
	}
	public static void main(String[] args) {
		System.out.println("Power Grid");
		// Load the font
		try {
			File fontFile = new File("resources/Bungee-Regular.ttf");
			if (fontFile.exists()) {
				Main.customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			} else {
				System.err.println("Font file not found!");
				Main.customFont = new Font("Arial", Font.PLAIN, 22);
			}
			if (Main.customFont != null) {
				java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(Main.customFont);
			}
		} catch (IOException | FontFormatException e) {
			System.err.println("Error loading custom font:");
			e.printStackTrace();
			Main.customFont = new Font("Arial", Font.PLAIN, 22);
		}
		new PowerGridFrame("Power Grid");
    }
}
