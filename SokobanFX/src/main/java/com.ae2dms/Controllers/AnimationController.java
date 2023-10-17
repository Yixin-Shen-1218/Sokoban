package com.ae2dms.Controllers;

import com.ae2dms.Main.Main;
import com.ae2dms.Music.AnimationBGM;
import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;

/**
 * <p> The Class AnimationController is the controller class of animation.fxml.
 * It sets the animation paths of fxml element in the animation scene, and define a mouse event which change to the menu scene.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/25-12:37
 * @since 1.0
 */
public class AnimationController {
    /**
     * fxml element, Text box at the bottom of the screen.
     */
    public Text ContinueBox;

    /**
     * fxml element, the right player img.
     */
    public ImageView rightPlayer;

    /**
     * fxml element, the left player img.
     */
    public ImageView leftPlayer;

    /**
     * fxml element, the blue crate img.
     */
    public ImageView blueCrate;

    /**
     * fxml element, the red crate img.
     */
    public ImageView redCrate;


    /**
     * Initialize the scene element, set the animation path and play.
     * <p> Define the path of the fxml elements, and set the animation of the text at the bottom of the screen. Play Repeated.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/28-19:37
     */
    public void initialize() throws IOException {
        // Play the Animation BGM
        AnimationBGM.getInstance().playMusic();

        // set the animation path of rightPlayer
        KeyValue keyValueX = new KeyValue(rightPlayer.xProperty(), 350, Interpolator.EASE_IN);
        KeyValue keyValueY = new KeyValue(rightPlayer.yProperty(), 0, Interpolator.EASE_OUT);

        // set the animation path of blueCrate
        KeyValue keyValueX2 = new KeyValue(blueCrate.xProperty(), 350, Interpolator.EASE_IN);
        KeyValue keyValueY2 = new KeyValue(blueCrate.yProperty(), 0, Interpolator.EASE_OUT);

        // set the animation path of leftPlayer
        KeyValue keyValueX3 = new KeyValue(leftPlayer.xProperty(), -350, Interpolator.EASE_IN);
        KeyValue keyValueY3 = new KeyValue(leftPlayer.yProperty(), 0, Interpolator.EASE_OUT);

        // set the animation path of redCrate
        KeyValue keyValueX4 = new KeyValue(redCrate.xProperty(), -350, Interpolator.EASE_IN);
        KeyValue keyValueY4 = new KeyValue(redCrate.yProperty(), 0, Interpolator.EASE_OUT);

        // set the keyFrames of the fxml elements
        KeyFrame keyFrame = new KeyFrame(Duration.millis(4000), keyValueX, keyValueY);
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(4000), keyValueX2, keyValueY2);
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(4000), keyValueX3, keyValueY3);
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(4000), keyValueX4, keyValueY4);

        // play repeated
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().addAll(keyFrame, keyFrame2, keyFrame3, keyFrame4);
        timeline.play();

        // set the animation of continue text
        FadeTransition ft = new FadeTransition(Duration.millis(1500), ContinueBox);
        ft.setFromValue(1.0);
        ft.setToValue(0.2);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }

    /**
     * StartGame, click the screen, jump to the menu scene.
     * <p> Click the screen, call the function to stop the animation BGM and change the scene to menu scene.
     *
     * @param mouseEvent mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/28-20:12
     */
    public void StartGame(MouseEvent mouseEvent) throws IOException {
        AnimationBGM.getInstance().stopMusic();
        Main.setRoot("/FXML/menu");
    }
}
