package fr.montreuil.iut.pirateswarriors.view.map;

import javafx.scene.layout.TilePane;

public class Carte_1 extends Carte {
    public Carte_1(TilePane tilePane) {
        super(tilePane);
        super.genererMap("map1.csv");
    }
}