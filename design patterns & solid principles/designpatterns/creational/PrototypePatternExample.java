package designpatterns.creational;

interface Shapes {
    Shapes clone();
    void draw();
}
 class Circle1 implements Shapes {
    private int radius;

    public Circle1(int radius) {
        this.radius = radius;
    }

    // Implementing the clone method
    @Override
    public Shapes clone() {
        return new Circle1(this.radius);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    // Setter for customization
    public void setRadius(int radius) {
        this.radius = radius;
    }
}

class Rectangle1 implements Shapes {
    private int width;
    private int height;

    public Rectangle1(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Shapes clone() {
        return new Rectangle1(this.width, this.height);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width: " + width + " and height: " + height);
    }

    // Setters for customization
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}


public class PrototypePatternExample {
    public static void main(String[] args) {
        Circle1 originalCircle=new Circle1(10);
        Rectangle1 originalRectangle=new Rectangle1(20,30);

        Circle1 clonedCircle= (Circle1) originalCircle.clone();
        Rectangle1 clonedRectangle = (Rectangle1) originalRectangle.clone();

        System.out.println("Original objects...");
        originalCircle.draw();
        originalRectangle.draw();

        clonedCircle.setRadius(20);
        clonedRectangle.setHeight(40);
        clonedRectangle.setWidth(60);
        clonedCircle.draw();
        clonedRectangle.draw();
    }
}
/*
The Prototype Pattern is a creational design pattern used to create objects by copying or cloning an existing object, known as a prototype. This approach avoids the cost of creating objects from scratch when creating similar objects.
How It Works:
Instead of creating new instances, the client clones a pre-existing object.
The cloned object can be modified without affecting the original prototype.


The Shape interface extends Cloneable, which is a marker interface in Java.
However, Java's Cloneable is not mandatory; you can create your own clone method.
Each concrete class implements its own version of the clone method to handle how the object is copied.
Shallow copy: Copies only references (default clone() behavior).
Deep copy: Explicitly copies all fields to ensure independence from the original.


 */
