package com.pirateswarriors.model.Ennemis;


import com.pirateswarriors.model.Tresor;
import com.pirateswarriors.model.Environnement;
import com.pirateswarriors.model.map.BFS;
import com.pirateswarriors.model.map.Couple;
import javafx.beans.property.*;

import java.util.ArrayList;

public class Ennemis {

    protected IntegerProperty pts_vie;
    private DoubleProperty positionX;
    private DoubleProperty positionY;
    private String id;
    protected Environnement env;
    protected int pos, pts_score, pts_pièces, pts_attaque, vitesse;
    private StringProperty dir;
    public static int compteur=0;
    private CarteModele carteModele;
    ArrayList chemin;
    com.pirateswarriors.model.map.BFS BFS ;

    /**
     *Constructeur de la classe Mère "Ennemis"
     *avec tout ses attributs
     */
    public Ennemis(int vitesse, Environnement env, int pts_vie, int pts_score, int pts_pièces, int pts_attaque) {
        this.pts_vie = new SimpleIntegerProperty(pts_vie);
        this.pts_score = pts_score;
        this.pts_pièces = pts_pièces;
        this.pts_attaque = pts_attaque;
        this.positionX = new SimpleDoubleProperty(1536);
        this.positionY = new SimpleDoubleProperty(192);
        this.vitesse = vitesse;
        this.env = env;
        this.dir = new SimpleStringProperty("");//Direction de l'ennemi --> voir méthode avance() ci-dessous
        this.pos = 0;
        this.id = "E"+compteur;
        this.carteModele = env.getCarte() ;
        this.BFS = new BFS(carteModele,apparition());
        this.chemin = BFS.cheminVersSource();
        compteur++;
    }

      public Ennemis(Environnement env) {
        this.positionX = new SimpleDoubleProperty(1536);
        this.positionY = new SimpleDoubleProperty(192);
        this.vitesse = vitesse;
        this.env = env;
        this.carteModele = env.getCarte() ;
        this.BFS = new BFS(carteModele,apparition() );
        this.chemin = BFS.cheminVersSource();
        this.id = "E"+compteur;
          this.dir = new SimpleStringProperty("");
        this.pos = 0;
        compteur++;
    }

    /**
     *Getter et Setter
     */
    public String getDir() {return dir.getValue();}
    public String getId() {return id;}
    public StringProperty getDirProperty(){return dir;}
    public double getPositionX() {return positionX.getValue();}
    public DoubleProperty positionXProperty() {return positionX;}
    public DoubleProperty positionYProperty() {return positionY;}
    public ArrayList<Couple> getChemin() {return this.chemin;}
    public double getPositionY() {return positionY.getValue();}
    public void setPositionY(double positionY) {this.positionY.setValue(positionY);}
    public void setPositionX(double positionX) {this.positionX.setValue(positionX);}
    public void enleverPv(int n) {this.pts_vie.setValue(this.pts_vie.getValue() - n);}

    /**
     * Méthode apparition()
     *   - En fonction de la map, et de manière aléatoire, apparition() détermine le spawn
     *   de l'ennemi sur le csv pour le BFS
     *   - Ajuste l'apparition sur la map en fonction des pixels
     */
    public Couple apparition(){
        Couple c = null;
        //Spawn pour la map1
        if(env.getMap().equals("map1.csv")){
            int rand = (int) (Math.random() * 2) + 1;
            if (rand == 1) {
                c = new Couple(3, 24);
            }
            else if (rand == 2) {
                c = new Couple(11, 22);
                setPositionX(getPositionX()-128);
                setPositionY(getPositionY()+512);
            }
        }
        //Spawn pour la map2
        else if (env.getMap().equals("map2.csv")){
            int rand = (int) (Math.random() * 2) + 1;
            if (rand == 1) {
                c = new Couple(4, 24);
                setPositionY(getPositionY()+64);
            }
            else if (rand == 2) {
                c = new Couple(11, 11);
                setPositionX(getPositionX()-832);
                setPositionY(getPositionY()+512);
            }
            else if (rand == 3) {
                c = new Couple(11, 15);
                setPositionX(getPositionX()-576);
                setPositionY(getPositionY()+512);
            }
        }
        //Spawn pour la map3
        if(env.getMap().equals("map3.csv")){
            int rand = (int) (Math.random() * 2) + 1;
            if (rand == 1) {
                c = new Couple(5, 24);
                setPositionY(getPositionY()+128);
            }
            else if (rand == 2) {
                c = new Couple(6, 24);
                setPositionY(getPositionY()+192);

            }
        }
        return c;
    }

    /**
     * Méthode estMort()
     *  - Vérifie si les points de vie de l'ennemi sont inférieurs ou égale à 0
     *  et return un booléen
     */
    public boolean estMort(){return this.pts_vie.getValue() <= 0;}


    /**
     * Méthode avance()
     *  - Méthode qui vérifie dans quelle direction va l'ennemi :
     *          haut --> h
     *          bas --> b
     *          gauche --> g
     *  Et lui fait aller dans cette direction.
     */
    public void avance(){
        if(pos<getChemin().size()-1){
            if(positionX.getValue()%64==0 && positionY.getValue()%64==0){
                Couple case_chemin = getChemin().get(pos);
                Couple case_apres = getChemin().get(pos + 1);

                if (case_apres.equals(new Couple(case_chemin.getX() - 1, case_chemin.getY()))) {dir.setValue("h");}
                else if (case_apres.equals(new Couple(case_chemin.getX(), case_chemin.getY() - 1))) {dir.setValue("g");}
                else if (case_apres.equals(new Couple(case_chemin.getX() + 1, case_chemin.getY()))) {dir.setValue("b");}
                pos++;
            }
            if(getDir().equals("h")){setPositionY(getPositionY()-this.vitesse);}

            if(getDir().equals("g")){setPositionX(getPositionX()-this.vitesse);}

            if(getDir().equals("b")){setPositionY(getPositionY()+this.vitesse);}
        }
    }

    /**
     * Méthode attaque(Trésor tresor)
     *  - Prend en argument un trésor
     *  - Inflige au trésor des dégats
     */
    public void attaque(Tresor tresor){tresor.damage(pts_attaque);}
}
