package com.ae2dms.Manager;

import com.ae2dms.GameState.GameEngine;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * <p> The class PlayerInfoTest is to test PlayerInfo class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/3-20:31
 * @since 1.0
 */
public class PlayerInfoTest {
    /**
     * The playerInfo is used to do the test.
     */
    private PlayerInfo playerInfo;

    /**
     * setUp for the test class.
     * <p> Instantiate a new playerInfo to do the test.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-20:31
     */
    @Before
    public void setUp() {
        this.playerInfo = new PlayerInfo(50, new int[]{50, 10, 30, 20, 50, 10, 20, 200}, "Jack");
    }

    /**
     * getMoveCount Test.
     * <p> Test the getMoveCount method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-20:31
     */
    @Test
    public void getMoveCount() {
        int moveCount = playerInfo.getMoveCount();
        assertEquals(50, moveCount);
    }

    /**
     * getLevelMoveCount Test.
     * <p> Test the getLevelMoveCount method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-20:31
     */
    @Test
    public void getLevelMoveCount() {
        int[] LevelMoveCount = playerInfo.getLevelMoveCount();
        assertEquals(Arrays.toString((new int[]{50, 10, 30, 20, 50, 10, 20, 200})), Arrays.toString(LevelMoveCount));
    }

    /**
     * getNickName Test.
     * <p> Test the getNickName method.
     *
     * @author Yixin SHEN
     * @date 2020/12/3-20:31
     */
    @Test
    public void getNickName() {
        String nickName = playerInfo.getNickName();
        assertEquals("Jack", nickName);
    }
}