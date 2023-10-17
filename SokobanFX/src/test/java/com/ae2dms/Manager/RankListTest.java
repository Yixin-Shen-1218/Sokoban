package com.ae2dms.Manager;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * <p> The class RankListTest is to test RankList class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/12/3-21:04
 * @since 1.0
 */
public class RankListTest {

    /**
     * getRankTop5 Test.
     * <p> Test the getRankTop5 method.
     *
     * @throws FileNotFoundException FileNotFoundException
     * @author Yixin SHEN
     * @date 2020/12/3-21:05
     */
    @Test
    public void getRankTop5() throws FileNotFoundException {
        RankList rankList = new RankList();
        ArrayList<PlayerInfo> rankTop5 = rankList.getRankTop5();
        assertEquals("pwq", rankTop5.get(0).getNickName());

        assertEquals("Jenny", rankTop5.get(1).getNickName());
    }
}