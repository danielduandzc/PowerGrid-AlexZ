package src;

import java.util.*;
public class ResourceHub {
    private Resource[][] coalMarket;
    private Resource[][] oilMarket;
    private Resource[][] garbageMarket;
    private Resource[] uraniumMarket;
    private HashMap<Resource, Integer> resourceStockpile;

    public ResourceHub() {
        coalMarket = new Resource[0][0];
        oilMarket = new Resource[0][0];
        garbageMarket = new Resource[0][0];
        uraniumMarket = new Resource[0];
        resourceStockpile = new HashMap<>();
    }

    public Resource[][] getCoalMarket() {
        return coalMarket;
    }

    public Resource[][] getOilMarket() {
        return oilMarket;
    }

    public Resource[][] getGarbageMarket() {
        return garbageMarket;
    }

    public Resource[] getUraniumMarket() {
        return uraniumMarket;
    }

    public void restockCoal(int n) {
        // Implementation for restocking coal
    }

    public void restockOil(int n) {
        // Implementation for restocking oil
    }

    public void restockGarbage(int n) {
        // Implementation for restocking garbage
    }

    public void restockUranium(int n) {
        // Implementation for restocking uranium
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
        return resourceStockpile;
    }
}