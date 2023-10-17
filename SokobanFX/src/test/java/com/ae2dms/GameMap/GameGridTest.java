package com.ae2dms.GameMap;

import com.ae2dms.GameState.GameEngine;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * <p> The class GameGridTest is to test GameGrid class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/3-16:33
 * @since 1.0
 */
public class GameGridTest {
    /**
     * The level is used to do the test.
     */
    private Level level;
    /**
     * The level's objectsGrid is used to do the test.
     */
    private GameGrid objectsGrid;

    /**
     * setUp for the test class.
     * <p> Instantiate a new level and its objectsGrid to do the test.
     *
     * @throws Exception Exception
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Before
    public void setUp() throws Exception {
        InputStream in = new FileInputStream(new File("src/test/resources/debugGame.skb"));
        GameEngine gameEngine = new GameEngine(in, true);
        this.level = gameEngine.getCurrentLevel();
        this.objectsGrid = gameEngine.getCurrentLevel().objectsGrid;
    }

    /**
     * translatePoint Test.
     * <p> Test the translatePoint method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void translatePoint() {
        Point translatePoint = GameGrid.translatePoint(level.getKeeperPosition(), new Point(1, 0));
        assertEquals(new Point(19, 10), translatePoint);
    }

    /**
     * getDimension Test.
     * <p> Test the getDimension method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void getDimension() {
        Dimension dimension = objectsGrid.getDimension();
        assertEquals(new Dimension(20, 20), dimension);
    }

    /**
     * getTargetFromSource Test.
     * <p> Test the getTargetFromSource method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void getTargetFromSource() {
        GameObject target = objectsGrid.getTargetFromSource(level.getKeeperPosition(), new Point(1, 0));
        assertEquals("W", target.getStringSymbol());
    }

    /**
     * getGameObjectAt Test.
     * <p> Test the getGameObjectAt method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void getGameObjectAt() {
        GameObject target = objectsGrid.getGameObjectAt(18, 10);
        assertEquals("S", target.getStringSymbol());

        GameObject target2 = objectsGrid.getGameObjectAt(19, 10);
        assertEquals("W", target2.getStringSymbol());
    }

    /**
     * testGetGameObjectAt Test.
     * <p> Test the testGetGameObjectAt method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void testGetGameObjectAt() {
        GameObject target = objectsGrid.getGameObjectAt(new Point(18, 10));
        assertEquals("S", target.getStringSymbol());

        GameObject target2 = objectsGrid.getGameObjectAt(new Point(19, 10));
        assertEquals("W", target2.getStringSymbol());
    }

    /**
     * removeGameObjectAt Test.
     * <p> Test the removeGameObjectAt method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void removeGameObjectAt() {
        objectsGrid.removeGameObjectAt(new Point(19, 10));
        assertNull(objectsGrid.getGameObjectAt(19, 10));
    }

    /**
     * putGameObjectAt Test.
     * <p> Test the putGameObjectAt method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void putGameObjectAt() {
        objectsGrid.putGameObjectAt(null, 2, 10);
        assertNull(objectsGrid.getGameObjectAt(2, 10));
    }

    /**
     * testPutGameObjectAt Test.
     * <p> Test the testPutGameObjectAt method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void testPutGameObjectAt() {
        objectsGrid.putGameObjectAt(null, new Point(2, 10));
        assertNull(objectsGrid.getGameObjectAt(2, 10));
    }

    /**
     * testToString Test.
     * <p> Test the testToString method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-16:33
     */
    @Test
    public void testToString() {
        String map = objectsGrid.toString();
        assertEquals("WWWWWWWWWWWWWWWWWWWW\n" +
                "W    W             W\n" +
                "W C  W             W\n" +
                "W    W      WWWWWWWW\n" +
                "W    WWWW  WWWWWWWWW\n" +
                "W            WWWWWWW\n" +
                "W    WWWWW   WWWWWWW\n" +
                "W    WWWWWWWWWWWWWWW\n" +
                "W    WWWWWWWWWWWWWWW\n" +
                "W    WWWWWWWWWWWWWWW\n" +
                "W    WWWWWWWWWWWWWWW\n" +
                "W           WWWWWWWW\n" +
                "W         WWWWWWWWWW\n" +
                "WWWWWWW   WWWWWWWWWW\n" +
                "WWWWWWW   WWWWWWWWWW\n" +
                "WWWWWWW   WWWWWWWWWW\n" +
                "WWWWWWW   WWWWWWWWWW\n" +
                "WWWWWWW   WWWWWWWWWW\n" +
                "WWWWWWW   SWWWWWWWWW\n" +
                "WWWWWWWWWWWWWWWWWWWW\n", map);
    }

}