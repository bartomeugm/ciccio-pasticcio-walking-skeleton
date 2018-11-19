package com.codurance.ciccio_pasticcio;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

public class OrderController {

    OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    public Message createOrder(Request req, Response res) {
        JsonObject requestBody = Json.parse(req.body()).asObject();
        JsonArray requestedProducts = requestBody.get("products").asArray();
        EmployeeID employeeId = new EmployeeID(requestBody.get("employee_id").asInt());
        CustomerID customerId = new CustomerID(requestBody.get("customer_id").asInt());

        ShippingDetails shippingDetails = new ShippingDetails(
                requestBody.get("ship_name").asString(),
                requestBody.get("ship_address").asString(),
                requestBody.get("ship_city").asString(),
                requestBody.get("ship_region").asString(),
                requestBody.get("ship_postcode").asString(),
                requestBody.get("ship_country").asString(),
                requestBody.get("freight").asBoolean());
        List<Item> itemList = new ArrayList<>();

        for (JsonValue product : requestedProducts) {
            itemList.add(new Item(product.asInt()));
        }

        Products products = new Products(itemList);
        Order order = new Order(employeeId, customerId, shippingDetails, products);

        int orderNumber = orderApplicationService.createOrder(order);

        res.status(201);
        res.type("application/json");
        Message message = new Message();
        message.setMensaje("/orders/" + orderNumber);
        return message;
    }
}
