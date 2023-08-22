package org.example.day11;

import java.util.*;
import java.util.function.LongPredicate;
import java.util.function.LongUnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day11 {

    private final List<Monkey> monkeys;
    private final List<Integer> dividers;
    private final int amountOfRounds;

    public Day11(int amountOfRounds) {
        this.monkeys = new ArrayList<>();
        this.amountOfRounds = amountOfRounds;
        this.dividers = new ArrayList<>();
        fillMonkeyList(INPUT);
    }

    public long doMonkeyBusiness() {
        for (int i = 0; i < amountOfRounds; i++) {
            for (int j = 0; j < monkeys.size(); j++) {
                monkeys.get(j).inspectAndThrow(monkeys);
            }
        }

        List<Integer> inspections = monkeys.stream()
                .map(Monkey::getNumberOfInspections)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .toList();

        return Long.valueOf(inspections.get(0)) * Long.valueOf(inspections.get(1));
    }

    private void fillMonkeyList(String input) {
        String[] monkeyParts = input.split("\n\n");

        for (String monkey : monkeyParts) {
            int id = -1;
            Queue<Item> items = new LinkedList<>();
            LongUnaryOperator operator = null;
            LongPredicate predicate = null;
            List<Integer> friends = new ArrayList<>();

            for (String line : monkey.lines().toList()) {
                String[] lines = line.split(":");

                id = parseMonkeyId(id, lines);

                if (lines.length > 1) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(lines[1]);

                    parseItems(items, lines);
                    operator = parseOperator(operator, lines, matcher);
                    predicate = parseTest(predicate, lines, matcher);
                    parseFriends(friends, lines, matcher);
                }
            }
            Monkey monkeyToAdd = new Monkey(id, items, operator, predicate, friends);
            monkeys.add(monkeyToAdd);
        }
        Monkey.setCommonDivider(dividers);
    }

    private int parseMonkeyId(int id, String[] lines) {
        if (lines[0].contains("Monkey")) {
            String[] parts = lines[0].split("\s");
            return Integer.parseInt(parts[1].substring(0, 1));
        }
        return id;
    }

    private void parseItems(Queue<Item> items, String[] lines) {
        if (lines[0].contains("Starting items")) {
            String[] parts = lines[1].split(",");
            for (String part : parts) {
                items.add(new Item(Integer.parseInt(part.trim())));
            }
        }
    }

    private LongUnaryOperator parseOperator(LongUnaryOperator operator, String[] lines, Matcher matcher) {
        if (lines[0].contains("Operation")) {
            String[] parts = lines[1].split("=");
            if (parts[1].contains("*") && (matcher.find())) {
                return n -> n * Integer.parseInt(matcher.group());
            } else if (parts[1].contains("+") && (matcher.find())) {
                return n -> n + Integer.parseInt(matcher.group());
            } else if ((parts[1].contains("*"))) {
                return n -> n * n;
            } else {
                return n -> n + n;
            }
        }
        return operator;
    }

    private LongPredicate parseTest(LongPredicate predicate, String[] lines, Matcher matcher) {
        if (lines[0].contains("Test") && (matcher.find())) {
            int divider = Integer.parseInt(matcher.group());
            this.dividers.add(divider);
            return n -> n % divider == 0;
        }
        return predicate;
    }

    private void parseFriends(List<Integer> friends, String[] lines, Matcher matcher) {
        if ((lines[0].contains("true") || lines[0].contains("false")) && (matcher.find())) {
            friends.add(Integer.parseInt(matcher.group()));
        }
    }

    private static final String INPUT =
            """
                   Monkey 0:
                     Starting items: 66, 79
                     Operation: new = old * 11
                     Test: divisible by 7
                       If true: throw to monkey 6
                       If false: throw to monkey 7
                   
                   Monkey 1:
                     Starting items: 84, 94, 94, 81, 98, 75
                     Operation: new = old * 17
                     Test: divisible by 13
                       If true: throw to monkey 5
                       If false: throw to monkey 2
                   
                   Monkey 2:
                     Starting items: 85, 79, 59, 64, 79, 95, 67
                     Operation: new = old + 8
                     Test: divisible by 5
                       If true: throw to monkey 4
                       If false: throw to monkey 5
                   
                   Monkey 3:
                     Starting items: 70
                     Operation: new = old + 3
                     Test: divisible by 19
                       If true: throw to monkey 6
                       If false: throw to monkey 0
                   
                   Monkey 4:
                     Starting items: 57, 69, 78, 78
                     Operation: new = old + 4
                     Test: divisible by 2
                       If true: throw to monkey 0
                       If false: throw to monkey 3
                   
                   Monkey 5:
                     Starting items: 65, 92, 60, 74, 72
                     Operation: new = old + 7
                     Test: divisible by 11
                       If true: throw to monkey 3
                       If false: throw to monkey 4
                   
                   Monkey 6:
                     Starting items: 77, 91, 91
                     Operation: new = old * old
                     Test: divisible by 17
                       If true: throw to monkey 1
                       If false: throw to monkey 7
                   
                   Monkey 7:
                     Starting items: 76, 58, 57, 55, 67, 77, 54, 99
                     Operation: new = old + 6
                     Test: divisible by 3
                       If true: throw to monkey 2
                       If false: throw to monkey 1
                    """;
}


