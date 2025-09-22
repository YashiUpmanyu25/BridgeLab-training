interface ICert {
    void genCert();
}

class User {
    protected String nm, em;
    protected int uid;
    User(String n,String e,int i){ nm=n; em=e; uid=i; }
}

class Learner extends User implements ICert {
    Learner(String n,String e,int i){ super(n,e,i); }
    public void genCert(){ System.out.println("Short Cert for "+nm); }
}

class Instructor extends User implements ICert {
    Instructor(String n,String e,int i){ super(n,e,i); }
    public void genCert(){ System.out.println("Full Cert by "+nm); }
}

class Quiz {
    private String[] qs;
    private String[] ans;
    private int sc;
    Quiz(String[] q,String[] a){ qs=q; ans=a; sc=0; }
    public void setScore(int s){ sc=s; }
    public double getPerc(){ return (sc*100.0)/qs.length; }
}
