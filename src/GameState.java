package src;
import java.awt.image.BufferedImage;
import java.util.*;
public class GameState{

    public static ArrayList<String> currentEvent = new ArrayList<>();
    public static int currentPlayer;
    public static int currentStep=1;
    public static Player[] players=new Player[4];
    public static Player[] playerOrder=new Player[4];
    public static BufferedImage boardImage;
    public static CityGraph graphOfCity=new CityGraph();


}