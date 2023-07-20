package org.example;

public class Day2Result {
    private final String myChoice;
    private final String opponentsChoice;

    public Day2Result(String myChoice, String opponentsChoice) {
        this.myChoice = myChoice;
        this.opponentsChoice = opponentsChoice;
    }

    public int getMyPoints() {
        return switch (myChoice) {
            case "X" -> getOpponentsPoints() - 1 == 0 ? 3 : getOpponentsPoints() - 1;
            case "Y" -> getOpponentsPoints();
            case "Z" -> getOpponentsPoints() + 1 == 4 ? 1 : getOpponentsPoints() + 1;
            default -> 0;
        };
    }

    public int getOpponentsPoints() {
        return switch (opponentsChoice) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            default -> 0;
        };
    }

    public int getMyScore() {
        if (getMyPoints() == getOpponentsPoints()) {
            return getMyPoints() + 3;
        } else if (getMyPoints() == getOpponentsPoints() + 1) {
            return getMyPoints() + 6;
        } else if (getMyPoints() == 1 && getOpponentsPoints() == 3) {
            return getMyPoints() + 6;
        } else {
            return getMyPoints();
        }
    }
}
