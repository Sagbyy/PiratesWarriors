package com.pirateswarriors.model.ennemies.PackEnnemis;


import com.pirateswarriors.Ennemis;
import com.pirateswarriors.Environnement;
import javafx.scene.image.Image;

public class BarqueCanon extends Ennemis {
    public BarqueCanon(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
        super(vitesse, env, pts_vie, pts_score, pts_pièces, pts_attaque, image);
    }
//    public BarqueCanon(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
//        super(x, y, 5, env, 150, 30, 20, 50, image);
//    }

    public void tire(){
        //Si la barque se trouve à ... pixels de distance du trésor, elle s'arrète et lui tire dessus
    }
}
