package com.pirateswarriors.controller;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.PorteMonnaie;
import com.pirateswarriors.model.Tresor;
import com.pirateswarriors.view.EnnemiVue;
import com.pirateswarriors.model.ennemies.PackEnnemis.BarqueCanon;
import com.pirateswarriors.model.ennemies.PackEnnemis.PirateFusil;
import com.pirateswarriors.view.PorteMonnaieVue;
import com.pirateswarriors.view.TresorVue;
import com.pirateswarriors.view.defense.AjoutDefense;
import com.pirateswarriors.view.map.Carte;
import com.pirateswarriors.view.map.Carte_1;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import javax.swing.*;
import java.net.URL;
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
    private Label labelVieTresor;
    @FXML
    private Label nbPieces;
    @FXML
    private ImageView imgTresor;
    private int tre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



//        this.ennemis = new PirateFusil();
//        this.ennemis2 = new BarqueCanon();
//        this.personnageVue = new EnnemiVue(this.ennemis);
//        this.personnageVue2 = new EnnemiVue(this.ennemis2);
        this.carte_1 = new Carte_1(tilePane);

        this.tresor = new Tresor(2000);
        this.tresorVue = new TresorVue(tresor);
//        this.paneCentral.getChildren().add(tresorVue.getImgTresor());
//        this.tresorVue.getImgTresor().setX(0);
//        this.tresorVue.getImgTresor().setY(335);
        this.porteMonnaie = new PorteMonnaie();
        porteMonnaie.setNb(9000);
        this.porteMonnaieVue = new PorteMonnaieVue(porteMonnaie);

        nbPieces.textProperty().bind(porteMonnaie.nbProperty().asString());
        labelVieTresor.setText("vie: " + String.valueOf(tresor.getPv()));

        this.jeu = new Environnement(paneCentral);
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
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                       //this.personnage.setPositionX(this.personnage.getPositionX() + 10);
                        // this.personnageVue.getImageBateau().setX(this.personnage.getPositionX());

//                    if(temps==50){
//                        System.out.println("fini");
//                        gameLoop.stop();
//                    }
//
//                    else if (temps%5==0) {
//                        System.out.println("un tour");
//                        this.personnage.setPositionX(this.personnage.getPositionX() - 1);
//
//
//                        // this.personnageVue.getImageBateau().setX(this.personnage.getPositionX());
//
//                        //this.personnage.setPositionY(this.personnage.getPositionY());
//                        this.personnageVue.getImageBateau().setY(this.personnage.getPositionY());
//                        System.out.println(this.personnageVue.getImageBateau().getX());
//                        // ajout de monnaie a chaque tour
//                        porteMonnaie.ajoutMonnaie(500);
//                        System.out.println("nouvelle valeur du porte monnaie: " + porteMonnaie.getNb());
//                    }
                    for (int i = 0; i < jeu.getEnnemisList().size(); i++) {
                        Ennemis e = jeu.getEnnemisList().get(i);
                        EnnemiVue v = new EnnemiVue(jeu.getEnnemisList().get(i));
                        this.paneCentral.getChildren().add(v.getImageBateau());
                        v.getImageBateau().xProperty().bind(e.positionXProperty());
                        v.getImageBateau().yProperty().bind(e.positionYProperty());

                        if (tresor.estPasDetruit()){
                            // Infliger des dégâts au trésor
                            if (ennemiProche(jeu.getEnnemisList().get(i))){
                                if ((temps%20)==0){
                                    System.out.println("temps:" + temps);
                                    jeu.getEnnemisList().get(i).attaque(this.tresor);
                                    labelVieTresor.setText("vie: " + String.valueOf(this.tresor.getPv()));
                                }
                            }
                        }
                    }

//                    for (int i=0; i < jeu.getEnnemis().size(); i++){
//
//
//                    }

                        //remplacement de l'image trésor
//                        else{
//                            int i = paneCentral.getChildren().indexOf(imgTresor);
//                            paneCentral.getChildren().set(i, tresorVue.imgTresorDetruit());
//                        }
                    jeu.untour();
                    temps++;

                    })
            );
            gameLoop.getKeyFrames().add(kf);

        //}


    }

    public boolean ennemiProche(Ennemis ennemis){
        double distanceX = Math.abs(ennemis.getPositionX() - imgTresor.getX());
        System.out.println("distanceX: " + distanceX);
        double distanceY = Math.abs(ennemis.getPositionY() - imgTresor.getY());

        // Calcul de la distance entre l'ennemi et le trésor
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        System.out.println("distance: " + distance);
        double maxDistance = 266;
        if (distance <= maxDistance) {
            System.out.println("distance proche");
            return true;
        } else {
            return false;
        }
    }



    @FXML
    public void ajoutDefense(ActionEvent event) {
        System.out.println("Bouton cliqué !");

        String buttonId = ((Button) event.getSource()).getId();

        // Ajout de la vue
        AjoutDefense ajoutDefense = new AjoutDefense(paneCentral, buttonId, porteMonnaie, jeu);
        ajoutDefense.ajoutDefense();
        ajoutDefense.bindImage(mouseX, mouseY);

        // Lorsque qu'on clique sur la map on laisse la position au clique
        ControleurAjoutDefense controleurAjoutDefense = new ControleurAjoutDefense(ajoutDefense.getDefense(), porteMonnaie, jeu);
        paneCentral.addEventHandler(MouseEvent.MOUSE_CLICKED, controleurAjoutDefense);
    }

    @FXML
    public void lancerVagues(ActionEvent actionEvent) {

        if (lcn == 0) {
            initAnimation();

            lcn++;
        }
        gameLoop.play();
    }

    @FXML
    public void Pause(ActionEvent actionEvent) {
        if (lcn == 1) {
            gameLoop.stop();

        }
    }

}