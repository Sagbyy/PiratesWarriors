package com.pirateswarriors.controller;

import com.pirateswarriors.model.ennemies.Personnage;
import com.pirateswarriors.view.map.Carte;
import com.pirateswarriors.view.map.Carte_1;
import com.pirateswarriors.view.PersonnageVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TilePane tilePane;

    private Personnage personnage;
    private PersonnageVue personnageVue;
    @FXML
    private Label welcomeText;

    @FXML
    private Pane paneCentral;

    private Carte carte_1;

    private Timeline gameLoop;

    private int temps;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.personnage = new Personnage();
        this.personnageVue = new PersonnageVue(this.personnage);
        this.carte_1 = new Carte_1(tilePane);
        this.paneCentral.getChildren().add(personnageVue.getImageBateau());
        this.personnageVue.getImageBateau().xProperty().bind(this.personnage.positionXProperty());
        this.personnageVue.getImageBateau().yProperty().bind(this.personnage.positionYProperty());
        initAnimation();
        // demarre l'animation
        gameLoop.play();

    }

    public Pane getPaneCentral() {
        return this.paneCentral;
    }


    private void initAnimation() {
        gameLoop = new Timeline();
        temps=0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.007),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    if(temps==50){
                        System.out.println("fini");
                        gameLoop.stop();
                    }
                    else if (temps%5==0){
                        System.out.println("un tour");
                       this.personnage.setPositionX(this.personnage.getPositionX()-1);
                       // this.personnageVue.getImageBateau().setX(this.personnage.getPositionX());

                        this.personnage.setPositionY(this.personnage.getPositionY());
                        /*this.personnageVue.getImageBateau().setY(this.personnage.getPositionY());
                        System.out.println(this.personnageVue.getImageBateau().getX());*/

                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }




}