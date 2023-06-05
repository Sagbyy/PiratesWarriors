package com.pirateswarriors.controller;

import com.pirateswarriors.model.PorteMonnaie;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ControleurAjoutDefense implements EventHandler<MouseEvent> {

        private ImageView imageShip;
        private Label labelPv;
        private PorteMonnaie porteMonnaie;
        private Pane paneCentral;

        public ControleurAjoutDefense(ImageView imageShip, Label labelPv, PorteMonnaie porteMonnaie, Pane paneCentral) {
            this.imageShip = imageShip;
            this.labelPv = labelPv;
            this.porteMonnaie = porteMonnaie;
            this.paneCentral = paneCentral;
        }

    // Lorsque qu'on clique sur la map on laisse la position au clique
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(!porteMonnaie.argentVide()){
                imageShip.xProperty().unbind();
                imageShip.yProperty().unbind();

                labelPv.setLayoutX(imageShip.getX() + 10);
                labelPv.setLayoutY(imageShip.getY() - 25);


                // retrait du cout de la defense

                porteMonnaie.ajoutMonnaie(-500);
            }
            else
                //nbPieces.;0
                System.out.printf("Vous n'avez pas assez d'argent !/n");

        }
}
