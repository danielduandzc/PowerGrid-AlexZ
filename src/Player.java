package src;
import java.util.*;

public class Player {
 private int Elektro, numHouses = 0;
 private String color;
 private String canBid;
 private ArrayList<PowerPlant> powerPlants = new ArrayList<PowerPlant>();   
 private HashSet<CityNode> cities = new HashSet<CityNode>();

 public void setColor(String color){
        this.color = color;
 }
 public String getColor(){
        return color;
 }
 public int addElektro(int add){
       Elektro+=add;
 }
}
