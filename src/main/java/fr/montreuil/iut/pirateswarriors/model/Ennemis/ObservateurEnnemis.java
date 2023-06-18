package fr.montreuil.iut.pirateswarriors.model.Ennemis;

import fr.montreuil.iut.pirateswarriors.view.EnnemiVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ObservateurEnnemis implements ListChangeListener<Ennemis> {

    private Pane panneauJeu;

    /**
     * Constructeur de la class ObservateurEnnemis
     *  - Sert à gérer les nouveaux ennemis ainsi que ceux qui meurent
     */
    public ObservateurEnnemis(Pane panneauJeu) {
        super();
        this.panneauJeu = panneauJeu;
    }

    /**
     * Méthode ajoutEnnemis(Ennemis ennemi)
     *  - Prend en argument un Ennemis
     *  - Créer une vue à cet Ennemis
     *  - Bind la position de l'ennemi à celle de sa vue
     *  - Ajoute un listener "PositionListener" pour mettre à jour le sens
     *  dans lequel il va
     */
    private void ajoutEnnemis(Ennemis ennemi) {
        EnnemiVue v = new EnnemiVue(ennemi);
        this.panneauJeu.getChildren().addAll(v.getImageBateau(), v.getProgressHealth());
        v.getImageBateau().xProperty().bind(ennemi.positionXProperty());
        v.getImageBateau().yProperty().bind(ennemi.positionYProperty());
        ennemi.getDirProperty().addListener(new PositionListener(v));
    }

    /**
     * Méthode enleverEnnemis(Ennemis mort)
     *  - Prend en argument un Ennemis
     *  - Recherche la vue de cet ennemis grace à leur iD
     *  - Supprime la vue de l'ennemi du Pane
     */
    private void enleverEnnemis(Ennemis mort) {
        this.panneauJeu.getChildren().remove(this.panneauJeu.lookup("#"+mort.getId()));
    }

    /**
     * Méthode onChanged
     *  - Utilise les fonctions ci-dessus selon ce qui se passe dans le jeu
     */
    @Override
    public void onChanged(Change<? extends Ennemis> change) {
        while (change.next()) {
            // gestion des nouveaux Ennemis
            for (Ennemis nouveau : change.getAddedSubList()) {ajoutEnnemis(nouveau);}
            // gestion des Ennemis morts
            for (Ennemis nouveau : change.getRemoved()) {enleverEnnemis(nouveau);}
        }
    }
}
