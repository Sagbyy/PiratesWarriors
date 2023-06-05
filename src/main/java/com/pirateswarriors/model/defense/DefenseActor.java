package com.pirateswarriors.model.defense;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class DefenseActor {

    private IntegerProperty pv;
    private int prix;
    private DoubleProperty positionX;
    private DoubleProperty positionY;

    public DefenseActor(int pv, int prix) {
        this.pv = new SimpleIntegerProperty(pv);
        this.prix = prix;
        this.positionX = new SimpleDoubleProperty(0);
        this.positionY = new SimpleDoubleProperty(0);
    }

    // Getter & Setter
    public IntegerProperty getPvProperty() {
        return this.pv;
    }

    public int getPv() {
        return this.pv.getValue();
    }

    public DoubleProperty positionXProperty() {
        return this.positionX;
    }

    public double getPositionX() {
        return this.positionX.getValue();
    }

    public void setPositionX(double newPos) {
        this.positionX.setValue(newPos);
    }

    public DoubleProperty positionYProperty() {
        return this.positionY;
    }

    public double getPositionY() {
        return this.positionY.getValue();
    }

    public void setPositionY(double newPos) {
        this.positionY.setValue(newPos);
    }
}
