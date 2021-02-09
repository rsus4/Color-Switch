package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Game {

    @FXML
    private ImageView smallRing1;

    @FXML
    private ImageView smallRing2;

    @FXML
    private ImageView firstObstacle;


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

    public void play() {
        System.out.println("HI");
        System.out.println(6);
        rot(smallRing1,1);
        rot(smallRing2,-1);
        rot(firstObstacle,-1);
    }

    @FXML
    private void ActionPause(ActionEvent event) throws IOException {
        System.out.println("You clicked Pause button ");
        Parent settings_page_parent= FXMLLoader.load(getClass().getResource("pause.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Scene scenepause =new Scene(settings_page_parent);
        Stage some_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        some_stage.setScene(scenepause);
        some_stage.show();
    }



}
