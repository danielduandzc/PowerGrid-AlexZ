import java.util.*;
public class GameState{

    public static Queue<String> currentEvent = new LinkedList<>();
    public static int currentPlayer;
    public static int currentStep=1;
    public static player[] players=new player[4];
    public static player[] playerOrder=new int[4];
    public static bufferedImage boardImage;
    public static cityGraph graphOfCity=new cityGraph();


}