import java.util.Objects;

public class ProductDTO {

    private final String name;
    private final double price;
    private final boolean discontinued;

    public ProductDTO(String name, double price, boolean discontinued) {
        this.name = name;
        this.price = price;
        this.discontinued = discontinued;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean discontinued() {
        return discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Double.compare(that.price, price) == 0 &&
                discontinued == that.discontinued &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, discontinued);
    }
}
