package src;
public class ResourceHub {
    // Market spaces 1-16, tracking how many of each resource are at each price point
    public int[] coalMarket = new int[17];      // Spaces 1-16
    public int[] oilMarket = new int[17];       // Spaces 1-16
    public int[] garbageMarket = new int[17];   // Spaces 1-16
    public int[] uraniumMarket = new int[17];   // Spaces 1-16
    
    // Price for each space
    private int[] spacePrice = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    public ResourceHub() {
        initializeMarket();
    }
    
    public void initializeMarket() {
        // Clear all markets
        for(int i = 0; i < 17; i++) {
            coalMarket[i] = 0;
            oilMarket[i] = 0;
            garbageMarket[i] = 0;
            uraniumMarket[i] = 0;
        }
        
        // Initial setup per rules:
        // 3 coal on spaces 1-8
        for(int i = 1; i <= 8; i++) {
            coalMarket[i] = 3;
        }
        
        // 3 oil on spaces 3-8
        for(int i = 3; i <= 8; i++) {
            oilMarket[i] = 3;
        }
        
        // 3 garbage on spaces 7-8
        garbageMarket[7] = 3;
        garbageMarket[8] = 3;
        
        // 1 uranium on spaces 14 and 16
        uraniumMarket[14] = 1;
        uraniumMarket[16] = 1;
    }
    
    // Get the market array for a specific resource
    public int[] getMarketForResource(Resource resource) {
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
    public int[] getCoalMarket() {
        return coalMarket;
    }
    
    public int[] getOilMarket() {
        return oilMarket;
    }
    
    public int[] getGarbageMarket() {
        return garbageMarket;
    }
    
    public int[] getUraniumMarket() {
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