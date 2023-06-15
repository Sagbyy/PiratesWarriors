package com.pirateswarriors.model.Ennemis.PackEnnemis;

import com.pirateswarriors.model.Ennemis.Ennemis;
import com.pirateswarriors.model.Environnement;

public class Voleur extends Ennemis {

    //Sous class d'Ennemis, Voleur
    public Voleur(Environnement env) {
        super(4, env, 1000, 20, 20, 5);// Super de toutes les données d'Ennemis
                                                                                         // avec ses points de vie, sa vitesse, etc...
    }

}
