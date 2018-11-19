import java.util.Objects;

public class Product{
    private final String name;

    private final double price;
    private final ProductStatus status;

    public Product(String name, double price, ProductStatus status) {
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
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                status == product.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, status);
    }
}
