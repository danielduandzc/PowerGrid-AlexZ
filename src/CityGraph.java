package src;
import java.util.*;

public class CityGraph {
    private ArrayList<CityNode> nodes;
    private ArrayList<Edge> edges;

    public CityGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public int getShortestPath(CityNode startNode, CityNode targetNode) {
        // Implementation for shortest path algorithm (e.g., Dijkstra's)
        PriorityQueue<CityNode> adjacentCities = new PriorityQueue<CityNode>();
        HashSet<CityNode> visitedNodes = new HashSet<>();
        CityNode currentNode = startNode;
        adjacentCities.offer(currentNode);
        startNode.setDistance(0);
        for(CityNode n: nodes)
            n.setDistance(Integer.MAX_VALUE);
        
        while(!adjacentCities.isEmpty()){ 
            if(visitedNodes.containsAll(nodes)
               return targetNode.getDistance();
            
            currentNode = adjacentCities.poll();
            visitedNodes.add(currentNode);
            
            for(Edge e: currentNode.getAdjacentEdges()){
                if(e.getOtherNode(currentNode).equals(targetNode))
                    return targetNode.getDistance;
                if(visitedNodes.contains(e.getOtherNode(currentNode)))
                    continue;
                else{
                    adjacentCities.offer(e.getOtherNode(currentNode));
                    if((currentNode.getDistance() + e.getCost()) < e.getOtherNode(currentNode).getDistance())
                        e.getOtherNode(currentNode).setDistance(currentNode.getDistance() + e.getCost());
                }
            }
        }
    }

    public void addNode(CityNode n) {
        if (n != null && !nodes.contains(n)) {
            nodes.add(n);
        }
    }

    public CityNode getNode(String name){
        for(CityNode n: nodes)
            if(n.getName().equals(name))
                return n;
        return null;
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
