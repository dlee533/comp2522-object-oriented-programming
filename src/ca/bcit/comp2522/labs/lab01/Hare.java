package ca.bcit.comp2522.labs.lab01;

/**Hare class.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Hare {
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

        final byte chanceSleeps = 20;
        final byte chanceBigHop = 30;
        final byte chanceBigSlip = 40;
        final byte chanceSmallHop = 70;

        final byte bigHop = 9;
        final byte bigSlip = -12;
        final byte smallHop = 1;
        final byte smallSlip = -2;

        double randomNumber = Math.random() * percentage;

        if (randomNumber < chanceSleeps) {
            setPosition(position);
        } else if (randomNumber < chanceBigHop) {
            setPosition(position + bigHop);
        } else if (randomNumber < chanceBigSlip) {
            setPosition(position + bigSlip);
        } else if (randomNumber < chanceSmallHop) {
            setPosition(position + smallHop);
        } else {
            setPosition(position + smallSlip);
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

        Hare hare = (Hare) o;

        return position == hare.position;
    }

    /**
     * Returns the class name and position value.
     *
     * @return the class name and position value in string format
     */
    @Override
    public String toString() {
        return "Hare{" + "position=" + position + '}';
    }
}
