interface ITrans {
    void deposit(double a);
    void withdraw(double a);
    double checkBal();
}

class Account {
    protected String accNo;
    private double bal;
    Account(String id) {
        this.accNo = id;
        this.bal = 0;
    }
    Account(String id, double b) {
        this.accNo = id;
        this.bal = b;
    }
    protected void setBal(double b) { this.bal = b; }
    protected double getBal() { return bal; }
}

class SavAcc extends Account implements ITrans {
    private double r = 4;
    SavAcc(String id, double b) { super(id,b); }
    public void deposit(double a) { setBal(getBal()+a); }
    public void withdraw(double a) { if(getBal()>=a) setBal(getBal()-a); }
    public double checkBal() { return getBal(); }
    public double calcInt() { return getBal()*r/100; }
}

class CurAcc extends Account implements ITrans {
    private double r = 2;
    CurAcc(String id, double b) { super(id,b); }
    public void deposit(double a) { setBal(getBal()+a); }
    public void withdraw(double a) { if(getBal()>=a) setBal(getBal()-a); }
    public double checkBal() { return getBal(); }
    public double calcInt() { return getBal()*r/100; }
}
