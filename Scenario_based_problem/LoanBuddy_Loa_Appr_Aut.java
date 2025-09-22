interface IApp {
    boolean approve();
    double calcEmi();
}

class Applicant {
    private String nm;
    private int cs;
    private double inc, amt;
    Applicant(String n,int c,double i,double a){ nm=n; cs=c; inc=i; amt=a; }
    protected int getCs(){ return cs; }
    protected double getAmt(){ return amt; }
    protected double getInc(){ return inc; }
}

class LoanApp implements IApp {
    protected String lt;
    protected int term;
    protected double r;
    protected Applicant ap;
    LoanApp(String t,int tm,double rt,Applicant a){ lt=t; term=tm; r=rt; ap=a; }
    public boolean approve(){ return ap.getCs()>650 && ap.getInc()>ap.getAmt()/term; }
    public double calcEmi(){
        double P=ap.getAmt(), R=r/1200, N=term;
        return P*R*Math.pow(1+R,N)/(Math.pow(1+R,N)-1);
    }
}

class HomeLoan extends LoanApp {
    HomeLoan(int tm,double rt,Applicant a){ super("Home",tm,rt,a); }
    public double calcEmi(){ return super.calcEmi()*0.95; }
}

class AutoLoan extends LoanApp {
    AutoLoan(int tm,double rt,Applicant a){ super("Auto",tm,rt,a); }
    public double calcEmi(){ return super.calcEmi()*1.05; }
}
