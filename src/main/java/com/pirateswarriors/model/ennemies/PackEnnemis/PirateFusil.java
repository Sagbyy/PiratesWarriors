package com.pirateswarriors.model.ennemies.PackEnnemis;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.Environnement;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

public class PirateFusil extends Ennemis {



    public PirateFusil(Environnement env) {
        super(2,env,1500,7,10, 10, new Image("testanim.gif"));
        setPositionX(getPositionX()-64);
        setPositionY(getPositionY()-64);


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
