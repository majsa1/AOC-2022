package org.example;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileDayOne = "src/main/resources/day1.txt";
        Day1 day1 = new Day1(inputFileDayOne);
        System.out.println(day1.getMostCalories());
        System.out.println(day1.getTopThreeCalories());
    }
}