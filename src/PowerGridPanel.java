package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class PowerGridPanel extends JPanel implements KeyListener, MouseListener {
	private int screenNum = 0; // 0 = title, 1 = instructions, 2 = game 
	
	public PowerGridPanel() {
		
		try {
			
		} catch (Exception E) {
			
		}
		
		addKeyListener(this);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if (screenNum == 0) {
			// title screen
			 Font sizedFont = Main.customFont.deriveFont(Font.BOLD, 100f);
			g.setFont(sizedFont);
			g.drawString("POWER GRID", 200, 200);
			sizedFont = Main.customFont.deriveFont(Font.PLAIN, 50f);
			g.setFont(sizedFont);
			g.drawString("Click to Start", 350, 400);
		} else if (screenNum == 1) {
			// instructions
			Font sizedFont = Main.customFont.deriveFont(Font.PLAIN, 50f);
			g.setFont(sizedFont);
			g.drawString("Instructions", 350, 100);
			 sizedFont = Main.customFont.deriveFont(Font.PLAIN, 30f);
			g.setFont(sizedFont);
			g.drawString("1. Click to place power plants.", 100, 200);
			g.drawString("2. Connect cities to power plants.", 100, 250);
			g.drawString("3. Manage resources and expand your grid.", 100, 300);
			g.drawString("Click to Start Game", 300, 400);
		} else if (screenNum == 2) {
			// game screen
			Font sizedFont = Main.customFont.deriveFont(Font.BOLD, 50f);
			g.setFont(sizedFont);
			g.drawString("Game Screen - Under Construction", 100, 200);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
        int y = e.getY();
		if (screenNum == 0 && x >= 350 && x <= 650 && y >= 350 && y <= 450) {
			screenNum = 1;
		} else if (screenNum == 1 && x >= 300 && x <= 700 && y >= 350 && y <= 450) {
			screenNum = 2;
		}
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		repaint();
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
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
