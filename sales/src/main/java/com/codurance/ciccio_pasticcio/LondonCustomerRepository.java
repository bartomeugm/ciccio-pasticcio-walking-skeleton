package com.codurance.ciccio_pasticcio;

public class LondonCustomerRepository implements CustomerRepository {
    @Override
    public Boolean doesCustomerExists(CustomerId customerId) {
        throw new UnsupportedOperationException();
    }
}
