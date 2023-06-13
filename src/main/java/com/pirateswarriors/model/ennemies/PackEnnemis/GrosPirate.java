package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.view.EnnemiVue;
import javafx.scene.image.Image;

public class GrosPirate extends Ennemis {

    //Sous class d'Ennemis, GrosPirate
    public GrosPirate(Environnement env) {
        super(1, env, 1500, 40, 40, 50, 4);// Super de toutes les données d'Ennemis
                                                                                          // avec ses points de vie, son image, etc...
    }

}
