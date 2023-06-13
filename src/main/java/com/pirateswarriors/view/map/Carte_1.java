package com.pirateswarriors.view.map;

import com.pirateswarriors.controller.ControllerViewChoixMap;
import javafx.scene.layout.TilePane;

public class Carte_1 extends Carte {
    private ControllerViewChoixMap controllerViewChoixMap;


    public Carte_1(TilePane tilePane) {
        super(tilePane, "newMap2.csv");
    }
}