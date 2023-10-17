package com.ae2dms.Music;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * <p> The Class ToggleSound load the ToggleSound file and defines some methods to manipulate the AudioClip.
 * The Class ToggleSound load the ToggleSound file and defines some methods to manipulate the AudioClip, use singleton design pattern.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/26-17:19
 * @since 1.0
 */
public class ToggleSound {
    /**
     * Defines the instance of the ToggleSound class.
     */
    private static final ToggleSound TOGGLE_SOUND = new ToggleSound();
    /**
     * Defines the AudioClip music to load the music file.
     */
    private final AudioClip music;

    /**
     * The constructor of ToggleSound class.
     * <p> Instantiate the ToggleSound object.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:55
     */
    private ToggleSound() {
        // Load toggle file
        URL url = this.getClass().getClassLoader().getResource("music/toggle.wav");
        assert url != null;
        music = new AudioClip(url.toExternalForm());
        music.setCycleCount(1);
        music.play();
    }

    /**
     * Return the instance of ToggleSound.
     * <p> Return the instance of ToggleSound.
     *
     * @return com.ae2dms.Music.AnimationBGM The instance of ToggleSound.
     * @author Yixin SHEN
     * @date 2020/11/30-23:57
     */
    public static ToggleSound getInstance() {
        return TOGGLE_SOUND;
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
