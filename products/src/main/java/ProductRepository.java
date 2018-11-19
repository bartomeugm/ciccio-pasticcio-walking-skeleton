import java.util.Map;
import java.util.Optional;

public class ProductRepository {
    private Map<ProductId, Product> productData;

    public ProductRepository(Map<ProductId, Product> productData) {
        this.productData = productData;
    }

    public ProductRepository() {
    }

    public Optional<Product> findProduct(ProductId productId) {
        return Optional.ofNullable(productData.get(productId));
    }
}