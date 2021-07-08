package com.hexenode.fx.algorithms.knapsack;

import com.hexenode.fx.algorithms.knapsack.builder.KnapsackBuilder;
import com.hexenode.fx.algorithms.knapsack.model.Item;
import com.hexenode.fx.algorithms.knapsack.model.Knapsack;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class KnapsackFX {

    // By using recursion + memoization:
    // Time complexity: O(n*maxWeight)
    // Space complexity: O(n*maxWeight)

    private final List<Knapsack> knapsacks;
    private final int maxWeight;

    public KnapsackFX(int maxWeight) {
        this.knapsacks = Collections.synchronizedList(new ArrayList<>());
        this.maxWeight = maxWeight;
    }

    public Knapsack packKnapsack(List<Item> items) {
        Knapsack ks0 = new Knapsack(0, maxWeight);
        knapsacks.add(ks0);

        if (ks0.getItems().size() == items.size()) {
            return ks0;
        }

        for (Item item : items) {
            for (int i = 0; i < knapsacks.size(); i++) {
                Knapsack knapsack = knapsacks.get(i);
                if (item.getWeight() <= knapsack.getRemainingWeight()) {
                    // alternative 1. clone new knapsack but do not add the item
                    knapsacks.add(KnapsackBuilder.getBuilder().clone(knapsack).build());
                    i++; // because we have added new item, increase the for-loop index
                    // alternative 2. add the item to the current knapsack
                    knapsack.addItem(item);
                }
            }
        }
        log.debug("all knapsacks: " + knapsacks);

        // return the most optimised knapsack with the highest value
        Knapsack knapsack = knapsacks.stream().max(Comparator.comparingDouble(Knapsack::getTotalValue)).orElse(null);
        log.warn("winning knapsack: " + knapsack);
        return knapsack;
    }
}
