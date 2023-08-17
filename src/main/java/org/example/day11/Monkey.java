package org.example.day11;

import java.util.List;
import java.util.Queue;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class Monkey {
    private final int id;
    private final Queue<Item> items;
    private final IntUnaryOperator operator;
    private final Predicate<Integer> predicate;
    private final List<Integer> friends;
    private int numberOfInspections;

    public Monkey(int id, Queue<Item> items, IntUnaryOperator operator, Predicate<Integer> predicate, List<Integer> friends) {
        this.id = id;
        this.items = items;
        this.predicate = predicate;
        this.operator = operator;
        this.friends = friends;
    }

    public void inspectAndThrow(List<Monkey> monkeys) {
        while (!items.isEmpty()) {
           int worryLevel = inspect(items.poll());
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

    private int inspect(Item item) {
        return this.operator.applyAsInt(item.worryLevel());
    }

    private int getBored(int worryLevel) {
        return worryLevel / 3;
    }

    private boolean testWorryLevel(int worryLevel) {
        return this.predicate.test(worryLevel);
    }

    private void throwToMonkey(int worryLevel, List<Monkey> monkeys) {
        Monkey monkey = findMonkey(friends.get(testWorryLevel(worryLevel) ? 0 : 1), monkeys);
        if (monkey != null) {
            monkey.addToItems(new Item(worryLevel));
        }
    }

    private Monkey findMonkey(int monkeyId, List<Monkey> monkeys) {
        return monkeys.stream().filter(a -> a.getId() == monkeyId).findFirst().orElse(null);
    }
}
