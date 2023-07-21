package org.example.days;

import java.util.*;

public class Day3Rucksack {
    private final String firstPart;
    private final String secondPart;
    private Character commonItem;
    private int value;

    public Day3Rucksack(String firstPart, String secondPart) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
        findCommonItem();
    }

    public int getCommonItemValueByASCII() {
        if (Character.isLowerCase(commonItem)) {
            value = commonItem - 96;
        }
        if (Character.isUpperCase(commonItem)) {
            value = commonItem - 64 + 26;
        }
        return value;
    }

    private void findCommonItem() {
        List<String> first = new ArrayList<>(Arrays.asList(firstPart.split("")));
        List<String> second = new ArrayList<>(Arrays.asList(secondPart.split("")));
        for (String f : first) {
            for (String s : second) {
                if (f.equals(s)) {
                    commonItem = f.charAt(0);
                    break;
                }
            }
        }
    }
}
