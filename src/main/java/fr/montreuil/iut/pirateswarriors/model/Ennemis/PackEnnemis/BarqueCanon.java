package fr.montreuil.iut.pirateswarriors.model.Ennemis.PackEnnemis;

import fr.montreuil.iut.pirateswarriors.model.Ennemis.Ennemis;
import fr.montreuil.iut.pirateswarriors.model.Environnement;

public class BarqueCanon extends Ennemis {


    //Sous class d'Ennemis, BarqueCanon
    public BarqueCanon( Environnement env) {
        super(1, env, 200, 7, 10, 10);// Super de toute les données d'Ennemis
                                                                                       // avec ses points de vie, sa vitesse, etc...
        setPositionY(getPositionY()-64); // Calibrage par rapport au chemin sur la map
        setPositionX(getPositionX()-64); // pour la position X et Y
    }

}
