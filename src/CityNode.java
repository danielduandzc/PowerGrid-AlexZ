package src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CityNode {
    private final String cityName;
    private final String zoneColor;
    private final int x;
    private final int y;
    private final ArrayList<Edge> adjacentEdges;
    private final ArrayList<Integer> occupantIds;
    private int distance;

    public CityNode(String cityName, String zoneColor) {
        this(cityName, zoneColor, 0, 0);
    }

    public CityNode(String cityName, String zoneColor, int x, int y) {
        this.cityName = cityName;
        this.zoneColor = zoneColor;
        this.x = x;
        this.y = y;
        this.adjacentEdges = new ArrayList<>();
        this.occupantIds = new ArrayList<>();
    }

    public String getName() {
        return cityName;
    }

    public String getZoneColor() {
        return zoneColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Integer> getOccupantIds() {
        return occupantIds;
    }

    public boolean isOccupiedBy(Player player) {
        return occupantIds.contains(player.getId());
    }

    public int getOccupancy() {
        return occupantIds.size();
    }

    public boolean canBuild(Player player, int step) {
        return !isOccupiedBy(player) && occupantIds.size() < Math.min(step, 3);
    }

    public void addOccupant(Player player) {
        if (!occupantIds.contains(player.getId())) {
            occupantIds.add(player.getId());
        }
    }

    public int getBuildCost() {
        if (occupantIds.isEmpty()) {
            return 10;
        }
        if (occupantIds.size() == 1) {
            return 15;
        }
        return 20;
    }

    public Color getZonePaint() {
        if ("North".equals(zoneColor)) {
            return new Color(44, 126, 137);
        }
        if ("West".equals(zoneColor)) {
            return new Color(239, 145, 61);
        }
        if ("Rhine".equals(zoneColor)) {
            return new Color(209, 70, 66);
        }
        if ("Center".equals(zoneColor)) {
            return new Color(229, 204, 77);
        }
        if ("East".equals(zoneColor)) {
            return new Color(80, 99, 173);
        }
        if ("South".equals(zoneColor)) {
            return new Color(122, 85, 157);
        }
        return Color.LIGHT_GRAY;
    }

    public void addEdge(Edge edge) {
        adjacentEdges.add(edge);
    }

    public void removeEdge(Edge edge) {
        adjacentEdges.remove(edge);
    }

    public ArrayList<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getFirstSector() {
        return occupantIds.size() > 0 ? occupantIds.get(0) : 0;
    }

    public void setFirstSector(int playerId) {
        if (occupantIds.isEmpty()) {
            occupantIds.add(playerId);
        } else {
            occupantIds.set(0, playerId);
        }
    }

    public int getSecondSector() {
        return occupantIds.size() > 1 ? occupantIds.get(1) : 0;
    }

    public void setSecondSector(int playerId) {
        while (occupantIds.size() < 2) {
            occupantIds.add(0);
        }
        occupantIds.set(1, playerId);
    }

    public int getThirdSector() {
        return occupantIds.size() > 2 ? occupantIds.get(2) : 0;
    }

    public void setThirdSector(int playerId) {
        while (occupantIds.size() < 3) {
            occupantIds.add(0);
        }
        occupantIds.set(2, playerId);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CityNode cityNode)) {
            return false;
        }
        return Objects.equals(cityName, cityNode.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }
}
