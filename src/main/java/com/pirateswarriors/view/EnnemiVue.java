package com.pirateswarriors.view;


import com.pirateswarriors.model.ennemies.Ennemis;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnnemiVue {

    private ImageView imageEnnemi;
    private Image image;
    private Label labelPv;
    private Pane paneCentrale;


    public EnnemiVue(Ennemis ennemi) {
        if(ennemi.getImage() == 1){
            this.image = new Image("piratefusil.png") ;
        }
        else if(ennemi.getImage() == 2){
            this.image = new Image("Embarcationfortune.png") ;
        }
        else if(ennemi.getImage() == 3){
            this.image = new Image("barquecanon.png") ;
        }
        else if(ennemi.getImage() == 4){
            this.image = new Image("grospirate.png") ;
        }
        else if(ennemi.getImage() == 5){
            this.image = new Image("Voleur.png") ;
        }
        else if(ennemi.getImage() == 6){
            this.image = new Image("grosnavire.png") ;
        }

        this.imageEnnemi = new ImageView(image);
        this.imageEnnemi.setId(ennemi.getId());

        //imageBateau.setImage(image);

        this.labelPv = new Label("PV : " + ennemi.getPts_vie());
        ennemi.getPts_vieProperty().addListener((obs, old, nouv) -> {
            this.labelPv.setText("PV : " + nouv);
        });
        ennemi.positionXProperty().addListener((obs, old, nouv) -> {
            this.labelPv.setLayoutX((Double) nouv + 15);
        });
        ennemi.positionYProperty().addListener((obs, old, nouv) -> {
            this.labelPv.setLayoutY((Double) nouv);
        });
    }

    public ImageView getImageBateau() {
        return imageEnnemi;
    }





}
