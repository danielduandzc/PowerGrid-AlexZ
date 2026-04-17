//package src;
import javax.swing.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
		// Load the font
		try {
			File fontFile = new File("resources/Bungee-Regular.ttf");
			if (fontFile.exists()) {
				Main.customFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile));
			} else {
				InputStream is = PowerGridFrame.class.getResourceAsStream("/resources/Bungee-Regular.ttf");
				if (is != null) {
					Main.customFont = Font.createFont(Font.TRUETYPE_FONT, is);
				} else {
					System.err.println("Font file not found!");
				}
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
