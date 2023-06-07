package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import javafx.scene.image.Image;

public class Voleur extends Ennemis {
    public Voleur(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
        super(vitesse, env, pts_vie, pts_score, pts_pièces, pts_attaque, image);
    }
//    public Voleur(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
//        super(x, y, 40, env, 50, 20, 20, 15, image);
//    }

}
