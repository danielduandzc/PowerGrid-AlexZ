package src;

public enum GamePhase {
    TITLE("Title"),
    SETUP("Setup"),
    AUCTION_SELECT("Auction: choose plant"),
    AUCTION_BID("Auction: bidding"),
    RESOURCE_BUY("Buy resources"),
    BUILD("Build houses"),
    BUREAUCRACY("Bureaucracy"),
    GAME_OVER("Game over");

    private final String label;

    GamePhase(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
