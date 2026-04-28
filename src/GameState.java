package src;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.util.*;
public class GameState{
    public static boolean firstRoundOfAuction=true;
    public static ArrayList<String> currentEvent = new ArrayList<>();
    public static int currentPlayerIndex=0;
    public static int currentStep=1;
    public static Player[] players=new Player[4];
    public static int[] playerOrder= new int[]{3,1,4,2};
    public static BufferedImage boardImage;
    public static CityGraph graphOfCity=new CityGraph();
    public static boolean[] isColorSelected=new boolean[6];
    public static boolean[] isZoneSelected=new boolean[6];
    public static InitialPanel initialPanel;
    public static int minBid=0;
    public static PowerPlant auctionedPowerPlant;
    public static ArrayList<PowerPlant> powerPlantDeck=new ArrayList<PowerPlant>();
    public static ArrayList<PowerPlant> powerPlantsInMarket=new ArrayList<PowerPlant>();
    public static ArrayList<PowerPlant> discardPile=new ArrayList<PowerPlant>();
    public static ArrayList<Integer> playerOrderInAuction=new ArrayList<Integer>();
    
    public static ResourceHub resourceMarket = new ResourceHub();
    public static CityGraph fullGraph = new CityGraph();
    public static String cityNameForPurchase;
    public static int setPriceForCity;
    public static int auctionPlayerIndex=0;
    public static Resource selectedResourceForAddition = null;
    public static int numPlayerSkipped=0;
    public static ArrayList<Resource> resourcesToAdd = new ArrayList<Resource>();

    public static boolean canAddResourceToAnyPlant(Player player, Resource resource) {
        if (player == null || resource == null) return false;
        for (PowerPlant pp : player.getPowerPlants()) {
            if (pp.getCurrentResources().size() < pp.getMaxResources() && pp.getFuelType().contains(resource)) {
                return true;
            }
        }
        return false;
    }

    

    public static void processNextDiscardedResource(Player player) {
        selectedResourceForAddition = null;
        while (!resourcesToAdd.isEmpty()) {
            Resource next = resourcesToAdd.remove(0);
            if (canAddResourceToAnyPlant(player, next)) {
                selectedResourceForAddition = next;
                return;
            }
        }
    }
    

