package com.hexenode.fx.algorithms.knapsack.model;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Slf4j
@EqualsAndHashCode(of = "id")
public class Knapsack {
    private final LinkedList<Item> items;

    private final int id;
    private final double maxWeight;
    private double remainingWeight;

    public Knapsack(int id, double maxWeight) {
        log.trace("Knapsack#{} -> created", id);
        this.id = id;
        this.maxWeight = maxWeight;
        this.remainingWeight = maxWeight;
        this.items = new LinkedList<>();
    }

    public void setItems(LinkedList<Item> items) {
        this.items.clear();
        items.forEach(this::addItem);
    }

    public void addItem(Item item) {
        if (remainingWeight - item.getWeight() < 0) {
            log.error("Knapsack is full!!");
            return;
        }
        this.remainingWeight = remainingWeight - item.getWeight();
        this.items.add(item);
    }

    public int getId() {
        return id;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getRemainingWeight() {
        return remainingWeight;
    }

    public double getTotalValue() {
        return items.stream().map(Item::getValue).reduce(Double::sum).orElse(0.0);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Knapsack.class.getSimpleName() + "#" + id + "[", "]")
                .add("remainingWeight=" + remainingWeight)
                .add("items=" + items.stream().map(Item::toCompactString).collect(Collectors.joining(", ")))
                .toString();
    }
}
