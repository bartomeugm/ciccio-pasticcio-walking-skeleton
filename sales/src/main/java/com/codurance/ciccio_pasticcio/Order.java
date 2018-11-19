package com.codurance.ciccio_pasticcio;

import java.util.Objects;
import java.util.UUID;

public class Order {
    public final EmployeeID employeeId;
    public final CustomerID customerId;
    public final ShippingDetails shippingDetails;
    public final Products products;

    public Order(EmployeeID employeeId, CustomerID customerId, ShippingDetails shippingDetails, Products products) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.shippingDetails = shippingDetails;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(employeeId, order.employeeId) &&
                Objects.equals(customerId, order.customerId) &&
                Objects.equals(shippingDetails, order.shippingDetails) &&
                Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, customerId, shippingDetails, products);
    }
}
