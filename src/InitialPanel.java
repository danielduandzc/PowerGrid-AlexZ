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
	
	private BufferedImage titleScreen, gameBackground, redHouse, yellowHouse, greenHouse, blueHouse, purpleHouse, whiteHouse;
	public InitialPanel() {
		
		//Load all images
		try{
            titleScreen = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Base Image.png"));
            gameBackground = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Background.png"));
            redHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Red_House.png"));
            yellowHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Yellow_House.png"));
            greenHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Green_House.png"));
            blueHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Blue_House.png"));
            purpleHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Purple_House.png"));
            whiteHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/White_House.png"));

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
			g.drawImage(titleScreen, 0, 0, 2048,1152,this);
			
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
		} else if (GameState.currentEvent.getLast().equals("Color Selection")) {
			// color selection
			g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
			//Draw the houses
			
			if(!GameState.isZoneSelected[0]) g.drawImage(redHouse, 574, 501, 150, 150, this);
			if(!GameState.isZoneSelected[1]) g.drawImage(yellowHouse, 724, 501,150, 150, this);
			if(!GameState.isZoneSelected[2]) g.drawImage(greenHouse, 874, 501, 150, 150,this);
			if(!GameState.isZoneSelected[3]) g.drawImage(blueHouse, 1024, 501, 150, 150,this);
			if(!GameState.isZoneSelected[4]) g.drawImage(purpleHouse, 1174, 501,150, 150, this);
			if(!GameState.isZoneSelected[5]) g.drawImage(whiteHouse, 1324, 501, 150, 150,this);
			
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
		switch(GameState.currentEvent.getLast()) {
			case "Title Screen":
				if (x >= 1276 && x <= 1816 && y >= 796 && y <= 897) {
					GameState.currentEvent.removeLast(); // Remove title screen
					GameState.currentEvent.add("Instructions");
				}
				break;
			case "Instructions":
				if (x >= 300 && x <= 700 && y >= 350 && y <= 450) {
					GameState.currentEvent.removeLast();
   					GameState.currentEvent.add("Color Selection");
					break;
				}
			case "Color Selection":
				if (x >= 574 && x <= 724 && y >= 501 && y <= 651 && !GameState.isZoneSelected[0]) {
					GameState.isZoneSelected[0] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Red");
					GameState.currentPlayerIndex++;
				} else if (x>=724 && x <= 874 && y >= 501 && y <= 651 && !GameState.isZoneSelected[1]) {
					GameState.isZoneSelected[1] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Yellow");
					GameState.currentPlayerIndex++;
				} else if (x >= 874 && x <= 1024 && y >= 501 && y <= 651 && !GameState.isZoneSelected[2]) {
					GameState.isZoneSelected[2] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Green");
					GameState.currentPlayerIndex++;
				} else if (x >= 1024 && x <= 1174 && y >= 501 && y <= 651 && !GameState.isZoneSelected[3]) {
					GameState.isZoneSelected[3] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Blue");
					GameState.currentPlayerIndex++;
				} else if (x >= 1174 && x <= 1324 && y >= 501 && y <= 651 && !GameState.isZoneSelected[4]) {
					GameState.isZoneSelected[4] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Purple");
					GameState.currentPlayerIndex++;
				} else if (x >= 1324 && x <= 1474 && y >= 501 && y <= 651 && !GameState.isZoneSelected[5]) {
					GameState.isZoneSelected[5] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("White");
					GameState.currentPlayerIndex++;
				}
				
				if(GameState.currentPlayerIndex == 4) {
					GameState.currentEvent.removeLast();
					System.out.println("Player One Color: " + GameState.players[0].getColor());
					System.out.println("Player Two Color: " + GameState.players[1].getColor());
					System.out.println("Player Three Color: " + GameState.players[2].getColor());
					System.out.println("Player Four Color: " + GameState.players[3].getColor());

					GameState.currentEvent.add("Zone Selection");
				}
		repaint();
		
	}
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
