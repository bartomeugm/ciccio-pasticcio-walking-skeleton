import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import spark.Request;
import spark.Response;

public class ProductController {
    private ApplicationService applicationService;

    public ProductController(ApplicationService applicationService) {

        this.applicationService = applicationService;
    }

    public String getProductById(Request req, Response res) {
        res.status(200);
        res.type("application/json");

        ProductId productId = new ProductId(Integer.valueOf(req.queryParams("id")));
        ProductDTO productDTO = applicationService.getProductById(productId);
        JsonObject jsonObject = Json.object()
                .add("name", productDTO.getName())
                .add("price", productDTO.getPrice())
                .add("discontinued", productDTO.discontinued());

        return jsonObject.toString();
    }
}
