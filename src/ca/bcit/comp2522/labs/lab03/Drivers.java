package ca.bcit.comp2522.labs.lab03;

import java.util.Scanner;

/**
 * Driver class.
 */
public class Drivers {

    /**
     * Drives plantation simulation.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Plantation lotuslandLumber = new Plantation();
        for (int i = 0; i < 5; i++) {
            lotuslandLumber.seed();
        }
        int numberOfTrees = lotuslandLumber.size();
        System.out.println("There are " + numberOfTrees + " trees.");

        System.out.print("Enter the minimum harvest circumference: ");
        Scanner scan = new Scanner(System.in);
        double minimumCircumference = scan.nextDouble();
        int numberOfHarvestableTrees = lotuslandLumber.harvestCount(minimumCircumference);
        System.out.println("There are " + numberOfHarvestableTrees + " harvestable trees.");
    }
}
