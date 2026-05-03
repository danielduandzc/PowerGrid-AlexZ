package src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final int id;
    private final String name;
    private String colorName;
    private Color color;
    private int elektro;
    private final ArrayList<PowerPlant> powerPlants;
    private final LinkedHashSet<CityNode> cities;

    public Player() {
        this(1, "Player 1", "Red", new Color(204, 55, 55));
    }

    public Player(int id, String name, String colorName, Color color) {
        this.id = id;
        this.name = name;
        this.colorName = colorName;
        this.color = color;
        this.elektro = 50;
        this.powerPlants = new ArrayList<>();
        this.cities = new LinkedHashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setColor(String colorName) {
        this.colorName = colorName;
    }

    public String getColor() {
        return colorName;
    }

    public Color getPlayerColor() {
        return color;
    }

    public void setPlayerColor(Color color) {
        this.color = color;
    }

    public int addElektro(int amount) {
        elektro += amount;
        return elektro;
    }

    public int getElektro() {
        return elektro;
    }

    public boolean canAfford(int amount) {
        return elektro >= amount;
    }

    public void spend(int amount) {
        elektro -= amount;
    }

    public void earn(int amount) {
        elektro += amount;
    }

    public ArrayList<PowerPlant> getPowerPlants() {
        return powerPlants;
    }

    public void buyPowerPlant(PowerPlant plant) {
        buyPowerPlant(plant, plant.getNumber());
    }

    public void buyPowerPlant(PowerPlant plant, int pricePaid) {
        spend(pricePaid);
        powerPlants.add(plant);
        if (powerPlants.size() > 3) {
            scrapSmallestPlantExcept(plant);
        }
    }

    private void scrapSmallestPlantExcept(PowerPlant newPlant) {
        PowerPlant scrap = powerPlants.stream()
                .filter(plant -> plant != newPlant)
                .min(Comparator.comparingInt(PowerPlant::getNumber))
                .orElse(null);
        if (scrap != null) {
            powerPlants.remove(scrap);
            for (Resource resource : Resource.values()) {
                int amount = scrap.getStored(resource);
                for (int i = 0; i < amount; i++) {
                    storeResource(resource);
                }
            }
        }
    }

    public boolean canStore(Resource resource) {
        for (PowerPlant plant : powerPlants) {
            if (plant.canStore(resource)) {
                return true;
            }
        }
        return false;
    }

    public boolean storeResource(Resource resource) {
        PowerPlant bestPlant = powerPlants.stream()
                .filter(plant -> plant.canStore(resource))
                .min(Comparator.comparingInt(PowerPlant::getTotalStoredResources))
                .orElse(null);
        return bestPlant != null && bestPlant.addResource(resource);
    }

    public Set<CityNode> getCities() {
        return cities;
    }

    public int getNumHouses() {
        return cities.size();
    }

    public void addCity(CityNode city) {
        cities.add(city);
    }

    public boolean ownsCity(CityNode city) {
        return cities.contains(city);
    }

    public int getLargestPlantNumber() {
        return powerPlants.stream()
                .mapToInt(PowerPlant::getNumber)
                .max()
                .orElse(0);
    }

    public int calculateSupplyableCities() {
        int output = 0;
        for (PowerPlant plant : powerPlants) {
            output += plant.getPotentialOutput();
        }
        return Math.min(output, getNumHouses());
    }

    public int autoPowerCities(ResourceMarket resourceMarket) {
        List<PowerPlant> sortedPlants = new ArrayList<>(powerPlants);
        sortedPlants.sort(Comparator.comparingInt(PowerPlant::getCitiesPowered).reversed());
        int output = 0;
        for (PowerPlant plant : sortedPlants) {
            output += plant.runAndConsume(resourceMarket);
        }
        return Math.min(output, getNumHouses());
    }
}
