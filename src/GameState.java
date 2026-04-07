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
    public static InitialPanel initialPanel;
    public static int minBid=0;
    public static PowerPlant auctionedPowerPlant;
    public static ArrayList<PowerPlant> powerPlantDeck=new ArrayList<PowerPlant>();
    public static ArrayList<PowerPlant> powerPlantsInMarket=new ArrayList<PowerPlant>();

    public static void setUpDeckAndMarket(){
        ArrayList<PowerPlant> tempDeck=new ArrayList<PowerPlant>();
        tempDeck.add(new PowerPlant(4,1,3,2,new ArrayList<Resource>(Arrays.asList(Resource.OIL))));
        tempDeck.add(new PowerPlant(4,1,4,2,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        tempDeck.add(new PowerPlant(4,1,5,2,new ArrayList<Resource>(Arrays.asList(Resource.OIL,Resource.COAL))));
        tempDeck.add(new PowerPlant(2,1,6,1,new ArrayList<Resource>(Arrays.asList(Resource.GARBAGE))));
        tempDeck.add(new PowerPlant(6,2,7,3,new ArrayList<Resource>(Arrays.asList(Resource.OIL))));
        tempDeck.add(new PowerPlant(6,2,8,3,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        tempDeck.add(new PowerPlant(2,1,9,1,new ArrayList<Resource>(Arrays.asList(Resource.OIL))));
        tempDeck.add(new PowerPlant(4,2,10,2,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        tempDeck.add(new PowerPlant(2,2,11,1,new ArrayList<Resource>(Arrays.asList(Resource.URANIUM))));
        tempDeck.add(new PowerPlant(4,2,12,2,new ArrayList<Resource>(Arrays.asList(Resource.OIL,Resource.COAL))));
        tempDeck.add(new PowerPlant(0,1,13,0,new ArrayList<Resource>()));
        tempDeck.add(new PowerPlant(4,2,14,2,new ArrayList<Resource>(Arrays.asList(Resource.GARBAGE))));
        tempDeck.add(new PowerPlant(4,3,15,2,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        Collections.shuffle(tempDeck);
            for(int i=11;i>=3;i--) {
                powerPlantsInMarket.add(tempDeck.remove(i));
            }
       powerPlantsInMarket.sort(Comparator.comparingInt(PowerPlant::getPrice));
        for(int i=tempDeck.size()-1;i>=0;i--) {
            powerPlantDeck.add(tempDeck.get(i));
        }







    } 

   

    public static void setUpAuction(){
        currentPlayerIndex=0;
        minBid=0;
        for(Player k : players)
        {
            k.setInAuction(true);
            k.setHasPassed(false);
            k.setBid(0);
        }
        currentEvent.add("Pick Powerplant");
       
           
        
    }
    public void continueAuction(){
        minBid=players[currentPlayerIndex].getBid();
        currentPlayerIndex++;
        if(currentPlayerIndex==4) {
            currentPlayerIndex=0;
        }
        if(!players[currentPlayerIndex].getInAuction()||players[currentPlayerIndex].getHasPassed()) {
            continueAuction();
        }
        int numPlayersInAuction=0;
        for(Player k : players)
        {
            if(k.getInAuction()&&!k.getHasPassed()) {
                numPlayersInAuction++;
            }
        }
        if(numPlayersInAuction==1) {
            for(Player k : players)
            {
                if(k.getInAuction()&&!k.getHasPassed()) {
                    k.buyPowerPlant(auctionedPowerPlant);
                    powerPlantsInMarket.add(powerPlantDeck.remove(powerPlantDeck.size()-1));
                    powerPlantsInMarket.sort(Comparator.comparingInt(PowerPlant::getPrice));
                    k.setInAuction(false);
                }
            }
        }
    }
}
   
    



