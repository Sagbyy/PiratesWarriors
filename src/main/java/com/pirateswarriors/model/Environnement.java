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
    private ArrayList<DefenseActor> defenseList;
    private ArrayList<Ennemis> ennemisBack;


    private IntegerProperty nbVague;
    private IntegerProperty nbScore;
    private IntegerProperty nbArgent;
    private int nbEnnemis;

    public Environnement() {
        super();
        this.nbVague = new SimpleIntegerProperty(1);
        this.nbScore = new SimpleIntegerProperty(0);
        this.nbArgent = new SimpleIntegerProperty(0);
        this.ennemisList = new ArrayList<>();
        this.defenseList = new ArrayList<>();
        this.ennemisBack = new ArrayList<>();
        this.nbEnnemis = 0;
    }

    public ArrayList<Ennemis> getEnnemisList() {
        return ennemisList;
    }

    public void ajouter(Ennemis a){
        this.ennemisList.add(a);
    }
    public void ajouterDefense(DefenseActor defense) {
        this.defenseList.add(defense);
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


    public void untour () {
        if (ennemisList.size() == 0) {
            this.nbEnnemis += 10;
            vague();

        }

        vague();
        tousAvancent();
        sontMorts();

        // Attaque des défense
        for (Ennemis ennemies : ennemisList) {
            if (ennemies.estMort()) {
                ennemisList.remove(ennemies);
                System.out.println("mort de : " + ennemies);
            }
            for (DefenseActor defense : defenseList) {
                double distanceX = Math.abs(ennemies.getPositionX() - defense.getPositionX());
                double distanceY = Math.abs(ennemies.getPositionX() - defense.getPositionX());

                if (distanceX < 25 || distanceY < 25) {
                    System.out.println("Ennemis trouvée : " + ennemies);
                    ennemies.enleverPv(1);
                    ennemies.positionXProperty().addListener((obs, old, nouv) -> {
                        defense.rotateImage((Double) nouv, ennemies.getPositionY());
                    });
                    ennemies.positionYProperty().addListener((obs, old, nouv) -> {
                        defense.rotateImage(ennemies.getPositionX(), (Double) nouv);
                    });
                }
            }
        }
    }

    public void tousAvancent () {
        for (int i = 0; i < getEnnemisList().size(); i++) {
            getEnnemisList().get(i).avance();
        }
    }

    public void sontMorts () {
        for (int i = getEnnemisList().size() - 1; i >= 0; i--) {
            Ennemis a = getEnnemisList().get(i);
            if (a.estMort()) {
                System.out.println("mort de : " + a);
                getEnnemisList().remove(i);
            }
        }
    }


    int nbenn, lop;
    public void vague () {
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