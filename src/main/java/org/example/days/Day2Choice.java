package org.example.days;

public class Day2Choice {
    private final String myChoice;
    private final String opponentsChoice;

    public Day2Choice(String myChoice, String opponentsChoice) {
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
        if (isDraw()) {
            return getMyPoints() + 3;
        } else if (isWin()) {
            return getMyPoints() + 6;
        } else {
            return getMyPoints();
        }
    }

    private boolean isDraw() {
        return getMyPoints() == getOpponentsPoints();
    }

    private boolean isWin() {
        return getMyPoints() == getOpponentsPoints() + 1 || getMyPoints() == 1 && getOpponentsPoints() == 3;
    }
}
