import spark.Request;
import spark.Response;

public class OrderController implements Controller {

    OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    public Message sayHello(Request req, Response res) {
        String greeting = orderApplicationService.sayHello();
        Message mensaje = new Message();
        mensaje.setMensaje(greeting);
        res.header("Content-Type","application/json");
        return mensaje;
    }
}
