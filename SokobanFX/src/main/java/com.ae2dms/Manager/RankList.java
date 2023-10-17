package com.ae2dms.Manager;

import com.ae2dms.Controllers.SlotController;
import com.ae2dms.GameMap.Level;
import com.ae2dms.Manager.PlayerInfo;

import java.io.*;
import java.util.*;

/**
 * <p> The Class RankList defines the RankList structure, used to get the top5 ranking.
 * Defines some fields and methods that related to rankTop5.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/22-16:27
 * @since 1.0
 */
public class RankList {
    /**
     * The array list that contains the Top 5 player.
     */
    private final ArrayList<PlayerInfo> rankTop5;

    /**
     * The constructor of RankList class.
     * <p> Set the rankTop5 value by calling setRankTop5 method.
     *
     * @throws FileNotFoundException FileNotFoundException
     * @author Yixin SHEN
     * @date 2020/11/30-22:53
     */
    public RankList() throws FileNotFoundException {
        rankTop5 = setRankTop5();
    }

    /**
     * Return the Top5 player in array list.
     * <p> Read ranking.txt file, return the Top5 player in array list.
     *
     * @return java.util.ArrayList The Top5 player in array list.
     * @throws FileNotFoundException FileNotFoundException
     * @author Yixin SHEN
     * @date 2020/11/30-23:36
     */
    private ArrayList<PlayerInfo> setRankTop5() throws FileNotFoundException {
        ArrayList<PlayerInfo> playerInfos = readRanking();

        playerInfos.sort(Comparator.comparingInt(PlayerInfo::getMoveCount));

        ArrayList<PlayerInfo> Top5Player = new ArrayList<>(5);

        for (int i = 0; i < 5; ++i) {
            Top5Player.add(playerInfos.get(i));
        }

        return Top5Player;
    }

    /**
     * Read the ranking.txt file, return the top5 player in array list.
     * <p> Read the ranking.txt file, return the top5 player in array list.
     *
     * @return java.util.ArrayList The top5 players' info.
     * @throws FileNotFoundException FileNotFoundException
     * @author Yixin SHEN
     * @date 2020/11/30-23:38
     */
    private ArrayList<PlayerInfo> readRanking() throws FileNotFoundException {
        File sourceFile = new File("src/main/resources/Ranking/ranking.txt");
        InputStream input = new FileInputStream(sourceFile);
        ArrayList<PlayerInfo> playerInfos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String NickName;
            String line1;
            int MoveCount = 0;

            while ((line1 = reader.readLine()) != null) {
                String line2 = reader.readLine();
                NickName = line1.replace("MapSetName: ", "");

                String inputString = line2.replace("LevelMoveCount: ", "");
                String[] stringArray = inputString.split(" ");

                int[] levelMove = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    levelMove[i] = Integer.parseInt(stringArray[i]);
                    MoveCount += Integer.parseInt(stringArray[i]);
                }

                playerInfos.add(new PlayerInfo(MoveCount, levelMove, NickName));
                MoveCount = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return playerInfos;
    }

    /**
     * Return the Top5 player in array list.
     * <p> Return the Top5 player in array list.
     *
     * @return java.util.ArrayList The top5 player array list.
     * @author Yixin SHEN
     * @date 2020/11/30-23:45
     */
    public ArrayList<PlayerInfo> getRankTop5() {
        return rankTop5;
    }
}
