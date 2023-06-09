package com.pirateswarriors.controller;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.PorteMonnaie;
import com.pirateswarriors.model.Tresor;
import com.pirateswarriors.model.ennemies.ObservateurEnnemis;
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
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

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
    private Label nbVagues;
    @FXML
    private ImageView imgTresor;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.carte_1 = new Carte_1(tilePane);

        this.tresor = new Tresor(2000);
        this.tresorVue = new TresorVue(tresor);

        this.porteMonnaie = new PorteMonnaie();
        this.porteMonnaieVue = new PorteMonnaieVue(porteMonnaie);



        nbPieces.textProperty().bind(porteMonnaie.nbProperty().asString());
        labelVieTresor.setText("vie: " + String.valueOf(tresor.getPv()));

        this.jeu = new Environnement(paneCentral, porteMonnaie);
        nbVagues.textProperty().bind(jeu.getNbVaguesProperty().asString());
        // Mouse Property
        this.mouseY = new SimpleDoubleProperty(0);
        this.mouseX = new SimpleDoubleProperty(0);

        // ecoute de la liste des acteurs pour prendre en compte les morts et les vivants
        this.jeu.getEnnemisList().addListener(new ObservateurEnnemis(this.paneCentral));

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

                    for (int i = 0; i < jeu.getEnnemisList().size(); i++) {
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


                    jeu.untour();
                    temps++;

                    })
            );
            gameLoop.getKeyFrames().add(kf);

        //}


    }

    public boolean ennemiProche(Ennemis ennemis){
        double distanceX = Math.abs(ennemis.getPositionX() - imgTresor.getX());
        double distanceY = Math.abs(ennemis.getPositionY() - imgTresor.getY());

        // Calcul de la distance entre l'ennemi et le trésor
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        double maxDistance = 266;
        if (distance <= maxDistance) {
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
        ControleurAjoutDefense controleurAjoutDefense = new ControleurAjoutDefense(ajoutDefense.getDefense(), porteMonnaie, jeu, paneCentral);
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