package org.example;

import org.example.days.Day1;
import org.example.days.Day2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileDayOne = "src/main/resources/day1.txt";
        Day1 day1 = new Day1(inputFileDayOne);
        System.out.println(day1.getMostCalories());
        System.out.println(day1.getTopThreeCalories());

        String inputFileDayTwo = "src/main/resources/day2.txt";
        Day2 day2 = new Day2(inputFileDayTwo);
        System.out.println(day2.getMyScores());
    }
}