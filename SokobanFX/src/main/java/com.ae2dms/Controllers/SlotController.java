package com.ae2dms.Controllers;

import com.ae2dms.Main.Main;
import com.ae2dms.Manager.FileHandler;
import com.ae2dms.Music.ClickSound;
import com.ae2dms.Music.StartSound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.Optional;

/**
 * <p> The Class SlotController is the controller class of slot.fxml.
 * Initialize the slot scene, define some mouse events and set the text property of buttons.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/18-9:48
 * @since 1.0
 */
public class SlotController implements FileHandler {
    /**
     * Defines which archive should be load.
     */
    public static int archive;
    /**
     * fxml element, Erase button to erase scene.
     */
    public Button Erase;
    /**
     * fxml element, return button to menu scene.
     */
    public Button Return;
    /**
     * fxml element, slotButton1.
     */
    @FXML
    Button But1;
    /**
     * fxml element, slotButton2.
     */
    @FXML
    Button But2;
    /**
     * fxml element, slotButton3.
     */
    @FXML
    Button But3;

    /**
     * Initialize the slot scene, set the Buttons' text.
     * <p> initialize the the slot scene, using FileHandler interface mapSetName method to set the button text property.
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
     * Initialize the Archive1.skb game.
     * <p> If gameName equal to "New Game!", call the starGame method and play the start interface sound.
     * else, use Archive1.skb to load the game map.
     *
     * @param actionEvent Mouse click.
     * @throws IOException throws IOException
     * @author Yixin SHEN
     * @date 2020/11/18-10:44
     */
    public void openSlot1(ActionEvent actionEvent) throws IOException {
        archive = 1;
        String gameName = But1.textProperty().getValue();
        if (gameName.equals("New Game!")) {
            StartSound.getInstance().playMusic();
            StarGame();
        } else {
            StartSound.getInstance().playMusic();
            Main.setRoot("/FXML/game");
        }
    }

    /**
     * Initialize the Archive2.skb game.
     * <p> If gameName equal to "New Game!", call the starGame method and play the start interface sound.
     * else, use Archive2.skb to load the game map.
     *
     * @param actionEvent Mouse click.
     * @throws IOException throws IOException
     * @author Yixin SHEN
     * @date 2020/11/18-10:44
     */
    public void openSlot2(ActionEvent actionEvent) throws IOException {
        archive = 2;
        String gameName = But2.textProperty().getValue();
        if (gameName.equals("New Game!")) {
            StartSound.getInstance().playMusic();
            StarGame();
        } else {
            StartSound.getInstance().playMusic();
            Main.setRoot("/FXML/game");
        }
    }

    /**
     * Initialize the Archive3.skb game.
     * <p> If gameName equal to "New Game!", call the starGame method and play the start interface sound.
     * else, use Archive3.skb to load the game map.
     *
     * @param actionEvent Mouse click.
     * @throws IOException throws IOException
     * @author Yixin SHEN
     * @date 2020/11/18-10:44
     */
    public void openSlot3(ActionEvent actionEvent) throws IOException {
        archive = 3;
        String gameName = But3.textProperty().getValue();
        if (gameName.equals("New Game!")) {
            StartSound.getInstance().playMusic();
            StarGame();
        } else {
            StartSound.getInstance().playMusic();
            Main.setRoot("/FXML/game");
        }
    }

    /**
     * Mouse event method, click the button set the scene to erase scene.
     * <p> Jump to the erase slot scene and play the interface sound.
     *
     * @param actionEvent Mouse click.
     * @throws IOException throws IOException
     * @author Yixin SHEN
     * @date 2020/11/18-10:45
     */
    public void eraseSlot(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/erase");
    }

    /**
     * Mouse event method, click the button set the scene to menu scene.
     * <p> Jump to the erase menu scene and play the interface sound.
     *
     * @param actionEvent Mouse click.
     * @throws IOException throws IOException
     * @author Yixin SHEN
     * @date 2020/11/18-10:49
     */
    public void returnToMenu(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/menu");
    }

    /**
     * Prompt a input dialog and set the scene to game scene.
     * <p> Prompt a input dialog that allows user to input Nickname for game and initialize the game.
     * If user cancel the dialog, jump to the slot scene.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/29-18:18
     */
    public void StarGame() throws IOException {
        TextInputDialog dialog = new TextInputDialog("Mario");
        dialog.setTitle("Create a new game");
        dialog.setHeaderText("SOKOBAN game!");
        dialog.setContentText("Please enter your Nickname:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Your name: " + result.get());
            FileHandler.changeMapName(result.get());
            Main.setRoot("/FXML/game");
        } else {
            Main.setRoot("/FXML/slot");
        }
    }
}
