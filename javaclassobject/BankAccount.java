public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount to deposit must be positive");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Amount to withdraw must be positive");
        }
    }
    
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
    
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        displayBalance();
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Lynda", "123456789", 700.00);
        
        System.out.println("Initial Account Details:");
        account.displayAccountDetails();
        System.out.println();
        
        account.deposit(200.00);
        account.displayBalance();
        System.out.println();
        
        account.withdraw(100.00);
        account.displayBalance();
        System.out.println();
        
        account.withdraw(900.00);
        account.displayBalance();
    }
}