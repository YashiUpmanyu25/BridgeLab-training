interface ISch {
    void sched();
    void resched(String d);
    void cancel();
}

class UserE {
    protected String nm;
    UserE(String n){ nm=n; }
}

class Event {
    protected String en, loc, dt;
    protected int att;
    private final int eid;
    private static int ctr=1;
    Event(String n,String l,String d,int a){ en=n; loc=l; dt=d; att=a; eid=ctr++; }
    public int getId(){ return eid; }
    public double cost(double v,double s,double dis){ return v+s-dis; }
}

class BDay extends Event implements ISch {
    BDay(String n,String l,String d,int a){ super(n,l,d,a); }
    public void sched(){ System.out.println("BD scheduled"); }
    public void resched(String d){ dt=d; }
    public void cancel(){ System.out.println("BD canceled"); }
}

class Conf extends Event implements ISch {
    Conf(String n,String l,String d,int a){ super(n,l,d,a); }
    public void sched(){ System.out.println("Conf scheduled"); }
    public void resched(String d){ dt=d; }
    public void cancel(){ System.out.println("Conf canceled"); }
}
