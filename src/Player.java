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
}


