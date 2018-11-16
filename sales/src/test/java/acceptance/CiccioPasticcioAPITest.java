package acceptance;

import com.codurance.ciccio_pasticcio.Application;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CiccioPasticcioAPITest {
    @Before
    public void setUp() {
        Application.main();
    }

    @Test
    public void verify_order_creation_is_ok() {
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

        given().port(8080)
                .when()
                .contentType("application/json")
                .body(order)
                .post("/orders")
                .then()
                .statusCode(201)
                .contentType("application/json")
                .body("url", equalTo("/orders/1"));
    }
}