package src;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GameState {
    public static ArrayList<String> currentEvent = new ArrayList<>();
    public static int currentPlayerIndex = 0;
    public static int currentStep = 1;
    public static Player[] players = new Player[4];
    public static int[] playerOrder = new int[]{1, 2, 3, 4};
    public static BufferedImage boardImage;
    public static CityGraph graphOfCity = new CityGraph();
    public static boolean[] isColorSelected = new boolean[6];
    public static boolean[] isZoneSelected = new boolean[6];
    public static InitialPanel initialPanel;
    public static int minBid = 0;
    public static PowerPlant auctionedPowerPlant;
    public static ArrayList<PowerPlant> powerPlantDeck = new ArrayList<>();
    public static ArrayList<PowerPlant> powerPlantsInMarket = new ArrayList<>();

    private static final int[] PAYMENTS = {
            10, 22, 33, 44, 54, 64, 73, 82, 90, 98, 105,
            112, 118, 124, 129, 134, 138, 142, 145, 148, 150
    };

    private static final Color[] PLAYER_COLORS = {
            new Color(210, 66, 66),
            new Color(226, 184, 45),
            new Color(62, 157, 99),
            new Color(61, 120, 205)
    };

    private static final String[] COLOR_NAMES = {"Red", "Yellow", "Green", "Blue"};

    private GamePhase phase = GamePhase.TITLE;
    private int playerCount = 4;
    private int round = 1;
    private int step = 1;
    private CityGraph cityGraph = CityGraph.createGermanyMap();
    private ResourceMarket resourceMarket = new ResourceMarket();
    private final ArrayList<Player> activePlayers = new ArrayList<>();
    private final ArrayList<Player> turnOrder = new ArrayList<>();
    private final ArrayList<Player> reverseTurnOrder = new ArrayList<>();
    private final ArrayList<PowerPlant> plantDeck = new ArrayList<>();
    private final ArrayList<PowerPlant> plantsUnderStepThree = new ArrayList<>();
    private final ArrayList<PowerPlant> plantMarket = new ArrayList<>();
    private final LinkedList<String> log = new LinkedList<>();
    private final Set<Integer> boughtThisAuctionPhase = new HashSet<>();
    private final Set<Integer> optedOutAuctionPhase = new HashSet<>();
    private final Set<Integer> auctionActivePlayerIds = new HashSet<>();

    private int phaseTurnIndex = 0;
    private int auctioneerOrderIndex = 0;
    private int currentBidderOrderIndex = 0;
    private int currentBid = 0;
    private Player highBidder;
    private Player auctioneer;
    private PowerPlant auctionPlant;
    private int discountPlantNumber = -1;
    private boolean discountActive = false;
    private boolean firstAuctionRound = true;
    private boolean stepTwoPending = false;
    private boolean stepThreePending = false;
    private boolean uraniumRefillAllowed = true;
    private boolean finalBureaucracy = false;
    private String winnerText = "";

    public GameState() {
        resetPlayers(4);
        log("Welcome to Power Grid. Choose a player count and start.");
    }

    public void setPlayerCount(int playerCount) {
        if (phase != GamePhase.TITLE && phase != GamePhase.SETUP) {
            return;
        }
        this.playerCount = Math.max(3, Math.min(4, playerCount));
        resetPlayers(this.playerCount);
    }

    private void resetPlayers(int count) {
        activePlayers.clear();
        for (int i = 0; i < count; i++) {
            Player player = new Player(i + 1, "Player " + (i + 1), COLOR_NAMES[i], PLAYER_COLORS[i]);
            activePlayers.add(player);
            if (i < players.length) {
                players[i] = player;
            }
        }
    }

    public void showSetup() {
        phase = GamePhase.SETUP;
    }

    public void startNewGame() {
        round = 1;
        step = 1;
        currentStep = step;
        phaseTurnIndex = 0;
        auctioneerOrderIndex = 0;
        currentBidderOrderIndex = 0;
        currentBid = 0;
        discountPlantNumber = -1;
        discountActive = false;
        firstAuctionRound = true;
        stepTwoPending = false;
        stepThreePending = false;
        uraniumRefillAllowed = true;
        finalBureaucracy = false;
        winnerText = "";
        cityGraph = CityGraph.createGermanyMap();
        graphOfCity = cityGraph;
        resourceMarket = new ResourceMarket();
        resetPlayers(playerCount);
        setupPowerPlants();
        turnOrder.clear();
        turnOrder.addAll(activePlayers);
        Collections.shuffle(turnOrder);
        syncLegacyPlayerOrder();
        log.clear();
        log("Game started with " + playerCount + " players on the Germany map.");
        beginAuctionPhase();
    }

    private void setupPowerPlants() {
        plantDeck.clear();
        plantsUnderStepThree.clear();
        plantMarket.clear();
        powerPlantDeck.clear();
        powerPlantsInMarket.clear();

        ArrayList<PowerPlant> plugPlants = new ArrayList<>();
        for (PowerPlant plant : createAllPowerPlants()) {
            if (plant.getNumber() <= 15) {
                plugPlants.add(plant);
            }
        }
        Collections.shuffle(plugPlants);
        for (int i = 0; i < 8 && !plugPlants.isEmpty(); i++) {
            plantMarket.add(plugPlants.remove(0));
        }
        PowerPlant topPlant = plugPlants.isEmpty() ? null : plugPlants.remove(0);

        int[] removalCounts = removalCountsForPlayers(playerCount);
        for (int i = 0; i < removalCounts[0] && !plugPlants.isEmpty(); i++) {
            plugPlants.remove(0);
        }

        ArrayList<PowerPlant> socketPlants = new ArrayList<>();
        for (PowerPlant plant : createAllPowerPlants()) {
            if (plant.getNumber() >= 16) {
                socketPlants.add(plant);
            }
        }
        Collections.shuffle(socketPlants);
        for (int i = 0; i < removalCounts[1] && !socketPlants.isEmpty(); i++) {
            socketPlants.remove(0);
        }

        plantDeck.addAll(plugPlants);
        plantDeck.addAll(socketPlants);
        Collections.shuffle(plantDeck);
        plantDeck.add(PowerPlant.stepThreeCard());
        if (topPlant != null) {
            plantDeck.add(0, topPlant);
        }
        sortMarket();
        syncLegacyPowerPlants();
    }

    private int[] removalCountsForPlayers(int count) {
        if (count == 3) {
            return new int[]{2, 6};
        }
        if (count == 4) {
            return new int[]{1, 3};
        }
        return new int[]{1, 5};
    }

    private ArrayList<PowerPlant> createAllPowerPlants() {
        ArrayList<PowerPlant> plants = new ArrayList<>();
        plants.add(new PowerPlant(3, 1, 2, Resource.OIL));
        plants.add(new PowerPlant(4, 1, 2, Resource.COAL));
        plants.add(new PowerPlant(5, 1, 2, Resource.COAL, Resource.OIL));
        plants.add(new PowerPlant(6, 1, 1, Resource.GARBAGE));
        plants.add(new PowerPlant(7, 2, 3, Resource.OIL));
        plants.add(new PowerPlant(8, 2, 3, Resource.COAL));
        plants.add(new PowerPlant(9, 1, 1, Resource.OIL));
        plants.add(new PowerPlant(10, 2, 2, Resource.COAL));
        plants.add(new PowerPlant(11, 2, 1, Resource.URANIUM));
        plants.add(new PowerPlant(12, 2, 2, Resource.COAL, Resource.OIL));
        plants.add(new PowerPlant(13, 1, 0));
        plants.add(new PowerPlant(14, 2, 2, Resource.GARBAGE));
        plants.add(new PowerPlant(15, 3, 2, Resource.COAL));
        plants.add(new PowerPlant(16, 3, 2, Resource.OIL));
        plants.add(new PowerPlant(17, 2, 1, Resource.URANIUM));
        plants.add(new PowerPlant(18, 2, 0));
        plants.add(new PowerPlant(19, 3, 2, Resource.GARBAGE));
        plants.add(new PowerPlant(20, 5, 3, Resource.COAL));
        plants.add(new PowerPlant(21, 4, 2, Resource.COAL, Resource.OIL));
        plants.add(new PowerPlant(22, 2, 0));
        plants.add(new PowerPlant(23, 3, 1, Resource.URANIUM));
        plants.add(new PowerPlant(24, 4, 2, Resource.GARBAGE));
        plants.add(new PowerPlant(25, 5, 2, Resource.COAL));
        plants.add(new PowerPlant(26, 5, 2, Resource.OIL));
        plants.add(new PowerPlant(27, 3, 0));
        plants.add(new PowerPlant(28, 4, 1, Resource.URANIUM));
        plants.add(new PowerPlant(29, 4, 1, Resource.COAL, Resource.OIL));
        plants.add(new PowerPlant(30, 6, 3, Resource.GARBAGE));
        plants.add(new PowerPlant(31, 6, 3, Resource.COAL));
        plants.add(new PowerPlant(32, 6, 3, Resource.OIL));
        plants.add(new PowerPlant(33, 4, 0));
        plants.add(new PowerPlant(34, 5, 1, Resource.URANIUM));
        plants.add(new PowerPlant(35, 5, 1, Resource.OIL));
        plants.add(new PowerPlant(36, 7, 3, Resource.COAL));
        plants.add(new PowerPlant(37, 4, 0));
        plants.add(new PowerPlant(38, 7, 3, Resource.GARBAGE));
        plants.add(new PowerPlant(39, 6, 1, Resource.URANIUM));
        plants.add(new PowerPlant(40, 6, 2, Resource.OIL));
        plants.add(new PowerPlant(42, 6, 2, Resource.COAL));
        plants.add(new PowerPlant(44, 5, 0));
        plants.add(new PowerPlant(46, 7, 3, Resource.COAL, Resource.OIL));
        plants.add(new PowerPlant(50, 6, 0));
        return plants;
    }

    public void determinePlayerOrder() {
        turnOrder.clear();
        turnOrder.addAll(activePlayers);
        turnOrder.sort(new Comparator<Player>() {
            @Override
            public int compare(Player first, Player second) {
                int cityCompare = Integer.compare(second.getNumHouses(), first.getNumHouses());
                if (cityCompare != 0) {
                    return cityCompare;
                }
                return Integer.compare(second.getLargestPlantNumber(), first.getLargestPlantNumber());
            }
        });
        syncLegacyPlayerOrder();
    }

    private void beginAuctionPhase() {
        if (!firstAuctionRound) {
            determinePlayerOrder();
        }
        boughtThisAuctionPhase.clear();
        optedOutAuctionPhase.clear();
        auctionPlant = null;
        highBidder = null;
        auctioneer = null;
        currentBid = 0;
        auctioneerOrderIndex = 0;
        discountActive = !getCurrentMarket().isEmpty();
        discountPlantNumber = discountActive ? getCurrentMarket().get(0).getNumber() : -1;
        phase = GamePhase.AUCTION_SELECT;
        log("Round " + round + ": auction begins. The smallest current plant is discounted.");
        selectNextAuctioneer();
    }

    private void selectNextAuctioneer() {
        while (auctioneerOrderIndex < turnOrder.size()) {
            Player candidate = turnOrder.get(auctioneerOrderIndex);
            if (!boughtThisAuctionPhase.contains(candidate.getId())
                    && !optedOutAuctionPhase.contains(candidate.getId())) {
                auctioneer = candidate;
                currentPlayerIndex = candidate.getId() - 1;
                phase = GamePhase.AUCTION_SELECT;
                return;
            }
            auctioneerOrderIndex++;
        }
        finishAuctionPhase();
    }

    public void passAuction() {
        if (phase != GamePhase.AUCTION_SELECT || auctioneer == null) {
            return;
        }
        if (firstAuctionRound) {
            log("Everyone must buy one power plant in the first auction round.");
            return;
        }
        optedOutAuctionPhase.add(auctioneer.getId());
        log(auctioneer.getName() + " opts out of this auction phase.");
        auctioneerOrderIndex++;
        selectNextAuctioneer();
    }

    public void startAuction(PowerPlant plant) {
        if (phase != GamePhase.AUCTION_SELECT || plant == null || !getCurrentMarket().contains(plant)) {
            return;
        }
        auctionPlant = plant;
        auctionedPowerPlant = plant;
        int minimumBid = getMinimumBid(plant);
        if (!getAuctioneer().canAfford(minimumBid)) {
            log(getAuctioneer().getName() + " cannot afford the minimum bid for #" + plant.getNumber() + ".");
            return;
        }
        auctionActivePlayerIds.clear();
        for (Player player : turnOrder) {
            if (!boughtThisAuctionPhase.contains(player.getId())
                    && !optedOutAuctionPhase.contains(player.getId())) {
                auctionActivePlayerIds.add(player.getId());
            }
        }
        auctioneer = getAuctioneer();
        highBidder = auctioneer;
        currentBid = minimumBid;
        minBid = currentBid;
        currentBidderOrderIndex = nextBidderIndexAfter(indexOfPlayer(auctioneer));
        phase = GamePhase.AUCTION_BID;
        log(auctioneer.getName() + " starts #" + plant.getNumber() + " at " + currentBid + " Elektro.");
        if (auctionActivePlayerIds.size() == 1) {
            awardAuction();
        }
    }

    public int getMinimumBid(PowerPlant plant) {
        if (discountActive && plant.getNumber() == discountPlantNumber) {
            return 1;
        }
        return plant.getNumber();
    }

    public void raiseBid(int increment) {
        if (phase != GamePhase.AUCTION_BID) {
            return;
        }
        Player bidder = getCurrentBidder();
        if (bidder == null) {
            return;
        }
        int newBid = currentBid + increment;
        if (!bidder.canAfford(newBid)) {
            log(bidder.getName() + " cannot afford " + newBid + ".");
            return;
        }
        highBidder = bidder;
        currentBid = newBid;
        minBid = currentBid;
        log(bidder.getName() + " bids " + currentBid + " on #" + auctionPlant.getNumber() + ".");
        currentBidderOrderIndex = nextBidderIndexAfter(currentBidderOrderIndex);
    }

    public void passBid() {
        if (phase != GamePhase.AUCTION_BID) {
            return;
        }
        Player bidder = getCurrentBidder();
        if (bidder == null || bidder == highBidder) {
            return;
        }
        auctionActivePlayerIds.remove(bidder.getId());
        log(bidder.getName() + " passes.");
        if (auctionActivePlayerIds.size() <= 1) {
            awardAuction();
        } else {
            currentBidderOrderIndex = nextBidderIndexAfter(currentBidderOrderIndex);
        }
    }

    private void awardAuction() {
        if (highBidder == null || auctionPlant == null) {
            return;
        }
        highBidder.buyPowerPlant(auctionPlant, currentBid);
        boughtThisAuctionPhase.add(highBidder.getId());
        if (auctionPlant.getNumber() == 39) {
            uraniumRefillAllowed = false;
        }
        plantMarket.remove(auctionPlant);
        if (discountActive && auctionPlant.getNumber() == discountPlantNumber) {
            discountActive = false;
            discountPlantNumber = -1;
        }
        log(highBidder.getName() + " buys #" + auctionPlant.getNumber() + " for " + currentBid + ".");
        drawReplacementIntoMarket();
        sortMarket();
        syncLegacyPowerPlants();

        Player originalAuctioneer = auctioneer;
        auctionPlant = null;
        highBidder = null;
        auctionActivePlayerIds.clear();
        currentBid = 0;

        if (allPlayersAuctionFinished()) {
            finishAuctionPhase();
            return;
        }
        if (originalAuctioneer != null
                && !boughtThisAuctionPhase.contains(originalAuctioneer.getId())
                && !optedOutAuctionPhase.contains(originalAuctioneer.getId())) {
            auctioneer = originalAuctioneer;
            phase = GamePhase.AUCTION_SELECT;
            return;
        }
        auctioneerOrderIndex = Math.max(auctioneerOrderIndex + 1, indexOfPlayer(originalAuctioneer) + 1);
        selectNextAuctioneer();
    }

    private boolean allPlayersAuctionFinished() {
        for (Player player : turnOrder) {
            if (!boughtThisAuctionPhase.contains(player.getId())
                    && !optedOutAuctionPhase.contains(player.getId())) {
                return false;
            }
        }
        return true;
    }

    private void finishAuctionPhase() {
        if (discountActive) {
            PowerPlant discounted = findMarketPlant(discountPlantNumber);
            if (discounted != null && plantMarket.remove(discounted)) {
                log("The discounted #" + discounted.getNumber() + " was unsold and leaves the market.");
                drawReplacementIntoMarket();
                sortMarket();
            }
            discountActive = false;
            discountPlantNumber = -1;
        }
        if (firstAuctionRound) {
            firstAuctionRound = false;
            determinePlayerOrder();
        }
        if (stepThreePending) {
            startStepThree();
        }
        beginResourcePhase();
    }

    private void beginResourcePhase() {
        reverseTurnOrder.clear();
        reverseTurnOrder.addAll(turnOrder);
        Collections.reverse(reverseTurnOrder);
        phaseTurnIndex = 0;
        phase = GamePhase.RESOURCE_BUY;
        updateCurrentPlayerFromPhaseOrder(reverseTurnOrder);
        log("Buy resources in reverse player order.");
    }

    public void buyResource(Resource resource) {
        if (phase != GamePhase.RESOURCE_BUY) {
            return;
        }
        Player player = getCurrentPhasePlayer();
        int price = resourceMarket.getCheapestPrice(resource);
        if (player == null || price < 0) {
            return;
        }
        if (!player.canStore(resource)) {
            log(player.getName() + " has no storage for " + resource.getLabel() + ".");
            return;
        }
        if (!player.canAfford(price)) {
            log(player.getName() + " cannot afford " + resource.getLabel() + ".");
            return;
        }
        int paid = resourceMarket.buy(resource);
        if (paid >= 0 && player.storeResource(resource)) {
            player.spend(paid);
            log(player.getName() + " buys 1 " + resource.getLabel() + " for " + paid + ".");
        }
    }

    public void finishResourceTurn() {
        if (phase != GamePhase.RESOURCE_BUY) {
            return;
        }
        phaseTurnIndex++;
        if (phaseTurnIndex >= reverseTurnOrder.size()) {
            beginBuildPhase();
        } else {
            updateCurrentPlayerFromPhaseOrder(reverseTurnOrder);
        }
    }

    private void beginBuildPhase() {
        phaseTurnIndex = 0;
        phase = GamePhase.BUILD;
        updateCurrentPlayerFromPhaseOrder(reverseTurnOrder);
        log("Build houses in reverse player order.");
    }

    public void buildCity(CityNode city) {
        if (phase != GamePhase.BUILD || city == null) {
            return;
        }
        Player player = getCurrentPhasePlayer();
        if (player == null) {
            return;
        }
        if (!city.canBuild(player, step)) {
            log("That city has no available space for " + player.getName() + " in Step " + step + ".");
            return;
        }
        int connectionCost = cityGraph.cheapestConnectionCost(player, city);
        int totalCost = city.getBuildCost() + connectionCost;
        if (!player.canAfford(totalCost)) {
            log(player.getName() + " needs " + totalCost + " Elektro for " + city.getName() + ".");
            return;
        }
        player.spend(totalCost);
        player.addCity(city);
        city.addOccupant(player);
        log(player.getName() + " builds in " + city.getName() + " for " + totalCost + ".");
        if (player.getNumHouses() >= getStepTwoThreshold() && step == 1) {
            stepTwoPending = true;
        }
        if (player.getNumHouses() >= getGameEndThreshold()) {
            finalBureaucracy = true;
            log("Game end has been triggered; finish this build phase.");
        }
    }

    public void finishBuildTurn() {
        if (phase != GamePhase.BUILD) {
            return;
        }
        phaseTurnIndex++;
        if (phaseTurnIndex >= reverseTurnOrder.size()) {
            beginBureaucracyPhase();
        } else {
            updateCurrentPlayerFromPhaseOrder(reverseTurnOrder);
        }
    }

    private void beginBureaucracyPhase() {
        phase = GamePhase.BUREAUCRACY;
        phaseTurnIndex = 0;
        updateCurrentPlayerFromPhaseOrder(turnOrder);
        if (finalBureaucracy) {
            log("Final bureaucracy: compare how many cities each player can power.");
        } else {
            if (stepTwoPending && step < 2) {
                startStepTwo();
            }
            log("Bureaucracy begins: power cities and collect income.");
        }
    }

    public void runBureaucracyForCurrentPlayer() {
        if (phase != GamePhase.BUREAUCRACY) {
            return;
        }
        if (finalBureaucracy) {
            calculateWinner();
            phase = GamePhase.GAME_OVER;
            return;
        }
        Player player = getCurrentPhasePlayer();
        if (player == null) {
            return;
        }
        int poweredCities = player.autoPowerCities(resourceMarket);
        int payment = getPayment(poweredCities);
        player.earn(payment);
        log(player.getName() + " powers " + poweredCities + " cities and earns " + payment + ".");
        phaseTurnIndex++;
        if (phaseTurnIndex >= turnOrder.size()) {
            finishBureaucracyPhase();
        } else {
            updateCurrentPlayerFromPhaseOrder(turnOrder);
        }
    }

    private void finishBureaucracyPhase() {
        resourceMarket.refill(playerCount, step, uraniumRefillAllowed);
        log("Resource market refilled for Step " + step + ".");
        updatePowerPlantMarketAfterBureaucracy();
        if (stepThreePending) {
            startStepThree();
        }
        round++;
        determinePlayerOrder();
        beginAuctionPhase();
    }

    private void startStepTwo() {
        step = 2;
        currentStep = step;
        stepTwoPending = false;
        removeLowestMarketPlant();
        drawReplacementIntoMarket();
        sortMarket();
        log("Step 2 begins. Cities now allow second houses.");
    }

    private void startStepThree() {
        if (step < 2) {
            startStepTwo();
        }
        step = 3;
        currentStep = step;
        stepThreePending = false;
        removeLowestMarketPlant();
        while (plantMarket.size() > 6) {
            removeHighestMarketPlantToBottom();
        }
        if (!plantsUnderStepThree.isEmpty()) {
            plantDeck.addAll(plantsUnderStepThree);
            plantsUnderStepThree.clear();
            Collections.shuffle(plantDeck);
        }
        sortMarket();
        syncLegacyPowerPlants();
        log("Step 3 begins. All six market plants are available and cities allow third houses.");
    }

    private void updatePowerPlantMarketAfterBureaucracy() {
        if (step >= 3) {
            removeLowestMarketPlant();
            drawReplacementIntoMarket();
        } else {
            removeHighestMarketPlantToBottom();
            drawReplacementIntoMarket();
        }
        sortMarket();
        syncLegacyPowerPlants();
    }

    private void removeLowestMarketPlant() {
        sortMarket();
        if (!plantMarket.isEmpty()) {
            PowerPlant removed = plantMarket.remove(0);
            log("Power plant #" + removed.getNumber() + " leaves the market.");
        }
    }

    private void removeHighestMarketPlantToBottom() {
        sortMarket();
        if (!plantMarket.isEmpty()) {
            PowerPlant removed = plantMarket.remove(plantMarket.size() - 1);
            plantsUnderStepThree.add(removed);
            log("Power plant #" + removed.getNumber() + " is set below the Step 3 stack.");
        }
    }

    private void drawReplacementIntoMarket() {
        PowerPlant drawn = drawPlant();
        if (drawn != null) {
            plantMarket.add(drawn);
        }
        sortMarket();
        syncLegacyPowerPlants();
    }

    private PowerPlant drawPlant() {
        while (!plantDeck.isEmpty()) {
            PowerPlant drawn = plantDeck.remove(0);
            if (drawn.isStepThreeCard()) {
                stepThreePending = true;
                if (!plantsUnderStepThree.isEmpty()) {
                    plantDeck.addAll(plantsUnderStepThree);
                    plantsUnderStepThree.clear();
                    Collections.shuffle(plantDeck);
                }
                log("The Step 3 card was drawn; Step 3 will start after this phase.");
                return null;
            }
            return drawn;
        }
        return null;
    }

    private void sortMarket() {
        plantMarket.sort(Comparator.comparingInt(PowerPlant::getNumber));
    }

    private void calculateWinner() {
        Player winner = null;
        int bestPowered = -1;
        for (Player player : activePlayers) {
            int powered = player.calculateSupplyableCities();
            if (winner == null
                    || powered > bestPowered
                    || powered == bestPowered && player.getElektro() > winner.getElektro()) {
                winner = player;
                bestPowered = powered;
            }
        }
        if (winner == null) {
            winnerText = "No winner could be determined.";
        } else {
            winnerText = winner.getName() + " wins by powering " + bestPowered
                    + " cities with " + winner.getElektro() + " Elektro remaining.";
        }
        log(winnerText);
    }

    private int getPayment(int poweredCities) {
        int index = Math.max(0, Math.min(poweredCities, PAYMENTS.length - 1));
        return PAYMENTS[index];
    }

    private int getStepTwoThreshold() {
        return playerCount == 6 ? 6 : 7;
    }

    private int getGameEndThreshold() {
        if (playerCount == 3 || playerCount == 4) {
            return 17;
        }
        if (playerCount == 5) {
            return 15;
        }
        if (playerCount >= 6) {
            return 14;
        }
        return 18;
    }

    private Player getAuctioneer() {
        return auctioneer;
    }

    private int indexOfPlayer(Player player) {
        if (player == null) {
            return -1;
        }
        for (int i = 0; i < turnOrder.size(); i++) {
            if (turnOrder.get(i).getId() == player.getId()) {
                return i;
            }
        }
        return -1;
    }

    private int nextBidderIndexAfter(int index) {
        if (turnOrder.isEmpty()) {
            return -1;
        }
        int start = index;
        int next = index;
        do {
            next = (next + 1 + turnOrder.size()) % turnOrder.size();
            Player candidate = turnOrder.get(next);
            if (auctionActivePlayerIds.contains(candidate.getId()) && candidate != highBidder) {
                currentPlayerIndex = candidate.getId() - 1;
                return next;
            }
        } while (next != start);
        return indexOfPlayer(highBidder);
    }

    public Player getCurrentBidder() {
        if (phase != GamePhase.AUCTION_BID || currentBidderOrderIndex < 0 || turnOrder.isEmpty()) {
            return null;
        }
        Player candidate = turnOrder.get(currentBidderOrderIndex);
        if (auctionActivePlayerIds.contains(candidate.getId()) && candidate != highBidder) {
            currentPlayerIndex = candidate.getId() - 1;
            return candidate;
        }
        currentBidderOrderIndex = nextBidderIndexAfter(currentBidderOrderIndex);
        if (currentBidderOrderIndex >= 0) {
            return turnOrder.get(currentBidderOrderIndex);
        }
        return null;
    }

    private Player getCurrentPhasePlayer() {
        if (phase == GamePhase.RESOURCE_BUY || phase == GamePhase.BUILD) {
            if (phaseTurnIndex >= 0 && phaseTurnIndex < reverseTurnOrder.size()) {
                return reverseTurnOrder.get(phaseTurnIndex);
            }
        }
        if (phase == GamePhase.BUREAUCRACY) {
            if (phaseTurnIndex >= 0 && phaseTurnIndex < turnOrder.size()) {
                return turnOrder.get(phaseTurnIndex);
            }
        }
        return null;
    }

    private void updateCurrentPlayerFromPhaseOrder(List<Player> order) {
        if (phaseTurnIndex >= 0 && phaseTurnIndex < order.size()) {
            currentPlayerIndex = order.get(phaseTurnIndex).getId() - 1;
        }
    }

    private PowerPlant findMarketPlant(int number) {
        for (PowerPlant plant : plantMarket) {
            if (plant.getNumber() == number) {
                return plant;
            }
        }
        return null;
    }

    private void log(String message) {
        log.addFirst(message);
        while (log.size() > 10) {
            log.removeLast();
        }
    }

    private void syncLegacyPlayerOrder() {
        for (int i = 0; i < playerOrder.length; i++) {
            playerOrder[i] = i < turnOrder.size() ? turnOrder.get(i).getId() : i + 1;
        }
    }

    private void syncLegacyPowerPlants() {
        powerPlantsInMarket.clear();
        powerPlantsInMarket.addAll(plantMarket);
        powerPlantDeck.clear();
        powerPlantDeck.addAll(plantDeck);
    }

    public void setUpDeckAndMarket() {
        setupPowerPlants();
    }

    public void setUpAuction() {
        beginAuctionPhase();
    }

    public void continueAuction() {
    }

    public GamePhase getPhase() {
        return phase;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getRound() {
        return round;
    }

    public int getStep() {
        return step;
    }

    public CityGraph getCityGraph() {
        return cityGraph;
    }

    public ResourceMarket getResourceMarket() {
        return resourceMarket;
    }

    public ArrayList<Player> getActivePlayers() {
        return activePlayers;
    }

    public ArrayList<Player> getTurnOrder() {
        return turnOrder;
    }

    public List<PowerPlant> getPlantMarket() {
        return plantMarket;
    }

    public List<PowerPlant> getCurrentMarket() {
        int currentSize = step >= 3 ? Math.min(6, plantMarket.size()) : Math.min(4, plantMarket.size());
        return new ArrayList<>(plantMarket.subList(0, currentSize));
    }

    public List<PowerPlant> getFutureMarket() {
        if (step >= 3 || plantMarket.size() <= 4) {
            return new ArrayList<>();
        }
        return new ArrayList<>(plantMarket.subList(4, plantMarket.size()));
    }

    public LinkedList<String> getLog() {
        return log;
    }

    public Player getCurrentActor() {
        if (phase == GamePhase.AUCTION_SELECT) {
            return auctioneer;
        }
        if (phase == GamePhase.AUCTION_BID) {
            return getCurrentBidder();
        }
        return getCurrentPhasePlayer();
    }

    public PowerPlant getAuctionPlant() {
        return auctionPlant;
    }

    public Player getHighBidder() {
        return highBidder;
    }

    public int getCurrentBid() {
        return currentBid;
    }

    public int getDiscountPlantNumber() {
        return discountPlantNumber;
    }

    public boolean isDiscountActive() {
        return discountActive;
    }

    public boolean isFirstAuctionRound() {
        return firstAuctionRound;
    }

    public int getGameEndThresholdForDisplay() {
        return getGameEndThreshold();
    }

    public String getWinnerText() {
        return winnerText;
    }

    public EnumMap<Resource, Integer> getRefillPreview() {
        return new EnumMap<>(ResourceMarket.refillAmounts(playerCount, step));
    }
}
