package ca.bcit.comp2522.assignments.a2;

import java.util.Comparator;

/**
 * Compares Guppies by age.
 *
 * @author BCIT
 * @version 2020
 */
public class GuppyHealthCoefficientComparator implements Comparator<Guppy> {

    /**
     * Compares the two provided Guppies.  Returns an integer whose
     * sign is based on their order.  In this case, if the Guppy passed
     * as the first parameter is younger, the method returns a negative
     * integer.
     * @param o1 a Guppy
     * @param o2 a Guppy
     * @return negative value if o1 < o2, 0 if o1 == o2, and positive if o1 > o2
     */
    @Override
    public int compare(Guppy o1, Guppy o2) {
        if (o1.getHealthCoefficient() == o2.getHealthCoefficient()) {
            return 0;
        } else {
            return o1.getHealthCoefficient() > o2.getHealthCoefficient() ? 1 : -1;
        }
    }
}



