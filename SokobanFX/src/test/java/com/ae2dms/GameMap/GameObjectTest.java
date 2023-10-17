package com.ae2dms.GameMap;

import com.ae2dms.GameState.GameEngine;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * <p> The class GameObjectTest is to test GameObject enum.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/3-17:33
 * @since 1.0
 */
public class GameObjectTest {
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
     * @date 2020/12/3-17:33
     */
    @Before
    public void setUp() throws Exception {
        InputStream in = new FileInputStream(new File("src/test/resources/debugGame.skb"));
        GameEngine gameEngine = new GameEngine(in, true);
        this.objectsGrid = gameEngine.getCurrentLevel().objectsGrid;
    }

    /**
     * fromChar Test.
     * <p> Test the fromChar method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-17:33
     */
    @Test
    public void fromChar() {
        GameObject gameObject = GameObject.fromChar('c');
        assertEquals("C", gameObject.getStringSymbol());

        GameObject gameObject2 = GameObject.fromChar('S');
        assertEquals("S", gameObject2.getStringSymbol());

        GameObject gameObject3 = GameObject.fromChar('f');
        assertEquals("W", gameObject3.getStringSymbol());
    }

    /**
     * getStringSymbol Test.
     * <p> Test the getStringSymbol method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-17:33
     */
    @Test
    public void getStringSymbol() {
        GameObject gameObject = objectsGrid.getGameObjectAt(18,10);
        assertEquals("S", gameObject.getStringSymbol());
    }

    /**
     * getCharSymbol Test.
     * <p> Test the getCharSymbol method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-17:33
     */
    @Test
    public void getCharSymbol() {
        GameObject gameObject = objectsGrid.getGameObjectAt(18,10);
        assertEquals('S', gameObject.getCharSymbol());
    }
}