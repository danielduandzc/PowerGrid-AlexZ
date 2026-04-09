package src;



import java.util.*;

public class PowerPlant {
    int maxResources; 
    int powerOutput; 
    int price;
    int fuelCost;
    ArrayList<Resource> fuelType;
    ArrayList<Resource> currentResources = new ArrayList<Resource>();  
   


    public PowerPlant(int maxResources, int powerOutput, int price, int fuelCost, ArrayList<Resource> fuelType) {
       
        this.maxResources = maxResources;
        this.powerOutput = powerOutput;
        this.price = price;
        this.fuelCost = fuelCost;
        this.fuelType = fuelType;
        
    }

    public int getPrice() {
        return price;
    }   
    public int getPowerOutput() {
        return powerOutput;
    }
    public int getFuelCost() {
        return fuelCost;
    }
    public ArrayList<Resource> getFuelType() {
        return fuelType;
    }
    public ArrayList<Resource> getCurrentResources() {
        return currentResources;
    }
    public int getMaxResources() {
        return maxResources;
    }
    public boolean addResource(Resource resource) {
        if (currentResources.size() < maxResources && fuelType.contains(resource)) {
            currentResources.add(resource);
            return true;
        }
        return false;
    }
}