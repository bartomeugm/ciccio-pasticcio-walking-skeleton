package com.codurance.ciccio_pasticcio;

public interface Repository {
    Persistable<Order> insertOrder(Order order);
}
