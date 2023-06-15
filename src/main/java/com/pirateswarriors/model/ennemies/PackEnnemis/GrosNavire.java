package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.view.EnnemiVue;
import javafx.scene.image.Image;

public class GrosNavire extends Ennemis {


    //Sous class d'Ennemis, GrosNavire
    public GrosNavire(Environnement env) {
        super(1, env, 8000, 500, 500, 500, 6);// Super de toutes les données d'Ennemis
                                                                                             // avec ses points de vie, son image, etc...
        setPositionX(getPositionX()-64); // Calibrage par rapport au chemin sur la map

    }

}
