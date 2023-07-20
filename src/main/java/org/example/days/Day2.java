package org.example.days;

import org.example.utils.FileReader;
import org.example.utils.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 implements FileReader {

    private final List<Day2Choice> choices;

    public Day2(String fileName) throws IOException {
        choices = new ArrayList<>();
        Utilities.getDataFromFile(this, fileName);
    }

    @Override
    public void read(String data) {
        choices.add(new Day2Choice(data.substring(2,3), data.substring(0,1)));
    }

    public int getMyScores() {
        int totalScore = 0;
        for (Day2Choice choice : choices) {
            totalScore += choice.getMyScore();
        }
        return totalScore;
    }
}

