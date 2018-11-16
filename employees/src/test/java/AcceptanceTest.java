import com.eclipsesource.json.Json;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AcceptanceTest {

    // Create an employee

    @Test
    public void employee_can_be_created() {
        String jsonBody = Json.object()
                .add("lastName", "White")
                .add("firstName", "Nick")
                .add("title", "Mr")
                .add("titleOfCourtesy", "SIR")
                .add("birthDate", "11/12/1994")
                .add("hireDate", "16/11/2018")
                .add("address", "24th Street")
                .add("city", "London")
                .add("region", "South East")
                .add("postalCode", "N1 2EJ")
                .add("country", "UK")
                .add("homePhone", "0208 123 4567")
                .add("extension", "123")
                .add("photo", "/no_photo.jpg")
                .add("notes", "")
                .toString();

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("/employees")
                .then()
                .statusCode(201);
    }
}
