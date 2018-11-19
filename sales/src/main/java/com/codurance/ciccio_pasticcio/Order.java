package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class Order {
    public final EmployeeID employeeId;
    public final CustomerID customerId;
    public final ShippingDetails shippingDetails;
    public final Products products;
    private final OrderID id;

    public Order(EmployeeID employeeId, CustomerID customerId, ShippingDetails shippingDetails, Products products, OrderID id) {
        this.id = id;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.shippingDetails = shippingDetails;
        this.products = products;
    }

    public static Order from(OrderRequest request) {
        return new Order(request.employeeId, request.customerId, request.shippingDetails, request.products, new OrderID());
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
