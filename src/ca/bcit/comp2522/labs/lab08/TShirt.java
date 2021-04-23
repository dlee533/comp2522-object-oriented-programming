package ca.bcit.comp2522.labs.lab08;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Draws my shirt.
 *
 * @author Dongmin Lee (A01165938)
 * @version 2020
 */
public class TShirt extends Group {

    /**
     * Creates a rectangular shirt.
     */
    public TShirt() {
        Rectangle shirt = new Rectangle(350, 100);
        shirt.setX(75);
        shirt.setY(400);
        shirt.setFill(Color.DARKBLUE);
        getChildren().add(shirt);
    }
}
