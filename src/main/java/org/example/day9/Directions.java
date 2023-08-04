package org.example.day9;

public enum Directions {
    LEFT("L"),
    RIGHT("R"),
    UP("U"),
    DOWN("D");

    public final String label;

    Directions(String label) {
        this.label = label;
    }
}
