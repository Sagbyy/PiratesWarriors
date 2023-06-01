package com.pirateswarriors.model.ennemies.PackEnnemis;


import com.pirateswarriors.Ennemis;
import com.pirateswarriors.Environnement;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;

public class BarqueCanon extends Ennemis {
    Environnement jeu = new Environnement();

    private DoubleProperty positionX;
    private DoubleProperty positionY;

    public BarqueCanon() {
        this.jeu = jeu;
        this.image = new Image("ship.png");
        this.positionX = new SimpleDoubleProperty(1216);
        this.positionY = new SimpleDoubleProperty(64);
        this.pts_vie = 10;
        this.pts_score = 7;
        this.pts_pièces = 10;
        this.pts_attaque = 10;
        this.vitesse = 1;
    }
    public void tire(){
        //Si la barque se trouve à ... pixels de distance du trésor, elle s'arrète et lui tire dessus
    }
}
