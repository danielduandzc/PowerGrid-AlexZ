package src;

public class Edge {
    private CityNode a;
    private CityNode b;
    private int cost;
    
    public Edge(CityNode a, CityNode b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
    
    public CityNode getOtherNode(CityNode n) {
        if (n.equals(a)) {
            return b;
        } else if (n.equals(b)) {
            return a;
        }
        return null;
    }
    
    public int getCost() {
        return cost;
    }
    
    public void setCost(int x) {
        cost = x;
    }
    public CityNode getANode() {
        return a;
    }
    public CityNode getBNode() {
        return b;
    }
}