package org.example.day9;

public enum Direction {
    LEFT("L"),
    RIGHT("R"),
    UP("U"),
    DOWN("D");

    public final String label;

    Direction(String label) {
        this.label = label;
    }

    public static Direction ofLabel(String label){
        for(Direction direction : Direction.values()) {
            if (direction.label.equals(label)){
                return direction;
            }
        }
        return null;
    }
}
