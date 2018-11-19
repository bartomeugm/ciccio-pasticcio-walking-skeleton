public class Product{
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean discontinued() {
        return discontinued;
    }

    private final String name;
    private final double price;
    private final boolean discontinued;


    public Product(String name, double price, boolean discontinued) {
        this.name = name;
        this.price = price;
        this.discontinued = discontinued;
    }

}
