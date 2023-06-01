package com.pirateswarriors.model.defense;

import com.pirateswarriors.model.PorteMonnaie;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

public class ControleurAjoutDefense implements EventHandler<MouseEvent> {

        private ImageView imageShip;
        private Label labelPv;

        private PorteMonnaie porteMonnaie;

        public ControleurAjoutDefense(ImageView imageShip, Label labelPv, PorteMonnaie porteMonnaie) {
            this.imageShip = imageShip;
            this.labelPv = labelPv;
            this.porteMonnaie = porteMonnaie;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            imageShip.xProperty().unbind();
            imageShip.yProperty().unbind();

            labelPv.setLayoutX(imageShip.getX() + 10);
            labelPv.setLayoutY(imageShip.getY() - 25);

            // retrait du cout de la defense
            if (!this.porteMonnaie.argentVide()){
                this.porteMonnaie.ajoutMonnaie(-500);
            }
            else {
                //nbPieces.;
                System.out.printf("Vous n'avez pas assez d'argent !/n");
            }
            System.out.println("Bateau ajouter à : " + "\nx : " + imageShip.getX() + " | y : " + imageShip.getY());
        }
}
