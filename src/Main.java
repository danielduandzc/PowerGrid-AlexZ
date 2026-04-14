package src;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JLabel;
public class Main {
	public static Font customFont = null;
	public static void main(String[] args) {
		 // 1. Load the font
        GameState.players[0] = new Player();
       
        GameState.players[1] = new Player();
        
        GameState.players[2] = new Player();
       
        GameState.players[3] = new Player();
        
        try {
            // Try to load from resources directory first
            File fontFile = new File("resources/Bungee-Regular.ttf");
            if (fontFile.exists()) {
                customFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile));
            } else {
                // Try loading from classpath/JAR
                InputStream is = Main.class.getResourceAsStream("/resources/Bungee-Regular.ttf");
                if (is != null) {
                    customFont = Font.createFont(Font.TRUETYPE_FONT, is);
                } else {
                    System.err.println("Font file not found!");
                }
            }
            
            // Register the font with the GraphicsEnvironment
            if (customFont != null) {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(customFont);
            }
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading custom font:");
            e.printStackTrace();
            // Fallback to default font
            customFont = new Font("Arial", Font.PLAIN, 22);
        }

        // 3. Use the font in a Swing component
        if (customFont != null) {
            // Derive a new font with the desired size (e.g., 22f)
            Font sizedFont = customFont.deriveFont(Font.PLAIN, 22f);
            JLabel label = new JLabel("Hello, Custom Font!");
            label.setFont(sizedFont);
        }
        GameState.setUpDeckAndMarket();
		new PowerGridFrame("Power Grid!!!");
    }
		
	}


