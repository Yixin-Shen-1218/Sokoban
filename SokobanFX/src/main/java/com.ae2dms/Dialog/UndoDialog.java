package com.ae2dms.Dialog;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <p> The Class UndoDialog is to generate the Undo warning dialog that prompts warning message.
 * Defines a constructor that generate a warning dialog. When the step is the first step, user cannot perform warning.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/24-18:15
 * @since 1.0
 */
public class UndoDialog extends Dialog {
    /**
     * UndoDialog constructor.
     * <p> Generate a new undo dialog, set the size and text content, pop by stage.
     *
     * @param stage The primary stage in Main.
     * @author Yixin SHEN
     * @date   2020/11/29-20:44
     */
    public UndoDialog(Stage stage) {
        String dialogTitle = "Undo Warning";
        String dialogMessage = "Undo failed, you are in the first step!\n";

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.setResizable(false);
        dialog.setTitle(dialogTitle);

        Text text1 = new Text(dialogMessage);
        text1.setTextAlignment(TextAlignment.CENTER);
        text1.setFont(javafx.scene.text.Font.font(14));

        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);
        dialogVbox.setBackground(Background.EMPTY);
        dialogVbox.getChildren().add(text1);

        Scene dialogScene = new Scene(dialogVbox, 350, 150);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
