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

}
