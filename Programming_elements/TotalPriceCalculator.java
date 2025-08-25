import java.util.Scanner;

public class TotalPriceCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter the unit price of the item (INR): ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter the quantity to be bought: ");
        int quantity = sc.nextInt();

        // Calculating total price
        double totalPrice = unitPrice * quantity;

        // Output
        System.out.println("The total purchase price is INR " + totalPrice +
                           " if the quantity " + quantity + " and unit price is INR " + unitPrice);

        sc.close();
    }
}