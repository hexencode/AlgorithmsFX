package com.hexenode.fx.algorithms.knapsack;

import com.hexenode.fx.algorithms.knapsack.model.Item;
import com.hexenode.fx.algorithms.knapsack.model.Knapsack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class KnapsackFXTest {

    @Test
    public void test1() {
        int maxWeight = 10;
        List<Item> items = List.of(
                new Item(0, 6.0, 20.0),
                new Item(1, 5.0, 15.0),
                new Item(2, 10.0, 25.0),
                new Item(3, 3.0, 10.0)
        );

        KnapsackFX knapsackFX = new KnapsackFX(maxWeight);
        Knapsack knapsack = knapsackFX.packKnapsack(items);

        assertThat(knapsack.getTotalValue()).isEqualTo(30);
        assertThat(knapsack.getItems()).size().isEqualTo(2);
        assertThat(knapsack.getItems()).extracting("index", "weight", "value").contains(
                tuple(0, 6.0, 20.0),
                tuple(3, 3.0, 10.0)
        );
    }

    @Test
    public void test2() {
        /* PREPARE TEST DATA */
        int maxWeight = 56;
        List<Item> items = List.of(
                new Item(0, 90.72, 13.0),
                new Item(1, 33.80, 40.0),
                new Item(2, 43.15, 10.0),
                new Item(3, 37.97, 16.0),
                new Item(4, 46.81, 36.0),
                new Item(5, 48.77, 79.0),
                new Item(6, 81.80, 45.0),
                new Item(7, 19.36, 79.0),
                new Item(8, 6.76, 64.0)
        );

        /* RUN */
        Knapsack knapsack = new KnapsackFX(maxWeight).packKnapsack(items);

        /* ASSERT RESULTS */
        assertThat(knapsack.getTotalValue()).isEqualTo(143);
        assertThat(knapsack.getItems()).size().isEqualTo(2);
        assertThat(knapsack.getItems()).extracting("index", "weight", "value").contains(
                tuple(7, 19.36, 79.0),
                tuple(8, 6.76, 64.0)
        );
    }

    @Test
    public void test3() {
        /* PREPARE TEST DATA */
        int maxWeight = 81;
        List<Item> items = List.of(
                new Item(1, 53.38, 45.0),
                new Item(2, 88.62, 98.0),
                new Item(3, 78.48, 3.0),
                new Item(4, 72.30, 76.0),
                new Item(5, 30.18, 9.0),
                new Item(6, 46.34, 48.0)
        );

        /* RUN */
        Knapsack knapsack = new KnapsackFX(maxWeight).packKnapsack(items);

        /* ASSERT RESULTS */
        assertThat(knapsack.getTotalValue()).isEqualTo(76.0);
        assertThat(knapsack.getItems()).size().isEqualTo(1);
        assertThat(knapsack.getItems()).extracting("index", "weight", "value").contains(
                tuple(4, 72.3, 76.0)
        );
    }

    @Test
    public void test4() {
        /* PREPARE TEST DATA */
        int maxWeight = 8;
        List<Item> items = List.of(
                new Item(1, 15.3, 34.0)
        );

        /* RUN */
        Knapsack knapsack = new KnapsackFX(maxWeight).packKnapsack(items);

        /* ASSERT RESULTS */
        assertThat(knapsack.getItems()).isNullOrEmpty();
    }

    @Test
    public void test5() {
        /* PREPARE TEST DATA */
        int maxWeight = 75;
        List<Item> items = List.of(
                new Item(1, 85.31, 29.0),
                new Item(2, 14.55, 74.0),
                new Item(3, 3.98, 16.0),
                new Item(4, 26.24, 55.0),
                new Item(5, 63.69, 52.0),
                new Item(6, 76.25, 75.0),
                new Item(7, 60.02, 74.0),
                new Item(8, 93.18, 35.0),
                new Item(9, 89.95, 78.0)
        );

        /* RUN */
        Knapsack knapsack = new KnapsackFX(maxWeight).packKnapsack(items);

        /* ASSERT RESULTS */
        assertThat(knapsack.getTotalValue()).isEqualTo(148.0);
        assertThat(knapsack.getItems()).size().isEqualTo(2);
        assertThat(knapsack.getItems()).extracting("index", "weight", "value").contains(
                tuple(2, 14.55, 74.0),
                tuple(7, 60.02, 74.0)
        );
    }

}