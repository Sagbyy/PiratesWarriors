package com.pirateswarriors.model.ennemies;

import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.map.BFS;
import com.pirateswarriors.model.map.Couple;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Ennemis {
    protected IntegerProperty pts_vie; // Points de vie de l'ennemi
    protected int pts_score; // Nombre de points gagnés quand le joueur élimine l'ennemi
    protected int pts_pièces; // Nombre de pièces gagnés quand le joueur élimine l'ennemi
    protected int pts_attaque; // Valeur de l'attaque de l'ennemi
    protected double vitesse; // vitesse de direction
    private DoubleProperty positionX;
    private DoubleProperty positionY;
    private String id;
    private DoubleProperty x,y; // Position
    protected Environnement env;
    protected Image image;
    private String dir;
    private int pos;
    public static int compteur=0;


    ArrayList chemin;
    CarteModele g = new CarteModele("newMap1.csv");
    com.pirateswarriors.model.map.BFS BFS = new BFS(g);

    public Ennemis(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) { // Constructeur de la class mère Ennemis
        this.pts_vie = new SimpleIntegerProperty(pts_vie);
        this.image = image;
        this.pts_score = pts_score;
        this.pts_pièces = pts_pièces;
        this.pts_attaque = pts_attaque;
        this.positionX = new SimpleDoubleProperty(1280);
        this.positionY = new SimpleDoubleProperty(64);
        this.vitesse = vitesse;
        this.env = env;
        this.chemin = BFS.cheminVersSource();
        this.dir = "";
        this.pos = 0;
        this.id = "E"+compteur;
        compteur++;
    }


    public Ennemis() { // Constructeur de la class mère Ennemis
        this.pts_vie = pts_vie;
        this.image = image;
        this.pts_score = pts_score;
        this.pts_pièces = pts_pièces;
        this.pts_attaque = pts_attaque;
        this.positionX = new SimpleDoubleProperty(1216);
        this.positionY = new SimpleDoubleProperty(64);
        this.vitesse = vitesse;
        this.env = env;
        this.chemin = BFS.cheminVersSource();
        this.dir = "";
        this.pos = 0;
    }



    public boolean estMort(){ // Fonction pour verfier si l'ennemi est mort ou non
        if(this.pts_vie.getValue() == 0){
            return true; // Si oui retourne true
        }
        else return false; // Sinon retourne false
    }

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

    public IntegerProperty getPts_vieProperty() {
        return this.pts_vie;
    }

    public int getPts_vie() {
        return this.pts_vie.getValue();
    }

    public void setPts_vie(int newPtsVie) {
        this.pts_vie.setValue(newPtsVie);
    }

    public void enleverPv(int n) {
        this.pts_vie.setValue(this.pts_vie.getValue() - n);
    }

    public void ajoutPv(int n) {
        this.pts_vie.setValue(this.pts_vie.getValue() + n);
    }

    public Image getImage(){
        return this.image;
    }

    public void seDeplace(){

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
                setPositionY(getPositionY()-this.vitesse);
            }

            if(dir.equals("g")){
                setPositionX(getPositionX()-this.vitesse);
            }

            if(dir.equals("h")){
                setPositionY(getPositionY()+this.vitesse);
            }

        }
    }
}
