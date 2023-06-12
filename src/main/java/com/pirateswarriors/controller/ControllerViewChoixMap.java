package com.pirateswarriors.controller;

import com.pirateswarriors.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerViewChoixMap {
    private Stage stage;
    private FXMLLoader fxmlLoader;

    public void setStage(Stage stage){
        this.stage = stage;
    }



    @FXML
    private void afficherView3(ActionEvent event) {
        try {
            fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
