package com.ae2dms.Music;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * <p> The Class ErrorSound load the ErrorSound file and defines some methods to manipulate the AudioClip.
 * The Class ErrorSound load the ErrorSound file and defines some methods to manipulate the AudioClip, use singleton design pattern.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/26-16:52
 * @since 1.0
 */
public class ErrorSound {
    /**
     * Defines the instance of the ErrorSound class.
     */
    private static final ErrorSound ERROR_SOUND = new ErrorSound();
    /**
     * Defines the AudioClip music to load the music file.
     */
    private final AudioClip music;

    /**
     * The constructor of ConfirmSound class.
     * <p> Instantiate the ConfirmSound object.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:55
     */
    private ErrorSound() {
        // Load error file
        URL url = this.getClass().getClassLoader().getResource("music/error.wav");
        assert url != null;
        music = new AudioClip(url.toExternalForm());
        music.setCycleCount(1);
        music.play();
    }
    /**
     * Return the instance of ErrorSound.
     * <p> Return the instance of ErrorSound.
     *
     * @return com.ae2dms.Music.AnimationBGM The instance of ErrorSound.
     * @author Yixin SHEN
     * @date 2020/11/30-23:57
     */
    public static ErrorSound getInstance() {
        return ERROR_SOUND;
    }

    /**
     * Play the music.
     * <p> Play the music.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:58
     */
    public void playMusic() {
        music.play();
    }
}
