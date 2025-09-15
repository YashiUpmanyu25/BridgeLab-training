public class CartItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public void addItem(int quantityToAdd) {
        if (quantityToAdd > 0) {
            quantity += quantityToAdd;
            System.out.println("Added " + quantityToAdd + " of " + itemName + " to cart");
        } else {
            System.out.println("Quantity to add must be positive");
        }
    }
    
    public void removeItem(int quantityToRemove) {
        if (quantityToRemove > 0) {
            if (quantityToRemove <= quantity) {
                quantity -= quantityToRemove;
                System.out.println("Removed " + quantityToRemove + " of " + itemName + " from cart");
            } else {
                System.out.println("Cannot remove more items than available in cart");
            }
        } else {
            System.out.println("Quantity to remove must be positive");
        }
    }
    
    public double getTotalCost() {
        return price * quantity;
    }
    
    public void displayItem() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total cost: " + getTotalCost());
    }
    
    public static void main(String[] args) {
        CartItem item1 = new CartItem("Laptop", 999.99, 1);
        CartItem item2 = new CartItem("Mouse", 19.99, 2);
        
        System.out.println("Initial Cart:");
        item1.displayItem();
        System.out.println();
        item2.displayItem();
        System.out.println();
        
        item1.addItem(2);
        item1.displayItem();
        System.out.println();
        
        item2.removeItem(1);
        item2.displayItem();
        System.out.println();
        
        System.out.println("Total cost of all items: " + (item1.getTotalCost() + item2.getTotalCost()));
    }
}