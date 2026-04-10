package src;

import java.util.ArrayList;

public class CityNode implements Comparable<int>{
    private String cityName;
    private String zoneColor;
    private int distance;
    private int firstSector;
    private int secondSector;
    private int thirdSector;
    private ArrayList<Edge> adjacentEdges;

    public CityNode(String n, String c) {
        this.cityName = n;
        this.zoneColor = c;
        this.firstSector = 0;
        this.secondSector = 0;
        this.thirdSector = 0;
        this.adjacentEdges = new ArrayList<>();
    }

    public String getName() {
        return cityName;
    }

    public String getZoneColor() {
        return zoneColor;
    }

    public int getFirstSector() {
        return firstSector;
    }

    public void setFirstSector(int p) {
        this.firstSector = p;
    }

    public int getSecondSector() {
        return secondSector;
    }

    public void setSecondSector(int p) {
        this.secondSector = p;
    }

    public int getThirdSector() {
        return thirdSector;
    }

    public void setThirdSector(int p) {
        this.thirdSector = p;
    }

    public void addEdge(Edge e) {
        adjacentEdges.add(e);
    }

    public void removeEdge(Edge e) {
        adjacentEdges.remove(e);
    }

    public void setDistance(int x){
        distance = x;
    }

    public int getDistance(){
        return distance;
    }

    public void setAdjacentEdges(ArrayList<Edge> list) {
        adjacentEdges = list;
    }
    
    public ArrayList<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public int compareTo(CityNode n){
        if(this.getDistance() > n.getDistance())
            return 1;
        if(this.getDistance() < n.getDistance())
            return -1;
        else
            if(this.getDistance == n.getDistance())
                return 0;
    }
}
