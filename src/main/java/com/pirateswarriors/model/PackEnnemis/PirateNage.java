package com.pirateswarriors.model.PackEnnemis;

import com.pirateswarriors.Ennemis;
import com.pirateswarriors.Environnement;
import javafx.scene.image.Image;

public class PirateNage extends Ennemis {

    public PirateNage(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque) {
        super(x, y, 15, env, 100, 10,
                5, 15, new Image("Images/PirateNage.gif"));// Contructeur du Pirate à la nage avec ses données
    }

}
