package solidprinciples.openclosed;

interface Shape{
    double calculateArea();
}
class Circle1 implements Shape{
    private double radius;
    Circle1(double radius){
        this.radius=radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}
class Rectangle1 implements Shape{
    private double length, width;

    Rectangle1(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculateArea() {
        return length*width;
    }
}
class CalculateArea1{
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
public class OCPExample {
    public static void main(String[] args) {
    Shape circle=new Circle1(5);
    Shape rectangle=new Rectangle1(5,9);
    AreaCalculator areaCalculator=new AreaCalculator();
        System.out.println(areaCalculator.calculateArea(circle));
        System.out.println(areaCalculator.calculateArea(rectangle));

    }
}
/*
Open for Extension: Adding a new shape (e.g., Triangle) only requires creating a new class that implements Shape. No changes are needed in AreaCalculator.
Closed for Modification: The AreaCalculator class and existing shape classes remain unchanged.
No existing code needs to be modified. This is the power of adhering to the Open/Closed Principle!
 */