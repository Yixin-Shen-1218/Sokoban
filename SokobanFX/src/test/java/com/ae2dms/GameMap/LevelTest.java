package com.ae2dms.GameMap;

import com.ae2dms.GameState.GameEngine;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * <p> The class LevelTest is to test Level class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/3-9:24
 * @since 1.0
 */
public class LevelTest {
    /**
     * The level is used to do test.
     */
    private Level level;

    /**
     * setUp for the test class.
     * <p> Instantiate a new level to do the test.
     *
     * @throws FileNotFoundException FileNotFoundException
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Before
    public void setUp() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File("src/test/resources/debugGame.skb"));
        GameEngine gameEngine = new GameEngine(in, true);
        this.level = gameEngine.getCurrentLevel();
    }


    /**
     * getMove Test.
     * <p> Test the getMove method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Test
    public void getMove() {
        int LevelMove = level.getMove();
        assertEquals(0, LevelMove);
    }

    /**
     * setMove Test.
     * <p> Test the setMove method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Test
    public void setMove() {
        level.setMove(50);
        int newLevelMove = level.getMove();
        assertEquals(50, newLevelMove);
    }

    /**
     * setKeeperPosition Test.
     * <p> Test the setKeeperPosition method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Test
    public void setKeeperPosition() {
        level.setKeeperPosition(new Point(1, 2));
        Point point = level.getKeeperPosition();
        assertEquals(new Point(1, 2), point);
    }

    /**
     * isComplete Test.
     * <p> Test the isComplete method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Test
    public void isComplete() {
        boolean complete = level.isComplete();
        assertFalse(complete);
    }

    /**
     * getName Test.
     * <p> Test the getName method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Test
    public void getName() {
        String name = level.getName();
        assertEquals("lEVEL 1", name);
    }

    /**
     * getIndex Test.
     * <p> Test the getIndex method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Test
    public void getIndex() {
        int index = level.getIndex();
        assertEquals(1, index);
    }

    /**
     * getKeeperPosition Test.
     * <p> Test the getKeeperPosition method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Test
    public void getKeeperPosition() {
        Point keeperPosition = level.getKeeperPosition();
        assertEquals(new Point(18, 10), keeperPosition);
    }

    /**
     * getTargetObject Test.
     * <p> Test the getTargetObject method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-9:24
     */
    @Test
    public void getTargetObject() {
        GameObject target = level.getTargetObject(level.getKeeperPosition(), new Point(1, 0));
        assertEquals("W", target.getStringSymbol());
    }
}