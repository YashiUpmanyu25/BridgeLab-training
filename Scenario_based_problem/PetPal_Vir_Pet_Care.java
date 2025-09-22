interface IAct {
    void feed();
    void play();
    void sleep();
}

class Pet {
    protected String nm,tp;
    protected int ag;
    private int hunger=50, mood=50;
    Pet(String n,String t,int a){ nm=n; tp=t; ag=a; }
    protected void setH(int v){ hunger=v; }
    protected void setM(int v){ mood=v; }
    protected int getH(){ return hunger; }
    protected int getM(){ return mood; }
    public void makeSound(){}
}

class Dog extends Pet implements IAct {
    Dog(String n,int a){ super(n,"Dog",a); }
    public void feed(){ setH(getH()-10); }
    public void play(){ setM(getM()+15); }
    public void sleep(){ setM(getM()+5); }
    public void makeSound(){ System.out.println("Woof"); }
}

class Cat extends Pet implements IAct {
    Cat(String n,int a){ super(n,"Cat",a); }
    public void feed(){ setH(getH()-8); }
    public void play(){ setM(getM()+12); }
    public void sleep(){ setM(getM()+6); }
    public void makeSound(){ System.out.println("Meow"); }
}

class Bird extends Pet implements IAct {
    Bird(String n,int a){ super(n,"Bird",a); }
    public void feed(){ setH(getH()-5); }
    public void play(){ setM(getM()+10); }
    public void sleep(){ setM(getM()+7); }
    public void makeSound(){ System.out.println("Chirp"); }
}
