package org.example.day3;

import org.example.utils.FileReader;
import org.example.utils.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 implements FileReader {
    private int totalScore;
    private final List<String> lines;
    private final List<Group> groups;

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
        for (Group group : groups) {
            group.findCommonItem();
            totalScore += group.getCommonItemValueByASCII();
        }
        return totalScore;
    }

    private void getCompartmentContents(String data) {
        String compartmentOne = data.substring(0, data.length() / 2);
        String compartmentTwo = data.substring(data.length() / 2);
        Rucksack rucksack = new Rucksack(compartmentOne, compartmentTwo);
        totalScore += rucksack.getCommonItemValueByASCII();
    }

    private void getRucksackContents(String data) {
        lines.add(data);
    }

    private void getGroups() {
        Group group = new Group();
        for (int i = 0; i < lines.size(); i++) {
            if (i != 0 && i % 3 == 0) {
                groups.add(group);
                group = new Group();
            }
            group.addToRucksackContents(lines.get(i));
        }
        groups.add(group);
    }
}
