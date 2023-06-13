package com.pirateswarriors.controller;

import com.pirateswarriors.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class ControllerViewChoixMap {
    private Stage stage;
    private FXMLLoader fxmlLoader;
    @FXML
    private Button buttonMap1;
    @FXML
    private Button buttonMap2;
    @FXML
    private Button buttonMap3;
    private String nomMap;

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    private void afficherView3(ActionEvent event) {
        try {

            // Vérifier si l'événement provient d'un bouton
            if (event.getSource() instanceof Button) {
                Button clickedButton = (Button) event.getSource();

                // Comparer les références des boutons pour déterminer le bouton cliqué
                if (clickedButton == buttonMap1) {
                    nomMap = "map"+1+".csv";
                } else if (clickedButton == buttonMap2) {
                    nomMap = "map"+2+".csv";
                } else if (clickedButton == buttonMap3) {
                    nomMap = "map"+3+".csv";
                }
            }

            fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getNomMap(){
        return nomMap;
    }
}
