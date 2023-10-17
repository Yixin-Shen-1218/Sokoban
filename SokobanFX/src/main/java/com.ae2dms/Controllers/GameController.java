package com.ae2dms.Controllers;

import com.ae2dms.Dialog.DialogFactory;
import com.ae2dms.GameMap.GameGrid;
import com.ae2dms.GameMap.GameObject;
import com.ae2dms.GameMap.Level;
import com.ae2dms.GameState.GameEngine;
import com.ae2dms.Main.Main;
import com.ae2dms.Manager.FileHandler;
import com.ae2dms.Manager.GraphicObject;
import com.ae2dms.Music.BGM;
import com.ae2dms.Music.ClickSound;
import com.ae2dms.Music.ErrorSound;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Optional;

/**
 * <p> The Class GameController is the controller class of game.fxml.
 * Initialize the game scene, implements the FileHandler interface and defines a game scene event.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/17-13:49
 * @since 1.0
 */
public class GameController implements FileHandler {
    /**
     * Defines the pause pane.
     */
    @FXML
    public AnchorPane Paused;

    /**
     * Defines the new gameEngine object.
     */
    private static GameEngine gameEngine;

    /**
     * fxml element, display the level move.
     */
    @FXML
    public Label LevelMove;

    /**
     * Defines the new FILE object.
     */
    private File saveFile;

    /**
     * Defines whether music is toggled or not.
     */
    private boolean music = true;

    /**
     * Defines the stage of the scene. In this project, there is only one stage.
     */
    private Stage primaryStage;

    /**
     * Defines the dialogFactory object, using to generate different dialog.
     */
    private DialogFactory dialogFactory;

    /**
     * Defines the gameGrid object, use to store game map.
     */
    @FXML
    private GridPane gameGrid;

    /**
     * Defines the move event handler.
     */
    private static EventHandler<KeyEvent> keyEventEventHandler1;

    /**
     * Defines the pause and return to menu event handler.
     */
    private static EventHandler<KeyEvent> keyEventEventHandler2;

    /**
     * Initialize the game scene element.
     * <p> Set the primaryStage to Main.primaryStage. Load the game file and play BGM of the game.
     * Instantiate a dialog factory, set the LevelMove label's text to the level move of current level.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-14:41
     */
    public void initialize() throws IOException {
        this.primaryStage = Main.primaryStage;
        loadDefaultSaveFile();
        BGM.getInstance().playMusic();
        this.dialogFactory = new DialogFactory();
        LevelMove.setText("LevelMove: " + gameEngine.getCurrentLevel().getMove());
    }

    /**
     * Load game .skb file, set two different event handler.
     * <p> Load the .skb game file according to the static archive value, set two different event handler that player can use key board to control the game.
     * Transform the stream type to InputStream, utilize it as the parameter for initializeGame function.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/20-13:01
     */
    void loadDefaultSaveFile() throws IOException {
        saveFile = new File("src/main/resources/Archives/Archive" + SlotController.archive + ".skb");
        InputStream in = new FileInputStream(saveFile);
        initializeGame(in);
        setEventFilter1();
        setEventFilter2();
    }

    /**
     * Instantiate a new gameEngine object.
     * <p> Instantiate a new gameEngine object, reload the gameGrid map.
     *
     * @param input InputStream got from .skb archive file.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-15:04
     */
    private void initializeGame(InputStream input) throws IOException {
        gameEngine = new GameEngine(input, true);
        reloadGrid();
    }

