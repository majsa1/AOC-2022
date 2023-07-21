package org.example.day4;

import org.example.utils.FileReader;
import org.example.utils.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 implements FileReader {
    private int counter = 0;

    public Day4(String fileName) throws IOException {
        Utilities.getDataFromFile(this, fileName);
    }

    @Override
    public void read(String data) {
        Ranges ranges;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        String[] parts = data.split(",");
        String[] firstPart = parts[0].split("-");
        for (int i = Integer.parseInt(firstPart[0]); i <= Integer.parseInt(firstPart[1]); i++) {
            first.add(i);
        }
        String[] secondPart = parts[1].split("-");
        for (int i = Integer.parseInt(secondPart[0]); i <= Integer.parseInt(secondPart[1]); i++) {
            second.add(i);
        }
        ranges = new Ranges(first, second);

        if (ranges.fullyContains()) {
            counter++;
        }
    }

    public int getCount() {
        return counter;
    }
}
