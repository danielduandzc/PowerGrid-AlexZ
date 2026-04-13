package src;

import java.util.*;
public class ResourceHub {
    // Market spaces 1-16, tracking how many of each resource are at each price point
    private int[] coalMarket = new int[17];      // Spaces 1-16
    private int[] oilMarket = new int[17];       // Spaces 1-16
    private int[] garbageMarket = new int[17];   // Spaces 1-16
    private int[] uraniumMarket = new int[17];   // Spaces 1-16
    
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
    
    // Get the price of the cheapest available resource
    public int getCheapestPrice(Resource resource) {
        int[] market = getMarketForResource(resource);
        for(int i = 1; i < market.length; i++) {
            if(market[i] > 0) {
                return spacePrice[i];
            }
        }
        return -1; // Resource not available
    }
    
    // Buy a resource from the market (from the cheapest available)
    public boolean buyResource(Resource resource) {
        int[] market = getMarketForResource(resource);
        for(int i = 1; i < market.length; i++) {
            if(market[i] > 0) {
                market[i]--;
                return true;
            }
        }
        return false; // Could not buy, resource not available
    }
    
    // Get remaining count at a specific space
    public int getResourceCountAtSpace(Resource resource, int space) {
        if(space < 1 || space > 16) return 0;
        return getMarketForResource(resource)[space];
    }
    
    // Check if resource is available
    public boolean isResourceAvailable(Resource resource) {
        int[] market = getMarketForResource(resource);
        for(int i = 1; i < market.length; i++) {
            if(market[i] > 0) return true;
        }
        return false;
    }
    
    // Restock resources (used in Phase 5: Bureaucracy)
    public void restockCoal(int amount) {
        addResourcesToMarket(coalMarket, amount, 8);
    }
    
    public void restockOil(int amount) {
        addResourcesToMarket(oilMarket, amount, 8);
    }
    
    public void restockGarbage(int amount) {
        addResourcesToMarket(garbageMarket, amount, 8);
    }
    
    public void restockUranium(int amount) {
        // Uranium is special: max 1 per space, spaces 1-16
        for(int i = 16; i >= 1 && amount > 0; i--) {
            if(uraniumMarket[i] == 0) {
                uraniumMarket[i] = 1;
                amount--;
            }
        }
    }
    
    // Helper to add resources starting from highest space going down
    private void addResourcesToMarket(int[] market, int amount, int maxSpace) {
        for(int i = maxSpace; i >= 1 && amount > 0; i--) {
            int canAdd = Math.min(3 - market[i], amount); // Max 3 per space
            market[i] += canAdd;
            amount -= canAdd;
        }
    }
    
    private int[] getMarketForResource(Resource resource) {
        switch(resource) {
            case COAL: return coalMarket;
            case OIL: return oilMarket;
            case GARBAGE: return garbageMarket;
            case URANIUM: return uraniumMarket;
            default: return new int[17];
        }
    }
    
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

    public void removeCoal(int n) {
        // Implementation for removing coal
    }

    public void removeOil(int n) {
        // Implementation for removing oil
    }

    public void removeGarbage(int n) {
        // Implementation for removing garbage
    }

    public void removeUranium(int n) {
        // Implementation for removing uranium
    }

    public HashMap<Resource, Integer> getResourceStockpile() {
        return new HashMap<>();
    }
}