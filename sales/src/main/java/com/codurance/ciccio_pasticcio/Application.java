package com.codurance.ciccio_pasticcio;

import com.eclipsesource.json.Json;
import com.google.gson.Gson;
import spark.Spark;

import static spark.Spark.post;

public class Application {
    public static void main(String... args) {
        OrderController orderController = ControllerFactory.orderController();
        setPort();
        post("/orders", (req, res) -> {
                    res.status(201);
                    res.type("application/json");
                    return Json.object().add("url", "/orders/1");
                }
        );
    }

    private static void setPort() {
        Spark.port(8080);
    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
