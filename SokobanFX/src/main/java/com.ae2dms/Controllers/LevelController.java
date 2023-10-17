package com.ae2dms.Controllers;

import com.ae2dms.GameState.GameEngine;
import com.ae2dms.Main.Main;
import com.ae2dms.Music.ClickSound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;

/**
 * <p> The Class LevelController is the controller class of level.fxml.
 * Initialize the level scene, have a static field that store the selected level, eight mouse event functions.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/28-23:49
 * @since 1.0
 */
public class LevelController {
    /**
     * Defines which level have been selected.
     */
    public static int selectLevel = 0;

    /**
     * fxml element, the first LevelButton.
     */
    @FXML
    public Button Btn1;
    /**
     * fxml element, the second LevelButton.
     */
    public Button Btn2;
    /**
     * fxml element, the third LevelButton.
     */
    public Button Btn3;
    /**
     * fxml element, the forth LevelButton.
     */
    public Button Btn4;
    /**
     * fxml element, the fifth LevelButton.
     */
    public Button Btn5;
    /**
     * fxml element, the sixth LevelButton.
     */
    public Button Btn6;
    /**
     * fxml element, the seventh LevelButton.
     */
    public Button Btn7;
    /**
     * fxml element, the eighth LevelButton.
     */
    public Button Btn8;
    /**
     * fxml element, the first Lock img.
     */
    public ImageView Lock1;
    /**
     * fxml element, the second Lock img.
     */
    public ImageView Lock2;
    /**
     * fxml element, the third Lock img.
     */
    public ImageView Lock3;
    /**
     * fxml element, the forth Lock img.
     */
    public ImageView Lock4;
    /**
     * fxml element, the fifth Lock img.
     */
    public ImageView Lock5;
    /**
     * fxml element, the sixth Lock img.
     */
    public ImageView Lock6;
    /**
     * fxml element, the seventh Lock img.
     */
    public ImageView Lock7;

    /**
     * Initialize the level scene.
     * <p> Initialize the level scene, set the properties of fxml elements in the level scene according to the maxLevel value.
     *
     * @author Yixin SHEN
     * @date 2020/11/29-16:57
     */
    public void initialize() {
        // set the fxml elements properties.
        if (GameEngine.maxLevel == 1) {
            Btn2.setDisable(true);
            Btn3.setDisable(true);
            Btn4.setDisable(true);
            Btn5.setDisable(true);
            Btn6.setDisable(true);
            Btn7.setDisable(true);
            Btn8.setDisable(true);
        } else if (GameEngine.maxLevel == 2) {
            Btn3.setDisable(true);
            Btn4.setDisable(true);
            Btn5.setDisable(true);
            Btn6.setDisable(true);
            Btn7.setDisable(true);
            Btn8.setDisable(true);
            Lock1.setVisible(false);
        } else if (GameEngine.maxLevel == 3) {
            Btn4.setDisable(true);
            Btn5.setDisable(true);
            Btn6.setDisable(true);
            Btn7.setDisable(true);
            Btn8.setDisable(true);
            Lock1.setVisible(false);
            Lock2.setVisible(false);
        } else if (GameEngine.maxLevel == 4) {
            Btn5.setDisable(true);
            Btn6.setDisable(true);
            Btn7.setDisable(true);
            Btn8.setDisable(true);
            Lock1.setVisible(false);
            Lock2.setVisible(false);
            Lock3.setVisible(false);
        } else if (GameEngine.maxLevel == 5) {
            Btn6.setDisable(true);
            Btn7.setDisable(true);
            Btn8.setDisable(true);
            Lock1.setVisible(false);
            Lock2.setVisible(false);
            Lock3.setVisible(false);
            Lock4.setVisible(false);
        } else if (GameEngine.maxLevel == 6) {
            Btn7.setDisable(true);
            Btn8.setDisable(true);
            Lock1.setVisible(false);
            Lock2.setVisible(false);
            Lock3.setVisible(false);
            Lock4.setVisible(false);
            Lock5.setVisible(false);
        } else if (GameEngine.maxLevel == 7) {
            Btn8.setDisable(true);
            Lock1.setVisible(false);
            Lock2.setVisible(false);
            Lock3.setVisible(false);
            Lock4.setVisible(false);
            Lock5.setVisible(false);
            Lock6.setVisible(false);
        } else if (GameEngine.maxLevel == 8) {
            Lock1.setVisible(false);
            Lock2.setVisible(false);
            Lock3.setVisible(false);
            Lock4.setVisible(false);
            Lock5.setVisible(false);
            Lock6.setVisible(false);
            Lock7.setVisible(false);
        }
    }

    /**
     * LoadLevel1, set the scene to game scene.
     * <p> Change the selectLevel value to 1, play the interface sound and set the scene to game scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:59
     */
    public void LoadLevel1(ActionEvent actionEvent) throws IOException {
        selectLevel = 1;
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/game");
    }

    /**
     * LoadLevel2, set the scene to game scene.
     * <p> Change the selectLevel value to 2, play the interface sound and set the scene to game scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:59
     */
    public void LoadLevel2(ActionEvent actionEvent) throws IOException {
        selectLevel = 2;
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/game");
    }

    /**
     * LoadLevel3, set the scene to game scene.
     * <p> Change the selectLevel value to 3, play the interface sound and set the scene to game scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:59
     */
    public void LoadLevel3(ActionEvent actionEvent) throws IOException {
        selectLevel = 3;
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/game");
    }

    /**
     * LoadLevel4, set the scene to game scene.
     * <p> Change the selectLevel value to 4, play the interface sound and set the scene to game scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:59
     */
    public void LoadLevel4(ActionEvent actionEvent) throws IOException {
        selectLevel = 4;
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/game");
    }

    /**
     * LoadLevel5, set the scene to game scene.
     * <p> Change the selectLevel value to 5, play the interface sound and set the scene to game scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:59
     */
    public void LoadLevel5(ActionEvent actionEvent) throws IOException {
        selectLevel = 5;
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/game");
    }

    /**
     * LoadLevel6, set the scene to game scene.
     * <p> Change the selectLevel value to 6, play the interface sound and set the scene to game scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:59
     */
    public void LoadLevel6(ActionEvent actionEvent) throws IOException {
        selectLevel = 6;
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/game");
    }

    /**
     * LoadLevel7, set the scene to game scene.
     * <p> Change the selectLevel value to 7, play the interface sound and set the scene to game scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:59
     */
    public void LoadLevel7(ActionEvent actionEvent) throws IOException {
        selectLevel = 7;
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/game");
    }

    /**
     * LoadLevel8, set the scene to game scene.
     * <p> Change the selectLevel value to 8, play the interface sound and set the scene to game scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:59
     */
    public void LoadLevel8(ActionEvent actionEvent) throws IOException {
        selectLevel = 8;
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/game");
    }

}
