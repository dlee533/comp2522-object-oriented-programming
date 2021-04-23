package ca.bcit.comp2522.quizzes.quiz03;

/**
 * This class construct a Road object which contains a Direction and Name.
 *
 * @author Zichang Liu A00930658
 * @author Mina Lee A01165938
 * @year 2020
 * @package ca.bcit.comp2522.quiz.quiz3
 */
public class Road {
    private Direction direction;
    private String name;

    public Road(String name, Direction direction){
        this.name = name;
        this.direction = direction;
    }

    enum Direction{
        NORTH,EAST,SOUTH,WEST
    }

    public Direction getDirection() {
        return direction;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Road{" +
                "direction=" + direction +
                ", name='" + name + '\'' +
                '}';
    }
}
