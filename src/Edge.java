package src;

public class Edge {
    private final CityNode a;
    private final CityNode b;
    private int cost;

    public Edge(CityNode a, CityNode b) {
        this(a, b, 0);
    }

    public Edge(CityNode a, CityNode b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public CityNode getOtherNode(CityNode node) {
        if (node.equals(a)) {
            return b;
        }
        if (node.equals(b)) {
            return a;
        }
        return null;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public CityNode getANode() {
        return a;
    }

    public CityNode getBNode() {
        return b;
    }
}
