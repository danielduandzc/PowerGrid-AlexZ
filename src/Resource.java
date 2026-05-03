package src;

import java.awt.Color;

public enum Resource {
    COAL("Coal", new Color(105, 72, 44)),
    OIL("Oil", new Color(34, 38, 43)),
    GARBAGE("Garbage", new Color(214, 174, 35)),
    URANIUM("Uranium", new Color(174, 48, 66));

    private final String label;
    private final Color color;

    Resource(String label, Color color) {
        this.label = label;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public Color getColor() {
        return color;
    }
}
