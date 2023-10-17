package com.ae2dms.Music;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * <p> The Class ImpactCrate load the ImpactCrate file and defines some methods to manipulate the AudioClip.
 * The Class ImpactCrate load the ImpactCrate file and defines some methods to manipulate the AudioClip, use singleton design pattern.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/24-20:23
 * @since 1.0
 */
public class ImpactCrate {
    /**
     * Defines the instance of the ImpactCrate class.
     */
    private static final ImpactCrate impactCrate = new ImpactCrate();
    /**
     * Defines the AudioClip music to load the music file.
     */
    private final AudioClip music;

    /**
     * The constructor of ImpactCrate class.
     * <p> Instantiate the ImpactCrate object.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-23:55
     */
    private ImpactCrate() {
        // Load impactCrate file
        URL url = this.getClass().getClassLoader().getResource("music/impactCrate.wav");
        assert url != null;
        music = new AudioClip(url.toExternalForm());
        music.setCycleCount(1);
        music.play();
    }

    /**
     * Return the instance of ImpactCrate.
     * <p> Return the instance of ImpactCrate.
     *
     * @return com.ae2dms.Music.AnimationBGM The instance of ImpactCrate.
     * @author Yixin SHEN
     * @date 2020/11/30-23:57
     */
    public static ImpactCrate getInstance() {
        return impactCrate;
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
