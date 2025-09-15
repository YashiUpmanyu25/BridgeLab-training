import java.util.*;

class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name; this.price = price;
    }
}

class Order {
    int orderId;
    List<Product> products = new ArrayList<>();

    Order(int orderId) { this.orderId = orderId; }

    void addProduct(Product p) { products.add(p); }

    void showOrder() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) {
            System.out.println("- " + p.name + " $" + p.price);
        }
    }
}

class CustomerE {
    String name;
    List<Order> orders = new ArrayList<>();

    CustomerE(String name) { this.name = name; }

    void placeOrder(Order o) {
        orders.add(o);
        System.out.println(name + " placed order " + o.orderId);
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        CustomerE c1 = new CustomerE("Pragati");

        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Phone", 20000);

        Order o1 = new Order(101);
        o1.addProduct(p1);
        o1.addProduct(p2);

        c1.placeOrder(o1);
        o1.showOrder();
    }
}
