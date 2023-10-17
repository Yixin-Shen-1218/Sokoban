package com.ae2dms.Music;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * <p> The Class BGM load the BGM file and defines some methods to manipulate the AudioClip.
 * The Class BGM load the BGM file and defines some methods to manipulate the AudioClip, use singleton design pattern.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/26-17:52
 * @since 1.0
 */
public class BGM {
    /**
     * Defines the instance of the BGM class.
     */
    private static final BGM instance = new BGM();
    /**
     * Defines the AudioClip music to load the music file.
     */
    private final AudioClip music;

    /**
     * The constructor of BGM class.
     * <p> Instantiate the BGM object.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:55
     */
    private BGM() {
        // Load BGM file
        URL url = this.getClass().getClassLoader().getResource("music/puzzle_theme.wav");
        assert url != null;
        music = new AudioClip(url.toExternalForm());
        music.setCycleCount(AudioClip.INDEFINITE);
        music.setVolume(0.4);
        music.play();
    }

    /**
     * Return the instance of AnimationBGM.
     * <p> Return the instance of AnimationBGM.
     *
     * @return com.ae2dms.Music.AnimationBGM The instance of AnimationBGM.
     * @author Yixin SHEN
     * @date 2020/11/30-23:57
     */
    public static BGM getInstance() {
        return instance;
    }

    /**
     * Stop the music.
     * <p> Stop the music.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:58
     */
    public void stopMusic() {
        music.stop();
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
