package sample;

//import javafx.animation.Animation;
//import javafx.animation.RotateTransition;
//import javafx.scene.transform.Rotate;
//import javafx.util.Duration;
//import javafx.scene.control.*;
//import javafx.scene.shape.*;
//import java.lang.Object;
//import javafx.animation.Interpolator;
//import javafx.scene.control.Label;
//

//import javax.swing.text.html.ImageView;

//import com.sun.glass.ui.Application;
import javafx.application.Application;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Image {

    @FXML
    private ImageView ImgOuterRing;

    @FXML
    private ImageView ImgInnerRing;

    @FXML
    private ImageView ImgMiddleRing;

    @FXML
    private ImageView textRing1;

    @FXML
    private ImageView textRing2;
    @FXML
    private ImageView Imgstop;
    @FXML
    private ImageView ImgLeaderboard;
    @FXML
    private Button greyPlayButton;

    @FXML
    private Button SettingsButton;

    @FXML
    private Button InfinityButton;

    @FXML
    public static Button QuestionMarkButton;

    @FXML
    private Button GameModesButton;

    @FXML private javafx.scene.control.Button StopButton;


    private Stage ps;

    public void setStage(Stage s){
        this.ps=s;
    }

//    public Image(String s) {
//    }


//    private void SetRotate(ImageView ring1){
//        RotateTransition rt=new RotateTransition(Duration.seconds(10));
//        rt.setNode(ring1);
//    }


//    public static Button getGreyPlayButton() {
//        return greyPlayButton;
//    }
//
//    public static Button getSettingsButton() {
//        return SettingsButton;
//    }
//
//    public static Button getInfinityButton() {
//        return InfinityButton;
//    }
//
    public Button getQuestionMarkButton() {
        return QuestionMarkButton;
    }
//
//    public static Button getGameModesButton() {
//        return GameModesButton;
//    }

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

//    public static void changeScreen( Stage primaryStage, Scene sceneInfo){
//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent e)
//            {
////                l.setText("   button   selected    ");
//                QuestionMarkButton.setOnAction(e->primaryStage.setScene(sceneInfo));
//
//            }
//        };
//       QuestionMarkButton.setOnAction(e->primaryStage.setScene(sceneInfo));
//
//    }

    public void init(Stage s){
        this.ps=s;
    }

//    public void SettingsMenu() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
//        Parent root = null;
//        try{
//            root=loader.load();
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
//        Settings mySettings=(Settings) (loader.getController());
////        mySettings.init(this.ps);
//        this.ps.setTitle("Color Switch");
//        Scene sceneSettings=new Scene(root);
//        this.ps.setScene(sceneSettings);
////        this.ps.show();
//    }

    @FXML
    private void handleQuestionAction(ActionEvent event) throws IOException{
        System.out.println("You clicked Questions button ");
        Parent question_page_parent= FXMLLoader.load(getClass().getResource("info.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Scene sceneinfo =new Scene(question_page_parent);
        Stage ques_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        ques_stage.setScene(sceneinfo);
        ques_stage.show();
    }

    @FXML
    private void handleInfinityAction(ActionEvent event) throws IOException{
        System.out.println("You clicked Infinity button ");
        Parent infinite_page_parent= FXMLLoader.load(getClass().getResource("infinity.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Scene sceneinfinity =new Scene(infinite_page_parent);
        Stage infinity_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        infinity_stage.setScene(sceneinfinity);
        infinity_stage.show();
    }

    @FXML
    private void handleSettingsAction(ActionEvent event) throws IOException{
        System.out.println("You clicked Settings button ");
        Parent settings_page_parent= FXMLLoader.load(getClass().getResource("settings.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Scene scenesettings =new Scene(settings_page_parent);
        Stage some_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        some_stage.setScene(scenesettings);
        some_stage.show();
    }

    @FXML
    private void handleGameAction(ActionEvent event) throws Exception {
//        System.out.println("You clicked Play button ");
//        Parent settings_page_parent= FXMLLoader.load(getClass().getResource("game.fxml"));
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
//        Scene scenegame =new Scene(settings_page_parent);
//        Stage some_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        some_stage.setScene(scenegame);
//
//        some_stage.show();
//




        //GAMEE MENU GUI
//        System.out.println("You clicked return home button ");
//       FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
//
//        Parent root = loader.load();
//
//        Game myGame=(Game) (loader.getController());
//        myGame.play();
//        Scene scenePlay =new Scene(root);
//        Stage home_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        home_stage.setScene(scenePlay);
//        home_stage.show();
        String[] arguments = new String[] {"123"};
//        GameStart.main(arguments);

//        Stage s = new Stage();
//       GameStart gs=new GameStart();
//       gs.start(s);

//        gs.start(GameStart.s);
        new GameStart().start(ps);
//        Application.launch(GameStart.class,arguments);

    }

    @FXML
    private void handleGameModesAction(ActionEvent event) throws IOException{
        System.out.println("You clicked Play button ");
        Parent settings_page_parent= FXMLLoader.load(getClass().getResource("infinity.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Scene scenegame =new Scene(settings_page_parent);
        Stage some_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        some_stage.setScene(scenegame);

        some_stage.show();

    }

    @FXML
    private void handleStopAction(ActionEvent event) throws IOException{
        System.out.println("You clicked Stop button ");
//        Parent settings_page_parent= FXMLLoader.load(getClass().getResource("infinity.fxml"));
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
//        Scene scenegame =new Scene(settings_page_parent);
//        Stage some_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        some_stage.setScene(scenegame);
////
////        some_stage.show();
        //this.ps.close();

        Stage stage = (Stage) StopButton.getScene().getWindow();
        stage.close();

    }


    @FXML
    private void handleLeaderBoardAction(ActionEvent event) throws IOException{
        System.out.println("You clicked leaderboard button ");
        Parent settings_page_parent= FXMLLoader.load(getClass().getResource("leaderboard.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Scene sceneLeader =new Scene(settings_page_parent);
        Stage some_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        some_stage.setScene(sceneLeader);
        some_stage.show();

    }

    @FXML
    private void ActionresumeSaved(ActionEvent event) throws IOException{
        System.out.println("You clicked resumeSaved button ");
        Parent settings_page_parent= FXMLLoader.load(getClass().getResource("resumeSaved.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Scene sceneLeader =new Scene(settings_page_parent);
        Stage some_stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        some_stage.setScene(sceneLeader);
        some_stage.show();

    }

    public void play() {
        System.out.println("HI");
        System.out.println(6);
        rot(ImgInnerRing,1);
        rot(ImgOuterRing,1);
        rot(ImgMiddleRing,-1);
        rot(textRing1,1);
        rot(textRing2,-1);
        rot(ImgLeaderboard,1);
        rot(Imgstop,-1);
    }
}