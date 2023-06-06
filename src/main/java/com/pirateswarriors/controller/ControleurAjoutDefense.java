package com.pirateswarriors.controller;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.PorteMonnaie;
import com.pirateswarriors.model.defense.DefenseActor;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ControleurAjoutDefense implements EventHandler<MouseEvent> {

        private PorteMonnaie porteMonnaie;
        private Pane paneCentral;
        private DefenseActor defenseActor;
        Environnement env;

        public ControleurAjoutDefense(DefenseActor defenseActor, PorteMonnaie porteMonnaie, Environnement env) {
            this.defenseActor = defenseActor;
            this.porteMonnaie = porteMonnaie;
            this.env = env;
        }
        
    // Lorsque qu'on clique sur la map on laisse la position au clique
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(!porteMonnaie.argentVide()){
                this.defenseActor.positionXProperty().unbind();
                this.defenseActor.positionYProperty().unbind();

                this.defenseActor.labelProperty().setLayoutX(this.defenseActor.getImageProperty().getX() + 10);
                this.defenseActor.labelProperty().setLayoutY(this.defenseActor.getImageProperty().getY() - 25);



                this.env.ajouterDefense(defenseActor);
                // retrait du cout de la defense

                porteMonnaie.ajoutMonnaie(-500);
            }
            else
                //nbPieces.;0
                System.out.printf("Vous n'avez pas assez d'argent !/n");

        }
}
