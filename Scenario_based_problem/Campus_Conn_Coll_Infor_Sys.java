interface ICourse {
    void enroll(String c);
    void drop(String c);
}

class Person {
    protected String nm, em;
    protected int id;
    Person(String n,String e,int i){ nm=n; em=e; id=i; }
    public void printDetails(){}
}

class Student extends Person implements ICourse {
    private double gpa;
    Student(String n,String e,int i){ super(n,e,i); }
    public void enroll(String c){}
    public void drop(String c){}
    public void setGpa(double g){ gpa=g; }
    public double getGpa(){ return gpa; }
    public void printDetails(){ System.out.println("Stu: "+nm+" "+gpa); }
}

class Faculty extends Person implements ICourse {
    Faculty(String n,String e,int i){ super(n,e,i); }
    public void enroll(String c){}
    public void drop(String c){}
    public void printDetails(){ System.out.println("Fac: "+nm); }
}

class Course {
    private String cn;
    private Faculty f;
    private java.util.List<Student> sl = new java.util.ArrayList<>();
    Course(String n, Faculty t){ cn=n; f=t; }
    public void addStu(Student s){ sl.add(s); }
}
