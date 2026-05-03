package src;

import javax.swing.JFrame;

public class PowerGridFrame extends JFrame {
    public PowerGridFrame(String frameName) {
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InitialPanel panel = new InitialPanel();
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
