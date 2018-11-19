import java.util.Objects;

public class ProductDTO {

    private final String name;
    private final double price;
    private final ProductStatus status;

    public ProductDTO(String name, double price, ProductStatus status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductStatus status() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Double.compare(that.price, price) == 0 &&
                status == that.status &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, status);
    }
}
