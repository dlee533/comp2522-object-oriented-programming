package ca.bcit.comp2522.labs.lab04;

public class Circle extends Shape2D {

    private double radius;
    private final static double PI = 3.1415926535897932384626433;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {

    }

    @Override
    public double getArea() {
        return PI * PI * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
