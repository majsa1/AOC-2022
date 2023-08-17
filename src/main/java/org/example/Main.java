package org.example;

import org.example.day1.Day1;
import org.example.day10.Day10;
import org.example.day11.Day11;
import org.example.day2.Day2;
import org.example.day3.Day3;
import org.example.day4.Day4;
import org.example.day5.Day5;
import org.example.day6.Day6;
import org.example.day7.Day7;
import org.example.day8.Day8;
import org.example.day9.Day9;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileDayOne = "src/main/resources/day1.txt";
        Day1 day1 = new Day1(inputFileDayOne);
        System.out.println(day1.getMostCalories());
        System.out.println(day1.getTopThreeCalories());

        String inputFileDayTwo = "src/main/resources/day2.txt";
        Day2 day2 = new Day2(inputFileDayTwo);
        System.out.println(day2.getMyScores());

        String inputFileDayThree = "src/main/resources/day3.txt";
        Day3 day3 = new Day3(inputFileDayThree);
        System.out.println(day3.getGroupScore());

        String inputFileDayFour = "src/main/resources/day4.txt";
        Day4 day4 = new Day4(inputFileDayFour);
        System.out.println(day4.getCount());

        Day5 day5 = new Day5();
        System.out.println(day5.getMessage());

        Day6 day6 = new Day6();
        System.out.println(day6.getMarker());

        Day7 day7 = new Day7();
        System.out.println(day7.getResultPartOne());
        System.out.println(day7.getResultPartTwo());

        Day8 day8 = new Day8();
        System.out.println(day8.getNumberOfVisibleTrees());
        System.out.println(day8.getHighestScenicScore());

        Day9 day9 = new Day9(10);
        day9.visualize(day9.getVisited());
        System.out.println(day9.getNumberOfVisitedPositions());

        Day10 day10 = new Day10();
        System.out.println(day10.getAllStrengths(Arrays.asList(20, 60, 100, 140, 180, 220)));
        System.out.println(day10.moveSprite());

        Day11 day11 = new Day11(20);
        System.out.println(day11.doMonkeyBusiness());
    }
}