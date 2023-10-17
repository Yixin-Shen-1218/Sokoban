package com.ae2dms.Controllers;

import com.ae2dms.Main.Main;
import com.ae2dms.Music.ClickSound;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * <p> The Class HelpController is the controller class of help.fxml.
 * Initialize the help scene.
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/26-21:37
 * @since 1.0
 */
public class HelpController {
    /**
     * fxml element, the Return to menu button.
     */
    public Button Return;

    /**
     * Return to menu funtion.
     * <p> Click the button and return to menu scene.
     *
     * @param actionEvent Mouse click
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date   2020/11/29-16:50
     */
    public void ReturnMenu(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/menu");
    }
}
