package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class InitialPanel extends JPanel implements KeyListener, MouseListener {
	private int screenNum = 0; // 0 = title, 1 = instructions, 2 = game 
	public static int numMouseClicks = 0;
	
	private BufferedImage gameBackground;
	public InitialPanel() {
		
		//Load all images
		try{
            gameBackground = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Base Image.png"));
            

        } catch (Exception e){
            System.out.println("No workie because idk 🤷‍♂️");
            System.out.println(e);
        }
		
		try {
			
		} catch (Exception E) {
			
		}
		GameState.currentEvent.add("Title Screen");
		addKeyListener(this);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if (GameState.currentEvent.getLast().equals("Title Screen")) {
			// title screen
			 Font sizedFont = Main.customFont.deriveFont(Font.BOLD, 100f);
			g.setFont(sizedFont);
			g.drawString("POWER GRID", 200, 200);
			g.drawImage(gameBackground, 0, 0, 2048,1152,this);
			
			sizedFont = Main.customFont.deriveFont(Font.PLAIN, 60f);
			g.setFont(sizedFont);
			
			//g.drawImage(gameBackground,1276,796,1816-1276,897-796,this);//Play Button
			//g.drawString("Play", 1470, 897);
		} else if (GameState.currentEvent.getLast().equals("Instructions")) {
			// instructions
			Font sizedFont = Main.customFont.deriveFont(Font.PLAIN, 50f);
			g.setFont(sizedFont);
			
			 sizedFont = Main.customFont.deriveFont(Font.PLAIN, 30f);
			g.setFont(sizedFont);
			g.drawString("1. Click to place power plants.", 100, 200);
			g.drawString("2. Connect cities to power plants.", 100, 250);
			g.drawString("3. Manage resources and expand your grid.", 100, 300);
			g.drawString("Click to Start Game", 300, 400);
		} else if (screenNum == 2) {
			
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		repaint();
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
        int y = e.getY();
		System.out.println("Mouse clicked at: " + x + ", " + y +"\t|"+"Mouse clicks: " + ++numMouseClicks);
		if (GameState.currentEvent.getLast().equals("Title Screen") && x >= 1276 && x <= 1816 && y >= 796 && y <= 897) {
			GameState.currentEvent.removeLast(); // Remove title screen
			GameState.currentEvent.add("Instructions");
			
		} else if (GameState.currentEvent.getLast().equals("Instructions") && x >= 300 && x <= 700 && y >= 350 && y <= 450) {
			 GameState.currentEvent.removeLast();
    GameState.currentEvent.add("Zone Selection");
    
    this.add(new ZoneSelectionPanel()); // Adds the child
    
    this.revalidate(); // Tells Swing the "map" of components changed
    this.repaint();    // Tells Swing to actually draw the change
    return;
		}
		repaint();
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
}
