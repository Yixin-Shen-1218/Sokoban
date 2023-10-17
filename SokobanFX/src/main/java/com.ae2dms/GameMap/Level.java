package com.ae2dms.GameMap;

import com.ae2dms.GameState.GameEngine;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

/**
 * <p> The Class Level defines the level object in the game.
 * Every level in the game is an object. Defines some level fields and method that manipulate the level object.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/30-17:10
 * @since 1.0
 */
public final class Level implements Iterable<GameObject> {
    /**
     * Defines the game object grid, including the keeper, wall and crates.
     */
    public GameGrid objectsGrid;
    /**
     * Defines the game diamond grid, only contains the diamonds of the level.
     */
    public final GameGrid diamondsGrid;
    /**
     * Defines the name of level.
     */
    private final String name;
    /**
     * Defines the index of level.
     */
    private final int index;
    /**
     * Defines the diamonds number of level.
     */
    private int numberOfDiamonds = 0;
    /**
     * Defines the level move count.
     */
    private int move = 0;
    /**
     * Defines the level keeper position point.
     */
    private Point keeperPosition = new Point(0, 0);

    /**
     * Get the level move count.
     * <p> Return the move count of the level.
     *
     * @return int The level move count.
     * @author Yixin SHEN
     * @date 2020/11/18-15:35
     */
    public int getMove() {
        return move;
    }

    /**
     * Set the level move count.
     * <p> Set the level move count number.
     *
     * @param move The move value to set as.
     * @author Yixin SHEN
     * @date 2020/11/30-17:34
     */
    public void setMove(int move) {
        this.move = move;
    }

    /**
     * Set the keeper position.
     * <p> Set the level keeper position.
     *
     * @param keeperPosition The keeper position point to set as.
     * @author Yixin SHEN
     * @date 2020/11/30-17:35
     */
    public void setKeeperPosition(Point keeperPosition) {
        this.keeperPosition = keeperPosition;
    }

    /**
     * Constructor of level class, initiate the level object.
     * <p> Constructor of level class, set the level fields according to the parameters.
     *
     * @param levelName  The name of level.
     * @param levelIndex The index of level.
     * @param raw_level  The raw level map of level.
     * @author Yixin SHEN
     * @date 2020/11/30-17:36
     */
    public Level(String levelName, int levelIndex, List<String> raw_level) {
        if (GameEngine.isDebugActive()) {
            System.out.printf("[ADDING LEVEL] LEVEL [%d]: %s\n", levelIndex, levelName);
        }

        name = levelName;
        index = levelIndex;

        int rows = raw_level.size();
        int columns = raw_level.get(0).trim().length();

        objectsGrid = new GameGrid(rows, columns);
        diamondsGrid = new GameGrid(rows, columns);

        for (int row = 0; row < raw_level.size(); row++) {

            for (int col = 0; col < raw_level.get(row).length(); col++) {
                GameObject curTile = GameObject.fromChar(raw_level.get(row).charAt(col));

                if (curTile == GameObject.DIAMOND) {
                    numberOfDiamonds++;
                    diamondsGrid.putGameObjectAt(curTile, row, col);
                    curTile = GameObject.FLOOR;
                } else if (curTile == GameObject.CRATE_ON_DIAMOND) {
                    numberOfDiamonds++;
                    curTile = GameObject.DIAMOND;
                    diamondsGrid.putGameObjectAt(curTile, row, col);
                    curTile = GameObject.CRATE;
                } else if (curTile == GameObject.KEEPER) {
                    keeperPosition = new Point(row, col);
                } else if (curTile == GameObject.KEEPER_ON_DIAMOND) {
                    numberOfDiamonds++;
                    curTile = GameObject.DIAMOND;
                    diamondsGrid.putGameObjectAt(curTile, row, col);
                    keeperPosition = new Point(row, col);
                    curTile = GameObject.KEEPER;
                }

                objectsGrid.putGameObjectAt(curTile, row, col);
                curTile = null;
            }
        }
    }

    /**
     * Check whether the level is completed.
     * <p> If all the crates are on the diamonds, return ture; else, return false.
     *
     * @return boolean Whether the level is completed or not.
     * @author Yixin SHEN
     * @date 2020/11/30-19:32
     */
    public boolean isComplete() {
        int cratedDiamondsCount = 0;
        for (int row = 0; row < objectsGrid.ROWS; row++) {
            for (int col = 0; col < objectsGrid.COLUMNS; col++) {
                if (objectsGrid.getGameObjectAt(col, row) == GameObject.CRATE && diamondsGrid.getGameObjectAt(col, row) == GameObject.DIAMOND) {
                    cratedDiamondsCount++;
                }
            }
        }
        return cratedDiamondsCount >= numberOfDiamonds;
    }

