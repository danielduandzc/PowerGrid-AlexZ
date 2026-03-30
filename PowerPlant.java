package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

public class PowerPlant extends JPanel implements KeyListener, MouseListener {
    int maxResources; 
    int powerOutput; 
    int price;
    int fuelCost;
    ArrayList<Resource> fuelType;
    ArrayList<Resource> currentResources = new ArrayList<Resource>();  
    BufferedImage image;


    public PowerPlant(int maxResources, int powerOutput, int price, int fuelCost, ArrayList<Resource> fuelType, String imagePath) {
        try {
            image = ImageIO.read(getClass().getResource(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.maxResources = maxResources;
        this.powerOutput = powerOutput;
        this.price = price;
        this.fuelCost = fuelCost;
        this.fuelType = fuelType;
        addKeyListener(this);
        addMouseListener(this);
    }

    public int getPrice() {
        return price;
    }   
    public int getPowerOutput() {
        return powerOutput;
    }
    public int getFuelCost() {
        return fuelCost;
    }
    public ArrayList<Resource> getFuelType() {
        return fuelType;
    }
    public ArrayList<Resource> getCurrentResources() {
        return currentResources;
    }
    public int getMaxResources() {
        return maxResources;
    }
    public boolean addResource(Resource resource) {
        if (currentResources.size() < maxResources && fuelType.contains(resource)) {
            currentResources.add(resource);
            return true;
        }
        return false;
    }