package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    private final List<Day2Result> resultList;

    public Day2(String fileName) throws IOException {
        resultList = new ArrayList<>();
        getArrayFromFile(fileName);
    }

    private void getArrayFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                resultList.add(new Day2Result(input.substring(2,3), input.substring(0,1)));
            }
        }
    }

    public int getMyScores() {
        int total = 0;
        for (Day2Result result : resultList) {
            total += result.getMyScore();
        }
        return total;
    }
}

