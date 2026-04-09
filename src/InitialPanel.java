package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.geom.RoundRectangle2D;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class InitialPanel extends JPanel implements KeyListener, MouseListener {
	private int screenNum = 0; // 0 = title, 1 = instructions, 2 = game 
	public static int numMouseClicks = 0;
	private Graphics g;
	
	private BufferedImage titleScreen, gameBackground, redHouse, yellowHouse, greenHouse, blueHouse, purpleHouse, whiteHouse, bigBoard, board,
	auctionImagePlayerOne, auctionImagePlayerTwo, auctionImagePlayerThree, auctionImagePlayerFour;
	public InitialPanel() {
		
		//Load all images
		try{
			bigBoard = ImageIO.read(new File("resources/Board.png"));
			board = ImageIO.read(new File("resources/Cropped Board.png"));
            titleScreen = ImageIO.read(new File("resources/Powergrid.png"));
            gameBackground = ImageIO.read(new File("resources/Background.png"));
            redHouse = ImageIO.read(new File("resources/Red_House.png"));
            yellowHouse = ImageIO.read(new File("resources/Yellow_House.png"));
            greenHouse = ImageIO.read(new File("resources/Green_House.png"));
            blueHouse = ImageIO.read(new File("resources/Blue_House.png"));
            purpleHouse = ImageIO.read(new File("resources/Purple_House.png"));
            whiteHouse = ImageIO.read(new File("resources/White_House.png"));
			auctionImagePlayerOne = ImageIO.read(new File("resources/Player_1.png"));
			auctionImagePlayerTwo = ImageIO.read(new File("resources/Player_2.png"));
			auctionImagePlayerThree = ImageIO.read(new File("resources/Player_3.png"));
			auctionImagePlayerFour = ImageIO.read(new File("resources/Player_4.png"));

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
				// title screen with proper layout
				drawTitleScreen(g);
				break;
			case "Rules":
				drawRulesScreen(g);
				break;
			case "Instructions":
				Font sizedFont;
				sizedFont = Main.customFont.deriveFont(Font.PLAIN, 50f);
			g.setFont(sizedFont);
			
			 sizedFont = Main.customFont.deriveFont(Font.PLAIN, 30f);
			g.setFont(sizedFont);
			g.drawString("1. Click to place power plants.", 100, 200);
			g.drawString("2. Connect cities to power plants.", 100, 250);
			g.drawString("3. Manage resources and expand your grid.", 100, 300);
			g.drawString("Click to Start Game", 300, 400);
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
					g.drawImage(auctionImagePlayerOne, 100, 800, 400, 175, this);
					g.drawImage(auctionImagePlayerTwo, 500, 800, 400, 175, this);
					g.drawImage(auctionImagePlayerThree, 900, 800, 400, 175, this);
					g.drawImage(auctionImagePlayerFour, 1300, 800, 400, 175, this);
			break;

		}
	}
	
	private void drawTitleScreen(Graphics g) {
		// Draw background (scaled to fit properly maintaining aspect ratio)
		if (titleScreen != null) {
			int imgW = titleScreen.getWidth();
			int imgH = titleScreen.getHeight();
			double scale = Math.min((double) getWidth() / imgW, (double) getHeight() / imgH);
			int newW = (int) (imgW * scale);
			int newH = (int) (imgH * scale);
			int x = (getWidth() - newW) / 2;
			int y = (getHeight() - newH) / 2;
			g.drawImage(titleScreen, x, y, newW, newH, this);
		} else {
			g.setColor(new Color(30, 60, 120)); // Dark blue background fallback
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	private void drawRulesScreen(Graphics g) {
		// Fill background
		g.setColor(new Color(20, 40, 80));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw title
		Font titleFont = Main.customFont.deriveFont(Font.BOLD, 60f);
		g2.setFont(titleFont);
		g2.setColor(Color.WHITE);
		String title = "RULES";
		FontMetrics fm = g2.getFontMetrics();
		int titleX = (getWidth() - fm.stringWidth(title)) / 2;
		g2.drawString(title, titleX, 80);
		
		// Draw rules text
		Font ruleFont = Main.customFont.deriveFont(Font.PLAIN, 24f);
		g2.setFont(ruleFont);
		g2.setColor(new Color(200, 220, 255));
		
		int startY = 150;
		int lineHeight = 50;
		String[] rules = {
			"1. Click to place power plants in different cities",
			"2. Connect cities to your power plants to generate income",
			"3. Manage resources (coal, oil, uranium, etc.) wisely",
			"4. Expand your network to cover more cities than opponents",
			"5. Outbid other players in auctions to get better plants",
			"6. First to 17 cities wins the game!"
		};
		
		for (int i = 0; i < rules.length; i++) {
			g2.drawString(rules[i], 100, startY + (i * lineHeight));
		}
		
		// Draw back button
		int buttonWidth = 150;
		int buttonHeight = 70;
		int backButtonX = getWidth() / 2 - buttonWidth / 2;
		int backButtonY = getHeight() - 120;
		drawButton(g2, backButtonX, backButtonY, buttonWidth, buttonHeight, "Back", new Color(150, 80, 80), new Color(100, 40, 40));
		
		// Store button coordinates for click detection
		GameState.backButtonBounds = new Rectangle(backButtonX, backButtonY, buttonWidth, buttonHeight);
	}
	
	private void drawButton(Graphics2D g, int x, int y, int width, int height, String label, Color primaryColor, Color borderColor) {
		// Draw button background
		g.setColor(primaryColor);
		g.fillRoundRect(x, y, width, height, 15, 15);
		
		// Draw button border
		g.setColor(borderColor);
		g.setStroke(new BasicStroke(3));
		g.drawRoundRect(x, y, width, height, 15, 15);
		
		// Draw button text
		Font buttonFont = Main.customFont.deriveFont(Font.BOLD, 32f);
		g.setFont(buttonFont);
		g.setColor(Color.WHITE);
		FontMetrics fm = g.getFontMetrics();
		int textX = x + (width - fm.stringWidth(label)) / 2;
		int textY = y + ((height - fm.getHeight()) / 2) + fm.getAscent();
		g.drawString(label, textX, textY);
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
				if (x >= 1212 && x <= 1680 && y >= 735 && y <= 819) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Color Selection");
					repaint();
				}
				// Check if Rules button was clicked
				else if (x >= 1212 && x <= 1680 && y >= 860 && y <= 940) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Rules");
					repaint();
				}
				break;
			case "Rules":
				// Check if Back button was clicked
				if (GameState.backButtonBounds != null && GameState.backButtonBounds.contains(x, y)) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Title Screen");
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
					GameState.currentEvent.removeLast();
					GameState.currentPlayerIndex = 0;
					GameState.currentEvent.add("Auction");
				}
				repaint();
				break;
			case "Auction":
				if(y>=840&&y<=880) {
					if(x>=300&&x<=475) {
						//GameState.currentEvent.add("View Player One Profile");
					} else if(x>=710&&x<=885) {
						//GameState.currentEvent.add("View Player Two Profile");
					} else if(x>=1100&&x<=1275) {
						//GameState.currentEvent.add("View Player Three Profile");
					} else if(x>=1500&&x<=1675) {
						//GameState.currentEvent.add("View Player Four Profile");
					}
				}
				if(y>=920&&y<=970) {
					if(GameState.players[GameState.currentPlayerIndex].getInAuction()) {
						
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
