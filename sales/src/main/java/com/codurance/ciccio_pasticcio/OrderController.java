package com.codurance.ciccio_pasticcio;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderController {

    OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    public Message createOrder(Request req, Response res) throws CustomerNotExistsException {
        OrderRequest orderRequest = parseCreateOrderDTO(req);
        UUID orderUuid = orderApplicationService.createOrder(orderRequest);

        return response(created("/orders/" + orderUuid), res);

    }

    private Message response(Message message, Response res) {
        res.status(HttpStatus.CREATED_201);
        res.type("application/json");
        return message;
    }

    private Message created(String url) {
        return new Message(url);
    }


    private OrderRequest parseCreateOrderDTO(Request req) {
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
        return new OrderRequest(employeeId, customerId, shippingDetails, products);
    }
}
