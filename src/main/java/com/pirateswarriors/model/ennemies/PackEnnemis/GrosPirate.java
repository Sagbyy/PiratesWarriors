package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.view.EnnemiVue;
import javafx.scene.image.Image;

public class GrosPirate extends Ennemis {
    public GrosPirate(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image, EnnemiVue ennemiVue) {
        super(vitesse, env, pts_vie, pts_score, pts_pièces, pts_attaque, image, ennemiVue);
    }
//    public GrosPirate(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
//        super(x, y, 8, env, 150, 40, 40, 50, image);
//    }
}
