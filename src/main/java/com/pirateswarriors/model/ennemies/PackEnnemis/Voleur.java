package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.view.EnnemiVue;
import javafx.scene.image.Image;

public class Voleur extends Ennemis {

    //Sous class d'Ennemis, Voleur
    public Voleur(Environnement env) {
        super(4, env, 1000, 20, 20, 5, 5);// Super de toutes les données d'Ennemis
                                                                                         // avec ses points de vie, son image, etc...
    }

}
