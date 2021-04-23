package ca.bcit.comp2522.labs.lab01;

/**
 * Race class.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Race {
    private Hare hare;
    private Tortoise tortoise;
    private int length;
    private int tick;

    /**
     * Constructs the object with new hare and tortoise objects and setting the length.
     *
     * @param length length of the race
     */
    public Race(int length) {
        hare = new Hare();
        tortoise = new Tortoise();
        this.length = length;
    }

    /**
     * Resets the position of hare and tortoise.
     */
    public void reset() {
        hare.resetPosition();
        tortoise.resetPosition();
    }

    /**
     * Resets then start the race.
     *
     * @return winner in string form
     */
    public String simulateRace() {
        reset();
        return race();
    }

    private String race() {
        tick = 0;
        do {
            tick++;
            int firstTurnPosition = Math.round(Math.random()) == 0 ? hare.move() : tortoise.move();
            if (firstTurnPosition >= length) {
                return hare.getPosition() >= length ? "Hare" : "Tortoise";
            }
        } while (hare.getPosition() < length && tortoise.getPosition() < length);
        return (hare.getPosition() > tortoise.getPosition() ? "Hare" : "Tortoise");
    }

    public String raceInfo() {
        return ("Tick: " + tick + "\n" + hare.toString() + "\n" + tortoise.toString());
    }
}
