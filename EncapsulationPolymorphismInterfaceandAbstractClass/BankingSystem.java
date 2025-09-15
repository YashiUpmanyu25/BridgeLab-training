import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String acc, String holder, double bal) {
        this.accountNumber = acc; this.holderName = holder; this.balance = bal;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String a) { accountNumber = a; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String h) { holderName = h; }

    public double getBalance() { return balance; }
    protected void setBalance(double b) { balance = b; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public abstract double calculateInterest();

    public void printSummary() {
        System.out.printf("Acc: %s, Holder: %s, Balance: %.2f%n", accountNumber, holderName, balance);
    }
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate; // annual percent

    public SavingsAccount(String acc, String holder, double bal, double rate) {
        super(acc, holder, bal);
        this.interestRate = rate;
    }

    @Override
    public double calculateInterest() {
        // simple interest example for 1 year
        return getBalance() * (interestRate / 100.0);
    }

    @Override
    public boolean applyForLoan(double amount) {
        // simple rule: must have balance >= 20% of loan
        return getBalance() >= 0.2 * amount;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // arbitrary multiplier
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String acc, String holder, double bal, double odLimit) {
        super(acc, holder, bal);
        this.overdraftLimit = odLimit;
    }

    @Override
    public double calculateInterest() {
        // current accounts may have minimal interest: 0
        return 0.0;
    }

    @Override
    public boolean applyForLoan(double amount) {
        // simpler rule: eligibility based on overdraft + balance
        return getBalance() + overdraftLimit >= 0.5 * amount;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() + overdraftLimit;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("S1001","Ravi",50000,4.0));
        accounts.add(new CurrentAccount("C2001","Meera",20000,10000));

        for (BankAccount a : accounts) {
            a.printSummary();
            System.out.printf("  Interest (1yr): %.2f%n", a.calculateInterest());
            if (a instanceof Loanable) {
                Loanable l = (Loanable) a;
                System.out.printf("  Loan Eligibility: %.2f, Can apply for 1L? %b%n",
                    l.calculateLoanEligibility(), l.applyForLoan(100000));
            }
            System.out.println("---");
        }
    }
}
