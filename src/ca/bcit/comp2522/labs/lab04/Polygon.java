package ca.bcit.comp2522.labs.lab04;

public abstract class Polygon extends Shape2D {
    protected int numberOfSides;

    public Polygon(final int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
}
