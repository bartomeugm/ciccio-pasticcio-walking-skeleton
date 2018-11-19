package com.codurance.ciccio_pasticcio;

import java.util.UUID;

public class OrderApplicationService {
    private final Repository orderRepository;
    private final OrderValidator orderValidator;
    private final CustomerRepository customerRepository;

    public OrderApplicationService(Repository orderRepository, OrderValidator orderValidator, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.customerRepository = customerRepository;
    }

    public UUID createOrder(OrderRequest orderRequest) throws CustomerNotExistsException {
        CustomerID customerID = orderRequest.customerId;
        boolean customerExists = customerRepository.doesCustomerExists(customerID);
        if (!customerExists) throw new CustomerNotExistsException();


        Order order = Order.from(orderRequest);
        orderValidator.validate(order);
        return orderRepository.insertOrder(order).identifier;
    }
}
