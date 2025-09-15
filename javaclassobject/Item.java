public class Item {
    String itemCode;
    String itemName;
    double price;
    
    Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    
    public void displayItem() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Price: " + price);
        System.out.println("----------------------------");
    }
    
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
    
    public static void main(String[] args) {
        Item item1 = new Item("01AA", "Water bottle", 500);
        Item item2 = new Item("01BB", "Rice", 700);
        Item item3 = new Item("02AA", "Blackboard", 400);
        
        item1.displayItem();
        item2.displayItem();
        item3.displayItem();
        
        System.out.println("Total cost for 3 water bottles: " + item1.calculateTotalCost(3));
    }
}