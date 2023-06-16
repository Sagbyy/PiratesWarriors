package com.pirateswarriors.model.defense.packDefense;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.defense.DefenseActor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TankDefense extends DefenseActor {
    private String pathSound;
    public TankDefense(int pv, int prix, int degats, ImageView image, Pane pane, Environnement env) {
        super(pv, prix, degats, 15, image, pane, "/com/pirateswarriors/sounds/shoot/ShootShip.mp3", true, 300, 5000, env);
    }
}
