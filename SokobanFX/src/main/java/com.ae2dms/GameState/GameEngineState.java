package com.ae2dms.GameState;

import java.awt.*;

/**
 * <p> The interface GameEngineState defines two method of the state class.
 * The interface GameEngineState defines two method of the state class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/26-10:26
 * @since 1.0
 */
public interface GameEngineState {
    /**
     * The keeper move method.
     * <p> The keeper move method.
     *
     * @param delta The movement in point format.
     * @throws CloneNotSupportedException CloneNotSupportedException
     * @author Yixin SHEN
     * @date 2020/11/30-21:34
     */
    void move(Point delta) throws CloneNotSupportedException;

    /**
     * Debug method.
     * <p> Set as the debug state or not.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-21:35
     */
    void debug();
}
