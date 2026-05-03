package src;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.SwingUtilities;

public class Main {
    public static Font customFont = new Font("SansSerif", Font.PLAIN, 22);

    public static void main(String[] args) {
        loadCustomFont();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerGridFrame("Power Grid");
            }
        });
    }

    private static void loadCustomFont() {
        try {
            File fontFile = new File("resources/Bungee-Regular.ttf");
            if (fontFile.exists()) {
                customFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile));
            } else {
                InputStream stream = Main.class.getResourceAsStream("/resources/Bungee-Regular.ttf");
                if (stream != null) {
                    customFont = Font.createFont(Font.TRUETYPE_FONT, stream);
                }
            }
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(customFont);
        } catch (IOException | FontFormatException exception) {
            customFont = new Font("SansSerif", Font.PLAIN, 22);
        }
    }
}
