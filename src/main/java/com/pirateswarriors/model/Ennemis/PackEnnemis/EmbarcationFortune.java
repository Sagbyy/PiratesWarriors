package com.pirateswarriors.model.Ennemis.PackEnnemis;

import com.pirateswarriors.model.Ennemis.Ennemis;
import com.pirateswarriors.model.Environnement;

public class EmbarcationFortune extends Ennemis {


    //Sous class d'Ennemis, EmbarcationFortune
    public EmbarcationFortune(Environnement env) {
        super(2, env, 1500, 50, 50, 10);// Super de toutes les données d'Ennemis
                                                                                          // avec ses points de vie, sa vitesse, etc...
        setPositionY(getPositionY()-64); // Calibrage par rapport au chemin sur la map
        setPositionX(getPositionX()-64); // pour la position X et Y
    }

}
