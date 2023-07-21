package org.example.days;

import org.example.utils.FileReader;
import org.example.utils.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 implements FileReader {
    private int totalScore;
    private final List<String> lines;
    private final List<Day3Group> groups;

    public Day3(String fileName) throws IOException {
        lines = new ArrayList<>();
        groups = new ArrayList<>();
        Utilities.getDataFromFile(this, fileName);
        getGroups();
    }

    @Override
    public void read(String data) {
        getRucksackContents(data);
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getGroupScore() {
        for (Day3Group day3Group : groups) {
            day3Group.findCommonItem();
            totalScore += day3Group.getCommonItemValueByASCII();
        }
        return totalScore;
    }

    private void getCompartmentContents(String data) {
        String compartmentOne = data.substring(0, data.length() / 2);
        String compartmentTwo = data.substring(data.length() / 2);
        Day3Rucksack day3Rucksack = new Day3Rucksack(compartmentOne, compartmentTwo);
        totalScore += day3Rucksack.getCommonItemValueByASCII();
    }

    private void getRucksackContents(String data) {
        lines.add(data);
    }

    private void getGroups() {
        Day3Group group = new Day3Group();
        for (int i = 0; i < lines.size(); i++) {
            if (i != 0 && i % 3 == 0) {
                groups.add(group);
                group = new Day3Group();
            }
            group.addToRucksackContents(lines.get(i));
        }
        groups.add(group);
    }
}
