package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ZoneSelectionPanel extends JPanel MouseListener { 
	public static int numMouseClicks = 0;
	private static GameState state;
	private BufferedImage gameBackground, redHouse, yellowHouse, greenHouse, blueHouse, purpleHouse, whiteHouse;
    
	public PowerGridPanel(GameState gs) {
		state=gs;
		//Load all images
		try{
            gameBackground = ImageIO.read(PowerGrid.class.getResourceAsStream("/resources/Background.png"));
            redHouse = ImageIO.read(PowerGrid.class.getResourceAsStream("/resources/Red_House.png"));
            yellowHouse = ImageIO.read(PowerGrid.class.getResourceAsStream("/resources/Yellow_House.png"));
            greenHouse = ImageIO.read(PowerGrid.class.getResourceAsStream("/resources/Green_House.png"));
            blueHouse = ImageIO.read(PowerGrid.class.getResourceAsStream("/resources/Blue_House.png"));
            purpleHouse = ImageIO.read(PowerGrid.class.getResourceAsStream("/resources/Purple_House.png"));
            whiteHouse = ImageIO.read(PowerGrid.class.getResourceAsStream("/resources/White_House.png"));
            

        } catch (Exception e){
            System.out.println("No workie because idk 🤷‍♂️");
            System.out.println(e);
        }
		
		try {
			
		} catch (Exception E) {
			
		}
		
		
		addMouseListener(this);
	}
    public void paint(Graphics g) {
       
            
        
        super.paint(g);
         if(state.currentEvent.peek().equals("Zone Selection")) {
            g.drawImage(gameBackground, 0, 0, this);
            //Draw the houses
            g.drawImage(redHouse, 100, 100, this);
            g.drawImage(yellowHouse, 200, 100, this);
            g.drawImage(greenHouse, 300, 100, this);
            g.drawImage(blueHouse, 400, 100, this);
            g.drawImage(purpleHouse, 500, 100, this);
            g.drawImage(whiteHouse, 600, 100, this);
        }
    }
}
	