package com.hexenode.fx.algorithms.knapsack.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "index")
public class Item {
    private final int index;
    private final double weight;
    private final double value;

    public String toCompactString() {
        return String.format("Item#%s[%skg, %sEUR]", index, weight, value);
    }
}
