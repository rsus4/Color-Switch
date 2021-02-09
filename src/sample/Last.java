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



public class Last {

    @FXML
    private ImageView firstSmallRing;
    @FXML
    private ImageView secondSmallRing;

    public void rot(ImageView imv, int mul){
        RotateTransition rotate = new RotateTransition(Duration.millis(3000));
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360*mul);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        //rotate.setAutoReverse(true);
        rotate.setNode(imv);
        rotate.play();
    }

    public void play(){
        rot(firstSmallRing,1);
        rot(secondSmallRing,-1);
    }

    @FXML
    private void handleLastReturn(ActionEvent event) throws IOException {
        System.out.println("You clicked return home button ");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("imageRing.fxml"));
        Parent root = loader.load();
//        Parent home_page_parent= FXMLLoader.load(getClass().getResource("imageRing.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Image myImage=(Image) (loader.getController());
        myImage.play();
        Scene scene1 =new Scene(root);
        Stage home_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        home_stage.setScene(scene1);
        home_stage.show();
    }

    @FXML
    private void handleRetry(ActionEvent event) throws IOException {
        System.out.println("You clicked return home button ");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = loader.load();
//        Parent home_page_parent= FXMLLoader.load(getClass().getResource("imageRing.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Game myGame=(Game) (loader.getController());
        myGame.play();
        Scene scenePlay =new Scene(root);
        Stage home_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        home_stage.setScene(scenePlay);
        home_stage.show();
    }
}
