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
 * <p> The class MenuControllerTest is to test MenuController class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/4-15:39
 * @since 1.0
 */
public class MenuControllerTest extends ApplicationTest {
    /**
     * Start method of the fx project, called in main method.
     * <p> Start the game, set the first scene of the game and the name of the stage.
     * Load the style.css file to all node in the stage, stage show.
     *
     * @param primaryStage The stage of MainTest.
     * @throws Exception Exception
     * @author Yixin SHEN
     * @date 2020/12/4-15:39
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle(GameEngine.GAME_NAME);
        Main.scene = new Scene(FXMLLoader.load(Main.class.getResource("/FXML/menu.fxml")));
        Main.scene.getStylesheets().add(String.valueOf(getClass().getResource("/FXML/style.css")));
        primaryStage.setScene(Main.scene);
        primaryStage.show();
    }

    /**
     * startGame Test.
     * <p> Test the startGame method. Click the Start button, change to slot scene.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-15:39
     */
    @Test
    public void startGame() {
        clickOn(Main.scene.lookup("#Start"));
    }

    /**
     * openSetting Test.
     * <p> Test the openSetting method. Click the Setting button, change to Setting scene.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-15:39
     */
    @Test
    public void openSetting() {
        clickOn(Main.scene.lookup("#Setting"));
    }

    /**
     * openRank Test.
     * <p> Test the openRank method. Click the Ranking button, change to Ranking scene.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-15:39
     */
    @Test
    public void openRank() {
        clickOn(Main.scene.lookup("#Ranking"));
    }

    /**
     * openHelp Test.
     * <p> Test the openHelp method. Click the Help button, change to Help scene.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-15:39
     */
    @Test
    public void openHelp() {
        clickOn(Main.scene.lookup("#Help"));
    }

    /**
     * openTutorial Test.
     * <p> Test the openTutorial method. Click the Tutorial button, change to Tutorial scene.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-15:39
     */
    @Test
    public void openTutorial() {
        clickOn(Main.scene.lookup("#Tutorial"));
    }
}