interface ICheck {
    double genBill();
    double applyDisc(double c);
}

class Product {
    protected String nm, cat;
    protected double pr;
    Product(String n,String c,double p){ nm=n; cat=c; pr=p; }
}

class PerProd extends Product {
    PerProd(String n,String c,double p){ super(n,c,p); }
}

class NonPerProd extends Product {
    NonPerProd(String n,String c,double p){ super(n,c,p); }
}

class Cart implements ICheck {
    private java.util.List<Product> pl=new java.util.ArrayList<>();
    private double tot;
    Cart(){}
    Cart(java.util.List<Product> p){ pl.addAll(p); calc(); }
    public void add(Product p){ pl.add(p); calc(); }
    private void calc(){ tot=0; for(Product p:pl) tot+=p.pr; }
    public double genBill(){ return tot; }
    public double applyDisc(double c){ return tot-c; }
}
