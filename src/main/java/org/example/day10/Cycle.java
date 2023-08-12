package org.example.day10;

public class Cycle {
    private final int numberOfCycle;
    private final int value;

    public Cycle(int numberOfCycle, int value) {
        this.numberOfCycle = numberOfCycle;
        this.value = value;
    }

    public int getSignalStrength() {
        return numberOfCycle * value;
    }
}

