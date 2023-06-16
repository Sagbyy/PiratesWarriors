package com.pirateswarriors.model;

import com.pirateswarriors.controller.ControllerViewChoixMap;
import com.pirateswarriors.model.defense.DefenseActor;
import com.pirateswarriors.model.map.CarteModele;
import com.pirateswarriors.model.Ennemis.Ennemis;
import com.pirateswarriors.model.Ennemis.PackEnnemis.BarqueCanon;
import com.pirateswarriors.model.Ennemis.PackEnnemis.PirateFusil;
import com.pirateswarriors.view.TresorVue;
import com.pirateswarriors.view.map.Carte;
import com.pirateswarriors.model.Ennemis.PackEnnemis.*;
import com.pirateswarriors.view.EnnemiVue;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Environnement {

    //private ArrayList<Ennemis> ennemisList;
    private ArrayList<DefenseActor> defenseList;
    private ObservableList<Ennemis> ennemisList;
    private ArrayList<Ennemis> ennemisBack;

    private CarteModele carte;
    private IntegerProperty nbVague;
    private IntegerProperty nbScore;
    private IntegerProperty nbArgent;
    private int nbEnnemis;
    private Pane paneCentral;
    private PorteMonnaie porteMonnaie;
    private ControllerViewChoixMap controllerViewChoixMap;
    private String map;
    private Tresor tresor;
    private TresorVue tresorVue;

    public Environnement(Carte carte, Pane paneCentral, PorteMonnaie porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
        this.porteMonnaie.setNb(9000);
        this.paneCentral = paneCentral;
        this.tresor = new Tresor(2000);
        this.tresorVue = new TresorVue(tresor);
        this.nbVague = new SimpleIntegerProperty(0);
        this.nbScore = new SimpleIntegerProperty(0);
        this.nbArgent = new SimpleIntegerProperty(0);
        this.ennemisList =  FXCollections.observableArrayList();
        this.defenseList = new ArrayList<>();
        this.ennemisBack = new ArrayList<>();
        this.nbEnnemis = 0;
        this.map = SelectionMap();;
        this.carte = new CarteModele(map);

    }

    public boolean ennemiProche(Ennemis ennemis){
        double distanceX = Math.abs(ennemis.getPositionX() - tresorVue.getImgTresor().getX());
        double distanceY = Math.abs(ennemis.getPositionY() - tresorVue.getImgTresor().getY());
        // Calcul de la distance entre l'ennemi et le trésor
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        System.out.println(distance);
        //definit la position du trésor -> lorsque distance entre ennemi est trésor est inferieur a cette valeur l'ennemi attaque
        double maxDistance = 449;
        if (distance <= maxDistance) {
            return true;
        } else {
            return false;
        }
    }

    public String SelectionMap(){
        //récupère le numéro du bouton cliqué
        int carte = ControllerViewChoixMap.getMap();
        //attribution des noms des fichiers csv des maps
        if (carte == 1){
            map = "map1.csv";
        }
        else if (carte == 2){
            map = "map2.csv";
        }
        else if (carte == 3){
            map = "map3.csv";
        }
        return map;
    }

    boolean go = true;
    int time = 0;
    public void untour() {
        time++;
        if(time%1==0) {
            if (ennemisList.size() == 0 && go == true) {
                this.nbEnnemis += 10;
                vague();
                this.nbVague.set(getNbVague() + 1);
                if (getNbVague() % 2 == 0 && vag < 5) {
                    vag++;
                }
            } else if (!go) {

                vague();
            }
            sontMorts();
            tousAvancent();

            Iterator<Ennemis> ennemisIterator = ennemisList.iterator();
            while (ennemisIterator.hasNext()) {
                Ennemis ennemies = ennemisIterator.next();
                EnnemiVue ennemiVue = new EnnemiVue(ennemies);


                if (ennemies.estMort()) {
                    ennemisIterator.remove();
                } else {
                    ListIterator<DefenseActor> defenseIterator = defenseList.listIterator();
                    while (defenseIterator.hasNext()) {
                        DefenseActor defense = defenseIterator.next();

                        defense.eachTimeDoSomething();

                        if ((defense.getPositionX() + defense.getPorteeDegats() >= ennemiVue.getMiddlePostionX() && defense.getPositionX() - defense.getPorteeDegats() <= ennemiVue.getMiddlePostionX()) && (defense.getPositionY() + defense.getPorteeDegats() >= ennemiVue.getMiddlePostionY() && defense.getPositionY() - defense.getPorteeDegats() <= ennemiVue.getMiddlePostionY())) {
                            defense.attaque(ennemies, ennemiVue);

                            // Si il ne tire pas
                            if (!defense.ifHasBullet()) {
                                if (ennemies.estMort()) {
                                    this.paneCentral.getChildren().remove(this.paneCentral.lookup("#" + ennemies.getId()));
                                }
                            }
                        }

                        if (defense.getPv() <= 0) {
                            defenseIterator.remove();
                        }
                    }
                }
            }
        }


    }

    public CarteModele getCarte() {
        return carte;
    }

    public void tousAvancent() {
        for (int i = 0; i < getEnnemisList().size(); i++) {
            getEnnemisList().get(i).avance();
        }
    }

        public void sontMorts() {
            for (int i = getEnnemisList().size() - 1; i >= 0; i--) {
                Ennemis a = getEnnemisList().get(i);
                if (a.estMort()) {
                    getEnnemisList().remove(i);
                    this.porteMonnaie.ajoutMonnaie(100);
                }
            }
        }



    int nbenn, lop;
    int vag = 1;

    public void vague() {
        if (!(nbenn == this.nbEnnemis)) {
            if (lop % 75 == 0) {
                int rand = (int) (Math.random() * vag) + 1;
                if (rand == 1) {
                    getEnnemisList().add(new PirateFusil(this));
                }
                else if (rand == 2) {
                    getEnnemisList().add(new EmbarcationFortune(this));
                }
                else if (rand == 3) {
                    getEnnemisList().add(new BarqueCanon(this));
                }
                else if (rand == 4) {
                    getEnnemisList().add(new GrosPirate(this));
                }
                else if (rand == 5) {
                    getEnnemisList().add(new Voleur(this));
                }
                else if (rand == 6) {
                    if(getNbVague()%10==0){
                        getEnnemisList().add(new GrosNavire(this));
                    }

                }
                nbenn++;
            }
            go = false;
        } else {
            go = true;
            nbenn = 0;
        }
        lop = lop + (int) (Math.random() * 3) + 1;



    }
    public Tresor getTresor(){
        return this.tresor;
    }
    public PorteMonnaie getPorteMonnaie() {
        return this.porteMonnaie;
    }
    public Pane getPaneCentral() {
        return this.paneCentral;
    }

    public ObservableList<Ennemis> getEnnemisList() {
        return ennemisList;
    }

    public void ajouter(Ennemis a) {
        this.ennemisList.add(a);
    }

    public void ajouterDefense(DefenseActor defense) {
        this.defenseList.add(defense);
    }
    public IntegerProperty getNbVaguesProperty(){
        return this.nbVague;
    }

    public void removeDefense(DefenseActor defense) {
        this.defenseList.remove(defense);
    }

    public ArrayList<DefenseActor> getDefenseList() {
        return this.defenseList;
    }

    public String getMap(){
        return this.map;
    }

    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public int getNbVague() {
        return nbVague.get();
    }

    public void setNbVague(int nbVague) {
        this.nbVague.set(nbVague);
    }

    }


