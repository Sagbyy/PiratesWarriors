package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.view.EnnemiVue;
import javafx.scene.image.Image;

public class GrosNavire extends Ennemis {
//    public GrosNavire(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
////        super(x, y, 2, env, 400, 100, 80, 150, image);
//    }

    public GrosNavire(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
        super(vitesse, env, pts_vie, pts_score, pts_pièces, pts_attaque, image);
    }

    public void tire(){
        //Si la barque se trouve à ... pixels de distance du trésor, elle s'arrète et lui tire dessus
    }
}
