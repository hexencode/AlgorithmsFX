package com.hexenode.fx.algorithms.knapsack.builder;

import com.hexenode.fx.algorithms.knapsack.model.Item;
import com.hexenode.fx.algorithms.knapsack.model.Knapsack;

import java.util.LinkedList;

public class KnapsackBuilder {

    private LinkedList<Item> items;
    private int id;
    private double maxWeight;

    private KnapsackBuilder() {
    }

    public static KnapsackBuilder getBuilder() {
        return new KnapsackBuilder();
    }

    public KnapsackBuilder clone(Knapsack knapsack) {
        this.id = knapsack.getId() + 1;
        this.maxWeight = knapsack.getMaxWeight();
        this.items = new LinkedList<>(knapsack.getItems());
        return this;
    }

    public Knapsack build() {
        Knapsack knapsack = new Knapsack(id, maxWeight);
        knapsack.setItems(this.items);
        return knapsack;
    }
}
