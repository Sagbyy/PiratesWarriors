package com.pirateswarriors.controller;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.defense.DefenseActor;
import com.pirateswarriors.model.Ennemis.Ennemis;
import com.pirateswarriors.model.PorteMonnaie;
import com.pirateswarriors.model.Tresor;
import com.pirateswarriors.model.Ennemis.ObservateurEnnemis;
import com.pirateswarriors.view.EnnemiVue;
import com.pirateswarriors.view.LoosePane;
import com.pirateswarriors.view.PorteMonnaieVue;
import com.pirateswarriors.view.TresorVue;
import com.pirateswarriors.view.defense.AjoutDefense;
import com.pirateswarriors.view.map.Carte;
import com.pirateswarriors.view.map.Carte_1;
import com.pirateswarriors.view.map.Carte_2;
import com.pirateswarriors.view.map.Carte_3;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private TilePane tilePane;
    @FXML
    private Pane paneCentral;
    @FXML
    private ToggleButton showScopeDefenses;
    @FXML
    private Button buttonAddDefense;
    private DoubleProperty mouseX;
    private DoubleProperty mouseY;
    private Carte carte;
    private Timeline gameLoop;
    private int temps;
    private PorteMonnaie porteMonnaie;
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
    private ControleurAjoutDefense controleurAjoutDefense;
    private ArrayList<Circle> circleScopeList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.porteMonnaie = new PorteMonnaie();
        creationMap();
        nbPieces.textProperty().bind(porteMonnaie.nbProperty().asString());
        labelVieTresor.setText("vie: " + String.valueOf(jeu.getTresor().getPv()));

        //this.jeu = new Environnement(carte, paneCentral, porteMonnaie);
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
        this.circleScopeList = new ArrayList<>();

    }

    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        LoosePane loosePane = new LoosePane();
        BorderPane borderPane = this.borderPane; // Copie de référence pour utilisation dans le KeyFrame


        KeyFrame kf = new KeyFrame(
            // on définit le FPS (nbre de frame par seconde)
            Duration.seconds(0.030),
            // on définit ce qui se passe à chaque frame
            // c'est un eventHandler d'ou le lambda
            (ev ->{

                for (int i = 0; i < jeu.getEnnemisList().size(); i++) {
                    if (jeu.getTresor().estPasDetruit()){
                        // Infliger des dégâts au trésor
                        if (jeu.ennemiProche(jeu.getEnnemisList().get(i))){
                            if ((temps%20)==0){
                                jeu.getEnnemisList().get(i).attaque(jeu.getTresor());
                                labelVieTresor.setText("vie: " + String.valueOf(jeu.getTresor().getPv()));
                            }
                        }
                    }
                }

                if (jeu.getTresor().estPasDetruit()) {
                    jeu.untour();
                    temps++;
                } else {
                    borderPane.setTop(loosePane.getLoosePane());
                }

            })
        );
        gameLoop.getKeyFrames().add(kf);
    }

    public void creerMap(){
        int carte = ControllerViewChoixMap.getMap();
        if (carte == 1){
            this.carte = new Carte_1(tilePane);
        }
        else if (carte == 2){
            this.carte = new Carte_2(tilePane);
        }
        else if (carte == 3){
            this.carte = new Carte_3(tilePane);
        }
    }

    public void creationMap(){
        creerMap();
        this.jeu = new Environnement(this.carte, this.paneCentral, this.porteMonnaie);
    }

    @FXML
    public void ajoutDefense(ActionEvent event) {
        if (!porteMonnaie.argentVide()) {
            if (controleurAjoutDefense != null) {
                paneCentral.removeEventHandler(MouseEvent.MOUSE_CLICKED, controleurAjoutDefense);
            }

            String buttonId = ((Button) event.getSource()).getId();

            // Ajout de la vue
            AjoutDefense ajoutDefense = new AjoutDefense(paneCentral, buttonId, porteMonnaie, jeu);
            ajoutDefense.ajoutDefense();
            ajoutDefense.bindImage(mouseX, mouseY);

            // Lorsque qu'on clique sur la map on laisse la position au clique
            controleurAjoutDefense = new ControleurAjoutDefense(ajoutDefense.getDefense(), porteMonnaie, jeu, paneCentral);
            paneCentral.addEventHandler(MouseEvent.MOUSE_CLICKED, controleurAjoutDefense);
        }
    }

    @FXML
    public void showScopeDefenses() {
        if (showScopeDefenses.isSelected()) {
            // Le bouton est activé
            for (DefenseActor defense : this.jeu.getDefenseList()) {
                Circle portee = new Circle(defense.getMiddlePostionX(), defense.getMiddlePostionY(), defense.getPorteeDegats(), Color.rgb(0, 0, 0, 0.5));
                this.paneCentral.getChildren().add(2, portee);
                circleScopeList.add(portee);
            }
        } else {
            // Le bouton est désactivé
            for(Circle circle : this.circleScopeList) {
                this.paneCentral.getChildren().remove(circle);
            }
        }
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