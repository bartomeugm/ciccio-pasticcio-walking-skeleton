import com.sun.deploy.config.JREInfo;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class ProductRepositoryShould {

    // preload repository with products??

    @Test
    void return_product_given_id() {

        Product product = new Product("pastel de nata", 2., ProductStatus.ACTIVE);
        ProductId id = new ProductId(10001);
        Map<ProductId, Product> productData = new HashMap<ProductId, Product>() {{ put(id, product); }};
        ProductRepository repository = new ProductRepository(productData);
        assertThat(repository.findProduct(id).get(), CoreMatchers.is(product));
    }
}
