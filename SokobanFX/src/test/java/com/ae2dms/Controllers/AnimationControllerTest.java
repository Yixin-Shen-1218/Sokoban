package com.ae2dms.Controllers;

import com.ae2dms.GameState.GameEngine;
import com.ae2dms.Main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * <p> The class AnimationControllerTest is to test AnimationController class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/4-11:43
 * @since 1.0
 */
public class AnimationControllerTest extends ApplicationTest {
    /**
     * Start method of the fx project, called in main method.
     * <p> Start the game, set the first scene of the game and the name of the stage.
     * Load the style.css file to all node in the stage, stage show.
     *
     * @param primaryStage The stage of MainTest.
     * @throws Exception Exception
     * @author Yixin SHEN
     * @date 2020/12/4-10:29
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle(GameEngine.GAME_NAME);
        Main.scene = new Scene(FXMLLoader.load(Main.class.getResource("/FXML/animation.fxml")));
        Main.scene.getStylesheets().add(String.valueOf(getClass().getResource("/FXML/style.css")));
        primaryStage.setScene(Main.scene);
        primaryStage.show();
    }

    /**
     * startGame Test.
     * <p> Test the startGame method. Click the scene, change to menu scene.
     *
     * @author Yixin SHEN
     * @date 2020/12/4-10:29
     */
    @Test
    public void startGame() {
        clickOn(Main.scene);
    }
}