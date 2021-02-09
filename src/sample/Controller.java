package sample;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Controller {

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

}
