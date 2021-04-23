package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

/**
 * Driver class to execute the program.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Driver {
    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem();
        Scanner scan = new Scanner(System.in);
        System.out.print("How many weeks would you like to run the simulation? ");
        int numberOfWeeks = scan.nextInt();
        ecosystem.setupSimulation();
        ecosystem.simulate(numberOfWeeks);
    }
}
