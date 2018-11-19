import com.eclipsesource.json.Json;
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

    @Test
    void return_product_info_in_json() {
        String expected = Json.object()
                .add("name", "Pasticcio")
                .add("price", 5.00)
                .add("discontinued", Json.TRUE)
                .toString();
        Request req = mock(Request.class);
        Response res = mock(Response.class);

        ApplicationService appService = mock(ApplicationService.class);

        when(req.queryParams("id")).thenReturn("10001");

        ProductDTO pasticcio = new ProductDTO("Pasticcio", 5.00, true);
        ProductId productId = new ProductId(10001);
        when(appService.getProductById(productId)).thenReturn(pasticcio);

        ProductController productController = new ProductController(appService);
        String actual = productController.getProductById(req, res);

        verify(res).status(200);
        verify(res).type("application/json");

        assertThat(actual, is(expected));
    }
}
