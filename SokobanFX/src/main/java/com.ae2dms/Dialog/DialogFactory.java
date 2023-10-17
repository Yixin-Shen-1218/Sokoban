package com.ae2dms.Dialog;

import com.ae2dms.GameState.GameEngine;
import javafx.stage.Stage;

/**
 * <p> The Class DialogFactory defines a factory design pattern that used to generate dialog.
 * Generate different dialog type by different parameters.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/24-18:16
 * @since 1.0
 */
public class DialogFactory {
    /**
     * Generate different dialog object according to different parameters.
     * <p> If the type is null, print warning, return null; if the type is Vic, return a Vic dialog object;
     * if the type is About, return a About dialog object; if the type is Undo, return a Undo dialog object; else return null;
     *
     * @param type       The type of dialog.
     * @param stage      The primary stage in Main.
     * @param gameEngine The current gameEngine object.
     * @return com.ae2dms.Dialog.Dialog
     * @author Yixin SHEN
     * @date 2020/11/29-20:51
     */
    public Dialog getDialog(String type, Stage stage, GameEngine gameEngine) {
        if (type == null) {
            System.out.println("Dialog type missing");
            return null;
        } else if (type.equalsIgnoreCase("Vic"))
            return new VicDialog(stage, gameEngine);
        if (type.equalsIgnoreCase("About"))
            return new AboutDialog(stage);
        if (type.equalsIgnoreCase("Undo"))
            return new UndoDialog(stage);
        System.out.println("Dialog type not supported");
        return null;
    }
}