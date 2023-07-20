package org.example.days;

import org.example.utils.FileReader;
import org.example.utils.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 implements FileReader {
    private final List<Integer> allCalories;
    private int totalCalories;

    public Day1(String fileName) throws IOException {
        allCalories = new ArrayList<>();
        Utilities.getDataFromFile(this, fileName);
    }

    @Override
    public void read(String data) {
        addTotalCaloriesToList(data);
    }

    public int getMostCalories() {
        return allCalories.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0);
    }

    public int getTopThreeCalories() {
        return allCalories.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void addTotalCaloriesToList(String input) {
        if (!input.isBlank()) {
            totalCalories += Integer.parseInt(input);
        } else {
            allCalories.add(totalCalories);
            totalCalories = 0;
        }
    }
}
