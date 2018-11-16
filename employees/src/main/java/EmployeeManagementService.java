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
            res.status(201);
            res.type("application/json");

            EmployeeID employeeID = applicationService.addEmployee(null);


            return Json.object().add("uri", "/employees/"+employeeID.toString()).toString();
        });
    }
}
