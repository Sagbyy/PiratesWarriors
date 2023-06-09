package fr.montreuil.iut.pirateswarriors.model.defense.packDefense;

import fr.montreuil.iut.pirateswarriors.model.Environnement;
import fr.montreuil.iut.pirateswarriors.model.defense.DefenseActor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SoldierKnifeDefense extends DefenseActor {
    private String pathSound;
    public SoldierKnifeDefense(int pv, int prix, int degats, ImageView image, Pane pane, Environnement env) {
        super(pv, prix, degats, 10, image, pane, "/fr/montreuil/iut/pirateswarriors/sounds/shoot/knifeSound.mp3", false, 80, 1000, env);
    }
}
