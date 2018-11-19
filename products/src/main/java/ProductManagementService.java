import spark.Spark;

import static spark.Spark.exception;
import static spark.Spark.get;


public class ProductManagementService {
    private ProductController productController;

    public ProductManagementService(ProductController productController) {

        this.productController = productController;
    }

    public void startOn(int port) {
        Spark.port(port);
        get("/products/:id", (req, res) -> {
            return productController.getProductById(req, res);
        });
        exception(Exception.class,
                (ex, req, res) -> { ex.printStackTrace(); });
    }
}
