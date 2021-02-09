package sample;



import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;



import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.*;




public class Main extends Application {

    Scene scene1,sceneInfo;

    @Override
    public void start(Stage primaryStage) throws Exception{


//        Parent settings_page_parent= FXMLLoader.load(getClass().getResource("introScreen.fxml"));
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
//        Scene sceneintro =new Scene(settings_page_parent);
//        primaryStage.setTitle("Color Switch");
//        primaryStage.setScene(sceneintro);
//        primaryStage.show();
////        for(long i=0;i<1000000000;i++){
////            //timepass
////        }
//        long start = System.currentTimeMillis();
//        Thread.sleep(5000);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("imageRing.fxml"));
        Parent root = loader.load();
        Image myImage=(Image) (loader.getController());
        myImage.setStage(primaryStage);
        myImage.play();
        scene1=new Scene(root);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene1);
        primaryStage.show();


        // TESTING LAST PAGE
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("last.fxml"));
//        Parent root = loader.load();
//        Last myLast=(Last) (loader.getController());
////        myLast.play();
//        scene1=new Scene(root);
//        primaryStage.setTitle("Color Switch");
//        primaryStage.setScene(scene1);
//        primaryStage.show();

        // TESTING BALL CRASH
//        Parent infinite_page_parent= FXMLLoader.load(getClass().getResource("crashMenu.fxml"));
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
//        Scene sceneinfinity =new Scene(infinite_page_parent);
////        Stage infinity_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        primaryStage.setScene(sceneinfinity);
//        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
