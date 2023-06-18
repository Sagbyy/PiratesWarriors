package fr.montreuil.iut.pirateswarriors.model.Ennemis.PackEnnemis;

import fr.montreuil.iut.pirateswarriors.model.Ennemis.Ennemis;
import fr.montreuil.iut.pirateswarriors.model.Environnement;

public class PirateFusil extends Ennemis {


    //Sous class d'Ennemis, PirateFusil
    public PirateFusil(Environnement env) {
        super(2,env,1500,7,10, 10);// Super de toutes les données d'Ennemis
                                                                                    // avec ses points de vie, sa vitesse, etc...
    }


}
