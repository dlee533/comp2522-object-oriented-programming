package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Guppy class.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Guppy {

    /**
     * Upper bound for young fish's age in weeks.
     */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;

    /**
     * Upper bound for mature fish's age in weeks.
     */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;

    /**
     * Maximum age of a fish in weeks.
     */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;

    /**
     * Minimum water volume in ml.
     */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /**
     * Default genus.
     */
    public static final String DEFAULT_GENUS = "Poecilia";

    /**
     * Default species.
     */
    public static final String DEFAULT_SPECIES = "reticulata";

    /**
     * Default health coefficient.
     */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /**
     * Minimum health coefficient.
     */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /**
     * Maximum health coefficient.
     */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    private static int numberOfGuppiesBorn = 0;

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;

    /**
     * Constructor for when the Guppy object is instantiated without argument.
     */
    public Guppy() {
        this(DEFAULT_GENUS, DEFAULT_SPECIES, 0, true, 0,
                DEFAULT_HEALTH_COEFFICIENT);
    }


    /**
     * Constructor for when the Guppy object is instantiated with arguments.
     *
     * @param newGenus genus of the fish in string
     * @param newSpecies species of the fish in string
     * @param newAgeInWeeks age of the fish in weeks in int
     * @param newIsFemale true if the fish is female, else false
     * @param newGenerationNumber the generation number in int
     * @param newHealthCoefficient health coefficient in double
     * @throws IllegalArgumentException if the arguments are invalid.
     */
    public Guppy(final String newGenus,
                 final String newSpecies,
                 final int newAgeInWeeks,
                 final boolean newIsFemale,
                 final int newGenerationNumber,
                 final double newHealthCoefficient) {
        if (!checkIfValid(newGenus, newSpecies, newAgeInWeeks, newGenerationNumber,
                newHealthCoefficient)) {
            throw new IllegalArgumentException();
        }
        genus = newGenus.trim().substring(0, 1).toUpperCase()
                + newGenus.trim().substring(1).toLowerCase();
        species = newSpecies.trim().toLowerCase();
        ageInWeeks = Math.max(newAgeInWeeks, 0);
        isFemale = newIsFemale;
        generationNumber = Math.max(newGenerationNumber, 0);
        setHealthCoefficient(newHealthCoefficient);
        if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT
                || healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT)
                    ? MINIMUM_HEALTH_COEFFICIENT : MAXIMUM_HEALTH_COEFFICIENT;
        }
        setIsAlive(true);

        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * Get genus.
     *
     * @return genus
     */
    public String getGenus() {
        return genus;
    }

    /**
     * Get species.
     *
     * @return species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Get age in weeks.
     *
     * @return ageInWeeks, an int
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Checks whether the fish is female.
     *
     * @return isFemale, true if the fish is female, else false.
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Get generation number.
     *
     * @return generation number in int
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Get the status of Fish.
     *
     * @return isAlive, true if the fish is alive, else false
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Get health coefficient.
     *
     * @return health coefficient in double
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Get identification number.
     *
     * @return identification number in int
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Get the number of guppies born.
     *
     * @return number of total guppies in int
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Change the age in weeks.
     *
     * @param ageInWeeks an integer representing the fish's age in weeks
     */
    public void setAgeInWeeks(int ageInWeeks) {
        if (ageInWeeks >= 0 && ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = ageInWeeks;
        }
    }

    /**
     * Change the status.
     *
     * @param alive a boolean. true if the fish is alive, else false
     */
    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Change the health coefficient.
     *
     * @param healthCoefficient a double representing the health of the fish
     */
    public void setHealthCoefficient(double healthCoefficient) {
        if (healthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT
                && healthCoefficient >= MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = healthCoefficient;
        }
    }

    private boolean checkIfValid(final String newGenus,
                                 final String newSpecies,
                                 final int newAgeInWeeks,
                                 final int newGenerationNumber,
                                 final double newHealthCoefficient) {
        return !(newGenus == null
                || newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS
                || newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT
                || newSpecies == null
                || newAgeInWeeks < 0
                || newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT
                || newGenerationNumber < 0
                || newGenus.isBlank()
                || newSpecies.isBlank());
    }

    /**
     * Increases the fish's age by one week, if the age is over the maximum, the fish dies.
     */
    public void incrementAge() {
        ageInWeeks++;
        if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            setIsAlive(false);
        }
    }

    /**
     * Get how many ml of water is needed depending on the age of the said fish.
     *
     * @return required water volume in double
     */
    public double getVolumeNeeded() {
        final double waterVolumeConstantForOldFish = 1.5;
        if (ageInWeeks < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (ageInWeeks <= MATURE_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * waterVolumeConstantForOldFish;
        } else {
            return 0.0;
        }
    }

    /**
     * Change the health coefficient by delta, if the health coefficient is too low, fish dies.
     *
     * @param delta a double
     */
    public void changeHealthCoefficient(final double delta) {
        if (getHealthCoefficient() + delta <= MINIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(MINIMUM_HEALTH_COEFFICIENT);
            setIsAlive(false);
        } else {
            setHealthCoefficient(Math.min(getHealthCoefficient() + delta,
                    MAXIMUM_HEALTH_COEFFICIENT));
        }
    }

    private boolean checkIfSpawnable() {
        final int spawnableAgeInWeeks = 8;
        return (this.isFemale && this.ageInWeeks >= spawnableAgeInWeeks);
    }

    public ArrayList<Guppy> spawn() {
        if (checkIfSpawnable()) {
            Random random = new Random();
            final ArrayList<Guppy> fryList = new ArrayList<>();
            if (random.nextInt(2) == 1) {
                final int upperBoundForNewFryNumber = 101;
                final int numberOfNewFry = random.nextInt(upperBoundForNewFryNumber);
                for (int count = 0; count < numberOfNewFry; count++) {
                    final boolean fryIsFemale = random.nextBoolean();
                    final double newHealthCoefficient = (1.0 + this.healthCoefficient) / 2.0;
                    Guppy fry = new Guppy(this.genus, this.species, 0, fryIsFemale,
                            this.generationNumber + 1, newHealthCoefficient);
                    fryList.add(fry);
                }
                return fryList;
            }
        }
        return null;
    }

    /**
     * Check whether current object is equal to object passed.
     *
     * @param o object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Guppy guppy = (Guppy) o;

        if (!genus.equals(guppy.genus)) {
            return false;
        }
        if (!species.equals(guppy.species)) {
            return false;
        }
        if (guppy.ageInWeeks != ageInWeeks) {
            return false;
        }
        if (guppy.isFemale != isFemale) {
            return false;
        }
        if (guppy.generationNumber != generationNumber) {
            return false;
        }
        if (guppy.isAlive != isAlive) {
            return false;
        }
        if (guppy.healthCoefficient == healthCoefficient) {
            return false;
        }
        return guppy.identificationNumber == identificationNumber;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = genus != null ? genus.hashCode() : 0;
        result = 31 * result + (species != null ? species.hashCode() : 0);
        result = 31 * result + ageInWeeks;
        result = 31 * result + (isFemale ? 1 : 0);
        result = 31 * result + generationNumber;
        result = 31 * result + (isAlive ? 1 : 0);
        temp = Double.doubleToLongBits(healthCoefficient);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + identificationNumber;
        return result;
    }

    /**
     * Return the values of each instance variables in guppy object.
     *
     * @return the formatted string with information about the current object
     */
    @Override
    public String toString() {
        return "Guppy{"
                + "genus='" + genus
                + ", species='" + species
                + ", ageInWeeks=" + ageInWeeks
                + ", isFemale=" + isFemale
                + ", generationNumber=" + generationNumber
                + ", isAlive=" + isAlive
                + ", healthCoefficient=" + healthCoefficient
                + ", identificationNumber=" + identificationNumber + '}';
    }
}
