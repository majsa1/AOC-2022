package org.example.day9;

import java.util.*;

import static org.example.day9.Direction.*;
import static org.example.day9.Direction.DOWN;

public class Position {
    private int x;
    private int y;
    private String name;
    private static List<Position> visited = new ArrayList<>();

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(String name, int x, int y) {
        this(x, y);
        this.name = name;
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

    public String getName() {
        return name;
    }

    public static List<Position> getVisited() {
        return visited;
    }

    public static void addToVisited(Position position) {
        visited.add(position);
    }

    public static void clearVisited() {
        visited = new ArrayList<>();
    }

    public static int getNumberOfVisited() {
        Set<Position> visitedSet = new HashSet<>(visited);
        return visitedSet.size();
    }

    public void move(Direction direction) {
        if (direction.equals(RIGHT)) {
            this.x++;
        }
        if (direction.equals(LEFT)) {
            this.x--;
        }
        if (direction.equals(UP)) {
            this.y++;
        }
        if (direction.equals(DOWN)) {
            this.y--;
        }
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
        return "Position " + name + ": (" + x + "," + y + ")";
    }
}
