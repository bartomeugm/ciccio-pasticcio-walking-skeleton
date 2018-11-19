import com.eclipsesource.json.Json;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import spark.Request;
import spark.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductControllerShould {
    private Request req;
    private Response res;

    @BeforeEach
    void setUp() {
        req = mock(Request.class);
        res = mock(Response.class);
    }

    @Test
    void return_product_info_in_json() {

        ApplicationService appService = mock(ApplicationService.class);

        when(req.params("id")).thenReturn("10001");

        ProductDTO foundProduct = new ProductDTO("Pasticcio", 5.00, true);

        when(appService.getProductById(new ProductId(10001))).thenReturn(foundProduct);

        ProductController productController = new ProductController(appService);
        String actual = productController.getProductById(req, res);

        verify(res).status(200);
        verify(res).type("application/json");

        String expected = getJsonFromDTO(foundProduct);
        assertThat(actual, is(expected));
    }

    private String getJsonFromDTO(ProductDTO productDTO) {
        return Json.object()
                .add("name", productDTO.getName())
                .add("price", productDTO.getPrice())
                .add("discontinued", productDTO.discontinued())
                .toString();
    }
}
