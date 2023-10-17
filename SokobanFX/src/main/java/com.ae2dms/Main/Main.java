package com.ae2dms.Main;

import com.ae2dms.GameState.GameEngine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

/**
 * <p> The Class Main is used to start the game.
 * The main class of the project.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/5-16:11
 * @since 1.0
 */
public class Main extends Application {
    /**
     * Defines the stage of the game.
     */
    public static Stage primaryStage;
    /**
     * Defines the scene of the game.
     */
    public static Scene scene;

    /**
     * Start method of the fx project, called in main method.
     * <p> Start the game, set the first scene of the game and the name of the primaryStage.
     * Load the style.css file to all node in the stage, stage show.
     *
     * @param primaryStage The stage of the game.
     * @throws Exception Exception
     * @author Yixin SHEN
     * @date 2020/11/30-22:27
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle(GameEngine.GAME_NAME);
        scene = new Scene(loadFXML("/FXML/animation"));
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/FXML/style.css")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Set the scene root of the game.
     * <p> Set the scene root of the game.
     *
     * @param fxml The fxml file name.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/30-22:29
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Load the fxml file as resource.
     * <p> Load the fxml file as resource, return the load file in fx parent format.
     *
     * @param fxml The fxml file name.
     * @return javafx.scene.Parent The fxml file in parent format.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/30-22:31
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The main method of the game.
     * <p> The main method of the game, call the launch method to start the game.
     *
     * @param args Main method args.
     * @author Yixin SHEN
     * @date 2020/11/30-22:32
     */
    public static void main(String[] args) {
        launch(args);
    }
}