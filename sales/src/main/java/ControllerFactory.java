public class ControllerFactory {
    public Controller create() {
        return new OrderController(new OrderApplicationService());
    }
}
