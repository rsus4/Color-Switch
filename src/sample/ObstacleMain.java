package sample;
/*
    Made with <3 by Group 36
    Rishit and Dhairya :))
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ObstacleMain extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        AnchorPane root = new AnchorPane();
        root.setMaxHeight(675);
        root.setMaxWidth(425);
        root.setMinHeight(675);
        root.setMinWidth(425);

        Color c = new Color(0.13,0.13,0.13,1.0);

        Scene scene = new Scene(root, c);
        stage.setScene(scene);
        stage.setTitle("Color Switch");

//        Obstancles for demonstration purposes:
//        Circle o1=new Circle(root, stage,200);
//    TwoCircle o2=new TwoCircle(root, stage,200);
//        Triangle o3=new Triangle(root, stage,10);
//        DottedCircle o4=new DottedCircle(root, stage);
//        Plus o5=new Plus(root, stage,0,0);
        TwoPlus o6=new TwoPlus(root,stage,-13,0);
//          Rhombus o7=new Rhombus(root, stage,105);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}