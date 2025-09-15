import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String name, double price, int qty) {
        this.itemName = name; this.price = price; this.quantity = qty;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String n) { itemName = n; }

    public double getPrice() { return price; }
    public void setPrice(double p) { price = p; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { quantity = q; }

    public void getItemDetails() {
        System.out.printf("%s x%d @ %.2f each%n", itemName, quantity, price);
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount(); // discount amount
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) { super(name, price, qty); }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        // small discount for veg combos
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() { return "Veg combo 5%"; }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }

    @Override
    public double calculateTotalPrice() {
        // extra charge for non-veg preparation
        return getPrice() * getQuantity() + 20.0 * getQuantity();
    }

    @Override
    public double applyDiscount() {
        // seasonal discount
        return calculateTotalPrice() * 0.07;
    }

    @Override
    public String getDiscountDetails() { return "NonVeg seasonal 7%"; }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 200, 2));
        order.add(new NonVegItem("Chicken Biryani", 250, 1));

        double subtotal = 0;
        for (FoodItem fi : order) {
            fi.getItemDetails();
            double total = fi.calculateTotalPrice();
            double discount = 0;
            String discDetails = "No discount";
            if (fi instanceof Discountable) {
                Discountable d = (Discountable) fi;
                discount = d.applyDiscount();
                discDetails = d.getDiscountDetails();
            }
            System.out.printf("  Price: %.2f, Discount: %.2f (%s), Payable: %.2f%n",
                total, discount, discDetails, total - discount);
            subtotal += (total - discount);
            System.out.println("---");
        }
        System.out.printf("Order Total Payable: %.2f%n", subtotal);
    }
}
