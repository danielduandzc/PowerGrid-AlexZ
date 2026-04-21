package src;
public class ResourceHub {
    // Market spaces 1-16, tracking how many of each resource are at each price point
    public boolean[][] coalMarket = new boolean[8][3];      // Spaces 1-16
    public boolean[][] oilMarket = new boolean[8][3];       // Spaces 1-16
    public boolean[][] garbageMarket = new boolean[8][3];   // Spaces 1-16
    public boolean[][] uraniumMarket = new boolean[12][1];   // Spaces 1-16
    private int[] prices = {1,2,3,4,5,6,7,8,10,12,14,16};

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
    
    private boolean isEmpty(boolean[] x){
        for(boolean b: x){
            if(b) return false;
        }
        return true;
    }

            private void addResource(boolean[][] market, int num) {
            if (num <= 0)
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
    
        private void removeResource(boolean[][] market, int num) {
        if (num == 0)
            return;

        // find last non-empty row
        int index = market.length - 1;
        while (index >= 0 && isEmpty(market[index]))
            index--;

        if (index < 0)
            return; // nothing to remove

        // remove last true in that row
        for (int i = market[index].length - 1; i >= 0; i--) {
            if (market[index][i]) {
                market[index][i] = false;
                break;
            }
        }

        removeResource(market, num - 1);
    }


    
    public void initializeMarket() {
        // Clear all markets
        

            addResource(coalMarket, 24);
            addResource(oilMarket, 18);
            addResource(garbageMarket, 9);
            addResource(uraniumMarket, 2);
        
        
        
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
        boolean[][] market = getMarketForResource(resource);
        for(int i = 0; i < market.length; i++) {
         if(notEmpty(market[i]))
         return prices[i];   
        }
        return -1;
    }
    
    // Buy a resource at the cheapest available price
    public boolean buyResource(Resource resource) {
        boolean[][] market = getMarketForResource(resource);
        if(market == null) return false;
        
        // Find the first non-empty row and remove one resource
        for(int i = 0; i < market.length; i++) {
            if(notEmpty(market[i])) {
                // Remove one resource from this row
                for(int j = market[i].length - 1; j >= 0; j--) {
                    if(market[i][j]) {
                        market[i][j] = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean notEmpty(boolean[] x){
        for(boolean b: x)
        if(b)
        return true;
        return false;
        }
    
    
}