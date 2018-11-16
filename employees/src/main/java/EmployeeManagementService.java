import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import spark.Spark;

import static spark.Spark.post;

public class EmployeeManagementService {


    public void startOn(int port) {
        Spark.port(port);
        post("/employees", (req, res) -> {
            res.status(201);
            res.type("application/json");
            return Json.object().add("uri", "/employees/1234").toString();
        });
    }
}
