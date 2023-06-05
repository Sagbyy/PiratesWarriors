package com.pirateswarriors;

import com.pirateswarriors.model.ennemies.PackEnnemis.BarqueCanon;
import com.pirateswarriors.model.ennemies.PackEnnemis.PirateFusil;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Environnement {

    private ArrayList<Ennemis> ennemis;
    private ArrayList<Defense> defenses;

    private IntegerProperty nbVague;
    private IntegerProperty nbScore;
    private IntegerProperty nbArgent;
    private int nbEnnemis;

    public Environnement() {
        super();
        this.nbVague = new SimpleIntegerProperty(1);
        this.nbScore = new SimpleIntegerProperty(0);
        this.nbArgent = new SimpleIntegerProperty(0);
        this.ennemis= new ArrayList<>();
        this.defenses= new ArrayList<>();
        this.nbEnnemis = 10;
    }

    public void ajouter(Ennemis a){
        this.ennemis.add(a);
    }

    public int getNbVague() {
        return nbVague.get();
    }

    public void setNbVague(int nbVague) {
        this.nbVague.set(nbVague);
    }

    public ArrayList<Ennemis> getEnnemis() {
        return this.ennemis;
    }

    public void créerVagues(){
        for(int i = 0; i <= this.nbEnnemis; i++){
            int rand = (int)(Math.random() * 2) + 1;
            if(rand == 1){
                this.ennemis.add(new BarqueCanon());
            }
            if(rand == 2){
                this.ennemis.add(new PirateFusil());
            }
        }
        setNbVague(getNbVague()+1);
        this.nbEnnemis =  this.nbEnnemis * 2;
    }

    public void jeu(){
        créerVagues();
    }


}
