package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.view.EnnemiVue;
import javafx.scene.image.Image;

public class EmbarcationFortune extends Ennemis {
    public EmbarcationFortune(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image, EnnemiVue ennemiVue) {
        super(vitesse, env, pts_vie, pts_score, pts_pièces, pts_attaque, image, ennemiVue);
    }
//    public EmbarcationFortune(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) {
//        super(x, y, 10, env, 150, 25, 20, 25, image);
//    }

    public void descend(){
        // Si l'embarcation atteint la plage, les deux pirates descendent
        // Si l'embarcation est détruite, deux pirateNages apparaissent
    }
}
