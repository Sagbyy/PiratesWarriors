package com.pirateswarriors.view.defense;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.PorteMonnaie;
import com.pirateswarriors.model.defense.DefenseActor;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
    private PorteMonnaie porteMonnaie;
    private Environnement env;

    public AjoutDefense(Pane paneCentral, String buttonId, PorteMonnaie porteMonnai, Environnement env) {
        this.paneCentral = paneCentral;
        this.porteMonnaie = porteMonnai;
        this.boxDefense = new VBox();
        this.imageShip = new ImageView();
        this.buttonId = buttonId;
        this.env = env;
    }

    public void ajoutDefense() {
        if (!porteMonnaie.argentVide()) {
            switch (this.buttonId) {
                case "defense1" -> {
                    // Récupère l'image de la défense
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (1).png"))));
                    // Nouvelle instance de la défense
                    this.defense = new DefenseActor(50, 15, 10000, imageShip, paneCentral);
                }
                case "defense2" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (2).png"))));
                    this.defense = new DefenseActor(50, 15, 10000, imageShip, paneCentral);
                }
                case "defense3" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (3).png"))));
                    this.defense = new DefenseActor(50, 15, 10000, imageShip, paneCentral);
                }
                case "defense4" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (4).png"))));
                    this.defense = new DefenseActor(50, 15, 10000,imageShip, paneCentral);
                }
                case "defense5" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (5).png"))));
                    this.defense = new DefenseActor(50, 15, 10000, imageShip, paneCentral);
                }
                case "defense6" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (6).png"))));
                    this.defense = new DefenseActor(50, 15, 10000, imageShip, paneCentral);
                }
                default -> {
                    System.out.println("Erreur : defense n'existe pas");
                }
            }
        }
    }

    public void bindImage(DoubleProperty mouseX, DoubleProperty mouseY) {
        if (!porteMonnaie.argentVide()) {
            // Bindings des positions de la défense avec celle de la souris
            defense.positionXProperty().bind(mouseX);
            defense.positionYProperty().bind(mouseY);
        }
    }

    // Getter & Setter

    public DefenseActor getDefense() {
        return this.defense;
    }

}
