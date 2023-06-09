package fr.montreuil.iut.pirateswarriors.controller;

import fr.montreuil.iut.pirateswarriors.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

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

    public static void setMap(int map) {
        ControllerViewChoixMap.map = map;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public static int getMap(){
        return map;
    }

    private int choixMap(){
        //attribut un numéro lorsque le bouton est selectionné
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
            stage.setFullScreen(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
