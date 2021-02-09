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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Triangle extends Application {
    private final Rectangle r1, r2, r3;
    private final Polygon t1,t2,t3,t4,t5,t6;
    private final AnchorPane root;
    private final ImageView star;
    private final ImageView colorwheel;


    public Triangle(AnchorPane root, Stage stage,double center_x,double center_y) throws Exception{
        r1=new Rectangle();
        r1.setHeight(150);
//        r1.setX(147);
//        r1.setY(115);
        r1.setLayoutX(147-30);
        r1.setLayoutY(115+center_y);
        r1.setRotate(30);
        r1.setWidth(25);
        r1.setFill(Color.AQUA);

        r2=new Rectangle();
        r2.setHeight(150);
        r2.setLayoutX(242-30);
        r2.setLayoutY(115+center_y);
        r2.setRotate(-30);
        r2.setWidth(25);
        r2.setFill(Color.DEEPPINK);

        r3=new Rectangle();
        r3.setHeight(150);
        r3.setLayoutX(194-30);
        r3.setLayoutY(197+center_y);
        r3.setRotate(90);
        r3.setWidth(25);
        r3.setFill(Color.YELLOW);

        t1=new Polygon();
        t1.getPoints().addAll(-42.79129409790039, 41.90371322631836, -17.97125816345215, 40.74338150024414, -39.923545837402344, 2.566340208053589);
        t1.setFill(Color.AQUA);
        t1.setLayoutX(236-30);
        t1.setLayoutY(87+center_y);
        t1.setRotate(30);

        t2=new Polygon();
        t2.getPoints().addAll(-42.791290283203125, 43.75, -18.25, 37.75, -42.791290283203125, -0.5);
        t2.setFill(Color.DEEPPINK);
        t2.setLayoutX(250-30);
        t2.setLayoutY(88+center_y);

        t3=new Polygon();
        t3.getPoints().addAll(-59.75, 43.5, -18.5, 43.5, -17.97125244140625, 19.5);
        t3.setFill(Color.YELLOW);
        t3.setLayoutX(150-30);
        t3.setLayoutY(241+center_y);

        t4=new Polygon();
        t4.getPoints().addAll(25.0, 43.5, -18.5, 43.5, -18.5, 18.5);
        t4.setFill(Color.YELLOW);
        t4.setLayoutX(299-30);
        t4.setLayoutY(241+center_y);

        t5=new Polygon();
        t5.getPoints().addAll(-54.75, 42.5, -12.97125244140625, 18.5, -31.75, 3.5);
        t5.setFill(Color.AQUA);
        t5.setLayoutX(145-30);
        t5.setLayoutY(242+center_y);

        t6=new Polygon();
        t6.getPoints().addAll(-65.75, 25.25, -24.0, 49.5, -49.0, 7.25);
        t6.setFill(Color.DEEPPINK);
        t6.setLayoutX(348-30);
        t6.setLayoutY(235+center_y);

        this.star = new ImageView();
        this.star.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/asset/star.png")));
        this.star.setX(160);
        this.star.setY(center_y-80);

        this.colorwheel = new ImageView();
        this.colorwheel.setImage(new Image(getClass().getResourceAsStream("/asset/colourwheel.png")));
        this.colorwheel.setX(162);
        this.colorwheel.setY(center_y+350);

        this.root=root;
        this.start(stage);
    }

    public void moveCircle(double distance){
        this.star.setY(this.star.getY()+distance);
        this.colorwheel.setY(this.colorwheel.getY()+distance);
        r1.setLayoutY(r1.getLayoutY()+distance);
        r2.setLayoutY(r2.getLayoutY()+distance);
        r3.setLayoutY(r3.getLayoutY()+distance);
        t1.setLayoutY(t1.getLayoutY()+distance);
        t2.setLayoutY(t2.getLayoutY()+distance);
        t3.setLayoutY(t3.getLayoutY()+distance);
        t4.setLayoutY(t4.getLayoutY()+distance);
        t5.setLayoutY(t5.getLayoutY()+distance);
        t6.setLayoutY(t6.getLayoutY()+distance);
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
            semiIntersect(circle,color,r1,stage);
            semiIntersect(circle,color,r2,stage);
            semiIntersect(circle,color,t1,stage);
            semiIntersect(circle,color,t2,stage);
            semiIntersect(circle,color,t5,stage);
            semiIntersect(circle,color,t6,stage);

        }
        else if(color==3){
            semiIntersect(circle,color,r1,stage);
            semiIntersect(circle,color,r3,stage);
            semiIntersect(circle,color,t1,stage);
            semiIntersect(circle,color,t3,stage);
            semiIntersect(circle,color,t5,stage);
            semiIntersect(circle,color,t4,stage);
        }

        else{
            semiIntersect(circle,color,r3,stage);
            semiIntersect(circle,color,r2,stage);
            semiIntersect(circle,color,t3,stage);
            semiIntersect(circle,color,t2,stage);
            semiIntersect(circle,color,t4,stage);
            semiIntersect(circle,color,t6,stage);

        }
    }

    public double getStar(){
        return  t6.getLayoutY()-270;
    }
    public ImageView getColorWheelImg(){
        return colorwheel;
    }

    public double getColorWheel(){
        return t6.getLayoutY()+140;
    }
    public ImageView getStarImg(){
        return star;
    }


    @Override
    public void start(Stage stage) throws Exception {
        Group g=new Group();
        g.getChildren().addAll(r1,r2,r3,t1,t2,t3,t4,t5,t6);
        root.getChildren().add(g);
        root.getChildren().add(getStarImg());
        root.getChildren().add(getColorWheelImg());


        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(-3600);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setDuration(Duration.millis(25000));
        rotate.setNode(g);
        rotate.play();
    }


}
