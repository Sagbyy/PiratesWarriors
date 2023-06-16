package com.pirateswarriors.model.defense.packDefense;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.defense.DefenseActor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BombDefense extends DefenseActor {
    private String pathSound;
    public BombDefense(int pv, int prix, int degats, ImageView image, Pane pane, Environnement env) {
        super(pv, prix, degats, pv, image, pane, "/com/pirateswarriors/sounds/shoot/bombSound.mp3", false, 80, 0, env);
    }
}
