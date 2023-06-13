package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

public class BarqueCanon extends Ennemis {


    //Sous class d'Ennemis, BarqueCanon
    public BarqueCanon( Environnement env) {
        super(1, env, 200, 7, 10, 10,3);// Super de toute les données d'Ennemis
                                                                                       // avec ses points de vie, son image, etc...
    }

}
