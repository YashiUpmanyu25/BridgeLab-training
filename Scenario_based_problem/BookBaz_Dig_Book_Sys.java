interface IDisc {
    double disc(double d);
}

class Book {
    protected String t,a;
    protected double p;
    private int stk;
    Book(String tt,String au,double pr,int s){ t=tt;a=au;p=pr;stk=s; }
    public void updStk(int n){ stk+=n; }
    public int getStk(){ return stk; }
}

class EBook extends Book implements IDisc {
    EBook(String tt,String au,double pr,int s){ super(tt,au,pr,s); }
    public double disc(double d){ return p-d; }
}

class PBook extends Book implements IDisc {
    PBook(String tt,String au,double pr,int s){ super(tt,au,pr,s); }
    public double disc(double d){ return p-(d/2); }
}

class Order {
    private Book bk;
    private int qty;
    Order(Book b,int q){ bk=b; qty=q; }
    public double total(double d){ return (bk.p*qty)-d; }
}
