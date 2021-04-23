package ca.bcit.comp2522.labs.lab08;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Draws my face.
 *
 * @author Dongmin Lee (A01165938)
 * @version 2020
 */
public class Face extends Group {

    /**
     * Assemble head, eyes, mouth, nose into a face.
     */
    public Face() {
        Head head = new Head();
        Eye leftEye = new Eye();
        Eye rightEye = new Eye();
        setTranslate(leftEye, 210, 220);
        setTranslate(rightEye, 290, 220);
        Nose nose = new Nose();
        Mouth mouth = new Mouth();
        getChildren().addAll(head, leftEye, rightEye, nose, mouth);
    }

    private void setTranslate(Eye eye, final int x, final int y) {
        eye.setTranslateX(x);
        eye.setTranslateY(y);
    }

    static class Head extends Group {
        Head() {
            Ellipse outline = drawOutline();
            Rectangle neck = drawNeck();

            Shape topHair = drawTopHair();
            Rectangle bottomHair = drawBottomHair();

            getChildren().addAll(bottomHair, neck, outline, topHair);
        }

        Rectangle drawNeck() {
            Rectangle neck = new Rectangle(100, 200);
            neck.setX(200);
            neck.setY(300);
            neck.setFill(Color.TAN);


            return neck;
        }

        Ellipse drawOutline() {
            Ellipse outline = new Ellipse(250, 250, 100, 130);
            outline.setFill(Color.TAN);
            outline.setStroke(Color.BLACK);
            outline.setStrokeWidth(1);

            return outline;
        }

        Shape drawTopHair() {
            Ellipse hair = new Ellipse(250, 240, 105, 135);
            Ellipse hairToBeRemoved = new Ellipse(250, 270, 100, 120);

            return Shape.subtract(hair, hairToBeRemoved);
        }

        Rectangle drawBottomHair() {
            Rectangle hair = new Rectangle(210, 200);
            hair.setX(145);
            hair.setY(250);

            return hair;
        }
    }

    static class Eye extends Group {
        Eye() {
            Shape eyeball = drawEyeball();
            Circle iris = drawIris();
            Circle pupil = drawPupil();

            getChildren().addAll(eyeball, iris, pupil);
        }

        Shape drawEyeball() {
            Circle upperEyeLid = new Circle(0, 15, 18);
            Circle lowerEyeLid = new Circle(0, 0, 18);
            Shape eyeball = Shape.intersect(upperEyeLid, lowerEyeLid);
            eyeball.setFill(Color.WHITE);
            return eyeball;
        }

        Circle drawIris() {
            Circle iris = new Circle(0, 7.5, 7);
            iris.setFill(Color.BROWN);
            return iris;
        }

        Circle drawPupil() {
            Circle pupil = new Circle(0, 7.5, 4);
            pupil.setFill(Color.BLACK);
            return pupil;
        }
    }

    static class Nose extends Group {
        Nose() {
            Arc outline = new Arc();
            outline.setCenterX(250);
            outline.setCenterY(270);
            outline.setRadiusX(12);
            outline.setRadiusY(10);
            outline.setStartAngle(180);
            outline.setLength(180);
            outline.setType(ArcType.OPEN);
            outline.setStroke(Color.BLACK);
            outline.setStrokeWidth(4);
            outline.setFill(Color.TRANSPARENT);
            getChildren().add(outline);
        }
    }

    static class Mouth extends Group {
        Mouth() {
            Line line = new Line(210, 315, 290, 315);
            line.setStrokeWidth(5);

            getChildren().add(line);
        }
    }
}
