package fr.montreuil.iut.pirateswarriors.model.defense;

import fr.montreuil.iut.pirateswarriors.model.Environnement;
import fr.montreuil.iut.pirateswarriors.model.Ennemis.Ennemis;
import fr.montreuil.iut.pirateswarriors.view.EnnemiVue;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class DefenseActor {

    private IntegerProperty pv;
    private int prix;
    private DoubleProperty positionX;
    private DoubleProperty positionY;
    private ImageView image;
    private Pane pane;
    private int degat;
    private MediaPlayer shootSound;
    private ImageView bullet;
    private long lastExecutionTime;
    private long lastExecutionTimeForPv;
    private String pathSound;
    private Boolean ifHasBullet;
    private double porteeDegats;
    private int delayMS;
    private int degatPv;
    private Environnement env;
    private ProgressBar progressHealth;
    private int pvEntier;

    public DefenseActor(int pv, int prix, int degats, int degatPv, ImageView image, Pane pane, String pathSound, Boolean ifHasBullet, double porteeDegats, int delayMS, Environnement env) {
        this.env = env;
        this.pvEntier = pv;
        this.degatPv = degatPv;
        this.delayMS = delayMS;
        this.porteeDegats = porteeDegats;
        this.ifHasBullet = ifHasBullet;
        this.pathSound = pathSound;
        this.lastExecutionTime = 0L;
        this.lastExecutionTimeForPv = 0L;
        this.pane = pane;
        this.pv = new SimpleIntegerProperty(pv);
        this.prix = prix;
        this.image = image;
        this.positionX = new SimpleDoubleProperty(0);
        this.positionY = new SimpleDoubleProperty(0);
        this.degat = degats;
        // Progress Health
        this.progressHealth = new ProgressBar();
        this.progressHealth.setPrefWidth(50);
        this.getPvProperty().addListener((obs, old, nouv) -> {
            this.progressHealth.setProgress((double) this.getPv() / this.pvEntier);
        });

        this.positionXProperty().addListener((obs, old, nouv) -> {
            this.progressHealth.setLayoutX(this.getMiddlePostionX() - 20);
            this.progressHealth.setLayoutY(this.getMiddlePostionY() - 70);
        });

        this.positionYProperty().addListener((obs, old, nouv) -> {
            this.progressHealth.setLayoutX(this.getMiddlePostionX() - 20);
            this.progressHealth.setLayoutY(this.getMiddlePostionY() - 70);
        });

        this.bullet = new ImageView(new Image(getClass().getResource("/fr/montreuil/iut/pirateswarriors/images/defense/cannonBall.png").toString()));
        this.shootSound = new MediaPlayer(new Media(getClass().getResource(this.pathSound).toString()));
        // Bind des positions de l'acteur avec l'image
        this.image.xProperty().bind(Bindings.subtract(positionXProperty(), this.image.getBoundsInLocal().getWidth() / 2));
        this.image.yProperty().bind(Bindings.subtract(positionYProperty(), this.image.getBoundsInLocal().getHeight() / 2));
        this.getPvProperty().addListener((obs, old, nouv) -> {
            // Si il est mort
            if ((int) nouv <= 0) {
                this.pane.getChildren().removeAll(this.image, this.progressHealth, this.bullet);
            }
        });
        this.pane.getChildren().addAll(this.image, this.progressHealth);
    }

    // Getter & Setter

    public int getPrix() {
        return this.prix;
    }

    public boolean ifHasBullet() {
        return this.ifHasBullet;
    }

    public double getPorteeDegats() {
        return this.porteeDegats;
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

    public void enleverPv(int pv) {
        this.getPvProperty().setValue(this.getPv() - pv);
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

    public void eachTimeDoSomething() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastExecutionTimeForPv >= 5000) { // Vérifier si deux secondes se sont écoulées
            this.enleverPv(this.degatPv);
            lastExecutionTimeForPv = currentTime; // Mettre à jour le dernier instant d'exécution
        }
    }

    public void attaque(Ennemis ennemi, EnnemiVue ennemiVue) {
        rotateImage(ennemiVue.getMiddlePostionX(), ennemiVue.getMiddlePostionY());

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastExecutionTime >= this.delayMS) { // Vérifier si deux secondes se sont écoulées
            if (ifHasBullet) {
                // Création de l'animation de déplacement de la balle
                pane.getChildren().add(bullet);
                TranslateTransition transition = new TranslateTransition(Duration.seconds(1), this.bullet);
                transition.setDuration(Duration.seconds(0.5));
                transition.setFromX(this.positionXProperty().getValue());
                transition.setFromY(this.positionYProperty().getValue());
                // Vers le centre de l'image
                transition.setToX(ennemiVue.getMiddlePostionX());
                transition.setToY(ennemiVue.getMiddlePostionY());

                // Configuration de l'animation
                transition.setOnFinished(event -> {
                    this.enleverPv(this.degatPv);
                    ennemi.enleverPv(this.degat);

                    pane.getChildren().remove(bullet);

                    if (ennemi.estMort()) {
                        this.pane.getChildren().remove(this.pane.lookup("#"+ennemi.getId()));
                    }
                });

                // Lancement de l'animation
                transition.play();
            }

            // Sound shoot
            this.shootSound.stop();
            this.shootSound.play();

            if (!ifHasBullet) {
                this.enleverPv(this.degatPv);
                ennemi.enleverPv(this.degat);
            }

            lastExecutionTime = currentTime; // Mettre à jour le dernier instant d'exécution
        }
    }
}
