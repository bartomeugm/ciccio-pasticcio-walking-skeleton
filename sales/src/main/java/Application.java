import com.google.gson.Gson;

import static spark.Spark.get;

public class Application {
    public static void main(String... args) {
        get("/order", (req, res) -> {
            Controller controller = new ControllerFactory().create();
            return ((OrderController) controller).sayHello(req, res);
        }, Application::toJson);
    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
