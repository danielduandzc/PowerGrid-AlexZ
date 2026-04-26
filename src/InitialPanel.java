package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class InitialPanel extends JPanel implements KeyListener, MouseListener {
	private HashMap<String, Point> cityCoords = new HashMap<>();

private void loadCityCoordinates() {
    
  cityCoords.put("Flensburg", new Point((int)(getWidth() * (867 / 1920.0)), (int)(getHeight() * (36 / 1070.0))));
    cityCoords.put("Kiel", new Point((int)(getWidth() * (918 / 1920.0)), (int)(getHeight() * (101 / 1070.0))));
    cityCoords.put("Rostock", new Point((int)(getWidth() * (1114 / 1920.0)), (int)(getHeight() * (122 / 1070.0))));
    cityCoords.put("Lubeck", new Point((int)(getWidth() * (989 / 1920.0)), (int)(getHeight() * (146 / 1070.0))));
    cityCoords.put("Cuxhaven", new Point((int)(getWidth() * (802 / 1920.0)), (int)(getHeight() * (163 / 1070.0))));
    cityCoords.put("Wilhelmshaven", new Point((int)(getWidth() * (736 / 1920.0)), (int)(getHeight() * (203 / 1070.0))));
    cityCoords.put("Hamburg", new Point((int)(getWidth() * (913 / 1920.0)), (int)(getHeight() * (203 / 1070.0))));
    cityCoords.put("Schwerin", new Point((int)(getWidth() * (1053 / 1920.0)), (int)(getHeight() * (206 / 1070.0))));
    cityCoords.put("Torgelow", new Point((int)(getWidth() * (1294 / 1920.0)), (int)(getHeight() * (198 / 1070.0))));
    cityCoords.put("Bremen", new Point((int)(getWidth() * (818 / 1920.0)), (int)(getHeight() * (266 / 1070.0))));
    cityCoords.put("Berlin", new Point((int)(getWidth() * (1236 / 1920.0)), (int)(getHeight() * (331 / 1070.0))));
    cityCoords.put("Osnabruck", new Point((int)(getWidth() * (747 / 1920.0)), (int)(getHeight() * (344 / 1070.0))));
    cityCoords.put("Hannover", new Point((int)(getWidth() * (919 / 1920.0)), (int)(getHeight() * (360 / 1070.0))));
    cityCoords.put("Magdeburg", new Point((int)(getWidth() * (1092 / 1920.0)), (int)(getHeight() * (367 / 1070.0))));
    cityCoords.put("Frankfurt-O", new Point((int)(getWidth() * (1336 / 1920.0)), (int)(getHeight() * (358 / 1070.0))));
    cityCoords.put("Munster", new Point((int)(getWidth() * (694 / 1920.0)), (int)(getHeight() * (405 / 1070.0))));
    cityCoords.put("Duisburg", new Point((int)(getWidth() * (559 / 1920.0)), (int)(getHeight() * (432 / 1070.0))));
    cityCoords.put("Essen", new Point((int)(getWidth() * (623 / 1920.0)), (int)(getHeight() * (446 / 1070.0))));
    cityCoords.put("Dortmund", new Point((int)(getWidth() * (710 / 1920.0)), (int)(getHeight() * (475 / 1070.0))));
    cityCoords.put("Halle", new Point((int)(getWidth() * (1105 / 1920.0)), (int)(getHeight() * (470 / 1070.0))));
    cityCoords.put("Kassel", new Point((int)(getWidth() * (869 / 1920.0)), (int)(getHeight() * (492 / 1070.0))));
    cityCoords.put("Leipzig", new Point((int)(getWidth() * (1165 / 1920.0)), (int)(getHeight() * (491 / 1070.0))));
    cityCoords.put("Dusseldorf", new Point((int)(getWidth() * (577 / 1920.0)), (int)(getHeight() * (504 / 1070.0))));
    cityCoords.put("Erfurt", new Point((int)(getWidth() * (1038 / 1920.0)), (int)(getHeight() * (535 / 1070.0))));
    cityCoords.put("Dresden", new Point((int)(getWidth() * (1297 / 1920.0)), (int)(getHeight() * (533 / 1070.0))));
    cityCoords.put("Koln", new Point((int)(getWidth() * (642 / 1920.0)), (int)(getHeight() * (552 / 1070.0))));
    cityCoords.put("Aachen", new Point((int)(getWidth() * (548 / 1920.0)), (int)(getHeight() * (570 / 1070.0))));
    cityCoords.put("Fulda", new Point((int)(getWidth() * (916 / 1920.0)), (int)(getHeight() * (589 / 1070.0))));
    cityCoords.put("Frankfurt-M", new Point((int)(getWidth() * (814 / 1920.0)), (int)(getHeight() * (629 / 1070.0))));
    cityCoords.put("Wiesbaden", new Point((int)(getWidth() * (750 / 1920.0)), (int)(getHeight() * (652 / 1070.0))));
    cityCoords.put("Trier", new Point((int)(getWidth() * (586 / 1920.0)), (int)(getHeight() * (692 / 1070.0))));
    cityCoords.put("Wurzburg", new Point((int)(getWidth() * (934 / 1920.0)), (int)(getHeight() * (687 / 1070.0))));
    cityCoords.put("Nurnberg", new Point((int)(getWidth() * (1043 / 1920.0)), (int)(getHeight() * (725 / 1070.0))));
    cityCoords.put("Mannheim", new Point((int)(getWidth() * (804 / 1920.0)), (int)(getHeight() * (746 / 1070.0))));
    cityCoords.put("Saarbrucken", new Point((int)(getWidth() * (671 / 1920.0)), (int)(getHeight() * (771 / 1070.0))));
    cityCoords.put("Regensburg", new Point((int)(getWidth() * (1124 / 1920.0)), (int)(getHeight() * (789 / 1070.0))));
    cityCoords.put("Stuttgart", new Point((int)(getWidth() * (837 / 1920.0)), (int)(getHeight() * (828 / 1070.0))));
    cityCoords.put("Augsburg", new Point((int)(getWidth() * (998 / 1920.0)), (int)(getHeight() * (856 / 1070.0))));
    cityCoords.put("Passau", new Point((int)(getWidth() * (1272 / 1920.0)), (int)(getHeight() * (849 / 1070.0))));
    cityCoords.put("Freiburg", new Point((int)(getWidth() * (712 / 1920.0)), (int)(getHeight() * (916 / 1070.0))));
    cityCoords.put("Munchen", new Point((int)(getWidth() * (1095 / 1920.0)), (int)(getHeight() * (910 / 1070.0))));
    cityCoords.put("Konstanz", new Point((int)(getWidth() * (831 / 1920.0)), (int)(getHeight() * (958 / 1070.0))));







}
	private boolean hasLoadedCoords=false;
	private int screenNum = 0; // 0 = title, 1 = instructions, 2 = game 
	public static int numMouseClicks = 0;
	private Graphics g;
	private int rulecounter = 0;
	private int resourceButtonStartY = 500; // Y position where resource buy buttons start
	
	private BufferedImage titleScreen, gameBackground, redHouse, yellowHouse, greenHouse, blueHouse, purpleHouse, whiteHouse, bigBoard, board,
	auctionImagePlayerOne, auctionImagePlayerTwo, auctionImagePlayerThree, auctionImagePlayerFour, arrow, scoringTrack, rules1, rules2, rules3, rules4, rules5, 
	rules6, rules7, rules8, rules9, rules10, rules11, rules12, rulesBG, menu, resourceSummary;
	private BufferedImage pp3, pp4, pp5, pp6, pp7, pp8, pp9, pp10, pp11, pp12, pp13, pp14, pp15, pp16, pp17, pp18,
	pp19, pp20, pp21, pp22, pp23, pp24, pp25, pp26, pp27, pp28, pp29, pp30, pp31, pp32, pp33, pp34, pp35, pp36, pp37, pp38, pp39, pp40,
	pp42, pp44, pp46, pp50, step3Card, son;
	public InitialPanel() {
		
		//Load all images
		try{
			// Try loading from resources with null checks
			InputStream is;
			is = PowerGridFrame.class.getResourceAsStream("/resources/Too Broke.png");
			if(is == null) is = new java.io.FileInputStream("resources/Too Broke.png");
			son = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Resource Summary.png");
			if(is == null) is = new java.io.FileInputStream("resources/Resource Summary.png");
			resourceSummary = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Menu.png");
			if(is == null) is = new java.io.FileInputStream("resources/Menu.png");
			menu = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules Background.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules Background.png");
			rulesBG = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules1.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules1.png");
			rules1 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules2.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules2.png");
			rules2 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules3.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules3.png");
			rules3 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules4.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules4.png");
			rules4 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules5.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules5.png");
			rules5 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules6.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules6.png");
			rules6 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules7.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules7.png");
			rules7 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules8.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules8.png");
			rules8 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules9.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules9.png");
			rules9 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules10.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules10.png");
			rules10 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules11.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules11.png");
			rules11 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Rules12.png");
			if(is == null) is = new java.io.FileInputStream("resources/Rules12.png");
			rules12 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Scoring_Track.png");
			if(is == null) is = new java.io.FileInputStream("resources/Scoring_Track.png");
			scoringTrack = ImageIO.read(is);
			
			java.net.URL url = PowerGridFrame.class.getResource("/resources/Board.png");
			if(url != null) bigBoard = ImageIO.read(url);
			else bigBoard = ImageIO.read(new java.io.File("resources/Board.png"));
			
			url = PowerGridFrame.class.getResource("/resources/Cropped Board.png");
			if(url != null) board = ImageIO.read(url);
			else board = ImageIO.read(new java.io.File("resources/Cropped Board.png"));
			
            is = PowerGridFrame.class.getResourceAsStream("/resources/Powergrid.png");
            if(is == null) is = new java.io.FileInputStream("resources/Powergrid.png");
            titleScreen = ImageIO.read(is);
            
            is = PowerGridFrame.class.getResourceAsStream("/resources/Background.png");
            if(is == null) is = new java.io.FileInputStream("resources/Background.png");
            gameBackground = ImageIO.read(is);
            
            is = PowerGridFrame.class.getResourceAsStream("/resources/Red_House.png");
            if(is == null) is = new java.io.FileInputStream("resources/Red_House.png");
            redHouse = ImageIO.read(is);
            
            is = PowerGridFrame.class.getResourceAsStream("/resources/Yellow_House.png");
            if(is == null) is = new java.io.FileInputStream("resources/Yellow_House.png");
            yellowHouse = ImageIO.read(is);
            
            is = PowerGridFrame.class.getResourceAsStream("/resources/Green_House.png");
            if(is == null) is = new java.io.FileInputStream("resources/Green_House.png");
            greenHouse = ImageIO.read(is);
            
            is = PowerGridFrame.class.getResourceAsStream("/resources/Blue_House.png");
            if(is == null) is = new java.io.FileInputStream("resources/Blue_House.png");
            blueHouse = ImageIO.read(is);
            
            is = PowerGridFrame.class.getResourceAsStream("/resources/Purple_House.png");
            if(is == null) is = new java.io.FileInputStream("resources/Purple_House.png");
            purpleHouse = ImageIO.read(is);
            
            is = PowerGridFrame.class.getResourceAsStream("/resources/White_House.png");
            if(is == null) is = new java.io.FileInputStream("resources/White_House.png");
            whiteHouse = ImageIO.read(is);
            
			is = PowerGridFrame.class.getResourceAsStream("/resources/Player_1.png");
			if(is == null) is = new java.io.FileInputStream("resources/Player_1.png");
			auctionImagePlayerOne = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Player_2.png");
			if(is == null) is = new java.io.FileInputStream("resources/Player_2.png");
			auctionImagePlayerTwo = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Player_3.png");
			if(is == null) is = new java.io.FileInputStream("resources/Player_3.png");
			auctionImagePlayerThree = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Player_4.png");
			if(is == null) is = new java.io.FileInputStream("resources/Player_4.png");
			auctionImagePlayerFour = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Arrow.png");
			if(is == null) is = new java.io.FileInputStream("resources/Arrow.png");
			arrow = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/3.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/3.jpeg");
			pp3 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/4.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/4.jpeg");
			pp4 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/5.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/5.jpeg");
			pp5 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/6.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/6.jpeg");
			pp6 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/7.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/7.jpeg");
			pp7 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/8.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/8.jpeg");
			pp8 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/9.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/9.jpeg");
			pp9 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/10.png");
			if(is == null) is = new java.io.FileInputStream("resources/10.png");
			pp10 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/11.png");
			if(is == null) is = new java.io.FileInputStream("resources/11.png");
			pp11 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/12.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/12.jpeg");
			pp12 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/13.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/13.jpeg");
			pp13 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/14.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/14.jpeg");
			pp14 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/15.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/15.jpeg");
			pp15 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/16.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/16.jpeg");
			pp16 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/17.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/17.jpeg");
			pp17 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/18.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/18.jpeg");
			pp18 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/19.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/19.jpeg");
			pp19 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/20.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/20.jpeg");
			pp20 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/21.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/21.jpeg");
			pp21 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/22.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/22.jpeg");
			pp22 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/23.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/23.jpeg");
			pp23 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/24.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/24.jpeg");
			pp24 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/25.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/25.jpeg");
			pp25 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/26.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/26.jpeg");
			pp26 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/27.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/27.jpeg");
			pp27 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/28.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/28.jpeg");
			pp28 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/29.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/29.jpeg");
			pp29 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/30.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/30.jpeg");
			pp30 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/31.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/31.jpeg");
			pp31 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/32.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/32.jpeg");
			pp32 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/33.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/33.jpeg");
			pp33 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/34.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/34.jpeg");
			pp34 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/35.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/35.jpeg");
			pp35 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/36.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/36.jpeg");
			pp36 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/37.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/37.jpeg");
			pp37 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/38.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/38.jpeg");
			pp38 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/39.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/39.jpeg");
			pp39 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/40.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/40.jpeg");
			pp40 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/42.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/42.jpeg");
			pp42 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/44.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/44.jpeg");
			pp44 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/46.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/46.jpeg");
			pp46 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/50.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/50.jpeg");
			pp50 = ImageIO.read(is);
			
			is = PowerGridFrame.class.getResourceAsStream("/resources/Step 3.jpeg");
			if(is == null) is = new java.io.FileInputStream("resources/Step 3.jpeg");
			step3Card = ImageIO.read(is);

        } catch (Exception e){
            System.out.println("No workie because idk 🤷‍♂️");
            e.printStackTrace();
        }
		System.out.println("rulesBG loaded: " + (rulesBG != null));
		
		try {
			
		} catch (Exception E) {
			
		}
		GameState.currentEvent.add("Title Screen");
		addKeyListener(this);
		addMouseListener(this);
	}

	// Move Resources UI state
	private int moveSourceIndex = -1;
	private int moveTargetIndex = -1;
	
	public void paint(Graphics g) {
		if(!hasLoadedCoords){
			hasLoadedCoords=true;
			loadCityCoordinates();
		}
		
		super.paint(g);
		
		switch(GameState.currentEvent.getLast()) {
			 case "Title Screen":
				
			// 	// title screen with proper layout
			 	g.drawImage(titleScreen, 0, 0, 2048, 1152, this);
			 	break;

			case "Instructions":
				System.out.println("Drawing rulesBG: " + (rulesBG != null));
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				switch(rulecounter) {
					case 0: g.drawImage(rules1, 400, 0, 1024, 1152, this); break;
					case 1: g.drawImage(rules2, 400, 0, 1024, 1152, this); break;
					case 2: g.drawImage(rules3, 400, 0, 1024, 1152, this); break;
					case 3: g.drawImage(rules4, 400, 0, 1024, 1152, this); break;
					case 4: g.drawImage(rules5, 400, 0, 1024, 1152, this); break;
					case 5: g.drawImage(rules6, 400, 0, 1024, 1152, this); break;
					case 6: g.drawImage(rules7, 400, 0, 1024, 1152, this); break;
					case 7: g.drawImage(rules8, 400, 0, 1024, 1152, this); break;
					case 8: g.drawImage(rules9, 400, 0, 1024, 1152,this); break;
					case 9: g.drawImage(rules10,400 ,0 ,1024 ,1152 ,this); break;
					case 10: g.drawImage(rules11 ,400 ,0 ,1024 ,1152 ,this); break;
					case 11: g.drawImage(rules12 ,400 ,0 ,1024 ,1152 ,this); break;
				}
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 30f));
				
				// Draw left arrow pointer for previous page
				Graphics2D g2d = (Graphics2D) g;
				g2d.setStroke(new BasicStroke(4));
				
				// Left click area - white box background
				int decX1 = 76, decY1 = 108;
				int decX2 = 200, decY2 = 969;
				g.setColor(Color.WHITE);
				g.fillRect(decX1, decY1, decX2 - decX1, decY2 - decY1);
				
				// Right click area - white box background
				int incX1 = 1724, incY1 = 87;
				int incX2 = 1852, incY2 = 958;
				g.fillRect(incX1, incY1, incX2 - incX1, incY2 - incY1);
				
				// Left arrow (pointing left)
				g.setColor(Color.BLACK);
				int leftArrowX = 100;
				int leftArrowY = 576;
				int arrowSize = 40;
				int[] leftXPoints = {leftArrowX, leftArrowX + arrowSize, leftArrowX + arrowSize};
				int[] leftYPoints = {leftArrowY, leftArrowY - arrowSize, leftArrowY + arrowSize};
				g2d.fillPolygon(leftXPoints, leftYPoints, 3);
				g2d.drawPolygon(leftXPoints, leftYPoints, 3);
				
				// Right arrow (pointing right)
				int rightArrowX = getWidth() - 100;
				int rightArrowY = 576;
				int[] rightXPoints = {rightArrowX, rightArrowX - arrowSize, rightArrowX - arrowSize};
				int[] rightYPoints = {rightArrowY, rightArrowY - arrowSize, rightArrowY + arrowSize};
				g2d.fillPolygon(rightXPoints, rightYPoints, 3);
				g2d.drawPolygon(rightXPoints, rightYPoints, 3);
				
				// Draw Return button
				int returnButtonX = getWidth()/2 - 60;
				int returnButtonY = 20;
				int returnButtonWidth = 120;
				int returnButtonHeight = 50;
				
				g.setColor(Color.WHITE);
				g.fillRect(returnButtonX, returnButtonY, returnButtonWidth, returnButtonHeight);
				g.setColor(Color.BLACK);
				g2d.setStroke(new BasicStroke(3));
				g2d.drawRect(returnButtonX, returnButtonY, returnButtonWidth, returnButtonHeight);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 18f));
				centerString(g, "Return", returnButtonX, returnButtonY, returnButtonWidth, returnButtonHeight);
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
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 22f));
				
				g.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
				g.setColor(Color.WHITE);
				
				g.setColor(Color.BLACK);
				
				Graphics2D g2 = (Graphics2D)(g);
				g2.setStroke(new BasicStroke(5));
				
				g.drawString("Please select the boxes for the zones",57, 848    );
				
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
				drawMenu(g);
				break;
			case "Auction":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.drawImage(getPowerPlantImage(GameState.auctionedPowerPlant.getPrice()), 824, 200, 200, 200, this);
				
				drawAuctionUI(g);
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
				
					
					//around x=1600–1800, y=950–1050)
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Font sizedFont;
				sizedFont = Main.customFont.deriveFont(Font.PLAIN, 50f);
				g.setFont(sizedFont);
			
			 sizedFont = Main.customFont.deriveFont(Font.PLAIN, 30f);
				sizedFont = Main.customFont.deriveFont(Font.BOLD, 100f);
				g.setFont(sizedFont);
				g.drawString("Player " + ((GameState.playerOrderInAuction.get(0)) + 1) + " Pick a Power Plant", 100, 900);
				sizedFont = Main.customFont.deriveFont(Font.BOLD, 25f);
				g.setFont(sizedFont);
				g.drawString("Current Elektro: "+GameState.players[GameState.playerOrderInAuction.get(0)].getElektro(), 900, 750);
				for(int i=0;i<4;i++){
					g.drawImage(getPowerPlantImage(GameState.powerPlantsInMarket.get(i).getPrice()), 175 + i * 200, 150, 150, 150, this);
				}
				g.drawString("Current Market ", 1000, 200);
				for(int i=0;i<4;i++){
					g.drawImage(getPowerPlantImage(GameState.powerPlantsInMarket.get(i+4).getPrice()), 175 + i * 200, 350, 150, 150, this);
				}
				g.drawString("Future Market ", 1000, 400);
				if(!GameState.firstRoundOfAuction){
				sizedFont = Main.customFont.deriveFont(Font.PLAIN, 20f);
				g.setFont(sizedFont);
				int skipWidth = 150;
				int skipHeight = 60;
				int skipX = getWidth() - skipWidth - 50;
				int skipY = getHeight() - skipHeight - 50;
				g.setColor(Color.WHITE);
				g.fillRect(skipX, skipY, skipWidth, skipHeight);
				g.setColor(Color.BLACK);
				Graphics2D g2dSkip = (Graphics2D) g;
				g2dSkip.setStroke(new BasicStroke(3));
				g2dSkip.drawRect(skipX, skipY, skipWidth, skipHeight);
				centerString(g, "SKIP", skipX, skipY, skipWidth, skipHeight);
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
				sizedFont = Main.customFont.deriveFont(Font.BOLD, 25f);
				g.setFont(sizedFont);
				g.drawString("Current Elektro: "+GameState.players[GameState.playerOrderInAuction.get(0)].getElektro(), 900, 750);
				for(int i=0;i<4;i++){
					g.drawImage(getPowerPlantImage(GameState.powerPlantsInMarket.get(i).getPrice()), 175 + i * 200, 150, 150, 150, this);
				}
				for(int i=0;i<4;i++){
					g.drawImage(getPowerPlantImage(GameState.powerPlantsInMarket.get(i+4).getPrice()), 175 + i * 200, 350, 150, 150, this);
				}
				if(!GameState.firstRoundOfAuction){
				sizedFont = Main.customFont.deriveFont(Font.PLAIN, 20f);
				g.setFont(sizedFont);
				int skipWidth = 150;
				int skipHeight = 60;
				int skipX = getWidth() - skipWidth - 50;
				int skipY = getHeight() - skipHeight - 50;
				g.setColor(Color.WHITE);
				g.fillRect(skipX, skipY, skipWidth, skipHeight);
				g.setColor(Color.BLACK);
				Graphics2D g2dSkip = (Graphics2D) g;
				g2dSkip.setStroke(new BasicStroke(3));
				g2dSkip.drawRect(skipX, skipY, skipWidth, skipHeight);
				centerString(g, "SKIP", skipX, skipY, skipWidth, skipHeight);
				}
				break;
			case "Buy Resources":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				drawMenu(g);
				Font customFontLarge = Main.customFont.deriveFont(Font.BOLD, 40f);
				Font customFontMed = Main.customFont.deriveFont(Font.BOLD, 30f);
				Font customFontSmall = Main.customFont.deriveFont(Font.BOLD, 15f);
				
				g.setFont(customFontLarge);
				g.setColor(Color.BLACK);
				g.drawString("Player " + (GameState.currentPlayerIndex + 1) + " - Buy Resources", 100, 100);
				
				g.setFont(customFontMed);
				g.drawString("Elektro: " + GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1].getElektro(), 100, 150);
				
				// Display player's powerplants as images with their individual resources
				Player currentPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1];
				ArrayList<PowerPlant> playerPowerPlants = currentPlayer.getPowerPlants();
				
				g.setFont(customFontMed);
				g.drawString("Your Power Plants:", 100, 200);
				
				 g2d = (Graphics2D) g;
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
						if(fuelStr.isEmpty()) fuelStr = "Renewable";
						if(fuelStr.length() == 2) fuelStr = fuelStr.substring(0, 1) + "/" + fuelStr.substring(1);
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
						// Draw resource tokens for all resource types
						int l=0;
			for (int i = 0; i < 4; i++) {
				int count = resourceCounts[i];
				if (count > 0) {
					for (int t = 0; t < count; t++) {
						g.setColor(sphereColorsLocal[i]);
						g.fillOval(tokenXPos, tokenYPos, 15, 15);
						g.setColor(Color.WHITE);
						g2d.setStroke(new BasicStroke(1));
						g2d.drawOval(tokenXPos, tokenYPos, 15, 15);
						tokenXPos += 18;
						l++;
						if(l%5==0) {
							tokenXPos = ppXPos;
							tokenYPos += 18;
						}

					}
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
				
				
				// Draw the resource market grid
				String[] resourceNames = {"Coal", "Oil", "Garbage", "Uranium"};
				Resource[] resourceTypes = {Resource.COAL, Resource.OIL, Resource.GARBAGE, Resource.URANIUM};
				Color[] sphereColors = {new Color(101, 67, 33), Color.BLACK, Color.YELLOW, Color.RED};
				
				// Display each resource type with its market spaces
				int resourceYPos = marketStartY + 50;
				resourceButtonStartY = resourceYPos; // Store starting position for mouse click detection
				
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
					boolean[][] market = null;
					if(r == 0) market = GameState.resourceMarket.getCoalMarket();
					else if(r == 1) market = GameState.resourceMarket.getOilMarket();
					else if(r == 2) market = GameState.resourceMarket.getGarbageMarket();
					else if(r == 3) market = GameState.resourceMarket.getUraniumMarket();
					
					if(market != null) {
						// Count available resources in first row (cheapest price)
						for (boolean[] row : market) {
							for (boolean cell : row) {
								if (cell) {
									availableCount++;
								}
							}
						}
					}drawMenu(g);
					//	
						// Draw resource tokens for available count
						int tokenX = 1600;
						for(int t = 0; t < availableCount; t++) {
							g.setColor(sphereColors[r]);
							g.fillOval(tokenX, resourceYPos - 15, 20, 20);
							g.setColor(Color.BLACK);
							g2d.setStroke(new BasicStroke(1));
							g2d.drawOval(tokenX, resourceYPos - 15, 20, 20);
							if((t+1)%3==0) 
							tokenX -= 22;
							tokenX -= 22;
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
			case "Select Resource":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				drawMenu(g);
				
				Font selectResourceFontLarge = Main.customFont.deriveFont(Font.BOLD, 40f);
				Font selectResourceFontSmall = Main.customFont.deriveFont(Font.BOLD, 15f);
				
				// Draw title
				g.setFont(selectResourceFontLarge);
				g.setColor(Color.BLACK);
				String resourceName = GameState.selectedResourceForAddition != null ? GameState.selectedResourceForAddition.toString() : "Resource";
				g.drawString("Player " + (GameState.currentPlayerIndex + 1) + " - Select Power Plant for " + resourceName, 50, 100);
				
				// Get current player's power plants
				Player selectPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1];
				ArrayList<PowerPlant> selectPlayerPowerPlants = selectPlayer.getPowerPlants();
				
				// Display up to 3 power plants
				int numPlantsToShow = Math.min(3, selectPlayerPowerPlants.size());
				
				if(numPlantsToShow == 0) {
					g.setFont(selectResourceFontSmall);
					g.drawString("No power plants to add resources to", 100, 300);
				} else {
					// Calculate spacing for 3 plants
					int plantWidth = (int)(getWidth() * 0.25);
					int plantHeight = (int)(getHeight() * 0.65);
					int baseX = (int)(getWidth() * 0.1);
					int spacing = (int)(getWidth() * 0.3);
					int baseY = (int)(getHeight() * 0.25);
					
					Graphics2D g2dSelect = (Graphics2D) g;
					
					for(int i = 0; i < numPlantsToShow; i++) {
						PowerPlant pp = selectPlayerPowerPlants.get(i);
						int plantX = baseX + (i * spacing);
						int plantY = baseY;
						
						// Draw plant card background
						g.setColor(Color.WHITE);
						g.fillRect(plantX, plantY, plantWidth, plantHeight);
						g.setColor(Color.BLACK);
						g2dSelect.setStroke(new BasicStroke(3));
						g2dSelect.drawRect(plantX, plantY, plantWidth, plantHeight);
						
						// Draw power plant image
						BufferedImage ppImage = getPowerPlantImage(pp.getPrice());
						if(ppImage != null) {
							g.drawImage(ppImage, plantX + 30, plantY + 20, 100, 100, this);
						}
						
						// Draw plant info
						g.setFont(selectResourceFontSmall);
						g.setColor(Color.BLACK);
						int infoY = plantY + 135;
						g.drawString("Price: " + pp.getPrice(), plantX + 20, infoY);
						g.drawString("Capacity: " + pp.getMaxResources(), plantX + 20, infoY + 25);
						
						// Draw fuel types
						String fuelStr = "";
						for(Resource r : pp.getFuelType()) {
							fuelStr += r.toString().substring(0, 1);
						}
						if(fuelStr.isEmpty()) fuelStr = "Renewable";
						if(fuelStr.length() == 2) fuelStr = fuelStr.substring(0, 1) + "/" + fuelStr.substring(1);
						g.drawString("Fuels: " + fuelStr, plantX + 20, infoY + 50);
						
						// Draw current resources
						int currentCount = pp.getCurrentResources().size();
						g.drawString("Current: " + currentCount + "/" + pp.getMaxResources(), plantX + 20, infoY + 75);
						
						// Draw resource tokens
						Color[] sphereColorsLocal = {new Color(101, 67, 33), Color.BLACK, Color.YELLOW, Color.RED};
						int tokenXPos = plantX + 20;
						int tokenYPos = infoY + 95;
						int[] resourceCounts = {0, 0, 0, 0};
						
						for(Resource r : pp.getCurrentResources()) {
							if(r == Resource.COAL) resourceCounts[0]++;
							else if(r == Resource.OIL) resourceCounts[1]++;
							else if(r == Resource.GARBAGE) resourceCounts[2]++;
							else if(r == Resource.URANIUM) resourceCounts[3]++;
						}
						
						int l = 0;
						for (int j = 0; j < 4; j++) {
							int count = resourceCounts[j];
							if (count > 0) {
								for (int t = 0; t < count; t++) {
									g.setColor(sphereColorsLocal[j]);
									g.fillOval(tokenXPos, tokenYPos, 12, 12);
									g.setColor(Color.WHITE);
									g2dSelect.setStroke(new BasicStroke(1));
									g2dSelect.drawOval(tokenXPos, tokenYPos, 12, 12);
									tokenXPos += 15;
									l++;
									if(l%4==0) {
										tokenXPos = plantX + 20;
										tokenYPos += 15;
									}
								}
							}
						}
					}
				}
				break;
			case "Buy Cities":
				
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.drawImage(bigBoard, getWidth()/4, 0, getWidth()/2, getHeight(), null);
				drawMenu(g);
				
				// Draw heading with player info
				Font citiesFontLarge = Main.customFont.deriveFont(Font.BOLD, 40f);
				Font citiesFontSmall = Main.customFont.deriveFont(Font.BOLD, 20f);
				
				g.setFont(citiesFontLarge);
				g.setColor(Color.BLACK);
				g.drawString("Player " + (GameState.currentPlayerIndex + 1), 100, 100);
				g.drawString("Buy Cities", 100, 150);
				
				// Draw continue button
				g.setFont(citiesFontSmall);
				drawDoneButton(g);
				
				// Draw all cities with their states
				drawBuyCitiesUI(g);
				break;
			case "Confirm City Purchase":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 30f));
				g.setColor(Color.BLACK);
				String confirmMsg = "Confirm Purchase Of "+GameState.cityNameForPurchase+" For "+GameState.setPriceForCity+" Elektro?";
				FontMetrics fm = g.getFontMetrics();
				int msgWidth = fm.stringWidth(confirmMsg);
				g.drawString(confirmMsg, (getWidth() - msgWidth) / 2, getHeight() / 2 - 100);
				
				// Display player's current elektro
				Player confirmPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1];
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 22f));
				String elektroMsg = "You have: " + confirmPlayer.getElektro() + " Elektro";
				FontMetrics elektroFm = g.getFontMetrics();
				int elektroMsgWidth = elektroFm.stringWidth(elektroMsg);
				g.drawString(elektroMsg, (getWidth() - elektroMsgWidth) / 2, getHeight() / 2);
				
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
		case "Too Broke":
			// Draw background
			g.drawImage(gameBackground, 0, 0, getWidth(), getHeight(), this);
			// Draw a smaller centered Too Broke image (if available)
			int imgWidth = 0;
			int imgHeight = 0;
			if (son != null) {
				imgWidth = son.getWidth();
				imgHeight = son.getHeight();
				int targetW = Math.min(getWidth() / 3, imgWidth);
				int targetH = (int) ((double) imgHeight / imgWidth * targetW);
				int imgX = (getWidth() - targetW) / 2;
				int imgY = (getHeight() - targetH) / 2 - 40; // lift a bit to make room for text
				g.drawImage(son, imgX, imgY, targetW, targetH, this);
				// Draw the text below the image
				g.setColor(Color.WHITE);
				g.setFont(Main.customFont.deriveFont(Font.BOLD, 36f));
				FontMetrics fmTB = g.getFontMetrics();
				String msg = "You're too broke";
				int msgW = fmTB.stringWidth(msg);
				int msgX = (getWidth() - msgW) / 2;
				int msgY = imgY + targetH + 50;
				// draw shadow for readability
				g.setColor(Color.BLACK);
				g.drawString(msg, msgX + 2, msgY + 2);
				g.setColor(Color.WHITE);
				g.drawString(msg, msgX, msgY);
			} else {
				// No image: show message centered on background
				g.setColor(Color.WHITE);
				g.setFont(Main.customFont.deriveFont(Font.BOLD, 36f));
				FontMetrics fmTB = g.getFontMetrics();
				String msg = "You're too broke";
				int msgW = fmTB.stringWidth(msg);
				g.drawString(msg, (getWidth() - msgW) / 2, getHeight() / 2);
			}
			// Click to return to Buy Cities
			break;
			case "Bureaucracy":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.drawImage(scoringTrack, 724, 200, 600, 130, this);
				drawMenu(g);
				
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 32f));
				g.setColor(Color.BLACK);
				String bureauMsg = "Player " + (GameState.playerOrder[GameState.currentPlayerIndex]) + " has earned " + GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].getEarnedIncome() + " Elektro";
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
				
				// Draw circles AFTER other elements so they appear on top
				// Scoring track coordinates (22 positions: 0-21)
				int[][] scoringCoords = {
					{749, 247}, {808, 247}, {893, 245}, {977, 241}, {1064, 243}, {1149, 244}, {1237, 243}, {1305, 246},
					{746, 299}, {790, 298}, {834, 299}, {876, 300}, {917, 299}, {962, 300}, {1001, 298}, {1043, 301},
					{1089, 299}, {1134, 300}, {1176, 298}, {1223, 298}, {1259, 301}, {1305, 296}
				};
				
				Graphics2D bureauG2d = (Graphics2D) g;
				bureauG2d.setStroke(new BasicStroke(2));
				
				// Draw one circle for each player at their city count position
				
					int cityCount = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].getCities().size();
					
						String playerColorStr = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].getColor();
						Color playerColor = getColorFromString(playerColorStr);
						
						// Position is cityCount - 1 since arrays are 0-indexed
						int positionIdx = cityCount;
						int x = scoringCoords[positionIdx][0];
						int y = scoringCoords[positionIdx][1];
						int circleSize = 20;
						
						g.setColor(playerColor);
						g.fillOval(x - circleSize/2, y - circleSize/2, circleSize, circleSize);
						g.setColor(Color.BLACK);
						bureauG2d.drawOval(x - circleSize/2, y - circleSize/2, circleSize, circleSize);
					
				
				break;
			case "Activate Powerplants":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				drawMenu(g);
				Font ppFontLarge = Main.customFont.deriveFont(Font.BOLD, 40f);
				Font ppFontSmall = Main.customFont.deriveFont(Font.BOLD, 20f);
				g.setFont(ppFontLarge);
				g.setColor(Color.BLACK);
				g.drawString("Player " + (GameState.currentPlayerIndex + 1) + " - Activate Powerplants", 100, 100);
				
				// Display player's powerplants with images
				Player currentPPPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1];
				ArrayList<PowerPlant> playerPPs = currentPPPlayer.getPowerPlants();
				
				g.setFont(ppFontSmall);
				g.drawString("Click powerplants to activate", 100, 150);
				
				Graphics2D ppG2d = (Graphics2D) g;
				int ppDisplayXPos = 100;
				int ppDisplayYPos = 200;
				int ppImageWidth = 250;
				int ppImageHeight = 250;
				int ppSpacing = 310;
				
				if(playerPPs.size() == 0) {
					g.setFont(ppFontSmall);
					g.drawString("No power plants yet", 120, ppDisplayYPos);
				} else {
					for(int ppIdx = 0; ppIdx < playerPPs.size(); ppIdx++) {
						PowerPlant pp = playerPPs.get(ppIdx);
						int xPos = ppDisplayXPos + (ppIdx % 8) * ppSpacing;
						int yPos = ppDisplayYPos + (ppIdx / 8) * ppSpacing;
						
						// Draw powerplant image
						BufferedImage ppImage = getPowerPlantImage(pp.getPrice());
						if(ppImage != null) {
							g.drawImage(ppImage, xPos, yPos, ppImageWidth, ppImageHeight, this);
						} else {
							g.setColor(Color.LIGHT_GRAY);
							g.fillRect(xPos, yPos, ppImageWidth, ppImageHeight);
							g.setColor(Color.BLACK);
							ppG2d.setStroke(new BasicStroke(2));
							ppG2d.drawRect(xPos, yPos, ppImageWidth, ppImageHeight);
						}
						
						// Draw border - red if not activated, green if activated
						ppG2d.setStroke(new BasicStroke(5));
						if(pp.isActivated()) {
							g.setColor(Color.GREEN);
						} else {
							g.setColor(Color.RED);
						}
						ppG2d.drawRect(xPos, yPos, ppImageWidth, ppImageHeight);
						
						// Draw plant info below image
						g.setFont(ppFontSmall);
						g.setColor(Color.BLACK);
						g.drawString("Capacity: " + pp.getMaxResources(), xPos, yPos + ppImageHeight + 25);
						
						// Draw resource capabilities
						String fuelStr = "";
						for(Resource r : pp.getFuelType()) {
							fuelStr += r.toString().substring(0, 1);
						}
						g.drawString("Fuels: " + fuelStr, xPos, yPos + ppImageHeight + 45);
						
						// Draw current resources in plant
						int currentCount = pp.getCurrentResources().size();
						g.drawString("Current: " + currentCount, xPos, yPos + ppImageHeight + 65);
					}
				}
				
				// Done button
				// Move Resources button (moved to far left)
				int moveBtnW = getWidth()/5;
				int moveBtnH = (int)(getHeight() * 0.08);
				int moveBtnX = 40; // fixed left margin
				int moveBtnY = (int)(getHeight() * 0.9);
				g.setColor(Color.WHITE);
				g.fillRect(moveBtnX, moveBtnY, moveBtnW, moveBtnH);
				g.setColor(Color.BLACK);
				ppG2d.setStroke(new BasicStroke(4));
				ppG2d.drawRect(moveBtnX, moveBtnY, moveBtnW, moveBtnH);
				centerString(g, "Move Resources", moveBtnX, moveBtnY, moveBtnW, moveBtnH);

				// Done button
				int doneBtnW = getWidth()/5;
				int doneBtnX = getWidth()/2 - (getWidth()/10);
				int doneBtnY = (int)(getHeight() * 0.9);
				g.setColor(Color.WHITE);
				g.fillRect(doneBtnX, doneBtnY, doneBtnW, moveBtnH);
				g.setColor(Color.BLACK);
				ppG2d.setStroke(new BasicStroke(5));
				ppG2d.drawRect(doneBtnX, doneBtnY, doneBtnW, moveBtnH);
				centerString(g, "Done", doneBtnX, doneBtnY, doneBtnW, moveBtnH);
				break;
				
			case "Hybrid Powerplant":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Font hybridFont = Main.customFont.deriveFont(Font.PLAIN, 30f);
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
				break;
			case "Player Order":
				
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				drawMenu(g);
				Font orderFont = Main.customFont.deriveFont(Font.PLAIN, 30f);
				g.setFont(orderFont);
				g.setColor(Color.BLACK);
				g.drawString("Player Order For This Round: " + "Player "+GameState.playerOrder[0]+
				", Player "+GameState.playerOrder[1]+", Player "+GameState.playerOrder[2]+", Player "+GameState.playerOrder[3]
				, (getWidth() - 850) / 2, getHeight() / 2 - 150);
				GameState.currentPlayerIndex=0;
				break;
			
				case "Move Resources": {
					g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
					drawMenu(g);
					g.setColor(Color.BLACK);
					g.setFont(Main.customFont.deriveFont(Font.PLAIN, 28f));
					g.drawString("Move Resources - Select source then target", 100, 100);
					// Detailed instructions (right side, above powerplants)
					Font instrFont = Main.customFont.deriveFont(Font.PLAIN, 16f);
					g.setFont(instrFont);
					int instrX = getWidth()/2 + 100; // place on right half
					int instrY = 140;
					int lineH = 20;
					g.drawString("How to use:", instrX, instrY);
					g.drawString("1) Click a SOURCE plant (becomes BLUE)", instrX, instrY + lineH);
					g.drawString("2) Click a TARGET plant (becomes ORANGE)", instrX, instrY + 2*lineH);
					g.drawString("3) 'Move One' = move 1 resource", instrX, instrY + 3*lineH);
					g.drawString("4) 'Move All' = move all compatible", instrX, instrY + 4*lineH);
					Player mrPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1];
					ArrayList<PowerPlant> mrPPs = mrPlayer.getPowerPlants();
					int mr_ppDisplayXPos = 100;
					int mr_ppDisplayYPos = 160;
					int mr_ppImageWidth = 220;
					int mr_ppImageHeight = 220;
					int mr_ppSpacing = 270;
					Graphics2D mrG2 = (Graphics2D) g;
					for (int i = 0; i < mrPPs.size(); i++) {
						PowerPlant pp = mrPPs.get(i);
						int xPos = mr_ppDisplayXPos + (i % 8) * mr_ppSpacing;
						int yPos = mr_ppDisplayYPos + (i / 8) * mr_ppSpacing;
						BufferedImage ppImage = getPowerPlantImage(pp.getPrice());
						if (ppImage != null) g.drawImage(ppImage, xPos, yPos, mr_ppImageWidth, mr_ppImageHeight, this);
						else {
							g.setColor(Color.LIGHT_GRAY);
							g.fillRect(xPos, yPos, mr_ppImageWidth, mr_ppImageHeight);
							g.setColor(Color.BLACK);
							mrG2.setStroke(new BasicStroke(2));
							mrG2.drawRect(xPos, yPos, mr_ppImageWidth, mr_ppImageHeight);
						}
						// highlight selections
						mrG2.setStroke(new BasicStroke(6));
						if (i == moveSourceIndex) {
							g.setColor(new Color(30, 144, 255)); // DodgerBlue
							mrG2.drawRect(xPos - 4, yPos - 4, mr_ppImageWidth + 8, mr_ppImageHeight + 8);
						} else if (i == moveTargetIndex) {
							g.setColor(new Color(255, 140, 0)); // DarkOrange
							mrG2.drawRect(xPos - 4, yPos - 4, mr_ppImageWidth + 8, mr_ppImageHeight + 8);
						} else {
							mrG2.setStroke(new BasicStroke(4));
							mrG2.setColor(Color.DARK_GRAY);
							mrG2.drawRect(xPos, yPos, mr_ppImageWidth, mr_ppImageHeight);
						}
						// draw small resource counts
						g.setFont(Main.customFont.deriveFont(Font.PLAIN, 14f));
						g.setColor(Color.BLACK);
						g.drawString("Current: " + pp.getCurrentResources().size(), xPos, yPos + mr_ppImageHeight + 18);
					}
					// Buttons: Move One, Move All, Done (left column)
					int mr_btnW = 180, mr_btnH = 48;
					int mr_btnColX = 60; // left column X
					int mr_btnY = getHeight() - 220;
					// Move One
					int mr_mvOneX = mr_btnColX;
					g.setColor(Color.WHITE);
					g.fillRect(mr_mvOneX, mr_btnY, mr_btnW, mr_btnH);
					g.setColor(Color.BLACK);
					mrG2.setStroke(new BasicStroke(3));
					mrG2.drawRect(mr_mvOneX, mr_btnY, mr_btnW, mr_btnH);
					centerString(g, "Move One", mr_mvOneX, mr_btnY, mr_btnW, mr_btnH);
					// Move All
					int mr_mvAllX = mr_btnColX;
					g.setColor(Color.WHITE);
					g.fillRect(mr_mvAllX, mr_btnY + mr_btnH + 12, mr_btnW, mr_btnH);
					g.setColor(Color.BLACK);
					mrG2.drawRect(mr_mvAllX, mr_btnY + mr_btnH + 12, mr_btnW, mr_btnH);
					centerString(g, "Move All", mr_mvAllX, mr_btnY + mr_btnH + 12, mr_btnW, mr_btnH);
					// Done (return to Activate Powerplants)
					int mr_doneX = mr_btnColX;
					g.setColor(Color.WHITE);
					g.fillRect(mr_doneX, mr_btnY + 2*(mr_btnH + 12), mr_btnW, mr_btnH);
					g.setColor(Color.BLACK);
					mrG2.drawRect(mr_doneX, mr_btnY + 2*(mr_btnH + 12), mr_btnW, mr_btnH);
					centerString(g, "Done", mr_doneX, mr_btnY + 2*(mr_btnH + 12), mr_btnW, mr_btnH);
				}
					break;
			case "Resource Summary":
				// Show resource summary image centered (not fullscreen)
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.setColor(Color.BLACK);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 22f));
				g.drawString("Resource Summary", 100, 100);
				if(resourceSummary != null) {
					int w = Math.min(800, getWidth()/2);
					int h = (int)(w * (resourceSummary.getHeight() / (double)resourceSummary.getWidth()));
					int resX = (getWidth() - w) / 2;
					int resY = (getHeight() - h) / 2;
					g.drawImage(resourceSummary, resX, resY, w, h, this);
					// Show the yellow highlight only for the current step (1,2,3)
					int[] stepXs = {0, 937, 972, 1022}; // index by step number
					int boxW = 30;
					Color highlightColor = new Color(255, 255, 0, 120); // semi-transparent yellow
					Graphics2D g2h = (Graphics2D) g;
					g2h.setStroke(new BasicStroke(2));
					int cs = GameState.currentStep; // current step: 1,2,3...
					if(cs >= 1 && cs <= 3) {
						int hx = stepXs[cs];
						if (hx >= resX && hx <= resX + w) {
							int drawX = hx - boxW/2;
							g2h.setColor(highlightColor);
							g2h.fillRect(drawX, resY, boxW, h);
							g2h.setColor(Color.YELLOW.darker());
							g2h.drawRect(drawX, resY, boxW, h);
						}
					}
				}
				// Return to Menu button
				int retW = 220, retH = 50, retX = getWidth() - retW - 20, retY = 20;
				g.setColor(Color.WHITE);
				g.fillRect(retX, retY, retW, retH);
				g.setColor(Color.BLACK);
				((Graphics2D)g).setStroke(new BasicStroke(3));
				((Graphics2D)g).drawRect(retX, retY, retW, retH);
				centerString(g, "Return to Menu", retX, retY, retW, retH);
				break;
			case "Player Profiles":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.setColor(Color.BLACK);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 22f));
				g.drawString("Player Profiles", 100, 100);
				// Draw scoring track (reuse coords from Bureaucracy) and place player markers with slight y offsets so markers don't stack
				// Shifted to the right (40px earlier, now add ~200 more as requested)
				int shiftRight = 240;
				int[][] newScoringCoords = {
					{749 + shiftRight, 247}, {808 + shiftRight, 247}, {893 + shiftRight, 245}, {977 + shiftRight, 241}, {1064 + shiftRight, 243}, {1149 + shiftRight, 244}, {1237 + shiftRight, 243}, {1305 + shiftRight, 246},
					{746 + shiftRight, 299}, {790 + shiftRight, 298}, {834 + shiftRight, 299}, {876 + shiftRight, 300}, {917 + shiftRight, 299}, {962 + shiftRight, 300}, {1001 + shiftRight, 298}, {1043 + shiftRight, 301},
					{1089 + shiftRight, 299}, {1134 + shiftRight, 300}, {1176 + shiftRight, 298}, {1223 + shiftRight, 298}, {1259 + shiftRight, 301}, {1305 + shiftRight, 296}
				};
				if(scoringTrack!=null) g.drawImage(scoringTrack, 724 + shiftRight, 200, 600, 130, this);
				for(int i=0;i<4;i++){
					Player p = GameState.players[i];
					 cityCount = p.getCities().size();
					int posIdx = Math.max(0, Math.min(newScoringCoords.length-1, cityCount));
					int xC = newScoringCoords[posIdx][0];
					int yC = newScoringCoords[posIdx][1];
					int yOffset = (i - 1) * 8; // spread out markers vertically: -8,0,8,16
					g.setColor(getColorFromString(p.getColor()));
		 			Graphics2D g2p = (Graphics2D) g;
		 			g2p.fillOval(xC - 12, yC - 12 + yOffset, 24, 24);
		 			g2p.setColor(Color.BLACK);
		 			g2p.setStroke(new BasicStroke(2));
		 			g2p.drawOval(xC - 12, yC - 12 + yOffset, 24, 24);

            		// (star will be drawn next to the player's header below)
				}

				// Player summary list with elektro and order (Arial) - show players in playerOrder
				int infoX = 120; int infoY = 160; int lineH = 24;
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 14f));
				Color[] sphereColorsLocal = {new Color(101, 67, 33), Color.BLACK, Color.YELLOW, Color.RED};
				for(int slot=0; slot<4; slot++){
					int playerIdx = GameState.playerOrder[slot]-1; // actual player index
					Player p = GameState.players[playerIdx];
					String header = "Player "+(playerIdx+1)+" ("+p.getColor()+")  | Elektro: "+p.getElektro()+"  | Order Slot: "+(slot+1);
					g.setColor(Color.BLACK);
					g.drawString(header, infoX, infoY);
					// draw star next to player header for quick identification
					Graphics2D g2s = (Graphics2D) g;
					int starXHeader = infoX - 28; // left of the header text
					int starYHeader = infoY - 6; // vertically near the text baseline
					drawStar(g2s, starXHeader, starYHeader, 8, getColorFromString(p.getColor()));
					infoY += lineH;

					// Draw powerplants same as Buy Resources layout
					ArrayList<PowerPlant> pps = p.getPowerPlants();
					int ppX = infoX + 20;
					int ppY = infoY;
					if(pps.size() == 0) {
						g.drawString("No power plants", ppX, ppY);
						ppY += 20;
					} else {
						Graphics2D g2pp = (Graphics2D) g;
						for(PowerPlant pp : pps) {
							BufferedImage ppImage = getPowerPlantImage(pp.getPrice());
							if(ppImage != null) {
								g.drawImage(ppImage, ppX, ppY, 100, 100, this);
							} else {
								g.setColor(Color.LIGHT_GRAY);
								g.fillRect(ppX, ppY, 100, 100);
								g.setColor(Color.BLACK);
								g2pp.setStroke(new BasicStroke(2));
								g2pp.drawRect(ppX, ppY, 100, 100);
							}
							// info text
							g.setColor(Color.BLACK);
							g.drawString("Capacity: " + pp.getMaxResources(), ppX + 110, ppY + 20);
							String fuelStr = "";
							for(Resource r : pp.getFuelType()) fuelStr += r.toString().substring(0,1);
							if(fuelStr.isEmpty()) fuelStr = "Renewable";
							if(fuelStr.length() == 2) fuelStr = fuelStr.substring(0,1) + "/" + fuelStr.substring(1);
							g.drawString("Fuels: " + fuelStr, ppX + 110, ppY + 40);
							g.drawString("Current: " + pp.getCurrentResources().size(), ppX + 110, ppY + 60);

							// resource tokens drawing (compact)
							int tokenBaseX = ppX;
							int tokenBaseY = ppY + 75;
							int[] resourceCounts = {0,0,0,0};
							for(Resource r : pp.getCurrentResources()){
								if(r == Resource.COAL) resourceCounts[0]++;
								else if(r == Resource.OIL) resourceCounts[1]++;
								else if(r == Resource.GARBAGE) resourceCounts[2]++;
								else if(r == Resource.URANIUM) resourceCounts[3]++;
							}
							int drew = 0;
							for(int ri=0; ri<4; ri++){
								for(int t=0; t<resourceCounts[ri]; t++){
									g.setColor(sphereColorsLocal[ri]);
									g.fillOval(tokenBaseX + (drew%5)*14, tokenBaseY + (drew/5)*14, 12, 12);
									g.setColor(Color.WHITE);
									g2pp.setStroke(new BasicStroke(1));
									g2pp.drawOval(tokenBaseX + (drew%5)*14, tokenBaseY + (drew/5)*14, 12, 12);
									drew++;
								}
							}

							ppX += 220;
							if(ppX > getWidth() - 200) { ppX = infoX + 20; ppY += 120; }
						}
						ppY += 120;
					}
					infoY = ppY + 10;
				}

				// Return to Menu button
				int retW2 = 220, retH2 = 50, retX2 = getWidth() - retW2 - 20, retY2 = 20;
				g.setColor(Color.WHITE);
				g.fillRect(retX2, retY2, retW2, retH2);
				g.setColor(Color.BLACK);
				((Graphics2D)g).setStroke(new BasicStroke(3));
				((Graphics2D)g).drawRect(retX2, retY2, retW2, retH2);
				centerString(g, "Return to Menu", retX2, retY2, retW2, retH2);
				break;
			case "Discarded Plants":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.setColor(Color.BLACK);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 22f));
				g.drawString("Discarded Powerplants", 100, 100);
				int dx = 120; int dy = 160; int w = 140; int h = 120; int idx=0;
				for(PowerPlant pp : GameState.discardPile){
					BufferedImage img = getPowerPlantImage(pp.getPrice());
					if(img!=null) g.drawImage(img, dx + (idx%6)*(w+20), dy + (idx/6)*(h+30), w, h, this);
					else g.drawString("#"+pp.getPrice(), dx + (idx%6)*(w+20), dy + (idx/6)*(h+30));
					idx++;
				}
				if(idx==0) g.drawString("No discarded powerplants", 120, 160);
				// Return to Menu button
				int retWd = 220, retHt = 50, retXd = getWidth() - retWd - 20, retYd = 20;
				g.setColor(Color.WHITE);
				g.fillRect(retXd, retYd, retWd, retHt);
				g.setColor(Color.BLACK);
				((Graphics2D)g).setStroke(new BasicStroke(3));
				((Graphics2D)g).drawRect(retXd, retYd, retWd, retHt);
				centerString(g, "Return to Menu", retXd, retYd, retWd, retHt);
				break;
			case "Full Map":
				// Draw normal game background behind the map
				g.drawImage(gameBackground, 0, 0, getWidth(), getHeight(), this);
				// Draw board in center column (same as Buy Cities)
				int boardX = getWidth()/4;
				int boardW = getWidth()/2;
				int boardY = 0;
				int boardH = getHeight();
				if(bigBoard!=null) g.drawImage(bigBoard, boardX, boardY, boardW, boardH, this);
				else g.drawImage(board, boardX, boardY, boardW, boardH, this);

				// Draw cities the same way as the Buy Cities screen
				drawBuyCitiesUI(g);

				g.setColor(Color.BLACK);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 22f));
				
				int retWm = 220, retHm = 50, retXm = getWidth() - retWm - 20, retYm = 20;
				g.setColor(Color.WHITE);
				g.fillRect(retXm, retYm, retWm, retHm);
				g.setColor(Color.BLACK);
				((Graphics2D)g).setStroke(new BasicStroke(3));
				((Graphics2D)g).drawRect(retXm, retYm, retWm, retHm);
				centerString(g, "Return to Menu", retXm, retYm, retWm, retHm);
				break;
			case "Resource Market View":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 22f));
				g.setColor(Color.BLACK);
				g.drawString("Resource Market", 100, 100);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 14f));
				int ry = 160;
				Resource[] resTypes = {Resource.COAL, Resource.OIL, Resource.GARBAGE, Resource.URANIUM};
				for(Resource r : resTypes){
					int price = GameState.resourceMarket.getCheapestPrice(r);
					boolean[][] market = GameState.resourceMarket.getMarketForResource(r);
					int count = 0; for(boolean[] row: market) for(boolean b: row) if(b) count++;
					g.drawString(r.toString()+": " + count + " available, cheapest: $"+price, 120, ry);
					ry += 36;
				}
				int retXr = getWidth() - 240, retYr = 20;
				g.setColor(Color.WHITE); g.fillRect(retXr, retYr, 220, 50); g.setColor(Color.BLACK); ((Graphics2D)g).drawRect(retXr, retYr, 220, 50); centerString(g, "Return to Menu", retXr, retYr, 220, 50);
				break;
			case "Auction Market View":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				g.setFont(Main.customFont.deriveFont(Font.PLAIN, 22f));
				g.setColor(Color.BLACK);
				g.drawString("Auction Market", 100, 100);
				// Current Market (top 4) and Future Market (bottom 4)
				g.drawString("Current Market", 1000, 200);
				g.drawString("Future Market", 1000, 400);
				int apx = 175; int apy = 180; int apW = 150; int apH = 150;
				int marketLen = Math.min(GameState.powerPlantsInMarket.size(), 8);
				for(int i=0;i<marketLen;i++){
					PowerPlant pp = GameState.powerPlantsInMarket.get(i);
					BufferedImage img = getPowerPlantImage(pp.getPrice());
					if(img!=null) g.drawImage(img, apx + (i%4)*200, apy + (i/4)*200, apW, apH, this);
					// price removed per request
				}
				int retXa = getWidth() - 240, retYa = 20; g.setColor(Color.WHITE); g.fillRect(retXa, retYa, 220, 50); g.setColor(Color.BLACK); ((Graphics2D)g).drawRect(retXa, retYa, 220, 50); g.setFont(Main.customFont.deriveFont(Font.PLAIN, 14f)); centerString(g, "Return to Menu", retXa, retYa, 220, 50);
				break;
			case "Step Info":
				// Large centered step display
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				Graphics2D bigG = (Graphics2D) g;
				bigG.setColor(Color.BLACK);
				// Choose a very large font; scale based on panel height for responsiveness
				float size = Math.max(72f, getHeight() * 0.18f);
				Font bigFont = Main.customFont.deriveFont(Font.BOLD, size);
				bigG.setFont(bigFont);
				String stepLabel = "STEP " + GameState.currentStep;
				// Center the label in the whole panel
				centerString(g, stepLabel, 0, 0, getWidth(), getHeight());
				// Small hint to dismiss (keeps existing Return to Menu button behavior in mousePressed)
				bigG.setFont(Main.customFont.deriveFont(Font.PLAIN, 14f));
				bigG.setColor(new Color(0,0,0,140));
				bigG.drawString("(Click Return to Menu to exit)", 20, getHeight() - 20);
				break;
			case "Menu":
				// Draw the current game state underneath (already drawn by previous paint?)
				// Actually, when "Menu" is added, the previous screen is still behind.
				// We'll draw a dark overlay over the existing graphics.
				Graphics2D menuG2 = (Graphics2D) g;
				// Semi-transparent overlay
				menuG2.setColor(new Color(0, 0, 0, 200));
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);

				// Define the menu panel size (square, e.g. 800x800)
				int panelW = 800;
				int panelH = 800;
				int panelX = (getWidth() - panelW) / 2;
				int panelY = (getHeight() - panelH) / 2;

				// White background for the menu panel
				menuG2.setColor(Color.WHITE);
				menuG2.fillRect(panelX, panelY, panelW, panelH);
				menuG2.setColor(Color.BLACK);
				menuG2.setStroke(new BasicStroke(4));
				menuG2.drawRect(panelX, panelY, panelW, panelH);

				// Title "MENU" using the custom font
				Font titleFont = Main.customFont.deriveFont(Font.BOLD, 60f);
				g.setFont(titleFont);
				g.setColor(Color.BLACK);
				String title = "MENU";
				FontMetrics titleFm = g.getFontMetrics();
				int titleX = panelX + (panelW - titleFm.stringWidth(title)) / 2;
				int titleY = panelY + 80;
				g.drawString(title, titleX, titleY);

				// Draw a separator line
				int separatorY = titleY + 30;
				g.drawLine(panelX + 50, separatorY, panelX + panelW - 50, separatorY);

				// Options layout: two columns, each button 300x60, spacing 40
				Font optionFont = Main.customFont.deriveFont(Font.PLAIN, 17f);
				g.setFont(optionFont);
				FontMetrics optionFm = g.getFontMetrics();

				String[] options = {
					"Resource Summary", "Player Profiles",
					"Discarded Powerplants", "Map",
					"Resource Market", "Auction Market",
					"Rules", "Return to Game",
					"Step Info"
				};
				// Store button bounds for mouse click detection (we'll use an array)
				// But for simplicity, in mousePressed we'll recalc positions.

				int startX = panelX + 100;
				int startY = panelY + 200;
				int btnW = 280;
				int btnH = 60;
				int colSpacing = 80;
				int rowSpacing = 70;

				for (int i = 0; i < options.length; i++) {
					int col = i % 2;
					int row = i / 2;
					 x = startX + col * (btnW + colSpacing);
					 y = startY + row * (btnH + rowSpacing);

					// Draw button background
					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(x, y, btnW, btnH, 15, 15);
					g.setColor(Color.BLACK);
					g.drawRoundRect(x, y, btnW, btnH, 15, 15);

					// Center the text
					int textX = x + (btnW - optionFm.stringWidth(options[i])) / 2;
					int textY = y + (btnH - optionFm.getHeight()) / 2 + optionFm.getAscent();
					g.setColor(Color.BLACK);
					g.drawString(options[i], textX, textY);
				}
				break;
				case "Step 2":
				g.drawImage(gameBackground, 0, 0, 2048, 1152, this);
				drawMenu(g);
				Font step2Font = Main.customFont.deriveFont(Font.PLAIN, 48f);
				g.setFont(step2Font);
				g.setColor(Color.BLACK);
				g.drawString("Step 2", (getWidth() - 200) / 2, getHeight() / 2);
				break;
			
				
				



			
		}
	}
			public void drawMenu(Graphics g) {
				// Graphics2D available via cast when needed; avoid declaring unused local here
			
			// Draw the white background image (or just fill white if image is missing)
			g.drawImage(menu,1700, 10, 120, 110, this);
			
			
			
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
			case -1: return step3Card;
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
	
	private Color getColorFromString(String colorString) {
		if(colorString == null) return Color.BLACK;
		switch(colorString) {
			case "Red": return new Color(255, 0, 0);
			case "Yellow": return new Color(255, 255, 0);
			case "Green": return new Color(0, 128, 0);
			case "Blue": return new Color(0, 0, 128);
			case "Purple": return new Color(128, 0, 128);
			case "White": return Color.WHITE;
			default: return Color.BLACK;
		}
	}
	
	// Draw the "Done" button for Buy Cities phase
	private void drawDoneButton(Graphics g) {
		g.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
		g.setColor(Color.WHITE);
		g.fillRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D)(g);
		g2d.setStroke(new BasicStroke(5));
		g2d.drawRect(getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
		centerString(g, "Done", getWidth()/2 - (getWidth()/10), (int)(getHeight() * 0.925), getWidth()/5, (int)(getHeight() * 0.05));
	}
	
	// Draw all cities for the Buy Cities UI - uses 2D structure for city data
	private void drawBuyCitiesUI(Graphics g) {
		CityGraph graph = GameState.fullGraph;
		Graphics2D g2d = (Graphics2D) g;
		
		// Build 2D array of city data: [[cityName, status, x, y], ...]
		java.util.List<Object[]> cityData = new java.util.ArrayList<>();
		
		for (CityNode node : graph.getNodes()) {
			String name = node.getName();
			Point p = cityCoords.get(name);
			
			if (p == null) continue;
			
			boolean allowed = GameState.graphOfCity.contains(name);
			String status = allowed ? "available" : "unavailable";
			
			// Store city data as object array [name, status, x, y, point]
			cityData.add(new Object[]{name, status, p.x, p.y, p});
		}
		
		// Draw each city based on its status
		for (Object[] city : cityData) {
			String name = (String) city[0];
			String status = (String) city[1];
			int x = (int) city[2];
			int y = (int) city[3];
			Point p = (Point) city[4];
			
			if (status.equals("unavailable")) {
				// Draw red X for unavailable cities
				g2d.setStroke(new BasicStroke(6));
				g2d.setColor(Color.RED);
				g2d.drawLine(x - 20, y - 20, x + 20, y + 20);
				g2d.drawLine(x + 20, y - 20, x - 20, y + 20);
			} else {
				// Draw sectors for available cities
				drawCitySectors(g, name, p);
			}
		}
	}

	private void drawCitySectors(Graphics g, String cityName, Point p) {
		// Define sector positions relative to city center
		// Sector 0: top (player 1)
		// Sector 1: bottom-left (player 2)
		// Sector 2: bottom-right (player 3)
		
		int sectorSize = 12; // diameter of sector circle
		int vertOffset = 12;  // vertical offset from center
		int horzOffset = 15;  // horizontal offset from center
		
		int[][] sectorPositions = {
			{0, -vertOffset},      // Sector 0: top
			{-horzOffset, vertOffset},   // Sector 1: bottom-left
			{horzOffset, vertOffset}     // Sector 2: bottom-right
		};
		
		// Collect all players who own this city
		ArrayList<Integer> owningPlayers = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			if(GameState.players[i].getCities().contains(cityName)) {
				owningPlayers.add(i);
			}
		}
		
		// Draw a sector for each player that owns this city
		for(int idx = 0; idx < owningPlayers.size() && idx < 3; idx++) {
			int playerIndex = owningPlayers.get(idx);
			Color playerColor = getColorFromString(GameState.players[playerIndex].getColor());
			
			// Calculate sector position
			int sectorX = p.x + sectorPositions[idx][0];
			int sectorY = p.y + sectorPositions[idx][1];
			
			// Draw filled circle for the sector
			g.setColor(playerColor);
			g.fillOval(sectorX - sectorSize/2, sectorY - sectorSize/2, sectorSize, sectorSize);
		}
	}

	// Draw a 5-point star centered at (cx,cy) with outer radius r
	private void drawStar(Graphics2D g2, int cx, int cy, int r, Color fill) {
		double angle = Math.toRadians(-18); // rotate so one point is up
		int n = 5;
		double innerR = r * 0.45;
		int[] xs = new int[n*2];
		int[] ys = new int[n*2];
		for (int i = 0; i < n*2; i++) {
			double rad = (i % 2 == 0) ? r : innerR;
			double a = angle + i * Math.PI / n;
			xs[i] = cx + (int) Math.round(Math.cos(a) * rad);
			ys[i] = cy + (int) Math.round(Math.sin(a) * rad);
		}
		Color prev = g2.getColor();
		g2.setColor(fill);
		g2.fillPolygon(xs, ys, n*2);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1));
		g2.drawPolygon(xs, ys, n*2);
		g2.setColor(prev);
	}
	
	private int countPlayerSectorsInCity(String cityName) {
		int count = 0;
		Player currentPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1];
		if(currentPlayer.getCities().contains(cityName)) {
			count = 1;
		}
		return count;
	}
	
	private int countTotalSectorsInCity(String cityName) {
		int count = 0;
		for(int i = 0; i < 4; i++) {
			if(GameState.players[i].getCities().contains(cityName)) {
				count++;
			}
		}
		return count;
	}
	
	// Draw the auction UI with scaled coordinates
	private void drawAuctionUI(Graphics g) {
		Font font = Main.customFont.deriveFont(Font.PLAIN, 22f);
		g.setFont(font);
		
		// Scaled positions for 4 players (left to right) - scaled from original 100, 500, 900, 1300 at 1920 width
		int[] playerXPositions = {
			(int)(getWidth() * (100.0 / 1920.0)),    // Player 1
			(int)(getWidth() * (500.0 / 1920.0)),    // Player 2
			(int)(getWidth() * (900.0 / 1920.0)),    // Player 3
			(int)(getWidth() * (1300.0 / 1920.0))    // Player 4
		};
		int playerY = (int)(getHeight() * (800.0 / 1070.0));  
		int playerWidth = (int)(getWidth() * (400.0 / 1920.0));   
		int playerHeight = (int)(getHeight() * (175.0 / 1070.0));
		
		// Text positions relative to player cards
		int elektroY = (int)(getHeight() * (750.0 / 1070.0));  // 50 pixels above player cards
		int bidY = (int)(getHeight() * (950.0 / 1070.0));      // 150 pixels below player cards
		
		// Draw each player's auction info
		for(int i = 0; i < 4; i++) {
			drawAuctionPlayer(g, i, playerXPositions[i], playerY, playerWidth, playerHeight, elektroY, bidY);
		}
		
		// Draw current player arrow - scaled from original positions (220, 620, 1020, 1420)
		int[] arrowXPositions = {
			(int)(getWidth() * (220.0 / 1920.0)),
			(int)(getWidth() * (620.0 / 1920.0)),
			(int)(getWidth() * (1020.0 / 1920.0)),
			(int)(getWidth() * (1420.0 / 1920.0))
		};
		int arrowY = (int)(getHeight() * (500.0 / 1070.0));
		int arrowWidth = (int)(getWidth() * (250.0 / 1920.0));
		int arrowHeight = (int)(getHeight() * (200.0 / 1070.0));
		
		int currentPlayerIndex = GameState.playerOrderInAuction.get(GameState.auctionPlayerIndex);
		g.drawImage(arrow, arrowXPositions[currentPlayerIndex], arrowY, arrowWidth, arrowHeight, this);
		drawMenu(g);
	}
	
	// Draw individual auction player UI
	private void drawAuctionPlayer(Graphics g, int playerIndex, int x, int y, int width, int height, int elektroY, int bidY) {
		// Draw colored rectangle behind player image
		String playerColor = GameState.players[playerIndex].getColor();
		if(playerColor != null) {
			Color bgColor = getColorFromString(playerColor);
			if(bgColor != null) {
				g.setColor(bgColor);
				g.fillRect(x, y, width, height);
			}
		}
		
		// Draw player image
		BufferedImage playerImage = null;
		if(playerIndex == 0) playerImage = auctionImagePlayerOne;
		else if(playerIndex == 1) playerImage = auctionImagePlayerTwo;
		else if(playerIndex == 2) playerImage = auctionImagePlayerThree;
		else if(playerIndex == 3) playerImage = auctionImagePlayerFour;
		
		if(playerImage != null) {
			g.drawImage(playerImage, x, y, width, height, this);
		}
		
		// Draw grayed out overlay if player is out or passed
		if(!GameState.players[playerIndex].getInAuction() || GameState.players[playerIndex].getHasPassed()) {
			Color halfTransparentBlack = new Color(0, 0, 0, 127);
			g.setColor(halfTransparentBlack);
			g.fillRect(x, y, width, height);
		} else {
			// Draw Elektro amount with original positioning
			g.setColor(Color.BLACK);
			Font font = Main.customFont.deriveFont(Font.PLAIN, 22f);
			g.setFont(font);
			int elektroX = x + (int)(width * 0.25);  // ~100 pixels into player card (original was 200 for player at 100)
			g.drawString(GameState.players[playerIndex].getElektro() + " Elektro", elektroX, elektroY);
		}
		
		// Draw bid amount with color coding
		int bid = GameState.players[playerIndex].getBid() + GameState.players[playerIndex].getGhostBid();
		if(GameState.players[playerIndex].getGhostBid() != 0) {
			g.setColor(Color.BLUE);
			if(bid > GameState.minBid) {
				g.setColor(new Color(0, 100, 0));
			}
			if(bid <= GameState.minBid || bid > GameState.players[playerIndex].getElektro()) {
				g.setColor(Color.RED);
			}
		} else {
			g.setColor(Color.BLACK);
		}
		
		Font bidFont = Main.customFont.deriveFont(Font.PLAIN, 22f);
		g.setFont(bidFont);
		int bidX = x + (int)(width * 0.25);  // ~100 pixels into player card (original was 200 for player at 100)
		g.drawString(bid + "", bidX, bidY);
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.println(GameState.playerOrderInAuction);
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
				if (x >= 1280 && x <= 1800 && y >= 800 && y <= 900) {
					GameState.currentEvent.removeLast();
					GameState.currentEvent.add("Color Selection");
					repaint();
				}
				// Check if Rules button was clicked
				else if (x >= 1280 && x <= 1800 && y >= 950 && y <= 1050) {
				
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

				// Return button bounds (centered horizontally, higher position)
				int returnButtonX = getWidth()/2 - 60;
				int returnButtonY = 20;
				int returnButtonWidth = 120;
				int returnButtonHeight = 50;

				if (x >= incX1 && x <= incX2 && y >= incY1 && y <= incY2) {
					rulecounter++;
				} else if (x >= decX1 && x <= decX2 && y >= decY1 && y <= decY2) {
					rulecounter--;
				} else if (x >= returnButtonX && x <= returnButtonX + returnButtonWidth && y >= returnButtonY && y <= returnButtonY + returnButtonHeight) {
					// Return to Title Screen
					GameState.currentEvent.removeLast();
					
				}

				// Wrap-around logic
				if (rulecounter < 0) {
					rulecounter = 11;
				} else if (rulecounter > 11) {
					rulecounter = 0;
				}

				repaint();
				System.out.println("ruleCounter is now: " + rulecounter);
				break;

			case "Color Selection":
				if (x >= 574 && x <= 724 && y >= 501 && y <= 651 && !GameState.isColorSelected[0]) {
					GameState.isColorSelected[0] = true;
					GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].setColor("Red");
					GameState.currentPlayerIndex++;
				} else if (x>=724 && x <= 874 && y >= 501 && y <= 651 && !GameState.isColorSelected[1]) {
					GameState.isColorSelected[1] = true;
					GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].setColor("Yellow");
					GameState.currentPlayerIndex++;
				} else if (x >= 874 && x <= 1024 && y >= 501 && y <= 651 && !GameState.isColorSelected[2]) {
					GameState.isColorSelected[2] = true;
					GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].setColor("Green");
					GameState.currentPlayerIndex++;
				} else if (x >= 1024 && x <= 1174 && y >= 501 && y <= 651 && !GameState.isColorSelected[3]) {
					GameState.isColorSelected[3] = true;
					GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].setColor("Blue");
					GameState.currentPlayerIndex++;
				} else if (x >= 1174 && x <= 1324 && y >= 501 && y <= 651 && !GameState.isColorSelected[4]) {
					GameState.isColorSelected[4] = true;
					GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].setColor("Purple");
					GameState.currentPlayerIndex++;
				} else if (x >= 1324 && x <= 1474 && y >= 501 && y <= 651 && !GameState.isColorSelected[5]) {
					GameState.isColorSelected[5] = true;
					GameState.players[GameState.playerOrder[GameState.currentPlayerIndex] - 1].setColor("White");
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
				}else if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
						GameState.currentEvent.add("Menu");
				}
				
				if(GameState.currentPlayerIndex == 4) {
					x=0;
					y=0;
					GameState.currentEvent.removeLast();
					GameState.currentPlayerIndex = 0;
					GameState.setUpAuction();
				}

		repaint();
		break;
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
					if(GameState.players[GameState.playerOrderInAuction.get(0)].getElektro()<GameState.powerPlantsInMarket.get(0).getPrice()-1)
						return;
					GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(0);
					
					GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				// Automatically make minimum bid and lock it in
				GameState.players[GameState.playerOrderInAuction.get(0)].setBid(GameState.minBid+1);
				GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
				GameState.players[GameState.playerOrderInAuction.get(0)].useGhostBid();
				GameState.currentEvent.removeLast();
				
				GameState.continueAuction();

			} else if (x >= 375 && x <= 525) {
				if(GameState.players[GameState.playerOrderInAuction.get(0)].getElektro()<GameState.powerPlantsInMarket.get(1).getPrice()-1)
						return;
				GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(1);
				GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				// Automatically make minimum bid and lock it in
				GameState.players[GameState.playerOrderInAuction.get(0)].setBid(GameState.minBid+1);
				GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
				GameState.players[GameState.playerOrderInAuction.get(0)].useGhostBid();
				GameState.currentEvent.removeLast();
				
				GameState.continueAuction();
			
			} else if (x >= 575 && x <= 725) {
				if(GameState.players[GameState.playerOrderInAuction.get(0)].getElektro()<GameState.powerPlantsInMarket.get(2).getPrice()-1)
						return;
				GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(2);
				GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				// Automatically make minimum bid and lock it in
				GameState.players[GameState.playerOrderInAuction.get(0)].setBid(GameState.minBid+1);
				GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
				GameState.players[GameState.playerOrderInAuction.get(0)].useGhostBid();
				GameState.currentEvent.removeLast();
				
				GameState.continueAuction();

			} else if (x >= 775 && x <= 925) {
				if(GameState.players[GameState.playerOrderInAuction.get(0)].getElektro()<GameState.powerPlantsInMarket.get(3).getPrice()-1)
						return;
				GameState.auctionedPowerPlant = GameState.powerPlantsInMarket.get(3);
				GameState.minBid = GameState.auctionedPowerPlant.getPrice()-1;
				// Automatically make minimum bid and lock it in
				GameState.players[GameState.playerOrderInAuction.get(0)].setBid(GameState.minBid+1);
				GameState.players[GameState.playerOrderInAuction.get(0)].setGhostBid(0);
				GameState.players[GameState.playerOrderInAuction.get(0)].useGhostBid();
				GameState.currentEvent.removeLast();
				
				GameState.continueAuction();
			}
		}
		else if (x >= getWidth() - 200 && x <= getWidth() - 50 && y >= getHeight() - 110 && y <= getHeight() - 50){
			x=0;y=0;
			GameState.players[GameState.playerOrderInAuction.get(0)].setInAuction(false);
			
			if(GameState.playerOrderInAuction.size()==2){
			GameState.currentEvent.removeFirst();
			GameState.currentEvent.removeFirst();
			System.out.println(GameState.playerOrderInAuction);
			GameState.playerOrderInAuction.remove(0);
				GameState.currentEvent.add("Buy Powerplant");
			}else{ 
				GameState.playerOrderInAuction.remove(0);
			}

		}
					repaint();
					break;
			case "Buy Powerplant":
				System.out.println(GameState.playerOrderInAuction);
				if (y >= 150 && y <= 300) {

				if (x >= 175 && x <= 325) {
					if(GameState.players[GameState.playerOrderInAuction.get(0)].getElektro()<GameState.powerPlantsInMarket.get(0).getPrice()-1)
						return;
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
					if(GameState.players[GameState.playerOrderInAuction.get(0)].getElektro()<GameState.powerPlantsInMarket.get(1).getPrice()-1)
						return;
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
					if(GameState.players[GameState.playerOrderInAuction.get(0)].getElektro()<GameState.powerPlantsInMarket.get(2).getPrice()-1)
						return;
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
					if(GameState.players[GameState.playerOrderInAuction.get(0)].getElektro()<GameState.powerPlantsInMarket.get(3).getPrice()-1)
						return;
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
				
		}else if (x >= getWidth() - 200 && x <= getWidth() - 50 && y >= getHeight() - 110 && y <= getHeight() - 50&&!GameState.firstRoundOfAuction){
			GameState.players[GameState.playerOrderInAuction.get(0)].setInAuction(false);
			GameState.playerOrderInAuction.remove(0);
			
				GameState.currentEvent.removeFirst();
				
				GameState.currentEvent.add("Buy Resources");
			
			}
			repaint();
				break;
			case "Auction":
				if (y >= 900 && y <= 950) {

				// Scaled click coordinates from original 1920 width
				int[][] coords = {
					{(int)(getWidth() * (100.0/1920.0)), (int)(getWidth() * (250.0/1920.0)), (int)(getWidth() * (320.0/1920.0)), (int)(getWidth() * (410.0/1920.0))},     // Player 1
					{(int)(getWidth() * (500.0/1920.0)), (int)(getWidth() * (650.0/1920.0)), (int)(getWidth() * (720.0/1920.0)), (int)(getWidth() * (810.0/1920.0))},     // Player 2
					{(int)(getWidth() * (900.0/1920.0)), (int)(getWidth() * (1050.0/1920.0)), (int)(getWidth() * (1120.0/1920.0)), (int)(getWidth() * (1210.0/1920.0))},  // Player 3
					{(int)(getWidth() * (1300.0/1920.0)), (int)(getWidth() * (1450.0/1920.0)), (int)(getWidth() * (1520.0/1920.0)), (int)(getWidth() * (1610.0/1920.0))}  // Player 4
				};

				int pIndex = GameState.playerOrderInAuction.get(GameState.auctionPlayerIndex);  
				Player p = GameState.players[pIndex];

				if (!p.getInAuction()) return;

				int[] c = coords[pIndex];

				// + ghost bid
				if (x >= c[0] && x <= c[0] + 50) {
					p.setGhostBid(p.getGhostBid() + 1);
					repaint();
					return;
				}

				// - ghost bid
				if (x >= c[1] && x <= c[1] + 50) {
					p.setGhostBid(p.getGhostBid() - 1);
					repaint();
					return;
				}

				// PASS
				if (x >= c[2] && x <= c[2] + 80) {
					p.setHasPassed(true);
					p.setBid(0);
					p.setGhostBid(0);
					GameState.continueAuction();
					repaint();
					return;
				}

				// CONFIRM BID
				if (x >= c[3] && x <= c[3] + 70) {
					if (p.getGhostBid() + p.getBid() > GameState.minBid) {
						p.useGhostBid();
						GameState.continueAuction();
					}
				}
			}else if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
						GameState.currentEvent.add("Menu");
						repaint();
						return;
				}
				
			
				repaint();
				break;

				case "Buy Resources":
					 if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
						
						GameState.currentEvent.add("Menu");
						repaint();
						return;
						
				}

						// Done button clicked
						if (x >= getWidth()/2 - (getWidth()/10) &&
							x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 &&
							y >= (int)(getHeight() * 0.9) &&
							y <= (int)(getHeight() * 0.9) + (int)(getHeight() * 0.08)) {

							GameState.currentPlayerIndex++;

							if (GameState.currentPlayerIndex == 4) {
								GameState.currentPlayerIndex = 0;
								GameState.currentEvent.removeLast();
								GameState.currentEvent.add("Buy Cities");
							}
						}

						// Current player
						Player buyPlayer = GameState.players[
							GameState.playerOrder[GameState.currentPlayerIndex] - 1
						];

						Resource[] resourceTypes = {
							Resource.COAL, Resource.OIL, Resource.GARBAGE, Resource.URANIUM
						};

						int resourceYPosClick = resourceButtonStartY;

						for (int r = 0; r < 4; r++) {

							// Buy button hitbox
							if (x >= 750 && x <= 830 &&
								y >= resourceYPosClick - 20 &&
								y <= resourceYPosClick + 20) {

								int price = GameState.resourceMarket.getCheapestPrice(resourceTypes[r]);

								if (price >= 0) {

									if (buyPlayer.getElektro() >= price &&
										buyPlayer.canAddResource(resourceTypes[r], 1)) {

										boolean bought = GameState.resourceMarket.buyResource(resourceTypes[r]);

										if (bought) {
											GameState.selectedResourceForAddition = resourceTypes[r];
											GameState.currentEvent.add("Select Resource");
											
											buyPlayer.addElektro(-price);
											repaint();
											return;

											
										}

									} else if (!buyPlayer.canAddResource(resourceTypes[r], 1)) {

										System.out.println(
											"Player " + (GameState.currentPlayerIndex + 1) +
											" does not have capacity for more resources"
										);

									} else {

										System.out.println(
											"Player " + (GameState.currentPlayerIndex + 1) +
											" does not have enough Elektro"
										);
									}

								} else {
									System.out.println(resourceTypes[r] + " is sold out");
								}
							}

							resourceYPosClick += 60;
						}

						repaint();
						break;

			case "Select Resource":
				// Menu button
				if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
					GameState.currentEvent.add("Menu");
					repaint();
					return;
				}
				
				Player selectPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1];
				ArrayList<PowerPlant> selectPlayerPowerPlants = selectPlayer.getPowerPlants();
				int numPlantsToShow = Math.min(3, selectPlayerPowerPlants.size());
				
				if(numPlantsToShow > 0) {
					// Calculate spacing for 3 plants (matching paint method)
					int plantWidth = (int)(getWidth() * 0.25);
					int plantHeight = (int)(getHeight() * 0.65);
					int baseX = (int)(getWidth() * 0.1);
					int spacing = (int)(getWidth() * 0.3);
					int baseY = (int)(getHeight() * 0.25);
					
					for(int i = 0; i < numPlantsToShow; i++) {
						PowerPlant pp = selectPlayerPowerPlants.get(i);
						int plantX = baseX + (i * spacing);
						int plantY = baseY;
						
						// Check if click is within this plant card
						if (x >= plantX && x <= plantX + plantWidth && y >= plantY && y <= plantY + plantHeight) {
							// Add the selected resource to this power plant
							if(pp.getCurrentResources().size() < pp.getMaxResources()) {
								// Check if this powerplant can use this resource type
								boolean canUseResource = false;
								if(GameState.selectedResourceForAddition == null) {
									canUseResource = false;
								} else if(pp.getFuelType().isEmpty()) {
									// Renewable plant can't use resources
									canUseResource = false;
								} else if(pp.getFuelType().contains(GameState.selectedResourceForAddition)) {
									canUseResource = true;
								}
								
								if(canUseResource) {
									pp.addResource(GameState.selectedResourceForAddition);
									
									
									// Return to Buy Resources
									GameState.currentEvent.removeLast();
									repaint();
									return;
								} else {
									System.out.println("This power plant cannot use " + GameState.selectedResourceForAddition);
								}
							} else {
								System.out.println("This power plant is at maximum capacity");
							}
						}
					}
				}
				repaint();
				break;

				
							case "Buy Cities":
								 if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
						
						GameState.currentEvent.add("Menu");
						repaint();
						return;
						
				}
				// Check if Done button was clicked
				if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
				&& y >= (int)(getHeight() * 0.925) && y <= (int)(getHeight() * 0.925) + (int)(getHeight() * 0.05)) {
					GameState.currentPlayerIndex++;
					if(GameState.currentPlayerIndex == 4) {
						GameState.currentPlayerIndex = 0;
						GameState.currentEvent.removeLast();
						for(Player p : GameState.players) {
							for(PowerPlant pp : p.getPowerPlants()) {
								pp.setActivated(false);
							}
						}
						GameState.currentEvent.add("Activate Powerplants");
					}
				} else {
					// Reset previously selected city
					GameState.cityNameForPurchase = null;
					
					// Use the scaled coordinates from cityCoords (populated during paint)
					int clickRadius = 30;
					for (Map.Entry<String, Point> entry : cityCoords.entrySet()) {
						String cityName = entry.getKey();
						Point p = entry.getValue();
						double dist = Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
						if (dist <= clickRadius && GameState.graphOfCity.contains(cityName)) {
							GameState.cityNameForPurchase = cityName;
							System.out.println("Clicked city: " + cityName);
							break;
						}
					}
					
					// Only proceed if a city was actually selected
					if (GameState.cityNameForPurchase != null) {
						// Check if player already owns a sector in this city
						if(countPlayerSectorsInCity(GameState.cityNameForPurchase) > 0) {
							System.out.println("Player already owns a sector in " + GameState.cityNameForPurchase);
						} else if(GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1].getCities().size() == 0 
								&& countTotalSectorsInCity(GameState.cityNameForPurchase) > 0) {
							// Player has no cities and cannot buy in a city that already has a player
							System.out.println("Player must build their first city in an empty city");
						} else {
							// Calculate base price
							int basePrice;
							if(GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1].getCities().size() == 0){
								basePrice = 0;
							} else {
								int lowestShortestPath = Integer.MAX_VALUE;
								for(String cityNameIter : GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1].getCities()){
									int pathLength = GameState.graphOfCity.getShortestPath(cityNameIter, GameState.cityNameForPurchase);
									if(lowestShortestPath > pathLength)
										lowestShortestPath = pathLength;
								}
								basePrice = lowestShortestPath;
							}
							
							// Add sector cost on top of base price
							int totalSectors = countTotalSectorsInCity(GameState.cityNameForPurchase);
							if(totalSectors == 0) {
								// First sector: base price
								GameState.setPriceForCity = basePrice+10;
							} else if(totalSectors == 1) {
								// Second sector: base price + 15
								GameState.setPriceForCity = basePrice + 15;
							} else if(totalSectors == 2) {
								// Third sector: base price + 20
								GameState.setPriceForCity = basePrice + 20;
							}
								if(GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1].getElektro()>=GameState.setPriceForCity) {
									GameState.currentEvent.add("Confirm City Purchase");
								} else {
									// Player doesn't have enough elektro - show Too Broke screen
									GameState.currentEvent.add("Too Broke");
								}
						}
					}
				}
				repaint();
				break;
				case "Confirm City Purchase":
					// Yes button clicked
					 if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
						
						GameState.currentEvent.add("Menu");
						repaint();
						return;
						
				}
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

				case "Too Broke":
					// Any click on Too Broke screen returns to Buy Cities
					GameState.currentEvent.removeLast();
					repaint();
					break;

				case "Bureaucracy":
					 if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
						
						GameState.currentEvent.add("Menu");
						repaint();
						return;
						
				}
					// Any click continues to next phase
					if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
					   && y >= (int)(getHeight() * 0.75) && y <= (int)(getHeight() * 0.75) + (int)(getHeight() * 0.08)) {
						GameState.currentPlayerIndex++;
						if(GameState.currentPlayerIndex == 4) {
							GameState.currentPlayerIndex = 0;
							GameState.currentEvent.removeLast();
							 GameState.newRound();
						}
					}
					repaint();
					break;
				case "Activate Powerplants":
					 if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
						
						GameState.currentEvent.add("Menu");
						repaint();
						return;
						
				}
					// Check if Move Resources button clicked (far left)
					int moveBtnW = getWidth()/5;
					int moveBtnX = 40; // far left
					int moveBtnY = (int)(getHeight() * 0.9);
					if (x >= moveBtnX && x <= moveBtnX + moveBtnW && y >= moveBtnY && y <= moveBtnY + (int)(getHeight() * 0.08)) {
						// open Move Resources UI
						moveSourceIndex = -1;
						moveTargetIndex = -1;
						GameState.currentEvent.add("Move Resources");
						repaint();
						break;
					}
					// Check if Done button clicked
					if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
					   && y >= (int)(getHeight() * 0.9) && y <= (int)(getHeight() * 0.9) + (int)(getHeight() * 0.08)) {
						GameState.currentPlayerIndex++;
						if(GameState.currentPlayerIndex == 4) {
							GameState.currentPlayerIndex = 0;
							GameState.currentEvent.removeLast();
							GameState.runBureaucracy();
							GameState.currentEvent.add("Bureaucracy");
						}
					} else {
						// Check if a powerplant was clicked
						Player clickedPPPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1];
						ArrayList<PowerPlant> clickedPlayerPPs = clickedPPPlayer.getPowerPlants();
						
						int ppDisplayXPos = 100;
						int ppDisplayYPos = 200;
						int ppImageWidth = 250;
						int ppImageHeight = 250;
						int ppSpacing = 310;
						
						for(int ppIdx = 0; ppIdx < clickedPlayerPPs.size(); ppIdx++) {
							PowerPlant pp = clickedPlayerPPs.get(ppIdx);
							int xPos = ppDisplayXPos + (ppIdx % 8) * ppSpacing;
							int yPos = ppDisplayYPos + (ppIdx / 8) * ppSpacing;
							
							// Check if click is within this powerplant's bounds
							if(x >= xPos && x <= xPos + ppImageWidth && y >= yPos && y <= yPos + ppImageHeight) {
								
								// Check if powerplant has enough resources to activate
								int currentResourceCount = pp.getCurrentResources().size();
								if(currentResourceCount >= pp.getFuelCost()) {
									// Toggle activation
									
									pp.setActivated(!pp.isActivated());
								}
								break;
							}
						}
					}
					repaint();
					break;
				case "Hybrid Powerplant":
					// Confirm button clicked
					if(x >= getWidth()/2 - (getWidth()/10) && x <= getWidth()/2 - (getWidth()/10) + getWidth()/5 
					   && y >= (int)(getHeight() * 0.75) && y <= (int)(getHeight() * 0.75) + (int)(getHeight() * 0.08)) {
						// Confirm resource selection and return to Activate Powerplants
						GameState.currentEvent.removeLast();
					}
					repaint();
					break;
				case "Player Order":
					 if (x >= 1700 && x <= 1820 && y >= 10 && y <= 120) {
						
						GameState.currentEvent.add("Menu");
						repaint();
						return;
					
						
				}
					GameState.currentEvent.removeLast();
					GameState.setUpAuction();
					repaint();
					break;
				case "Move Resources": {
					// handle clicks in Move Resources UI
					Player mrPlayer = GameState.players[GameState.playerOrder[GameState.currentPlayerIndex]-1];
					ArrayList<PowerPlant> mrPPs = mrPlayer.getPowerPlants();
					int mr_ppDisplayXPos = 100;
					int mr_ppDisplayYPos = 160;
					int mr_ppImageWidth = 220;
					int mr_ppImageHeight = 220;
					int mr_ppSpacing = 270;
					int mr_btnW = 180, mr_btnH = 48;
					int mr_btnColX = 60; // left column for the Move UI buttons
					int mr_btnY = getHeight() - 220;
					int mr_mvOneX = mr_btnColX;
					int mr_mvAllX = mr_btnColX;
					int mr_doneX = mr_btnColX;
					// Done button clicked -> return to Activate Powerplants
					if (x >= mr_doneX && x <= mr_doneX + mr_btnW && y >= mr_btnY + 2*(mr_btnH + 12) && y <= mr_btnY + 2*(mr_btnH + 12) + mr_btnH) {
						GameState.currentEvent.removeLast();
						repaint();
						break;
					}
					// Move One
					if (x >= mr_mvOneX && x <= mr_mvOneX + mr_btnW && y >= mr_btnY && y <= mr_btnY + mr_btnH) {
						if (moveSourceIndex >= 0 && moveTargetIndex >= 0 && moveSourceIndex < mrPPs.size() && moveTargetIndex < mrPPs.size()) {
							PowerPlant src = mrPPs.get(moveSourceIndex);
							PowerPlant tgt = mrPPs.get(moveTargetIndex);
							ArrayList<Resource> srcRes = src.getCurrentResources();
							for (int i = 0; i < srcRes.size(); i++) {
								Resource r = srcRes.get(i);
								if (tgt.getCurrentResources().size() < tgt.getMaxResources() && tgt.getFuelType().contains(r)) {
									srcRes.remove(i);
									tgt.addResource(r);
									break;
								}
							}
						}
						repaint();
						break;
					}
					// Move All
					if (x >= mr_mvAllX && x <= mr_mvAllX + mr_btnW && y >= mr_btnY + mr_btnH + 12 && y <= mr_btnY + mr_btnH + 12 + mr_btnH) {
						if (moveSourceIndex >= 0 && moveTargetIndex >= 0 && moveSourceIndex < mrPPs.size() && moveTargetIndex < mrPPs.size()) {
							PowerPlant src = mrPPs.get(moveSourceIndex);
							PowerPlant tgt = mrPPs.get(moveTargetIndex);
							boolean moved = true;
							while (moved) {
								moved = false;
								ArrayList<Resource> srcRes = src.getCurrentResources();
								for (int i = 0; i < srcRes.size(); i++) {
									Resource r = srcRes.get(i);
									if (tgt.getCurrentResources().size() < tgt.getMaxResources() && tgt.getFuelType().contains(r)) {
										srcRes.remove(i);
										tgt.addResource(r);
										moved = true;
										break;
									}
								}
							}
						}
						repaint();
						break;
					}
					// Otherwise, check if a powerplant image was clicked to select source/target
					for (int i = 0; i < mrPPs.size(); i++) {
						int xPos = mr_ppDisplayXPos + (i % 8) * mr_ppSpacing;
						int yPos = mr_ppDisplayYPos + (i / 8) * mr_ppSpacing;
						if (x >= xPos && x <= xPos + mr_ppImageWidth && y >= yPos && y <= yPos + mr_ppImageHeight) {
							if (moveSourceIndex == -1) {
								moveSourceIndex = i;
							} else if (moveTargetIndex == -1 && i != moveSourceIndex) {
								moveTargetIndex = i;
							} else if (i == moveSourceIndex) {
								moveSourceIndex = -1;
							} else if (i == moveTargetIndex) {
								moveTargetIndex = -1;
							} else {
								moveSourceIndex = i;
								moveTargetIndex = -1;
							}
						repaint();
						break;
						}
					}
					break;
				}
						case "Resource Summary":
					// Return button (top-right)
					int retX_rs = getWidth() - 240, retY_rs = 20, retW_rs = 220, retH_rs = 50;
					if (x >= retX_rs && x <= retX_rs + retW_rs && y >= retY_rs && y <= retY_rs + retH_rs) {
						GameState.currentEvent.removeLast();
						repaint();
						return;
					}
					// otherwise ignore clicks
					break;
				case "Player Profiles":
					int retX_pp = getWidth() - 240, retY_pp = 20, retW_pp = 220, retH_pp = 50;
					if (x >= retX_pp && x <= retX_pp + retW_pp && y >= retY_pp && y <= retY_pp + retH_pp) {
						GameState.currentEvent.removeLast();
						repaint();
						return;
					}
					break;
				case "Discarded Plants":
					int retX_dp = getWidth() - 240, retY_dp = 20, retW_dp = 220, retH_dp = 50;
					if (x >= retX_dp && x <= retX_dp + retW_dp && y >= retY_dp && y <= retY_dp + retH_dp) {
						GameState.currentEvent.removeLast();
						repaint();
						return;
					}
					break;
				case "Full Map":
					int retX_fm = getWidth() - 240, retY_fm = 20, retW_fm = 220, retH_fm = 50;
					if (x >= retX_fm && x <= retX_fm + retW_fm && y >= retY_fm && y <= retY_fm + retH_fm) {
						GameState.currentEvent.removeLast();
						repaint();
						return;
					}
					break;
				case "Resource Market View":
					int retX_rm = getWidth() - 240, retY_rm = 20, retW_rm = 220, retH_rm = 50;
					if (x >= retX_rm && x <= retX_rm + retW_rm && y >= retY_rm && y <= retY_rm + retH_rm) {
						GameState.currentEvent.removeLast();
						repaint();
						return;
					}
					break;
				case "Auction Market View":
					int retX_am = getWidth() - 240, retY_am = 20, retW_am = 220, retH_am = 50;
					if (x >= retX_am && x <= retX_am + retW_am && y >= retY_am && y <= retY_am + retH_am) {
						GameState.currentEvent.removeLast();
						repaint();
						return;
					}
					break;
				case "Step Info":
					int retX_si = getWidth() - 240, retY_si = 20, retW_si = 220, retH_si = 50;
					if (x >= retX_si && x <= retX_si + retW_si && y >= retY_si && y <= retY_si + retH_si) {
						GameState.currentEvent.removeLast();
						repaint();
						return;
					}
					break;
					case "Menu":
					// Recalculate panel and button positions (same as in paint)
					int panelW = 800;
					int panelH = 800;
					int panelX = (getWidth() - panelW) / 2;
					int panelY = (getHeight() - panelH) / 2;

					int startX = panelX + 100;
					int startY = panelY + 200;
					int btnW = 280;
					int btnH = 60;
					int colSpacing = 80;
					int rowSpacing = 70;

					String[] options = {
						"Resource Summary", "Player Profiles",
						"Discarded Powerplants", "Map",
						"Resource Market", "Auction Market",
						"Rules", "Return to Game",
						"Step Info"
					};

					for (int i = 0; i < options.length; i++) {
						int col = i % 2;
						int row = i / 2;
						int btnX = startX + col * (btnW + colSpacing);
						int btnY = startY + row * (btnH + rowSpacing);

						if (x >= btnX && x <= btnX + btnW && y >= btnY && y <= btnY + btnH) {
							// Handle each option
							switch (i) {
								case 0: // Resource Summary
									// Show resource summary card (implement as new event or dialog)
									GameState.currentEvent.add("Resource Summary");
									break;
								case 1: // Player Profiles
								//Should show player color, player number of cities (scoring track) player order, powerplants, relevant data concerning said powe
								//r plants, and elektro
									GameState.currentEvent.add("Player Profiles");
									break;
								case 2: // Discarded Powerplants 
									GameState.currentEvent.add("Discarded Plants");
									break;
								case 3: // Map shows the map with all the cities and the removed zones with the red x's
									GameState.currentEvent.add("Full Map");
									break;
								case 4: // Resource Market shows the resource market (with the better GUI preferrably)
									GameState.currentEvent.add("Resource Market View");
									break;
								case 5: // Auction Market shows the auction market similar to 
									GameState.currentEvent.add("Auction Market View");
									break;
								case 6: // Rules
									// Reuse instructions but keep menu stack?
									GameState.currentEvent.add("Instructions");
									break;
								case 7: // Return to Game
									GameState.currentEvent.removeLast(); // remove "Menu"
									repaint();
									return;
								case 8: // Step Info
									GameState.currentEvent.add("Step Info");
									break;
							}
							repaint();
							return;
					 
						
					
						}
					}
					repaint();
					break;
					
				

				case "Step 2":
					GameState.currentEvent.removeLast();
					repaint();
					break;
				
					}
}

	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		cityCoords=new HashMap<>();
		loadCityCoordinates();
		repaint();
	}
	
	public void mouseExited(MouseEvent e) {
		cityCoords=new HashMap<>();
		loadCityCoordinates();
		repaint();
	}
	
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
}
