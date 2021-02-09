package sample;

import javafx.animation.*;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DottedCircle extends Application {
    private PathTransition pt1;
    private final Circle c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24;
    private RotateTransition rotate;
    private final AnchorPane root;
    private final ImageView star;
    private final ImageView colorwheel;

    public DottedCircle(AnchorPane root, Stage stage,double center_x,double center_y) throws Exception {
        c1=new Circle(189+center_x,101+center_y,10);
        c1.setFill(Color.DEEPPINK);
        c2=new Circle(107+center_x,180+center_y,10);
        c2.setFill(Color.DEEPPINK);
        c3=new Circle(166+center_x,107+center_y,10);
        c3.setFill(Color.DEEPPINK);
        c4=new Circle(147+center_x,119+center_y,10);
        c4.setFill(Color.DEEPPINK);
        c5=new Circle(116+center_x,156+center_y,10);
        c5.setFill(Color.DEEPPINK);
        c6=new Circle(131+center_x,135+center_y,10);
        c6.setFill(Color.DEEPPINK);
        c7=new Circle(216+center_x,100+center_y,10);
        c7.setFill(Color.YELLOW);
        c8=new Circle(243+center_x,108+center_y,10);
        c8.setFill(Color.YELLOW);
        c9=new Circle(265+center_x,119+center_y,10);
        c9.setFill(Color.YELLOW);
        c10=new Circle(302+center_x,179+center_y,10);
        c10.setFill(Color.YELLOW);
        c11=new Circle(294+center_x,155+center_y,10);
        c11.setFill(Color.YELLOW);
        c12=new Circle(281+center_x,135+center_y,10);
        c12.setFill(Color.YELLOW);
        c13=new Circle(106+center_x,209+center_y,10);
        c13.setFill(Color.AQUA);
        c14=new Circle(112+center_x,236+center_y,10);
        c14.setFill(Color.AQUA);
        c15=new Circle(124+center_x,259+center_y,10);
        c15.setFill(Color.AQUA);
        c16=new Circle(142+center_x,278+center_y,10);
        c16.setFill(Color.AQUA);
        c17=new Circle(164+center_x,291+center_y,10);
        c17.setFill(Color.AQUA);
        c18=new Circle(189+center_x,301+center_y,10);
        c18.setFill(Color.AQUA);
        c19=new Circle(304+center_x,209+center_y,10);
        c19.setFill(Color.BLUEVIOLET);
        c20=new Circle(298+center_x,236+center_y,10);
        c20.setFill(Color.BLUEVIOLET);
        c21=new Circle(286+center_x,259+center_y,10);
        c21.setFill(Color.BLUEVIOLET);
        c22=new Circle(269+center_x,278+center_y,10);
        c22.setFill(Color.BLUEVIOLET);
        c23=new Circle(244+center_x,291+center_y,10);
        c23.setFill(Color.BLUEVIOLET);
        c24=new Circle(216+center_x,301+center_y,10);
        c24.setFill(Color.BLUEVIOLET);


        this.star = new ImageView();
        this.star.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/asset/star.png")));
        this.star.setX(160);
        this.star.setY(center_y+170);

        this.colorwheel = new ImageView();
        this.colorwheel.setImage(new Image(getClass().getResourceAsStream("/asset/colourwheel.png")));
        this.colorwheel.setX(162);
        this.colorwheel.setY(center_y+350);

        this.root=root;
        this.start(stage);
    }

    private void init(Stage primaryStage) {
        Group g1=new Group();
        g1.getChildren().addAll(c1, c2, c3, c4, c5, c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24);
        root.getChildren().add(g1);

        rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(-3600);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setDuration(Duration.millis(25000));
        rotate.setNode(g1);
        rotate.play();

        Path path2 = createEllipsePath(300, 200, 100, 100, 0);

        pt1 = new PathTransition();
        pt1.setDuration(Duration.seconds(2));
        pt1.setPath(path2);
        pt1.setNode(c1);
        pt1.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pt1.setCycleCount(Timeline.INDEFINITE);

    }

    private Path createEllipsePath(double centerX, double centerY, double radiusX, double radiusY, double rotate) {
        ArcTo arcTo = new ArcTo();
        arcTo.setX(centerX - radiusX + 1);
        arcTo.setY(centerY - radiusY);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(radiusX);
        arcTo.setRadiusY(radiusY);
        arcTo.setXAxisRotation(rotate);

        Path path = new Path();
        path.getElements().addAll(
                new MoveTo(centerX-radiusX, centerY-radiusY),
                arcTo,
                new ClosePath());
        return path;
    }

    public void semiIntersect(Circle circle,int color,Circle c1,Stage stage){
        Shape intersect=Shape.intersect(circle,c1);
        if(intersect.getBoundsInLocal().getWidth()!=-1){
            System.out.println("Ball collidied with PINK");
            stage.close();
        }
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
            semiIntersect(circle,color,c1,stage);
            semiIntersect(circle,color,c2,stage);
            semiIntersect(circle,color,c3,stage);
            semiIntersect(circle,color,c4,stage);
            semiIntersect(circle,color,c5,stage);
            semiIntersect(circle,color,c6,stage);
            semiIntersect(circle,color,c13,stage);
            semiIntersect(circle,color,c14,stage);
            semiIntersect(circle,color,c15,stage);
            semiIntersect(circle,color,c16,stage);
            semiIntersect(circle,color,c17,stage);
            semiIntersect(circle,color,c18,stage);
            semiIntersect(circle,color,c19,stage);
            semiIntersect(circle,color,c20,stage);
            semiIntersect(circle,color,c21,stage);
            semiIntersect(circle,color,c22,stage);
            semiIntersect(circle,color,c23,stage);
            semiIntersect(circle,color,c24,stage);

        }
        else if(color==3){
            semiIntersect(circle,color,c7,stage);
            semiIntersect(circle,color,c8,stage);
            semiIntersect(circle,color,c9,stage);
            semiIntersect(circle,color,c10,stage);
            semiIntersect(circle,color,c11,stage);
            semiIntersect(circle,color,c12,stage);
            semiIntersect(circle,color,c13,stage);
            semiIntersect(circle,color,c14,stage);
            semiIntersect(circle,color,c15,stage);
            semiIntersect(circle,color,c16,stage);
            semiIntersect(circle,color,c17,stage);
            semiIntersect(circle,color,c18,stage);
            semiIntersect(circle,color,c19,stage);
            semiIntersect(circle,color,c20,stage);
            semiIntersect(circle,color,c21,stage);
            semiIntersect(circle,color,c22,stage);
            semiIntersect(circle,color,c23,stage);
            semiIntersect(circle,color,c24,stage);
        }
        else if(color==2){
            semiIntersect(circle,color,c7,stage);
            semiIntersect(circle,color,c8,stage);
            semiIntersect(circle,color,c9,stage);
            semiIntersect(circle,color,c10,stage);
            semiIntersect(circle,color,c11,stage);
            semiIntersect(circle,color,c12,stage);
            semiIntersect(circle,color,c13,stage);
            semiIntersect(circle,color,c14,stage);
            semiIntersect(circle,color,c15,stage);
            semiIntersect(circle,color,c16,stage);
            semiIntersect(circle,color,c17,stage);
            semiIntersect(circle,color,c18,stage);
            semiIntersect(circle,color,c1,stage);
            semiIntersect(circle,color,c2,stage);
            semiIntersect(circle,color,c3,stage);
            semiIntersect(circle,color,c4,stage);
            semiIntersect(circle,color,c5,stage);
            semiIntersect(circle,color,c6,stage);


        }
        else{
            semiIntersect(circle,color,c7,stage);
            semiIntersect(circle,color,c8,stage);
            semiIntersect(circle,color,c9,stage);
            semiIntersect(circle,color,c10,stage);
            semiIntersect(circle,color,c11,stage);
            semiIntersect(circle,color,c12,stage);
            semiIntersect(circle,color,c19,stage);
            semiIntersect(circle,color,c20,stage);
            semiIntersect(circle,color,c21,stage);
            semiIntersect(circle,color,c22,stage);
            semiIntersect(circle,color,c23,stage);
            semiIntersect(circle,color,c24 ,stage);
            semiIntersect(circle,color,c1,stage);
            semiIntersect(circle,color,c2,stage);
            semiIntersect(circle,color,c3,stage);
            semiIntersect(circle,color,c4,stage);
            semiIntersect(circle,color,c5,stage);
            semiIntersect(circle,color,c6,stage);

        }
    }



    public void moveCircle(double distance){
        this.star.setY(this.star.getY()+distance);
        this.colorwheel.setY(this.colorwheel.getY()+distance);
        c1.setCenterY(c1.getCenterY()+distance);
        c2.setCenterY(c2.getCenterY()+distance);
        c3.setCenterY(c3.getCenterY()+distance);
        c4.setCenterY(c4.getCenterY()+distance);
        c5.setCenterY(c5.getCenterY()+distance);
        c6.setCenterY(c6.getCenterY()+distance);
        c7.setCenterY(c7.getCenterY()+distance);
        c8.setCenterY(c8.getCenterY()+distance);

        c9.setCenterY(c9.getCenterY()+distance);
        c10.setCenterY(c10.getCenterY()+distance);
        c11.setCenterY(c11.getCenterY()+distance);
        c12.setCenterY(c12.getCenterY()+distance);
        c13.setCenterY(c13.getCenterY()+distance);
        c14.setCenterY(c14.getCenterY()+distance);
        c15.setCenterY(c15.getCenterY()+distance);
        c16.setCenterY(c16.getCenterY()+distance);
        c17.setCenterY(c17.getCenterY()+distance);
        c18.setCenterY(c18.getCenterY()+distance);
        c19.setCenterY(c19.getCenterY()+distance);

        c20.setCenterY(c20.getCenterY()+distance);
        c21.setCenterY(c21.getCenterY()+distance);
        c22.setCenterY(c22.getCenterY()+distance);
        c23.setCenterY(c23.getCenterY()+distance);
        c24.setCenterY(c24.getCenterY()+distance);
    }


    public double getStar(){
        return  c1.getCenterY()+100;
    }
    public ImageView getColorWheelImg(){
        return colorwheel;
    }

    public double getColorWheel(){
        return c1.getCenterY()+270;
    }
    public ImageView getStarImg(){
        return star;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        root.getChildren().add(getStarImg());
        root.getChildren().add(getColorWheelImg());
        init(primaryStage);
        primaryStage.show();
    }
}