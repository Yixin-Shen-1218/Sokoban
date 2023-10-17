package com.ae2dms.Controllers;

import com.ae2dms.GameState.GameEngine;
import com.ae2dms.Main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

/**
 * <p> The class SettingControllerTest is to test SettingController class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/4-16:16
 * @since 1.0
 */
public class SettingControllerTest extends ApplicationTest {
    /**
     * Start method of the fx project, called in main method.
     * <p> Start the game, set the first scene of the game and the name of the stage.
     * Load the style.css file to all node in the stage, stage show.
     *
     * @param primaryStage The stage of MainTest.
     * @throws Exception Exception
     * @author Yixin SHEN
     * @date 2020/12/4-16:16
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle(GameEngine.GAME_NAME);
        Main.scene = new Scene(FXMLLoader.load(Main.class.getResource("/FXML/setting.fxml")));
        Main.scene.getStylesheets().add(String.valueOf(getClass().getResource("/FXML/style.css")));
        primaryStage.setScene(Main.scene);
        primaryStage.show();
    }

    /**
     * returnMenu Test.
     * <p> Test the returnMenu method. Click the Return button, change to Menu scene.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-16:16
     */
    @Test
    public void returnMenu() {
        clickOn(Main.scene.lookup("#Return"));
    }

    /**
     * soundControl Test.
     * <p> Test the soundControl method. Click the soundControl checkbox.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-16:16
     */
    @Test
    public void soundControl() {
        clickOn(Main.scene.lookup("#SoundControl"));
        assertFalse(SettingController.soundEffect);
    }
}