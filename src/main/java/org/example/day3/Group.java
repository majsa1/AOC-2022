package org.example.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
    private final List<String> rucksackContents;
    private String commonItem;
    private int value;

    public Group() {
        this.rucksackContents = new ArrayList<>();
    }

    public void addToRucksackContents(String contents) {
        this.rucksackContents.add(contents);
    }

    public int getCommonItemValueByASCII() {
        if (commonItem == null) {
            return 0;
        }
        char character = commonItem.charAt(0);
        if (Character.isLowerCase(character)) {
            value = character - 96;
        }
        if (Character.isUpperCase(character)) {
            value = character - 64 + 26;
        }
        return value;
    }

    public void findCommonItem() {
        List<String> first = new ArrayList<>(Arrays.asList(rucksackContents.get(0).split("")));
        List<String> second = new ArrayList<>(Arrays.asList(rucksackContents.get(1).split("")));
        List<String> third = new ArrayList<>(Arrays.asList(rucksackContents.get(2).split("")));

        boolean firstRetained = first.retainAll(second);
        boolean secondRetained = first.retainAll(third);

        if (firstRetained && secondRetained && !first.isEmpty()) {
            commonItem = first.get(0);
        }
    }
}
