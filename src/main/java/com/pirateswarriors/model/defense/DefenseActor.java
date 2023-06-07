package com.pirateswarriors.model.defense;

import com.pirateswarriors.model.ennemies.Ennemis;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class DefenseActor {

    private IntegerProperty pv;
    private int prix;
    private DoubleProperty positionX;
    private DoubleProperty positionY;
    private ImageView image;
    private Pane pane;
    private Label labelPv;
    private int degat;
    private MediaPlayer shootSound;
    private ImageView bullet;

    public DefenseActor(int pv, int prix, int degats, ImageView image, Pane pane) {
        this.pane = pane;
        this.pv = new SimpleIntegerProperty(pv);
        this.prix = prix;
        this.positionX = new SimpleDoubleProperty(0);
        this.positionY = new SimpleDoubleProperty(0);
        this.image = image;
        this.degat = degats;
        this.labelPv = new Label();
        this.bullet = new ImageView(new Image(getClass().getResource("/com/pirateswarriors/images/defense/cannonBall.png").toString()));
        this.shootSound = new MediaPlayer(new Media(getClass().getResource("/com/pirateswarriors/sounds/shoot/ShootShip.mp3").toString()));
        labelPv.setText("Vie : " + this.getPv());
        // Bind des positions de l'acteur avec l'image
        this.image.xProperty().bind(this.positionXProperty());
        this.image.yProperty().bind(this.positionYProperty());
        this.pane.getChildren().addAll(this.image, this.labelPv);
    }

    // Getter & Setter

    public Label labelProperty() {
        return this.labelPv;
    }

    public ImageView getImageProperty() {
        return this.image;
    }

    public IntegerProperty getPvProperty() {
        return this.pv;
    }

    public int getPv() {
        return this.pv.getValue();
    }

    public DoubleProperty positionXProperty() {
        return this.positionX;
    }

    public double getPositionX() {
        return this.positionX.getValue();
    }

    public void setPositionX(double newPos) {
        this.positionX.setValue(newPos);
    }

    public DoubleProperty positionYProperty() {
        return this.positionY;
    }

    public double getPositionY() {
        return this.positionY.getValue();
    }

    public void setPositionY(double newPos) {
        this.positionY.setValue(newPos);
    }

    // Methods

    public void rotateImage(double posX, double posY) {
        double angle = Math.toDegrees(Math.atan2(this.image.getY() - posY, this.image.getX() - posX));
        this.image.setRotate(angle);
    }

    public void attaque(Ennemis ennemi) {

        // Sound shoot
        this.shootSound.stop();
        this.shootSound.play();

        ennemi.enleverPv(this.degat);
        System.out.println(ennemi.getPts_vie());
        System.out.println("Methode ");

    }
}
