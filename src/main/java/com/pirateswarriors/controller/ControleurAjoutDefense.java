package com.pirateswarriors.controller;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.PorteMonnaie;
import com.pirateswarriors.model.defense.DefenseActor;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
            this.mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/com/pirateswarriors/sounds/error.mp3").toString()));
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
