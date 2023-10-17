package com.ae2dms.GameMap;

/**
 * <p> GameObject Enum, Define the game object and some method related to game object.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/30-17:10
 * @since 1.0
 */
public enum GameObject {
    /**
     * Defines the WALL symbol.
     */
    WALL('W'),
    /**
     * Defines the FLOOR symbol.
     */
    FLOOR(' '),
    /**
     * Defines the CRATE symbol.
     */
    CRATE('C'),
    /**
     * Defines the DIAMOND symbol.
     */
    DIAMOND('D'),
    /**
     * Defines the KEEPER symbol.
     */
    KEEPER('S'),
    /**
     * Defines the CRATE_ON_DIAMOND symbol.
     */
    CRATE_ON_DIAMOND('O'),
    /**
     * Defines the KEEPER_ON_DIAMOND symbol.
     */
    KEEPER_ON_DIAMOND('T'),
    /**
     * Defines the DEBUG_OBJECT symbol.
     */
    DEBUG_OBJECT('=');

    /**
     * The char symbol of game object.
     */
    public final char symbol;

    /**
     * Constructor of GameObject.
     * <p> Instantiate a gameObject, set the symbol field as symbol inputed.
     *
     * @param symbol GameObject symbol.
     * @author Yixin SHEN
     * @date 2020/11/30-17:15
     */
    GameObject(final char symbol) {
        this.symbol = symbol;
    }

    /**
     * Translate GameObject form char format to enum format.
     * <p> Translate GameObject form char format to enum format.
     *
     * @param c 1
     * @return com.ae2dms.GameMap.GameObject The GameObject type tranlated by char c.
     * @author Yixin SHEN
     * @date 2020/11/30-17:17
     */
    public static GameObject fromChar(char c) {
        for (GameObject t : GameObject.values()) {
            if (Character.toUpperCase(c) == t.symbol) {
                return t;
            }
        }
        return WALL;
    }

    /**
     * Translate the symbol to string type.
     * <p> Translate the symbol to string type.
     *
     * @return java.lang.String The string type of symbol.
     * @author Yixin SHEN
     * @date 2020/11/30-17:18
     */
    public String getStringSymbol() {
        return String.valueOf(symbol);
    }

    /**
     * Get the char symbol.
     * <p> Get the char symbol.
     *
     * @return char The char symbol of the GameObject.
     * @author Yixin SHEN
     * @date 2020/11/30-17:19
     */
    public char getCharSymbol() {
        return symbol;
    }
}