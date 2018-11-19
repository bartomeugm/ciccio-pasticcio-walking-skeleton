package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class OrderRequest {
    public final CustomerID customerId;
    public final ShippingDetails shippingDetails;
    public final Products products;
    public final EmployeeID employeeId;

    public OrderRequest(EmployeeID employeeId, CustomerID customerId, ShippingDetails shippingDetails, Products products) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.shippingDetails = shippingDetails;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(shippingDetails, that.shippingDetails) &&
                Objects.equals(products, that.products) &&
                Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, shippingDetails, products, employeeId);
    }
}
