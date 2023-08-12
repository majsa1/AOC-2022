package org.example.day10;

public class Instruction {
    private final int register;
    private final int cyclesToCompletion;

    public Instruction() {
        this.register = 0;
        this.cyclesToCompletion = 1;
    }

    public Instruction(int register) {
        this.register = register;
        this.cyclesToCompletion = 2;
    }

    public int getRegister() {
        return register;
    }

    public int getCyclesToCompletion() {
        return cyclesToCompletion;
    }
}
