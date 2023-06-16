package com.pirateswarriors.model.Ennemis.PackEnnemis;

import com.pirateswarriors.model.Ennemis.Ennemis;
import com.pirateswarriors.model.Environnement;

public class GrosNavire extends Ennemis {


    //Sous class d'Ennemis, GrosNavire
    public GrosNavire(Environnement env) {
        super(1, env, 8000, 500, 500, 500);// Super de toutes les données d'Ennemis
                                                                                             // avec ses points de vie, sa vitesse, etc...
        setPositionX(getPositionX()-64); // Calibrage par rapport au chemin sur la map

    }

}
