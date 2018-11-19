package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class CustomerID {
    private final int customerId;

    public CustomerID(int customerId) {

        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerID that = (CustomerID) o;
        return customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
