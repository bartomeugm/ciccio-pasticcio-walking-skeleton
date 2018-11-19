import java.util.Optional;

public class ApplicationService {


    private ProductRepository productRepository;

    public ApplicationService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public ProductDTO getProductById(ProductId productId) {
        Optional<Product> productOptional = productRepository.findProduct(productId);
        Product product = productOptional.get();
        return new ProductDTO(product.getName(), product.getPrice(), product.status());
    }
}