    /**
     * Set even handler one, allow Player control the game move.
     * <p> Set evenFilter, for gameEngine function, and bind to primary stag; Reload the gameGrid.
     *
     * @author Yixin SHEN
     * @date 2020/11/29-15:06
     */
    private void setEventFilter1() {
        keyEventEventHandler1 = event -> {
            try {
                gameEngine.handleKey(event.getCode());
            } catch (CloneNotSupportedException | IOException e) {
                e.printStackTrace();
            }
            try {
                reloadGrid();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, keyEventEventHandler1);
    }

    /**
     * Set even handler two, allow Player control the game pause by ESC and return to menu by F1.
     * <p> Set evenFilter, for gameEngine function, and bind to primary stag; Reload the gameGrid.
     *
     * @author Yixin SHEN
     * @date 2020/11/29-15:06
     */
    private void setEventFilter2() {
        keyEventEventHandler2 = event -> {
            Pause(event.getCode());
            try {
                ReturnMenuKey(event.getCode());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reloadGrid();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, keyEventEventHandler2);
    }

    /**
     * Press ESCAPE key on keyboard to pause the screen.
     * <p> When user press ESCAPE key, if the game is not paused, set Paused pane as visible, and delete the eventFilter1, stop the music.
     * else, set Paused pane as non-visible, and set the eventFilter1, play the music.
     *
     * @param code KeyCode from keyboard
     * @author Yixin SHEN
     * @date 2020/11/29-15:09
     */
    public void Pause(KeyCode code) {
        if (code.equals(KeyCode.ESCAPE)) {
            if (Paused.isVisible()) {
                Paused.setVisible(false);
                setEventFilter1();
                if (music) {
                    BGM.getInstance().playMusic();
                }
            } else {
                Paused.setVisible(true);
                deleteEventFilter1();
                BGM.getInstance().stopMusic();
            }
        }
    }

    /**
     * Return menu function, if user press F1 in the keyboard, return to the menu scene.
     * <p> Return menu function, if user press F1 in the keyboard, return to the menu scene.
     *
     * @param code KeyCode from keyboard
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-15:13
     */
    public void ReturnMenuKey(KeyCode code) throws IOException {
        if (code.equals(KeyCode.F1)) {
            if (Paused.isVisible()) {
                returnMenu();
            }
        }
    }

    /**
     * Delete the eventFilter1 bind with primary stage.
     * <p> Delete the eventFilter1 bind with primary stage.
     *
     * @author Yixin SHEN
     * @date 2020/11/29-15:14
     */
    public void deleteEventFilter1() {
        primaryStage.removeEventFilter(KeyEvent.KEY_PRESSED, keyEventEventHandler1);
    }

    /**
     * Delete the eventFilter2 bind with primary stage.
     * <p> Delete the eventFilter2 bind with primary stage.
     *
     * @author Yixin SHEN
     * @date 2020/11/29-15:14
     */
    public void deleteEventFilter2() {
        primaryStage.removeEventFilter(KeyEvent.KEY_PRESSED, keyEventEventHandler2);
    }

    /**
     * Load the game .skb file by file chooser.
     * <p> Load the game .skb file, set the extension filter that only .skb file can be seen in the file chooser.
     * If saveFile is not NULL, call the initializeGame function using the file has been chosen.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-15:15
     */
    private void loadGameFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Save File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sokoban save file", "*.skb"));
        saveFile = fileChooser.showOpenDialog(primaryStage);

        if (saveFile != null) {
            if (GameEngine.isDebugActive()) {
                GameEngine.logger.info("Loading save file: " + saveFile.getName());
            }
            initializeGame(new FileInputStream(saveFile));
        }
    }

    /**
     * Reload the game map in gameGrid fxml element.
     * <p> Reload the game map in gameGrid fxml element every time call this function.
     * If game has been completed, delete tow eventFilter, saveGame, prompt a Vic dialog and call the saveScore function to save the game score to ranking.txt.
     * Jump to rank scene and erase the archive file.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-15:18
     */
    public void reloadGrid() throws IOException {
        if (gameEngine.isGameComplete()) {
            deleteEventFilter1();
            deleteEventFilter2();
            saveGame();
            // Prompt a vic dialog
            dialogFactory.getDialog("Vic", primaryStage, gameEngine);

            BGM.getInstance().stopMusic();
            //save scores to the ranking.txt
            saveScore(gameEngine);

            Main.setRoot("/FXML/rank");

            //erase the current slot
            eraseArchive(SlotController.archive);
            saveFile = new File("src/main/resources/Archives/Archive" + SlotController.archive + ".skb");
            InputStream in = new FileInputStream(saveFile);
            gameEngine = new GameEngine(in, true);
            return;
        }
        // set the LevelMove label text content
        LevelMove.setText("LevelMove: " + gameEngine.getCurrentLevel().getMove());
        Level currentLevel = gameEngine.getCurrentLevel();
        Level.LevelIterator levelGridIterator = (Level.LevelIterator) currentLevel.iterator();
        gameGrid.getChildren().clear();
        while (levelGridIterator.hasNext()) {
            addObjectToGrid(levelGridIterator.next(), levelGridIterator.getcurrentposition());
        }
        gameGrid.autosize();
        primaryStage.sizeToScene();
    }

    /**
     * Prompt a about dialog.
     * <p> Play the interface click sound, pop up a about dialog
     *
     * @author Yixin SHEN
     * @date 2020/11/29-15:32
     */
    public void showAbout() {
        ClickSound.getInstance().playMusic();
        dialogFactory.getDialog("About", primaryStage, gameEngine);
    }

    /**
     * Add Game object to the grid.
     * <p> Add game object to the gameGrid according to the gameObject type.
     *
     * @param gameObject Game object type.
     * @param location   The location of the game object in the 20*20 map.
     * @author Yixin SHEN
     * @date 2020/11/29-15:34
     */
    private void addObjectToGrid(GameObject gameObject, Point location) {
        GraphicObject graphicObject = new GraphicObject(gameObject);
        gameGrid.add(graphicObject, location.y, location.x);
    }

    /**
     * Close the game.
     * <p> Click the Exit, play the interface sound of click and exit.
     *
     * @param actionEvent Mouse click.
     * @author Yixin SHEN
     * @date 2020/11/17-20:35
     */
    public void closeGame(ActionEvent actionEvent) {
        ClickSound.getInstance().playMusic();
        System.exit(0);
    }

    /**
     * Save the current game state to archive file.
     * <p> Save the current play state as a .sdk file to resources/Archives/ path and play the interface sound.
     *
     * @param actionEvent Mouse click.
     * @author Yixin SHEN
     * @date 2020/11/15-16:33
     */
    public void saveGame(ActionEvent actionEvent) {
        ClickSound.getInstance().playMusic();
        saveGame();
    }

    /**
     * Load the game file.
     * <p> Call the loadGameFile function, use file chooser to allow user choose game file for play and play the interface sound.
     *
     * @param actionEvent Mouse click.
     * @author Yixin SHEN
     * @date 2020/11/29-16:31
     */
    public void loadGame(ActionEvent actionEvent) {
        ClickSound.getInstance().playMusic();
        try {
            loadGameFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Unto the last move, back to the previous state.
     * <p> Return back to last step, refresh the gameGrid and play the interface sound.
     * If it is the first step, pop up a undo warning dialog.
     *
     * @param actionEvent Mouse click.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/13-15:47
     */
    public void undo(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Level currentLevel = gameEngine.getCurrentLevel();
        List<GameGrid> gameGridsTrack = gameEngine.getGameGridsTrack();
        List<Point> keeperTrack = gameEngine.getKeeperTrack();
        if (keeperTrack.size() == 0) {
            ErrorSound.getInstance().playMusic();
            dialogFactory.getDialog("Undo", primaryStage, gameEngine);
            return;
        }
        currentLevel.objectsGrid = gameGridsTrack.get(gameGridsTrack.size() - 1);
        currentLevel.setKeeperPosition(keeperTrack.get(keeperTrack.size() - 1));
        gameGridsTrack.remove(gameGridsTrack.size() - 1);
        keeperTrack.remove(keeperTrack.size() - 1);

        currentLevel.setMove(currentLevel.getMove() - 1);

        reloadGrid();
    }

    /**
     * Reset the current level to its original state.
     * <p>  Reset the whole level to its original state by load the SampleGame.skb file. Clear the keeperTrack and gameGridsTrack.
     * Pop up a confirmation first that let user can cancel its operation.
     *
     * @param actionEvent Mouse click.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/13-16:34
     */
    public void resetLevel(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("RESET THE LEVEL");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent())
            if (result.get() == ButtonType.OK) {
                InputStream in = getClass().getClassLoader().getResourceAsStream("level/SampleGame.skb");
                boolean debug = GameEngine.isDebugActive();
                GameEngine resetState = new GameEngine(in, true);
                resetState.setDebug(debug);
                int levelIndex = gameEngine.getCurrentLevel().getIndex();
                System.out.println(levelIndex);

                List<GameGrid> gameGridsTrack = gameEngine.getGameGridsTrack();
                List<Point> keeperTrack = gameEngine.getKeeperTrack();
                gameGridsTrack.clear();
                keeperTrack.clear();

                gameEngine.getCurrentLevel().objectsGrid = resetState.getLevels().get(levelIndex - 1).objectsGrid;
                gameEngine.getCurrentLevel().setKeeperPosition(resetState.getLevels().get(levelIndex - 1).getKeeperPosition());
                gameEngine.getCurrentLevel().setMove(0);
                GameEngine.maxLevel = levelIndex;
                reloadGrid();
            } else {
                System.out.println("reset cancel");
            }
    }

    /**
     * Turn on/off the debug pattern.
     * <p> Turn on/off debug pattern, reload the game grids and play the interface sound.
     *
     * @param actionEvent Mouse click.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/15-13:53
     */
    public void toggleDebug(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        gameEngine.toggleDebug();
        reloadGrid();
    }

    /**
     * Turn on/off game BGM.
     * <p> Turn on/off game BGM, if music is false before calling this function, start to play music;
     * If music is true, stop the music;
     *
     * @param actionEvent Mouse click.
     * @author Yixin SHEN
     * @date 2020/11/15-13:50
     */
    public void toggleMusic(ActionEvent actionEvent) {
        ClickSound.getInstance().playMusic();
        music = !music;
        if (music) {
            BGM.getInstance().playMusic();
        } else {
            BGM.getInstance().stopMusic();
        }

    }

    /**
     * Return to menu.
     * <p> return to the menu scene, and stop the BGM, delete both eventFilter set to the primary stage
     * Turn off the soundEffect of the gameEngine, set the selectedLevel value to zero.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/18-17:57
     */
    public void returnMenu() throws IOException {
        ClickSound.getInstance().playMusic();
        deleteEventFilter1();
        deleteEventFilter2();
        BGM.getInstance().stopMusic();
        gameEngine.setSoundEffect(false);
        saveGame();
        LevelController.selectLevel = 0;
        Main.setRoot("/FXML/menu");
    }

    /**
     * Save the current game state to the corresponding archive file.
     * <p> Save the current game state to the archive file, including map name, level move count, etc..
     *
     * @author Yixin SHEN
     * @date 2020/11/22-16:08
     */
    public static void saveGame() {
        File Archive = new File("src/main/resources/Archives/Archive" + SlotController.archive + ".skb");
        int currentLevelIndex;

        //if game is complete, set the currentLevelIndex as the size of level; if not, set the currentLevelIndex as maxLevel value.
        if (gameEngine.isGameComplete()) {
            currentLevelIndex = gameEngine.getLevels().size();
        } else {
            currentLevelIndex = GameEngine.maxLevel;
        }

        int max = gameEngine.getLevels().size();

        try {
            // save the mapSetName.
            System.out.println(gameEngine.mapSetName);
            FileWriter fileWriter = new FileWriter(Archive);
            String mapSetName = "MapSetName: " + gameEngine.mapSetName + "\n";
            fileWriter.write(mapSetName);

            // save the levelMoveCount.
            StringBuilder movecount = new StringBuilder("LevelMoveCount: ");

            int size = gameEngine.getLevels().size();
            for (int j = 0; j < size; ++j) {
                movecount.append(gameEngine.getLevels().get(j).getMove()).append(" ");
            }
            movecount.append("\n");
            fileWriter.write(movecount.toString());

            // save the level index.
            String LevelIndex = "LevelIndex: " + currentLevelIndex + "\n";
            fileWriter.write(LevelIndex);

            // save all the level maps of the gameEngine
            for (int i = 0; i < max; ++i) {
                String levelName = "LevelName: " + gameEngine.getLevels().get(i).getName() + "\n";
                fileWriter.write(levelName);

                Dimension dimension = gameEngine.getLevels().get(i).objectsGrid.getDimension();

                GameGrid objectsGrid = gameEngine.getLevels().get(i).objectsGrid;
                GameGrid diamondsGrid = gameEngine.getLevels().get(i).diamondsGrid;

                GameGrid levelState = new GameGrid(dimension.height, dimension.width);
                for (int row = 0; row < dimension.width; row++) {

                    for (int col = 0; col < dimension.height; col++) {

                        GameObject object = objectsGrid.getGameObjectAt(col, row);
                        GameObject diamond = diamondsGrid.getGameObjectAt(col, row);
                        GameObject retObj = object;
                        if (diamond == GameObject.DIAMOND) {
                            if (object == GameObject.CRATE) {
                                retObj = GameObject.CRATE_ON_DIAMOND;
                            } else if (object == GameObject.FLOOR) {
                                retObj = diamond;
                            } else if (object == GameObject.KEEPER) {
                                retObj = GameObject.KEEPER_ON_DIAMOND;
                            }
                        }
                        levelState.putGameObjectAt(retObj, col, row);
                    }

                }

                String gameGrid = levelState + "\n";
                fileWriter.write(gameGrid);
            }

            fileWriter.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set the scene to level scene.
     * <p> Play the interface sound, delete both eventFilters bind to the primary stage, stop the game BGM, set the soundEffect of game to false.
     * Save the gameSate and set the scene to level scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-16:47
     */
    public void selectLevel(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        deleteEventFilter1();
        deleteEventFilter2();
        BGM.getInstance().stopMusic();
        gameEngine.setSoundEffect(false);
        saveGame();
        Main.setRoot("/FXML/level");
    }

}

