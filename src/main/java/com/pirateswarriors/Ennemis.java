package com.pirateswarriors;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;

public class Ennemis {
    private int pts_vie; // Points de vie de l'ennemi
    private int pts_score; // Nombre de points gagnés quand le joueur élimine l'ennemi
    private int pts_pièces; // Nombre de pièces gagnés quand le joueur élimine l'ennemi
    private int pts_attaque; // Valeur de l'attaque de l'ennemi
    private double vitesse; // vitesse de direction
    private int dx,dy ;// direction
    private String id;
    private DoubleProperty x,y; // Position
    protected Environnement env;
    private Image image;

    public Ennemis(int x, int y, int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) { // Constructeur de la class mère Ennemis
        this.pts_vie = pts_vie;
        this.image = image;
        this.pts_score = pts_score;
        this.pts_pièces = pts_pièces;
        this.pts_attaque = pts_attaque;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.vitesse = vitesse;
        this.env = env;
    }

    public boolean estMort(){ // Fonction pour verfier si l'ennemi est mort ou non
        if(this.pts_vie == 0){
            return true; // Si oui retourne true
        }
        else return false; // Sinon retourne false
    }

    public void enleverPv(int n) {
        this.pts_vie-=n;
    }

    public void ajoutPv(int n) {
        this.pts_vie+=n;
    }

    public Image getImage(){
        return this.image;
    }

    public void seDeplace(){

    }
}
