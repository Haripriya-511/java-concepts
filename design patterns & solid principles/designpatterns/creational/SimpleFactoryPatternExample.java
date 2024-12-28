package designpatterns.creational;
/*
. It encapsulates the object creation logic in a single class, making it easier to manage
You create a factory class that contains a method to create objects of different types based on input parameters.
The client only interacts with the factory, not the actual object constructors.
 */
// Product Interface
interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Simple Factory
class ShapeFactory {
    public static Shape createShape(String type) {
        if ("circle".equalsIgnoreCase(type)) {
            return new Circle();
        } else if ("rectangle".equalsIgnoreCase(type)) {
            return new Rectangle();
        } else if ("square".equalsIgnoreCase(type)) {
            return new Square();
        }
        throw new IllegalArgumentException("Unknown shape type");
    }
}



public class SimpleFactoryPatternExample {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.createShape("circle");
        shape1.draw();

        Shape shape2 = ShapeFactory.createShape("rectangle");
        shape2.draw();
    }
}
/*
The client doesn't instantiate objects directly.
Adding new types requires modifying the factory, which violates the Open/Closed Principle.

 */
