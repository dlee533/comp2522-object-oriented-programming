package ca.bcit.comp2522.assignments.a2;


import java.util.*;

/**
 * Pool class that creates, stores, and manage guppy objects.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Pool {
    /**
     * Default pool name.
     */
    public static final String DEFAULT_POOL_NAME = "Unnamed";
    /**
     * Default pool temperature in celsius.
     */
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;
    /**
     * Minimum pool temperature in celsius.
     */
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;
    /**
     * Maximum pool temperature in celsius.
     */
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
    /**
     * Neutral pH.
     */
    public static final double NEUTRAL_PH = 7.0;
    /**
     * Default nutrient coefficient.
     */
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
    /**
     * Minimum nutrient coefficient.
     */
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
    /**
     * Maximum nutrient coefficient.
     */
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

    private static int numberOfPools = 0;
    private static int count = 0;

    private final String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private final int identificationNumber;
    private final ArrayList<Guppy> guppiesInPool;
    private final Random randomNumberGenerator;

    /**
     * Zero parameter constructor for pool class.
     */
    public Pool() {
        this(DEFAULT_POOL_NAME, 0.0, DEFAULT_POOL_TEMP_CELSIUS, NEUTRAL_PH,
                DEFAULT_NUTRIENT_COEFFICIENT);
    }

    /**
     * Multi parameter constructor for pool class.
     *
     * @param name String name
     * @param volumeLitres double volume in litres
     * @param temperatureCelsius double temperature in cesius
     * @param pH double pH
     * @param nutrientCoefficient double nutrient coefficient
     * @throws IllegalArgumentException when arguments are invalid
     */
    public Pool(String name, final double volumeLitres, final double temperatureCelsius,
                final double pH, final double nutrientCoefficient) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        name = name.trim();
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
        final byte pHLowerBound = 0;
        final byte pHUpperBound = 14;
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.volumeLitres = volumeLitres >= 0 ? volumeLitres : 0;
        this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS <= temperatureCelsius
                && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS ? temperatureCelsius
                : DEFAULT_POOL_TEMP_CELSIUS;
        this.pH = pHLowerBound <= pH && pH <= pHUpperBound ? pH : NEUTRAL_PH;
        this.nutrientCoefficient = 0 <= nutrientCoefficient && nutrientCoefficient <= 1
                ? nutrientCoefficient : DEFAULT_NUTRIENT_COEFFICIENT;
        this.guppiesInPool = new ArrayList<>();
        randomNumberGenerator = new Random();
        this.identificationNumber = ++count;
        numberOfPools++;
    }

    /**
     * Getter/Accessor for name.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter/Accessor for volumeLitres.
     *
     * @return double volumeLitres
     */
    public double getVolumeLitres() {
        return volumeLitres;
    }

    /**
     * Getter/Accessor for temperatureCelsius.
     *
     * @return double temperatureCelsius
     */
    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * Getter/Accessor for pH.
     *
     * @return double pH
     */
    public double getPH() {
        return pH;
    }

    /**
     * Getter/Accessor for nutrientCoefficient.
     *
     * @return double nutrientCoefficient
     */
    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    /**
     * Getter/Accessor for identificationNumber.
     *
     * @return int identificationNumber
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Getter/Accessor for numberOfPools.
     *
     * @return int numberOfPools
     */
    public static int getNumberCreated() {
        return numberOfPools;
    }

    /**
     * Setter/Mutator for volumeLitres.
     *
     * @param volumeLitres double
     */
    public void setVolumeLitres(final double volumeLitres) {
        if (volumeLitres >= 0) {
            this.volumeLitres = volumeLitres;
        }
    }

    /**
     * Setter/Mutator for temperatureCelsius.
     *
     * @param temperatureCelsius double
     */
    public void setTemperatureCelsius(final double temperatureCelsius) {
        if (temperatureCelsius >= MINIMUM_POOL_TEMP_CELSIUS
                && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = temperatureCelsius;
        }
    }

    /**
     * Setter/Mutator for pH.
     *
     * @param pH double
     */
    public void setPH(final double pH) {
        final byte pHLowerBound = 0;
        final byte pHUpperBound = 14;
        if (pH >= pHLowerBound && pH <= pHUpperBound) {
            this.pH = pH;
        }
    }

    /**
     * Setter/Mutator for nutrientCoefficient.
     *
     * @param nutrientCoefficient double
     */
    public void setNutrientCoefficient(final double nutrientCoefficient) {
        if (nutrientCoefficient >= MINIMUM_NUTRIENT_COEFFICIENT && nutrientCoefficient
                <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = nutrientCoefficient;
        }
    }

    /**
     * Change nutrient coefficient by delta.
     *
     * @param delta double
     */
    public void changeNutrientCoefficient(final double delta) {
        this.nutrientCoefficient += delta;
        if (this.nutrientCoefficient < MINIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;
        } else if (this.nutrientCoefficient > MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;
        }
    }

    /**
     * Change temperature by delta.
     *
     * @param delta double
     */
    public void changeTemperature(final double delta) {
        this.temperatureCelsius += delta;
        if (this.temperatureCelsius < MINIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
        } else if (this.temperatureCelsius > MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        }
    }

    /**
     * Add guppy to the arrayList.
     *
     * @param guppy a guppy of Guppy class
     * @return boolean value depending on whether guppy has been successfully
     * added to the arrayList or not
     */
    public boolean addGuppy(final Guppy guppy) {
        if (guppy == null) {
            return false;
        }
        this.guppiesInPool.add(guppy);
        return true;
    }

    /**
     * Get population of live guppies in a pool.
     *
     * @return population of alive guppies
     */
    public int getPopulation() {
        int aliveGuppyCount = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                aliveGuppyCount++;
            }
        }
        return aliveGuppyCount;
    }

    /**
     * Randomly kill guppies.
     *
     * @return number of guppies that have died
     */
    public int applyNutrientCoefficient() {
        Iterator<Guppy> iter = guppiesInPool.iterator();
        int numberOfDeadGuppies = 0;
        while (iter.hasNext()) {
            Guppy guppy = iter.next();
            if (randomNumberGenerator.nextDouble() > nutrientCoefficient) {
                guppy.setIsAlive(false);
                numberOfDeadGuppies++;
            }
        }
        return numberOfDeadGuppies;
    }

    /**
     * Remove dead guppies from the pool.
     *
     * @return the number of guppies removed from the pool
     */
    public int removeDeadGuppies() {
        Iterator<Guppy> iter = guppiesInPool.iterator();
        int numberOfGuppiesRemoved = 0;
        while (iter.hasNext()) {
            Guppy guppy = iter.next();
            if (!guppy.getIsAlive()) {
                iter.remove();
                numberOfGuppiesRemoved++;
            }
        }
        return numberOfGuppiesRemoved;
    }

    /**
     * Get guppy volume requirement in litres.
     *
     * @return volume requirement in litres
     */
    public double getGuppyVolumeRequirementInLitres() {
        final int millilitresInLitres = 1000;
        int totalVolumeRequirementInMillilitres = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                totalVolumeRequirementInMillilitres += guppy.getVolumeNeeded();
            }
        }
        return (double) totalVolumeRequirementInMillilitres / millilitresInLitres;
    }

    /**
     * Get average age in weeks.
     *
     * @return average age of live guppies in weeks
     */
    public double getAverageAgeInWeeks() {
        int totalAgeInWeeks = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                totalAgeInWeeks += guppy.getAgeInWeeks();
            }
        }
        return getPopulation() != 0 ? (double) totalAgeInWeeks / getPopulation()
                : (double) totalAgeInWeeks;
    }

    /**
     * Get average health coefficient of live guppies.
     *
     * @return double, average health coefficient of live guppies
     */
    public double getAverageHealthCoefficient() {
        double totalHealthCoefficient = 0.0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                totalHealthCoefficient += guppy.getHealthCoefficient();
            }
        }
        return getPopulation() != 0 ? totalHealthCoefficient / getPopulation()
                : totalHealthCoefficient;
    }

    /**
     * Get female ratio.
     *
     * @return the female percentage in double
     */
    public double getFemalePercentage() {
        int numberOfFemaleGuppies = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive() && guppy.getIsFemale()) {
                numberOfFemaleGuppies++;
            }
        }
        return getPopulation() > 0 ? (double) numberOfFemaleGuppies / getPopulation() : 0.0;
    }

    /**
     * Get median age.
     *
     * @return the median age in double
     */
    public double getMedianAge() {
        int middlePoint = 2;
        int[] ageArray = new int[getPopulation()];
        int index = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                ageArray[index] = guppy.getAgeInWeeks();
                index++;
            }
        }
        Arrays.sort(ageArray);
        if (Double.compare(0.0, (double) getPopulation() / middlePoint) == 0) {
            return (double) (ageArray[getPopulation() / middlePoint]
                    + ageArray[getPopulation() / middlePoint + 1]) / middlePoint;
        }
        return ageArray[getPopulation() / 2];
    }

    /**
     * Spawn random number of guppies.
     *
     * @return the total number of new guppies in int form
     */
    public int spawn() {
        int totalNumberOfNewGuppies = 0;
        int totalGuppyPopulation = getPopulation();
        for (int index = 0; index < totalGuppyPopulation; index++) {
            Guppy currentGuppy = guppiesInPool.get(index);
            ArrayList<Guppy> newBabies = currentGuppy.spawn();
            if (newBabies != null) {
                totalNumberOfNewGuppies += newBabies.size();
                guppiesInPool.addAll(newBabies);
            }
        }
        return totalNumberOfNewGuppies;
    }

    /**
     * Increment the age of guppies by one.
     *
     * @return the number of guppies died of old age
     */
    public int incrementAges() {
        int numberOfGuppiesDiedOfOldAge = 0;
        for (Guppy guppy : guppiesInPool) {
            guppy.incrementAge();
            if (!guppy.getIsAlive()) {
                numberOfGuppiesDiedOfOldAge += 1;
            }
        }
        return numberOfGuppiesDiedOfOldAge;
    }

    /**
     * Adjust for crowding.
     *
     * @return number of guppies crowded out in int form
     */
    public int adjustForCrowding() {
        int numberOfGuppiesCrowdedOut = 0;
        guppiesInPool.sort(new GuppyHealthCoefficientComparator());
        while (getGuppyVolumeRequirementInLitres() > getVolumeLitres()) {
            guppiesInPool.get(numberOfGuppiesCrowdedOut++).setIsAlive(false);
        }
        return numberOfGuppiesCrowdedOut;
    }

    /**
     * Equals method for pool class.
     *
     * @param o an object
     * @return the boolean value as to whether the argument is equal to current object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pool pool = (Pool) o;

        if (Double.compare(pool.volumeLitres, volumeLitres) != 0) {
            return false;
        }
        if (Double.compare(pool.temperatureCelsius, temperatureCelsius) != 0) {
            return false;
        }
        if (Double.compare(pool.pH, pH) != 0) {
            return false;
        }
        if (Double.compare(pool.nutrientCoefficient, nutrientCoefficient) != 0) {
            return false;
        }
        if (identificationNumber != pool.identificationNumber) {
            return false;
        }
        if (!Objects.equals(name, pool.name)) {
            return false;
        }
        if (!Objects.equals(guppiesInPool, pool.guppiesInPool)) {
            return false;
        }
        return Objects.equals(randomNumberGenerator, pool.randomNumberGenerator);
    }

    /**
     * HashCode method for pool class.
     *
     * @return the hashCode in int
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(volumeLitres);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(temperatureCelsius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pH);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(nutrientCoefficient);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + identificationNumber;
        result = 31 * result + (guppiesInPool != null ? guppiesInPool.hashCode() : 0);
        result = 31 * result + (randomNumberGenerator != null
                ? randomNumberGenerator.hashCode() : 0);
        return result;
    }

    /**
     * ToString method for pool class.
     *
     * @return the specialized toString in String format
     */
    @Override
    public String toString() {
        return "Pool{"
                + "name='" + name + '\''
                + ", volumeLitres=" + volumeLitres
                + ", temperatureCelsius=" + temperatureCelsius
                + ", pH=" + pH
                + ", nutrientCoefficient=" + nutrientCoefficient
                + ", identificationNumber=" + identificationNumber
                + ", guppiesInPool=" + guppiesInPool
                + ", randomNumberGenerator=" + randomNumberGenerator
                + '}';
    }
}
