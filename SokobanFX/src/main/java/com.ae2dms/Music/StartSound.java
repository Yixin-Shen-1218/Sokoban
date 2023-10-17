package com.ae2dms.Music;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * <p> The Class StartSound load the StartSound file and defines some methods to manipulate the AudioClip.
 * The Class StartSound load the StartSound file and defines some methods to manipulate the AudioClip, use singleton design pattern.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/26-17:14
 * @since 1.0
 */
public class StartSound {
    /**
     * Defines the instance of the StartSound class.
     */
    private static final StartSound START_SOUND = new StartSound();
    /**
     * Defines the AudioClip music to load the music file.
     */
    private final AudioClip music;

    /**
     * The constructor of StartSound class.
     * <p> Instantiate the StartSound object.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:55
     */
    private StartSound() {
        // Load start file
        URL url = this.getClass().getClassLoader().getResource("music/start.wav");
        assert url != null;
        music = new AudioClip(url.toExternalForm());
        music.setCycleCount(1);
        music.play();
    }

    /**
     * Return the instance of StartSound.
     * <p> Return the instance of StartSound.
     *
     * @return com.ae2dms.Music.AnimationBGM The instance of StartSound.
     * @author Yixin SHEN
     * @date 2020/11/30-23:57
     */
    public static StartSound getInstance() {
        return START_SOUND;
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
