package org.example.day4;

import java.util.HashSet;
import java.util.List;

public class Ranges {
    private final List<Integer> rangeOne;
    private final List<Integer> rangeTwo;

    public Ranges(List<Integer> rangeOne, List<Integer> rangeTwo) {
        this.rangeOne = rangeOne;
        this.rangeTwo = rangeTwo;
    }

    public boolean fullyContains() {
        return new HashSet<>(rangeOne).containsAll(rangeTwo) || new HashSet<>(rangeTwo).containsAll(rangeOne);
    }
}
