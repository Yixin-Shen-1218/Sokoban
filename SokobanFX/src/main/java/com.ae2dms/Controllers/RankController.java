package com.ae2dms.Controllers;

import com.ae2dms.Manager.RankList;
import com.ae2dms.Main.Main;
import com.ae2dms.Manager.PlayerInfo;
import com.ae2dms.Music.ClickSound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p> The Class RankController is the controller class of rank.fxml.
 * Initialize the rank scene, define a mouse event use to return to menu.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/20-14:03
 * @since 1.0
 */
public class RankController {
    /**
     * fxml element, top1 label.
     */
    @FXML
    public Label Label1;

    /**
     * fxml element, top2 label.
     */
    public Label Label2;

    /**
     * fxml element, top3 label.
     */
    public Label Label3;

    /**
     * fxml element, top4 label.
     */
    public Label Label4;

    /**
     * fxml element, top5 label.
     */
    public Label Label5;

    /**
     * fxml element, the Return to menu Button.
     */
    public Button Return;

    /**
     * Initialize the rank scene, show the top5 in the ranking.txt.
     * <p> initialize the the rank scene show the top5 in the ranking.txt, and set the mouse entered event to all the labels.
     *
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/23-19:29
     */
    public void initialize() throws IOException {
        // New a RankList object to get the top5 player info.
        RankList Rank = new RankList();
        ArrayList<PlayerInfo> RankTop5 = Rank.getRankTop5();
        // set the text property of label1.
        Label1.setText("Player: " + RankTop5.get(0).getNickName() + "    MoveCount: " + RankTop5.get(0).getMoveCount() + "\nLevel MoveCount: " + Arrays.toString(RankTop5.get(0).getLevelMoveCount()));
        Label1.setOnMouseEntered((MouseEvent e) ->
        {
            Label1.setScaleX(1.2);
            Label1.setScaleY(1.2);
        });
        Label1.setOnMouseExited((MouseEvent e) -> {
            Label1.setScaleX(1);
            Label1.setScaleY(1);
        });

        // set the text property of label2.
        Label2.setText("Player: " + RankTop5.get(1).getNickName() + "    MoveCount: " + RankTop5.get(1).getMoveCount() + "\nLevel MoveCount: " + Arrays.toString(RankTop5.get(1).getLevelMoveCount()));
        Label2.setOnMouseEntered((MouseEvent e) ->
        {
            Label2.setScaleX(1.2);
            Label2.setScaleY(1.2);
        });
        Label2.setOnMouseExited((MouseEvent e) -> {
            Label2.setScaleX(1);
            Label2.setScaleY(1);
        });

        // set the text property of label3.
        Label3.setText("Player: " + RankTop5.get(2).getNickName() + "    MoveCount: " + RankTop5.get(2).getMoveCount() + "\nLevel MoveCount: " + Arrays.toString(RankTop5.get(2).getLevelMoveCount()));
        Label3.setOnMouseEntered((MouseEvent e) ->
        {
            Label3.setScaleX(1.2);
            Label3.setScaleY(1.2);
        });
        Label3.setOnMouseExited((MouseEvent e) -> {
            Label3.setScaleX(1);
            Label3.setScaleY(1);
        });

        // set the text property of label4.
        Label4.setText("Player: " + RankTop5.get(3).getNickName() + "    MoveCount: " + RankTop5.get(3).getMoveCount() + "\nLevel MoveCount: " + Arrays.toString(RankTop5.get(3).getLevelMoveCount()));
        Label4.setOnMouseEntered((MouseEvent e) ->
        {
            Label4.setScaleX(1.2);
            Label4.setScaleY(1.2);
        });
        Label4.setOnMouseExited((MouseEvent e) -> {
            Label4.setScaleX(1);
            Label4.setScaleY(1);
        });

        // set the text property of label5.
        Label5.setText("Player: " + RankTop5.get(4).getNickName() + "    MoveCount: " + RankTop5.get(4).getMoveCount() + "\nLevel MoveCount: " + Arrays.toString(RankTop5.get(4).getLevelMoveCount()));
        Label5.setOnMouseEntered((MouseEvent e) ->
        {
            Label5.setScaleX(1.2);
            Label5.setScaleY(1.2);
        });
        Label5.setOnMouseExited((MouseEvent e) -> {
            Label5.setScaleX(1);
            Label5.setScaleY(1);
        });
    }

    /**
     * Return to the menu scene.
     * <p> Play the interface sound and return to the menu scene.
     *
     * @param actionEvent Mouse click.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date   2020/11/29-17:39
     */
    public void ReturnMenu(ActionEvent actionEvent) throws IOException {
        ClickSound.getInstance().playMusic();
        Main.setRoot("/FXML/menu");
    }
}
