package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TwoPlus extends Application {
    private final Line l1, l2, l3, l4, l5, l6, l7, l8;
    private final AnchorPane root;
    private final ImageView star;
    private final ImageView colorwheel;

    public TwoPlus(AnchorPane root, Stage stage,double center_x,double center_y) throws Exception {
        l1=new Line();
        l1.setEndX(82);
        l1.setLayoutX(91+center_x);
        l1.setLayoutY(225+center_y);
        l1.setStartX(42);
        l1.setRotate(90);
        l1.setStrokeWidth(15);
        l1.setStrokeLineCap(StrokeLineCap.ROUND);
        l1.setStroke(Color.YELLOW);

        l2=new Line();
        l2.setEndX(82);
        l2.setLayoutX(91+center_x);
        l2.setLayoutY(173+center_y);
        l2.setStartX(42);
        l2.setRotate(90);
        l2.setStrokeWidth(15);
        l2.setStrokeLineCap(StrokeLineCap.ROUND);
        l2.setStroke(Color.BLUEVIOLET);

        l3=new Line();
        l3.setEndX(82);
        l3.setLayoutX(64+center_x);
        l3.setLayoutY(200+center_y);
        l3.setStartX(42);
        //l3.setRotate(90);
        l3.setStrokeWidth(15);
        l3.setStrokeLineCap(StrokeLineCap.ROUND);
        l3.setStroke(Color.AQUA);

        l4=new Line();
        l4.setEndX(82);
        l4.setLayoutX(202+center_x);
        l4.setLayoutY(173+center_y);
        l4.setStartX(42);
        l4.setRotate(90);
        l4.setStrokeWidth(15);
        l4.setStrokeLineCap(StrokeLineCap.ROUND);
        l4.setStroke(Color.BLUEVIOLET);

        l5=new Line();
        l5.setEndX(82);
        l5.setLayoutX(202+center_x);
        l5.setLayoutY(224+center_y);
        l5.setStartX(42);
        l5.setRotate(90);
        l5.setStrokeWidth(15);
        l5.setStrokeLineCap(StrokeLineCap.ROUND);
        l5.setStroke(Color.YELLOW);

        l6=new Line();
        l6.setEndX(82);
        l6.setLayoutX(174+center_x);
        l6.setLayoutY(198+center_y);
        l6.setStartX(42);
        l6.setStrokeWidth(15);
        l6.setStrokeLineCap(StrokeLineCap.ROUND);
        l6.setStroke(Color.DEEPPINK);

        l7=new Line();
        l7.setEndX(82);
        l7.setLayoutX(229+center_x);
        l7.setLayoutY(198+center_y);
        l7.setStartX(42);
        l7.setStrokeWidth(15);
        l7.setStrokeLineCap(StrokeLineCap.ROUND);
        l7.setStroke(Color.AQUA);

        l8=new Line();
        l8.setEndX(82);
        l8.setLayoutX(119+center_x);
        l8.setLayoutY(198+center_y);
        l8.setStartX(42);
        l8.setStrokeWidth(15);
        l8.setStrokeLineCap(StrokeLineCap.ROUND);
        l8.setStroke(Color.DEEPPINK);

        this.star = new ImageView();
        this.star.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/asset/star.png")));
        this.star.setX(160);
        this.star.setY(center_y+60);

        this.colorwheel = new ImageView();
        this.colorwheel.setImage(new Image(getClass().getResourceAsStream("/asset/colourwheel.png")));
        this.colorwheel.setX(162);
        this.colorwheel.setY(l4.getLayoutY()+140);

        this.root=root;
        this.start(stage);
    }

    public double getStar(){
        return  l4.getLayoutY()-90;
    }
    public ImageView getColorWheelImg(){
        return colorwheel;
    }

    public double getColorWheel(){
        return l4.getLayoutY()+165;
    }
    public ImageView getStarImg(){
        return star;
    }

    public void semiIntersect(javafx.scene.shape.Circle circle, int color, Shape r1, Stage stage){
        Shape intersect=Shape.intersect(circle,r1);
        if(intersect.getBoundsInLocal().getWidth()!=-1){
            System.out.println("Ball collidied with PINK");
            stage.close();
        }
    }

    public void collisionCheckCircle(javafx.scene.shape.Circle circle, Stage stage){

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

        //r1=aqua=color1

        if(color==4){
            semiIntersect(circle,color,l2,stage);
            semiIntersect(circle,color,l3,stage);
            semiIntersect(circle,color,l4,stage);
            semiIntersect(circle,color,l6,stage);
            semiIntersect(circle,color,l7,stage);
            semiIntersect(circle,color,l8,stage);
        }
        else if(color==3){
            semiIntersect(circle,color,l1,stage);
            semiIntersect(circle,color,l2,stage);
            semiIntersect(circle,color,l3,stage);
            semiIntersect(circle,color,l4,stage);
            semiIntersect(circle,color,l5,stage);
            semiIntersect(circle,color,l7,stage);
        }
        else if(color==2){
            semiIntersect(circle,color,l1,stage);
            semiIntersect(circle,color,l3,stage);
            semiIntersect(circle,color,l5,stage);
            semiIntersect(circle,color,l6,stage);
            semiIntersect(circle,color,l7,stage);
            semiIntersect(circle,color,l8,stage);
        }

        else{
            semiIntersect(circle,color,l1,stage);
            semiIntersect(circle,color,l2,stage);
            semiIntersect(circle,color,l4,stage);
            semiIntersect(circle,color,l5,stage);
            semiIntersect(circle,color,l6,stage);
            semiIntersect(circle,color,l8,stage);
        }
    }

    public void moveCircle(double distance){
        this.star.setY(this.star.getY()+distance);
        this.colorwheel.setY(this.colorwheel.getY()+distance);
        l1.setLayoutY(l1.getLayoutY()+distance);
        l2.setLayoutY(l2.getLayoutY()+distance);
        l3.setLayoutY(l3.getLayoutY()+distance);
        l4.setLayoutY(l4.getLayoutY()+distance);
        l5.setLayoutY(l5.getLayoutY()+distance);
        l6.setLayoutY(l6.getLayoutY()+distance);
        l7.setLayoutY(l7.getLayoutY()+distance);
        l8.setLayoutY(l8.getLayoutY()+distance);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group g1=new Group();
        Group g2=new Group();
        g1.getChildren().addAll(l1,l2,l3,l8);
        g2.getChildren().addAll(l5,l4,l7,l6);
        root.getChildren().addAll(g1,g2);
        root.getChildren().add(star);
        root.getChildren().add(colorwheel);

        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(3600);
        rotate1.setCycleCount(Animation.INDEFINITE);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setDuration(Duration.millis(25000));
        rotate1.setNode(g1);
        rotate1.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(-3600);
        rotate2.setCycleCount(Animation.INDEFINITE);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setDuration(Duration.millis(25000));
        rotate2.setNode(g2);
        rotate2.play();
    }

}
