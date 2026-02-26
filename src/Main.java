package src;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JLabel;
public class Main {
	public static Font customFont = null;
	public static void main(String[] args) {
		 // 1. Load the font
        try {
            // Use getResourceAsStream for easy deployment within a JAR
            InputStream is = Main.class.getResourceAsStream("/resources/Bungee-Regular.ttf");
            if (is != null) {
                customFont = Font.createFont(Font.TRUETYPE_FONT, is);
                // 2. Register the font with the GraphicsEnvironment
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(customFont);
            } else {
                System.err.println("Font file not found in resources!");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // 3. Use the font in a Swing component
        if (customFont != null) {
            // Derive a new font with the desired size (e.g., 22f)
            Font sizedFont = customFont.deriveFont(Font.PLAIN, 22f);
            JLabel label = new JLabel("Hello, Custom Font!");
            label.setFont(sizedFont);

           
        }
		PowerGrid graphicWindow = new PowerGrid("Power Grid!!!");
    }
		
	}


