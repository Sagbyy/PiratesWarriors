package com.pirateswarriors.model.ennemies;

import com.pirateswarriors.model.map.BFS;
import com.pirateswarriors.model.map.Couple;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;

public class Personnage {

    private DoubleProperty positionX;
    private DoubleProperty positionY;
    private String dir;
    private int pos;

    ArrayList chemin;
    CarteModele g = new CarteModele("PiratesWarriorTIles_Couche1.csv");
    com.pirateswarriors.model.map.BFS BFS = new BFS(g);

    public Personnage(){
        positionX = new SimpleDoubleProperty(1900);
        positionY = new SimpleDoubleProperty(100);
        this.chemin = BFS.cheminVersSource();
        this.dir = "";
        this.pos = 0;
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

    public ArrayList<Couple> getChemin() {
        return this.chemin;
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

    public void avance(){
        if(pos<getChemin().size()-1){
            if(positionX.getValue()%64==0 && positionY.getValue()%64==0){
                Couple case_chemin = getChemin().get(pos);
                Couple case_apres = getChemin().get(pos + 1);

                if (case_apres.equals(new Couple(case_chemin.getX() - 1, case_chemin.getY()))) {
                    dir = "b";
                } else if (case_apres.equals(new Couple(case_chemin.getX(), case_chemin.getY() - 1))) {
                    dir = "g";
                } else if (case_apres.equals(new Couple(case_chemin.getX() + 1, case_chemin.getY()))) {
                    dir = "h";
                }
                pos++;
            }

            if(dir.equals("b")){
                setPositionY(getPositionY()-1);
            }

            if(dir.equals("g")){
                setPositionX(getPositionX()-1);
            }

            if(dir.equals("h")){
                setPositionY(getPositionY()+1);
            }

            System.out.println(dir);
        }
    }



}
