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
        String[] parts = data.split(",");
        List<Integer> first = getList(parts[0].split("-"));
        List<Integer> second = getList(parts[1].split("-"));

        Pair pair = new Pair(first, second);
        if (pair.overlaps()) {
            counter++;
        }
    }

    public int getCount() {
        return counter;
    }

    private List<Integer> getList(String[] parts) {
        List<Integer> list = new ArrayList<>();
        for (int i = Integer.parseInt(parts[0]); i <= Integer.parseInt(parts[1]); i++) {
            list.add(i);
        }
        return list;
    }
}
