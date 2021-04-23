package ca.bcit.comp2522.labs.lab04;

public class RegularPolygon extends Polygon {

    private double length;
    private double apothem;

    public RegularPolygon(int numberOfSides) {
        super(numberOfSides);
    }

    @Override
    public void draw() {

    }

    @Override
    public double getArea() {
        return 0.5 * apothem * getPerimeter();
    }

    @Override
    public double getPerimeter() {
        return length * numberOfSides;
    }
}
