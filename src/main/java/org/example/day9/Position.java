package org.example.day9;

import java.util.*;

public class Position {
    private int x;
    private int y;

    private static final List<Position> visited = new ArrayList<>();

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void addToVisited(Position position) {
        visited.add(position);
    }

    public static int getNumberOfVisited() {
        Set<Position> visitedSet = new HashSet<>(visited);
        return visitedSet.size();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position(" + x + "," + y + ")";
    }
}
