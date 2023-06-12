package com.pirateswarriors.model.ennemies;


import com.pirateswarriors.model.Tresor;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.ennemies.CarteModele;
import com.pirateswarriors.model.ennemies.PackEnnemis.BarqueCanon;
import com.pirateswarriors.model.ennemies.PackEnnemis.PirateFusil;
import com.pirateswarriors.model.map.BFS;
import com.pirateswarriors.model.map.Couple;
import com.pirateswarriors.view.EnnemiVue;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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


    private Tresor tresor;
    private Ennemis ennemis;
    private ImageView imgTresor;
    private EnnemiVue ennemiVue;
    private CarteModele carteModele;


    ArrayList chemin;
    //CarteModele g = new CarteModele("newMap2.csv");
    com.pirateswarriors.model.map.BFS BFS ;

    public Ennemis(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque, Image image, EnnemiVue ennemiVue) { // Constructeur de la class mère Ennemis
        this.pts_vie = new SimpleIntegerProperty(pts_vie);
        this.ennemiVue = ennemiVue;
        this.image = image;
        this.pts_score = pts_score;
        this.pts_pièces = pts_pièces;
        this.pts_attaque = pts_attaque;
        this.positionX = new SimpleDoubleProperty(1536);
        this.positionY = new SimpleDoubleProperty(192);
        this.vitesse = vitesse;
        this.env = env;
        this.dir = "";
        this.pos = 0;
        this.id = "E"+compteur;
        compteur++;
        this.carteModele = env.getCarte() ;
        this.BFS = new BFS(carteModele,apparition() );
        this.chemin = BFS.cheminVersSource();

    }


      public Ennemis(Environnement env) { // Constructeur de la class mère Ennemis
        this.positionX = new SimpleDoubleProperty(1536);
        this.positionY = new SimpleDoubleProperty(192);
        this.vitesse = vitesse;
        this.env = env;
        this.carteModele = env.getCarte() ;
        this.BFS = new BFS(carteModele,apparition() );
        this.chemin = BFS.cheminVersSource();
        this.id = "E"+compteur;
        this.dir = "";
        this.pos = 0;
        compteur++;
    }

    public String getId() {
        return id;
    }



    public Couple apparition(){
        Couple c = null;

        int rand = (int) (Math.random() * 2) + 1;
        if (rand == 1) {
             c = new Couple(3, 24);
        }
        if (rand == 2) {
             c = new Couple(11, 22);
            setPositionX(getPositionX()-128);
            setPositionY(getPositionY()+512);
        }
       return c;
    }


    public double getMiddlePostionX() {
        return this.getPositionX() + this.getImage().getWidth() / 2;
    }

    public double getMiddlePostionY() {
        return this.getPositionY() + this.getImage().getHeight() / 2;
    }

    public boolean estMort(){ // Fonction pour verfier si l'ennemi est mort ou non
        return this.pts_vie.getValue() <= 0;
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
