package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

public class BarqueCanon extends Ennemis {


    public BarqueCanon( Environnement env) {
        super(1,  env, 200, 7, 10, 10, new Image("ship.png"));
//        this.image = ;
//        this.positionX = new SimpleDoubleProperty(1216);
//        this.positionY = new SimpleDoubleProperty(64);
//        this.pts_vie = new SimpleIntegerProperty(200);
//        this.pts_score = 7;
//        this.pts_pièces = 10;
//        this.pts_attaque = 10;
//        this.vitesse = 1;
    }
    public void tire(){
        //Si la barque se trouve à ... pixels de distance du trésor, elle s'arrète et lui tire dessus
    }
}
