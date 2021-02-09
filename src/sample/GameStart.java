package sample;


import java.lang.ClassNotFoundException;
import java.lang.NoClassDefFoundError;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.scene.Group;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.input.KeyEvent;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameStart extends Application implements EventHandler<KeyEvent> {

    private double ballvel;
    private double timediff;
    private double old_time;
    private double circle_y=525.0f;
    private Circle circle;
    private sample.Circle o1;
    private sample.Circle o2;
    private sample.Circle o3;
    private sample.Triangle t1;
    private sample.TwoCircle tc;
    private Text scoreField;
    private int score=0;
    private String scoreStr;
    private boolean[] starbool;
    private boolean[] intersectbool;
    private boolean[] colorwheelbool;
    private final double distance_bw_obs=725/2;
    private sample.Rhombus r1;
    private sample.DottedCircle d1;
    private sample.Triangle tr1;
    private sample.Plus p1;
    private sample.TwoPlus tp1;

    @Override
    public void start(Stage stage) throws Exception {
        initUI(stage);
    }

    private void initUI(Stage stage) throws Exception {
        //ball =cicrle
        circle = new Circle();
        circle.setCenterX(195.0f);
        circle_y=525.0f;
        circle.setCenterY(circle_y);
        circle.setRadius(10.0f);

        circle.setFill(Color.YELLOW);

        starbool=new boolean[10000];
        intersectbool=new boolean[10000];
          colorwheelbool=new boolean[10000];
        for(int i=0;i<10000;i++){
            starbool[i]=false;
            intersectbool[i]=false;
            colorwheelbool[i]=false;
        }

        AnchorPane group = new AnchorPane();
        group.setStyle("-fx-background-color: #000000");
//        group.setStyle("-fx-background-color: #202020");
        group.getChildren().add(circle);
        old_time=System.nanoTime();

        //SDisplay score in text field
        scoreStr=Integer.toString(score);
        scoreField=new Text(scoreStr);
        scoreField.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 50));
        scoreField.setFill(Color.WHITE);
        scoreField.setX(25);
        scoreField.setY(75);

        //1 Circle
        //2 Dotted Circle
        //3 Triangle
        //4 TwoCircle
        //5 Rhombus
        //6 Plus
        //7 TwoPlus

        o1=new sample.Circle(group, stage,0,1*distance_bw_obs);
        o1.getColorWheelImg().setImage(null);
        o2=new sample.Circle(group, stage,0,0*distance_bw_obs);
        o3=new sample.Circle(group, stage,0,-1*distance_bw_obs);
        d1=new sample.DottedCircle(group,stage,-10,65-4*distance_bw_obs);
        tr1=new sample.Triangle(group,stage,0,65-5*distance_bw_obs);
        tc=new TwoCircle(group,stage,0,-2*distance_bw_obs);
