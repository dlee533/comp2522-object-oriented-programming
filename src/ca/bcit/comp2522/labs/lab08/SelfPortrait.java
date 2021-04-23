package ca.bcit.comp2522.labs.lab08;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

/**
 * Draws my portrait.
 *
 * @author Dongmin Lee (A01165938)
 * @version 2020
 */
public class SelfPortrait extends Application {

    /**
     * Draws my portrait.
     *
     * @param stage a stage
     */
    public void start(Stage stage) {
        Face face = new Face();
        TShirt tShirt = new TShirt();

        Group root = new Group(face, tShirt);
        root.setTranslateY(100);

        final int appWidth = 500;
        final int appHeight = 500;

        Image img = new Image("file:images/rain.png");
        ImageView imgView = new ImageView(img);
        imgView.getTransforms().add(new Shear(0.5, 0.3));
        imgView.setScaleX(0.9);
        imgView.setScaleY(0.8);
        imgView.setRotate(-20);
        imgView.setTranslateY(-50);
        imgView.setTranslateX(-100);

        HBox hbox = new HBox(imgView);

        StackPane portrait = new StackPane(root, hbox);
        portrait.setStyle("-fx-background-color: grey");
        Scene scene = new Scene(portrait, appWidth, appHeight);

        stage.setTitle("Self Portrait");
        stage.setScene(scene);
        stage.show();
}

    /**
     * Launches the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
