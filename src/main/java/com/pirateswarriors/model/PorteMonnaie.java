package com.pirateswarriors.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PorteMonnaie {
    private IntegerProperty nb;

    public PorteMonnaie(){
        this.nb = new SimpleIntegerProperty(0);
    }

    public IntegerProperty nbProperty(){
        return nb;
    }
    public int getNb(){
        return nb.get();
    }
    public void setNb(int nb){
        this.nbProperty().set(nb);
    }

    public void ajoutMonnaie(int s){
        this.nbProperty().setValue(nbProperty().getValue() + s);
    }

    public void enleverMonnaie(int s){
        this.nbProperty().setValue(nbProperty().getValue() - s);
    }

    public boolean argentVide(){
        if (nb.get() < 499){
            return true;
        }
        else
            return false;
    }
}

