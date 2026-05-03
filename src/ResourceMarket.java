package src;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class ResourceMarket {
    private static final int[] BASIC_PRICES = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final int[] URANIUM_PRICES = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14, 16};
    private static final int BASIC_SLOT_CAPACITY = 3;
    private static final int URANIUM_SLOT_CAPACITY = 1;

    private final EnumMap<Resource, int[]> prices;
    private final EnumMap<Resource, int[]> marketCounts;
    private final EnumMap<Resource, Integer> supplyCounts;

    public ResourceMarket() {
        prices = new EnumMap<>(Resource.class);
        marketCounts = new EnumMap<>(Resource.class);
        supplyCounts = new EnumMap<>(Resource.class);
        reset();
    }

    public final void reset() {
        prices.put(Resource.COAL, BASIC_PRICES.clone());
        prices.put(Resource.OIL, BASIC_PRICES.clone());
        prices.put(Resource.GARBAGE, BASIC_PRICES.clone());
        prices.put(Resource.URANIUM, URANIUM_PRICES.clone());

        marketCounts.put(Resource.COAL, new int[BASIC_PRICES.length]);
        marketCounts.put(Resource.OIL, new int[BASIC_PRICES.length]);
        marketCounts.put(Resource.GARBAGE, new int[BASIC_PRICES.length]);
        marketCounts.put(Resource.URANIUM, new int[URANIUM_PRICES.length]);

        fillStarting(Resource.COAL, 1);
        fillStarting(Resource.OIL, 3);
        fillStarting(Resource.GARBAGE, 6);
        fillStarting(Resource.URANIUM, 14);

        supplyCounts.put(Resource.COAL, 24 - countInMarket(Resource.COAL));
        supplyCounts.put(Resource.OIL, 24 - countInMarket(Resource.OIL));
        supplyCounts.put(Resource.GARBAGE, 24 - countInMarket(Resource.GARBAGE));
        supplyCounts.put(Resource.URANIUM, 12 - countInMarket(Resource.URANIUM));
    }

    private void fillStarting(Resource resource, int cheapestStartingPrice) {
        int[] resourcePrices = prices.get(resource);
        int[] counts = marketCounts.get(resource);
        int capacity = slotCapacity(resource);
        for (int i = 0; i < resourcePrices.length; i++) {
            if (resourcePrices[i] >= cheapestStartingPrice) {
                counts[i] = capacity;
            }
        }
    }

    public int getCheapestPrice(Resource resource) {
        int[] resourcePrices = prices.get(resource);
        int[] counts = marketCounts.get(resource);
        for (int i = 0; i < resourcePrices.length; i++) {
            if (counts[i] > 0) {
                return resourcePrices[i];
            }
        }
        return -1;
    }

    public int buy(Resource resource) {
        int[] resourcePrices = prices.get(resource);
        int[] counts = marketCounts.get(resource);
        for (int i = 0; i < resourcePrices.length; i++) {
            if (counts[i] > 0) {
                counts[i]--;
                return resourcePrices[i];
            }
        }
        return -1;
    }

    public void returnToSupply(Resource resource, int amount) {
        supplyCounts.put(resource, supplyCounts.getOrDefault(resource, 0) + amount);
    }

    public void refill(int playerCount, int step, boolean refillUranium) {
        Map<Resource, Integer> amounts = refillAmounts(playerCount, step);
        for (Resource resource : Resource.values()) {
            if (resource == Resource.URANIUM && !refillUranium) {
                continue;
            }
            refillResource(resource, amounts.getOrDefault(resource, 0));
        }
    }

    private void refillResource(Resource resource, int amount) {
        int[] counts = marketCounts.get(resource);
        int supply = supplyCounts.getOrDefault(resource, 0);
        int capacity = slotCapacity(resource);
        for (int i = counts.length - 1; i >= 0 && amount > 0 && supply > 0; i--) {
            while (counts[i] < capacity && amount > 0 && supply > 0) {
                counts[i]++;
                amount--;
                supply--;
            }
        }
        supplyCounts.put(resource, supply);
    }

    public int countInMarket(Resource resource) {
        return Arrays.stream(marketCounts.get(resource)).sum();
    }

    public int getSupplyCount(Resource resource) {
        return supplyCounts.getOrDefault(resource, 0);
    }

    public String getTrackSummary(Resource resource) {
        StringBuilder summary = new StringBuilder();
        int[] resourcePrices = prices.get(resource);
        int[] counts = marketCounts.get(resource);
        for (int i = 0; i < resourcePrices.length; i++) {
            if (counts[i] > 0) {
                if (summary.length() > 0) {
                    summary.append("  ");
                }
                summary.append(resourcePrices[i]).append(":").append(counts[i]);
            }
        }
        return summary.length() == 0 ? "empty" : summary.toString();
    }

    private int slotCapacity(Resource resource) {
        return resource == Resource.URANIUM ? URANIUM_SLOT_CAPACITY : BASIC_SLOT_CAPACITY;
    }

    public static Map<Resource, Integer> refillAmounts(int playerCount, int step) {
        int normalizedStep = Math.max(1, Math.min(step, 3));
        int[][] values;
        if (playerCount <= 2) {
            values = new int[][]{{3, 2, 1, 1}, {4, 2, 2, 1}, {3, 4, 3, 1}};
        } else if (playerCount == 3) {
            values = new int[][]{{4, 2, 1, 1}, {5, 3, 2, 1}, {3, 4, 3, 1}};
        } else if (playerCount == 4) {
            values = new int[][]{{5, 3, 2, 2}, {6, 4, 3, 3}, {4, 5, 4, 2}};
        } else if (playerCount == 5) {
            values = new int[][]{{5, 4, 3, 2}, {7, 5, 3, 3}, {5, 6, 5, 2}};
        } else {
            values = new int[][]{{7, 5, 3, 2}, {9, 6, 5, 3}, {6, 7, 6, 3}};
        }
        int[] selected = values[normalizedStep - 1];
        EnumMap<Resource, Integer> refill = new EnumMap<>(Resource.class);
        refill.put(Resource.COAL, selected[0]);
        refill.put(Resource.OIL, selected[1]);
        refill.put(Resource.GARBAGE, selected[2]);
        refill.put(Resource.URANIUM, selected[3]);
        return refill;
    }
}
