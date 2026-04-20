//package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class InitialPanel extends JPanel implements KeyListener, MouseListener {
	private HashMap<String, Point> cityCoords = new HashMap<>();

private void loadCityCoordinates() {
    
    cityCoords.put("Flensburg", new Point((int)(getWidth() * (867 / 2048.0)), (int)(getHeight() * (36 / 1152.0))));
    cityCoords.put("Kiel", new Point((int)(getWidth() * (918 / 2048.0)), (int)(getHeight() * (101 / 1152.0))));
    cityCoords.put("Rostock", new Point((int)(getWidth() * (1114 / 2048.0)), (int)(getHeight() * (122 / 1152.0))));
    cityCoords.put("Lubeck", new Point((int)(getWidth() * (989 / 2048.0)), (int)(getHeight() * (146 / 1152.0))));
    cityCoords.put("Cuxhaven", new Point((int)(getWidth() * (802 / 2048.0)), (int)(getHeight() * (163 / 1152.0))));
    cityCoords.put("Wilhelmshaven", new Point((int)(getWidth() * (736 / 2048.0)), (int)(getHeight() * (203 / 1152.0))));
    cityCoords.put("Hamburg", new Point((int)(getWidth() * (913 / 2048.0)), (int)(getHeight() * (203 / 1152.0))));
    cityCoords.put("Schwerin", new Point((int)(getWidth() * (1053 / 2048.0)), (int)(getHeight() * (206 / 1152.0))));
    cityCoords.put("Torgelow", new Point((int)(getWidth() * (1294 / 2048.0)), (int)(getHeight() * (198 / 1152.0))));
    cityCoords.put("Bremen", new Point((int)(getWidth() * (818 / 2048.0)), (int)(getHeight() * (266 / 1152.0))));
    cityCoords.put("Berlin", new Point((int)(getWidth() * (1236 / 2048.0)), (int)(getHeight() * (331 / 1152.0))));
    cityCoords.put("Osnabruck", new Point((int)(getWidth() * (747 / 2048.0)), (int)(getHeight() * (344 / 1152.0))));
    cityCoords.put("Hannover", new Point((int)(getWidth() * (919 / 2048.0)), (int)(getHeight() * (360 / 1152.0))));
    cityCoords.put("Magdeburg", new Point((int)(getWidth() * (1092 / 2048.0)), (int)(getHeight() * (367 / 1152.0))));
    cityCoords.put("Frankfurt-O", new Point((int)(getWidth() * (1336 / 2048.0)), (int)(getHeight() * (358 / 1152.0))));
    cityCoords.put("Munster", new Point((int)(getWidth() * (694 / 2048.0)), (int)(getHeight() * (405 / 1152.0))));
    cityCoords.put("Duisburg", new Point((int)(getWidth() * (559 / 2048.0)), (int)(getHeight() * (432 / 1152.0))));
    cityCoords.put("Essen", new Point((int)(getWidth() * (623 / 2048.0)), (int)(getHeight() * (446 / 1152.0))));
    cityCoords.put("Dortmund", new Point((int)(getWidth() * (710 / 2048.0)), (int)(getHeight() * (475 / 1152.0))));
    cityCoords.put("Halle", new Point((int)(getWidth() * (869 / 2048.0)), (int)(getHeight() * (492 / 1152.0))));
    cityCoords.put("Kassel", new Point((int)(getWidth() * (869 / 2048.0)), (int)(getHeight() * (490 / 1152.0))));
    cityCoords.put("Leipzig", new Point((int)(getWidth() * (1165 / 2048.0)), (int)(getHeight() * (491 / 1152.0))));
    cityCoords.put("Dusseldorf", new Point((int)(getWidth() * (577 / 2048.0)), (int)(getHeight() * (504 / 1152.0))));
    cityCoords.put("Erfurt", new Point((int)(getWidth() * (1038 / 2048.0)), (int)(getHeight() * (535 / 1152.0))));
    cityCoords.put("Dresden", new Point((int)(getWidth() * (1297 / 2048.0)), (int)(getHeight() * (533 / 1152.0))));
    cityCoords.put("Koln", new Point((int)(getWidth() * (642 / 2048.0)), (int)(getHeight() * (552 / 1152.0))));
    cityCoords.put("Aachen", new Point((int)(getWidth() * (548 / 2048.0)), (int)(getHeight() * (570 / 1152.0))));
    cityCoords.put("Fulda", new Point((int)(getWidth() * (916 / 2048.0)), (int)(getHeight() * (589 / 1152.0))));
    cityCoords.put("Frankfurt-M", new Point((int)(getWidth() * (814 / 2048.0)), (int)(getHeight() * (629 / 1152.0))));
    cityCoords.put("Wiesbaden", new Point((int)(getWidth() * (750 / 2048.0)), (int)(getHeight() * (652 / 1152.0))));
    cityCoords.put("Trier", new Point((int)(getWidth() * (586 / 2048.0)), (int)(getHeight() * (692 / 1152.0))));
    cityCoords.put("Wurzburg", new Point((int)(getWidth() * (934 / 2048.0)), (int)(getHeight() * (687 / 1152.0))));
    cityCoords.put("Nurnberg", new Point((int)(getWidth() * (1043 / 2048.0)), (int)(getHeight() * (725 / 1152.0))));
    cityCoords.put("Mannheim", new Point((int)(getWidth() * (804 / 2048.0)), (int)(getHeight() * (746 / 1152.0))));
    cityCoords.put("Saarbrucken", new Point((int)(getWidth() * (671 / 2048.0)), (int)(getHeight() * (771 / 1152.0))));
    cityCoords.put("Regensburg", new Point((int)(getWidth() * (1124 / 2048.0)), (int)(getHeight() * (789 / 1152.0))));
    cityCoords.put("Stuttgart", new Point((int)(getWidth() * (837 / 2048.0)), (int)(getHeight() * (828 / 1152.0))));
    cityCoords.put("Augsburg", new Point((int)(getWidth() * (998 / 2048.0)), (int)(getHeight() * (856 / 1152.0))));
    cityCoords.put("Passau", new Point((int)(getWidth() * (1272 / 2048.0)), (int)(getHeight() * (849 / 1152.0))));
    cityCoords.put("Freiburg", new Point((int)(getWidth() * (712 / 2048.0)), (int)(getHeight() * (916 / 1152.0))));
    cityCoords.put("Munchen", new Point((int)(getWidth() * (1095 / 2048.0)), (int)(getHeight() * (910 / 1152.0))));
    cityCoords.put("Konstanz", new Point((int)(getWidth() * (831 / 2048.0)), (int)(getHeight() * (958 / 1152.0))));

}
	private int screenNum = 0; // 0 = title, 1 = instructions, 2 = game 
	public static int numMouseClicks = 0;
	private Graphics g;
	private int rulecounter = 0;
	private Resource[] resourceTypes = {
		Resource.COAL,
		Resource.OIL,
		Resource.GARBAGE,
		Resource.URANIUM
	};	
	private BufferedImage titleScreen, gameBackground, redHouse, yellowHouse, greenHouse, blueHouse, purpleHouse, whiteHouse, bigBoard, board,
	auctionImagePlayerOne, auctionImagePlayerTwo, auctionImagePlayerThree, auctionImagePlayerFour, arrow, rules1, rules2, rules3, rules4, rules5, 
	rules6, rules7, rules8, rules9, rules10, rules11, rules12, rulesBG;
	private BufferedImage pp3, pp4, pp5, pp6, pp7, pp8, pp9, pp10, pp11, pp12, pp13, pp14, pp15, pp16, pp17, pp18,
	pp19, pp20, pp21, pp22, pp23, pp24, pp25, pp26, pp27, pp28, pp29, pp30, pp31, pp32, pp33, pp34, pp35, pp36, pp37, pp38, pp39, pp40,
	pp42, pp44, pp46, pp50;
	public InitialPanel() {
		loadCityCoordinates();
		//Load all images
		try{
			rulesBG = ImageIO.read(new File("resources/Rules Background.png"));
			rules1 = ImageIO.read(new File("resources/Rules1.png"));
			rules2 = ImageIO.read(new File("resources/Rules2.png"));
			rules3 = ImageIO.read(new File("resources/Rules3.png"));
			rules4 = ImageIO.read(new File("resources/Rules4.png"));
			rules5 = ImageIO.read(new File("resources/Rules5.png"));
			rules6 = ImageIO.read(new File("resources/Rules6.png"));
			rules7 = ImageIO.read(new File("resources/Rules7.png"));
			rules8 = ImageIO.read(new File("resources/Rules8.png"));
			rules9 = ImageIO.read(new File("resources/Rules9.png"));
			rules10 = ImageIO.read(new File("resources/Rules10.png"));
			rules11 = ImageIO.read(new File("resources/Rules11.png"));
			rules12 = ImageIO.read(new File("resources/Rules12.png"));
			bigBoard = ImageIO.read(new File("resources/Board.png"));
			board = ImageIO.read(new File("resources/Cropped Board.png"));
            titleScreen = ImageIO.read(new File("Powergrid.png"));
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
			arrow= ImageIO.read(new File("resources/Arrow.png"));
			pp3 = ImageIO.read(new File("resources/3.jpeg"));
			pp4 = ImageIO.read(new File("resources/4.jpeg"));
			pp5 = ImageIO.read(new File("resources/5.jpeg"));
			pp6 = ImageIO.read(new File("resources/6.jpeg"));
			pp7 = ImageIO.read(new File("resources/7.jpeg"));
			pp8 = ImageIO.read(new File("resources/8.jpeg"));
			pp9 = ImageIO.read(new File("resources/9.jpeg"));
			pp10 = ImageIO.read(new File("resources/10.png"));
			pp11 = ImageIO.read(new File("resources/11.png"));
			pp12 = ImageIO.read(new File("resources/12.jpeg"));
			pp13 = ImageIO.read(new File("resources/13.jpeg"));
			pp14 = ImageIO.read(new File("resources/14.jpeg"));
			pp15 = ImageIO.read(new File("resources/15.jpeg"));
			pp16 = ImageIO.read(new File("resources/16.jpeg"));
			pp17 = ImageIO.read(new File("resources/17.jpeg"));
			pp18 = ImageIO.read(new File("resources/18.jpeg"));
			pp19 = ImageIO.read(new File("resources/19.jpeg"));
			pp20 = ImageIO.read(new File("resources/20.jpeg"));
			pp21 = ImageIO.read(new File("resources/21.jpeg"));
			pp22 = ImageIO.read(new File("resources/22.jpeg"));
			pp23 = ImageIO.read(new File("resources/23.jpeg"));
			pp24 = ImageIO.read(new File("resources/24.jpeg"));
			pp25 = ImageIO.read(new File("resources/25.jpeg"));
			pp26 = ImageIO.read(new File("resources/26.jpeg"));
			pp27 = ImageIO.read(new File("resources/27.jpeg"));
			pp28 = ImageIO.read(new File("resources/28.jpeg"));
			pp29 = ImageIO.read(new File("resources/29.jpeg"));
			pp30 = ImageIO.read(new File("resources/30.jpeg"));
			pp31 = ImageIO.read(new File("resources/31.jpeg"));
			pp32 = ImageIO.read(new File("resources/32.jpeg"));
			pp33 = ImageIO.read(new File("resources/33.jpeg"));
			pp34 = ImageIO.read(new File("resources/34.jpeg"));
			pp35 = ImageIO.read(new File("resources/35.jpeg"));
			pp36 = ImageIO.read(new File("resources/36.jpeg"));
			pp37 = ImageIO.read(new File("resources/37.jpeg"));
			pp38 = ImageIO.read(new File("resources/38.jpeg"));
			pp39 = ImageIO.read(new File("resources/39.jpeg"));
			pp40 = ImageIO.read(new File("resources/40.jpeg"));
			pp42 = ImageIO.read(new File("resources/42.jpeg"));
			pp44 = ImageIO.read(new File("resources/44.jpeg"));
			pp46 = ImageIO.read(new File("resources/46.jpeg"));
			pp50 = ImageIO.read(new File("resources/50.jpeg"));

        } catch (Exception e){
            System.out.println("No workie because idk 🤷‍♂️");
            System.out.println(e);
        }
		System.out.println("rulesBG loaded: " + (rulesBG != null));
		
		try {
			
		} catch (Exception E) {
			
		}
		addKeyListener(this);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("Painting: " + GameState.currentEvent.getLast());
		switch(GameState.currentEvent.getLast()) {
			 case "Title Screen":
			// 	// title screen with proper layout
			 	g.drawImage(titleScreen, 0, 0, 1925, 1020, this);
			 	break;

			case "Instructions":
				g.drawImage(rulesBG, 0, 0, 1920, 1080, this);
				switch(rulecounter) {
					case 0: g.drawImage(rules1, 600, 0, 700, 1000, this); break;
					case 1: g.drawImage(rules2, 600, 0, 700, 1000, this); break;
					case 2: g.drawImage(rules3, 600, 0, 700, 1000, this); break;
					case 3: g.drawImage(rules4, 600, 0, 700, 1000, this); break;
					case 4: g.drawImage(rules5, 600, 0, 700, 1000, this); break;
					case 5: g.drawImage(rules6, 600, 0, 700, 1000, this); break;
					case 6: g.drawImage(rules7, 600, 0, 700, 1000, this); break;
					case 7: g.drawImage(rules8, 600, 0, 700, 1000, this); break;
					case 8: g.drawImage(rules9, 600, 0, 700, 1000,this); break;
					case 9: g.drawImage(rules10,600 ,0 ,700 ,1000 ,this); break;
					case 10: g.drawImage(rules11 ,600 ,0 ,700 ,1000 ,this); break;
					case 11: g.drawImage(rules12 ,600 ,0 ,700 ,1000 ,this); break;
				}
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 30f));
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
				break;
			case "Buy Powerplant":
			g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				
				sizedFont = Main.customFont.deriveFont(Font.PLAIN, 50f);
			g.setFont(sizedFont);
			
			 sizedFont = Main.customFont.deriveFont(Font.PLAIN, 30f);
				sizedFont = Main.customFont.deriveFont(Font.BOLD, 100f);
				g.setFont(sizedFont);
				g.drawString("Player " + ((GameState.playerOrderInAuction.get(0)) + 1) + " Buy a Power Plant", 100, 900);
				for(int i=0;i<4;i++){
					g.drawImage(getPowerPlantImage(GameState.powerPlantsInMarket.get(i).getPrice()), 175 + i * 200, 150, 150, 150, this);
				}
				for(int i=0;i<4;i++){
					g.drawImage(getPowerPlantImage(GameState.powerPlantsInMarket.get(i+4).getPrice()), 175 + i * 200, 350, 150, 150, this);
				}
				break;
			case "Buy Resources":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Font customFontLarge = Main.customFont.deriveFont(Font.BOLD, 40f);
				Font customFontMed = Main.customFont.deriveFont(Font.BOLD, 30f);
				Font customFontSmall = Main.customFont.deriveFont(Font.BOLD, 20f);
				
				g.setFont(customFontLarge);
				g.setColor(Color.BLACK);
				g.drawString("Player " + (GameState.currentPlayerIndex + 1) + " - Buy Resources", 100, 100);
				
				g.setFont(customFontMed);
				g.drawString("Elektro: " + GameState.players[GameState.currentPlayerIndex].getElektro(), 100, 150);
				
				// Display player's powerplants as images with their individual resources
				Player currentPlayer = GameState.players[GameState.currentPlayerIndex];
				ArrayList<PowerPlant> playerPowerPlants = currentPlayer.getPowerPlants();
				
				g.setFont(customFontMed);
				g.drawString("Your Power Plants:", 100, 200);
				
				Graphics2D g2d = (Graphics2D) g;
				int ppXPos = 100;
				int ppYPos = 230;
				
				if(playerPowerPlants.size() == 0) {
					g.setFont(customFontSmall);
					g.drawString("No power plants yet", 120, ppYPos);
				} else {
					for(PowerPlant pp : playerPowerPlants) {
						// Draw power plant image
						BufferedImage ppImage = getPowerPlantImage(pp.getPrice());
						if(ppImage != null) {
							g.drawImage(ppImage, ppXPos, ppYPos, 100, 100, this);
						} else {
							// Fallback if image not available
							g.setColor(Color.LIGHT_GRAY);
							g.fillRect(ppXPos, ppYPos, 100, 100);
							g.setColor(Color.BLACK);
							g2d.setStroke(new BasicStroke(2));
							g2d.drawRect(ppXPos, ppYPos, 100, 100);
						}
						
						// Draw plant info below image
						g.setFont(customFontSmall);
						g.setColor(Color.BLACK);
						g.drawString("Capacity: " + pp.getMaxResources(), ppXPos, ppYPos + 120);
						
						// Draw resource capabilities
						String fuelStr = "";
						for(Resource r : pp.getFuelType()) {
							fuelStr += r.toString().substring(0, 1);
						}
						g.drawString("Fuels: " + fuelStr, ppXPos, ppYPos + 140);
						
						// Draw current resources in plant
						int currentCount = pp.getCurrentResources().size();
						g.drawString("Current: " + currentCount, ppXPos, ppYPos + 160);
						
					// Draw resource tokens
					Color[] sphereColorsLocal = {new Color(101, 67, 33), Color.BLACK, Color.YELLOW, Color.RED};
					int tokenXPos = ppXPos;
					int tokenYPos = ppYPos + 175;
					int[] resourceCounts = {0, 0, 0, 0};						for(Resource r : pp.getCurrentResources()) {
							if(r == Resource.COAL) resourceCounts[0]++;
							else if(r == Resource.OIL) resourceCounts[1]++;
							else if(r == Resource.GARBAGE) resourceCounts[2]++;
							else if(r == Resource.URANIUM) resourceCounts[3]++;
						}
						
						// Draw resource tokens (show coal as example)
						if(resourceCounts[0] > 0) {
							for(int t = 0; t < resourceCounts[0] && t < 3; t++) {
								g.setColor(sphereColorsLocal[0]);
								g.fillOval(tokenXPos, tokenYPos, 15, 15);
								g.setColor(Color.WHITE);
								g2d.setStroke(new BasicStroke(1));
								g2d.drawOval(tokenXPos, tokenYPos, 15, 15);
								tokenXPos += 18;
							}
						}
						
						ppXPos += 120;
						if(ppXPos > getWidth() - 150) {
							ppXPos = 100;
							ppYPos += 200;
						}
					}
				}
				
				// Display Resource Market (as per official rules)
				int marketStartY = ppYPos + 220;
				g.setFont(customFontLarge);
				g.setColor(Color.BLACK);
				g.drawString("Resource Market", 100, marketStartY);
				
				// Draw the resource market grid
				String[] resourceNames = {"Coal", "Oil", "Garbage", "Uranium"};
				
				Color[] sphereColors = {new Color(101, 67, 33), Color.BLACK, Color.YELLOW, Color.RED};
				
				// Display each resource type with its market spaces
				int resourceYPos = marketStartY + 50;
				
				for(int r = 0; r < 4; r++) {
					// Draw colored sphere (resource token)
					g.setColor(sphereColors[r]);
					g.fillOval(100, resourceYPos - 20, 35, 35);
					g.setColor(Color.BLACK);
					g2d.setStroke(new BasicStroke(2));
					g2d.drawOval(100, resourceYPos - 20, 35, 35);
					
					// Draw resource name
					g.setFont(customFontMed);
					g.setColor(Color.BLACK);
					g.drawString(resourceNames[r] + ":", 150, resourceYPos);
					
					// Draw available quantity at cheapest price with token images
					int cheapestPrice = GameState.resourceMarket.getCheapestPrice(resourceTypes[r]);
					if(cheapestPrice >= 0) {
						g.setFont(customFontSmall);
						g.drawString("$" + cheapestPrice, 320, resourceYPos);
						
						// Display how many are available at cheapest price (as tokens)
						int availableCount = 0;
					//	int[] market = null;
					//	if(r == 0) market = GameState.resourceMarket.getCoalMarket();
					//	else if(r == 1) market = GameState.resourceMarket.getOilMarket();
					//	else if(r == 2) market = GameState.resourceMarket.getGarbageMarket();
					//	else if(r == 3) market = GameState.resourceMarket.getUraniumMarket();
						
					//	if(market != null) {
					//		for(int i = 1; i < market.length; i++) {
					//			if(market[i] > 0) {
					//				availableCount = market[i];
					//				break;
					//			}
					//		}
					//	}
					//	
						// Draw resource tokens for available count
						int tokenX = 400;
						for(int t = 0; t < availableCount && t < 5; t++) {
							g.setColor(sphereColors[r]);
							g.fillOval(tokenX, resourceYPos - 15, 20, 20);
							g.setColor(Color.BLACK);
							g2d.setStroke(new BasicStroke(1));
							g2d.drawOval(tokenX, resourceYPos - 15, 20, 20);
							tokenX += 22;
						}
						
						if(availableCount > 5) {
							g.setFont(customFontSmall);
							g.drawString("+" + (availableCount - 5), tokenX, resourceYPos);
						}
						
						// Buy button
						g.setColor(Color.LIGHT_GRAY);
						g.fillRect(750, resourceYPos - 20, 80, 40);
						g.setColor(Color.BLACK);
						g2d.setStroke(new BasicStroke(3));
						g2d.drawRect(750, resourceYPos - 20, 80, 40);
						g.setFont(customFontSmall);
						centerString(g, "Buy", 750, resourceYPos - 20, 80, 40);
					} else {
						g.setFont(customFontSmall);
						g.setColor(Color.RED);
						g.drawString("SOLD OUT", 320, resourceYPos);
					}
					
					resourceYPos += 60;
				}
				
				// Done button
				g.setFont(customFontMed);
				g.setColor(Color.WHITE);
				g.fillRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.9), getWidth()/5, (int)(getHeight() * 0.08));
				g.setColor(Color.BLACK);
				g2d.setStroke(new BasicStroke(5));
				g2d.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.9), getWidth()/5, (int)(getHeight() * 0.08));
				centerString(g, "Done", getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.9), getWidth()/5, (int)(getHeight() * 0.08));
				break;
			case "Buy Cities":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.drawImage(bigBoard, getWidth()/4, 0, getWidth()/2, getHeight(), null);
				// Draw the board and city houses - UI will be implemented with board drawing
				// Draw continue button
				Font buyFont = new Font("Arial", Font.BOLD, 30);
				g.setFont(buyFont);
				g.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
				g.setColor(Color.WHITE);
				g.fillRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
				g.setColor(Color.BLACK);
				Graphics2D buyG2 = (Graphics2D)(g);
				buyG2.setStroke(new BasicStroke(5));
				buyG2.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
				centerString(g, "Done", getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
				CityGraph graph = GameState.fullGraph; // however you store it
				
				for (CityNode node : graph.getNodes()) {
				String name = node.getName();
				
				Point p = cityCoords.get(name);

				if (p == null) continue;

				boolean allowed = GameState.graphOfCity.contains(name);
					

				if (!allowed) {
					 g2 = (Graphics2D) g;
					g2.setStroke(new BasicStroke(6));
					g2.setColor(Color.RED);

					int x = p.x;
					int y = p.y;

					g2.drawLine(x - 20, y - 20, x + 20, y + 20);
					g2.drawLine(x + 20, y - 20, x - 20, y + 20);
				}
				}
				break;
			case "Confirm City Purchase":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Font confirmFont = new Font("Arial", Font.BOLD, 40);
				g.setFont(confirmFont);
				g.setColor(Color.BLACK);
				String confirmMsg = "Confirm Purchase Of "+GameState.cityNameForPurchase+" For "+GameState.setPriceForCity+" Elektro?";
				FontMetrics fm = g.getFontMetrics();
				int msgWidth = fm.stringWidth(confirmMsg);
				g.drawString(confirmMsg, (getWidth() - msgWidth) / 2, getHeight() / 2 - 100);
				
				// Yes button
				g.drawRect((int)(getWidth() * 0.25), (int)(getHeight() * 0.55), (int)(getWidth() * 0.15), (int)(getHeight() * 0.08));
				g.setColor(Color.WHITE);
				g.fillRect((int)(getWidth() * 0.25), (int)(getHeight() * 0.55), (int)(getWidth() * 0.15), (int)(getHeight() * 0.08));
				g.setColor(Color.BLACK);
				Graphics2D confirmG2 = (Graphics2D)(g);
				confirmG2.setStroke(new BasicStroke(5));
				confirmG2.drawRect((int)(getWidth() * 0.25), (int)(getHeight() * 0.55), (int)(getWidth() * 0.15), (int)(getHeight() * 0.08));
				centerString(g, "Yes", (int)(getWidth() * 0.25), (int)(getHeight() * 0.55), (int)(getWidth() * 0.15), (int)(getHeight() * 0.08));
				
				// No button
				g.drawRect((int)(getWidth() * 0.6), (int)(getHeight() * 0.55), (int)(getWidth() * 0.15), (int)(getHeight() * 0.08));
				g.setColor(Color.WHITE);
				g.fillRect((int)(getWidth() * 0.6), (int)(getHeight() * 0.55), (int)(getWidth() * 0.15), (int)(getHeight() * 0.08));
				g.setColor(Color.BLACK);
				confirmG2.drawRect((int)(getWidth() * 0.6), (int)(getHeight() * 0.55), (int)(getWidth() * 0.15), (int)(getHeight() * 0.08));
				centerString(g, "No", (int)(getWidth() * 0.6), (int)(getHeight() * 0.55), (int)(getWidth() * 0.15), (int)(getHeight() * 0.08));
				break;
			case "Bureaucracy":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Font bureaucracyFont = new Font("Arial", Font.BOLD, 50);
				g.setFont(bureaucracyFont);
				g.setColor(Color.BLACK);
				String bureauMsg = "Player " + (GameState.currentPlayerIndex + 1) + " has earned 50 Elektro";
				FontMetrics bureauFm = g.getFontMetrics();
				int bureauMsgWidth = bureauFm.stringWidth(bureauMsg);
				g.drawString(bureauMsg, (getWidth() - bureauMsgWidth) / 2, getHeight() / 2);
				
				// Click to continue button
				g.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.75), getWidth()/5, (int)(getHeight() * 0.08));
				g.setColor(Color.WHITE);
				g.fillRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.75), getWidth()/5, (int)(getHeight() * 0.08));
				g.setColor(Color.BLACK);
				Graphics2D bureauG2 = (Graphics2D)(g);
				bureauG2.setStroke(new BasicStroke(5));
				bureauG2.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.75), getWidth()/5, (int)(getHeight() * 0.08));
				centerString(g, "Continue", getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.75), getWidth()/5, (int)(getHeight() * 0.08));
				break;
			case "Activate Powerplants":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Font ppFont = new Font("Arial", Font.BOLD, 35);
				g.setFont(ppFont);
				g.setColor(Color.BLACK);
				g.drawString("Player " + (GameState.currentPlayerIndex + 1) + " - Activate Powerplants", 100, 100);
				
				// Display player's powerplants (placeholder)
				g.drawString("Click powerplants to activate", 100, 200);
				
				// Done button
				g.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.9), getWidth()/5, (int)(getHeight() * 0.08));
				g.setColor(Color.WHITE);
				g.fillRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.9), getWidth()/5, (int)(getHeight() * 0.08));
				g.setColor(Color.BLACK);
				Graphics2D ppG2 = (Graphics2D)(g);
				ppG2.setStroke(new BasicStroke(5));
				ppG2.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.9), getWidth()/5, (int)(getHeight() * 0.08));
				centerString(g, "Done", getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.9), getWidth()/5, (int)(getHeight() * 0.08));
				break;
			case "Hybrid Powerplant":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Font hybridFont = new Font("Arial", Font.BOLD, 40);
				g.setFont(hybridFont);
				g.setColor(Color.BLACK);
				g.drawString("Select Resources", (getWidth() - 300) / 2, getHeight() / 2 - 150);
				
				// Display coal and oil options
				g.drawString("Coal needed: 2", 400, getHeight() / 2);
				g.drawString("Oil needed: 2", 400, getHeight() / 2 + 100);
				
				// Confirm button
				g.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.75), getWidth()/5, (int)(getHeight() * 0.08));
				g.setColor(Color.WHITE);
				g.fillRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.75), getWidth()/5, (int)(getHeight() * 0.08));
				g.setColor(Color.BLACK);
				Graphics2D hybridG2 = (Graphics2D)(g);
				hybridG2.setStroke(new BasicStroke(5));
				hybridG2.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.75), getWidth()/5, (int)(getHeight() * 0.08));
				centerString(g, "Confirm", getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.75), getWidth()/5, (int)(getHeight() * 0.08));
				



			
		}
	}
			public boolean isCityInSelectedZone(String cityName, boolean[] isZoneSelected) {
			HashMap<Integer, ArrayList<String>> zoneMap = new HashMap<>();

			zoneMap.put(0, new ArrayList<>(Arrays.asList(
				"Flensburg", "Kiel", "Hamburg", "Cuxhaven", "Wilhelmshaven", "Bremen", "Hannover", "Lubeck"
			)));
			zoneMap.put(1, new ArrayList<>(Arrays.asList(
				"Lubeck", "Schwerin", "Rostock", "Torgelow", "Magdeburg", "Berlin", "Frankfurt-O"
			)));
			zoneMap.put(2, new ArrayList<>(Arrays.asList(
				"Osnabruck", "Munster", "Duisburg", "Essen", "Dortmund", "Dusseldorf", "Kassel"
			)));
			zoneMap.put(3, new ArrayList<>(Arrays.asList(
				"Halle", "Leipzig", "Dresden", "Erfurt", "Fulda", "Wurzburg", "Nurnberg"
			)));
			zoneMap.put(4, new ArrayList<>(Arrays.asList(
				"Aachen", "Koln", "Trier", "Wiesbaden", "Frankfurt-M", "Saarbrucken", "Mannheim"
			)));
			zoneMap.put(5, new ArrayList<>(Arrays.asList(
				"Stuttgart", "Freiburg", "Konstanz", "Augsburg", "Munchen", "Regensburg", "Passau"
			)));

			for (int i = 0; i < isZoneSelected.length; i++) {
				if (isZoneSelected[i] && zoneMap.get(i).contains(cityName)) {
					return true;
				}
			}
			return false;
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
		return null;
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
		System.out.println("Mouse clicked at: " + x + ", " + y +"\t|\t"+"Mouse clicks: " + ++numMouseClicks);
		switch(GameState.currentEvent.getLast()) {
			case "Title Screen":
				// Check if Play button was clicked
				if (x >= 1200 && x <= 1700 && y >= 700 && y <= 800) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Color Selection");
					repaint();
				}
				// Check if Rules button was clicked
				else if (x >= 1200 && x <= 1700 && y >= 830 && y <= 914) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Instructions");
					repaint();
				}
				break;
			
			case "Instructions":
				// Rectangle for increasing ruleCounter
				int incX1 = 1724, incY1 = 87;   // top-left
				int incX2 = 1852, incY2 = 958;  // bottom-right

				// Rectangle for decreasing ruleCounter
				int decX1 = 76, decY1 = 108;    // top-left
				int decX2 = 200, decY2 = 969;   // bottom-right

				if (x >= incX1 && x <= incX2 && y >= incY1 && y <= incY2) {
					rulecounter++;
				} else if (x >= decX1 && x <= decX2 && y >= decY1 && y <= decY2) {
					rulecounter--;
				}

				// Wrap-around logic
				if (rulecounter < 0) {
					rulecounter = 11;
				} else if (rulecounter > 11) {
					rulecounter = 0;
				}
				// return button in iunctructions page
				if (x >= 80 && x <= 325 && y >= 30 && y <= 87) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Title Screen");
					repaint();
				}
				repaint();
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
				

				} else if (x >= 375 && x <= 525) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(1);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				GameState.currentEvent.removeLast();
				
				GameState.continueAuction();
			
			} else if (x >= 575 && x <= 725) {
				GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(2);
				GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				// Automatically make minimum bid and lock it in
				GameState.players[GameState.playerOrderInAuction.get(0)].setBid(GameState.minBid+1);
				GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
				GameState.players[GameState.playerOrderInAuction.get(0)].useGhostBid();
				GameState.currentEvent.removeLast();
				
				GameState.continueAuction();

				} else if (x >= 775 && x <= 925) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(3);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				GameState.currentEvent.removeLast();
				
				GameState.continueAuction();
			}
		}
					repaint();
					break;
			case "Buy Powerplant":
				if (y >= 150 && y <= 300) {

				if (x >= 175 && x <= 325) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(0);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
					GameState.players[GameState.playerOrderInAuction.get(0)].setBid(0);
                    GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
                    GameState.players[GameState.playerOrderInAuction.get(0)].buyPowerPlant(GameState.auctionedPowerPlant);
                    int i=0;
                    while(GameState.powerPlantsInMarket.get(i).getPrice()<GameState.auctionedPowerPlant.getPrice()) {
                        i++;
                    }
                    GameState.powerPlantsInMarket.remove(i);
				    GameState.powerPlantsInMarket.add(GameState.powerPlantDeck.remove(GameState.powerPlantDeck.size()-1));
				GameState.currentEvent.removeLast();
				GameState.currentEvent.add("Buy Resources");

				} else if (x >= 375 && x <= 525) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(1);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
					GameState.players[GameState.playerOrderInAuction.get(0)].setBid(0);
                    GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
                    GameState.players[GameState.playerOrderInAuction.get(0)].buyPowerPlant(GameState.auctionedPowerPlant);
                    int i=0;
                    while(GameState.powerPlantsInMarket.get(i).getPrice()<GameState.auctionedPowerPlant.getPrice()) {
                        i++;
                    }
                    GameState.powerPlantsInMarket.remove(i);
                    GameState.powerPlantsInMarket.add(GameState.powerPlantDeck.remove(GameState.powerPlantDeck.size()-1));
				GameState.currentEvent.removeLast();
				GameState.currentEvent.add("Buy Resources");

				} else if (x >= 575 && x <= 725) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(2);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
					GameState.players[GameState.playerOrderInAuction.get(0)].setBid(0);
                    GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
                    GameState.players[GameState.playerOrderInAuction.get(0)].buyPowerPlant(GameState.auctionedPowerPlant);
                    int i=0;
                    while(GameState.powerPlantsInMarket.get(i).getPrice()<GameState.auctionedPowerPlant.getPrice()) {
                        i++;
                    }
                    GameState.powerPlantsInMarket.remove(i);
                    GameState.powerPlantsInMarket.add(GameState.powerPlantDeck.remove(GameState.powerPlantDeck.size()-1));
				GameState.currentEvent.removeLast();
				GameState.currentEvent.add("Buy Resources");
				} else if (x >= 775 && x <= 925) {
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(3);
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
					GameState.players[GameState.playerOrderInAuction.get(0)].setBid(0);
                    GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
                    GameState.players[GameState.playerOrderInAuction.get(0)].buyPowerPlant(GameState.auctionedPowerPlant);
                    int i=0;
                    while(GameState.powerPlantsInMarket.get(i).getPrice()<GameState.auctionedPowerPlant.getPrice()) {
                        i++;
                    }
                    GameState.powerPlantsInMarket.remove(i);
                    GameState.powerPlantsInMarket.add(GameState.powerPlantDeck.remove(GameState.powerPlantDeck.size()-1));
				GameState.currentEvent.removeLast();
				GameState.currentEvent.add("Buy Resources");
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

				case "Buy Resources":
					// Done button clicked
					if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
					   && y >= (int)(getHeight() * 0.9) && y <= (int)(getHeight() * 0.9) + (int)(getHeight() * 0.08)) {
						GameState.currentPlayerIndex++;
						if(GameState.currentPlayerIndex == 4) {
							GameState.currentPlayerIndex = 0;
							GameState.currentEvent.removeLast();
							GameState.currentEvent.add("Buy Cities");
						}
					}					
				
					Player currentPlayer = GameState.players[GameState.currentPlayerIndex];
					int resourceYPos = 530;
					for(int r = 0; r < 4; r++) {
						// Buy button at coordinates (750, resourceYPos - 20) with size 80x40
						if(x >= 750 && x <= 830 && y >= resourceYPos - 20 && y <= resourceYPos + 20) {
							// Check if player can afford and has capacity
							int price = GameState.resourceMarket.getCheapestPrice(resourceTypes[r]);
							if(price >= 0) {
								if(currentPlayer.getElektro() >= price && currentPlayer.canAddResource(resourceTypes[r], 1)) {
									boolean bought = GameState.resourceMarket.buyResource(resourceTypes[r]);
									if(bought) {
										currentPlayer.addResource(resourceTypes[r], 1);
										currentPlayer.addElektro(-price);
										System.out.println("Player " + (GameState.currentPlayerIndex + 1) + " bought " + resourceTypes[r] + " for " + price + " Elektro");
									}
								} else if(!currentPlayer.canAddResource(resourceTypes[r], 1)) {
									System.out.println("Player " + (GameState.currentPlayerIndex + 1) + " does not have capacity for more resources");
								} else {
									System.out.println("Player " + (GameState.currentPlayerIndex + 1) + " does not have enough Elektro");
								}
							} else {
								System.out.println("Resource " + resourceTypes[r] + " is sold out");
							}
						}
						resourceYPos += 60;
					}   
					repaint();
					break;
				case "Buy Cities":
					// Check if Done button was clicked
					if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
					   && y >= (int)(getHeight() * 0.925) && y <= (int)(getHeight() * 0.925) + (int)(getHeight() * 0.05)) {
						GameState.currentPlayerIndex++;
						if(GameState.currentPlayerIndex == 4) {
							GameState.currentPlayerIndex = 0;
							GameState.currentEvent.removeLast();
							GameState.currentEvent.add("Activate Powerplants");
						}
					} else {
						// Check which city was clicked
						String[] cityNames = {"Flensburg", "Kiel", "Rostock", "Lubeck", "Cuxhaven", "Wilhelmshaven", "Hamburg", 
											  "Schwerin", "Torgelow", "Bremen", "Berlin", "Osnabruck", "Hannover", "Magdeburg", 
											  "Frankfurt-O", "Munster", "Duisburg", "Essen", "Dortmund", "Halle", "Kassel", 
											  "Leipzig", "Dusseldorf", "Erfurt", "Dresden", "Koln", "Aachen", "Fulda", 
											  "Frankfurt-M", "Wiesbaden", "Trier", "Wurzburg", "Nurnberg", "Mannheim", 
											  "Saarbrucken", "Regensburg", "Stuttgart", "Augsburg", "Passau", "Freiburg", 
											  "Munchen", "Konstanz"};
						int[][] cityCords = {{867, 36}, {918, 101}, {1114, 122}, {989, 146}, {802, 163}, {736, 203}, 
											  {913, 203}, {1053, 206}, {1294, 198}, {818, 266}, {1236, 331}, {747, 344}, 
											  {919, 360}, {1092, 367}, {1336, 358}, {694, 405}, {559, 432}, {623, 446}, 
											  {710, 475}, {1111, 461}, {869, 490}, {1165, 491}, {577, 504}, {1038, 535}, 
											  {1297, 533}, {642, 552}, {548, 570}, {916, 589}, {814, 629}, {750, 652}, 
											  {586, 692}, {934, 687}, {1043, 725}, {804, 746}, {671, 771}, {1124, 789}, 
											  {837, 828}, {998, 856}, {1272, 849}, {712, 916}, {1095, 910}, {831, 958}};
						
						int clickRadius = 30;
						for(int c = 0; c < cityNames.length; c++) {
							int cityX = cityCords[c][0];
							int cityY = cityCords[c][1];
							
							// Check if click is within radius of city
							if(Math.sqrt(Math.pow(x - cityX, 2) + Math.pow(y - cityY, 2)) <= clickRadius) {
								System.out.println("Clicked city: " + cityNames[c]);
								GameState.currentEvent.add("Confirm City Purchase");
								break;
							}
						}
					}
					repaint();
					break;
				case "Confirm City Purchase":
					// Yes button clicked
					if(x >= (int)(getWidth() * 0.25) && x <= (int)(getWidth() * 0.25) + (int)(getWidth() * 0.15)
					   && y >= (int)(getHeight() * 0.55) && y <= (int)(getHeight() * 0.55) + (int)(getHeight() * 0.08)) {
						// Confirm purchase - add logic to purchase city
						if(GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1].getElektro() >= GameState.setPriceForCity) {
							GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1].addCity(GameState.cityNameForPurchase);
							GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1].addElektro(-GameState.setPriceForCity);
							System.out.println("Player " + (GameState.playerOrder[GameState.currentPlayerIndex]) + " bought " + GameState.cityNameForPurchase + " for " + GameState.setPriceForCity + " Elektro");
						} else {
							System.out.println("Player " + (GameState.playerOrder[GameState.currentPlayerIndex]) + " does not have enough Elektro to buy " + GameState.cityNameForPurchase);
						}
						GameState.currentEvent.removeLast();
						repaint();
					}
					// No button clicked
					else if(x >= (int)(getWidth() * 0.6) && x <= (int)(getWidth() * 0.6) + (int)(getWidth() * 0.15)
					   && y >= (int)(getHeight() * 0.55) && y <= (int)(getHeight() * 0.55) + (int)(getHeight() * 0.08)) {
						// Cancel purchase, go back to Buy Cities
						GameState.currentEvent.removeLast();
						repaint();
					}
					break;

				case "Bureaucracy":
					// Any click continues to next phase
					if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
					   && y >= (int)(getHeight() * 0.75) && y <= (int)(getHeight() * 0.75) + (int)(getHeight() * 0.08)) {
						GameState.currentPlayerIndex++;
						if(GameState.currentPlayerIndex == 4) {
							GameState.currentPlayerIndex = 0;
							GameState.currentEvent.removeLast();
							// GameState.newRound();
						}
					}
					repaint();
					break;
				case "Activate Powerplants":
					// Done button clicked
					if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
					   && y >= (int)(getHeight() * 0.9) && y <= (int)(getHeight() * 0.9) + (int)(getHeight() * 0.08)) {
						GameState.currentPlayerIndex++;
						if(GameState.currentPlayerIndex == 4) {
							GameState.currentPlayerIndex = 0;
							GameState.currentEvent.removeLast();
							// GameState.doBureaucracy();
							GameState.currentEvent.add("Bureaucracy");
						}
					}
					break;
				case "Hybrid Powerplant":
					// Confirm button clicked
					if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
					   && y >= (int)(getHeight() * 0.75) && y <= (int)(getHeight() * 0.75) + (int)(getHeight() * 0.08)) {
						// Confirm resource selection and return to Activate Powerplants
						GameState.currentEvent.removeLast();
					}
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
