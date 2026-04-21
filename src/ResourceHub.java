package src;
public class ResourceHub {
    // Market spaces 1-16, tracking how many of each resource are at each price point
    public int[][] coalMarket = new boolean[8][3];      // Spaces 1-16
    public int[][] oilMarket = new boolean[8][3];       // Spaces 1-16
    public int[][] garbageMarket = new boolean[8][3];   // Spaces 1-16
    public int[] uraniumMarket = new boolean[12][1];   // Spaces 1-16
    
    // Price for each space
    

    public ResourceHub() {
        initializeMarket();
    }

    private boolean isFull(boolean[] x){
        boolean ret=true;
        for(boolean b: x){
            ret=ret&&b;
        }
        return ret;
    }

            private void addResource(boolean[][] market, int num) {
            if (num == 0)
                return;

            // find first non-full row
            int index = 0;
            while (index < market.length && isFull(market[index]))
                index++;

            if (index == market.length)
                return; // all full

            // fill first empty slot in that row
            for (int i = 0; i < market[index].length; i++) {
                if (!market[index][i]) {
                    market[index][i] = true;
                    break;
                }
            }

            addResource(market, num - 1);
        }

    
    public void initializeMarket() {
        // Clear all markets
        

            addResource(coalMarket, 24);
            addResource(oilMarket, 18);
            addResource(garbageMarket, 9);
            addResource(uraniumMarket, 2)
        
        
        
    }
    
    // Get the market array for a specific resource
    public boolean[][] getMarketForResource(Resource resource) {
        switch(resource) {
            case COAL:
                return coalMarket;
            case OIL:
                return oilMarket;
            case GARBAGE:
                return garbageMarket;
            case URANIUM:
                return uraniumMarket;
            default:
                return null;
        }
    }
    
    // Get methods for each market
    public boolean[][] getCoalMarket() {
        return coalMarket;
    }
    
    public boolean[][] getOilMarket() {
        return oilMarket;
    }
    
    public boolean[][] getGarbageMarket() {
        return garbageMarket;
    }
    
    public boolean[][] getUraniumMarket() {
        return uraniumMarket;
    }
    
    // Get the price of the cheapest available resource
    public int getCheapestPrice(Resource resource) {
        int[] market = getMarketForResource(resource);
        for(int i = 1; i < market.length; i++) {
            if(market[i] > 0) {
                return spacePrice[i];
            }
        }
        return  69;
    }
    
    // Buy a resource from the market (from the cheapest available space)
    public boolean buyResource(Resource resource) {
        int[] market = getMarketForResource(resource);
        if(market == null) return false;
        
        for(int i = 1; i < market.length; i++) {
            if(market[i] > 0) {
                market[i]--;
                return true;
            }
        }
        return false;
    }
}