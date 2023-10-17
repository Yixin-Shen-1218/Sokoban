package com.ae2dms.GameState;

import com.ae2dms.GameMap.Level;
import com.sun.javafx.scene.paint.GradientUtils;
import javafx.scene.input.KeyCode;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * <p> The class GameEngineTest is to test GameEngine class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/2-22:03
 * @since 1.0
 */
public class GameEngineTest {
    /**
     * The gameEngine used to do the test.
     */
    private GameEngine gameEngine;

    /**
     * setUp for the test class.
     * <p> Instantiate a new gameEngine to do the test.
     *
     * @throws FileNotFoundException FileNotFoundException
     * @author Yixin SHEN
     * @date 2020/12/3-0:16
     */
    @Before
    public void setUp() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File("src/test/resources/debugGame.skb"));
        this.gameEngine = new GameEngine(in, true);
    }

    /**
     * isDebugActive Test.
     * <p> Test the isDebugActive method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:14
     */
    @Test
    public void isDebugActive() {
        boolean isDebug = GameEngine.isDebugActive();
        assertFalse(isDebug);
    }

    /**
     * handleKey Test.
     * <p> Test the handleKey method.
     *
     * @throws IOException IOException
     * @throws CloneNotSupportedException CloneNotSupportedException
     * @author Yixin SHEN
     * @date 2020/12/3-0:14
     */
    @Test
    public void handleKey() throws IOException, CloneNotSupportedException {
        gameEngine.handleKey(KeyCode.UP);
        int direction = GameEngine.moveDirection;
        assertEquals(1, direction);

        gameEngine.handleKey(KeyCode.RIGHT);
        int direction2 = GameEngine.moveDirection;
        assertEquals(2, direction2);

        gameEngine.handleKey(KeyCode.DOWN);
        int direction3 = GameEngine.moveDirection;
        assertEquals(3, direction3);

        gameEngine.handleKey(KeyCode.LEFT);
        int direction4 = GameEngine.moveDirection;
        assertEquals(4, direction4);
    }

    /**
     * isGameComplete Test.
     * <p> Test the isGameComplete method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void isGameComplete() {
        boolean isComplete = gameEngine.isGameComplete();
        assertFalse(isComplete);
    }

    /**
     * getNextLevel Test.
     * <p> Test the getNextLevel method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void getNextLevel() {
        Level nextLevel = gameEngine.getNextLevel();
        int index = nextLevel.getIndex();
        assertEquals(2, index);
    }

    /**
     * getCurrentLevel Test.
     * <p> Test the getCurrentLevel method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void getCurrentLevel() {
        Level currentLevel = gameEngine.getCurrentLevel();
        int index = currentLevel.getIndex();
        assertEquals(1, index);
    }

    /**
     * toggleDebug Test.
     * <p> Test the toggleDebug method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void toggleDebug() {
        gameEngine.toggleDebug();
        boolean debug = GameEngine.isDebugActive();
        assertTrue(debug);
    }

    /**
     * getLevels Test.
     * <p> Test the getLevels method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void getLevels() {
        List<Level> levels = gameEngine.getLevels();
        int size = levels.size();
        assertEquals(8, size);
    }

    /**
     * movesCount Test.
     * <p> Test the movesCount method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void movesCount() {
        int movesCount = gameEngine.MovesCount();
        assertEquals(0, movesCount);
    }

    /**
     * getLevelMove Test.
     * <p> Test the getLevelMove method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void getLevelMove() {
        int[] levelMove = gameEngine.getLevelMove();
        assertEquals(Arrays.toString(new int[]{0, 0, 0, 0, 0, 0, 0, 0}), Arrays.toString(levelMove));
    }

    /**
     * setSoundEffect Test.
     * <p> Test the setSoundEffect method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void setSoundEffect() {
        gameEngine.setSoundEffect(false);
        assertFalse(gameEngine.isSoundEffect());
    }

    /**
     * setState Test.
     * <p> Test the setState method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void setState() {
        gameEngine.setState(gameEngine.PlayState);
        assertEquals(gameEngine.getPlayState(), gameEngine.state);
    }

    /**
     * getPlayState Test.
     * <p> Test the getPlayState method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void getPlayState() {
        GameEngineState playState = gameEngine.getPlayState();
        GameEngineState currentState = gameEngine.state;
        assertEquals(currentState, playState);
    }

    /**
     * getDebugState Test.
     * <p> Test the getDebugState method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void getDebugState() {
        GameEngineState debugState = gameEngine.getDebugState();
        gameEngine.setState(gameEngine.DebugState);
        GameEngineState currentState = gameEngine.state;
        assertEquals(currentState, debugState);
    }

    /**
     * setDebug Test.
     * <p> Test the setDebug method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void setDebug() {
        gameEngine.setDebug(true);
        assertTrue(GameEngine.isDebugActive());
    }

    /**
     * isSoundEffect Test.
     * <p> Test the isSoundEffect method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void isSoundEffect() {
        gameEngine.setSoundEffect(false);
        assertFalse(gameEngine.isSoundEffect());
    }

    /**
     * getLogger Test.
     * <p> Test the getLogger method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void getLogger() {
        Logger logger = GameEngine.getLogger();
        assertNotNull(logger);
    }

    /**
     * setCurrentLevel Test.
     * <p> Test the setCurrentLevel method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void setCurrentLevel() {
        gameEngine.setCurrentLevel(gameEngine.getLevels().get(1));
        int index = gameEngine.getCurrentLevel().getIndex();
        assertEquals(2, index);
    }

    /**
     * getSavedLevel Test.
     * <p> Test the getSavedLevel method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void getSavedLevel() {
        int savedLevel = gameEngine.getSavedLevel();
        assertEquals(1, savedLevel);
    }

    /**
     * setSavedLevel Test.
     * <p> Test the setSavedLevel method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-0:17
     */
    @Test
    public void setSavedLevel() {
        gameEngine.setSavedLevel(4);
        int savedLevel = gameEngine.getSavedLevel();
        assertEquals(4, savedLevel);
    }
}