    public static void setUpDeckAndMarket(){
        
        // Randomize player order for the first round only
       
        
        for(Player k : players) {
            k.addElektro(50);
        }
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
                            for(int i = 11; i >= 4; i--) {
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
        Collections.shuffle(powerPlantDeck);
        powerPlantDeck.add(0, new PowerPlant(0, 0, 51, 0, new ArrayList<Resource>()));
        
        
     } 

     public static void runBureaucracy(){
         firstRoundOfAuction=false;
            for(Player p : players) {
                int powerCount = 0;
                for(PowerPlant plant : p.getPowerPlants()) {
                    if(plant.isActivated()) {
                        powerCount += plant.getPowerOutput();
                        // Remove resources used for this turn
                        for(Resource r : plant.getFuelType()) {
                            int resourcesToRemove = plant.getFuelCost();
                            for(int i = 0; i < resourcesToRemove; i++) {
                                plant.getCurrentResources().remove(r);
                            }
                        }
                    }
                }
                // Power cities based on powerCount
                   
                    p.setEarnedIncome(calculateIncome(Math.min(powerCount,p.getCities().size())));
                     p.addElektro(p.getEarnedIncome());
                
            }
     }

    public static int calculateIncome(int p){
        switch (p) {
            case 0 :return 10;
            case 1 :return 22;
            case 2 :return 33;
            case 3 :return 44;
            case 4 :return 54;
            case 5 :return 64;
            case 6 :return 73;
            case 7 :return 82;
            case 8 :return 90;
            case 9 :return 98;
            case 10 :return 105;
            case 11 :return 112;
            case 12 :return 118;
            case 13 :return 124;
            case 14 :return 129;
            case 15 :return 134;
            case 16 :return 138;
            case 17 :return 142;
            case 18 :return 145;
            case 19 :return 148;
            case 20 :return 150;
           
        }
        return 150;
    }
    

    public static void setUpAuction(){
        numPlayerSkipped=0;
        auctionPlayerIndex=0;
        graphOfCity.removeUnselectedZones(isZoneSelected);
        currentPlayerIndex=0;
        minBid=0;
        playerOrderInAuction.clear();
        playerOrderInAuction.add(playerOrder[0]-1);
        playerOrderInAuction.add(playerOrder[1]-1);
        playerOrderInAuction.add(playerOrder[2]-1);
        playerOrderInAuction.add(playerOrder[3]-1);
        for(Player k : players)
        {
            k.setInAuction(true);
            k.setHasPassed(false);
            k.setBid(0);
        }
         powerPlantsInMarket.sort(Comparator.comparingInt(PowerPlant::getPrice));
         currentEvent.add("Auction");
        currentEvent.add("Pick Powerplant");
       
           
        
    }
            public static void newRound() {

            // Determine Step 2 or Step 3
            int mostCities = 0;
            for (Player p : players) {
                mostCities = Math.max(mostCities, p.getCities().size());
            }

           
            resourceMarket.restockMarket();

            // Sort players by:
            // 1. Most cities (descending)
            // 2. Highest power plant (descending)
            Integer[] order = {0, 1, 2, 3};

            Arrays.sort(order, (a, b) -> {
                Player pA = players[a];
                Player pB = players[b];

                int cityDiff = pB.getCities().size() - pA.getCities().size();
                if (cityDiff != 0) return cityDiff;

                int plantDiff = pB.getHighestPowerPlant() - pA.getHighestPowerPlant();
                return plantDiff;
            });

            // Save sorted order back into playerOrder
            for (int i = 0; i < 4; i++) {
                playerOrder[i] = order[i] + 1; // +1 because your array uses 1–4 instead of 0–3
            }

            currentEvent.add("Player Order");
             if (mostCities >= 7) {
                currentStep = 2;
                discardPile.add(powerPlantsInMarket.remove(0)); // Remove the cheapest power plant
                powerPlantsInMarket.add(powerPlantDeck.remove(powerPlantDeck.size() - 1)); // Add a new one from the deck
                currentEvent.add("Step 2");
            }
            if (mostCities >= 17) {
                // End game
                return;
            }
        }
    public static void continueAuction(){
        System.out.println((playerOrderInAuction.get(auctionPlayerIndex)+1)+" is the player");
        if(currentEvent.getLast().equals("Buy Powerplant")){
                return;
            }
        
        // Make sure auctionPlayerIndex is valid
        if(playerOrderInAuction.isEmpty()) {
            return;
        }
        if(auctionPlayerIndex >= playerOrderInAuction.size()) {
            auctionPlayerIndex = 0;
        }
       
        minBid=Math.max(minBid, players[playerOrderInAuction.get(auctionPlayerIndex)].getBid());
        auctionPlayerIndex++;
        if(auctionPlayerIndex==playerOrderInAuction.size()) {
            auctionPlayerIndex=0;
        }
        
        // Skip players who are not in auction or have passed - using a loop instead of recursion to avoid stack overflow
        int skipCounter = 0;
        int maxSkips = playerOrderInAuction.size();  // Prevent infinite loops
        while(skipCounter < maxSkips && (!players[playerOrderInAuction.get(auctionPlayerIndex)].getInAuction() || players[playerOrderInAuction.get(auctionPlayerIndex)].getHasPassed())) {
            System.out.println((playerOrderInAuction.get(auctionPlayerIndex)+1)+" is the player who was skipped");
            auctionPlayerIndex++;
            if(auctionPlayerIndex==playerOrderInAuction.size()) {
                auctionPlayerIndex=0;
            }
            skipCounter++;
        }
        int numPlayersInAuction=0;
        for(Player k : players)
        {
            if(k.getInAuction()&&!k.getHasPassed()) {
                numPlayersInAuction++;
            }
        }
        // If nobody remains in the auction (everyone passed), remove the lowest power plant from the market
        if(numPlayersInAuction==0) {
            System.out.println("All players passed the auction. Removing lowest power plant from the market.");
            if(!powerPlantsInMarket.isEmpty()) {
                PowerPlant removed = powerPlantsInMarket.remove(0);  // Remove the first (lowest price) power plant
                discardPile.add(removed);
                System.out.println("Removed power plant: " + removed.getPrice());
                // Add a new power plant from the deck to the market
                if(!powerPlantDeck.isEmpty()) {
                    powerPlantsInMarket.add(powerPlantDeck.remove(powerPlantDeck.size()-1));
                    powerPlantsInMarket.sort(Comparator.comparingInt(PowerPlant::getPrice));
                }
            }
            // Reset auction state for all players
            for(Player p : players) {
                p.setInAuction(false);
                p.setHasPassed(false);
                p.setBid(0);
                p.setGhostBid(0);
            }
            
            currentEvent.add("Pick Powerplant");
            return;
        }
        if(numPlayersInAuction==1) {
            // Find the remaining player who won the auction
            Player winner = null;
            int winnerIndex = -1;
            for(int i = 0; i < players.length; i++) {
                if(players[i].getInAuction() && !players[i].getHasPassed()) {
                    winner = players[i];
                    winnerIndex = i;
                    break;
                }
            }
            
            if(winner != null) {
                // Give the power plant to the winner
                winner.setBid(0);
                winner.setGhostBid(0);
                if(winner.getPowerPlants().size() >= 3) {
                    // If they already have 3 power plants, they must choose one to discard
                    // Store which player needs to discard for the UI to handle
                    currentPlayerIndex = winnerIndex;
                    currentEvent.add("Discard Powerplant");
                    return;
                }
                winner.buyPowerPlant(auctionedPowerPlant);
                
                // Remove this power plant from market and add a new one
                int marketIndex = 0;
                while(marketIndex < powerPlantsInMarket.size() && 
                      powerPlantsInMarket.get(marketIndex).getPrice() < auctionedPowerPlant.getPrice()) {
                    marketIndex++;
                }
                powerPlantsInMarket.remove(marketIndex);
                if(!powerPlantDeck.isEmpty()) {
                    powerPlantsInMarket.add(powerPlantDeck.remove(powerPlantDeck.size()-1));
                    powerPlantsInMarket.sort(Comparator.comparingInt(PowerPlant::getPrice));
                }
                
                System.out.println("Player " + (winnerIndex + 1) + " won the auction");
                
                // Remove this player from the auction rotation
                playerOrderInAuction.remove((Integer) winnerIndex);
                winner.setInAuction(false);
            
            }
            
            // Reset all players' auction states for next round
            for(Player p : players) {
                p.setHasPassed(false);
                p.setBid(0);
                p.setGhostBid(0);
            }
            
            // Check if auction is done
            if(playerOrderInAuction.size()==1) {
                System.out.println("Auction complete - all players have power plants");
                if(!currentEvent.isEmpty() && currentEvent.getLast().equals("Auction")) {
                    currentEvent.removeLast();
                }
                currentEvent.add("Buy Powerplant");
                return;
            }
            
            // Continue to next auction round
            auctionPlayerIndex = 0;
            minBid = 0;
            System.out.println("Starting next auction round with " + playerOrderInAuction.size() + " players");
            
            currentEvent.add("Pick Powerplant");
            return;
        }
    }
    
    // Reverse the player order for phases like Buy Resources and Build Houses
    public static void reversePlayerOrder() {
        int[] temp = new int[playerOrder.length];
        for(int i = 0; i < playerOrder.length; i++) {
            temp[i] = playerOrder[playerOrder.length - 1 - i];
        }
        playerOrder = temp;
        currentPlayerIndex = 0;
    }
}    



