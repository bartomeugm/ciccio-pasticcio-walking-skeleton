import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import spark.Spark;

import static spark.Spark.post;

public class EmployeeManagementService {


    private ApplicationService applicationService;

    public EmployeeManagementService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public void startOn(int port) {
        Spark.port(port);
        post("/employees", (req, res) -> {
            EmployeeID employeeID = applicationService.addEmployee(null);

            res.type("application/json");
            res.status(201);
            return Json.object().add("uri", "/employees/"+employeeID.toString()).toString();
        });
    }
}
