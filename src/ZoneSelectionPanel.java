package src;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ZoneSelectionPanel extends JPanel implements MouseListener { 
	public static int numMouseClicks = 0;

	private BufferedImage gameBackground, redHouse, yellowHouse, greenHouse, blueHouse, purpleHouse, whiteHouse;
    
	public ZoneSelectionPanel() {
	
		//Load all images
		try{
            gameBackground = ImageIO.read(ZoneSelectionPanel.class.getResourceAsStream("/resources/Background.png"));
            redHouse = ImageIO.read(ZoneSelectionPanel.class.getResourceAsStream("/resources/Red_House.png"));
            yellowHouse = ImageIO.read(ZoneSelectionPanel.class.getResourceAsStream("/resources/Yellow_House.png"));
            greenHouse = ImageIO.read(ZoneSelectionPanel.class.getResourceAsStream("/resources/Green_House.png"));
            blueHouse = ImageIO.read(ZoneSelectionPanel.class.getResourceAsStream("/resources/Blue_House.png"));
            purpleHouse = ImageIO.read(ZoneSelectionPanel.class.getResourceAsStream("/resources/Purple_House.png"));
            whiteHouse = ImageIO.read(ZoneSelectionPanel.class.getResourceAsStream("/resources/White_House.png"));
            

        } catch (Exception e){
            System.out.println("No workie because idk 🤷‍♂️");
            System.out.println(e);
        }
		
		try {
			
		} catch (Exception E) {
			
		}
		
		
		addMouseListener(this);
        repaint();
	}
    @Override
    public void paint(Graphics g) {
       
            
        
        super.paint(g);
         if(GameState.currentEvent.getLast().equals("Zone Selection")) {
            g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
            //Draw the houses
            g.drawImage(redHouse, 100, 100, 100, 100, this);
            g.drawImage(yellowHouse, 200, 100,100, 100, this);
            g.drawImage(greenHouse, 300, 100, 100, 100,this);
            g.drawImage(blueHouse, 400, 100, 100, 100,this);
            g.drawImage(purpleHouse, 500, 100,100, 100, this);
            g.drawImage(whiteHouse, 600, 100, 100, 100,this);
            
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        numMouseClicks++;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("GHJ clicked at: " + x + ", " + y +"\t|"+"Mouse clicks: " + ++numMouseClicks);
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
	