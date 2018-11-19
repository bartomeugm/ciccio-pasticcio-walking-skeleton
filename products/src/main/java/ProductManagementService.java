import spark.Spark;

import static spark.Spark.get;


public class ProductManagementService {
    public void startOn(int port) {
        Spark.port(port);
        get("/products/10001", (req, res) -> "");
    }
}
