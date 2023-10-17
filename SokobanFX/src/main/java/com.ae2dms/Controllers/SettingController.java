package com.ae2dms.Controllers;

import com.ae2dms.Main.Main;
import com.ae2dms.Music.ClickSound;
import com.ae2dms.Music.ToggleSound;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

import java.io.IOException;

/**
 * <p> The Class SettingController is the controller class of setting.fxml.
 * Initialize the setting scene, define some mouse event, use to control the soundEffect in the game and crates colors.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/25-13:34
 * @since 1.0
 */
public class SettingController {
    /**
     * fxml element, soundEffect check box.
     */
    @FXML
    public CheckBox SoundControl;
    /**
     * fxml element, volume on img.
     */
    public ImageView ImgOn;
    /**
     * fxml element, volume off img.
     */
    public ImageView ImgOff;
    /**
     * Defines whether the sound effect is on or off.
     */
    public static boolean soundEffect = true;
    /**
     * fxml element, a comboBox for choosing crates color in the game.
     */
    public ComboBox<String> ColorBox;

    /**
     * Defines the crates color in the game, 0 to BLUE, 1 to GREEN, 2 to RED.
     */
    public static int Color = 0;

    /**
     * fxml element, Return to menu button.
     */
    public Button Return;

    /**
     * Initialize the setting scene.
     * <p> set ImgOn and ImgOff visible or not according to soundEffect.
     * Set the color box options, set the initial value for the box according to Color value.
     *
     * @author Yixin SHEN
     * @date 2020/11/29-17:18
     */
    public void initialize() {
        SoundControl.setSelected(soundEffect);
        ImgOn.setVisible(soundEffect);
        ImgOff.setVisible(!soundEffect);

        ObservableList<String> options = FXCollections.observableArrayList("BLUE", "GREEN", "RED");
        ColorBox.setItems(options);
        if (Color == 0) {
            ColorBox.setValue("BLUE");
        } else if (Color == 1) {
            ColorBox.setValue("GREEN");
        } else {
            ColorBox.setValue("RED");
        }
    }

    /**
     * Return to the menu scene.
     * <p> Click the button, play the interface sound and return to the menu scene.
     *
     * @param actionEvent Mouse click.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date   2020/11/29-17:21
     */
    public void ReturnMenu(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/menu");
    }

    /**
     * Control the soundEffect value, set the value to opposite value.
     * <p> Set the soundEffect value to its oppsite value, play the interface sound and set the visivle value to the ImgOn and ImgOff.
     *
     * @param actionEvent Mouse click.
     * @author Yixin SHEN
     * @date   2020/11/29-17:23
     */
    public void SoundControl(ActionEvent actionEvent) {
        ToggleSound.getInstance().playMusic();
        soundEffect = !soundEffect;
        if (soundEffect) {
            ImgOn.setVisible(true);
            ImgOff.setVisible(false);
        } else {
            ImgOn.setVisible(false);
            ImgOff.setVisible(true);
        }
    }

    /**
     * Set the Color value.
     * <p> Play the interface sound and set the Color value according to what color player chosen.
     *
     * @param actionEvent Mouse click.
     * @author Yixin SHEN
     * @date   2020/11/29-17:26
     */
    public void SetColor(ActionEvent actionEvent) {
        ToggleSound.getInstance().playMusic();
        if (ColorBox.getValue() == "BLUE") {
            Color = 0;
        } else if (ColorBox.getValue() == "GREEN") {
            Color = 1;
        } else {
            Color = 2;
        }
    }
}
