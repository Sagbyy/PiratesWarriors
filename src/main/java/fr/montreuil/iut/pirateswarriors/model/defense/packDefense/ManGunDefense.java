package fr.montreuil.iut.pirateswarriors.model.defense.packDefense;

import fr.montreuil.iut.pirateswarriors.model.Environnement;
import fr.montreuil.iut.pirateswarriors.model.defense.DefenseActor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ManGunDefense extends DefenseActor {
    private String pathSound;
    public ManGunDefense(int pv, int prix, int degats, ImageView image, Pane pane, Environnement env) {
        super(pv, prix, degats, 10, image, pane, "/fr/montreuil/iut/pirateswarriors/sounds/shoot/ShootShip.mp3", true, 150, 2500, env);
    }
}
