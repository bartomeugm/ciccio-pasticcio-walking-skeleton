public class ControllerFactory {
    public static OrderController orderController() {
        return new OrderController(new OrderApplicationService());
    }
}
