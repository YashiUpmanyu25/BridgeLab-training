public class Circle {
    double radius;

    // Default constructor
    public Circle() {
        this(1.0); // calls parameterized constructor
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(5.0);

        System.out.println("Default Circle Area: " + c1.getArea());
        System.out.println("Circle with radius 5 Area: " + c2.getArea());
    }
}
