package ca.bcit.comp2522.quizzes.quiz03;

import java.util.ArrayList;

/**
 * This class runs the program.
 *
 * @author Zichang Liu A00930658
 * @author Mina Lee A01165938
 * @year 2020
 * @package ca.bcit.comp2522.quiz.quiz3
 */
public class RoadMaker {
    public static void main(String[] args) {
        ArrayList<Road> canadaRoad = new ArrayList<>();
        Road mainStreet = new Road("Main Street", Road.Direction.NORTH);
        Boulevard niagaraBoulevard = new Boulevard("Niagara Boulevard", Road.Direction.SOUTH,true);
        Highway transCanada = new Highway("Trans Canada", Road.Direction.EAST,true);
        canadaRoad.add(mainStreet);
        canadaRoad.add(niagaraBoulevard);
        canadaRoad.add(transCanada);
        for(Road road : canadaRoad){
            System.out.println(road.toString());
        }
    }
}
