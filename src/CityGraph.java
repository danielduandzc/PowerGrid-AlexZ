package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class CityGraph {
    private final ArrayList<CityNode> nodes;
    private final ArrayList<Edge> edges;
    private final Map<String, CityNode> cityByName;

    public CityGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.cityByName = new HashMap<>();
    }

    public static CityGraph createGermanyMap() {
        CityGraph graph = new CityGraph();

        graph.addCity("Flensburg", "North", 1209, 200);
        graph.addCity("Kiel", "North", 1316, 456);
        graph.addCity("Lubeck", "North", 1443, 653);
        graph.addCity("Cuxhaven", "North", 990, 681);
        graph.addCity("Wilhelmshaven", "North", 796, 842);
        graph.addCity("Hamburg", "North", 1298, 801);
        graph.addCity("Bremen", "North", 1014, 1057);
        graph.addCity("Hannover", "North", 1307, 1421);

        graph.addCity("Osnabruck", "West", 931, 1430);
        graph.addCity("Munster", "West", 626, 1674);
        graph.addCity("Duisburg", "West", 228, 1757);
        graph.addCity("Essen", "West", 429, 1803);
        graph.addCity("Dortmund", "West", 657, 1964);
        graph.addCity("Dusseldorf", "West", 259, 2007);
        graph.addCity("Koln", "West", 518, 2216);

        graph.addCity("Aachen", "Center", 216, 2296);
        graph.addCity("Trier", "Center", 305, 2651);
        graph.addCity("Wiesbaden", "Center", 916, 2465);
        graph.addCity("Frankfurt-M", "Center", 1027, 2401);
        graph.addCity("Saarbrucken", "Center", 688, 2999);
        graph.addCity("Mannheim", "Center", 965, 2853);
        graph.addCity("Kassel", "Center", 1107, 1997);

        graph.addCity("Fulda", "Rhine", 1323, 2244);
        graph.addCity("Wurzburg", "Rhine", 1341, 2670);
        graph.addCity("Erfurt", "Rhine", 1566, 2065);
        graph.addCity("Halle", "Rhine", 1917, 1757);
        graph.addCity("Leipzig", "Rhine", 2029, 1973);
        graph.addCity("Dresden", "Rhine", 2479, 2059);
        graph.addCity("Magdeburg", "Rhine", 1917, 1427);

        graph.addCity("Rostock", "East", 1948, 505);
        graph.addCity("Schwerin", "East", 1742, 851);
        graph.addCity("Berlin", "East", 2352, 1365);
        graph.addCity("Frankfurt-O", "East", 2624, 1365);
        graph.addCity("Torgelow", "East", 2519, 845);
        graph.addCity("Nurnberg", "East", 1785, 2836);
        graph.addCity("Regensburg", "East", 2019, 3091);

        graph.addCity("Stuttgart", "South", 1107, 3215);
        graph.addCity("Freiburg", "South", 694, 3554);
        graph.addCity("Konstanz", "South", 1249, 3678);
        graph.addCity("Augsburg", "South", 1520, 3363);
        graph.addCity("Munchen", "South", 1927, 3508);
        graph.addCity("Passau", "South", 2482, 3267);

        graph.connect("Flensburg", "Kiel", 4);
        graph.connect("Kiel", "Hamburg", 8);
        graph.connect("Kiel", "Lubeck", 4);
        graph.connect("Lubeck", "Hamburg", 6);
        graph.connect("Lubeck", "Schwerin", 6);
        graph.connect("Lubeck", "Rostock", 6);
        graph.connect("Rostock", "Schwerin", 6);
        graph.connect("Rostock", "Torgelow", 19);
        graph.connect("Schwerin", "Hamburg", 8);
        graph.connect("Schwerin", "Magdeburg", 18);
        graph.connect("Schwerin", "Berlin", 18);
        graph.connect("Torgelow", "Berlin", 15);
        graph.connect("Torgelow", "Frankfurt-O", 15);

        graph.connect("Cuxhaven", "Wilhelmshaven", 8);
        graph.connect("Cuxhaven", "Bremen", 8);
        graph.connect("Cuxhaven", "Hamburg", 11);
        graph.connect("Wilhelmshaven", "Bremen", 11);
        graph.connect("Bremen", "Hamburg", 11);
        graph.connect("Bremen", "Hannover", 10);
        graph.connect("Bremen", "Osnabruck", 11);
        graph.connect("Hannover", "Hamburg", 17);
        graph.connect("Hannover", "Osnabruck", 16);
        graph.connect("Hannover", "Kassel", 15);
        graph.connect("Hannover", "Magdeburg", 15);

        graph.connect("Osnabruck", "Munster", 7);
        graph.connect("Munster", "Essen", 6);
        graph.connect("Munster", "Dortmund", 2);
        graph.connect("Duisburg", "Essen", 2);
        graph.connect("Duisburg", "Dusseldorf", 2);
        graph.connect("Essen", "Dortmund", 4);
        graph.connect("Dortmund", "Kassel", 18);
        graph.connect("Dusseldorf", "Koln", 4);
        graph.connect("Koln", "Aachen", 7);
        graph.connect("Aachen", "Trier", 19);
        graph.connect("Koln", "Trier", 21);
        graph.connect("Koln", "Frankfurt-M", 20);

        graph.connect("Trier", "Wiesbaden", 18);
        graph.connect("Trier", "Saarbrucken", 11);
        graph.connect("Wiesbaden", "Frankfurt-M", 0);
        graph.connect("Frankfurt-M", "Mannheim", 11);
        graph.connect("Frankfurt-M", "Fulda", 8);
        graph.connect("Frankfurt-M", "Kassel", 13);
        graph.connect("Wiesbaden", "Saarbrucken", 10);
        graph.connect("Saarbrucken", "Mannheim", 11);
        graph.connect("Mannheim", "Wurzburg", 10);
        graph.connect("Mannheim", "Stuttgart", 6);
        graph.connect("Kassel", "Fulda", 8);
        graph.connect("Kassel", "Erfurt", 15);

        graph.connect("Fulda", "Wurzburg", 11);
        graph.connect("Fulda", "Erfurt", 13);
        graph.connect("Wurzburg", "Erfurt", 21);
        graph.connect("Wurzburg", "Nurnberg", 8);
        graph.connect("Erfurt", "Halle", 6);
        graph.connect("Erfurt", "Leipzig", 19);
        graph.connect("Halle", "Magdeburg", 11);
        graph.connect("Halle", "Leipzig", 6);
        graph.connect("Leipzig", "Dresden", 13);
        graph.connect("Magdeburg", "Berlin", 10);
        graph.connect("Berlin", "Frankfurt-O", 6);
        graph.connect("Berlin", "Leipzig", 17);

        graph.connect("Stuttgart", "Freiburg", 16);
        graph.connect("Stuttgart", "Augsburg", 15);
        graph.connect("Freiburg", "Konstanz", 14);
        graph.connect("Konstanz", "Augsburg", 17);
        graph.connect("Augsburg", "Munchen", 6);
        graph.connect("Augsburg", "Regensburg", 13);
        graph.connect("Augsburg", "Nurnberg", 18);
        graph.connect("Nurnberg", "Regensburg", 12);
        graph.connect("Regensburg", "Munchen", 10);
        graph.connect("Regensburg", "Passau", 12);
        graph.connect("Munchen", "Passau", 14);

        return graph;
    }

    public void addCity(String name, String zone, int x, int y) {
        CityNode node = new CityNode(name, zone, x, y);
        addNode(node);
        cityByName.put(name, node);
    }

    public void connect(String a, String b, int cost) {
        CityNode first = getCity(a);
        CityNode second = getCity(b);
        if (first == null || second == null) {
            return;
        }
        Edge edge = new Edge(first, second, cost);
        addEdge(edge);
        first.addEdge(edge);
        second.addEdge(edge);
    }

    public CityNode getCity(String name) {
        return cityByName.get(name);
    }

    public int cheapestConnectionCost(Player player, CityNode target) {
        if (player.getCities().isEmpty()) {
            return 0;
        }

        Map<CityNode, Integer> distance = new HashMap<>();
        PriorityQueue<CityDistance> queue = new PriorityQueue<>(new Comparator<CityDistance>() {
            @Override
            public int compare(CityDistance first, CityDistance second) {
                return Integer.compare(first.cost, second.cost);
            }
        });
        HashSet<CityNode> visited = new HashSet<>();

        for (CityNode city : player.getCities()) {
            distance.put(city, 0);
            queue.add(new CityDistance(city, 0));
        }

        while (!queue.isEmpty()) {
            CityDistance current = queue.poll();
            if (!visited.add(current.city)) {
                continue;
            }
            if (current.city.equals(target)) {
                return current.cost;
            }
            for (Edge edge : current.city.getAdjacentEdges()) {
                CityNode next = edge.getOtherNode(current.city);
                int newCost = current.cost + edge.getCost();
                if (newCost < distance.getOrDefault(next, Integer.MAX_VALUE)) {
                    distance.put(next, newCost);
                    queue.add(new CityDistance(next, newCost));
                }
            }
        }
        return Integer.MAX_VALUE / 2;
    }

    public ArrayList<Edge> getShortestPath(CityNode startNode, CityNode targetNode) {
        ArrayList<Edge> path = new ArrayList<>();
        if (startNode == null || targetNode == null) {
            return path;
        }

        Map<CityNode, Integer> distance = new HashMap<>();
        Map<CityNode, Edge> previousEdge = new HashMap<>();
        PriorityQueue<CityDistance> queue = new PriorityQueue<>(new Comparator<CityDistance>() {
            @Override
            public int compare(CityDistance first, CityDistance second) {
                return Integer.compare(first.cost, second.cost);
            }
        });
        HashSet<CityNode> visited = new HashSet<>();

        distance.put(startNode, 0);
        queue.add(new CityDistance(startNode, 0));

        while (!queue.isEmpty()) {
            CityDistance current = queue.poll();
            if (!visited.add(current.city)) {
                continue;
            }
            if (current.city.equals(targetNode)) {
                break;
            }
            for (Edge edge : current.city.getAdjacentEdges()) {
                CityNode next = edge.getOtherNode(current.city);
                int newCost = current.cost + edge.getCost();
                if (newCost < distance.getOrDefault(next, Integer.MAX_VALUE)) {
                    distance.put(next, newCost);
                    previousEdge.put(next, edge);
                    queue.add(new CityDistance(next, newCost));
                }
            }
        }

        CityNode current = targetNode;
        while (!current.equals(startNode) && previousEdge.containsKey(current)) {
            Edge edge = previousEdge.get(current);
            path.add(0, edge);
            current = edge.getOtherNode(current);
        }
        if (!current.equals(startNode)) {
            path.clear();
        }
        return path;
    }

    public void addNode(CityNode node) {
        if (node != null && !nodes.contains(node)) {
            nodes.add(node);
        }
    }

    public void removeNode(CityNode node) {
        nodes.remove(node);
        cityByName.remove(node.getName());
        edges.removeIf(edge -> edge.getANode().equals(node) || edge.getBNode().equals(node));
    }

    public void addEdge(Edge edge) {
        if (edge != null && !edges.contains(edge)) {
            edges.add(edge);
        }
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    public ArrayList<CityNode> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    private static class CityDistance {
        private final CityNode city;
        private final int cost;

        CityDistance(CityNode city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}
