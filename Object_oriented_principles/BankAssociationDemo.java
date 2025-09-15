import java.util.*;

class Customer {
    String name;
    double balance;

    Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void viewBalance() {
        System.out.println(name + "'s balance: " + balance);
    }
}

class Bank {
    String bankName;
    List<Customer> customers = new ArrayList<>();

    Bank(String bankName) {
        this.bankName = bankName;
    }

    void openAccount(Customer c) {
        customers.add(c);
        System.out.println("Account opened for " + c.name + " in " + bankName);
    }

    void showCustomers() {
        System.out.println("Customers of " + bankName + ":");
        for (Customer c : customers) {
            System.out.println("- " + c.name);
        }
    }
}

public class BankAssociationDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");

        Customer c1 = new Customer("Pragati", 5000);
        Customer c2 = new Customer("Unnati", 7000);

        bank.openAccount(c1);
        bank.openAccount(c2);

        c1.viewBalance();
        c2.viewBalance();

        bank.showCustomers();
    }
}
