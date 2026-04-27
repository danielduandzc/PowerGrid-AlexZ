//package src;

import java.util.ArrayList;
import java.util.List;

public class CityNode {
    private String cityName;
    private String zoneColor;
    private int distance;
    private int firstSector;
    private int secondSector;
    private int thirdSector;
    private List<Edge> adjacentEdges = new ArrayList<>();

    public CityNode(String n, String c) {
        this.distance = Integer.MAX_VALUE;
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

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }
    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CityNode)) return false;
    CityNode other = (CityNode) o;
    return this.cityName.equalsIgnoreCase(other.cityName);
}

@Override
public int hashCode() {
    return cityName.toLowerCase().hashCode();
}

}