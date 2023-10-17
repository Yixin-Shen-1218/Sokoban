package com.ae2dms.Dialog;

import com.ae2dms.GameState.GameEngine;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <p> The Class VicDialog is to generate the victory dialog that prompts victory message.
 * Defines a constructor that generate a victory dialog. When the game is completed, pop up the dialog.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/24-18:14
 * @since 1.0
 */
public class VicDialog extends Dialog {
    /**
     * VicDialog constructor.
     * <p> Generate a new Vic dialog, set the size and text content, pop by stage.
     *
     * @param stage The primary stage in Main.
     * @param gameEngine The gameEngine.
     * @author Yixin SHEN
     * @date   2020/11/29-20:44
     */
    public VicDialog(Stage stage, GameEngine gameEngine) {
        String dialogTitle = "Game Over!";
        String dialogMessage = "You completed " + gameEngine.mapSetName + " in " + gameEngine.MovesCount() + " moves!";
        MotionBlur mb = new MotionBlur(2, 3);

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.setResizable(false);
        dialog.setTitle(dialogTitle);

        Text text1 = new Text(dialogMessage);
        text1.setTextAlignment(TextAlignment.CENTER);
        text1.setFont(javafx.scene.text.Font.font(14));

        text1.setEffect(mb);

        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);
        dialogVbox.setBackground(Background.EMPTY);
        dialogVbox.getChildren().add(text1);

        Scene dialogScene = new Scene(dialogVbox, 350, 150);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
