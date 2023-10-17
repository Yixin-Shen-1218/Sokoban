package com.ae2dms.GameState;

import com.ae2dms.Controllers.LevelController;
import com.ae2dms.Controllers.SettingController;
import com.ae2dms.GameMap.GameGrid;
import com.ae2dms.GameMap.Level;
import com.ae2dms.Main.GameLogger;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p> The Class GameEngine defines the gameEngine of the game.
 * GameEngine defines the fields of gameEngine and contains some methods that manipulate the gameEngine.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/30-20:22
 * @since 1.0
 */
public class GameEngine {
    /**
     * Defines the name of game.
     */
    public static final String GAME_NAME = "SokobanFX";
    /**
     * Defines the logger of current gameEngine.
     */
    public static GameLogger logger;
    /**
     * Defines the total moveCount of the game.
     */
    public int movesCount = 0;
    /**
     * Defines the map set name.
     */
    public String mapSetName;
    /**
     * Defines whether the game in debug state or not.
     */
    private static boolean debug = false;
    /**
     * Defines the current level of the game.
     */
    private Level currentLevel;
    /**
     * Defines the levels in an arrayList of the game.
     */
    private List<Level> levels;
    /**
     * Defines whether the game is complete or not.
     */
    private boolean gameComplete = false;
    /**
     * Defines the savedLevel in the game archive file.
     */
    private int SavedLevel;
    /**
     * Defines the levelMove in an int array.
     */
    private int[] levelMove;
    /**
     * Defines the max level of the game.
     */
    public static int maxLevel;
    /**
     * Defines the keeper's move direction
     */
    public static int moveDirection;
    /**
     * Store every gameGrid state after successfully move
     */
    private final List<GameGrid> gameGridsTrack = new ArrayList<>();

    /**
     * Store every keeperPosition state after successfully move
     */
    private final List<Point> keeperTrack = new ArrayList<>();

    /**
     * Defines whether the sound effect is on or off.
     */
    private boolean soundEffect;

    /**
     * Defines the PlayState of gameEngine.
     */
    GameEngineState PlayState;
    /**
     * Defines the DubState of gameEngine.
     */
    GameEngineState DebugState;
    /**
     * Defines the gameEngine state.
     */
    GameEngineState state;

