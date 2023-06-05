package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.Ennemis;
import com.pirateswarriors.Environnement;
import com.pirateswarriors.model.map.Couple;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class PirateFusil extends Ennemis {

    Environnement jeu = new Environnement();

    private DoubleProperty positionX;
    private DoubleProperty positionY;

    public PirateFusil() {
        setPositionX(getPositionX()-64);
        setPositionY(getPositionY()-64);
        this.jeu = jeu;
        this.image = new Image("testanim.gif");
        this.positionX = positionX;
        this.positionY = positionY;
        this.pts_vie = new SimpleIntegerProperty(10);
        this.pts_score = 7;
        this.pts_pièces = 10;
        this.pts_attaque = 10;
        this.vitesse = 2;
    }

    //    public PirateFusil( ) {
//        super(10, 125, 15, 7, 20);
//        this.imagepirate = imagepirate;
//        this.env = jeu;
//        this.positionX = new SimpleDoubleProperty(1216);
//        this.positionY = new SimpleDoubleProperty(64);
//
//    }


    @Override
    public Image getImage() {
        return super.getImage();
    }
}
