package src;

import java.util.ArrayList;

public class PowerPlantHub {
    private ArrayList<PowerPlant> powerPlants;
    private PowerPlant[] currentMarket;
    private PowerPlant[] futureMarket;

    public PowerPlantHub() {
        powerPlants = new ArrayList<>();
        currentMarket = new PowerPlant[4];
        futureMarket = new PowerPlant[4];
    }

    public PowerPlant drawPowerPlant() {
        if (powerPlants.isEmpty()) {
            return null;
        }
        return powerPlants.remove(0);
    }

    public void addPowerPlant(PowerPlant p) {
        powerPlants.add(p);
    }

    public void discardPowerPlant(PowerPlant p) {
        powerPlants.remove(p);
    }

    public PowerPlant[] getCurrentMarket() {
        return currentMarket;
    }

    public PowerPlant[] getFutureMarket() {
        return futureMarket;
    }
}