package com.ae2dms.Controllers;

import com.ae2dms.GameState.GameEngine;
import com.ae2dms.Main.Main;
import com.ae2dms.Music.BGM;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;


/**
 * <p> The class LevelController is to test LevelController class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/4-15:26
 * @since 1.0
 */
public class LevelControllerTest extends ApplicationTest {
    /**
     * Start method of the fx project, called in main method.
     * <p> Start the game, set the first scene of the game and the name of the stage.
     * Load the style.css file to all node in the stage, stage show.
     *
     * @param primaryStage The stage of MainTest.
     * @throws Exception Exception
     * @author Yixin SHEN
     * @date 2020/12/4-15:26
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle(GameEngine.GAME_NAME);
        Main.scene = new Scene(FXMLLoader.load(Main.class.getResource("/FXML/level.fxml")));
        Main.scene.getStylesheets().add(String.valueOf(getClass().getResource("/FXML/style.css")));
        primaryStage.setScene(Main.scene);
        primaryStage.show();
    }

    /**
     * loadLevel1 Test.
     * <p> Test the loadLevel1 method. Click the Btn1 button, change to level1 scene.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-15:26
     */
    @Test
    public void loadLevel1() {
        SlotController.archive = 1;
        clickOn(Main.scene.lookup("#Btn1"));
        BGM.getInstance().stopMusic();
    }
}