package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.view.EnnemiVue;
import javafx.scene.image.Image;

public class EmbarcationFortune extends Ennemis {


    //Sous class d'Ennemis, EmbarcationFortune
    public EmbarcationFortune(Environnement env) {
        super(2, env, 1500, 50, 50, 10, 2);// Super de toutes les données d'Ennemis
                                                                                          // avec ses points de vie, son image, etc...
        setPositionY(getPositionY()-64); // Calibrage par rapport au chemin sur la map
        setPositionX(getPositionX()-64); // pour la position X et Y
    }

}
