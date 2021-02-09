package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
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

public class Infinity {

    @FXML
    private Button ClassicButton;

    @FXML
    private Button ReturnHome;

    @FXML
    private Button FireFlyButton;

    @FXML
    private void goBackFromInfinityAction(ActionEvent event) throws IOException {
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

}
