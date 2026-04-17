//package src;
import java.io.File;
import java.util.*;

public class CityGraph {
    private ArrayList<CityNode> nodes;
    private ArrayList<Edge> edges;

    public CityGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        loadFromFile("cityEdgeInfo.txt");
        
    }

    public ArrayList<Edge> getShortestPath(CityNode startNode, CityNode targetNode) {
        // Implementation for shortest path algorithm (e.g., Dijkstra's)
        startNode.setDistance(0);
        for(CityNode n: nodes)
            n.setDistance(Integer.MAX_VALUE);
        
        
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
        private void loadFromFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length != 3) continue;

                String cityA = parts[0];
                String cityB = parts[1];
                int weight = Integer.parseInt(parts[2]);

                CityNode nodeA = getOrCreateNode(cityA);
                CityNode nodeB = getOrCreateNode(cityB);

                Edge e = new Edge(nodeA, nodeB, weight);
                addEdge(e);
            }

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
        private CityNode getOrCreateNode(String cityName) {
        for (CityNode n : nodes) {
            if (n.getName().equals(cityName)) {
                return n;
            }
        }
        CityNode newNode = new CityNode(cityName, "");
        nodes.add(newNode);
        return newNode;
    }
}