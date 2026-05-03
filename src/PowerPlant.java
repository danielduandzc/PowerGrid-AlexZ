package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PowerPlant {
    private final int number;
    private final int citiesPowered;
    private final int resourceCost;
    private final EnumSet<Resource> resourceTypes;
    private final EnumMap<Resource, Integer> storedResources;
    private final boolean stepThreeCard;

    public PowerPlant(int number, int citiesPowered, int resourceCost, Resource... resourceTypes) {
        this.number = number;
        this.citiesPowered = citiesPowered;
        this.resourceCost = resourceCost;
        this.resourceTypes = resourceTypes.length == 0
                ? EnumSet.noneOf(Resource.class)
                : EnumSet.copyOf(Arrays.asList(resourceTypes));
        this.storedResources = new EnumMap<>(Resource.class);
        this.stepThreeCard = false;
        for (Resource resource : Resource.values()) {
            storedResources.put(resource, 0);
        }
    }

    private PowerPlant() {
        this.number = 999;
        this.citiesPowered = 0;
        this.resourceCost = 0;
        this.resourceTypes = EnumSet.noneOf(Resource.class);
        this.storedResources = new EnumMap<>(Resource.class);
        this.stepThreeCard = true;
    }

    public static PowerPlant stepThreeCard() {
        return new PowerPlant();
    }

    public boolean isStepThreeCard() {
        return stepThreeCard;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return number;
    }

    public int getCitiesPowered() {
        return citiesPowered;
    }

    public int getPowerOutput() {
        return citiesPowered;
    }

    public int getResourceCost() {
        return resourceCost;
    }

    public int getFuelCost() {
        return resourceCost;
    }

    public EnumSet<Resource> getResourceTypes() {
        return EnumSet.copyOf(resourceTypes);
    }

    public ArrayList<Resource> getFuelType() {
        return new ArrayList<>(resourceTypes);
    }

    public int getStorageCapacity() {
        return resourceCost * 2;
    }

    public int getMaxResources() {
        return getStorageCapacity();
    }

    public int getTotalStoredResources() {
        int total = 0;
        for (int amount : storedResources.values()) {
            total += amount;
        }
        return total;
    }

    public int getStored(Resource resource) {
        return storedResources.getOrDefault(resource, 0);
    }

    public Map<Resource, Integer> getStoredResources() {
        return new EnumMap<>(storedResources);
    }

    public ArrayList<Resource> getCurrentResources() {
        ArrayList<Resource> resources = new ArrayList<>();
        for (Resource resource : Resource.values()) {
            for (int i = 0; i < getStored(resource); i++) {
                resources.add(resource);
            }
        }
        return resources;
    }

    public boolean isEcological() {
        return resourceTypes.isEmpty();
    }

    public boolean canStore(Resource resource) {
        return !isEcological()
                && resourceTypes.contains(resource)
                && getTotalStoredResources() < getStorageCapacity();
    }

    public boolean addResource(Resource resource) {
        if (!canStore(resource)) {
            return false;
        }
        storedResources.put(resource, getStored(resource) + 1);
        return true;
    }

    public boolean canRun() {
        return isEcological() || getTotalStoredResources() >= resourceCost;
    }

    public int getPotentialOutput() {
        return canRun() ? citiesPowered : 0;
    }

    public int runAndConsume(ResourceMarket resourceMarket) {
        if (!canRun()) {
            return 0;
        }
        if (isEcological()) {
            return citiesPowered;
        }

        int remaining = resourceCost;
        List<Resource> preferredOrder = resourceTypes.stream()
                .sorted(Comparator.comparingInt(Resource::ordinal))
                .collect(Collectors.toList());
        for (Resource resource : preferredOrder) {
            while (remaining > 0 && getStored(resource) > 0) {
                storedResources.put(resource, getStored(resource) - 1);
                resourceMarket.returnToSupply(resource, 1);
                remaining--;
            }
        }
        return remaining == 0 ? citiesPowered : 0;
    }

    public String getFuelSummary() {
        if (isStepThreeCard()) {
            return "Step 3";
        }
        if (isEcological()) {
            return "Eco";
        }
        String fuels = resourceTypes.stream()
                .map(Resource::getLabel)
                .collect(Collectors.joining("/"));
        return resourceCost + " " + fuels;
    }

    public String getStorageSummary() {
        if (isEcological()) {
            return "-";
        }
        return resourceTypes.stream()
                .map(resource -> resource.getLabel().charAt(0) + ":" + getStored(resource))
                .collect(Collectors.joining(" ")) + " / " + getStorageCapacity();
    }

    @Override
    public String toString() {
        if (isStepThreeCard()) {
            return "Step 3";
        }
        return "#" + number + " (" + getFuelSummary() + " -> " + citiesPowered + ")";
    }
}
