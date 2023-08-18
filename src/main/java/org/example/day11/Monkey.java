package org.example.day11;

import java.util.List;
import java.util.Queue;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;

public class Monkey {
    private static int commonDivider;
    private final int id;
    private final Queue<Item> items;
    private final LongUnaryOperator operator;
    private final Predicate<Long> predicate;
    private final List<Integer> friends;
    private int numberOfInspections;

    public Monkey(int id, Queue<Item> items, LongUnaryOperator operator, Predicate<Long> predicate, List<Integer> friends) {
        this.id = id;
        this.items = items;
        this.predicate = predicate;
        this.operator = operator;
        this.friends = friends;
    }

    public static void setCommonDivider(List<Integer> dividers) {
        commonDivider = dividers.stream()
                .filter(Monkey::isPrimeNumber)
                .reduce(1, (a, b) -> a * b);
    }

    public void inspectAndThrow(List<Monkey> monkeys) {
        while (!items.isEmpty()) {
            long worryLevel = inspect(items.poll());
            worryLevel = getBored(worryLevel);
            throwToMonkey(worryLevel, monkeys);
            numberOfInspections++;
        }
    }

    public int getId() {
        return id;
    }

    public void addToItems(Item item) {
        items.add(item);
    }

    public int getNumberOfInspections() {
        return numberOfInspections;
    }

    private long inspect(Item item) {
        return this.operator.applyAsLong(item.worryLevel());
    }

    private long getBored(long worryLevel) { // refactor
        return (worryLevel % commonDivider);
    }

    private boolean testWorryLevel(long worryLevel) {
        return this.predicate.test(worryLevel);
    }

    private void throwToMonkey(long worryLevel, List<Monkey> monkeys) {
        Monkey monkey = findMonkey(friends.get(testWorryLevel(worryLevel) ? 0 : 1), monkeys);
        if (monkey != null) {
            monkey.addToItems(new Item(worryLevel));
        }
    }

    private Monkey findMonkey(int monkeyId, List<Monkey> monkeys) {
        return monkeys.stream().filter(a -> a.getId() == monkeyId).findFirst().orElse(null);
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0 ) {
                return false;
            }
        }
        return true;
    }
}
