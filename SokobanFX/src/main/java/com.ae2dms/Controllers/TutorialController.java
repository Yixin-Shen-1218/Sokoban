package com.ae2dms.Controllers;

import com.ae2dms.Main.Main;
import com.ae2dms.Music.ClickSound;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.IOException;
import java.net.URL;

/**
 * <p> The Class TutorialController is the controller class of tutorial.fxml.
 * Initialize the tutorial scene, define media mouse events and load the video resource.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/28-19:20
 * @since 1.0
 */
public class TutorialController {
    /**
     * fxml element, MediaView for tutorial video.
     */
    public MediaView TutorialView;
    /**
     * fxml element, Return button to menu scene.
     */
    public Button Return;
    /**
     * fxml element, Play button to play the video.
     */
    public Button Play;
    /**
     * fxml element, Stop button to stop the video.
     */
    public Button Stop;
    /**
     * MediaPlayer object, load the video resource.
     */
    private MediaPlayer mp;

    /**
     * Initialize the tutorial scene, load the tutorial video.
     * <p> Initialize the tutorial scene, load the tutorial video and set the MediaView width and height.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-15:38
     */
    public void initialize() {
        URL url = this.getClass().getClassLoader().getResource("video/Tutorial.mp4");
        Media media = new Media(url.toExternalForm());

        mp = new MediaPlayer(media);

        TutorialView.setFitWidth(352);
        TutorialView.setFitHeight(288);

        TutorialView.setMediaPlayer(mp);
    }

    /**
     * Mouse event method, click the button set the scene to menu scene.
     * <p> Jump to the erase menu scene and play the interface sound. Stop the mediaPlayer.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date   2020/11/30-15:40
     */
    public void ReturnMenu(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/menu");
        mp.stop();
    }

    /** 
     * Play the tutorial video.
     * <p> Click the button to play the tutorial video.
     * 
     * @param actionEvent Mouse click.
     * @author Yixin SHEN
     * @date   2020/11/30-15:41
     */
    public void PlayVideo(ActionEvent actionEvent) {
        ClickSound.getInstance().playMusic();
        mp.play();
    }

    /**
     * Stop the tutorial video.
     * <p> Click the button to stop the tutorial video.
     *
     * @param actionEvent Mouse click.
     * @author Yixin SHEN
     * @date   2020/11/30-15:42
     */
    public void StopVideo(ActionEvent actionEvent) {
        ClickSound.getInstance().playMusic();
        mp.stop();
    }
}
