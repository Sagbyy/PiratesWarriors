package com.pirateswarriors.model;

import com.pirateswarriors.model.defense.DefenseActor;
import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.ennemies.PackEnnemis.BarqueCanon;
import com.pirateswarriors.model.ennemies.PackEnnemis.PirateFusil;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;

public class Environnement {

    //private ArrayList<Ennemis> ennemisList;
    private ArrayList<DefenseActor> defenseList;
    private ArrayList<Ennemis> ennemisBack;
    private ObservableList<Ennemis> ennemisList;
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
        this.nbVague = new SimpleIntegerProperty(1);
        this.nbScore = new SimpleIntegerProperty(0);
        this.nbArgent = new SimpleIntegerProperty(0);
        this.ennemisList =  FXCollections.observableArrayList();
        this.defenseList = new ArrayList<>();
        this.ennemisBack = new ArrayList<>();
        this.nbEnnemis = 0;
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
        System.out.println("Ajouttttttttttt");
    }


    public ArrayList<Ennemis> getEnnemisBack() {
        return ennemisBack;
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


    public void créerVagues() {
        for (int i = 0; i <= this.nbEnnemis; i++) {
            int rand = (int) (Math.random() * 2) + 1;
            if (rand == 1) {
                this.ennemisList.add(new BarqueCanon());
            }
            if (rand == 2) {
                this.ennemisList.add(new PirateFusil());
            }
        }
    }


    public void untour() {
        if (ennemisList.size() == 0) {
            this.nbEnnemis += 10;
            vague();

        }

        vague();
        tousAvancent();
        sontMorts();

        // Attaque des défense

        Iterator<Ennemis> iterator = ennemisList.iterator();
        while (iterator.hasNext()) {
            Ennemis ennemies = iterator.next();

            if (ennemies.estMort()) {
                iterator.remove();
            } else {
                for (DefenseActor defense : defenseList) {
                    if ((defense.getPositionX() + defense.getPorteeDegats() >= ennemies.getMiddlePostionX() && defense.getPositionX() - defense.getPorteeDegats() <= ennemies.getMiddlePostionX()) && (defense.getPositionY() + defense.getPorteeDegats() >= ennemies.getMiddlePostionY() && defense.getPositionY() - defense.getPorteeDegats() <= ennemies.getMiddlePostionY())) {
                        defense.attaque(ennemies);
                    }
                }
            }
        }
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
                this.porteMonnaie.ajoutMonnaie(50);
            }
        }
    }


    int nbenn, lop;

    public void vague() {
        if (!(nbenn == getNbEnnemis())) {
            if (lop % 75 == 0) {
                int rand = (int) (Math.random() * 2) + 1;
                if (rand == 1) {
                    getEnnemisList().add(new BarqueCanon());

                }
                if (rand == 2) {
                    getEnnemisList().add(new PirateFusil());
                }
                nbenn++;
            }

        }
        lop = lop + (int) (Math.random() * 3) + 1;

    }

}