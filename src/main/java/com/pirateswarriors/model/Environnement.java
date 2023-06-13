package com.pirateswarriors.model;

import com.pirateswarriors.model.defense.DefenseActor;
import com.pirateswarriors.model.ennemies.CarteModele;
import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.ennemies.PackEnnemis.*;
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

    CarteModele carte;
    private IntegerProperty nbVague;
    private IntegerProperty nbScore;
    private IntegerProperty nbArgent;
    private int nbEnnemis;
    private Pane paneCentral;
    private PorteMonnaie porteMonnaie;

    public Environnement(Pane paneCentral, PorteMonnaie porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
        this.porteMonnaie.setNb(9000);
        this.paneCentral = paneCentral;
        this.nbVague = new SimpleIntegerProperty(0);
        this.nbScore = new SimpleIntegerProperty(0);
        this.nbArgent = new SimpleIntegerProperty(0);
        this.ennemisList =  FXCollections.observableArrayList();
        this.defenseList = new ArrayList<>();
        this.ennemisBack = new ArrayList<>();
        this.nbEnnemis = 0;
        this.carte = new CarteModele("map1.csv");
    }

    public PorteMonnaie getPorteMonnaie() {
        return this.porteMonnaie;
    }

//    public CarteModele getCarte(){
//        return this.carte;
//    }
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


    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public int getNbVague() {
        return nbVague.get();
    }

    public void setNbVague(int nbVague) {
        this.nbVague.set(nbVague);
    }
    boolean go = true;
    public void untour() {
        if (ennemisList.size() == 0 && go == true) {
            this.nbEnnemis += 10;
            vague();
            this.nbVague.set(getNbVague() + 1);
            if(getNbVague()%2 == 0 && vag<5){
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
                    }

                    if (defense.getPv() <= 0) {
                        defenseIterator.remove();
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
                    System.out.println("mort de : " + a.getId());
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
    }


