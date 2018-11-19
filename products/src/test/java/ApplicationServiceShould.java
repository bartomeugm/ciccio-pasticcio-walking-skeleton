import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationServiceShould {

    @Test
    void return_product_dto_given_product_id() {
        ProductId productId = new ProductId(20018);
        String productName = "Augustine croissant";
        double productPrice = 12.00;
        ProductStatus status = ProductStatus.DISCONTINUED;

        ProductDTO expected = new ProductDTO(productName, productPrice, status);
        ProductRepository productRepository = mock(ProductRepository.class);

        Product product = new Product(productName, productPrice, status);

        when(productRepository.findProduct(productId)).thenReturn(Optional.of(product));

        ApplicationService applicationService = new ApplicationService(productRepository);

        ProductDTO actual = applicationService.getProductById(productId);
        assertThat(actual, is(expected));
    }
}