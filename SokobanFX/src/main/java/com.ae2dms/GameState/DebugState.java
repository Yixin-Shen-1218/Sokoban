package com.ae2dms.GameState;

import com.ae2dms.Controllers.GameController;
import com.ae2dms.GameMap.GameGrid;
import com.ae2dms.GameMap.GameObject;
import com.ae2dms.GameMap.Level;
import com.ae2dms.Main.GameLogger;
import com.ae2dms.Music.FootStep;
import com.ae2dms.Music.ImpactCrate;
import com.ae2dms.Music.ImpactWall;

import java.awt.*;
import java.util.List;

/**
 * <p> The Class DebugState defines the DebugState of GameEngine.
 * Defines a move method under debug state. Implements the GameEngineState Class.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/26-10:31
 * @since 1.0
 */
public class DebugState implements GameEngineState {
    /**
     * Defines the current gameEngine.
     */
    GameEngine gameEngine;

    /**
     * Constructor of DebugState, set the gameEngine as the current gameEngine.
     * <p> Constructor of DebugState, set the gameEngine as the current gameEngine.
     *
     * @param gameEngine The current gameEngine.
     * @author Yixin SHEN
     * @date 2020/11/30-20:17
     */
    public DebugState(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    /**
     * The keeper move method under DebugState.
     * <p> If the crate target is wall/crate, move failed. else, move successful.
     *
     * @param delta The move type in point format. (1,0)(-1,0)(0,1)(0,-1)
     * @author Yixin SHEN
     * @date 2020/11/30-20:18
     */
    @Override
    public void move(Point delta) throws CloneNotSupportedException {
        if (gameEngine.isGameComplete()) {
            return;
        }

        Level currentLevel = gameEngine.getCurrentLevel();
        java.util.List<Point> keeperTrack = gameEngine.getKeeperTrack();
        List<GameGrid> gameGridsTrack = gameEngine.getGameGridsTrack();
        GameLogger logger = GameEngine.getLogger();

        Point keeperPosition = currentLevel.getKeeperPosition();
        GameObject keeper = currentLevel.objectsGrid.getGameObjectAt(keeperPosition);
        Point targetObjectPoint = GameGrid.translatePoint(keeperPosition, delta);
        GameObject keeperTarget = currentLevel.objectsGrid.getGameObjectAt(targetObjectPoint);

        System.out.println("Current level state:");
        System.out.println(currentLevel.toString());
        System.out.println(currentLevel.diamondsGrid);
        System.out.println("Keeper pos: " + keeperPosition);
        System.out.println("Movement source obj: " + keeper);
        System.out.printf("Target object: %s at [%s]", keeperTarget, targetObjectPoint);

        boolean keeperMoved = false;

        switch (keeperTarget) {

            case WALL:
                if (gameEngine.isSoundEffect()) {
                    ImpactWall.getInstance().playMusic();
                }
                break;

            case CRATE:
                // if the crate target is not FLOOR, break, move false
                GameObject crateTarget = currentLevel.getTargetObject(targetObjectPoint, delta);
                if (crateTarget != GameObject.FLOOR) {
                    break;
                }

                gameGridsTrack.add(currentLevel.objectsGrid.clone());

                // move FLOOR to the original position of the CRATE
                currentLevel.objectsGrid.putGameObjectAt(currentLevel.objectsGrid.getGameObjectAt(GameGrid.translatePoint(targetObjectPoint, delta)), targetObjectPoint);

                // move the CRATE
                currentLevel.objectsGrid.putGameObjectAt(keeperTarget, GameGrid.translatePoint(targetObjectPoint, delta));

                // move the FLOOR to the original position of keeper
                currentLevel.objectsGrid.putGameObjectAt(currentLevel.objectsGrid.getGameObjectAt(GameGrid.translatePoint(keeperPosition, delta)), keeperPosition);

                // move the keeper
                currentLevel.objectsGrid.putGameObjectAt(keeper, GameGrid.translatePoint(keeperPosition, delta));


                keeperMoved = true;

                if (gameEngine.isSoundEffect()) {
                    ImpactCrate.getInstance().playMusic();
                }

                break;

            case FLOOR:
                gameGridsTrack.add(currentLevel.objectsGrid.clone());

                // move the FLOOR to the original position of keeper
                currentLevel.objectsGrid.putGameObjectAt(currentLevel.objectsGrid.getGameObjectAt(GameGrid.translatePoint(keeperPosition, delta)), keeperPosition);

                // move the keeper
                currentLevel.objectsGrid.putGameObjectAt(keeper, GameGrid.translatePoint(keeperPosition, delta));

                keeperMoved = true;

                if (gameEngine.isSoundEffect()) {
                    FootStep.getInstance().playMusic();
                }

                break;

            default:
                logger.severe("The object to be moved was not a recognised GameObject.");
                throw new AssertionError("This should not have happened. Report this problem to the developer.");
        }

        // if the keeper moved, make the level move = level move + 1; add keeperPosition to moveTrack ArrayList; translate keeperPosition to targetPosition
        // if the current level is completed, make the current level to next level
        if (keeperMoved) {
            keeperTrack.add(new Point(keeperPosition.x, keeperPosition.y));
            keeperPosition.translate((int) delta.getX(), (int) delta.getY());

            if (currentLevel.isComplete()) {
                System.out.println("Level complete!");
                gameGridsTrack.clear();
                keeperTrack.clear();
                gameEngine.setCurrentLevel(gameEngine.getNextLevel());

                if (currentLevel.getIndex() >= GameEngine.maxLevel) {
                    GameEngine.maxLevel = GameEngine.maxLevel + 1;
                }
                GameController.saveGame();
                return;
            }
            // level move +1
            currentLevel.setMove(currentLevel.getMove() + 1);
        }
    }

    /**
     * Change the state of gameEngine to playState.
     * <p> Change the state of gameEngine to playState, set the Debug filed in gameEngine to false.
     *
     * @author Yixin SHEN
     * @date 2020/11/30-20:22
     */
    @Override
    public void debug() {
        gameEngine.setState(gameEngine.getPlayState());
        gameEngine.setDebug(false);
    }
}
