package com.codurance.ciccio_pasticcio;

public interface CustomerRepository {
    Boolean doesCustomerExists(CustomerId customerId);
}
