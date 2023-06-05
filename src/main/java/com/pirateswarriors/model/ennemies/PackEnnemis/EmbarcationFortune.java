package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.Ennemis;
import com.pirateswarriors.Environnement;
import javafx.scene.image.Image;

public class EmbarcationFortune extends Ennemis {
    public EmbarcationFortune(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
        super(vitesse, env, pts_vie, pts_score, pts_pièces, pts_attaque, image);
    }
//    public EmbarcationFortune(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
//        super(x, y, 10, env, 150, 25, 20, 25, image);
//    }

    public void descend(){
        // Si l'embarcation atteint la plage, les deux pirates descendent
        // Si l'embarcation est détruite, deux pirateNages apparaissent
    }
}
