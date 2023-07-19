package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {
    private final List<Integer> allCalories;
    private int totalCalories;

    public Day1(String fileName) throws IOException {
        allCalories = new ArrayList<>();
        getArrayFromFile(fileName);
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

    private void getArrayFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                addTotalCaloriesToList(input);
            }
        }
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
