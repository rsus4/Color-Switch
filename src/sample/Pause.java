package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Pause {

    @FXML
    private void ActionReturnHome(ActionEvent event) throws IOException {
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
    private void ActionResume(ActionEvent event) throws IOException{
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
