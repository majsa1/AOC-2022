package org.example.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3Group {
    private final List<String> rucksackContents;
    private Character commonItem;
    private int value;

    public Day3Group() {
        this.rucksackContents = new ArrayList<>();
    }

    public void addToRucksackContents(String contents) {
        this.rucksackContents.add(contents);
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

    public void findCommonItem() {
        List<String> first = new ArrayList<>(Arrays.asList(rucksackContents.get(0).split("")));
        List<String> second = new ArrayList<>(Arrays.asList(rucksackContents.get(1).split("")));
        List<String> third = new ArrayList<>(Arrays.asList(rucksackContents.get(2).split("")));

        for (String f : first) {
            for (String s : second) {
                if (f.equals(s)) {
                    for (String t : third) {
                        if (f.equals(t)) {
                            commonItem = f.charAt(0);
                            break;
                        }
                    }
                }
            }
        }
    }
}
