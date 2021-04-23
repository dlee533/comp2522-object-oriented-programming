package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;
import java.util.Random;

/**
 * Plantation class.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Plantation {
    private ArrayList<Tree> farm;

    /**
     * Constructor for Plantation object, initiates the arrayList.
     */
    public Plantation() {
        farm = new ArrayList<>();
    }

    /**
     * Returns the size of the arrayList.
     *
     * @return integer, size of the arrayList, farm
     */
    public int size() {
        return farm.size();
    }

    private int add(final Tree tree) {
        farm.add(tree);
        return size();
    }

    /**
     * Seed the random trees of random number.
     *
     * @return integer, the number of trees planted
     */
    public int seed() {
        final int rangeForNumberOfTrees = 991;
        final int lowerBoundForNumberOfTrees = 10;
        final int rangeForAgeInYears = 1001;
        final int rangeForCircumferenceInCentimeter = 90;
        final int lowerBoundForCircumferenceInCentimeter = 10;
        final Random random = new Random();
        final int randomNumber = random.nextInt(rangeForNumberOfTrees) + lowerBoundForNumberOfTrees;
        for (int i = 0; i <randomNumber; i++) {
            final int randomSpeciesChoice = random.nextInt(Tree.Species.values().length);
            final var randomSpecies = Tree.Species.values()[randomSpeciesChoice];
            final int randomAgeInYears = random.nextInt(rangeForAgeInYears);
            final double randomCircumferenceInCentimeter = (random.nextDouble() * rangeForCircumferenceInCentimeter)
                    + lowerBoundForCircumferenceInCentimeter;
            Tree tree = new Tree(randomSpecies, randomAgeInYears, randomCircumferenceInCentimeter);
            add(tree);
        }
        return randomNumber;
    }

    /**
     * Count the number of harvestable trees.
     *
     * @param cutOffCircumference double
     * @return integer, the number of harvestable trees
     */
    public int harvestCount(final double cutOffCircumference) {
        int count = 0;
        for (Tree tree: farm) {
            if (cutOffCircumference <= tree.getCircumferenceInCentimeter()) {
                count++;
            }
        }
        return count;
    }

    /**
     * equals method.
     *
     * @param o an object
     * @return boolean value, whether this is equal to the object passed
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Plantation that = (Plantation) o;

        return farm.equals(that.farm);
    }

    /**
     * hashCode method.
     *
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        return farm.hashCode();
    }

    /**
     * toString method.
     *
     * @return the string representation of the object
     */
    @Override
    public String
    toString() {
        return "Plantation{"
                + "farm=" + farm
                + '}';
    }
}