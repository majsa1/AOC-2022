package org.example.day5;

import java.util.*;

public class Day5 {

    private Map<Integer, Deque<String>> stacks;
    private List<List<String>> moves;

    public Day5() {
        createStacks();
        getMoves();
        move();
    }

    private void createStacks() {
        stacks = new HashMap<>();
        String crates = """
                [T]     [D]         [L]           \s
                [R]     [S] [G]     [P]         [H]
                [G]     [H] [W]     [R] [L]     [P]
                [W]     [G] [F] [H] [S] [M]     [L]
                [Q]     [V] [B] [J] [H] [N] [R] [N]
                [M] [R] [R] [P] [M] [T] [H] [Q] [C]
                [F] [F] [Z] [H] [S] [Z] [T] [D] [S]
                [P] [H] [P] [Q] [P] [M] [P] [F] [D]
                 1   2   3   4   5   6   7   8   9\s
                """;
        List<String> lines = new ArrayList<>(crates.lines().toList());
        Collections.reverse(lines);
        String firstLine = lines.get(0).trim();
        int lastIndex = firstLine.length() - 1;
        int amountOfStacks = Integer.parseInt(firstLine.substring(lastIndex));

        for (int i = 0; i < amountOfStacks; i++) {
            Deque<String> stack = new ArrayDeque<>();
            stacks.put(i + 1, stack);
            for (int j = 1; j < lines.size(); j++) {
                String[] items = lines.get(j).split("(?=(.{4})+$)");
                List<String> rows = new ArrayList<>(Arrays.stream(items).toList());
                if (!rows.get(i).isBlank()) {
                    stack.push(rows.get(i).trim());
                }
            }
        }
    }

