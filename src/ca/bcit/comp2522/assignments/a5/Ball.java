package ca.bcit.comp2522.assignments.a5;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Random;


/**
 *  Ball is a Runnable.  A Ball bounces.
 *
 * @author BCIT
 * @version 2020
 */
public class Ball extends Circle implements Runnable {

    private static final ArrayList<Ball> BALL_LIST = new ArrayList<>();

    private static final Random GENERATOR = new Random();
    private static final int RADIUS = 10;

    private final int MAX_X = 500; // horizontal edge of enclosing Panel
    private final int MAX_Y = 500; // vertical edge of enclosing Panel

    private int dx; // change in horizontal position of ball
    private int dy; // change in vertical position of ball

    /**
     * Constructs an object of type Ball.
     */
    public Ball() {
        super(RADIUS, Color.RED);

        this.setCenterX(GENERATOR.nextInt(MAX_X));
        this.setCenterY(GENERATOR.nextInt(MAX_Y));

        final int maxPixel = 5;

        dx = GENERATOR.nextInt(maxPixel); // change in x (0 - 4 pixels)
        dy = GENERATOR.nextInt(maxPixel); // change in y (0 - 4 pixels)

        BALL_LIST.add(this);
    }

    private double getHypotenuse(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private synchronized void checkIfCollision() {
        for (Ball ball : BALL_LIST) {
            double xDistance = this.getCenterX() - ball.getCenterX();
            double yDistance = this.getCenterY() - ball.getCenterY();
            if (!ball.equals(this) && Math.abs(getHypotenuse(xDistance, yDistance)) <= RADIUS * 2) {
                this.dx *= -1;
                this.dy *= -1;
            }
        }
    }

    /**
     * Bounces the Ball perpetually.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(20); // sleep for 20 milliseconds
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            /* Long-running operations must not be run on the JavaFX application
               thread, since this prevents JavaFX from updating the UI, resulting
               in a frozen UI.

               Furthermore any change to a Node that is part of a "live" scene
               graph must happen on the JavaFX application thread.

               Platform.runLater can be used to execute those updates on the
               JavaFX application thread.
             */
            Platform.runLater(() -> {
                // if bounce off top or bottom of Panel
                if (this.getCenterY() <= 0 || this.getCenterY() >= MAX_Y) {
                    dy *= -1; // reverses velocity in y direction}
                }

                // if bounce off left or right of Panel
                if (this.getCenterX() <= 0 || this.getCenterX() >= MAX_X) {
                    dx *= -1; // reverses velocity in x direction
                }

                this.checkIfCollision();

                this.setCenterX(this.getCenterX() + dx); // determines new x-position
                this.setCenterY(this.getCenterY() + dy); // determines new y-position

            });
        }
    }
}