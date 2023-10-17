package com.ae2dms.Controllers;

import com.ae2dms.Main.Main;
import com.ae2dms.Manager.FileHandler;
import com.ae2dms.Music.ClickSound;
import com.ae2dms.Music.ConfirmSound;
import com.ae2dms.Music.ErrorSound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;

/**
 * <p> The Class EraseController is the controller class of erase.fxml.
 * Initialize the text properties of Buttons, implements the FileHandler interface that can erase the corresponding archive file.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/18-10:46
 * @since 1.0
 */
public class EraseController implements FileHandler {
    /**
     * Defines the sign which archive should be erase.
     */
    private int eraseNumber;
    /**
     * fxml element, the first EraseButton.
     */
    @FXML
    Button But1;

    /**
     * fxml element, the second EraseButton.
     */
    @FXML
    Button But2;

    /**
     * fxml element, the third EraseButton.
     */
    @FXML
    Button But3;

    /**
     * fxml element, the Return Button.
     */
    public Button Return;
    /**
     * Initialize the erase scene element.
     * <p> initialize the erase slot scene, set the Buts text as their corresponding mapSetNames.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/22-13:56
     */
    public void initialize() throws IOException {
        But1.setText(FileHandler.mapSetName(1));
        But2.setText(FileHandler.mapSetName(2));
        But3.setText(FileHandler.mapSetName(3));
    }

    /**
     * Return to the slot scene.
     * <p> Return to slot scene and play the interface click sound
     *
     * @param actionEvent mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/22-14:25
     */
    public void ReturnSlot(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/slot");
    }

    /**
     * Prompt a confirmation dialog, if choose yes, erase the slot1.
     * <p> Prompt a confirmation dialog and play the confirm sound. if the slot is empty, prompt a warning dialog.
     * if the slot is not empty, if choose yes, erase the slot1; if choose no, do nothing.
     *
     * @param actionEvent mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/22-15:17
     */
    public void Erase1(ActionEvent actionEvent) throws IOException {
        eraseNumber = 1;
        String gameName = But1.textProperty().getValue();
        if (gameName.equals("New Game!")) {
            ErrorSound.getInstance().playMusic();
            newWarning();
        } else {
            ConfirmSound.getInstance().playMusic();
            erase(eraseNumber);
        }
    }

    /**
     * Prompt a confirmation dialog, if choose yes, erase the slot2.
     * <p> Prompt a confirmation dialog and play the confirm sound. if the slot is empty, prompt a warning dialog.
     * if the slot is not empty, if choose yes, erase the slot2; if choose no, do nothing.
     *
     * @param actionEvent mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/22-15:17
     */
    public void Erase2(ActionEvent actionEvent) throws IOException {
        eraseNumber = 2;
        String gameName = But2.textProperty().getValue();
        if (gameName.equals("New Game!")) {
            ErrorSound.getInstance().playMusic();
            newWarning();
        } else {
            ConfirmSound.getInstance().playMusic();
            erase(eraseNumber);
        }
    }

    /**
     * Prompt a confirmation dialog, if choose yes, erase the slot3.
     * <p> Prompt a confirmation dialog and play the confirm sound. if the slot is empty, prompt a warning dialog.
     * if the slot is not empty, if choose yes, erase the slot3; if choose no, do nothing.
     *
     * @param actionEvent mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/22-15:17
     */
    public void Erase3(ActionEvent actionEvent) throws IOException {
        eraseNumber = 3;
        String gameName = But3.textProperty().getValue();
        if (gameName.equals("New Game!")) {
            ErrorSound.getInstance().playMusic();
            newWarning();
        } else {
            ConfirmSound.getInstance().playMusic();
            erase(eraseNumber);
        }
    }

    /**
     * Generate erase dialog, if choose yes, call the eraseArchive function and jump to slot scene.
     * <p> pop up a confirm dialog that let user to confirm his/her operation, if choose yes, call the eraseArchive function and jump to the slot scene.
     * If choose no, do nothing.
     *
     * @param index the archive index which chosen to erase
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/22-15:18
     */
    public void erase(int index) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("ERASE THE ARCHIVE");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent())
            if (result.get() == ButtonType.OK) {
                eraseArchive(eraseNumber);
                Main.setRoot("/FXML/slot");
            } else {
                System.out.println("erase cancel");
            }
    }

    /**
     * Generate empty lot warning dialog.
     * <p> if the slot he/she choose is empty, pop up a waning message.
     *
     * @author Yixin SHEN
     * @date 2020/11/22-15:19
     */
    public void newWarning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Look, a Warning Dialog");
        alert.setContentText("It's already a empty slot!");

        alert.showAndWait();
    }
}
