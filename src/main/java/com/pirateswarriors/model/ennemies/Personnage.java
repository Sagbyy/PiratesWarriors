package com.pirateswarriors.model.ennemies;

import com.pirateswarriors.view.PersonnageVue;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {

    private DoubleProperty positionX;
    private DoubleProperty positionY;

    public Personnage(){
        positionX = new SimpleDoubleProperty(1900);
        positionY = new SimpleDoubleProperty(100);
    }

    // Getters et setters pour les attributs

    public double getPositionX() {
        return positionX.getValue();
    }
    public void setPositionX(double positionX) {
        this.positionX.setValue(positionX);
    }
    public DoubleProperty positionXProperty() {
        return positionX;
    }



    public double getPositionY() {
        return positionY.getValue();
    }
    public void setPositionY(double positionY) {
        this.positionY.setValue(positionY);
    }
    public DoubleProperty positionYProperty() {
        return positionY;
    }




}
