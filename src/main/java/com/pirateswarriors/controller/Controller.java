package com.pirateswarriors.controller;

import com.pirateswarriors.view.Map;
import com.pirateswarriors.view.Map_1;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TilePane tilePane;

    private Map map_1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.map_1 = new Map_1(tilePane);
    }
}
