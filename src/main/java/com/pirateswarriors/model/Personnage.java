package com.pirateswarriors.model;

import com.pirateswarriors.view.PersonnageVue;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {

    private DoubleProperty positionX;
    private DoubleProperty positionY;

    public Personnage(){
        positionX = new SimpleDoubleProperty(0);
        positionY = new SimpleDoubleProperty(0);
    }

    // Getters et setters pour les attributs

    public double getPositionX() {
        return positionX.get();
    }
    public void setPositionX(int positionX) {
        this.positionX.set(positionX);
    }
    public DoubleProperty positionXProperty() {
        return positionX;
    }



    public double getPositionY() {
        return positionY.get();
    }
    public void setPositionY(int positionY) {
        this.positionY.set(positionY);
    }
    public DoubleProperty positionYProperty() {
        return positionY;
    }




}
