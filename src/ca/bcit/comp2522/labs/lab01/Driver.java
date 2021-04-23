package ca.bcit.comp2522.labs.lab01;

/**
 * Simulates the races to compare the number of wins: tortoise wins the most.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Driver {
    private static String simulateRaces(final int numberOfRaces, final int length) {
        Race race = new Race(length);
        int countHareWin = 0;
        int countTortoiseWin = 0;
        for (int round = 0; round < numberOfRaces; round++) {
            String winner = race.simulateRace();
            if (winner.equals("Hare")) {
                countHareWin++;
            } else {
                countTortoiseWin++;
            }
        }
        return "Hare won " + countHareWin + " times.\n"
                + "Tortoise won " + countTortoiseWin + " times.";
    }

    /**
     * Simulates the races.
     *
     * @param args default parameter for main method
     */
    public static void main(String[] args) {
        final int numberOfRaces = 100;
        final int raceLength1 = 100;
        final int raceLength2 = 1000;

        System.out.println("First Race:");
        Race race = new Race(raceLength1);
        System.out.println("Winner: " + race.simulateRace());
        System.out.println(race.raceInfo());
        System.out.println();

        System.out.println("Second Race:");
        System.out.println(simulateRaces(numberOfRaces, raceLength1));
        System.out.println();

        System.out.println("Third Race:");
        System.out.println(simulateRaces(numberOfRaces, raceLength2));
    }
}
