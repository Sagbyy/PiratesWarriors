package fr.montreuil.iut.pirateswarriors.view.map;

import javafx.scene.layout.TilePane;

public class Carte_2 extends Carte {
    public Carte_2(TilePane tilePane) {
        super(tilePane);
        super.genererMap("map2.csv");    }
}
