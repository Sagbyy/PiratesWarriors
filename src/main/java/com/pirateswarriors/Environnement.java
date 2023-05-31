package com.pirateswarriors;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Environnement {

    private int width,height;
    private ArrayList<Ennemis> ennemis;
    private ArrayList<Defense> defenses;

    private IntegerProperty nbVague;
    private IntegerProperty nbScore;
    private IntegerProperty nbArgent;

    public Environnement() {
        super();
        this.width = width;
        this.height = height;
        this.nbVague = new SimpleIntegerProperty(1);
        this.nbScore = new SimpleIntegerProperty(0);
        this.nbArgent = new SimpleIntegerProperty(0);
        this.ennemis= new ArrayList<>();
        this.defenses= new ArrayList<>();

    }

    public void ajouter(Ennemis a){
        this.ennemis.add(a);
    }
}
