package src;
import java.util.*;

public class Player {
      private int Elektro, numHouses = 0;
      private String color;
      private boolean inAuction;
      private int bid;
      private int ghostBid;
      private boolean hasPassed;
      private ArrayList<PowerPlant> powerPlants = new ArrayList<PowerPlant>();   
      private HashSet<CityNode> cities = new HashSet<CityNode>();
      private HashMap<Resource, Integer> resources = new HashMap<Resource, Integer>();

      public void setColor(String color) {
            this.color = color;
      }
      public String getColor(){
            return color;
      }
      public int addElektro(int add){
            Elektro += add;
            return Elektro;
      }
      public void setInAuction(boolean b){
            inAuction=b;
      }
      public boolean getInAuction(){
            return inAuction;
      }
      public void setHasPassed(boolean b){
            hasPassed=b;
      }
      public boolean getHasPassed(){
            return hasPassed;
      }
      public void setBid(int x){
            
            bid=x;
      }
      public void addBid(int x){
            bid+=x;
      }
      public int getBid(){
            return bid;
      }
      public void setGhostBid(int x){
            ghostBid=x;
      }
      public int getGhostBid(){
            return ghostBid;
      }
      
      public void useGhostBid(){
            addBid(ghostBid);
            ghostBid=0;
      }
      public void buyPowerPlant(PowerPlant plant){
            powerPlants.add(plant);
            addElektro(-plant.getPrice());
      }
      public int getElektro(){
            return Elektro;
      }
      
      public int getMaxResourceCapacity() {
            int maxCapacity = 0;
            for(PowerPlant plant : powerPlants) {
                  maxCapacity += plant.getMaxResources();
            }
            return maxCapacity;
      }
      
      // Get max capacity for specific resource type (based on plants that can use it)
      public int getMaxCapacityForResource(Resource resource) {
            int capacity = 0;
            for(PowerPlant plant : powerPlants) {
                  if(plant.getFuelType().contains(resource)) {
                        capacity += plant.getMaxResources();
                  }
            }
            return capacity;
      }
      
      public HashMap<Resource, Integer> getResources() {
            return resources;
      }
      
      public int getResourceCount(Resource resource) {
            int total = 0;
            for(PowerPlant plant : powerPlants) {
                  if(plant.getFuelType().contains(resource)) {
                        for(Resource r : plant.getCurrentResources()) {
                              if(r == resource) {
                                    total++;
                              }
                        }
                  }
            }
            return total;
      }
      
      public int getTotalResourceCount() {
            int total = 0;
            for(PowerPlant plant : powerPlants) {
                  total += plant.getCurrentResources().size();
            }
            return total;
      }
      
      public void addResource(Resource resource, int amount) {
            // Find the first plant that can accept this resource and has space
            for(PowerPlant plant : powerPlants) {
                  if(plant.getFuelType().contains(resource)) {
                        for(int i = 0; i < amount; i++) {
                              if(!plant.addResource(resource)) {
                                    return; // Plant is full, stop adding
                              }
                        }
                        return;
                  }
            }
      }
      
      public boolean canAddResource(Resource resource, int amount) {
            int currentCapacity = 0;
            int currentCount = 0;
            for(PowerPlant plant : powerPlants) {
                  if(plant.getFuelType().contains(resource)) {
                        currentCapacity += plant.getMaxResources();
                        currentCount += getResourceCountInPlant(plant, resource);
                  }
            }
            return currentCount + amount <= currentCapacity;
      }
      
      private int getResourceCountInPlant(PowerPlant plant, Resource resource) {
            int count = 0;
            for(Resource r : plant.getCurrentResources()) {
                  if(r == resource) {
                        count++;
                  }
            }
            return count;
      }
      
      public ArrayList<PowerPlant> getPowerPlants() {
            return powerPlants;
      }
}
