package com.pirateswarriors.model.defense;

import com.pirateswarriors.model.ennemies.Ennemis;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
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
    private long lastExecutionTime;


    public DefenseActor(int pv, int prix, int degats, ImageView image, Pane pane) {
        this.lastExecutionTime = 0L;
        this.pane = pane;
        this.pv = new SimpleIntegerProperty(pv);
        this.prix = prix;
        this.image = image;
        this.positionX = new SimpleDoubleProperty(0);
        this.positionY = new SimpleDoubleProperty(0);
        this.degat = degats;
        this.labelPv = new Label();
        this.bullet = new ImageView(new Image(getClass().getResource("/com/pirateswarriors/images/defense/cannonBall.png").toString()));
        this.shootSound = new MediaPlayer(new Media(getClass().getResource("/com/pirateswarriors/sounds/shoot/ShootShip.mp3").toString()));
        labelPv.setText("Vie : " + this.getPv());
        // Bind des positions de l'acteur avec l'image
        this.image.xProperty().bind(Bindings.subtract(positionXProperty(), this.image.getBoundsInLocal().getWidth() / 2));
        this.image.yProperty().bind(Bindings.subtract(positionYProperty(), this.image.getBoundsInLocal().getHeight() / 2));
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
        return this.positionXProperty().getValue();
    }

    public void setPositionX(double newPos) {
        this.positionX.setValue(newPos);
    }

    public DoubleProperty positionYProperty() {
        return this.positionY;
    }

    public double getPositionY() {
        return this.positionYProperty().getValue();
    }

    public void setPositionY(double newPos) {
        this.positionY.setValue(newPos);
    }

    // Methods

    public double getMiddlePostionX() {
        return this.getImageProperty().getBoundsInLocal().getMinX() + this.getImageProperty().getBoundsInLocal().getWidth() / 2;
    }

    public double getMiddlePostionY() {
        return this.getImageProperty().getBoundsInLocal().getMinY() + this.getImageProperty().getBoundsInLocal().getHeight() / 2;
    }

    public void rotateImage(double posX, double posY) {
        double angle = Math.toDegrees(Math.atan2(this.image.getY() - posY, this.image.getX() - posX));
        this.image.setRotate(angle - 90);
    }

    public void attaque(Ennemis ennemi) {

        rotateImage(ennemi.getPositionX(), ennemi.getPositionY());

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastExecutionTime >= 3500) { // Vérifier si deux secondes se sont écoulées
            // Création de l'animation de déplacement de la balle
            pane.getChildren().add(bullet);
            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), this.bullet);
            transition.setDuration(Duration.seconds(0.5));
            transition.setFromX(this.positionXProperty().getValue());
            transition.setFromY(this.positionYProperty().getValue());
            // Vers le centre de l'image
            transition.setToX(ennemi.getMiddlePostionX());
            transition.setToY(ennemi.getMiddlePostionY());

            // Configuration de l'animation
            transition.setOnFinished(event -> {
                pane.getChildren().remove(bullet);

                pane.getChildren().remove(pane.lookup("#" + ennemi.getId()));
            });

            // Lancement de l'animation
            transition.play();


            // Sound shoot
            this.shootSound.stop();
            this.shootSound.play();

            ennemi.enleverPv(this.degat);

            lastExecutionTime = currentTime; // Mettre à jour le dernier instant d'exécution
        }
    }
}
