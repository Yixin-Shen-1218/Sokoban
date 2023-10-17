package com.ae2dms.Manager;

import com.ae2dms.Controllers.SettingController;
import com.ae2dms.GameMap.GameObject;
import com.ae2dms.GameState.GameEngine;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * <p> The Class GraphicObject defines the map graphic.
 * It determines the graph in the map, map UI imgs are all in here.
 *
 * @author Yixin SHEN
 * @version 1.1
 * @date 2020/11/25-12:37
 * @since 1.0
 */
public class GraphicObject extends Rectangle {
    /**
     * The constructor of GraphicObject class.
     * <p> Determines the graph of the certain object in the parameter.
     *
     * @param obj The game object which to load the corresponding graph.
     * @author Yixin SHEN
     * @date 2020/11/30-22:44
     */
    public GraphicObject(GameObject obj) {
        Paint color;
        switch (obj) {
            case WALL:
                color = new ImagePattern(new Image("img/Game/Objects/block.png"));
                break;

            case CRATE:
                if (SettingController.Color == 0) {
                    color = new ImagePattern(new Image("img/Game/Objects/crate.png"));
                } else if (SettingController.Color == 1) {
                    color = new ImagePattern(new Image("img/Game/Objects/crate_green.png"));
                } else {
                    color = new ImagePattern(new Image("img/Game/Objects/crate_red.png"));
                }

                break;

            case DIAMOND:

                if (SettingController.Color == 0) {
                    color = new ImagePattern(new Image("img/Game/Objects/diamond.png"));
                } else if (SettingController.Color == 1) {
                    color = new ImagePattern(new Image("img/Game/Objects/diamond_green.png"));
                } else {
                    color = new ImagePattern(new Image("img/Game/Objects/diamond_red.png"));
                }

                if (GameEngine.isDebugActive()) {
                    FadeTransition ft = new FadeTransition(Duration.millis(1000), this);
                    ft.setFromValue(1.0);
                    ft.setToValue(0.2);
                    ft.setCycleCount(Timeline.INDEFINITE);
                    ft.setAutoReverse(true);
                    ft.play();
                }

                break;

            case KEEPER:
                if (GameEngine.moveDirection == 1) {
                    color = new ImagePattern(new Image("img/Game/Player/player_UP.png"));
                } else if (GameEngine.moveDirection == 2) {
                    color = new ImagePattern(new Image("img/Game/Player/player_RIGHT.png"));
                } else if (GameEngine.moveDirection == 3) {
                    color = new ImagePattern(new Image("img/Game/Player/player_DOWN.png"));
                } else {
                    color = new ImagePattern(new Image("img/Game/Player/player_LEFT.png"));
                }
                break;

            case FLOOR:
                color = new ImagePattern(new Image("img/Game/Objects/ground.png"));
                break;

            case CRATE_ON_DIAMOND:
                if (SettingController.Color == 0) {
                    color = new ImagePattern(new Image("img/Game/Objects/crate_on_diamond.png"));
                } else if (SettingController.Color == 1) {
                    color = new ImagePattern(new Image("img/Game/Objects/crate_on_diamond_green.png"));
                } else {
                    color = new ImagePattern(new Image("img/Game/Objects/crate_on_diamond_red.png"));
                }
                break;

            case KEEPER_ON_DIAMOND:
                if (GameEngine.moveDirection == 1) {
                    color = new ImagePattern(new Image("img/Game/Player/PlayerOnD_UP.png"));
                } else if (GameEngine.moveDirection == 2) {
                    color = new ImagePattern(new Image("img/Game/Player/PlayerOnD_RIGHT.png"));
                } else if (GameEngine.moveDirection == 3) {
                    color = new ImagePattern(new Image("img/Game/Player/PlayerOnD_DOWN.png"));
                } else {
                    color = new ImagePattern(new Image("img/Game/Player/PlayerOnD_LEFT.png"));
                }
                break;

            default:
                String message = "Error in Level constructor. Object not recognized.";
                GameEngine.logger.severe(message);
                throw new AssertionError(message);
        }

        this.setFill(color);
        this.setHeight(30);
        this.setWidth(30);

    }
}
