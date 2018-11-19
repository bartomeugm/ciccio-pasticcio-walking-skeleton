package com.codurance.ciccio_pasticcio;

import com.google.gson.Gson;
import spark.Spark;

import static spark.Spark.exception;
import static spark.Spark.post;

public class Application {
    public static void main(String... args) {
        OrderController orderController = ControllerFactory.orderController();
        setPort();
        post("/orders", (req, res) -> orderController.createOrder(req, res)
        );

        exception(CustomerNotExistsException.class, (exception, request, response) -> {
            response.status(500);
            response.body("User not found");
        });
    }

    private static void setPort() {
        Spark.port(8080);
    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
