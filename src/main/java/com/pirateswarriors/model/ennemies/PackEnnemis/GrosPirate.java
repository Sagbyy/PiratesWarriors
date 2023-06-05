package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.Ennemis;
import com.pirateswarriors.model.Environnement;
import javafx.scene.image.Image;

public class GrosPirate extends Ennemis {
    public GrosPirate(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
        super(vitesse, env, pts_vie, pts_score, pts_pièces, pts_attaque, image);
    }
//    public GrosPirate(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
//        super(x, y, 8, env, 150, 40, 40, 50, image);
//    }
}
