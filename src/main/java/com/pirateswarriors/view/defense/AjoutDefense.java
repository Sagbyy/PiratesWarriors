package com.pirateswarriors.view.defense;

import com.pirateswarriors.model.PorteMonnaie;
import com.pirateswarriors.model.defense.DefenseActor;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class AjoutDefense {
    private Pane paneCentral;
    private VBox boxDefense;
    private ImageView imageShip;
    private DefenseActor defense;
    private String buttonId;
    private Label labelPv;
    private PorteMonnaie porteMonnaie;

    public AjoutDefense(Pane paneCentral, String buttonId, PorteMonnaie porteMonnaie) {
        this.paneCentral = paneCentral;
        this.porteMonnaie = porteMonnaie;
        this.boxDefense = new VBox();
        this.imageShip = new ImageView();
        this.labelPv = new Label();
        this.buttonId = buttonId;
    }
    public void ajoutDefense() {
        switch (this.buttonId) {
            case "defense1" -> {
                // Récupère l'image de la défense
                imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (1).png"))));
                // Nouvelle instance de la défense
                this.defense = new DefenseActor(50, 15);
            }
            case "defense2" -> {
                imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (2).png"))));
                this.defense = new DefenseActor(50, 15);
            }
            case "defense3" -> {
                imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (3).png"))));
                this.defense = new DefenseActor(50, 15);
            }
            case "defense4" -> {
                imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (4).png"))));
                this.defense = new DefenseActor(50, 15);
            }
            case "defense5" -> {
                imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (5).png"))));
                this.defense = new DefenseActor(50, 15);
            }
            case "defense6" -> {
                imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (6).png"))));
                this.defense = new DefenseActor(50, 15);
            }
            default -> {
                this.imageShip = null;
                this.defense = null;
                System.out.println("Erreur : defense n'existe pas");
            }
        }

        labelPv.setText("Vie : " + defense.getPv());
    }

    public void bindImage(DoubleProperty mouseX, DoubleProperty mouseY) {
        if (!porteMonnaie.argentVide()) {
            // Bindings des positions de la défense avec celle de la souris
            imageShip.xProperty().bind(mouseX);
            imageShip.yProperty().bind(mouseY);

            // Ajout de la défense et du label dans la pane
            paneCentral.getChildren().add(labelPv);
            paneCentral.getChildren().add(imageShip);
        }
    }

    // Getter & Setter

    public ImageView getImageShip() {
        return this.imageShip;
    }

    public Label getLabelPv() {
        return this.labelPv;
    }
}
