package org.example.day11;

import java.util.*;

public class Day11 {

    private final List<Monkey> monkeys;
    private final List<Integer> dividers;
    private final int amountOfRounds;

    public Day11(int amountOfRounds) {
        this.monkeys = new ArrayList<>();
        this.amountOfRounds = amountOfRounds;
        fillMonkeyList();

        this.dividers = new ArrayList<>(List.of(7, 13, 5, 19, 2, 11, 17, 3));
        Monkey.setCommonDivider(this.dividers);
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

    private void fillMonkeyList() {
        monkeys.add(new Monkey(
                0,
                new LinkedList<>(List.of(new Item(66), new Item(79))),
                n -> n * 11,
                n -> n % 7 == 0,
                new ArrayList<>(List.of(6, 7))));
        monkeys.add(new Monkey(
                1,
                new LinkedList<>(List.of(
                        new Item(84), new Item(94), new Item(94),
                        new Item(81), new Item(98), new Item(75))),
                n -> n * 17,
                n -> n % 13 == 0,
                new ArrayList<>(List.of(5, 2))));
        monkeys.add(new Monkey(
                2,
                new LinkedList<>(List.of(
                        new Item(85), new Item(79), new Item(59),
                        new Item(64), new Item(79), new Item(95),
                        new Item(67))),
                n -> n + 8,
                n -> n % 5 == 0,
                new ArrayList<>(List.of(4, 5))));
        monkeys.add(new Monkey(
                3,
                new LinkedList<>(List.of(new Item(70))),
                n -> n + 3,
                n -> n % 19 == 0,
                new ArrayList<>(List.of(6, 0))));
        monkeys.add(new Monkey(
                4,
                new LinkedList<>(List.of(
                        new Item(57), new Item(69), new Item(78),
                        new Item(78))),
                n -> n + 4,
                n -> n % 2 == 0,
                new ArrayList<>(List.of(0, 3))));
        monkeys.add(new Monkey(
                5,
                new LinkedList<>(List.of(
                        new Item(65), new Item(92), new Item(60),
                        new Item(74), new Item(72))),
                n -> n + 7,
                n -> n % 11 == 0,
                new ArrayList<>(List.of(3, 4))));
        monkeys.add(new Monkey(
                6,
                new LinkedList<>(List.of(
                        new Item(77), new Item(91), new Item(91))),
                n -> n * n,
                n -> n % 17 == 0,
                new ArrayList<>(List.of(1, 7))));
        monkeys.add(new Monkey(
                7,
                new LinkedList<>(List.of(
                        new Item(76), new Item(58), new Item(57),
                        new Item(55), new Item(67), new Item(77),
                        new Item(54), new Item(99))),
                n -> n + 6,
                n -> n % 3 == 0,
                new ArrayList<>(List.of(2, 1))));
    }
}


