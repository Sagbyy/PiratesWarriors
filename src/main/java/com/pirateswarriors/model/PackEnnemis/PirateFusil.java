package com.pirateswarriors.model.PackEnnemis;

import com.pirateswarriors.Ennemis;
import com.pirateswarriors.Environnement;
import javafx.scene.image.Image;

public class PirateFusil extends Ennemis {

    public PirateFusil(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
        super(x, y, 10, env, 125, 15, 7, 20, image);
    }

}
