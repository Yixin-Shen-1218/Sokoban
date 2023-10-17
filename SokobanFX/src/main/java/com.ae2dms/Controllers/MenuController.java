package com.ae2dms.Controllers;

import com.ae2dms.Main.Main;
import com.ae2dms.Music.ClickSound;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * <p> The Class MenuController is the controller class of menu.fxml.
 * Initialize the menu scene, define some mouse event.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/17-23:27
 * @since 1.0
 */
public class MenuController {
    /**
     * fxml element, the button to slot scene.
     */
    public Button Start;
    /**
     * fxml element, the button to Setting scene.
     */
    public Button Setting;
    /**
     * fxml element, the button to Ranking scene.
     */
    public Button Ranking;
    /**
     * fxml element, the button to exit.
     */
    public Button Exit;
    /**
     * fxml element, the button to Help scene.
     */
    public Button Help;
    /**
     * fxml element, the button to Tutorial scene.
     */
    public Button Tutorial;

    /**
     * Set the scene to slot scene.
     * <p> Click the start button, jump to the slot scene and play the interface sound.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/18-9:42
     */
    public void startGame(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/slot");
    }

    /**
     * Set the scene to setting scene.
     * <p> Click the setting button, jump to the setting scene and play the interface sound.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/18-9:42
     */
    public void openSetting(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/setting");
    }

    /**
     * Set the scene to rank scene.
     * <p> Click the rank button, jump to the rank scene and play the interface sound.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/18-9:42
     */
    public void openRank(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/rank");
    }

    /**
     * Close the game.
     * <p> Click the exit button, close the game.
     *
     * @param actionEvent Mouse click
     * @author Yixin SHEN
     * @date 2020/11/18-9:42
     */
    public void closeGame(ActionEvent actionEvent) {
        ClickSound.getInstance().playMusic();
        System.exit(0);
    }

    /**
     * Set the scene to help scene.
     * <p> Click the help button, jump to the help scene and play the interface sound.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/18-9:42
     */
    public void openHelp(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/help");
    }

    /**
     * Set the scene to tutorial scene.
     * <p> Click the tutorial button, jump to the tutorial scene and play the interface sound.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/18-9:42
     */
    public void openTutorial(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/tutorial");
    }
}
