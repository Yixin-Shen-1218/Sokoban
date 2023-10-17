package com.ae2dms.Main;

import com.ae2dms.GameState.GameEngine;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * <p> The Class GameLogger extends the Logger class to generate log file.
 * Defines some logger fields and some Methods of logger.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/25-12:37
 * @since 1.0
 */
public class GameLogger extends Logger {
    /**
     * Defines the Logger object.
     */
    private static final Logger logger = Logger.getLogger("GameLogger");
    /**
     * Defines the date of logger.
     */
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    /**
     * Defines the calendar.
     */
    private final Calendar calendar = Calendar.getInstance();

    /**
     * Generate the log file.
     * <p> Constructor of the GameLogger class, generate a logger file.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date   2020/11/30-22:20
     */
    public GameLogger() throws IOException {
        super("com.aes2dms.sokoban", null);

        File directory = new File(System.getProperty("user.dir") + "/" + "logs");
        directory.mkdirs();

        FileHandler fh = new FileHandler(directory + "/" + GameEngine.GAME_NAME + ".log");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }

    /**
     * Create a formatted massage.
     * <p> Create a formatted massage, translate the time to -- format.
     *
     * @param message The original message.
     * @return java.lang.String The translated result message.
     * @author Yixin SHEN
     * @date   2020/11/30-22:21
     */
    private String createFormattedMessage(String message) {
        return dateFormat.format(calendar.getTime()) + " -- " + message;
    }

    /**
     * Write the message as info to logger.
     * <p> Write the message as info to logger.
     *
     * @param message The original message.
     * @author Yixin SHEN
     * @date   2020/11/30-22:22
     */
    public void info(String message) {
        logger.info(createFormattedMessage(message));
    }

    /**
     * Write the message as warning to logger.
     * <p> Write the message as warning to logger.
     *
     * @param message The original message.
     * @author Yixin SHEN
     * @date   2020/11/30-22:22
     */
    public void warning(String message) {
        logger.warning(createFormattedMessage(message));
    }

    /**
     * Write the message as severe to logger.
     * <p> Write the message as severe to logger.
     *
     * @param message The original message.
     * @author Yixin SHEN
     * @date   2020/11/30-22:22
     */
    public void severe(String message) {
        logger.severe(createFormattedMessage(message));
    }
}