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
	private Graphics g;
	
	private BufferedImage titleScreen, gameBackground, redHouse, yellowHouse, greenHouse, blueHouse, purpleHouse, whiteHouse, bigBoard, board,
	auctionImagePlayerOne, auctionImagePlayerTwo, auctionImagePlayerThree, auctionImagePlayerFour, arrow;
	private BufferedImage pp3, pp4, pp5, pp6, pp7, pp8, pp9, pp10, pp11, pp12, pp13, pp14, pp15, pp16, pp17, pp18,
	pp19, pp20, pp21, pp22, pp23, pp24, pp25, pp26, pp27, pp28, pp29, pp30, pp31, pp32, pp33, pp34, pp35, pp36, pp37, pp38, pp39, pp40,
	pp42, pp44, pp46, pp50;
	public InitialPanel() {
		
		//Load all images
		try{
			bigBoard = ImageIO.read(PowerGridFrame.class.getResource("/resources/Board.png"));
			board = ImageIO.read(PowerGridFrame.class.getResource("/resources/Cropped Board.png"));
            titleScreen = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Powergrid.png"));
            gameBackground = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Background.png"));
            redHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Red_House.png"));
            yellowHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Yellow_House.png"));
            greenHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Green_House.png"));
            blueHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Blue_House.png"));
            purpleHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Purple_House.png"));
            whiteHouse = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/White_House.png"));
			auctionImagePlayerOne = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Player_1.png"));
			auctionImagePlayerTwo = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Player_2.png"));
			auctionImagePlayerThree = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Player_3.png"));
			auctionImagePlayerFour = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Player_4.png"));
			arrow= ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/Arrow.png"));
			pp3 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/3.jpeg"));
			pp4 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/4.jpeg"));
			pp5 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/5.jpeg"));
			pp6 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/6.jpeg"));
			pp7 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/7.jpeg"));
			pp8 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/8.jpeg"));
			pp9 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/9.jpeg"));
			pp10 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/10.png"));
			pp11 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/11.png"));
			pp12 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/12.jpeg"));
			pp13 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/13.jpeg"));
			pp14 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/14.jpeg"));
			pp15 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/15.jpeg"));
			pp16 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/16.jpeg"));
			pp17 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/17.jpeg"));
			pp18 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/18.jpeg"));
			pp19 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/19.jpeg"));
			pp20 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/20.jpeg"));
			pp21 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/21.jpeg"));
			pp22 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/22.jpeg"));
			pp23 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/23.jpeg"));
			pp24 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/24.jpeg"));
			pp25 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/25.jpeg"));
			pp26 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/26.jpeg"));
			pp27 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/27.jpeg"));
			pp28 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/28.jpeg"));
			pp29 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/29.jpeg"));
			pp30 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/30.jpeg"));
			pp31 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/31.jpeg"));
			pp32 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/32.jpeg"));
			pp33 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/33.jpeg"));
			pp34 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/34.jpeg"));
			pp35 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/35.jpeg"));
			pp36 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/36.jpeg"));
			pp37 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/37.jpeg"));
			pp38 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/38.jpeg"));
			pp39 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/39.jpeg"));
			pp40 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/40.jpeg"));
			pp42 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/42.jpeg"));
			pp44 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/44.jpeg"));
			pp46 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/46.jpeg"));
			pp50 = ImageIO.read(PowerGridFrame.class.getResourceAsStream("/resources/50.jpeg"));

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
		switch(GameState.currentEvent.getLast()) {
			 case "Title Screen":
			// 	// title screen with proper layout
			 	g.drawImage(titleScreen, 0, 0, 2048, 1152, this);
			 	break;
		
			
			case "Color Selection":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				//Draw the houses	
				if(!GameState.isColorSelected[0]) g.drawImage(redHouse, 574, 501, 150, 150, this);
				if(!GameState.isColorSelected[1]) g.drawImage(yellowHouse, 724, 501,150, 150, this);
				if(!GameState.isColorSelected[2]) g.drawImage(greenHouse, 874, 501, 150, 150,this);
				if(!GameState.isColorSelected[3]) g.drawImage(blueHouse, 1024, 501, 150, 150,this);
				if(!GameState.isColorSelected[4]) g.drawImage(purpleHouse, 1174, 501,150, 150, this);
				if(!GameState.isColorSelected[5]) g.drawImage(whiteHouse, 1324, 501, 150, 150,this);
				break;
			case "Zone Selection":
				// zone selection
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.drawImage(bigBoard, getWidth()/4, 0, getWidth()/2, getHeight(), null);
		
		//continue button
		//height: 950
		Font font = new Font("Arial", Font.BOLD, 30);
		g.setFont(font);
		
		g.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
		g.setColor(Color.WHITE);
		g.fillRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
		g.setColor(Color.BLACK);
		
		Graphics2D g2 = (Graphics2D)(g);
		g2.setStroke(new BasicStroke(5));
		g2.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
		
		centerString(g, "Continue", getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
		g2.setStroke(new BasicStroke(15));
			g.setColor(new Color(0, 128, 128));//teal
			g.fillRect(180, 150, 75, 75);
		if(GameState.isZoneSelected[0]){
			g2.setColor(new Color(0,0,0));//black
			g2.drawLine(180, 150, 255, 225);
			g2.drawLine(255, 150, 180, 225);
		}
		
			g.setColor(new Color(255, 165,0));//orange
			g.fillRect(180,250, 75, 75);
		if(GameState.isZoneSelected[1]){
			g2.setColor(new Color(0, 0, 0));//black
			g2.drawLine(180, 250, 255, 325);
			g2.drawLine(255, 250, 180, 325);
		}
		g.setColor(new Color(255, 0, 0));//red
		g.fillRect(180, 350, 75, 75);
		if(GameState.isZoneSelected[2]){
			g2.setColor(new Color(0, 0, 0));//black
			g2.drawLine(180, 350, 255, 425);
			g2.drawLine(255, 350, 180, 425);
		}
		g.setColor(new Color(255,255,0));//yellow
		g.fillRect(180, 450, 75, 75);
		if(GameState.isZoneSelected[3]){
			g2.setColor(new Color(0, 0, 0));//black
			g2.drawLine(180, 450, 255, 525);
			g2.drawLine(255, 450, 180, 525);
		}
		g.setColor(new Color(0, 0, 128));//blue
		g.fillRect(180, 550, 75, 75);
		if(GameState.isZoneSelected[4]){
			g2.setColor(new Color(0, 0, 0));//black
			g2.drawLine(180, 550, 255, 625);
			g2.drawLine(255, 550, 180, 625);
		}
		g.setColor(new Color(128, 0, 128));//purple
		g.fillRect(180, 650, 75, 75);
		if(GameState.isZoneSelected[5]){
			g2.setColor(new Color(0, 0, 0));//black
			g2.drawLine(180, 650, 255, 725);
			g2.drawLine(255, 650, 180, 725);
		}
				break;
			case "Auction":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				    g.drawImage(getPowerPlantImage(GameState.auctionedPowerPlant.getPrice()), 824, 200, 200, 200, this);
					switch(GameState.playerOrder[GameState.currentPlayerIndex]) {
					case 1: g.drawImage(arrow, 220, 500, 250, 200, this); break;
					case 2: g.drawImage(arrow, 620, 500, 250, 200, this); break;
					case 3: g.drawImage(arrow, 1020, 500, 250, 200, this); break;
					case 4: g.drawImage(arrow, 1420, 500, 250, 200, this); break;
					}
					 font = new Font("Arial", Font.BOLD, 30);
					g.setFont(font);

					
					
					g.drawImage(auctionImagePlayerOne, 100, 800, 400, 175, this);
					if(!GameState.players[0].getInAuction()||GameState.players[0].getHasPassed()) {
						Color halfTransparentBlack = new Color(0, 0, 0, 127);
						g.setColor(halfTransparentBlack);
						g.fillRect(100, 800, 400, 175);
					}else{
						g.setColor(Color.BLACK);
						g.drawString(GameState.players[0].getElektro() + " Elektro", 200, 750);
					}
					if(GameState.players[0].getGhostBid() != 0) {
						g.setColor(Color.BLUE);
						if(GameState.players[0].getGhostBid()+GameState.players[0].getBid() > GameState.minBid) {
							g.setColor(new Color(0,100,0));
						}
						if(GameState.players[0].getGhostBid()+GameState.players[0].getBid() <= GameState.minBid ||
							GameState.players[0].getGhostBid()+GameState.players[0].getBid() > GameState.players[0].getElektro()) {
							g.setColor(Color.RED);
						}
					}else {
						g.setColor(Color.BLACK);
					}
					g.drawString((GameState.players[0].getBid() + GameState.players[0].getGhostBid()) + "", 200, 950);
					g.drawImage(auctionImagePlayerTwo, 500, 800, 400, 175, this);
					if(!GameState.players[1].getInAuction()||GameState.players[1].getHasPassed()) {
						Color halfTransparentBlack = new Color(0, 0, 0, 127);
						g.setColor(halfTransparentBlack);
						g.fillRect(500, 800, 400, 175);
					}else{
						g.setColor(Color.BLACK);
						g.drawString(GameState.players[1].getElektro() + " Elektro", 600, 750);
					}
					if(GameState.players[1].getGhostBid() != 0) {
						g.setColor(Color.BLUE);
						if(GameState.players[1].getGhostBid()+GameState.players[1].getBid() > GameState.minBid) {
							g.setColor(new Color(0,100,0));
						}
						if(GameState.players[1].getGhostBid()+GameState.players[1].getBid() <= GameState.minBid ||
							GameState.players[1].getGhostBid()+GameState.players[1].getBid() > GameState.players[1].getElektro()) {
							g.setColor(Color.RED);
						}
					}else {
						g.setColor(Color.BLACK);
					}
					
					g.drawString((GameState.players[1].getBid() + GameState.players[1].getGhostBid()) + "", 600, 950);
					g.drawImage(auctionImagePlayerThree, 900, 800, 400, 175, this);
					if(!GameState.players[2].getInAuction()||GameState.players[2].getHasPassed()) {
						Color halfTransparentBlack = new Color(0, 0, 0, 127);
						g.setColor(halfTransparentBlack);
						g.fillRect(900, 800, 400, 175);
					}else{
						g.setColor(Color.BLACK);
						g.drawString(GameState.players[2].getElektro() + " Elektro", 1000, 750);
					}
					if(GameState.players[2].getGhostBid() != 0) {
						g.setColor(Color.BLUE);
						if(GameState.players[2].getGhostBid()+GameState.players[2].getBid() > GameState.minBid) {
							g.setColor(new Color(0,100,0));
						}
						if(GameState.players[2].getGhostBid()+GameState.players[2].getBid() <= GameState.minBid ||
							GameState.players[2].getGhostBid()+GameState.players[2].getBid() > GameState.players[2].getElektro()) {
							g.setColor(Color.RED);
						}
					}else {
						g.setColor(Color.BLACK);
					}
					g.drawString((GameState.players[2].getBid() + GameState.players[2].getGhostBid()) + "", 1000, 950);
					g.drawImage(auctionImagePlayerFour, 1300, 800, 400, 175, this);
					if(!GameState.players[3].getInAuction()||GameState.players[3].getHasPassed()) {
						Color halfTransparentBlack = new Color(0, 0, 0, 127);
						g.setColor(halfTransparentBlack);
						g.fillRect(1300, 800, 400, 175);
					}else{
						g.setColor(Color.BLACK);
						g.drawString(GameState.players[3].getElektro() + " Elektro", 1400, 750);
					}
				
					if(GameState.players[3].getGhostBid() != 0) {
						g.setColor(Color.BLUE);
						if(GameState.players[3].getGhostBid()+GameState.players[3].getBid() > GameState.minBid) {
							g.setColor(new Color(0,100,0));
						}
						if(GameState.players[3].getGhostBid()+GameState.players[3].getBid() <= GameState.minBid ||
							GameState.players[3].getGhostBid()+GameState.players[3].getBid() > GameState.players[3].getElektro()) {
							g.setColor(Color.RED);
						}
					}else {
						g.setColor(Color.BLACK);
					}
					g.drawString((GameState.players[3].getBid() + GameState.players[3].getGhostBid()) + "", 1400, 950);
			break;
			case "Pick Powerplant":
				/*	
					First powerplant is at 175 150. 150x150. each has 50 pixels between them.

					Powerplant 1: 175,150 to 325,300
					Powerplant 2: 225,150 to 375,300
					Powerplant 3: 275,150 to 425,300
					Powerplant 4: 325,150 to 475,300

					Powerplant 5: 175,350 to 325,400
					Powerplant 6: 225,350 to 375,400
					Powerplant 7: 275,350 to 425,400
					Powerplant 8: 325,350 to 475,400
					
					
					*/
					System.out.println("works");
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Font sizedFont;
				sizedFont = Main.customFont.deriveFont(Font.PLAIN, 50f);
			g.setFont(sizedFont);
			
			 sizedFont = Main.customFont.deriveFont(Font.PLAIN, 30f);
				sizedFont = Main.customFont.deriveFont(Font.BOLD, 100f);
				g.setFont(sizedFont);
				g.drawString("Player " + ((GameState.playerOrderInAuction.get(0)) + 1) + " Pick a Power Plant", 100, 900);
				for(int i=0;i<4;i++){
					g.drawImage(getPowerPlantImage(GameState.powerPlantsInMarket.get(i).getPrice()), 175 + i * 200, 150, 150, 150, this);
				}
				for(int i=0;i<4;i++){
					g.drawImage(getPowerPlantImage(GameState.powerPlantsInMarket.get(i+4).getPrice()), 175 + i * 200, 350, 150, 150, this);
				}

		}
	}
	public void centerString(Graphics g, String text, int xRect, int yRect, int rectWidth, int rectHeight) {
	    // Get the FontMetrics
	    FontMetrics fm = g.getFontMetrics();
	    // Calculate the center x coordinate
	    int textWidth = fm.stringWidth(text);
	    int x = xRect + (rectWidth - textWidth) / 2;
	    // Calculate the center y coordinate (considering ascent and descent for true vertical center)
	    // getAscent() is the distance from the baseline to the top of the characters.
	    // getHeight() is the total height of the font (ascent + descent + leading).
	    // A common method for visual centering uses getAscent():
	    int y = yRect + ((rectHeight - fm.getHeight()) / 2) + fm.getAscent();
	    // Draw the string
	    g.drawString(text, x, y);
	}

	private BufferedImage getPowerPlantImage(int powerPlantNumber) {
		switch(powerPlantNumber) {
			case 3: return pp3;
			case 4: return pp4;
			case 5: return pp5;
			case 6: return pp6;
			case 7: return pp7;
			case 8: return pp8;
			case 9: return pp9;
			case 10: return pp10;
			case 11: return pp11;
			case 12: return pp12;
			case 13: return pp13;
			case 14: return pp14;
			case 15: return pp15;
			case 16: return pp16;
			case 17: return pp17;
			case 18: return pp18;
			case 19: return pp19;
			case 20: return pp20;
			case 21: return pp21;
			case 22: return pp22;
			case 23: return pp23;
			case 24: return pp24;
			case 25: return pp25;
			case 26: return pp26;
			case 27: return pp27;
			case 28: return pp28;
			case 29: return pp29;
			case 30: return pp30;
			case 31: return pp31;
			case 32: return pp32;
			case 33: return pp33;
			case 34: return pp34;
			case 35: return pp35;
			case 36: return pp36;
			case 37: return pp37;
			case 38: return pp38;
			case 39: return pp39;
			case 40: return pp40;
			case 42: return pp42;
			case 44: return pp44;
			case 46: return pp46;
			case 50: return pp50; 
			
		}
		return null; // default case, should not happen if input is valid
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
		Graphics g = getGraphics();
		int x = e.getX();
        int y = e.getY();
		System.out.println("Mouse clicked at: " + x + ", " + y +"\t|\t"+"Mouse clicks: " + ++numMouseClicks);
		switch(GameState.currentEvent.getLast()) {
			case "Title Screen":
				// Check if Play button was clicked
				if (x >= 1280 && x <= 1800 && y >= 800 && y <= 900) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Color Selection");
					repaint();
				}
				// Check if Rules button was clicked
				else if (x >= 1280 && x <= 1800 && y >= 950 && y <= 1050) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Color Selection");
					repaint();
				}
				break;
			
			case "Instructions":
				if (x >= 300 && x <= 700 && y >= 350 && y <= 450) {
					GameState.currentEvent.removeLast();
   					GameState.currentEvent.add("Color Selection");
					repaint();
				}
				break;
			case "Color Selection":
				if (x >= 574 && x <= 724 && y >= 501 && y <= 651 && !GameState.isColorSelected[0]) {
					GameState.isColorSelected[0] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Red");
					GameState.currentPlayerIndex++;
				} else if (x>=724 && x <= 874 && y >= 501 && y <= 651 && !GameState.isColorSelected[1]) {
					GameState.isColorSelected[1] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Yellow");
					GameState.currentPlayerIndex++;
				} else if (x >= 874 && x <= 1024 && y >= 501 && y <= 651 && !GameState.isColorSelected[2]) {
					GameState.isColorSelected[2] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Green");
					GameState.currentPlayerIndex++;
				} else if (x >= 1024 && x <= 1174 && y >= 501 && y <= 651 && !GameState.isColorSelected[3]) {
					GameState.isColorSelected[3] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Blue");
					GameState.currentPlayerIndex++;
				} else if (x >= 1174 && x <= 1324 && y >= 501 && y <= 651 && !GameState.isColorSelected[4]) {
					GameState.isColorSelected[4] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("Purple");
					GameState.currentPlayerIndex++;
				} else if (x >= 1324 && x <= 1474 && y >= 501 && y <= 651 && !GameState.isColorSelected[5]) {
					GameState.isColorSelected[5] = true;
					GameState.players[GameState.currentPlayerIndex].setColor("White");
					GameState.currentPlayerIndex++;
				}
				
				if(GameState.currentPlayerIndex == 4) {
					GameState.currentEvent.removeLast();
					System.out.println("Player One Color: " + GameState.players[0].getColor());
					System.out.println("Player Two Color: " + GameState.players[1].getColor());
					System.out.println("Player Three Color: " + GameState.players[2].getColor());
					System.out.println("Player Four Color: " + GameState.players[3].getColor());
					GameState.currentPlayerIndex = 0;
					GameState.currentEvent.add("Zone Selection");
				}
				repaint();
				break;
			case "Zone Selection":
				if(x>=180 && x <= 255 && y >= 150 && y <= 225 && !GameState.isZoneSelected[0]) {
					GameState.isZoneSelected[0] = true;
					GameState.currentPlayerIndex++;
				} else if(x >= 180 && x <= 255 && y >= 250 && y <= 325 && !GameState.isZoneSelected[1]) {
					GameState.isZoneSelected[1] = true;
					GameState.currentPlayerIndex++;
				} else if(x >= 180 && x <= 255 && y >= 350 && y <= 425 && !GameState.isZoneSelected[2]) {
					GameState.isZoneSelected[2] = true;
					GameState.currentPlayerIndex++;
				} else if(x >= 180 && x <= 255 && y >= 450 && y <= 525 && !GameState.isZoneSelected[3]) {
					GameState.isZoneSelected[3] = true;
					GameState.currentPlayerIndex++;
				} else if(x >= 180 && x <= 255 && y >= 550 && y <= 625 && !GameState.isZoneSelected[4]) {
					GameState.isZoneSelected[4] = true;
					GameState.currentPlayerIndex++;
				} else if(x >= 180 && x <= 255 && y >= 650 && y <= 725 && !GameState.isZoneSelected[5]) {
					GameState.isZoneSelected[5] = true;
					GameState.currentPlayerIndex++;
				}
				if(GameState.currentPlayerIndex == 4) {
					x=0;
					y=0;
					GameState.currentEvent.removeLast();
					GameState.currentPlayerIndex = 0;
					GameState.setUpAuction();
				}

		repaint();
				case "Pick Powerplant":
					// code for picking power plant
					/*	
					First powerplant is at 175 150. 150x150. each has 50 pixels between them.

					Powerplant 1: 175,150 to 325,300
					Powerplant 2: 225,150 to 375,300
					Powerplant 3: 275,150 to 425,300
					Powerplant 4: 325,150 to 475,300

					Powerplant 5: 175,350 to 325,400
					Powerplant 6: 225,350 to 375,400
					Powerplant 7: 275,350 to 425,400
					Powerplant 8: 325,350 to 475,400
					
					
					*/
				if (y >= 150 && y <= 300) {

				if (x >= 175 && x <= 325) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(0);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				GameState.currentEvent.removeLast();
				GameState.currentEvent.add("Auction");

				} else if (x >= 375 && x <= 525) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(1);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				GameState.currentEvent.removeLast();
				GameState.currentEvent.add("Auction");

				} else if (x >= 575 && x <= 725) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(2);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				GameState.currentEvent.removeLast();
				GameState.currentEvent.add("Auction");

				} else if (x >= 775 && x <= 925) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(3);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				GameState.currentEvent.removeLast();
				GameState.currentEvent.add("Auction");
				}
				
			}
					repaint();
					break;
				case "Auction":
					if(y>=840&&y<=880)
						if(x>=300&&x<=475) {
							//GameState.currentEvent.add("View Player One Profile");
						} else if(x>=710&&x<=885) {
							//GameState.currentEvent.add("View Player Two Profile");
						} else if(x>=1100&&x<=1275) {
							//GameState.currentEvent.add("View Player Three Profile");
						} else if(x>=1500&&x<=1675) {
							//GameState.currentEvent.add("View Player Four Profile");
						}
					if(y>=920&&y<=970){
						if(x>=100&&x<=100+50) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==1) {
							GameState.players[GameState.currentPlayerIndex].setGhostBid(GameState.players[GameState.currentPlayerIndex].getGhostBid()+1);
							}
						}else if(x>=250&&x<=250+50) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==1) {
							GameState.players[GameState.currentPlayerIndex].setGhostBid(GameState.players[GameState.currentPlayerIndex].getGhostBid()-1);
							}
						}else if(x>=320&&x<=320+80) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==1) {
							GameState.players[GameState.currentPlayerIndex].setHasPassed(true);
							GameState.players[GameState.currentPlayerIndex].setBid(0);
							GameState.players[GameState.currentPlayerIndex].setGhostBid(0);
							GameState.continueAuction();
							repaint();

							}
						}else if(x>=410&&x<=410+70) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==1) {
							if(GameState.players[GameState.currentPlayerIndex].getGhostBid()+ GameState.players[GameState.currentPlayerIndex].getBid() > GameState.minBid){
								GameState.players[GameState.currentPlayerIndex].useGhostBid();
								GameState.continueAuction();
							}
						}
						}else if(x>=500&&x<=500+50) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==2) {
							GameState.players[GameState.currentPlayerIndex].setGhostBid(GameState.players[GameState.currentPlayerIndex].getGhostBid()+1);
							}
						}else if(x>=650&&x<=650+50) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==2) {
							GameState.players[GameState.currentPlayerIndex].setGhostBid(GameState.players[GameState.currentPlayerIndex].getGhostBid()-1);
							}
						}else if(x>=720&&x<=720+80) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==2) {
							GameState.players[GameState.currentPlayerIndex].setHasPassed(true);
							GameState.players[GameState.currentPlayerIndex].setBid(0);
							GameState.players[GameState.currentPlayerIndex].setGhostBid(0);
							GameState.continueAuction();
							repaint();
							}
						}else if(x>=810&&x<=810+70) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==2) {
							if(GameState.players[GameState.currentPlayerIndex].getGhostBid()+ GameState.players[GameState.currentPlayerIndex].getBid() > GameState.minBid){
								GameState.players[GameState.currentPlayerIndex].useGhostBid();
								GameState.continueAuction();
							}
							}
						}else if(x>=900&&x<=900+50) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==3) {
							GameState.players[GameState.currentPlayerIndex].setGhostBid(GameState.players[GameState.currentPlayerIndex].getGhostBid()+1);
							}
						}else if(x>=1050&&x<=1050+50) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==3) {
							GameState.players[GameState.currentPlayerIndex].setGhostBid(GameState.players[GameState.currentPlayerIndex].getGhostBid()-1);
							}
						}else if(x>=1120&&x<=1120+80) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==3) {
							GameState.players[GameState.currentPlayerIndex].setHasPassed(true);
							GameState.players[GameState.currentPlayerIndex].setBid(0);
							GameState.players[GameState.currentPlayerIndex].setGhostBid(0);
							GameState.continueAuction();
							repaint();
							}
						}else if(x>=1210&&x<=1210+70) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==3) {
							if(GameState.players[GameState.currentPlayerIndex].getGhostBid()+ GameState.players[GameState.currentPlayerIndex].getBid() > GameState.minBid){
								GameState.players[GameState.currentPlayerIndex].useGhostBid();
								GameState.continueAuction();
							}
							}
						}else if(x>=1300&&x<=1300+50) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==4) {
							GameState.players[GameState.currentPlayerIndex].setGhostBid(GameState.players[GameState.currentPlayerIndex].getGhostBid()+1);
							}
						}else if(x>=1450&&x<=1450+50) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==4) {
							GameState.players[GameState.currentPlayerIndex].setGhostBid(GameState.players[GameState.currentPlayerIndex].getGhostBid()-1);
							}
						}else if(x>=1520&&x<=1520+80) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==4) {
							GameState.players[GameState.currentPlayerIndex].setHasPassed(true);
							GameState.players[GameState.currentPlayerIndex].setBid(0);
							GameState.players[GameState.currentPlayerIndex].setGhostBid(0);
							GameState.continueAuction();
							repaint();
							}
						}else if(x>=1610&&x<=1610+70) {
							if(GameState.players[GameState.currentPlayerIndex].getInAuction()&&GameState.playerOrder[GameState.currentPlayerIndex]==4) {
							if(GameState.players[GameState.currentPlayerIndex].getGhostBid()+ GameState.players[GameState.currentPlayerIndex].getBid() > GameState.minBid){
								GameState.players[GameState.currentPlayerIndex].useGhostBid();
								GameState.continueAuction();
							}
							}
						}
						
					}
				
			
				repaint();
				break;
		
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
