package com.pirateswarriors.model.defense;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

public class ControleurAjoutDefense implements EventHandler<MouseEvent> {

        private ImageView imageShip;
        private Label labelPv;

        public ControleurAjoutDefense(ImageView imageShip, Label labelPv) {
            this.imageShip = imageShip;
            this.labelPv = labelPv;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            imageShip.xProperty().unbind();
            imageShip.yProperty().unbind();

            labelPv.setLayoutX(imageShip.getX() + 10);
            labelPv.setLayoutY(imageShip.getY() - 25);

            System.out.println("Bateau ajouter à : " + "\nx : " + imageShip.getX() + " | y : " + imageShip.getY());
        }
}
