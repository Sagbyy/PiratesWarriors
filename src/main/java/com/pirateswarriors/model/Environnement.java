package com.pirateswarriors.model;

import com.pirateswarriors.model.defense.DefenseActor;
import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.ennemies.PackEnnemis.BarqueCanon;
import com.pirateswarriors.model.ennemies.PackEnnemis.PirateFusil;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Environnement {

    private ArrayList<Ennemis> ennemisList;
    private ArrayList<DefenseActor> defensesList;

    private IntegerProperty nbVague;
    private IntegerProperty nbScore;
    private IntegerProperty nbArgent;
    private int nbEnnemis;

    public Environnement() {
        this.nbVague = new SimpleIntegerProperty(1);
        this.nbScore = new SimpleIntegerProperty(0);
        this.nbArgent = new SimpleIntegerProperty(0);
        this.ennemisList = new ArrayList<>();
        this.defensesList = new ArrayList<>();
        this.nbEnnemis = 10;
    }

    public void ajouterEnnemi(Ennemis a){
        this.ennemisList.add(a);
    }

    public void ajouterDefense(DefenseActor defense) {
        this.defensesList.add(defense);
    }

    public int getNbVague() {
        return nbVague.get();
    }

    public void setNbVague(int nbVague) {
        this.nbVague.set(nbVague);
    }

    public ArrayList<Ennemis> getEnnemisList() {
        return this.ennemisList;
    }

    public void créerVagues(){
        for(int i = 0; i <= this.nbEnnemis; i++){
            int rand = (int)(Math.random() * 2) + 1;
            if(rand == 1){
                this.ennemisList.add(new BarqueCanon());
            }
            if(rand == 2){
                this.ennemisList.add(new PirateFusil());
            }
        }
        setNbVague(getNbVague()+1);
        this.nbEnnemis =  this.nbEnnemis * 2;
    }

    public void jeu(){
        créerVagues();
    }

    public void unTour() {
        // Attaque des défense
        System.out.println(defensesList);


        for (Ennemis ennemies : ennemisList) {
            for (DefenseActor defense : defensesList) {
                double distanceX = Math.abs(ennemies.getPositionX() - defense.getPositionX());
                double distanceY = Math.abs(ennemies.getPositionX() - defense.getPositionX());

                System.out.println("Distance : " );
                if (distanceX < 150 || distanceY < 150) {
                    ennemies.enleverPv(5);
                }
            }
        }
    }
}
