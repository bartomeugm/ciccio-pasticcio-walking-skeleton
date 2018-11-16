import spark.Spark;

import static spark.Spark.post;

public class EmployeeManagementService {


    public void startOn(int port) {
        Spark.port(port);
        post("/employees", (req, res) -> {
            res.status(201);
            return "";
        });
    }
}
