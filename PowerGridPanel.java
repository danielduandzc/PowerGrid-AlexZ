import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.geom.AffineTransform;
import java.util.*;
import static java.lang.System.*;

public class PowerGridPanel extends JPanel implements KeyListener, MouseListener {
	public PowerGridPanel() {
		
		try {
			
		} catch (Exception E) {
			
		}
		
		addKeyListener(this);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	public void mouseClicked(MouseEvent e) {
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
