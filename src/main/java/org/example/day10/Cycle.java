package org.example.day10;

public class Cycle {
    private final int numberOfCycle;
    private final int value;
    private Instruction instruction;

    public Cycle(int numberOfCycle, int value) {
        this.numberOfCycle = numberOfCycle;
        this.value = value;
        this.instruction = null;
    }

    public int getSignalStrength() {
        return numberOfCycle * value;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
}

