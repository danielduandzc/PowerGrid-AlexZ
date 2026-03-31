package src;
import java.util.*;

public class CityGraph {
    private ArrayList<CityNode> nodes;
    private ArrayList<Edge> edges;

    public CityGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public ArrayList<Edge> getShortestPath(CityNode a, CityNode b) {
        // Implementation for shortest path algorithm (e.g., Dijkstra's)
        return new ArrayList<>();
    }

    public void addNode(CityNode n) {
        if (n != null && !nodes.contains(n)) {
            nodes.add(n);
        }
    }

    public void removeNode(CityNode n) {
        nodes.remove(n);
        edges.removeIf(e -> e.getANode().equals(n) || e.getBNode().equals(n));
    }

    public void addEdge(Edge e) {
        if (e != null && !edges.contains(e)) {
            edges.add(e);
        }
    }

    public void removeEdge(Edge e) {
        edges.remove(e);
    }

    public ArrayList<CityNode> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}