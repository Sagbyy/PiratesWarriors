package com.pirateswarriors.model.PackEnnemis;

import com.pirateswarriors.Ennemis;
import com.pirateswarriors.Environnement;
import javafx.scene.image.Image;

public class GrosNavire extends Ennemis {
    public GrosNavire(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
        super(x, y, 2, env, 400, 100, 80, 150, image);
    }

    public void tire(){
        //Si la barque se trouve à ... pixels de distance du trésor, elle s'arrète et lui tire dessus
    }
}
