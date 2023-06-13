package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

public class PirateFusil extends Ennemis {


    //Sous class d'Ennemis, PirateFusil
    public PirateFusil(Environnement env) {
        super(2,env,1500,7,10, 10,1);// Super de toutes les données d'Ennemis
                                                                                    // avec ses points de vie, son image, etc...
    }


}
