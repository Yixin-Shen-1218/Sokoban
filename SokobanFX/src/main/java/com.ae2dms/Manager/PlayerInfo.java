package com.ae2dms.Manager;

/**
 * <p> The Class PlayerInfo defines the playerInfo structure.
 * Defines some fields and methods that related to player info.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/22-16:23
 * @since 1.0
 */
public class PlayerInfo {
    /**
     * Return the move count of the player.
     * <p> Return the move count of the player.
     *
     * @return int The moveCount of the player.
     * @author Yixin SHEN
     * @date 2020/11/30-22:47
     */
    public int getMoveCount() {
        return MoveCount;
    }

    /**
     * Return the level move count array.
     * <p> Return the level move count array.
     *
     * @return int[] The level move count in an int array format.
     * @author Yixin SHEN
     * @date 2020/11/30-22:48
     */
    public int[] getLevelMoveCount() {
        return LevelMoveCount;
    }

    /**
     * Return the nickName of the player.
     * <p> Return the nickName of the player.
     *
     * @return java.lang.String The NickName user has input.
     * @author Yixin SHEN
     * @date 2020/11/30-22:48
     */
    public String getNickName() {
        return NickName;
    }

    /**
     * Defines the move count of the player.
     */
    private final int MoveCount;
    /**
     * Defines the LevelMoveCount of the player in an int array.
     */
    private final int[] LevelMoveCount;
    /**
     * Defines the NickName of the player.
     */
    private final String NickName;

    /**
     * The constructor of the PlayerInfo class.
     * <p> Instantiate the player info, set the fields according to parameters.
     *
     * @param moveCount      The total moveCount.
     * @param levelMoveCount The level move count in int array format.
     * @param nickName       The player's nick name.
     * @author Yixin SHEN
     * @date 2020/11/30-22:51
     */
    public PlayerInfo(int moveCount, int[] levelMoveCount, String nickName) {
        MoveCount = moveCount;
        LevelMoveCount = levelMoveCount;
        NickName = nickName;
    }
}
