package src;
import java.util.*;

public class Player {
 private int Elektro, numHouses = 0;
 private String color;
 private boolean inAuction;
 private int bid;
 private boolean hasPassed;
 private ArrayList<PowerPlant> powerPlants = new ArrayList<PowerPlant>();   
 private HashSet<CityNode> cities = new HashSet<CityNode>();

 public void setColor(String color){
        this.color = color;
 }
 public String getColor(){
        return color;
 }
 public void addElektro(int add){
       Elektro+=add;
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

}
