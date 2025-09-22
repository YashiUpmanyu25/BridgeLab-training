// File: MyBankDemo.java
import java.util.*;

interface ITransaction {
    void deposit(double amount);
    boolean withdraw(double amount);
    double checkBalance();
}

abstract class Account implements ITransaction {
    protected String accountNumber;
    private double balance; // must be private
    public Account(String accountNumber) { this(accountNumber, 0.0); }
    public Account(String accountNumber, double opening) {
        this.accountNumber = accountNumber;
        this.balance = opening;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    @Override
    public double checkBalance() { return balance; }

    public abstract double calculateInterest(); // polymorphic
}

class SavingsAccount extends Account {
    private double rate = 4.0; // percent

    public SavingsAccount(String acct, double opening) { super(acct, opening); }

    @Override
    public double calculateInterest() {
        // simple yearly interest
        return checkBalance() * rate / 100.0;
    }
}

class CurrentAccount extends Account {
    private double rate = 1.0; // smaller interest or special rules

    public CurrentAccount(String acct, double opening) { super(acct, opening); }

    @Override
    public double calculateInterest() {
        // lower interest
        return checkBalance() * rate / 100.0;
    }
}

public class MyBankDemo {
    public static void main(String[] args) {
        Account s = new SavingsAccount("SA1001", 10000);
        Account c = new CurrentAccount("CA2001", 5000);

        s.deposit(2000);
        c.withdraw(1000);

        System.out.printf("Savings balance ₹%.2f interest ₹%.2f%n", s.checkBalance(), s.calculateInterest());
        System.out.printf("Current balance ₹%.2f interest ₹%.2f%n", c.checkBalance(), c.calculateInterest());
    }
}
