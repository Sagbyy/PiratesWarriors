package com.pirateswarriors.model.ennemies;

import com.pirateswarriors.view.EnnemiVue;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ObservateurEnnemis implements ListChangeListener<Ennemis> {

    private Pane panneauJeu;
    public ObservateurEnnemis(Pane panneauJeu) {
        super();
        this.panneauJeu = panneauJeu;
    }

    private void ajoutEnnemis(Ennemis ennemi) {
        EnnemiVue v = new EnnemiVue(ennemi);
        this.panneauJeu.getChildren().add(v.getImageBateau());
        v.getImageBateau().xProperty().bind(ennemi.positionXProperty());
        v.getImageBateau().yProperty().bind(ennemi.positionYProperty());
        ennemi.getDirProperty().addListener(new PositionListener(v));
    }

    private void enleverEnnemis(Ennemis mort) {
        System.out.println(this.panneauJeu.lookup("#"+mort.getId()));
        this.panneauJeu.getChildren().remove(this.panneauJeu.lookup("#"+mort.getId()));
    }



    @Override
    public void onChanged(Change<? extends Ennemis> change) {
        while (change.next()) {
            // gestion des nouveaux n ́es
            for (Ennemis nouveau : change.getAddedSubList()) {
                ajoutEnnemis(nouveau);

            }
        }
    }
}
