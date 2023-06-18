package fr.montreuil.iut.pirateswarriors.controller;

import fr.montreuil.iut.pirateswarriors.model.Environnement;
import fr.montreuil.iut.pirateswarriors.model.PorteMonnaie;
import fr.montreuil.iut.pirateswarriors.model.defense.DefenseActor;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ControleurAjoutDefense implements EventHandler<MouseEvent> {

        private PorteMonnaie porteMonnaie;
        private Pane paneCentral;
        private DefenseActor defenseActor;
        private MediaPlayer mediaPlayer;
        private Environnement env;

        public ControleurAjoutDefense(DefenseActor defenseActor, PorteMonnaie porteMonnaie, Environnement env, Pane paneCentral) {
            this.defenseActor = defenseActor;
            this.porteMonnaie = porteMonnaie;
            this.env = env;
            this.paneCentral = paneCentral;
            this.mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/fr/montreuil/iut/pirateswarriors/sounds/error.mp3").toString()));
        }

    // Lorsque qu'on clique sur la map on laisse la position au clique
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(env.getCarte().isRedZone(this.defenseActor.getPositionX(), this.defenseActor.getPositionY())){
                this.defenseActor.positionXProperty().unbind();
                this.defenseActor.positionYProperty().unbind();

                this.env.ajouterDefense(defenseActor);

                // Débloque la selection
                this.env.setLockDefense(false);
            } else {
                this.mediaPlayer.stop();
                this.mediaPlayer.play();
            }
        }
}
