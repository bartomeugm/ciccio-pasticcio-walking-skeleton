import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        HashMap<ProductId, Product> productData = new HashMap<ProductId, Product>() {{
            ProductId productId = new ProductId(10001);
            Product product = new Product("Pasticcio", 5., ProductStatus.DISCONTINUED);
            put(productId, product);
        }};
        ProductRepository repository = new ProductRepository(productData);
        ApplicationService applicationService = new ApplicationService(repository);
        ProductController productController = new ProductController(applicationService);
        ProductManagementService service = new ProductManagementService(productController);
        service.startOn(4567);
    }
}
