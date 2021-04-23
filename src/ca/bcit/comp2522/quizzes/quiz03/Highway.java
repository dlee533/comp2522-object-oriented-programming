package ca.bcit.comp2522.quizzes.quiz03;

/**
 * This class construct a Highway object which contains inherited the Road class, a Direction, Name and a boolean hasHO
 * Vlane.
 *
 * @author Zichang Liu A00930658
 * @author Mina Lee A01165938
 * @year 2020
 * @package ca.bcit.comp2522.quiz.quiz3
 */
public class Highway extends Road {
    private boolean hasHOVlane;
    public Highway(String name, Direction direction, boolean hasHOVlane) {
        super(name, direction);
        this.hasHOVlane = hasHOVlane;
    }

    @Override
    public String toString() {
        return "Highway{" +
                "hasHOVlane=" + hasHOVlane +
                ", direction=" + getDirection() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
