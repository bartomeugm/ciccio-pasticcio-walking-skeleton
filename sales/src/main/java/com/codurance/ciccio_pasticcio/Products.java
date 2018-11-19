package com.codurance.ciccio_pasticcio;

import java.util.List;
import java.util.Objects;

public class Products {
    private final List<Item> itemList;

    public Products(List<Item> itemList) {

        this.itemList = itemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(itemList, products.itemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemList);
    }
}
