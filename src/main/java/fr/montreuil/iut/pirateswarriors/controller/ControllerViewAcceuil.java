package fr.montreuil.iut.pirateswarriors.controller;

import fr.montreuil.iut.pirateswarriors.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class ControllerViewAcceuil {

    private Stage stage;
    private FXMLLoader fxmlLoader;

    public void setStage(Stage stage){
        this.stage = stage;
    }
    @FXML
    public void afficherView2(ActionEvent event) {
        try {
            fxmlLoader = new FXMLLoader(Main.class.getResource("viewChoixMap.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void sortieJeu(ActionEvent event){
        Platform.exit();
    }
}
