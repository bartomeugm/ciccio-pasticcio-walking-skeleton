import com.google.gson.Gson;
import spark.Spark;

import static spark.Spark.get;

public class Application {
    public static void main(String... args) {
        OrderController orderController = ControllerFactory.orderController();
        setPort();
        get("/order", (req, res) ->
                        orderController.sayHello(req, res)
                , Application::toJson);
    }

    private static void setPort() {
        Spark.port(8080);
    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
