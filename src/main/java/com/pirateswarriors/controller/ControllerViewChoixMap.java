package com.pirateswarriors.controller;

import com.pirateswarriors.Main;
import com.pirateswarriors.view.map.Carte;
import com.pirateswarriors.view.map.Carte_1;
import com.pirateswarriors.view.map.Carte_2;
import com.pirateswarriors.view.map.Carte_3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class ControllerViewChoixMap {
    private Stage stage;
    private FXMLLoader fxmlLoader;
    @FXML
    private RadioButton buttonMap1;
    @FXML
    private RadioButton buttonMap2;
    @FXML
    private RadioButton buttonMap3;
    private static int map;

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public static int getMap(){
        return map;
    }

    private int choixMap(){
        int map = 0;
        if (buttonMap1.isSelected()){
            map = 1;
        }
        else if (buttonMap2.isSelected()){
            map = 2;
        }
        else if (buttonMap3.isSelected()){
            map = 3;
        }
        return map;
    }
    @FXML
    private void jouer(ActionEvent event){
        try {
            this.map = choixMap();
            fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
