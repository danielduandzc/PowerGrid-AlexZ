package src;
import java.util.*;

public class CityGraph {
    private  ArrayList<CityNode> nodes;
    private   ArrayList<Edge> edges;
    public int x;
    public int y;

    public CityGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        initializeGraph();
    }
    public boolean contains(String cityName) {
    for (CityNode node : nodes) {
        if (node.getName().equalsIgnoreCase(cityName)) {
            return true;
        }
    }
    return false;
}
private void rebuildAdjacencyLists() {
    // Clear all adjacency lists
    for (CityNode node : nodes) {
        node.getAdjacentEdges().clear();
    }
    // Re-add each edge to its endpoint nodes
    for (Edge edge : edges) {
        edge.getANode().getAdjacentEdges().add(edge);
        edge.getBNode().getAdjacentEdges().add(edge);
    }
}

    private void initializeGraph() {
        // Create all nodes
        String[] cityNames = {"Flensburg", "Kiel", "Rostock", "Lubeck", "Cuxhaven", "Wilhelmshaven", "Hamburg",
                              "Schwerin", "Torgelow", "Bremen", "Berlin", "Osnabruck", "Hannover", "Magdeburg",
                              "Frankfurt-O", "Munster", "Duisburg", "Essen", "Dortmund", "Halle", "Kassel",
                              "Leipzig", "Dusseldorf", "Erfurt", "Dresden", "Koln", "Aachen", "Fulda",
                              "Frankfurt-M", "Wiesbaden", "Trier", "Wurzburg", "Nurnberg", "Mannheim",
                              "Saarbrucken", "Regensburg", "Stuttgart", "Augsburg", "Passau", "Freiburg",
                              "Munchen", "Konstanz"};
        
        for (String cityName : cityNames) {
            addNode(new CityNode(cityName, ""));
        }
        
        // Add edges based on adjacency list
        addEdgeByName("Flensburg", "Kiel", 4);
        addEdgeByName("Kiel", "Lubeck", 4);
        addEdgeByName("Kiel", "Hamburg", 8);
        addEdgeByName("Hamburg", "Lubeck", 6);
        addEdgeByName("Hamburg", "Schwerin", 8);
        addEdgeByName("Hamburg", "Hannover", 17);
        addEdgeByName("Hamburg", "Bremen", 11);
        addEdgeByName("Hamburg", "Cuxhaven", 11);
        addEdgeByName("Cuxhaven", "Bremen", 8);
        addEdgeByName("Wilhelmshaven", "Bremen", 11);
        addEdgeByName("Wilhelmshaven", "Osnabruck", 14);
        addEdgeByName("Bremen", "Hannover", 10);
        addEdgeByName("Bremen", "Osnabruck", 11);
        addEdgeByName("Hannover", "Schwerin", 19);
        addEdgeByName("Hannover", "Magdeburg", 15);
        addEdgeByName("Hannover", "Erfurt", 19);
        addEdgeByName("Hannover", "Kassel", 15);
        addEdgeByName("Lubeck", "Schwerin", 6);
        addEdgeByName("Rostock", "Schwerin", 6);
        addEdgeByName("Rostock", "Torgelow", 19);
        addEdgeByName("Schwerin", "Torgelow", 19);
        addEdgeByName("Schwerin", "Berlin", 18);
        addEdgeByName("Schwerin", "Magdeburg", 16);
        addEdgeByName("Torgelow", "Berlin", 15);
        addEdgeByName("Magdeburg", "Berlin", 10);
        addEdgeByName("Magdeburg", "Halle", 11);
        addEdgeByName("Berlin", "Frankfurt-O", 6);
        addEdgeByName("Berlin", "Halle", 17);
        addEdgeByName("Osnabruck", "Munster", 7);
        addEdgeByName("Osnabruck", "Kassel", 20);
        addEdgeByName("Munster", "Dortmund", 2);
        addEdgeByName("Munster", "Essen", 6);
        addEdgeByName("Duisburg", "Essen", 0);
        addEdgeByName("Essen", "Dortmund", 4);
        addEdgeByName("Essen", "Dusseldorf", 2);
        addEdgeByName("Dortmund", "Kassel", 18);
        addEdgeByName("Dortmund", "Frankfurt-M", 20);
        addEdgeByName("Dortmund", "Koln", 10);
        addEdgeByName("Kassel", "Erfurt", 15);
        addEdgeByName("Kassel", "Fulda", 8);
        addEdgeByName("Kassel", "Frankfurt-M", 13);
        addEdgeByName("Dusseldorf", "Koln", 4);
        addEdgeByName("Dusseldorf", "Aachen", 9);
        addEdgeByName("Aachen", "Koln", 7);
        addEdgeByName("Aachen", "Trier", 19);
        addEdgeByName("Koln", "Wiesbaden", 21);
        addEdgeByName("Koln", "Trier", 20);
        addEdgeByName("Trier", "Wiesbaden", 18);
        addEdgeByName("Trier", "Saarbrucken", 11);
        addEdgeByName("Wiesbaden", "Frankfurt-M", 0);
        addEdgeByName("Wiesbaden", "Mannheim", 11);
        addEdgeByName("Wiesbaden", "Saarbrucken", 10);
        addEdgeByName("Frankfurt-M", "Fulda", 8);
        addEdgeByName("Frankfurt-M", "Wurzburg", 13);
        addEdgeByName("Saarbrucken", "Mannheim", 11);
        addEdgeByName("Saarbrucken", "Stuttgart", 17);
        addEdgeByName("Mannheim", "Wurzburg", 10);
        addEdgeByName("Mannheim", "Stuttgart", 6);
        addEdgeByName("Halle", "Leipzig", 0);
        addEdgeByName("Halle", "Erfurt", 6);
        addEdgeByName("Leipzig", "Frankfurt-O", 21);
        addEdgeByName("Leipzig", "Dresden", 13);
        addEdgeByName("Dresden", "Frankfurt-O", 16);
        addEdgeByName("Dresden", "Erfurt", 19);
        addEdgeByName("Erfurt", "Nurnberg", 21);
        addEdgeByName("Erfurt", "Fulda", 13);
        addEdgeByName("Fulda", "Wurzburg", 11);
        addEdgeByName("Wurzburg", "Nurnberg", 8);
        addEdgeByName("Wurzburg", "Augsburg", 19);
        addEdgeByName("Wurzburg", "Stuttgart", 12);
        addEdgeByName("Nurnberg", "Regensburg", 12);
        addEdgeByName("Nurnberg", "Augsburg", 18);
        addEdgeByName("Regensburg", "Passau", 12);
        addEdgeByName("Regensburg", "Munchen", 10);
        addEdgeByName("Regensburg", "Augsburg", 13);
        addEdgeByName("Passau", "Munchen", 14);
        addEdgeByName("Stuttgart", "Augsburg", 15);
        addEdgeByName("Stuttgart", "Konstanz", 16);
        addEdgeByName("Stuttgart", "Freiburg", 16);
        addEdgeByName("Augsburg", "Munchen", 6);
        addEdgeByName("Augsburg", "Konstanz", 17);
        addEdgeByName("Munchen", "Regensburg", 10);
        addEdgeByName("Munchen", "Passau", 10);
        addEdgeByName("Freiburg", "Konstanz", 14);
    }

    private void addEdgeByName(String cityA, String cityB, int weight) {
        CityNode nodeA = null;
        CityNode nodeB = null;
        
        for (CityNode n : nodes) {
            if (n.getName().equals(cityA)) nodeA = n;
            if (n.getName().equals(cityB)) nodeB = n;
        }
        
        if (nodeA != null && nodeB != null) {
            addEdge(new Edge(nodeA, nodeB, weight));
        }
    }

    public int getShortestPath(String startName, String targetName) {
    CityNode startNode = null;
    CityNode targetNode = null;

    // Find the nodes by name
    for (CityNode n : nodes) {
        if (n.getName().equalsIgnoreCase(startName)) startNode = n;
        if (n.getName().equalsIgnoreCase(targetName)) targetNode = n;
    }

    if (startNode == null || targetNode == null) {
        return -1; // city not found
    }

    // Reset distances
    for (CityNode n : nodes) {
        n.setDistance(Integer.MAX_VALUE);
    }
    startNode.setDistance(0);

    // Priority queue sorted by distance
    PriorityQueue<CityNode> pq = new PriorityQueue<>(Comparator.comparingInt(CityNode::getDistance));
    pq.add(startNode);

    HashSet<CityNode> visited = new HashSet<>();

    while (!pq.isEmpty()) {
        CityNode current = pq.poll();

        if (visited.contains(current)) continue;
        visited.add(current);

        // If we reached the target, we are done
        if (current.equals(targetNode)) {
            return current.getDistance();
        }

        // Relax edges
        for (Edge e : current.getAdjacentEdges()) {
            CityNode neighbor = e.getOtherNode(current);

            if (visited.contains(neighbor)) continue;

            int newDist = current.getDistance() + e.getCost();
            if (newDist < neighbor.getDistance()) {
                neighbor.setDistance(newDist);
                pq.add(neighbor);
            }
        }
    }

    return targetNode.getDistance();
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

    public void removeUnselectedZones(boolean[] isZoneSelected) {
    // Map zones to their city names
    HashMap<Integer, ArrayList<String>> zoneMap = new HashMap<>();
    
    // Teal (zone 0)
    zoneMap.put(0, new ArrayList<>(Arrays.asList(
        "Flensburg", "Kiel", "Hamburg", "Cuxhaven", "Wilhelmshaven", "Bremen", "Hannover"
    )));
    
    // Brown (zone 1)
    zoneMap.put(1, new ArrayList<>(Arrays.asList(
      "Lubeck", "Schwerin", "Rostock", "Torgelow", "Magdeburg", "Berlin", "Frankfurt-O"
    )));
    
    // Red (zone 2)
    zoneMap.put(2, new ArrayList<>(Arrays.asList(
        "Osnabruck", "Munster", "Duisburg", "Essen", "Dortmund", "Dusseldorf", "Kassel"
    )));
    
    // Yellow (zone 3)
    zoneMap.put(3, new ArrayList<>(Arrays.asList(
        "Halle", "Leipzig", "Dresden", "Erfurt", "Fulda", "Wurzburg", "Nurnberg"
    )));
    
    // Blue (zone 4)
    zoneMap.put(4, new ArrayList<>(Arrays.asList(
        "Aachen", "Koln", "Trier", "Wiesbaden", "Frankfurt-M", "Saarbrucken", "Mannheim"
    )));
    
    // Purple (zone 5)
    zoneMap.put(5, new ArrayList<>(Arrays.asList(
        "Stuttgart", "Freiburg", "Konstanz", "Augsburg", "Munchen", "Regensburg", "Passau"
    )));
    
    // Collect all cities in selected zones
    HashSet<String> selectedCities = new HashSet<>();
    for (int i = 0; i < isZoneSelected.length; i++) {
        if (isZoneSelected[i]) {
            selectedCities.addAll(zoneMap.get(i));
        }
    }
    
    // Remove nodes not in selected zones
    nodes.removeIf(node -> !selectedCities.contains(node.getName()));
    
    // Remove edges connected to removed nodes
    edges.removeIf(edge -> !selectedCities.contains(edge.getANode().getName()) || 
                           !selectedCities.contains(edge.getBNode().getName()));
    
    // Rebuild adjacency lists for the remaining nodes
    for (CityNode node : nodes) {
        node.getAdjacentEdges().clear();
    }
    for (Edge edge : edges) {
        edge.getANode().getAdjacentEdges().add(edge);
        edge.getBNode().getAdjacentEdges().add(edge);
    }
}

 
}