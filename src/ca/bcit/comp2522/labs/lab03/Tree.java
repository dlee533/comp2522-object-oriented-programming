package ca.bcit.comp2522.labs.lab03;

/**
 * Tree class, has type, ageInYears, circumferenceInCentimeter attributes.
 */
public class Tree {

    private Species type;
    private int ageInYears;
    private double circumferenceInCentimeter;

    /**
     * Enum type for species of tree.
     */
    public enum Species {
        MAPLE, ARBUTUS, BLUE_SPRUCE
    }

    /**
     * Constructor with two arguments, ageInYears, and circumferenceInCentimeter.
     *
     * @param ageInYears integer
     * @param circumferenceInCentimeter double
     */
    public Tree(final int ageInYears, final double circumferenceInCentimeter) {
        this(Species.MAPLE, ageInYears, circumferenceInCentimeter);
    }

    /**
     * Constructor with three arguments, type, ageInYears, circumferenceInCentimeter.
     *
     * @param type Species enum
     * @param ageInYears integer
     * @param circumferenceInCentimeter double
     */
    public Tree(final Species type, final int ageInYears, final double circumferenceInCentimeter) {
        if (ageInYears < 0 || circumferenceInCentimeter <0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        this.type = type;
        this.ageInYears = ageInYears;
        this.circumferenceInCentimeter = circumferenceInCentimeter;
    }

    /**
     * Tree ages a year.
     */
    public void grey() {
        ageInYears++;
    }

    /**
     * Setter/mutator for circumferenceInCentimeter.
     *
     * @param circumferenceInCentimeter double
     */
    public void setCircumferenceInCentimeter(final double circumferenceInCentimeter) {
        if (this.circumferenceInCentimeter < circumferenceInCentimeter) {
            this.circumferenceInCentimeter = circumferenceInCentimeter;
        }
    }

    /**
     * Getter/Accessor for type.
     *
     * @return Species type
     */
    public Species getType() {
        return type;
    }

    /**
     * Getter/Accessor for ageInYears.
     *
     * @return integer ageInYears
     */
    public int getAgeInYears() {
        return ageInYears;
    }

    /**
     * Getter/Accessor for circumferenceInCentimeter.
     *
     * @return double circumferenceInCentimeter
     */
    public double getCircumferenceInCentimeter() {
        return circumferenceInCentimeter;
    }

    /**
     * equals method.
     *
     * @param o an object
     * @return boolean value, whether this is equal to the object passed
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;

        if (ageInYears != tree.ageInYears) return false;
        if (Double.compare(tree.circumferenceInCentimeter, circumferenceInCentimeter) != 0) return false;
        return type == tree.type;
    }

    /**
     * hashCode method.
     *
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type.hashCode();
        result = 31 * result + ageInYears;
        temp = Double.doubleToLongBits(circumferenceInCentimeter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * toString method.
     *
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        return "Tree{" +
                "type=" + type +
                ", ageInYears=" + ageInYears +
                ", circumferenceInCentimeter=" + circumferenceInCentimeter +
                '}';
    }
}
