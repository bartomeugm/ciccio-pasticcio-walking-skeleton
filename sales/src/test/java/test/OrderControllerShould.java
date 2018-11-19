package test;

import com.codurance.ciccio_pasticcio.*;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import org.junit.Test;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class OrderControllerShould {

    @Test
    public void create_an_order_and_return_order_url() {
        OrderApplicationService orderApplicationService = mock(OrderApplicationService.class);
        OrderController orderController = new OrderController(orderApplicationService);
        Request request = mock(Request.class);
        Response response = mock(Response.class);
        when(request.body()).thenReturn(getBody());

        EmployeeID employeeId = new EmployeeID(1);
        CustomerID customerId = new CustomerID(2);
        ShippingDetails shippingDetails = new ShippingDetails(
                "Homer Simpson",
                "472, Evergreen terrace",
                "Springfield",
                "Oregon",
                "1234",
                "USA",
                true);
        List<Item> itemList = new ArrayList<Item>() {{
            add(new Item(1234));
            add(new Item(5678));
        }};
        Message expectedMessage = new Message();
        expectedMessage.setMensaje("/orders/1");
        Products products = new Products(itemList);
        Order order = new Order(employeeId, customerId, shippingDetails, products);
        when(orderApplicationService.createOrder(order)).thenReturn(1);

        Message actualMessage = orderController.createOrder(request, response);


        verify(response).status(201);
        verify(response).type("application/json");
        verify(orderApplicationService).createOrder(order);
        assertEquals(expectedMessage, actualMessage);
    }

    private String getBody() {
        JsonArray products = Json.array()
                .add(1234)
                .add(5678);

        String order = Json.object()
                .add("employee_id", 1)
                .add("customer_id", 2)
                .add("freight", true)
                .add("ship_name", "Homer Simpson")
                .add("ship_address", "472, Evergreen terrace")
                .add("ship_city", "Springfield")
                .add("ship_region", "Oregon")
                .add("ship_postcode", "1234")
                .add("ship_country", "USA")
                .add("products", products)
                .toString();

        return order;
    }
}
