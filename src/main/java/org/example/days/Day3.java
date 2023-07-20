package org.example.days;

import org.example.utils.FileReader;
import org.example.utils.Utilities;

import java.io.IOException;

public class Day3 implements FileReader {
    private int totalScore;

    public Day3(String fileName) throws IOException {
        Utilities.getDataFromFile(this, fileName);
    }

    @Override
    public void read(String data) {
        String firstPart = data.substring(0, data.length() / 2);
        String secondPart = data.substring(data.length() / 2);
        Day3Part day3Part = new Day3Part(firstPart, secondPart);
        totalScore += day3Part.getValueByASCII();
    }

    public int getTotalScore() {
        return totalScore;
    }
}
