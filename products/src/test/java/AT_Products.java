import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import io.restassured.specification.Argument;
import org.junit.jupiter.api.*;
import spark.Spark;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AT_Products {

    @BeforeAll
    static void setUp() {
        HashMap<ProductId, Product> productData = new HashMap<ProductId, Product>() {{
            ProductId productId = new ProductId(10001);
            Product product = new Product("Pasticcio", 5., ProductStatus.DISCONTINUED);
            put(productId, product);
        }};
        ProductRepository repository = new ProductRepository(productData);
        ApplicationService applicationService = new ApplicationService(repository);
        ProductController productController = new ProductController(applicationService);
        ProductManagementService productManagementService = new ProductManagementService(productController);

        productManagementService.startOn(8080);
    }

    @Test
    void product_can_be_found_by_id() {
        String jsonBody = Json.object()
                .add("name", "Pasticcio")
                .add("price", 5.00)
                .add("discontinued", Json.TRUE).toString();

        given()
                .contentType("application/json")
            .when()
                .get("/products/10001")
            .then()
                .statusCode(200)
                .contentType("application/json")
                .body(equalTo(jsonBody));
    }

    @AfterAll
    static void tearDown() {
        Spark.stop();
    }
}