    /**
     * Return the level's name.
     * <p> Return the level's name.
     *
     * @return java.lang.String The level name.
     * @author Yixin SHEN
     * @date 2020/11/15-16:54
     */
    public String getName() {
        return name;
    }

    /**
     * Return the level's index.
     * <p> Return the level's index.
     *
     * @return int The level index.
     * @author Yixin SHEN
     * @date 2020/11/30-19:34
     */
    public int getIndex() {
        return index;
    }

    /**
     * Return the keeper position.
     * <p>  Return the keeper position.
     *
     * @return java.awt.Point The keeper position point.
     * @author Yixin SHEN
     * @date 2020/11/30-19:34
     */
    public Point getKeeperPosition() {
        return keeperPosition;
    }

    /**
     * Return the Target point's game object type.
     * <p> Use the original point position and move delta point, call the getTargetFromSource method in GameGrid class, return the object type of target.
     *
     * @param source The point of original position.
     * @param delta  The move type in point format.
     * @return com.ae2dms.GameMap.GameObject The target position game object type.
     * @author Yixin SHEN
     * @date 2020/11/30-19:35
     */
    public GameObject getTargetObject(Point source, Point delta) {
        return objectsGrid.getTargetFromSource(source, delta);
    }

    /**
     * Get the gameGrid in a string format.
     * <p> Get the gameGrid in a string format.
     *
     * @return java.lang.String The string type of gameGrids.
     * @author Yixin SHEN
     * @date 2020/11/30-19:38
     */
    @Override
    public String toString() {
        return objectsGrid.toString();
    }

    /**
     * Instantiate a new LevelIterator object.
     * <p> Instantiate a new LevelIterator object.
     *
     * @return java.util.Iterator The LevelIterator object.
     * @author Yixin SHEN
     * @date 2020/11/30-19:39
     */
    @Override
    public Iterator<GameObject> iterator() {
        return new LevelIterator();
    }

    /**
     * <p> Subclass of Level.
     * Defines a LevelIterator class.
     *
     * @author Yixin SHEN
     * @version 1.1
     * @date 2020/11/30-19:39
     * @since 1.0
     */
    public class LevelIterator implements Iterator<GameObject> {

        /**
         * The column value.
         */
        int column = 0;
        /**
         * The row value.
         */
        int row = 0;

        /**
         * Whether the current point has the next point.
         * <p> Use to check whether the current point has the next point or not.
         *
         * @return boolean True means haveNext, false means no next.
         * @author Yixin SHEN
         * @date 2020/11/30-19:40
         */
        @Override
        public boolean hasNext() {
            return !(row == objectsGrid.ROWS - 1 && column == objectsGrid.COLUMNS);
        }

        /**
         * Get the next GameObject in the gameGrid.
         * <p> Return the game object type of the next point in gameGrid.
         *
         * @return com.ae2dms.GameMap.GameObject The game object type of the point.
         * @author Yixin SHEN
         * @date 2020/11/30-19:42
         */
        @Override
        public GameObject next() {
            if (column >= objectsGrid.COLUMNS) {
                column = 0;
                row++;
            }
            GameObject object = objectsGrid.getGameObjectAt(column, row);
            GameObject diamond = diamondsGrid.getGameObjectAt(column, row);
            GameObject retObj = object;
            column++;
            if (diamond == GameObject.DIAMOND) {
                if (object == GameObject.CRATE) {
                    retObj = GameObject.CRATE_ON_DIAMOND;
                } else if (object == GameObject.FLOOR) {
                    retObj = diamond;
                } else if (object == GameObject.KEEPER) {
                    retObj = GameObject.KEEPER_ON_DIAMOND;
                }
            }
            return retObj;
        }

        /**
         * Get the current position of the iterator.
         * <p> Use to define the position of the iterator.
         *
         * @return java.awt.Point The position of the iterator.
         * @author Yixin SHEN
         * @date 2020/11/30-19:45
         */
        public Point getcurrentposition() {
            return new Point(column, row);
        }

    }
}