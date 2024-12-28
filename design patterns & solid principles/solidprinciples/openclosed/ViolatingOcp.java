package solidprinciples.openclosed;

import org.w3c.dom.css.Rect;

class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }
}

class Rectangle {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}

class AreaCalculator {
    // adding a new shape requires modification of calculatorArea method
    // so not following OCP principle which is open for extension closed for modification

    public double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius * circle.radius;
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.length * rectangle.width;
        }
        throw new IllegalArgumentException("Unknown shape");
    }
}

public class ViolatingOcp {
    public static void main(String[] args) {
        Circle circle=new Circle(5);
        Rectangle rectangle=new Rectangle(5,9);
        AreaCalculator calculator = new AreaCalculator();
        System.out.println( calculator.calculateArea(circle));
        System.out.println( calculator.calculateArea(rectangle));

    }
}
