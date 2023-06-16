package com.pirateswarriors.model.Ennemis.PackEnnemis;

import com.pirateswarriors.model.Ennemis.Ennemis;
import com.pirateswarriors.model.Environnement;

public class PirateFusil extends Ennemis {


    //Sous class d'Ennemis, PirateFusil
    public PirateFusil(Environnement env) {
        super(2,env,1500,7,10, 10);// Super de toutes les données d'Ennemis
                                                                                    // avec ses points de vie, sa vitesse, etc...
    }


}
