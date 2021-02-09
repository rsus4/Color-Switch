package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.*;

import java.io.IOException;

public class TwoCircle extends Application {
    private final Arc b1, b2, b3, b4, b5, b6, b7, b8;
    private final AnchorPane root;
    private final ImageView star;
    private final ImageView colorwheel;


    public TwoCircle(AnchorPane root, Stage stage,double center_x, double center_y) throws Exception {
        b1=new Arc();
        b1.setCenterX(120);
        b1.setCenterY(center_y);
        b1.setRadiusX(70);
        b1.setRadiusY(70);
        b1.setStartAngle(90.0f);
        b1.setLength(90.0f);
        b1.setStrokeWidth(8);
        b1.setFill(Color.TRANSPARENT);
        b1.setStroke(Color.AQUA);

        b2=new Arc();
        b2.setCenterX(120);
        b2.setCenterY(center_y);
        b2.setRadiusX(70);
        b2.setRadiusY(70);
        b2.setStartAngle(0.0f);
        b2.setLength(90.0f);
        b2.setStrokeWidth(8);
        b2.setFill(Color.TRANSPARENT);
        b2.setStroke(Color.BLUEVIOLET);

        b3=new Arc();
        b3.setCenterX(120);
        b3.setCenterY(center_y);
        b3.setRadiusX(70);
        b3.setRadiusY(70);
        b3.setStartAngle(270.0f);
        b3.setLength(90.0f);
        b3.setStrokeWidth(8);
        b3.setFill(Color.TRANSPARENT);
        b3.setStroke(Color.DEEPPINK);

        b4=new Arc();
        b4.setCenterX(120);
        b4.setCenterY(center_y);
        b4.setRadiusX(70);
        b4.setRadiusY(70);
        b4.setStartAngle(180.0f);
        b4.setLength(90.0f);
        b4.setStrokeWidth(8);
        b4.setFill(Color.TRANSPARENT);
        b4.setStroke(Color.YELLOW);

        b5=new Arc();
        b5.setCenterX(270);
        b5.setCenterY(center_y);
        b5.setRadiusX(70);
        b5.setRadiusY(70);
        b5.setStartAngle(180.0f);
        b5.setLength(90.0f);
        b5.setStrokeWidth(8);
        b5.setFill(Color.TRANSPARENT);
        b5.setStroke(Color.DEEPPINK);

        b6=new Arc();
        b6.setCenterX(270);
        b6.setCenterY(center_y);
        b6.setRadiusX(70);
        b6.setRadiusY(70);
        b6.setStartAngle(90.0f);
        b6.setLength(90.0f);
        b6.setStrokeWidth(8);
        b6.setFill(Color.TRANSPARENT);
        b6.setStroke(Color.BLUEVIOLET);

        b7=new Arc();
        b7.setCenterX(270);
        b7.setCenterY(center_y);
        b7.setRadiusX(70);
        b7.setRadiusY(70);
        b7.setStartAngle(0.0f);
        b7.setLength(90.0f);
        b7.setStrokeWidth(8);
        b7.setFill(Color.TRANSPARENT);
        b7.setStroke(Color.AQUA);

        b8=new Arc();
        b8.setCenterX(270);
        b8.setCenterY(center_y);
        b8.setRadiusX(70);
        b8.setRadiusY(70);
        b8.setStartAngle(270.0f);
        b8.setLength(90.0f);
        b8.setStrokeWidth(8);
        b8.setFill(Color.TRANSPARENT);
        b8.setStroke(Color.YELLOW);

        this.star = new ImageView();
        this.star.setImage(new Image(getClass().getResourceAsStream("/asset/star.png")));
        this.star.setX(160);
        this.star.setY(center_y-130);

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
        root.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8);