    /**
     * Constructor of GameEngine, instantiate the gameEngine.
     * <p> Set the fields value of gameEngine and instantiate a new gameLogger, generate the GameEngine levels.
     *
     * @param input      Archive file input stream.
     * @param production The bool value.
     * @author Yixin SHEN
     * @date 2020/11/30-20:52
     */
    public GameEngine(InputStream input, boolean production) {
        this.soundEffect = SettingController.soundEffect;

        PlayState = new PlayState(this);
        DebugState = new DebugState(this);
        state = PlayState;
        setDebug(false);

        try {
            logger = new GameLogger();
            levels = loadGameFile(input);
            if (LevelController.selectLevel == 0) {
                currentLevel = getNextLevel();
            } else {
                currentLevel = levels.get(LevelController.selectLevel - 1);
                LevelController.selectLevel = 0;
            }
        } catch (IOException x) {
            System.out.println("Cannot create logger.");
        } catch (NoSuchElementException e) {
            logger.warning("Cannot load the default save file: " + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Return whether the gameEngine is debug or not.
     * <p> Check whether the gameEngine is debug or not.
     *
     * @return boolean  Whether the gameEngine is debug or not.
     * @author Yixin SHEN
     * @date 2020/11/30-20:57
     */
    public static boolean isDebugActive() {
        return debug;
    }

    /**
     * Call the move method according to the keyboard input.
     * <p> EventFilter set in the gameGontroller class, get the keyCode input by keyboard.
     * Change the moveDirection to different value used to determine the keeper img.
     *
     * @param code The keyboard input.
     * @throws CloneNotSupportedException CloneNotSupportedException
     * @throws IOException                IOException
     * @author Yixin SHEN
     * @date 2020/11/30-20:57
     */
    public void handleKey(KeyCode code) throws CloneNotSupportedException, IOException {
        switch (code) {
            case UP:
                moveDirection = 1;
                move(new Point(-1, 0));
                break;

            case RIGHT:
                moveDirection = 2;
                move(new Point(0, 1));
                break;

            case DOWN:
                moveDirection = 3;
                move(new Point(1, 0));
                break;

            case LEFT:
                moveDirection = 4;
                move(new Point(0, -1));
                break;

            default:
                // TODO: implement something funny.
        }

        if (isDebugActive()) {
            System.out.println(code);
        }
    }

    /**
     * The keeper move method.
     * <p> According to delta and current keeper position, judge whether it can be moved;
     * if the movement is successful, update the position of keeper/crate;
     * save the keeperTrack and the gameGridsTrack
     *
     * @param delta the keeper move case in the Point format.
     * @throws CloneNotSupportedException CloneNotSupportedException
     * @author Yixin SHEN
     * @date 2020/11/13-16:52
     */
    private void move(Point delta) throws CloneNotSupportedException {
        state.move(delta);
    }

    /**
     * Load the game archive file to generate level array list.
     * <p> input a .sdk file and read the input stream,
     * generate a level array list, contains the level details
     *
     * @param input file in .sdk format, which contains the map
     * @return java.util.List The level of this gameEngine.
     * @author Yixin SHEN
     * @date 2020/11/12-13:43
     */
    private List<Level> loadGameFile(InputStream input) {
        // Set the initial capacity of level array list
        int capacity = 8;

        List<Level> levels = new ArrayList<>(capacity);
        int levelIndex = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            boolean parsedFirstLevel = false;
            List<String> rawLevel = new ArrayList<>();
            String levelName = "";

            while (true) {
                String line = reader.readLine();
//                System.out.println(line);
                if (line == null) {
                    if (rawLevel.size() != 0) {
                        Level parsedLevel = new Level(levelName, ++levelIndex, rawLevel);
                        levels.add(parsedLevel);
                    }
                    break;
                }

                if (line.contains("MapSetName")) {
                    mapSetName = line.replace("MapSetName: ", "");
                    continue;
                }
                if (line.contains("LevelMoveCount")) {
                    String inputString = line.replace("LevelMoveCount: ", "");
                    String[] stringArray = inputString.split(" ");

                    this.levelMove = new int[stringArray.length];
                    for (int i = 0; i < stringArray.length; i++) {
                        levelMove[i] = Integer.parseInt(stringArray[i]);
                    }
                    continue;
                }
                if (line.contains("LevelIndex")) {
                    SavedLevel = Integer.parseInt(line.replace("LevelIndex: ", ""));
                    maxLevel = Integer.parseInt(line.replace("LevelIndex: ", ""));
                    continue;
                }
                if (line.contains("LevelName")) {
                    if (parsedFirstLevel) {
                        Level parsedLevel = new Level(levelName, ++levelIndex, rawLevel);
                        levels.add(parsedLevel);
                        rawLevel.clear();
                    } else {
                        parsedFirstLevel = true;
                    }

                    levelName = line.replace("LevelName: ", "");
                    continue;
                }

                line = line.trim();
                line = line.toUpperCase();
                if (line.matches(".*W.*W.*")) {
                    rawLevel.add(line);
                }
            }
        } catch (IOException e) {
            logger.severe("Error trying to load the game file: " + e);
        } catch (NullPointerException e) {
            logger.severe("Cannot open the requested file: " + e);
        }

        // set the level move
        for (int i = 0; i < capacity; ++i) {
            levels.get(i).setMove(levelMove[i]);
        }

        return levels;
    }

    /**
     * Return whether the game is complete or not.
     * <p> Check whether the game is complete or not.
     *
     * @return boolean The bool value defines whether the game is complete or not.
     * @author Yixin SHEN
     * @date 2020/11/30-21:02
     */
    public boolean isGameComplete() {
        return gameComplete;
    }

    /**
     * Get the next level in this GameEngine.
     * <p> When end-user complete the current level, call this function,
     * and return the next level object
     *
     * @return com.ae2dms.GameMap.Level The next level.
     * @author Yixin SHEN
     * @date 2020/11/12-13:41
     */
    public Level getNextLevel() {
        if (currentLevel == null) {
            return levels.get(SavedLevel - 1);
        }
        int currentLevelIndex = currentLevel.getIndex();
        if (currentLevelIndex < levels.size()) {
            System.out.println(currentLevelIndex + 1);
            return levels.get(currentLevelIndex);
        }
        gameComplete = true;
        return null;
    }

    /**
     * Get the current level of the gameEngine.
     * <p> Return the current level of the gameEngine.
     *
     * @return com.ae2dms.GameMap.Level The current level of the gameEngine.
     * @author Yixin SHEN
     * @date 2020/11/30-21:05
     */
    public Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Turn on/off debug pattern.
     * <p> Turn on/off debug pattern.
     *
     * @author Yixin SHEN
     * @date 2020/11/15-13:49
     */
    public void toggleDebug() {
        state.debug();
    }


    /**
     * Return the KeeperTrack array list.
     * <p> Return the KeeperTrack array list.
     *
     * @return java.util.List The KeeperTrack array list.
     * @author Yixin SHEN
     * @date 2020/11/13-15:03
     */
    public List<Point> getKeeperTrack() {
        return keeperTrack;
    }

    /**
     * Return the gameGridsTrack array list.
     * <p> Return the gameGridsTrack array list.
     *
     * @return java.util.List The gameGridsTrack array list.
     * @author Yixin SHEN
     * @date 2020/11/13-15:03
     */
    public List<GameGrid> getGameGridsTrack() {
        return gameGridsTrack;
    }

    /**
     * Return the levels array list of the gameEngine.
     * <p> The level array list getter.
     *
     * @return java.util.List The level array lost.
     * @author Yixin SHEN
     * @date 2020/11/15-18:35
     */
    public List<Level> getLevels() {
        return levels;
    }

    /**
     * Calculate the total move count of the gameEngine.
     * <p> Calculate the total move count.
     *
     * @return int The total move count.
     * @author Yixin SHEN
     * @date 2020/11/18-16:16
     */
    public int MovesCount() {
        int count = 0;
        for (Level level : this.levels) {
            count = count + level.getMove();
        }
        this.movesCount = count;
        return movesCount;
    }

    /**
     * Get the move count of levels in an int array.
     * <p> return level move of the gameEngine.
     *
     * @return int[] The move count of levels.
     * @author Yixin SHEN
     * @date 2020/11/22-18:16
     */
    public int[] getLevelMove() {
        return levelMove;
    }

    /**
     * Set the sound effect.
     * <p> Set the sound effect.
     *
     * @param soundEffect The soundEffect in the game setting.
     * @author Yixin SHEN
     * @date 2020/11/30-21:52
     */
    public void setSoundEffect(boolean soundEffect) {
        this.soundEffect = soundEffect;
    }

    /**
     * Set the game state as the sate parameter.
     * <p> Set the game state as the sate parameter.
     *
     * @param state The gameEngine state.
     * @author Yixin SHEN
     * @date 2020/11/30-21:53
     */
    public void setState(GameEngineState state) {
        this.state = state;
    }

    /**
     * Return the playState of the gameEngine.
     * <p> Return the playState of the gameEngine.
     *
     * @return com.ae2dms.GameState.GameEngineState The playState.
     * @author Yixin SHEN
     * @date 2020/11/30-21:54
     */
    public GameEngineState getPlayState() {
        return PlayState;
    }

    /**
     * Return the DebugState of the gameEngine.
     * <p> Return the DebugState of the gameEngine.
     *
     * @return com.ae2dms.GameState.GameEngineState The DebugState.
     * @author Yixin SHEN
     * @date 2020/11/30-21:54
     */
    public GameEngineState getDebugState() {
        return DebugState;
    }

    /**
     * Set the gameEngine debug bool to the parameter debug value.
     * <p> Set the gameEngine debug bool to the parameter debug value.
     *
     * @param debug The debug bool value.
     * @author Yixin SHEN
     * @date 2020/11/30-21:55
     */
    public void setDebug(boolean debug) {
        GameEngine.debug = debug;
    }

    /**
     * Check whether the soundEffect is on or off.
     * <p> Check whether the soundEffect is on or off.
     *
     * @return boolean The bool value of sound effect.
     * @author Yixin SHEN
     * @date 2020/11/30-21:56
     */
    public boolean isSoundEffect() {
        return soundEffect;
    }

    /**
     * Return the logger of this gameEngine.
     * <p> Return the logger of this gameEngine.
     *
     * @return com.ae2dms.Main.GameLogger The logger of this gameEngine.
     * @author Yixin SHEN
     * @date 2020/11/30-21:57
     */
    public static GameLogger getLogger() {
        return logger;
    }

    /**
     * Set the current level to the level input.
     * <p> Set the current level to the level input.
     *
     * @param currentLevel The level used to set as currentLevel.
     * @author Yixin SHEN
     * @date 2020/11/30-22:02
     */
    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Return the savedLevel index number in the archive file.
     * <p> Return the savedLevel index number in the archive file.
     *
     * @return int The savedLevel index number.
     * @author Yixin SHEN
     * @date 2020/11/30-22:03
     */
    public int getSavedLevel() {
        return SavedLevel;
    }

    /**
     * Set the savedLevel index number as the input.
     * <p> Set the savedLevel index number as the input.
     *
     * @param savedLevel The saveLevel number used to set as the savedLevel.
     * @author Yixin SHEN
     * @date 2020/11/30-22:04
     */
    public void setSavedLevel(int savedLevel) {
        SavedLevel = savedLevel;
    }

}