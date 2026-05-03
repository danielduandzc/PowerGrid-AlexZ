package src;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class InitialPanel extends JPanel implements KeyListener, MouseListener {
    private static final Color BACKGROUND = new Color(238, 241, 236);
    private static final Color PANEL = new Color(255, 255, 250);
    private static final Color INK = new Color(32, 38, 42);
    private static final Color MUTED = new Color(96, 105, 111);
    private static final Color LINE = new Color(197, 204, 200);
    private static final Color BUTTON = new Color(40, 91, 118);
    private static final Color BUTTON_HOVER = new Color(52, 116, 150);
    private static final Font UI_FONT = new Font("SansSerif", Font.PLAIN, 15);
    private static final Font UI_BOLD = new Font("SansSerif", Font.BOLD, 15);
    private static final Font UI_TITLE = new Font("SansSerif", Font.BOLD, 30);
    private static final int BOARD_COORD_WIDTH = 2920;
    private static final int BOARD_COORD_HEIGHT = 3698;

    private final GameState gameState;
    private final ArrayList<UiButton> buttons;
    private final Map<Integer, BufferedImage> plantImages;
    private BufferedImage titleScreen;
    private BufferedImage boardImage;
    private Rectangle lastMapViewport = new Rectangle();
    private int mouseX = -1;
    private int mouseY = -1;

    public InitialPanel() {
        gameState = new GameState();
        GameState.initialPanel = this;
        buttons = new ArrayList<>();
        plantImages = new HashMap<>();
        setPreferredSize(new Dimension(1600, 900));
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        loadImages();
    }

    private void loadImages() {
        titleScreen = loadImage("Powergrid.png");
        boardImage = loadImage("Cropped Board.png");
        int[] plantNumbers = {
                3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                37, 38, 39, 40, 42, 44, 46, 50
        };
        for (int number : plantNumbers) {
            BufferedImage image = loadImage(number + ".jpeg");
            if (image == null) {
                image = loadImage(number + ".png");
            }
            if (image != null) {
                plantImages.put(number, image);
            }
        }
    }

    private BufferedImage loadImage(String name) {
        try {
            File file = new File("resources", name);
            if (file.exists()) {
                return ImageIO.read(file);
            }
            java.io.InputStream stream = PowerGridFrame.class.getResourceAsStream("/resources/" + name);
            if (stream != null) {
                return ImageIO.read(stream);
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        buttons.clear();

        g.setColor(BACKGROUND);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (gameState.getPhase() == GamePhase.TITLE) {
            drawTitle(g);
        } else if (gameState.getPhase() == GamePhase.SETUP) {
            drawSetup(g);
        } else {
            drawGame(g);
        }
        drawButtons(g);
    }

    private void drawTitle(Graphics2D g) {
        if (titleScreen != null) {
            g.drawImage(titleScreen, 0, 0, getWidth(), getHeight(), this);
            g.setColor(new Color(255, 255, 255, 210));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        g.setColor(INK);
        g.setFont(new Font("SansSerif", Font.BOLD, 54));
        centerText(g, "Power Grid", 0, getHeight() / 2 - 110, getWidth(), 70);
        g.setFont(UI_TITLE);
        centerText(g, "Recharged hot-seat Java edition", 0, getHeight() / 2 - 45, getWidth(), 40);
        addButton("Play", getWidth() / 2 - 90, getHeight() / 2 + 35, 180, 52, new Runnable() {
            @Override
            public void run() {
                gameState.showSetup();
            }
        });
    }

    private void drawSetup(Graphics2D g) {
        drawCard(g, getWidth() / 2 - 260, 160, 520, 360);
        g.setColor(INK);
        g.setFont(UI_TITLE);
        centerText(g, "Setup", getWidth() / 2 - 260, 190, 520, 45);
        g.setFont(UI_FONT);
        centerText(g, "Germany map, auction market, resources, building, bureaucracy", getWidth() / 2 - 260, 250, 520, 28);
        centerText(g, "Players", getWidth() / 2 - 260, 304, 520, 24);

        int selected = gameState.getPlayerCount();
        addToggleButton("3 Players", getWidth() / 2 - 160, 350, 140, 46, selected == 3, new Runnable() {
            @Override
            public void run() {
                gameState.setPlayerCount(3);
            }
        });
        addToggleButton("4 Players", getWidth() / 2 + 20, 350, 140, 46, selected == 4, new Runnable() {
            @Override
            public void run() {
                gameState.setPlayerCount(4);
            }
        });
        addButton("Start Game", getWidth() / 2 - 110, 440, 220, 52, new Runnable() {
            @Override
            public void run() {
                gameState.startNewGame();
            }
        });
    }

    private void drawGame(Graphics2D g) {
        drawHeader(g);
        drawPlayers(g, 18, 86, 318, getHeight() - 104);
        drawRightPanel(g, getWidth() - 352, 86, 334, getHeight() - 104);

        int centerX = 360;
        int centerY = 86;
        int centerW = getWidth() - 730;
        int centerH = getHeight() - 104;
        drawCard(g, centerX, centerY, centerW, centerH);

        switch (gameState.getPhase()) {
            case AUCTION_SELECT:
            case AUCTION_BID:
                drawAuction(g, centerX, centerY, centerW, centerH);
                break;
            case RESOURCE_BUY:
                drawResourceBuying(g, centerX, centerY, centerW, centerH);
                break;
            case BUILD:
                drawBuild(g, centerX, centerY, centerW, centerH);
                break;
            case BUREAUCRACY:
                drawBureaucracy(g, centerX, centerY, centerW, centerH);
                break;
            case GAME_OVER:
                drawGameOver(g, centerX, centerY, centerW, centerH);
                break;
            default:
                break;
        }
    }

    private void drawHeader(Graphics2D g) {
        g.setColor(new Color(25, 42, 52));
        g.fillRect(0, 0, getWidth(), 68);
        g.setColor(Color.WHITE);
        g.setFont(UI_TITLE);
        g.drawString("Power Grid", 24, 43);
        g.setFont(UI_BOLD);
        String status = "Round " + gameState.getRound() + "   Step " + gameState.getStep()
                + "   " + gameState.getPhase().getLabel()
                + "   End at " + gameState.getGameEndThresholdForDisplay() + " cities";
        g.drawString(status, 260, 42);
        Player actor = gameState.getCurrentActor();
        if (actor != null) {
            drawPlayerPip(g, actor, getWidth() - 260, 20, 22);
            g.drawString(actor.getName(), getWidth() - 230, 42);
        }
    }

    private void drawPlayers(Graphics2D g, int x, int y, int w, int h) {
        drawCard(g, x, y, w, h);
        g.setFont(UI_TITLE.deriveFont(22f));
        g.setColor(INK);
        g.drawString("Players", x + 18, y + 34);
        int rowY = y + 56;
        for (Player player : gameState.getActivePlayers()) {
            int rowH = 148;
            g.setColor(new Color(247, 248, 244));
            g.fillRoundRect(x + 12, rowY, w - 24, rowH - 10, 8, 8);
            drawPlayerPip(g, player, x + 24, rowY + 15, 18);
            g.setColor(INK);
            g.setFont(UI_BOLD);
            g.drawString(player.getName(), x + 50, rowY + 30);
            g.setFont(UI_FONT);
            g.drawString(player.getElektro() + " Elektro", x + 50, rowY + 55);
            g.drawString(player.getNumHouses() + " cities", x + 160, rowY + 55);

            int plantY = rowY + 82;
            if (player.getPowerPlants().isEmpty()) {
                g.setColor(MUTED);
                g.drawString("No plants yet", x + 24, plantY);
            } else {
                for (PowerPlant plant : player.getPowerPlants()) {
                    g.setColor(INK);
                    g.drawString("#" + plant.getNumber() + "  " + plant.getFuelSummary()
                            + "  " + plant.getStorageSummary(), x + 24, plantY);
                    plantY += 18;
                }
            }
            rowY += rowH;
        }
    }

    private void drawRightPanel(Graphics2D g, int x, int y, int w, int h) {
        drawCard(g, x, y, w, h);
        g.setColor(INK);
        g.setFont(UI_TITLE.deriveFont(22f));
        g.drawString("Market", x + 18, y + 34);
        int yy = y + 64;
        g.setFont(UI_FONT);
        for (Resource resource : Resource.values()) {
            g.setColor(resource.getColor());
            g.fillRoundRect(x + 18, yy - 13, 18, 18, 4, 4);
            g.setColor(INK);
            int price = gameState.getResourceMarket().getCheapestPrice(resource);
            String priceLabel = price < 0 ? "empty" : "$" + price;
            g.drawString(resource.getLabel() + "  " + priceLabel
                    + "  market " + gameState.getResourceMarket().countInMarket(resource)
                    + "  supply " + gameState.getResourceMarket().getSupplyCount(resource),
                    x + 44, yy + 2);
            g.setColor(MUTED);
            drawClippedString(g, gameState.getResourceMarket().getTrackSummary(resource),
                    x + 44, yy + 22, w - 64);
            yy += 52;
        }

        yy += 12;
        g.setColor(INK);
        g.setFont(UI_TITLE.deriveFont(22f));
        g.drawString("Turn Order", x + 18, yy);
        yy += 26;
        g.setFont(UI_FONT);
        int order = 1;
        for (Player player : gameState.getTurnOrder()) {
            drawPlayerPip(g, player, x + 18, yy - 14, 14);
            g.setColor(INK);
            g.drawString(order + ". " + player.getName(), x + 42, yy);
            yy += 24;
            order++;
        }

        yy += 12;
        g.setColor(INK);
        g.setFont(UI_TITLE.deriveFont(22f));
        g.drawString("Log", x + 18, yy);
        yy += 26;
        g.setFont(UI_FONT);
        for (String message : gameState.getLog()) {
            drawWrappedLine(g, message, x + 18, yy, w - 36);
            yy += 38;
            if (yy > y + h - 20) {
                break;
            }
        }
    }

    private void drawAuction(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(INK);
        g.setFont(UI_TITLE);
        g.drawString("Power Plant Auction", x + 24, y + 42);
        Player actor = gameState.getCurrentActor();
        if (actor != null) {
            g.setFont(UI_BOLD);
            g.drawString(actor.getName() + " to act", x + 24, y + 72);
        }
        drawPowerPlantMarket(g, x + 22, y + 96, w - 44, gameState.getPhase() == GamePhase.AUCTION_SELECT);

        int controlsY = y + h - 170;
        drawCard(g, x + 22, controlsY, w - 44, 130);
        if (gameState.getPhase() == GamePhase.AUCTION_SELECT) {
            g.setColor(INK);
            g.setFont(UI_BOLD);
            g.drawString("Choose a current-market plant.", x + 42, controlsY + 36);
            if (!gameState.isFirstAuctionRound()) {
                addButton("Pass Auction", x + 42, controlsY + 62, 150, 42, new Runnable() {
                    @Override
                    public void run() {
                        gameState.passAuction();
                    }
                });
            }
        } else {
            PowerPlant plant = gameState.getAuctionPlant();
            Player highBidder = gameState.getHighBidder();
            Player currentBidder = gameState.getCurrentBidder();
            g.setColor(INK);
            g.setFont(UI_BOLD);
            if (plant != null) {
                g.drawString("Auctioning #" + plant.getNumber() + "     Current bid: "
                        + gameState.getCurrentBid(), x + 42, controlsY + 34);
            }
            g.setFont(UI_FONT);
            if (highBidder != null) {
                g.drawString("High bidder: " + highBidder.getName(), x + 42, controlsY + 62);
            }
            if (currentBidder != null) {
                g.drawString("Current bidder: " + currentBidder.getName(), x + 240, controlsY + 62);
            }
            addButton("Bid +1", x + 42, controlsY + 80, 105, 38, new Runnable() {
                @Override
                public void run() {
                    gameState.raiseBid(1);
                }
            });
            addButton("Bid +5", x + 158, controlsY + 80, 105, 38, new Runnable() {
                @Override
                public void run() {
                    gameState.raiseBid(5);
                }
            });
            addButton("Pass", x + 274, controlsY + 80, 105, 38, new Runnable() {
                @Override
                public void run() {
                    gameState.passBid();
                }
            });
        }
    }

    private void drawPowerPlantMarket(Graphics2D g, int x, int y, int w, boolean clickable) {
        List<PowerPlant> market = gameState.getPlantMarket();
        int cardW = Math.max(84, Math.min(132, (w - 70) / 4));
        int cardH = (int) (cardW * 1.18);
        int gap = 18;
        for (int i = 0; i < market.size(); i++) {
            int row = i / 4;
            int col = i % 4;
            int cx = x + col * (cardW + gap);
            int cy = y + row * (cardH + 42);
            PowerPlant plant = market.get(i);
            boolean current = gameState.getCurrentMarket().contains(plant);
            drawPlantCard(g, plant, cx, cy, cardW, cardH, current);
            if (clickable && current) {
                final PowerPlant selectedPlant = plant;
                addClickArea(cx - 4, cy - 4, cardW + 8, cardH + 8, new Runnable() {
                    @Override
                    public void run() {
                        gameState.startAuction(selectedPlant);
                    }
                });
                addButton("Auction #" + plant.getNumber(), cx, cy + cardH + 6, cardW, 30, new Runnable() {
                    @Override
                    public void run() {
                        gameState.startAuction(selectedPlant);
                    }
                });
            } else {
                g.setColor(current ? INK : MUTED);
                g.setFont(UI_FONT);
                centerText(g, current ? "Current" : "Future", cx, cy + cardH + 8, cardW, 20);
            }
        }
    }

    private void drawPlantCard(Graphics2D g, PowerPlant plant, int x, int y, int w, int h, boolean current) {
        g.setColor(current ? new Color(250, 250, 244) : new Color(232, 235, 232));
        g.fillRoundRect(x - 4, y - 4, w + 8, h + 8, 10, 10);
        g.setColor(current ? new Color(85, 119, 89) : LINE);
        g.setStroke(new BasicStroke(current ? 3 : 1));
        g.drawRoundRect(x - 4, y - 4, w + 8, h + 8, 10, 10);
        BufferedImage image = plantImages.get(plant.getNumber());
        if (image != null) {
            g.drawImage(image, x, y, w, h, this);
        } else {
            g.setColor(new Color(220, 224, 220));
            g.fillRoundRect(x, y, w, h, 8, 8);
            g.setColor(INK);
            g.setFont(UI_TITLE);
            centerText(g, "#" + plant.getNumber(), x, y + h / 2 - 18, w, 36);
        }
        g.setColor(new Color(255, 255, 255, 230));
        g.fillRoundRect(x + 6, y + 6, 76, 42, 8, 8);
        g.setColor(INK);
        g.setFont(UI_BOLD);
        g.drawString("#" + plant.getNumber(), x + 14, y + 24);
        g.setFont(UI_FONT.deriveFont(12f));
        g.drawString(plant.getCitiesPowered() + " cities", x + 14, y + 41);
        if (gameState.isDiscountActive() && plant.getNumber() == gameState.getDiscountPlantNumber()) {
            g.setColor(new Color(226, 184, 45));
            g.fillRoundRect(x + w - 55, y + 7, 46, 24, 8, 8);
            g.setColor(INK);
            g.setFont(UI_BOLD.deriveFont(12f));
            centerText(g, "$1", x + w - 55, y + 10, 46, 18);
        }
    }

    private void drawResourceBuying(Graphics2D g, int x, int y, int w, int h) {
        Player actor = gameState.getCurrentActor();
        g.setColor(INK);
        g.setFont(UI_TITLE);
        g.drawString("Buy Resources", x + 24, y + 42);
        if (actor != null) {
            g.setFont(UI_BOLD);
            g.drawString(actor.getName() + " has " + actor.getElektro() + " Elektro", x + 24, y + 72);
        }
        drawOwnedPlants(g, actor, x + 24, y + 108, w - 48, 170);

        int buttonY = y + 320;
        int bx = x + 24;
        for (final Resource resource : Resource.values()) {
            int price = gameState.getResourceMarket().getCheapestPrice(resource);
            String label = price < 0 ? resource.getLabel() + " empty" : "Buy " + resource.getLabel() + " $" + price;
            addButton(label, bx, buttonY, 168, 42, new Runnable() {
                @Override
                public void run() {
                    gameState.buyResource(resource);
                }
            });
            bx += 180;
        }
        addButton("Done", x + 24, buttonY + 72, 120, 42, new Runnable() {
            @Override
            public void run() {
                gameState.finishResourceTurn();
            }
        });
    }

    private void drawOwnedPlants(Graphics2D g, Player player, int x, int y, int w, int h) {
        drawCard(g, x, y, w, h);
        if (player == null) {
            return;
        }
        g.setFont(UI_BOLD);
        g.setColor(INK);
        g.drawString(player.getName() + "'s plants", x + 16, y + 28);
        int yy = y + 58;
        g.setFont(UI_FONT);
        for (PowerPlant plant : player.getPowerPlants()) {
            g.drawString("#" + plant.getNumber() + "   " + plant.getFuelSummary()
                    + "   Storage " + plant.getStorageSummary()
                    + "   Powers " + plant.getCitiesPowered(), x + 18, yy);
            yy += 28;
        }
    }

    private void drawBuild(Graphics2D g, int x, int y, int w, int h) {
        Player actor = gameState.getCurrentActor();
        g.setColor(INK);
        g.setFont(UI_TITLE);
        g.drawString("Build Houses", x + 24, y + 42);
        if (actor != null) {
            g.setFont(UI_BOLD);
            g.drawString(actor.getName() + " has " + actor.getElektro() + " Elektro", x + 24, y + 72);
        }
        addButton("Done", x + w - 150, y + 24, 110, 38, new Runnable() {
            @Override
            public void run() {
                gameState.finishBuildTurn();
            }
        });
        drawMap(g, x + 22, y + 92, w - 44, h - 118);
    }

    private void drawMap(Graphics2D g, int x, int y, int w, int h) {
        Rectangle viewport = calculateBoardViewport(x, y, w, h);
        lastMapViewport = viewport;
        g.setColor(new Color(229, 233, 226));
        g.fillRoundRect(x, y, w, h, 8, 8);
        if (boardImage != null) {
            g.drawImage(boardImage, viewport.x, viewport.y, viewport.width, viewport.height, this);
            g.setColor(new Color(255, 255, 255, 185));
            g.fillRect(viewport.x, viewport.y, viewport.width, viewport.height);
        } else {
            g.setColor(new Color(240, 243, 237));
            g.fillRoundRect(viewport.x, viewport.y, viewport.width, viewport.height, 8, 8);
        }
        g.setStroke(new BasicStroke(2f));
        for (Edge edge : gameState.getCityGraph().getEdges()) {
            int ax = mapX(edge.getANode(), viewport);
            int ay = mapY(edge.getANode(), viewport);
            int bx = mapX(edge.getBNode(), viewport);
            int by = mapY(edge.getBNode(), viewport);
            g.setColor(new Color(118, 127, 125, 150));
            g.drawLine(ax, ay, bx, by);
            g.setColor(new Color(255, 255, 250, 220));
            g.fillRoundRect((ax + bx) / 2 - 11, (ay + by) / 2 - 9, 22, 18, 8, 8);
            g.setColor(MUTED);
            g.setFont(UI_FONT.deriveFont(11f));
            centerText(g, String.valueOf(edge.getCost()), (ax + bx) / 2 - 11, (ay + by) / 2 - 8, 22, 14);
        }
        for (CityNode city : gameState.getCityGraph().getNodes()) {
            drawCity(g, city, viewport);
        }
    }

    private Rectangle calculateBoardViewport(int x, int y, int w, int h) {
        double boardAspect = BOARD_COORD_WIDTH / (double) BOARD_COORD_HEIGHT;
        double areaAspect = w / (double) h;
        int drawW;
        int drawH;
        if (areaAspect > boardAspect) {
            drawH = h;
            drawW = (int) Math.round(drawH * boardAspect);
        } else {
            drawW = w;
            drawH = (int) Math.round(drawW / boardAspect);
        }
        int drawX = x + (w - drawW) / 2;
        int drawY = y + (h - drawH) / 2;
        return new Rectangle(drawX, drawY, drawW, drawH);
    }

    private void drawCity(Graphics2D g, CityNode city, Rectangle viewport) {
        int cx = mapX(city, viewport);
        int cy = mapY(city, viewport);
        int radius = Math.max(7, Math.min(12, viewport.width / 75));
        g.setColor(city.getZonePaint());
        g.fillOval(cx - radius, cy - radius, radius * 2, radius * 2);
        g.setColor(INK);
        g.setStroke(new BasicStroke(2f));
        g.drawOval(cx - radius, cy - radius, radius * 2, radius * 2);
        int markerX = cx - 18;
        for (Integer playerId : city.getOccupantIds()) {
            Player player = findPlayer(playerId);
            if (player != null) {
                g.setColor(player.getPlayerColor());
                g.fillRect(markerX, cy + 14, 10, 10);
                g.setColor(INK);
                g.drawRect(markerX, cy + 14, 10, 10);
                markerX += 13;
            }
        }
        g.setColor(INK);
        g.setFont(UI_FONT.deriveFont(10f));
        centerText(g, city.getName(), cx - 42, cy - radius - 20, 84, 14);
    }

    private int mapX(CityNode city, Rectangle viewport) {
        return viewport.x + (int) Math.round(city.getX() / (double) BOARD_COORD_WIDTH * viewport.width);
    }

    private int mapY(CityNode city, Rectangle viewport) {
        return viewport.y + (int) Math.round(city.getY() / (double) BOARD_COORD_HEIGHT * viewport.height);
    }

    private CityNode findCityAt(int px, int py) {
        Rectangle viewport = lastMapViewport;
        if (viewport == null || viewport.width <= 0 || viewport.height <= 0) {
            return null;
        }
        for (CityNode city : gameState.getCityGraph().getNodes()) {
            int cx = mapX(city, viewport);
            int cy = mapY(city, viewport);
            int dx = px - cx;
            int dy = py - cy;
            if (dx * dx + dy * dy <= 16 * 16) {
                return city;
            }
        }
        return null;
    }

    private Player findPlayer(int id) {
        for (Player player : gameState.getActivePlayers()) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    private void drawBureaucracy(Graphics2D g, int x, int y, int w, int h) {
        Player actor = gameState.getCurrentActor();
        g.setColor(INK);
        g.setFont(UI_TITLE);
        g.drawString("Bureaucracy", x + 24, y + 42);
        if (actor != null) {
            g.setFont(UI_BOLD);
            g.drawString(actor.getName() + " can currently power "
                    + actor.calculateSupplyableCities() + " cities.", x + 24, y + 76);
            drawOwnedPlants(g, actor, x + 24, y + 108, w - 48, 190);
        }
        String label = gameState.getWinnerText().isEmpty() ? "Power / Collect" : "Score Game";
        addButton(label, x + 24, y + 330, 170, 44, new Runnable() {
            @Override
            public void run() {
                gameState.runBureaucracyForCurrentPlayer();
            }
        });
    }

    private void drawGameOver(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(INK);
        g.setFont(UI_TITLE);
        centerText(g, "Game Over", x, y + 150, w, 50);
        g.setFont(UI_TITLE.deriveFont(22f));
        centerText(g, gameState.getWinnerText(), x + 40, y + 230, w - 80, 40);
        addButton("New Game", x + w / 2 - 80, y + 310, 160, 46, new Runnable() {
            @Override
            public void run() {
                gameState.showSetup();
            }
        });
    }

    private void drawCard(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(PANEL);
        g.fill(new RoundRectangle2D.Double(x, y, w, h, 10, 10));
        g.setColor(LINE);
        g.setStroke(new BasicStroke(1.2f));
        g.draw(new RoundRectangle2D.Double(x, y, w, h, 10, 10));
    }

    private void drawPlayerPip(Graphics2D g, Player player, int x, int y, int size) {
        g.setColor(player.getPlayerColor());
        g.fillOval(x, y, size, size);
        g.setColor(INK);
        g.setStroke(new BasicStroke(1.5f));
        g.drawOval(x, y, size, size);
    }

    private void addButton(String label, int x, int y, int w, int h, Runnable action) {
        buttons.add(new UiButton(label, x, y, w, h, false, true, action));
    }

    private void addToggleButton(String label, int x, int y, int w, int h, boolean selected, Runnable action) {
        buttons.add(new UiButton(label, x, y, w, h, selected, true, action));
    }

    private void addClickArea(int x, int y, int w, int h, Runnable action) {
        buttons.add(new UiButton("", x, y, w, h, false, false, action));
    }

    private void drawButtons(Graphics2D g) {
        for (UiButton button : buttons) {
            if (!button.visible) {
                continue;
            }
            boolean hover = button.contains(mouseX, mouseY);
            g.setColor(button.selected ? new Color(73, 135, 87) : hover ? BUTTON_HOVER : BUTTON);
            g.fillRoundRect(button.x, button.y, button.w, button.h, 8, 8);
            g.setColor(new Color(16, 43, 56));
            g.drawRoundRect(button.x, button.y, button.w, button.h, 8, 8);
            g.setColor(Color.WHITE);
            g.setFont(UI_BOLD);
            centerText(g, button.label, button.x + 6, button.y, button.w - 12, button.h);
        }
    }

    private void centerText(Graphics2D g, String text, int x, int y, int w, int h) {
        FontMetrics metrics = g.getFontMetrics();
        int textWidth = metrics.stringWidth(text);
        int drawX = x + (w - textWidth) / 2;
        int drawY = y + (h - metrics.getHeight()) / 2 + metrics.getAscent();
        g.drawString(text, drawX, drawY);
    }

    private void drawClippedString(Graphics2D g, String text, int x, int y, int maxWidth) {
        FontMetrics metrics = g.getFontMetrics();
        String clipped = text;
        while (metrics.stringWidth(clipped) > maxWidth && clipped.length() > 4) {
            clipped = clipped.substring(0, clipped.length() - 4) + "...";
        }
        g.drawString(clipped, x, y);
    }

    private void drawWrappedLine(Graphics2D g, String text, int x, int y, int maxWidth) {
        FontMetrics metrics = g.getFontMetrics();
        if (metrics.stringWidth(text) <= maxWidth) {
            g.drawString(text, x, y);
            return;
        }
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();
        int drawY = y;
        for (String word : words) {
            String next = line.length() == 0 ? word : line + " " + word;
            if (metrics.stringWidth(next) > maxWidth) {
                g.drawString(line.toString(), x, drawY);
                drawY += 16;
                line = new StringBuilder(word);
            } else {
                line = new StringBuilder(next);
            }
        }
        if (line.length() > 0) {
            g.drawString(line.toString(), x, drawY);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        mouseX = event.getX();
        mouseY = event.getY();
        for (UiButton button : new ArrayList<>(buttons)) {
            if (button.contains(mouseX, mouseY)) {
                button.action.run();
                repaint();
                return;
            }
        }
        if (gameState.getPhase() == GamePhase.BUILD) {
            CityNode city = findCityAt(mouseX, mouseY);
            if (city != null) {
                gameState.buildCity(city);
                repaint();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
    }

    @Override
    public void mouseReleased(MouseEvent event) {
    }

    @Override
    public void mouseEntered(MouseEvent event) {
    }

    @Override
    public void mouseExited(MouseEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_R) {
            gameState.showSetup();
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    private static class UiButton {
        private final String label;
        private final int x;
        private final int y;
        private final int w;
        private final int h;
        private final boolean selected;
        private final boolean visible;
        private final Runnable action;

        UiButton(String label, int x, int y, int w, int h, boolean selected, boolean visible, Runnable action) {
            this.label = label;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.selected = selected;
            this.visible = visible;
            this.action = action;
        }

        boolean contains(int px, int py) {
            return px >= x && px <= x + w && py >= y && py <= y + h;
        }
    }
}
