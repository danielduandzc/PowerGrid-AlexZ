package src;
import java.awt.image.BufferedImage;
import java.util.*;
public class GameState{

    public static ArrayList<String> currentEvent = new ArrayList<>();
    public static int currentPlayerIndex=0;
    public static int currentStep=1;
    public static Player[] players=new Player[4];
    public static int[] playerOrder= new int[]{1,2,3,4};
    public static BufferedImage boardImage;
    public static CityGraph graphOfCity=new CityGraph();
    public static boolean[] isColorSelected=new boolean[6];
    public static boolean[] isZoneSelected=new boolean[6];
    
    public void setUpAuction(){
        currentPlayerIndex=0;
        for(player k : players)
        {
            k.setInAuction(true);
            k.setHasPassed(false);
            k.setBid(0);
        }
        currentEvent.add("Pick Powerplant");
        InitialPanel.repaint();
        }
    }
   
    



