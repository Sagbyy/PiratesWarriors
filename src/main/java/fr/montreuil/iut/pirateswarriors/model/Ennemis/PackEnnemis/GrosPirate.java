package fr.montreuil.iut.pirateswarriors.model.Ennemis.PackEnnemis;

import fr.montreuil.iut.pirateswarriors.model.Ennemis.Ennemis;
import fr.montreuil.iut.pirateswarriors.model.Environnement;

public class GrosPirate extends Ennemis {

    //Sous class d'Ennemis, GrosPirate
    public GrosPirate(Environnement env) {
        super(1, env, 1500, 40, 40, 50);// Super de toutes les données d'Ennemis
                                                                                          // avec ses points de vie, sa vitesse, etc...
        setPositionY(getPositionY()-64); // Calibrage par rapport au chemin sur la map
        setPositionX(getPositionX()-64); // pour la position X et Y
    }

}
