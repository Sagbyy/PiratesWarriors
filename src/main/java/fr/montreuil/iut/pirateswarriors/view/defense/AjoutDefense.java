package fr.montreuil.iut.pirateswarriors.view.defense;

import fr.montreuil.iut.pirateswarriors.model.Environnement;
import fr.montreuil.iut.pirateswarriors.model.PorteMonnaie;
import fr.montreuil.iut.pirateswarriors.model.defense.DefenseActor;
import fr.montreuil.iut.pirateswarriors.model.defense.packDefense.*;
import fr.montreuil.iut.pirateswarriors.model.defense.packDefense.*;
import javafx.beans.property.DoubleProperty;
import javafx.scene.effect.ColorAdjust;
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
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fr/montreuil/iut/pirateswarriors/images/defense/manBlue_gun.png"))));
                    // Nouvelle instance de la défense
                    this.defense = new ManGunDefense(100, 500, 300, imageShip, paneCentral, env);
                }
                case "defense2" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fr/montreuil/iut/pirateswarriors/images/defense/tank_blue.png"))));
                    this.defense = new TankDefense(150, 500, 800, imageShip, paneCentral, env);
                }
                case "defense3" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fr/montreuil/iut/pirateswarriors/images/defense/ship (3).png"))));
                    this.defense = new ShipDefense(200, 500, 900, imageShip, paneCentral, env);
                }
                case "defense4" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fr/montreuil/iut/pirateswarriors/images/defense/cannon.png"))));
                    this.defense = new CannonDefense(100, 500, 500,imageShip, paneCentral, env);
                }
                case "defense5" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fr/montreuil/iut/pirateswarriors/images/defense/soldierKnife.png"))));
                    this.defense = new SoldierKnifeDefense(50, 500, 10000, imageShip, paneCentral, env);
                }
                case "defense6" -> {
                    imageShip.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/fr/montreuil/iut/pirateswarriors/images/defense/bomb.png"))));
                    this.defense = new BombDefense(50, 500, 10000, imageShip, paneCentral, env);
                }
                default -> {
                    System.out.println("Erreur : defense n'existe pas");
                }
            }
            this.porteMonnaie.enleverMonnaie(this.defense.getPrix());

            this.defense.positionYProperty().addListener((obs, old, nouv) -> {
                if(!env.getCarte().isRedZone(this.defense.getPositionX(), this.defense.getPositionY())) {
                    ColorAdjust filter = new ColorAdjust();
                    filter.setSaturation(-1);
                    this.defense.getImageProperty().setEffect(filter);
                }
                else {
                    ColorAdjust filter = new ColorAdjust();
                    filter.setHue(0);
                    this.defense.getImageProperty().setEffect(filter);
                }
            });

        }
    }

    public void bindImage(DoubleProperty mouseX, DoubleProperty mouseY) {
        if (porteMonnaie.getNb() >= this.defense.getPrix()) {
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
