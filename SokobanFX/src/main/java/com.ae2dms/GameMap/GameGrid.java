package com.ae2dms.GameMap;

import com.ae2dms.GameState.GameEngine;

import java.awt.*;
import java.util.Iterator;

/**
 * <p> The Class GameGrid is used to load the map into grid.
 * Load the map in a 20 * 20 gridMap, containing some methods that manipulate the gameGrid map.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/18-9:48
 * @since 1.0
 */
public class GameGrid implements Iterable, Cloneable {
    /**
     * Define map column number.
     */
    final int COLUMNS;
    /**
     * Define map row number.
     */
    final int ROWS;
    /**
     * Define GameGrid map in a 2D-array consist of GameObject.
     */
    private GameObject[][] gameObjects;

    /**
     * Constructor of GameGrid, define the class field.
     * <p> Constructor of GameGrid, define the class field, including ROWS, COLUMNS and gameObject 2D-array.
     *
     * @param columns Column number of the level map.
     * @param rows    Row number of the level map.
     * @author Yixin SHEN
     * @date 2020/11/30-15:47
     */
    public GameGrid(int columns, int rows) {
        COLUMNS = columns;
        ROWS = rows;

        // Initialize the array
        gameObjects = new GameObject[COLUMNS][ROWS];
    }

    /**
     * Translate the point location according to the delta value.
     * <p> Get the sourceLocation of the original point, move the original point according to the delta point. e.g., (1,0),(-1,0),(0,1),(0,-1).
     *
     * @param sourceLocation The original point position.
     * @param delta          Define how the point should be moved.
     * @return java.awt.Point The point after being moved.
     * @author Yixin SHEN
     * @date 2020/11/30-15:50
     */
    public static Point translatePoint(Point sourceLocation, Point delta) {
        Point translatedPoint = new Point(sourceLocation);
        translatedPoint.translate((int) delta.getX(), (int) delta.getY());
        return translatedPoint;
    }

    /**
     * Get the GameGrid Dimension.
     * <p> New a Dimension object according to the GameGrid Column and Row.
     *
     * @return java.awt.Dimension The Dimension object.
     * @author Yixin SHEN
     * @date 2020/11/30-15:54
     */
    public Dimension getDimension() {
        return new Dimension(COLUMNS, ROWS);
    }

    /**
     * Get the GameObject type at target point.
     * <p> Input the source point and move delta, return the GameObject type at the target point.
     *
     * @param source The original position point.
     * @param delta  The move type in point format.
     * @return com.ae2dms.GameMap.GameObject The GameObject type at the target point.
     * @author Yixin SHEN
     * @date 2020/11/30-16:02
     */
    GameObject getTargetFromSource(Point source, Point delta) {
        return getGameObjectAt(translatePoint(source, delta));
    }

    /**
     * Get the game object at the corresponding position (col, row).
     * <p> Utilize col number and row number to get the GameObject type in this position.
     *
     * @param col The col number of position.
     * @param row The row number of position.
     * @return com.ae2dms.GameMap.GameObject The GameObject type at position.
     * @author Yixin SHEN
     * @date 2020/11/30-16:14
     */
    public GameObject getGameObjectAt(int col, int row) throws ArrayIndexOutOfBoundsException {
        if (isPointOutOfBounds(col, row)) {
            if (GameEngine.isDebugActive()) {
                System.out.printf("Trying to get null GameObject from COL: %d  ROW: %d", col, row);
            }
            throw new ArrayIndexOutOfBoundsException("The point [" + col + ":" + row + "] is outside the map.");
        }

        return gameObjects[col][row];
    }

    /**
     * Get the GameObject type at the Point p.
     * <p> Get the GameObject type at the Point p.
     *
     * @param p The point used to get its GameObject type.
     * @return com.ae2dms.GameMap.GameObject
     * @author Yixin SHEN
     * @date 2020/11/30-16:17
     */
    public GameObject getGameObjectAt(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Point cannot be null.");
        }

