package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class Order {

    private final EmployeeID employeeId;
    private final CustomerID customerId;
    private final ShippingDetails shippingDetails;
    private final Products products;

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

    public Order(EmployeeID employeeId, CustomerID customerId, ShippingDetails shippingDetails, Products products) {

        this.employeeId = employeeId;
        this.customerId = customerId;
        this.shippingDetails = shippingDetails;
        this.products = products;
    }

}
