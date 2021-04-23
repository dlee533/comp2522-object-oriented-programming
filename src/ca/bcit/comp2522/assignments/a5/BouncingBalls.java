package ca.bcit.comp2522.assignments.a5;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * BouncingBalls, an introduction to threading and JavaFX.
 *
 * @author BCIT
 * @author YOUR NAME GOES HERE
 * @version 2020
 */
public class BouncingBalls extends Application {

    private void addBall(Pane canvas) {
        Ball ball = new Ball();
        canvas.getChildren().add(ball);
        Thread bouncer = new Thread(ball);
        bouncer.setDaemon(true);
        bouncer.start();
    }

    /**
     * Demonstrates threading in JavaFX.
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        final int width = 500;
        final int height = 500;
        Scene scene = new Scene(canvas, width, height);
        Scanner scan = new Scanner(System.in);
        System.out.print("Number of balls: ");
        int numBalls = scan.nextInt();
        for (int i = 0; i < numBalls; i++) {
            addBall(canvas);
        }

        primaryStage.setTitle("Threads and Balls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.  We still need a main method in our
     * JavaFX applications.  The main method must do one thing.  Pass
     * the command line arguments (args) to the launch method inherited from
     * the Application class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
