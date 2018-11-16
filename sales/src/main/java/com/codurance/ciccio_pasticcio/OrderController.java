package com.codurance.ciccio_pasticcio;

import spark.Request;
import spark.Response;

public class OrderController {

    OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }
}