        Timeline animation1 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(b1.startAngleProperty(), b1.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(b1.startAngleProperty(), b1.getStartAngle() - 360, Interpolator.LINEAR))

        );
        animation1.setCycleCount(Animation.INDEFINITE);

        Timeline animation2 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(b2.startAngleProperty(), b2.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(b2.startAngleProperty(), b2.getStartAngle() - 360, Interpolator.LINEAR))

        );
        animation2.setCycleCount(Animation.INDEFINITE);

        Timeline animation3 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(b3.startAngleProperty(), b3.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(b3.startAngleProperty(), b3.getStartAngle() - 360, Interpolator.LINEAR))

        );
        animation3.setCycleCount(Animation.INDEFINITE);

        Timeline animation4 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(b4.startAngleProperty(), b4.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(b4.startAngleProperty(), b4.getStartAngle() - 360, Interpolator.LINEAR))

        );
        animation4.setCycleCount(Animation.INDEFINITE);

        Timeline animation5 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(b5.startAngleProperty(), b5.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(b5.startAngleProperty(), b5.getStartAngle() + 360, Interpolator.LINEAR))

        );
        animation5.setCycleCount(Animation.INDEFINITE);

        Timeline animation6 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(b6.startAngleProperty(), b6.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(b6.startAngleProperty(), b6.getStartAngle() + 360, Interpolator.LINEAR))

        );
        animation6.setCycleCount(Animation.INDEFINITE);

        Timeline animation7 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(b7.startAngleProperty(), b7.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(b7.startAngleProperty(), b7.getStartAngle() + 360, Interpolator.LINEAR))

        );
        animation7.setCycleCount(Animation.INDEFINITE);

        Timeline animation8 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(b8.startAngleProperty(), b8.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(b8.startAngleProperty(), b8.getStartAngle() + 360, Interpolator.LINEAR))

        );
        animation8.setCycleCount(Animation.INDEFINITE);

        animation1.play();
        animation2.play();
        animation3.play();
        animation4.play();
        animation5.play();
        animation6.play();
        animation7.play();
        animation8.play();
    }

    public Arc getB1(){
        return b1;
    }
    public Arc getB2(){
        return b2;
    }
    public Arc getB3(){
        return b3;
    }
    public Arc getB4(){
        return b4;
    }
    public Arc getB5(){
        return b5;
    }
    public Arc getB6(){
        return b6;
    }
    public Arc getB7(){
        return b7;
    }
    public Arc getB8(){
        return b8;
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
            Shape intersect=Shape.intersect(circle, getB1());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with BLUE");
//                    Parent infinite_page_parent= FXMLLoader.load(getClass().getResource("crashMenu.fxml"));
//                    Scene scenecrash =new Scene(infinite_page_parent);
//                    stage.setScene(scenecrash);
//                    stage.show();
//                    stop();
                stage.close();
            }

            intersect=Shape.intersect(circle, getB2());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with VIOLET");
                stage.close();
            }

            intersect=Shape.intersect(circle, getB3());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with PINK");
                stage.close();
            }

            intersect=Shape.intersect(circle, getB4());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with YELLOW ");
            }
        }
        else if(color==3){
            Shape intersect=Shape.intersect(circle, getB1());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with BLUE");
                stage.close();
            }

            intersect=Shape.intersect(circle, getB2());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with VIOLET");
                stage.close();
            }

            intersect=Shape.intersect(circle, getB3());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with PINK");

            }

            intersect=Shape.intersect(circle, getB4());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with YELLOW ");
                stage.close();
            }
        }
        else if(color==2){
            Shape intersect=Shape.intersect(circle, getB1());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with BLUE");
                stage.close();
            }

            intersect=Shape.intersect(circle, getB2());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with VIOLET");

            }

            intersect=Shape.intersect(circle, getB3());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with PINK");
                stage.close();

            }

            intersect=Shape.intersect(circle, getB4());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with YELLOW ");
                stage.close();
            }

        }
        else{
            Shape intersect=Shape.intersect(circle, getB1());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with BLUE");

            }

            intersect=Shape.intersect(circle, getB2());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with VIOLET");
                stage.close();
            }

            intersect=Shape.intersect(circle, getB3());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with PINK");
                stage.close();

            }

            intersect=Shape.intersect(circle, getB4());
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                System.out.println("Ball collidied with YELLOW ");
                stage.close();
            }

        }
    }



    public double getStar(){
        return  b1.getCenterY()-130;
    }
    public ImageView getColorWheelImg(){
        return colorwheel;
    }

    public double getColorWheel(){
        return b1.getCenterY()+175;
    }
    public ImageView getStarImg(){
        return star;
    }
    public void moveCircle(double distance){
        this.star.setY(this.star.getY()+distance);
        this.colorwheel.setY(this.colorwheel.getY()+distance);
        b1.setCenterY(b1.getCenterY()+distance);
        b2.setCenterY(b2.getCenterY()+distance);
        b3.setCenterY(b3.getCenterY()+distance);
        b4.setCenterY(b4.getCenterY()+distance);
        b5.setCenterY(b5.getCenterY()+distance);
        b6.setCenterY(b6.getCenterY()+distance);
        b7.setCenterY(b7.getCenterY()+distance);
        b8.setCenterY(b8.getCenterY()+distance);
    }
}
