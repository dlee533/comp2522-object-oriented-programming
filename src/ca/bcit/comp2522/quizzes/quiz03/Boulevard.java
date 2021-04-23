package ca.bcit.comp2522.quizzes.quiz03;

/**
 *
 * This class construct a Boulevard object which inherited the Road Class and  contains a Direction , Name, and a
 * boolean medianHasTrees.
 *
 * @author Zichang Liu A00930658
 * @author Mina Lee A01165938
 * @year 2020
 * @package ca.bcit.comp2522.quiz.quiz3
 */
public class Boulevard extends Road {
    private boolean medianHasTrees;
    public Boulevard(String name, Direction direction, boolean medianHasTrees) {
        super(name, direction);
        this.medianHasTrees = medianHasTrees;
    }
    @Override
    public String toString() {
        return "Boulevard{" +
                "medianHasTrees=" + medianHasTrees +
                ", direction=" + getDirection() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
