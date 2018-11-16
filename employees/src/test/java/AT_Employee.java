import com.eclipsesource.json.Json;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AT_Employee {

    ApplicationService applicationService = mock(ApplicationService.class);

    @BeforeEach
    void setUp() {
        new EmployeeManagementService(applicationService).startOn(8080);
    }

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

        when(applicationService.addEmployee(any())).thenReturn(new EmployeeID(4321));

        given()
                .contentType("application/json")
                .body(jsonBody)
        .when()
                .post("/employees")
        .then()
                .statusCode(201)
                .contentType("application/json")
                .body("uri", equalTo("/employees/4321"));
    }
}
