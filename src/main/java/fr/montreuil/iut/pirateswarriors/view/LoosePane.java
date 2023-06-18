package fr.montreuil.iut.pirateswarriors.view;

import fr.montreuil.iut.pirateswarriors.controller.ControllerViewAcceuil;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class LoosePane {
    private StackPane loosePane;
    private ControllerViewAcceuil controllerViewAcceuil;
    private Button quitButton;
    private Button restart;
    private HBox hBox;
    private Insets marge;

    public LoosePane() {
        this.loosePane = new StackPane();
        this.loosePane.setPrefHeight(1080);
        this.loosePane.setPrefWidth(1920);
        this.loosePane.getStyleClass().add("loosePane");

        this.marge = new Insets(10);

        this.hBox = new HBox();
        this.hBox.setAlignment(Pos.CENTER);
        this.hBox.setSpacing(15);

        this.quitButton = new Button("Quitter");
        this.quitButton.getStyleClass().add("button");
        this.hBox.getChildren().add(this.quitButton);

        this.restart = new Button("Rejouer");
        this.restart.getStyleClass().add("button");
        this.hBox.getChildren().add(this.restart);

        this.loosePane.getChildren().add(this.hBox);

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
