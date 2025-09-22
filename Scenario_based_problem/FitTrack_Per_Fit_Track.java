interface ITrack {
    void startW();
    void stopW();
}

class UProf {
    private String nm;
    private int ag;
    private double wt;
    private String gl;
    UProf(String n,int a,double w,String g){ nm=n; ag=a; wt=w; gl=g; }
    public double getWt(){ return wt; }
}

class Workout {
    protected String tp;
    protected int dur;
    protected double cal;
    Workout(String t,int d){ tp=t; dur=d; cal=0; }
    public double getCal(){ return cal; }
}

class Cardio extends Workout {
    Cardio(String t,int d){ super(t,d); }
    public void calc(){ cal=dur*8; }
}

class Strength extends Workout {
    Strength(String t,int d){ super(t,d); }
    public void calc(){ cal=dur*6; }
}
