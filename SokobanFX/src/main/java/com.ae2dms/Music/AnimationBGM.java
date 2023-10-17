package com.ae2dms.Music;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * <p> The Class AnimationBGM load the AnimationBGM file and defines some methods to manipulate the AudioClip.
 * The Class AnimationBGM load the AnimationBGM file and defines some methods to manipulate the AudioClip, use singleton design pattern.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/26-17:52
 * @since 1.0
 */
public class AnimationBGM {
    /**
     * Defines the instance of the AnimationBGM class.
     */
    private static final AnimationBGM instance = new AnimationBGM();
    /**
     * Defines the AudioClip music to load the music file.
     */
    private final AudioClip music;

    /**
     * The constructor of AnimationBGM class.
     * <p> Instantiate the AnimationBGM object.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:55
     */
    private AnimationBGM() {
        // Load BGM file
        URL url = this.getClass().getClassLoader().getResource("music/Animation.mp3");
        assert url != null;
        music = new AudioClip(url.toExternalForm());
        music.setCycleCount(AudioClip.INDEFINITE);
        music.setVolume(0.3);
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
    public static AnimationBGM getInstance() {
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
