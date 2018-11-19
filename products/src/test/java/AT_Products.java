import com.eclipsesource.json.Json;
import io.restassured.specification.Argument;
import org.junit.jupiter.api.*;
import spark.Spark;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AT_Products {

    private ApplicationService applicationService;

    @BeforeAll
    static void setUp() {
        new ProductManagementService(applicationService).startOn(8080);
    }

    @Test
    void product_can_be_found_by_id() {
        String jsonBody = Json.object()
                .add("name", "Pasticcio")
                .add("price", 5.00)
                .add("discontinued", Json.TRUE)
                .toString();

        given()
                .contentType("application/json")
            .when()
                .get("/products/10001")
            .then()
                .statusCode(200)
                .contentType("application/json")
                .body("$", equalTo(jsonBody));
    }

    @AfterAll
    static void tearDown() {
        Spark.stop();
    }
}
