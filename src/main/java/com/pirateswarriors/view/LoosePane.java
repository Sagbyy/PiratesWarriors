package com.pirateswarriors.view;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.util.Stack;

public class LoosePane {
    private StackPane loosePane;
    private Button quitButton;

    public LoosePane() {
        this.loosePane = new StackPane();
        this.loosePane.setPrefHeight(1080);
        this.loosePane.setPrefWidth(1920);
        this.loosePane.getStyleClass().add("loosePane");

        this.quitButton = new Button("Quitter");
        this.quitButton.getStyleClass().add("button");

        this.loosePane.getChildren().add(this.quitButton);

        this.quitButton.setOnAction(e -> {
            Platform.exit();
            System.out.println("click");
        });
    }

    public StackPane getLoosePane() {
        return this.loosePane;
    }
}
