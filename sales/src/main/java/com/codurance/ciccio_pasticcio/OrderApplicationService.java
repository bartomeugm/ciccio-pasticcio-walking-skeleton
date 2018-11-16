package com.codurance.ciccio_pasticcio;

public class OrderApplicationService {
    public OrderApplicationService(Repository repository, OrderValidator orderValidator) {
    }

    public String sayHello() {
        return "Hello";
    }

    public void createOrder(Order order) {
        throw new UnsupportedOperationException();
    }
}
