package com.pirateswarriors.controller;

import com.pirateswarriors.Ennemis;
import com.pirateswarriors.Environnement;
import com.pirateswarriors.model.PorteMonnaie;
import com.pirateswarriors.model.Tresor;
import com.pirateswarriors.model.defense.DefenseActor;
import com.pirateswarriors.model.ennemies.PackEnnemis.BarqueCanon;
import com.pirateswarriors.model.ennemies.PackEnnemis.PirateFusil;
import com.pirateswarriors.view.PorteMonnaieVue;
import com.pirateswarriors.view.TresorVue;
import com.pirateswarriors.view.map.Carte;
import com.pirateswarriors.view.map.Carte_1;
import com.pirateswarriors.view.EnnemiVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TilePane tilePane;
    @FXML
    private Pane paneCentral;
    @FXML
    private Button buttonAddDefense;
    private DoubleProperty mouseX;
    private DoubleProperty mouseY;
    private Ennemis ennemis;
    private Ennemis ennemis2;
    private EnnemiVue personnageVue;
    private EnnemiVue personnageVue2;
    private Tresor tresor;
    private TresorVue tresorVue;
    private Carte carte_1;
    private Timeline gameLoop;
    private int temps;
    private PorteMonnaie porteMonnaie;
    private PorteMonnaieVue porteMonnaieVue;
    private int lcn;
    private Environnement jeu;



    @FXML
    private Label nbPieces;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        this.jeu = new Environnement();

        this.carte_1 = new Carte_1(tilePane);

        this.tresor = new Tresor(1000);
        this.tresorVue = new TresorVue(tresor);
        this.paneCentral.getChildren().add(tresorVue.getImgTresor());
        this.tresorVue.getImgTresor().setX(0);
        this.tresorVue.getImgTresor().setY(335);
        this.porteMonnaie = new PorteMonnaie();
        porteMonnaie.setNb(1000);
        this.porteMonnaieVue = new PorteMonnaieVue(porteMonnaie);
//        this.paneCentral.getChildren().add(porteMonnaieVue.getImgPorteMonnaie());
//        this.porteMonnaieVue.getImgPorteMonnaie().setX(1200);
//        this.porteMonnaieVue.getImgPorteMonnaie().setY(800);
        nbPieces.textProperty().bind(porteMonnaie.nbProperty().asString());


        // Mouse Property
        this.mouseY = new SimpleDoubleProperty(0);
        this.mouseX = new SimpleDoubleProperty(0);

        // Get mouse position
        paneCentral.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseX.setValue(mouseEvent.getX());
                mouseY.setValue(mouseEvent.getY());
            }
        });






    }

    private void initAnimation() {
        gameLoop = new Timeline();
        temps=0;

        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{



                    for (int i =0; i < jeu.getEnnemis().size(); i++){
                        Ennemis e = jeu.getEnnemis().get(i);
                        EnnemiVue v = new EnnemiVue (jeu.getEnnemis().get(i));
                        this.paneCentral.getChildren().add(v.getImageBateau());
                        v.getImageBateau().xProperty().bind(e.positionXProperty());
                        v.getImageBateau().yProperty().bind(e.positionYProperty());
                    }

                    jeu.untour();

                    //this.ennemis.avance();
                    //this.ennemis2.avance();

                    temps++;


                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

    @FXML
    public void ajoutDefense(ActionEvent event) {
        System.out.println("Bouton cliqué !");

        String buttonId = ((Button) event.getSource()).getId();

        // Nouvelle instance de la défense
        DefenseActor defense;
        ImageView imageShip;

        switch (buttonId) {
            case "defense1":
                // Récupère l'image de la défense
                imageShip = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (1).png"))));
                // Nouvelle instance de la défense
                defense = new DefenseActor(50, 15);
                break;
            case "defense2":
                imageShip = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (2).png"))));
                defense = new DefenseActor(50, 15);
                break;
            case "defense3":
                imageShip = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (3).png"))));
                defense = new DefenseActor(50, 15);
                break;
            case "defense4":
                imageShip = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (4).png"))));
                defense = new DefenseActor(50, 15);
                break;
            case "defense5":
                imageShip = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (5).png"))));
                defense = new DefenseActor(50, 15);
                break;
            case "defense6":
                imageShip = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/pirateswarriors/images/defense/ship (6).png"))));
                defense = new DefenseActor(50, 15);
                break;
            default:
                imageShip = null;
                defense = null;
                System.out.println("Erreur : defense n'existe pas");
                break;
        }

        Label labelPv = new Label("Vie : " + defense.getPv());



        // Bindings des positions de la défense avec celle de la souris
        imageShip.xProperty().bind(mouseX);
        imageShip.yProperty().bind(mouseY);

        // Ajout de la défense et du label dans la pane
        paneCentral.getChildren().add(labelPv);
        paneCentral.getChildren().add(imageShip);


        // Lorsque qu'on clique sur la map on laisse la position au clique
        paneCentral.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageShip.xProperty().unbind();
                imageShip.yProperty().unbind();

                labelPv.setLayoutX(imageShip.getX() + 10);
                labelPv.setLayoutY(imageShip.getY() - 25);
// retrait du cout de la defense
                if (!porteMonnaie.argentVide()){
                    porteMonnaie.ajoutMonnaie(-500);
                }
                else
                    //nbPieces.;
                    System.out.printf("Vous n'avez pas assez d'argent !/n");

                System.out.println("Bateau ajouter à : " + "\nx : " + imageShip.getX() + " | y : " + imageShip.getY());
            }
        });

        System.out.println("somme après retrait du prix de la defense: "+ porteMonnaie.getNb() );
    }

    @FXML
    public void lancerVagues(ActionEvent actionEvent) {

        if(lcn==0){
            initAnimation();

            lcn++;
        }
        gameLoop.play();
    }

    @FXML
    public void Pause(ActionEvent actionEvent) {
        if(lcn==1){
            gameLoop.stop();

        }
    }
}