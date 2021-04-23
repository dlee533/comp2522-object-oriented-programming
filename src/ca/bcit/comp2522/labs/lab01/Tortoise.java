package ca.bcit.comp2522.labs.lab01;

/**
 * Tortoise class.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Tortoise {
    private int position = 0;

    private void setPosition(int position) {
        this.position = position;
    }

    /**
     * Returns the position value.
     *
     * @return position of the object
     */
    public int getPosition() {
        return position;
    }

    /**
     * Moves the position depending on the randomly generated number.
     *
     * @return the changed position in int type
     */
    public int move() {
        final byte percentage = 100;

        final byte chanceFastPlod = 50;
        final byte chanceSlip = 70;

        final byte fastPlod = 3;
        final byte slip = -6;
        final byte slowPlod = 1;

        double randomNumber = Math.random() * percentage;

        if (randomNumber < chanceFastPlod) {
            setPosition(position + fastPlod);
        } else if (randomNumber < chanceSlip) {
            setPosition(position + slip);
        } else {
            setPosition(position + slowPlod);
        }
        return position;
    }

    /**
     * Resets the position to zero.
     */
    public void resetPosition() {
        setPosition(0);
    }

    /**
     * Compares the current object to the object accepted as an argument to see if they are equal.
     *
     * @param o an object
     * @return a boolean value representing whether the objects being compared are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tortoise tortoise = (Tortoise) o;

        return position == tortoise.position;
    }

    /**
     * Returns the class name and position value.
     *
     * @return the class name and position value in string format
     */
    @Override
    public String toString() {
        return "Tortoise{" + "position=" + position + '}';
    }
}
