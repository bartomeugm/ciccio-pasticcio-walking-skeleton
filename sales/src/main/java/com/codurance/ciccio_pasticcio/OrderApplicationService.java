package com.codurance.ciccio_pasticcio;

public class OrderApplicationService {
    public OrderApplicationService(Repository repository, OrderValidator orderValidator, CustomerRepository customerRepository) {
    }

    public String sayHello() {
        return "Hello";
    }

    public int createOrder(Order order) {
        throw new UnsupportedOperationException();
    }
}
