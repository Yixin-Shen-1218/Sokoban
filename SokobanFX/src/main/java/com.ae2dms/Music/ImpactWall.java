package com.ae2dms.Music;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * <p> The Class ImpactWall load the ImpactWall file and defines some methods to manipulate the AudioClip.
 * The Class ImpactWall load the ImpactWall file and defines some methods to manipulate the AudioClip, use singleton design pattern.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/24-20:27
 * @since 1.0
 */
public class ImpactWall {
    /**
     * Defines the instance of the ImpactWall class.
     */
    private static final ImpactWall impactWall = new ImpactWall();
    /**
     * Defines the AudioClip music to load the music file.
     */
    private final AudioClip music;

    /**
     * The constructor of ImpactWall class.
     * <p> Instantiate the ImpactWall object.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:55
     */
    private ImpactWall(){
        // Load impactWall file
        URL url = this.getClass().getClassLoader().getResource("music/impactWall.wav");
        assert url != null;
        music = new AudioClip(url.toExternalForm());
        music.setCycleCount(1);
        music.play();
    }

    /**
     * Return the instance of ImpactWall.
     * <p> Return the instance of ImpactWall.
     *
     * @return com.ae2dms.Music.AnimationBGM The instance of ImpactWall.
     * @author Yixin SHEN
     * @date 2020/11/30-23:57
     */
    public static ImpactWall getInstance(){
        return impactWall;
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
