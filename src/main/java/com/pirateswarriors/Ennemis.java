package com.pirateswarriors;

import com.pirateswarriors.model.Tresor;
import com.pirateswarriors.model.ennemies.CarteModele;
import com.pirateswarriors.model.map.BFS;
import com.pirateswarriors.model.map.Couple;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Ennemis {
    protected int pts_vie; // Points de vie de l'ennemi
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

    private Tresor tresor;
    private Ennemis ennemis;
    private ImageView imgTresor;

    ArrayList chemin;
    CarteModele g = new CarteModele("newMap1.csv");
    com.pirateswarriors.model.map.BFS BFS = new BFS(g);

    public Ennemis(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image) { // Constructeur de la class mère Ennemis
        this.pts_vie = pts_vie;
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
        if(this.pts_vie == 0){
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

            //System.out.println(dir);
        }

    }
    public void attaque (Tresor tresor){
        //while (tresor.estPasDetruit()){
        System.out.println("attaque du trésor");
        tresor.damage(pts_attaque);
        //}
    }

//    public boolean ennemiProche(){
//        double distanceX = Math.abs(ennemis.getPositionX() - imgTresor.getX());
//        System.out.println("distanceX: " + distanceX);
//        double distanceY = Math.abs(ennemis.getPositionY() - imgTresor.getY());
//
//        // Calcul de la distance entre l'ennemi et le trésor
//        double distance = Math.sqrt(distanceX * distanceX - distanceY * distanceY);
//        System.out.println("distance: " + distance);
//        double maxDistance = 5;
//
//        if (distance <= maxDistance) {
//            System.out.println("distance proche");
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
}
