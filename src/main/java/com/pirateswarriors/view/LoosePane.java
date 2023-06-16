package com.pirateswarriors.view;

import com.pirateswarriors.controller.ControllerViewAcceuil;
import com.pirateswarriors.controller.ControllerViewChoixMap;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.util.Stack;

public class LoosePane {
    private StackPane loosePane;
    private ControllerViewAcceuil controllerViewAcceuil;
    private Button quitButton;
    private Button restart;

    public LoosePane() {
        this.loosePane = new StackPane();
        this.loosePane.setPrefHeight(1080);
        this.loosePane.setPrefWidth(1920);
        this.loosePane.getStyleClass().add("loosePane");

        this.quitButton = new Button("Quitter");
        this.quitButton.getStyleClass().add("button");
        this.loosePane.getChildren().add(this.quitButton);
        this.restart = new Button("restart");
        this.restart.getStyleClass().add("button");
        this.loosePane.getChildren().add(this.restart);

        this.controllerViewAcceuil = new ControllerViewAcceuil();

        this.quitButton.setOnAction(e -> {
            Platform.exit();
        });

        this.restart.setOnAction(e -> {
            controllerViewAcceuil.afficherView2(e);
        });

    }

    public StackPane getLoosePane() {
        return this.loosePane;
    }
}
