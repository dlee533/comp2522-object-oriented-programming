package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ecosystem class that creates, stores, and manage pool objects.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Ecosystem {

    private static int weekNumber = 1;

    private ArrayList<Pool> pools;

    /**
     * Empty parameter constructor for Ecosystem class.
     */
    public Ecosystem() {
        pools = new ArrayList<>();
    }

    /**
     * Add pool to the pool arrayList.
     *
     * @param newPool an object of Pool class
     */
    public void addPool(final Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    /**
     * Clears the pool.
     */
    public void reset() {
        pools.clear();
    }

    /**
     * Get the guppy population.
     *
     * @return total alive guppies in a pool
     */
    public int getGuppyPopulation() {
        int totalGuppies = 0;
        for (Pool pool : pools) {
            totalGuppies += pool.getPopulation();
        }
        return totalGuppies;
    }

    /**
     * Adjust the pool for crowding.
     *
     * @return the number of guppies crowded out
     */
    public int adjustForCrowding() {
        int totalGuppiesCrowdedOut = 0;
        for (Pool pool : pools) {
            totalGuppiesCrowdedOut += pool.adjustForCrowding();
        }
        return totalGuppiesCrowdedOut;
    }

    private void generateGuppies(final Pool pool,
                                 final int numberOfGuppies,
                                 final String genus,
                                 final String species,
                                 final int ageInWeeksLowerBound,
                                 final int ageInWeeksUpperBound,
                                 final double healthCoefficientLowerBound,
                                 final double healthCoefficientUpperBound,
                                 final double femaleChance) {
        final Random randomGenerator = new Random();
        int percentage = 100;
        for (int count = 0; count < numberOfGuppies; count++) {
            int randomAgeInWeeks = randomGenerator.nextInt(ageInWeeksUpperBound
                    - ageInWeeksLowerBound + 1) + ageInWeeksLowerBound;
            double randomHealthCoefficient = randomGenerator.nextDouble()
                    * (healthCoefficientUpperBound - healthCoefficientLowerBound)
                    + healthCoefficientLowerBound;
            boolean isFemale = randomGenerator.nextInt(percentage)  < femaleChance;
            Guppy guppy = new Guppy(genus, species, randomAgeInWeeks,
                    isFemale, 0, randomHealthCoefficient);
            pool.addGuppy(guppy);
        }
    }

    /**
     * Set up simulation.
     */
    public void setupSimulation() {
        String firstPoolName = "Skookumchuk";
        String secondPoolName = "Squamish";
        String thirdPoolName = "Semiahmoo";

        int firstPoolVolumeLitres = 3000;
        int secondPoolVolumeLitres = 15000;
        int thirdPoolVolumeLitres = 4500;

        int firstPoolTemperatureCelsius = 42;
        int secondPoolTemperatureCelsius = 39;
        int thirdPoolTemperatureCelsius = 37;

        double firstPoolPH = 7.9;
        double secondPoolPH = 7.7;
        double thirdPoolPH = 7.5;

        double firstPoolNutrientCoefficient = 0.9;
        double secondPoolNutrientCoefficient = 0.85;
        double thirdPoolNutrientCoefficient = 1.0;

        Pool firstPool = new Pool(firstPoolName, firstPoolVolumeLitres,
                firstPoolTemperatureCelsius, firstPoolPH, firstPoolNutrientCoefficient);
        addPool(firstPool);
        Pool secondPool = new Pool(secondPoolName, secondPoolVolumeLitres,
                secondPoolTemperatureCelsius, secondPoolPH, secondPoolNutrientCoefficient);
        addPool(secondPool);
        Pool thirdPool = new Pool(thirdPoolName, thirdPoolVolumeLitres,
                thirdPoolTemperatureCelsius, thirdPoolPH, thirdPoolNutrientCoefficient);
        addPool(thirdPool);

        String genus = "Poecilia";
        String species = "reticulata";

        final int numberOfGuppiesInFirstPool = 300;
        final int numberOfGuppiesInSecondPool = 100;
        final int numberOfGuppiesInThirdPool = 200;

        final int ageInWeeksLowerBoundInFirstPool = 10;
        final int ageInWeeksLowerBoundInSecondPool = 10;
        final int ageInWeeksLowerBoundInThirdPool = 15;

        final int ageInWeeksUpperBoundInFirstPool = 25;
        final int ageInWeeksUpperBoundInSecondPool = 15;
        final int ageInWeeksUpperBoundInThirdPool = 49;

        final double healthCoefficientLowerBoundInFirstPool = 0.5;
        final double healthCoefficientLowerBoundInSecondPool = 0.8;
        final double healthCoefficientLowerBoundInThirdPool = 0.0;

        final double healthCoefficientUpperBoundInFirstPool = 0.8;
        final double healthCoefficientUpperBoundInSecondPool = 1.0;
        final double healthCoefficientUpperBoundInThirdPool = 1.0;

        final double femaleChanceInFirstPool = 75;
        final double femaleChanceInSecondPool = 75;
        final double femaleChanceInThirdPool = 35;

        generateGuppies(firstPool, numberOfGuppiesInFirstPool, genus, species,
                ageInWeeksLowerBoundInFirstPool, ageInWeeksUpperBoundInFirstPool,
                healthCoefficientLowerBoundInFirstPool, healthCoefficientUpperBoundInFirstPool,
                femaleChanceInFirstPool);

        generateGuppies(secondPool, numberOfGuppiesInSecondPool, genus, species,
                ageInWeeksLowerBoundInSecondPool, ageInWeeksUpperBoundInSecondPool,
                healthCoefficientLowerBoundInSecondPool, healthCoefficientUpperBoundInSecondPool,
                femaleChanceInSecondPool);

        generateGuppies(thirdPool, numberOfGuppiesInThirdPool, genus, species,
                ageInWeeksLowerBoundInThirdPool, ageInWeeksUpperBoundInThirdPool,
                healthCoefficientLowerBoundInThirdPool, healthCoefficientUpperBoundInThirdPool,
                femaleChanceInThirdPool);
    }

    /**
     * Simulate.
     *
     * @param numberOfWeeks the number of weeks to simulate
     */
    public void simulate(final int numberOfWeeks) {
        for (int currentWeek = 0; currentWeek < numberOfWeeks; currentWeek++) {
            simulateOneWeek();
        }
    }

    /**
     * Simulate one week.
     */
    public void simulateOneWeek() {
        int diedOfOldAge = 0;
        int numberRemoved = 0;
        int starvedToDeath = 0;
        int newFry = 0;
        int crowdedOut = 0;

        for (Pool pool : pools) {
            diedOfOldAge += pool.incrementAges();
            numberRemoved += pool.removeDeadGuppies();
            starvedToDeath += pool.applyNutrientCoefficient();
            numberRemoved += pool.removeDeadGuppies();
            newFry += pool.spawn();
            crowdedOut += adjustForCrowding();
            numberRemoved += pool.removeDeadGuppies();
        }

        if (diedOfOldAge + starvedToDeath + crowdedOut != numberRemoved) {
            System.out.println("diedOfOldAge + starvedToDeath + crowdedOut != numberRemoved");
            return;
        }

        System.out.println("Week " + weekNumber++);
        System.out.println("Number of deaths this week due to old age: " + diedOfOldAge);
        System.out.println("Number of deaths this week due to starvation: " + starvedToDeath);
        System.out.println("Number of deaths this week due to overcrowding: " + crowdedOut);
        System.out.println("Number of births this week: " + newFry);

        System.out.println("Pools:");
        for (Pool pool : pools) {
            System.out.println(pool.getName() + " - " + pool.getPopulation());
        }
        System.out.println("Total population of the Ecosystem this week: " + getGuppyPopulation());
        System.out.println();
    }
}
