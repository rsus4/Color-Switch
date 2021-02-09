package sample;

import java.lang.ClassNotFoundException;
import java.lang.NoClassDefFoundError;
import javafx.fxml.FXML;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;


public class Circle extends Application {
    private final Arc a1,a2,a3,a4;
    private final ImageView star;
    private final AnchorPane root;
    private final ImageView colorwheel;

    public Circle(AnchorPane root, Stage stage,double center_x, double center_y) throws Exception {
        //1 BLUE
        a1=new Arc();
        a1.setCenterX(195);
        a1.setCenterY(center_y);
        a1.setRadiusX(100);
        a1.setRadiusY(100);
        a1.setStartAngle(90.0f);
        a1.setLength(90.0f);
        a1.setStrokeWidth(20);
        a1.setFill(Color.TRANSPARENT);
        a1.setStroke(Color.AQUA);

        //2 VIOLET
        a2=new Arc();
        a2.setCenterX(195);
        a2.setCenterY(center_y);
        a2.setRadiusX(100);
        a2.setRadiusY(100);
        a2.setStartAngle(0.0f);
        a2.setLength(90.0f);
        a2.setStrokeWidth(20);
        a2.setFill(Color.TRANSPARENT);
        a2.setStroke(Color.BLUEVIOLET);

        //3 PINK
        a3=new Arc();
        a3.setCenterX(195);
        a3.setCenterY(center_y);
        a3.setRadiusX(100);
        a3.setRadiusY(100);
        a3.setStartAngle(270.0f);
        a3.setLength(90.0f);
        a3.setStrokeWidth(20);
        a3.setFill(Color.TRANSPARENT);
        a3.setStroke(Color.DEEPPINK);

        //4 YELLOW
        a4=new Arc();
        a4.setCenterX(195);
        a4.setCenterY(center_y);
        a4.setRadiusX(100);
        a4.setRadiusY(100);
        a4.setStartAngle(180.0f);
        a4.setLength(90.0f);
        a4.setStrokeWidth(20);
        a4.setFill(Color.TRANSPARENT);
        a4.setStroke(Color.YELLOW);

        this.star = new ImageView();
        this.star.setImage(new Image(getClass().getResourceAsStream("/asset/star.png")));
        this.star.setX(162);
        this.star.setY(center_y-25);

        this.colorwheel = new ImageView();
        this.colorwheel.setImage(new Image(getClass().getResourceAsStream("/asset/colourwheel.png")));
        this.colorwheel.setX(162);
        this.colorwheel.setY(center_y+150);
        this.root=root;
        this.start(stage);






    }

    @Override
    public void start(Stage stage) throws Exception {

        root.getChildren().add(star);
        root.getChildren().add(colorwheel);

        root.getChildren().addAll(a1,a2,a3,a4);

        Timeline animation1 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(a1.startAngleProperty(), a1.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(2), new KeyValue(a1.startAngleProperty(), a1.getStartAngle() - 360, Interpolator.LINEAR))

        );
        animation1.setCycleCount(Animation.INDEFINITE);

        Timeline animation2 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(a2.startAngleProperty(), a2.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(2), new KeyValue(a2.startAngleProperty(), a2.getStartAngle() - 360, Interpolator.LINEAR))

        );
        animation2.setCycleCount(Animation.INDEFINITE);

        Timeline animation3 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(a3.startAngleProperty(), a3.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(2), new KeyValue(a3.startAngleProperty(), a3.getStartAngle() - 360, Interpolator.LINEAR))

        );
        animation3.setCycleCount(Animation.INDEFINITE);

        Timeline animation4 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(a4.startAngleProperty(), a4.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(2), new KeyValue(a4.startAngleProperty(), a4.getStartAngle() - 360, Interpolator.LINEAR))

        );
        animation4.setCycleCount(Animation.INDEFINITE);

        animation1.play();
        animation2.play();
        animation3.play();
        animation4.play();
    }

    public void collisionCheckCircle(javafx.scene.shape.Circle circle, Stage stage) throws IOException {

        int color;

        if(circle.getFill()==Color.AQUA){
            color=1;
        }
        else if(circle.getFill()==Color.BLUEVIOLET){
            color=2;
        }
        else if(circle.getFill()==Color.DEEPPINK){
            color=3;
        }
        else{
            color=4;
        }

        if(color==4){
            Shape intersect=Shape.intersect(circle, getA1());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with BLUE");
////                Stage sNew=new Stage();
//                    Parent infinite_page_parent= FXMLLoader.load(getClass().getResource("crashMenu.fxml"));
////                    Scene scenecrash =new Scene(infinite_page_parent);
////                    stage.setScene(scenecrash);
////                    stage.show();
               stage.close();
            }

            intersect=Shape.intersect(circle, getA2());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with VIOLET");
                stage.close();
            }

            intersect=Shape.intersect(circle, getA3());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with PINK");
                stage.close();
            }

            intersect=Shape.intersect(circle, getA4());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with YELLOW ");
            }
        }
        else if(color==3){
            Shape intersect=Shape.intersect(circle, getA1());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with BLUE");
                stage.close();
            }

            intersect=Shape.intersect(circle, getA2());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with VIOLET");
                stage.close();
            }

            intersect=Shape.intersect(circle, getA3());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with PINK");

            }

            intersect=Shape.intersect(circle, getA4());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with YELLOW ");
                stage.close();
            }
        }
        else if(color==2){
            Shape intersect=Shape.intersect(circle, getA1());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with BLUE");
                stage.close();
            }

            intersect=Shape.intersect(circle, getA2());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with VIOLET");

            }

            intersect=Shape.intersect(circle, getA3());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with PINK");
                stage.close();

            }

            intersect=Shape.intersect(circle, getA4());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with YELLOW ");
                stage.close();
            }

        }
        else{
            Shape intersect=Shape.intersect(circle, getA1());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with BLUE");

            }

            intersect=Shape.intersect(circle, getA2());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with VIOLET");
                stage.close();
            }

            intersect=Shape.intersect(circle, getA3());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with PINK");
                stage.close();

            }

            intersect=Shape.intersect(circle, getA4());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with YELLOW ");
                stage.close();
            }

        }
    }


    public double getStar() {
        return a1.getCenterY();
    }

    public ImageView getStarImg(){
        return star;
    }

    public ImageView getColorWheelImg(){
        return colorwheel;
    }

    public double getColorWheel(){
        return a1.getCenterY()+175;
    }
    public Arc getA1(){
        return a1;
    }

    public Arc getA2() {
        return a2;
    }

    public Arc getA3() {
        return a3;
    }

    public Arc getA4() {
        return a4;
    }

    public void moveCircle(double distance){
        this.star.setY(this.star.getY()+distance);
        this.colorwheel.setY(this.colorwheel.getY()+distance);
        a1.setCenterY(a1.getCenterY()+distance);
        a2.setCenterY(a2.getCenterY()+distance);
        a3.setCenterY(a3.getCenterY()+distance);
        a4.setCenterY(a4.getCenterY()+distance);
    }
}
