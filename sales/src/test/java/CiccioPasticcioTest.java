import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CiccioPasticcioTest {
    @Before
    public void setUp() {
        Application.main();
    }

    @Test
    public void verify_order_path_returns_hello() {
        given().port(8080)
                .when().get("/order")
                .then().body("mensaje", equalTo("Hello"));
    }
}
