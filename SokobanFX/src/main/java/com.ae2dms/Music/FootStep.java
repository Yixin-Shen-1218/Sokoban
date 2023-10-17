package com.ae2dms.Music;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * <p> The Class FootStep load the FootStep file and defines some methods to manipulate the AudioClip.
 * The Class FootStep load the FootStep file and defines some methods to manipulate the AudioClip, use singleton design pattern.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/24-20:04
 * @since 1.0
 */
public class FootStep {
    /**
     * Defines the instance of the FootStep class.
     */
    private static final FootStep footStep = new FootStep();
    /**
     * Defines the AudioClip music to load the music file.
     */
    private final AudioClip music;

    /**
     * The constructor of FootStep class.
     * <p> Instantiate the FootStep object.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:55
     */
    private FootStep(){
        // Load footstep_wood file
        URL url = this.getClass().getClassLoader().getResource("music/footstep_wood.wav");
        assert url != null;
        music = new AudioClip(url.toExternalForm());
        music.setCycleCount(1);
        music.play();
    }

    /**
     * Return the instance of FootStep.
     * <p> Return the instance of FootStep.
     *
     * @return com.ae2dms.Music.AnimationBGM The instance of FootStep.
     * @author Yixin SHEN
     * @date 2020/11/30-23:57
     */
    public static FootStep getInstance(){
        return footStep;
    }

    /**
     * Play the music.
     * <p> Play the music.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:58
     */
    public void playMusic(){
        music.play();
    }
}