    public void getMoves() {
        moves = new ArrayList<>();
        String procedure = """
                move 3 from 8 to 9
                move 2 from 2 to 8
                move 5 from 4 to 2
                move 7 from 1 to 4
                move 3 from 8 to 2
                move 3 from 2 to 7
                move 1 from 7 to 4
                move 3 from 2 to 9
                move 4 from 7 to 9
                move 1 from 5 to 2
                move 2 from 3 to 4
                move 5 from 9 to 5
                move 6 from 9 to 3
                move 5 from 9 to 5
                move 1 from 9 to 7
                move 2 from 3 to 1
                move 7 from 3 to 9
                move 2 from 7 to 2
                move 5 from 2 to 4
                move 1 from 2 to 9
                move 2 from 1 to 9
                move 7 from 6 to 1
                move 2 from 7 to 3
                move 2 from 3 to 9
                move 1 from 7 to 4
                move 1 from 9 to 2
                move 3 from 1 to 8
                move 2 from 3 to 4
                move 5 from 9 to 2
                move 1 from 3 to 9
                move 8 from 5 to 7
                move 1 from 6 to 1
                move 15 from 4 to 1
                move 4 from 2 to 5
                move 5 from 9 to 7
                move 1 from 9 to 5
                move 5 from 1 to 2
                move 3 from 8 to 9
                move 1 from 7 to 6
                move 11 from 1 to 2
                move 7 from 5 to 3
                move 4 from 2 to 6
                move 7 from 3 to 4
                move 3 from 5 to 9
                move 2 from 2 to 5
                move 5 from 1 to 8
                move 2 from 6 to 8
                move 3 from 8 to 9
                move 9 from 4 to 9
                move 9 from 7 to 4
                move 2 from 8 to 1
                move 1 from 8 to 7
                move 6 from 2 to 7
                move 5 from 2 to 4
                move 5 from 7 to 2
                move 2 from 1 to 7
                move 2 from 6 to 4
                move 7 from 7 to 1
                move 3 from 2 to 6
                move 1 from 8 to 7
                move 2 from 9 to 3
                move 2 from 3 to 1
                move 1 from 2 to 5
                move 4 from 6 to 5
                move 2 from 2 to 3
                move 3 from 5 to 7
                move 1 from 5 to 3
                move 9 from 1 to 7
                move 2 from 9 to 5
                move 13 from 4 to 1
                move 5 from 7 to 2
                move 3 from 3 to 1
                move 2 from 2 to 9
                move 1 from 2 to 7
                move 5 from 5 to 6
                move 2 from 2 to 4
                move 5 from 1 to 3
                move 9 from 7 to 8
                move 2 from 9 to 5
                move 3 from 5 to 4
                move 5 from 9 to 2
                move 10 from 4 to 8
                move 1 from 4 to 1
                move 2 from 8 to 4
                move 4 from 8 to 2
                move 3 from 6 to 8
                move 7 from 8 to 7
                move 10 from 9 to 3
                move 7 from 3 to 2
                move 11 from 2 to 3
                move 13 from 3 to 9
                move 1 from 6 to 3
                move 1 from 1 to 2
                move 1 from 2 to 8
                move 3 from 3 to 4
                move 1 from 2 to 9
                move 1 from 4 to 1
                move 10 from 8 to 3
                move 11 from 9 to 7
                move 1 from 6 to 2
                move 14 from 7 to 1
                move 2 from 2 to 9
                move 4 from 7 to 6
                move 1 from 2 to 4
                move 3 from 4 to 2
                move 4 from 2 to 9
                move 10 from 3 to 4
                move 3 from 6 to 1
                move 5 from 9 to 5
                move 5 from 5 to 8
                move 1 from 9 to 7
                move 2 from 9 to 6
                move 1 from 9 to 8
                move 2 from 4 to 8
                move 1 from 4 to 5
                move 2 from 3 to 1
                move 2 from 3 to 7
                move 27 from 1 to 2
                move 2 from 7 to 1
                move 9 from 4 to 6
                move 9 from 6 to 5
                move 5 from 8 to 6
                move 26 from 2 to 3
                move 1 from 2 to 5
                move 1 from 2 to 7
                move 1 from 8 to 4
                move 1 from 7 to 8
                move 24 from 3 to 5
                move 1 from 8 to 5
                move 1 from 4 to 3
                move 1 from 7 to 1
                move 1 from 8 to 9
                move 7 from 1 to 7
                move 8 from 6 to 4
                move 4 from 7 to 6
                move 1 from 3 to 9
                move 2 from 9 to 1
                move 3 from 7 to 9
                move 8 from 4 to 6
                move 3 from 9 to 1
                move 1 from 3 to 6
                move 1 from 8 to 2
                move 10 from 5 to 4
                move 1 from 3 to 8
                move 13 from 5 to 3
                move 1 from 2 to 9
                move 1 from 8 to 9
                move 1 from 3 to 8
                move 1 from 9 to 2
                move 3 from 6 to 9
                move 7 from 4 to 9
                move 4 from 3 to 9
                move 2 from 6 to 8
                move 2 from 4 to 5
                move 10 from 9 to 3
                move 1 from 1 to 9
                move 1 from 4 to 8
                move 1 from 1 to 4
                move 1 from 4 to 5
                move 4 from 6 to 3
                move 1 from 9 to 5
                move 1 from 6 to 9
                move 2 from 6 to 5
                move 1 from 9 to 2
                move 1 from 6 to 7
                move 18 from 5 to 2
                move 22 from 3 to 7
                move 19 from 7 to 1
                move 3 from 8 to 5
                move 4 from 9 to 3
                move 2 from 7 to 2
                move 1 from 8 to 1
                move 19 from 1 to 3
                move 2 from 7 to 5
                move 13 from 3 to 9
                move 4 from 1 to 2
                move 3 from 5 to 1
                move 11 from 9 to 1
                move 11 from 2 to 8
                move 3 from 9 to 3
                move 3 from 5 to 2
                move 2 from 1 to 4
                move 5 from 2 to 7
                move 12 from 1 to 5
                move 2 from 4 to 5
                move 9 from 5 to 8
                move 1 from 5 to 3
                move 4 from 2 to 3
                move 2 from 7 to 5
                move 6 from 2 to 8
                move 17 from 8 to 9
                move 2 from 9 to 6
                move 2 from 7 to 1
                move 15 from 9 to 6
                move 2 from 2 to 4
                move 9 from 8 to 5
                move 2 from 1 to 3
                move 12 from 6 to 2
                move 2 from 3 to 9
                move 5 from 6 to 3
                move 4 from 5 to 3
                move 11 from 3 to 4
                move 2 from 9 to 4
                move 6 from 5 to 2
                move 13 from 4 to 3
                move 1 from 4 to 5
                move 1 from 4 to 8
                move 18 from 2 to 6
                move 2 from 5 to 3
                move 1 from 8 to 3
                move 1 from 2 to 5
                move 1 from 7 to 8
                move 28 from 3 to 6
                move 2 from 3 to 4
                move 3 from 5 to 9
                move 2 from 5 to 9
                move 3 from 9 to 3
                move 5 from 3 to 4
                move 1 from 9 to 3
                move 1 from 9 to 1
                move 1 from 3 to 4
                move 45 from 6 to 2
                move 1 from 8 to 3
                move 2 from 4 to 6
                move 5 from 4 to 2
                move 1 from 3 to 7
                move 3 from 2 to 9
                move 1 from 4 to 8
                move 3 from 6 to 1
                move 42 from 2 to 8
                move 2 from 9 to 2
                move 4 from 2 to 6
                move 2 from 2 to 7
                move 1 from 9 to 6
                move 2 from 8 to 9
                move 4 from 1 to 8
                move 1 from 6 to 4
                move 1 from 4 to 8
                move 1 from 2 to 5
                move 3 from 7 to 4
                move 39 from 8 to 3
                move 7 from 8 to 5
                move 8 from 5 to 7
                move 35 from 3 to 1
                move 4 from 3 to 7
                move 10 from 7 to 2
                move 2 from 9 to 6
                move 3 from 4 to 2
                move 1 from 7 to 5
                move 1 from 7 to 8
                move 1 from 5 to 4
                move 12 from 1 to 6
                move 1 from 8 to 1
                move 1 from 4 to 5
                move 14 from 6 to 8
                move 9 from 8 to 6
                move 5 from 6 to 1
                move 11 from 2 to 9
                move 1 from 9 to 8
                move 6 from 8 to 3
                move 6 from 9 to 2
                move 8 from 1 to 9
                move 3 from 3 to 6
                move 7 from 1 to 4
                move 1 from 5 to 9
                move 8 from 9 to 8
                move 7 from 6 to 8
                move 1 from 9 to 3
                move 3 from 6 to 4
                move 3 from 9 to 1
                move 4 from 3 to 2
                move 1 from 6 to 7
                move 1 from 4 to 2
                move 13 from 1 to 7
                move 6 from 4 to 8
                move 1 from 7 to 3
                move 1 from 4 to 6
                move 1 from 9 to 5
                move 1 from 3 to 5
                move 19 from 8 to 9
                move 1 from 6 to 5
                move 6 from 9 to 2
                move 2 from 5 to 8
                move 1 from 5 to 2
                move 4 from 1 to 4
                move 8 from 9 to 4
                move 3 from 9 to 8
                move 2 from 9 to 1
                move 6 from 7 to 5
                move 12 from 4 to 2
                move 6 from 8 to 3
                move 1 from 4 to 1
                move 1 from 3 to 1
                move 13 from 2 to 3
                move 4 from 5 to 3
                move 1 from 4 to 9
                move 1 from 8 to 9
                move 12 from 3 to 2
                move 1 from 9 to 1
                move 2 from 5 to 9
                move 3 from 9 to 5
                move 1 from 7 to 5
                move 3 from 7 to 3
                move 1 from 5 to 4
                move 1 from 5 to 8
                move 9 from 2 to 3
                move 2 from 2 to 3
                move 3 from 1 to 9
                move 1 from 8 to 9
                move 3 from 9 to 1
                move 9 from 2 to 6
                move 1 from 9 to 5
                move 6 from 2 to 3
                move 2 from 6 to 9
                move 3 from 6 to 3
                move 1 from 4 to 3
                move 2 from 9 to 6
                move 2 from 7 to 2
                move 2 from 2 to 8
                move 24 from 3 to 7
                move 2 from 5 to 6
                move 2 from 8 to 2
                move 7 from 2 to 8
                move 8 from 3 to 6
                move 2 from 1 to 3
                move 1 from 1 to 2
                move 1 from 5 to 2
                move 15 from 7 to 4
                move 9 from 7 to 9
                move 7 from 9 to 1
                move 5 from 8 to 1
                move 4 from 1 to 4
                move 19 from 4 to 3
                move 22 from 3 to 5
                move 1 from 7 to 5
                move 9 from 5 to 4
                move 6 from 1 to 3
                move 6 from 3 to 1
                move 4 from 5 to 4
                move 1 from 2 to 1
                move 1 from 2 to 6
                move 4 from 6 to 1
                move 1 from 3 to 6
                move 3 from 6 to 3
                move 2 from 9 to 8
                move 2 from 5 to 3
                move 2 from 5 to 1
                move 10 from 6 to 4
                move 4 from 4 to 9
                move 7 from 4 to 3
                move 2 from 8 to 7
                move 4 from 9 to 3
                move 5 from 5 to 7
                move 1 from 5 to 1
                move 1 from 6 to 3
                move 1 from 8 to 4
                move 1 from 8 to 3
                move 13 from 4 to 5
                move 1 from 1 to 8
                move 6 from 5 to 3
                move 1 from 7 to 6
                move 5 from 7 to 6
                move 9 from 1 to 8
                move 1 from 8 to 4
                move 1 from 7 to 1
                move 1 from 4 to 1
                move 5 from 3 to 7
                move 3 from 7 to 9
                move 1 from 5 to 4
                move 6 from 8 to 6
                move 1 from 9 to 3
                move 2 from 9 to 5
                move 7 from 5 to 9
                move 1 from 7 to 5
                move 2 from 5 to 3
                move 10 from 6 to 8
                move 2 from 6 to 1
                move 1 from 4 to 9
                move 1 from 7 to 5
                move 8 from 8 to 2
                move 1 from 1 to 7
                move 1 from 9 to 7
                move 1 from 5 to 1
                move 3 from 9 to 8
                move 7 from 8 to 7
                move 6 from 7 to 1
                move 1 from 8 to 7
                move 4 from 7 to 1
                move 16 from 3 to 7
                move 4 from 3 to 1
                move 5 from 7 to 8
                move 16 from 1 to 4
                move 9 from 1 to 7
                move 1 from 3 to 4
                move 15 from 4 to 8
                move 1 from 3 to 1
                move 2 from 1 to 6
                move 2 from 4 to 9
                move 17 from 8 to 2
                move 6 from 9 to 5
                move 8 from 7 to 8
                move 2 from 6 to 9
                move 4 from 5 to 7
                move 2 from 8 to 5
                move 1 from 5 to 9
                move 11 from 2 to 6
                move 4 from 6 to 1
                move 5 from 2 to 8
                move 2 from 9 to 2
                move 1 from 9 to 3
                move 3 from 1 to 8
                move 1 from 3 to 6
                move 7 from 6 to 9
                move 2 from 5 to 4
                move 6 from 7 to 4
                move 4 from 8 to 1
                move 1 from 5 to 2
                move 1 from 6 to 1
                move 7 from 9 to 8
                move 2 from 7 to 9
                move 9 from 2 to 9
                move 5 from 9 to 3
                move 3 from 2 to 8
                move 4 from 8 to 7
                move 9 from 7 to 2
                move 3 from 1 to 3
                move 14 from 8 to 1
                move 2 from 8 to 3
                move 1 from 9 to 4
                move 3 from 7 to 9
                move 8 from 3 to 9
                move 2 from 2 to 7
                move 12 from 1 to 8
                move 4 from 1 to 6
                move 2 from 6 to 7
                move 1 from 6 to 7
                move 9 from 4 to 7
                move 9 from 7 to 4
                move 1 from 1 to 6
                move 2 from 3 to 6
                move 2 from 6 to 8
                move 12 from 9 to 8
                move 2 from 6 to 9
                move 2 from 9 to 7
                move 1 from 8 to 5
                move 5 from 7 to 5
                move 1 from 9 to 1
                move 3 from 4 to 1
                move 5 from 4 to 8
                move 4 from 1 to 7
                move 1 from 4 to 2
                move 19 from 8 to 4
                move 2 from 7 to 5
                move 14 from 8 to 5
                move 2 from 7 to 8
                move 3 from 9 to 8
                move 19 from 4 to 2
                move 9 from 2 to 4
                move 2 from 7 to 8
                move 15 from 5 to 9
                move 15 from 9 to 8
                move 1 from 5 to 9
                move 11 from 8 to 7
                move 4 from 5 to 8
                move 1 from 5 to 9
                move 2 from 9 to 5
                move 2 from 2 to 6
                move 14 from 2 to 9
                move 12 from 8 to 9
                move 3 from 8 to 4
                move 7 from 9 to 2
                move 4 from 7 to 9
                move 1 from 6 to 9
                move 1 from 7 to 5
                move 1 from 6 to 2
                move 3 from 5 to 4
                move 19 from 9 to 4
                move 1 from 5 to 1
                move 1 from 9 to 8
                move 1 from 1 to 7
                move 1 from 8 to 9
                move 4 from 7 to 2
                move 3 from 7 to 6
                move 18 from 4 to 2
                move 17 from 2 to 3
                move 2 from 6 to 8
                move 17 from 3 to 6
                move 13 from 2 to 1
                move 2 from 8 to 3
                move 2 from 2 to 9
                move 6 from 1 to 9
                move 1 from 3 to 4
                move 1 from 3 to 9
                move 8 from 6 to 4
                move 20 from 4 to 8
                move 3 from 4 to 8
                move 15 from 8 to 2
                move 11 from 2 to 6
                move 2 from 1 to 7
                move 7 from 9 to 8
                move 6 from 9 to 3
                move 1 from 6 to 5
                """;
        List<String> lines = new ArrayList<>(procedure.lines().toList());

        for (String line : lines) {
            List<String> instructions = new ArrayList<>();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                instructions.add(tokenizer.nextToken());
            }
            instructions.removeAll(new ArrayList<>(Arrays.asList("move", "from", "to")));
            moves.add(instructions);
        }
    }

    public void move() {
        for (List<String> move : moves) {
            int amount = Integer.parseInt(move.get(0));
            int from = Integer.parseInt(move.get(1));
            int to = Integer.parseInt(move.get(2));

            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                String mover = stacks.get(from).pop();
                tempList.add(mover);
            }
            Collections.reverse(tempList);
            tempList.forEach(item -> stacks.get(to).offerFirst(item));
        }
    }

    public String getMessage() {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < stacks.size(); i++) {
            message.append(stacks.get(i + 1).peek());
        }
        message = new StringBuilder(message.toString().replace("[", ""));
        message = new StringBuilder(message.toString().replace("]", ""));

        return message.toString();
    }
}