// File: WalletDemo.java
import java.util.*;

interface Transferrable {
    boolean transferTo(User receiver, double amount);
}

class Transaction {
    private final Date time;
    private final String from;
    private final String to;
    private final double amount;

    public Transaction(String from, String to, double amount) {
        this.time = new Date();
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String toString() {
        return String.format("[%s] %s -> %s : ₹%.2f", time, from, to, amount);
    }
}

abstract class Wallet implements Transferrable {
    protected String ownerId;
    private double balance;
    protected List<Transaction> history = new ArrayList<>();

    public Wallet(String ownerId) {
        this(ownerId, 0.0);
    }

    public Wallet(String ownerId, double openingBalance) {
        this.ownerId = ownerId;
        this.balance = openingBalance;
    }

    public double getBalance() { // safe read
        return balance;
    }

    protected void changeBalance(double delta) { // controlled mutation
        balance += delta;
        if (balance < 0) balance = 0; // simple guard
    }

    public List<Transaction> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public boolean transferTo(User receiverUser, double amount) {
        Wallet receiver = receiverUser.getWallet();
        if (amount <= 0 || amount > this.balance) return false;
        double fee = calculateFee(amount);
        double totalDeduct = amount + fee;
        changeBalance(-totalDeduct);
        receiver.changeBalance(amount);
        Transaction tx = new Transaction(ownerId, receiver.ownerId, amount);
        history.add(tx);
        receiver.history.add(tx);
        return true;
    }

    protected abstract double calculateFee(double amount);
}

class PersonalWallet extends Wallet {
    public PersonalWallet(String ownerId, double openingBalance) { super(ownerId, openingBalance); }

    @Override
    protected double calculateFee(double amount) {
        return amount * 0.005; // 0.5%
    }
}

class BusinessWallet extends Wallet {
    public BusinessWallet(String ownerId, double openingBalance) { super(ownerId, openingBalance); }

    @Override
    protected double calculateFee(double amount) {
        return Math.max(10.0, amount * 0.002); // lower %, minimum fee
    }
}

class User {
    private String userId;
    private String name;
    private Wallet wallet;

    public User(String userId, String name, Wallet wallet) {
        this.userId = userId;
        this.name = name;
        this.wallet = wallet;
    }

    public Wallet getWallet() { return wallet; }

    public void printBalance() {
        System.out.printf("%s balance: ₹%.2f%n", name, wallet.getBalance());
    }
}

public class WalletDemo {
    public static void main(String[] args) {
        User u1 = new User("U1", "Suman", new PersonalWallet("U1", 1000));
        User u2 = new User("U2", "Priya", new BusinessWallet("U2", 5000));

        u1.printBalance();
        u2.printBalance();

        boolean ok = u1.getWallet().transferTo(u2, 200);
        System.out.println("Transfer success: " + ok);

        u1.printBalance();
        u2.printBalance();

        // print transaction logs
        for (Transaction t : u1.getWallet().getHistory()) System.out.println(t);
    }
}
