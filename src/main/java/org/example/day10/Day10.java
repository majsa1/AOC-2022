package org.example.day10;

import java.util.ArrayList;
import java.util.List;

public class Day10 {
    private final List<Instruction> instructions = new ArrayList<>();
    private final List<Cycle> cycles = new ArrayList<>();
    private int value = 1;

    public int getAllStrengths(List<Integer> numbers) {
        return getAllStrengths(numbers, input);
    }

    public int getAllStrengths(List<Integer> numbers, String input) {
        getCycles(input);

        int sum = 0;
        for (Integer number : numbers) {
            Cycle cycle = cycles.get(number - 1);
            sum += cycle.getSignalStrength();
        }
        return sum;
    }

    private void getCycles(String input) {
        parseInput(input);

        for (Instruction instruction : instructions) {
            for (int i = 0; i < instruction.getCyclesToCompletion(); i++) {
                cycles.add(new Cycle(cycles.size() + 1, value));
                if (i == instruction.getCyclesToCompletion() - 1) {
                    value += instruction.getRegister();
                }
            }
        }
    }

    private void parseInput(String input) {
        Instruction instruction;
        for (String line : input.lines().toList()) {
            try {
                String[] lines = line.split("\s");
                instruction = new Instruction(Integer.parseInt(lines[1].trim()));
            } catch (Exception e) {
                instruction = new Instruction();
            }
            instructions.add(instruction);
        }
    }

    private static String input =
            """
                    addx 1
                    addx 4
                    noop
                    noop
                    addx 30
                    addx -24
                    addx -1
                    noop
                    addx 4
                    addx 1
                    addx 5
                    addx -4
                    addx 5
                    addx 4
                    addx 1
                    noop
                    addx 5
                    addx -1
                    addx 5
                    addx 3
                    noop
                    addx -38
                    addx 9
                    addx -4
                    noop
                    addx 3
                    noop
                    addx 2
                    addx 3
                    noop
                    addx 2
                    addx 3
                    noop
                    addx 2
                    addx 3
                    noop
                    addx 2
                    addx -17
                    addx 22
                    addx -2
                    addx 5
                    addx 2
                    addx 3
                    addx -2
                    addx -36
                    noop
                    addx 5
                    noop
                    addx 3
                    noop
                    addx 2
                    addx -5
                    noop
                    addx 10
                    addx 3
                    addx -2
                    addx 3
                    addx 2
                    addx 4
                    noop
                    noop
                    noop
                    noop
                    addx 3
                    noop
                    noop
                    addx 7
                    addx 1
                    noop
                    noop
                    addx -38
                    addx 39
                    addx -32
                    noop
                    noop
                    noop
                    addx 5
                    addx 2
                    addx -1
                    addx 4
                    noop
                    addx 5
                    addx -2
                    addx 5
                    addx 2
                    addx -26
                    addx 31
                    addx -2
                    addx 4
                    addx 3
                    addx -18
                    addx 19
                    addx -38
                    addx 7
                    noop
                    noop
                    addx 34
                    addx -39
                    addx 8
                    addx 5
                    addx 2
                    addx 10
                    addx -5
                    addx -2
                    addx 5
                    addx 2
                    addx 11
                    addx -6
                    noop
                    addx 3
                    noop
                    addx 2
                    addx 3
                    addx -2
                    addx -38
                    noop
                    noop
                    noop
                    addx 5
                    addx 11
                    noop
                    addx -3
                    noop
                    noop
                    noop
                    addx 2
                    noop
                    addx -11
                    addx 16
                    noop
                    addx 3
                    addx 2
                    addx 8
                    noop
                    noop
                    noop
                    noop
                    noop
                    addx 4
                    addx 3
                    noop
                    addx -20
                    noop
                    """;
}
