import java.util.*;

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price){
        this.productId = productId; this.name = name; this.price = price;
    }

    public String getProductId(){ return productId; }
    public String getName(){ return name; }
    public double getPrice(){ return price; }
    public void setPrice(double price){ this.price = price; }

    public abstract double calculateDiscount(); // absolute amount
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price){ super(id,name,price); }
    @Override public double calculateDiscount(){ return getPrice() * 0.10; }
    @Override public double calculateTax(){ return getPrice() * 0.18; }
    @Override public String getTaxDetails(){ return "GST 18%"; }
}

class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price){ super(id,name,price); }
    @Override public double calculateDiscount(){ return getPrice() * 0.20; }
    @Override public double calculateTax(){ return getPrice() * 0.05; }
    @Override public String getTaxDetails(){ return "GST 5%"; }
}

class Groceries extends Product {
    public Groceries(String id, String name, double price){ super(id,name,price); }
    @Override public double calculateDiscount(){ return 0; }
}

public class ECommercePlatform {
    public static void printFinalPrice(Product p){
        double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
        double discount = p.calculateDiscount();
        double finalPrice = p.getPrice() + tax - discount;
        System.out.printf("%s (%.2f) Tax: %.2f Discount: %.2f -> Final: %.2f%n",
            p.getName(), p.getPrice(), tax, discount, finalPrice);
    }

    public static void main(String[] args){
        List<Product> cart = Arrays.asList(
            new Electronics("E1","Smartphone",20000),
            new Clothing("C1","T-Shirt",500),
            new Groceries("G1","Rice (5kg)",2500)
        );
        cart.forEach(ECommercePlatform::printFinalPrice);
    }
}
0