        return getGameObjectAt((int) p.getX(), (int) p.getY());
    }

    /**
     * Remove the GameObject at that point.
     * <p> Remove the GameObject at target point, set it as null.
     *
     * @param position The point of position.
     * @return boolean
     * @author Yixin SHEN
     * @date 2020/11/30-16:19
     */
    public boolean removeGameObjectAt(Point position) {
        return putGameObjectAt(null, position);
    }

    /**
     * Set the GameObject type at target point as the gameObject type in parameter.
     * <p> If the point is out of map bounds, return false; else, set the GameObject type at target point as the gameObject type in parameter, return true.
     *
     * @param gameObject The gameObject type used to set as.
     * @param x          The column number.
     * @param y          The row number.
     * @return boolean Defines whether set successfully or not.
     * @author Yixin SHEN
     * @date 2020/11/30-16:28
     */
    public boolean putGameObjectAt(GameObject gameObject, int x, int y) {
        if (isPointOutOfBounds(x, y)) {
            return false;
        }

        gameObjects[x][y] = gameObject;
        return gameObjects[x][y] == gameObject;
    }

    /**
     * Set the GameObject type at target point as the gameObject type in parameter.
     * <p> If the point is out of map bounds, return false; else, set the GameObject type at target point as the gameObject type in parameter, return true.
     *
     * @param gameObject The gameObject type used to set as.
     * @param p          The target point.
     * @return boolean Defines whether set successfully or not.
     * @author Yixin SHEN
     * @date 2020/11/30-16:33
     */
    public boolean putGameObjectAt(GameObject gameObject, Point p) {
        return p != null && putGameObjectAt(gameObject, (int) p.getX(), (int) p.getY());
    }

    /**
     * Define whether the point is out of map bounds or not.
     * <p> If the x/y is less than 0 or greater or equal to COLUMNS/ROWS return true; else return false.
     *
     * @param x The x value of point.
     * @param y The y value of point.
     * @return boolean Defines whether point is out of bounds.
     * @author Yixin SHEN
     * @date 2020/11/30-16:35
     */
    private boolean isPointOutOfBounds(int x, int y) {
        return (x < 0 || y < 0 || x >= COLUMNS || y >= ROWS);
    }

    /**
     * Define whether the point is out of map bounds or not.
     * <p> If the x/y is less than 0 or greater or equal to COLUMNS/ROWS return true; else return false.
     *
     * @param p The point used to check.
     * @return boolean Defines whether point is out of bounds.
     * @author Yixin SHEN
     * @date 2020/11/30-16:38
     */
    private boolean isPointOutOfBounds(Point p) {
        return isPointOutOfBounds(p.x, p.y);
    }

    /**
     * Translate the gameObject 2D-array to string.
     * <p> Translate the gameObject 2D-array to string according to the GameObject type in the array.
     *
     * @return java.lang.String Return the 2D-array gameGrid in String format.
     * @author Yixin SHEN
     * @date 2020/11/30-16:41
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(gameObjects.length);

        for (GameObject[] gameObject : gameObjects) {
            for (GameObject aGameObject : gameObject) {
                if (aGameObject == null) {
                    aGameObject = GameObject.DEBUG_OBJECT;
                }
                sb.append(aGameObject.getCharSymbol());
            }

            sb.append('\n');
        }

        return sb.toString();
    }

    /**
     * Instantiate a new GridIterator object.
     * <p> Instantiate a new GridIterator object.
     *
     * @return java.util.Iterator The GridIterator object.
     * @author Yixin SHEN
     * @date 2020/11/30-16:53
     */
    @Override
    public Iterator<GameObject> iterator() {
        return new GridIterator();
    }

    /**
     * <p> Subclass of gameGrid.
     * Defines a GridIterator class.
     *
     * @author Yixin SHEN
     * @version 1.1
     * @date 2020/11/30-16:41
     * @since 1.0
     */
    public class GridIterator implements Iterator<GameObject> {
        /**
         * The row number.
         */
        int row = 0;
        /**
         * The column number.
         */
        int column = 0;

        /**
         * Whether the current point has the next point.
         * <p> Use to check whether the current point has the next point or not.
         *
         * @return boolean True means haveNext, false means no next.
         * @author Yixin SHEN
         * @date 2020/11/30-16:57
         */
        @Override
        public boolean hasNext() {
            return !(row == ROWS && column == COLUMNS);
        }

        /**
         * Get the next GameObject in the gameGrid.
         * <p> Get the next GameObject in the gameGrid.
         *
         * @return com.ae2dms.GameMap.GameObject The GameObject type at the net point.
         * @author Yixin SHEN
         * @date 2020/11/30-17:00
         */
        @Override
        public GameObject next() {
            if (column >= COLUMNS) {
                column = 0;
                row++;
            }
            return getGameObjectAt(column++, row);
        }
    }

    /**
     * Override the clone method.
     * <p> Override the clone method, make the gameGrid can be copied.
     *
     * @return com.ae2dms.GameMap.GameGrid The gameGrid copy.
     * @author Yixin SHEN
     * @date 2020/11/30-17:10
     */
    @Override
    public GameGrid clone() throws CloneNotSupportedException {
        GameGrid gameGrid = new GameGrid(this.COLUMNS, this.ROWS);
        gameGrid.gameObjects = new GameObject[this.COLUMNS][this.ROWS];
        for (int i = 0; i < this.COLUMNS; i++) {
            if (this.ROWS >= 0) System.arraycopy(this.gameObjects[i], 0, gameGrid.gameObjects[i], 0, this.ROWS);
        }
        return gameGrid;

    }
}