package com.pirateswarriors.controller;

import com.pirateswarriors.model.map.Map_1;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TilePane tilePane;

    private Map_1 map_1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tilePane = new TilePane();
        try {
            this.map_1 = new Map_1(tilePane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
