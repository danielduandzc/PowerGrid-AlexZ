package src;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
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
        //Max Resources, Power, Price, half max r, resources 
        powerPlantDeck.add(new PowerPlant(4,3,16,2,new ArrayList<Resource>(Arrays.asList(Resource.OIL))));
        powerPlantDeck.add(new PowerPlant(2,2,17,1,new ArrayList<Resource>(Arrays.asList(Resource.URANIUM))));
        powerPlantDeck.add(new PowerPlant(0,2,18,0,new ArrayList<Resource>()));
        powerPlantDeck.add(new PowerPlant(4,3,19,2,new ArrayList<Resource>(Arrays.asList(Resource.GARBAGE))));
        powerPlantDeck.add(new PowerPlant(6,5,20,3,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        powerPlantDeck.add(new PowerPlant(4,4,21,2,new ArrayList<Resource>(Arrays.asList(Resource.OIL,Resource.COAL))));
        powerPlantDeck.add(new PowerPlant(0,2,22,0,new ArrayList<Resource>()));
        powerPlantDeck.add(new PowerPlant(2,3,23,1,new ArrayList<Resource>(Arrays.asList(Resource.URANIUM))));
        powerPlantDeck.add(new PowerPlant(4,4,24,2,new ArrayList<Resource>(Arrays.asList(Resource.GARBAGE))));
        powerPlantDeck.add(new PowerPlant(4,5,25,2,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        powerPlantDeck.add(new PowerPlant(4,5,26,2,new ArrayList<Resource>(Arrays.asList(Resource.OIL))));
        powerPlantDeck.add(new PowerPlant(0,3,27,0,new ArrayList<Resource>()));
        powerPlantDeck.add(new PowerPlant(2,4,28,1,new ArrayList<Resource>(Arrays.asList(Resource.URANIUM))));
        powerPlantDeck.add(new PowerPlant(2,4,29,1,new ArrayList<Resource>(Arrays.asList(Resource.OIL,Resource.COAL))));
        powerPlantDeck.add(new PowerPlant(6,6,30,3,new ArrayList<Resource>(Arrays.asList(Resource.GARBAGE))));
        powerPlantDeck.add(new PowerPlant(6,6,31,3,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        powerPlantDeck.add(new PowerPlant(6,6,32,3,new ArrayList<Resource>(Arrays.asList(Resource.OIL))));
        powerPlantDeck.add(new PowerPlant(0,4,33,0,new ArrayList<Resource>()));
        powerPlantDeck.add(new PowerPlant(2,5,34,1,new ArrayList<Resource>(Arrays.asList(Resource.URANIUM))));
        powerPlantDeck.add(new PowerPlant(2,5,35,1,new ArrayList<Resource>(Arrays.asList(Resource.OIL))));
        powerPlantDeck.add(new PowerPlant(6,7,36,3,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        powerPlantDeck.add(new PowerPlant(0,4,37,0,new ArrayList<Resource>()));
        powerPlantDeck.add(new PowerPlant(6,7,38,3,new ArrayList<Resource>(Arrays.asList(Resource.GARBAGE))));
        powerPlantDeck.add(new PowerPlant(2,6,39,1,new ArrayList<Resource>(Arrays.asList(Resource.URANIUM))));
        powerPlantDeck.add(new PowerPlant(4,6,40,2,new ArrayList<Resource>(Arrays.asList(Resource.OIL))));
        powerPlantDeck.add(new PowerPlant(4,6,42,2,new ArrayList<Resource>(Arrays.asList(Resource.COAL))));
        powerPlantDeck.add(new PowerPlant(0,5,44,0,new ArrayList<Resource>()));
        powerPlantDeck.add(new PowerPlant(6,7,46,3,new ArrayList<Resource>(Arrays.asList(Resource.OIL,Resource.COAL))));
        powerPlantDeck.add(new PowerPlant(0,6,50,0,new ArrayList<Resource>()));
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

    public void setUpGraph(){
        try{
            File cityInformation = new File("cityInfo.txt");
            Scanner sc = new Scanner(cityInformation);

            while(sc.hasNextLine()){
                String[] temp = sc.nextLine().split(" ");
                graphOfCity.addNode(new CityNode(temp[0], temp[1]));
            }
        } catch (FileNotFoundException e){
            System.out.println("CityNode File error");
        }
    }
}
   
    