//        r1=new Rhombus(group,stage,0,200 -6*distance_bw_obs);
        p1=new Plus(group,stage,-80, 100-6*distance_bw_obs);
        tp1=new TwoPlus(group,stage,-13,150-7*distance_bw_obs);
        group.getChildren().add(scoreField);

        AnimationTimer timer = new MyTimer(old_time,stage);
        timer.start();
        var scene = new Scene(group, 400, 600);
        scene.setOnKeyPressed(this);
        stage.setTitle("AnimationTimer");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode().toString().equals("SPACE")){
            ballvel=510;
        }

    }



    private class MyTimer extends AnimationTimer {
        private double t_old;
        private Stage stage;

        public MyTimer(double t_old, Stage stage) {
            this.stage=stage;
            this.t_old=t_old;
        }

        @Override
        public void handle(long now) {
            timediff=(double)(now - t_old)/1000000000;
            t_old=now;
            try {
                doHandle(now);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public int generateRandom(){

            Random ran = new Random();
            int x = ran.nextInt(4)+1;
            if( circle.getFill()==Color.AQUA){
                // x can't be 1
                while(x==1){
                    x=ran.nextInt(4)+1;
                }
            }

            if( circle.getFill()==Color.BLUEVIOLET){
                // x can't be 2
                while(x==2){
                    x=ran.nextInt(4)+1;
                }
            }
            if( circle.getFill()==Color.DEEPPINK){
                // x can't be 3
                while(x==3){
                    x=ran.nextInt(4)+1;
                }
            }
            if( circle.getFill()==Color.YELLOW){
                // x can't be 4
                while(x==4){
                    x=ran.nextInt(4)+1;
                }
            }
            return x;
        }

        public void changeColor(int x){
            if(x==1){
                circle.setFill(Color.AQUA);
            }
            else if(x==2){
                circle.setFill(Color.BLUEVIOLET);
            }
            else if(x==3){
                circle.setFill(Color.DEEPPINK);
            }
            else{
                circle.setFill(Color.YELLOW);
            }
        }


        private void doHandle(long now) throws IOException {
            if(circle_y>=525 && ballvel<=0) {
                ballvel=0;
                return;
            }
            double dist=(ballvel * timediff) - ((2000 * timediff * timediff)/2);
            if(circle_y-dist<525/2){
                o1.moveCircle(dist);
                o2.moveCircle(dist);
                o3.moveCircle(dist);
                tc.moveCircle(dist);
                d1.moveCircle(dist);
                tr1.moveCircle(dist);
//                r1.moveCircle(dist);
                p1.moveCircle(dist);
                tp1.moveCircle(dist);
//                circle_y = circle_y - dist;
                circle.setCenterY(525/2);
            }
            else {
                circle_y = circle_y - dist;
                circle.setCenterY(circle_y);
            }
//            System.out.println(circle_y);
                  ballvel=ballvel-2000*timediff;

            //iterate a for loop for stars, inside the loop do this
            if(circle_y<=o1.getStar() && starbool[0]==false){
                o1.getStarImg().setImage(null);
                score+=1;
                starbool[0]=true;
            }
            if(circle_y<=o2.getStar() && starbool[1]==false ){
                o2.getStarImg().setImage(null);
                score+=1;
                starbool[1]=true;
            }
            if(circle_y<=o3.getStar() && starbool[2]==false){
                o3.getStarImg().setImage(null);
                score+=1;
                starbool[2]=true;
            }
            if(circle_y<=tc.getStar() && starbool[3]==false){
                tc.getStarImg().setImage(null);
                score+=1;
                starbool[3]=true;
            }
            if(circle_y<=d1.getStar() && starbool[4]==false){
                d1.getStarImg().setImage(null);
                score+=1;
                starbool[4]=true;
            }
            if(circle_y<= tr1.getStar()&& starbool[5]==false){
                tr1.getStarImg().setImage(null);
                score+=1;
                starbool[5]=true;
            }
//            if(circle_y<= r1.getStar()&& starbool[6]==false){
//                r1.getStarImg().setImage(null);
//                score+=1;
//                starbool[6]=true;
//            }
            if(circle_y<= p1.getStar()&& starbool[7]==false){
                p1.getStarImg().setImage(null);
                score+=1;
                starbool[7]=true;
            }
            if(circle_y<= tp1.getStar()&& starbool[8]==false){
                tp1.getStarImg().setImage(null);
                score+=1;
                starbool[8]=true;
            }

            scoreStr=Integer.toString(score);
            scoreField.setText(scoreStr);



            //ColorWheel


            if(circle_y<=o2.getColorWheel() && colorwheelbool[1]==false){
                o2.getColorWheelImg().setImage(null);
                int x=generateRandom();
                System.out.println("THE value of x is : " + x);
                changeColor(x);
                colorwheelbool[1]=true;
            }

            if(circle_y<= o3.getColorWheel() && colorwheelbool[2]==false ){
                o3.getColorWheelImg().setImage(null);
                int x=generateRandom();
                System.out.println("THE value of x is : " + x);
                changeColor(x);
                colorwheelbool[2]=true;
            }

            if(circle_y<=tc.getColorWheel() && colorwheelbool[3]==false){
                tc.getColorWheelImg().setImage(null);
                int x=generateRandom();
                System.out.println("THE value of x is : " + x);
                changeColor(x);
                colorwheelbool[3]=true;
            }
            if(circle_y<=d1.getColorWheel() && colorwheelbool[4]==false){
                d1.getColorWheelImg().setImage(null);
                int x=generateRandom();
                System.out.println("THE value of x is : " + x);
                changeColor(x);
                colorwheelbool[4]=true;
            }

            if(circle_y<=tr1.getColorWheel() && colorwheelbool[5]==false){
                tr1.getColorWheelImg().setImage(null);
                int x=generateRandom();
                while(x==2){
                    x=generateRandom();
                }
                System.out.println("THE value of x is : " + x);
                changeColor(x);
                colorwheelbool[5]=true;
            }

//            if(circle_y<=r1.getColorWheel() && colorwheelbool[6]==false){
//                r1.getColorWheelImg().setImage(null);
//                int x=generateRandom();
//                System.out.println("THE value of x is : " + x);
//                changeColor(x);
//                colorwheelbool[6]=true;
//            }

            if(circle_y<=p1.getColorWheel() && colorwheelbool[7]==false){
                p1.getColorWheelImg().setImage(null);
                int x=generateRandom();
                System.out.println("THE value of x is : " + x);
                changeColor(x);
                colorwheelbool[7]=true;
            }

            if(circle_y<=tp1.getColorWheel() && colorwheelbool[8]==false){
                tp1.getColorWheelImg().setImage(null);
                int x=generateRandom();
                System.out.println("THE value of x is : " + x);
                changeColor(x);
                colorwheelbool[8]=true;
            }


            //Intersection

            o1.collisionCheckCircle(circle,stage);
            o2.collisionCheckCircle(circle,stage);
            o3.collisionCheckCircle(circle,stage);
            tc.collisionCheckCircle(circle,stage);
            d1.collisionCheckCircle(circle,stage);
            tr1.collisionCheckCircle(circle,stage);
//              r1.collisionCheckCircle(circle,stage);
            p1.collisionCheckCircle(circle,stage);
            tp1.collisionCheckCircle(circle,stage);
            //End Intersection

        }

    }

    public static void main(String[] args) {
        launch(args);
//        System.out.println("HELLOOOO69");
    }
}
