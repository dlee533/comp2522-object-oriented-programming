package ca.bcit.comp2522.labs.lab04;

public class Rectangle extends Shape2D {

    private double width;
    private double height;

    public Rectangle(final double width, final double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {

    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }
}
