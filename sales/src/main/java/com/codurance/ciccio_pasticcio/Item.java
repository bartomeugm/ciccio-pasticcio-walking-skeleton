package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class Item {
    private final int productId;

    public Item(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return productId == item.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
