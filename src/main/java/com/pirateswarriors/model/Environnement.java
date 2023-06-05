package com.pirateswarriors.model;

import com.pirateswarriors.Defense;
import com.pirateswarriors.Ennemis;
import com.pirateswarriors.model.ennemies.PackEnnemis.BarqueCanon;
import com.pirateswarriors.model.ennemies.PackEnnemis.PirateFusil;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Environnement {

    private ArrayList<Ennemis> ennemis;
    private ArrayList<Defense> defenses;
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
        this.ennemis= new ArrayList<>();
        this.defenses= new ArrayList<>();
        this.ennemisBack = new ArrayList<>();
        this.nbEnnemis = 0;
    }

    public ArrayList<Ennemis> getEnnemis() {
        return ennemis;
    }

    public void ajouter(Ennemis a){
        this.ennemis.add(a);
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
                this.ennemis.add(new BarqueCanon());
            }
            if (rand == 2) {
                this.ennemis.add(new PirateFusil());
            }
        }
    }


    public void untour () {
        if (ennemis.size() == 0) {
            this.nbEnnemis += 10;
            vague();

        }

                vague();
                tousAvancent();
                sontMorts();
            }

            public void tousAvancent () {
                for (int i = 0; i < getEnnemis().size(); i++) {
                    getEnnemis().get(i).avance();
                }
            }

            public void sontMorts () {
                for (int i = getEnnemis().size() - 1; i >= 0; i--) {
                    Ennemis a = getEnnemis().get(i);
                    if (a.estMort()) {
                        System.out.println("mort de : " + a);
                        getEnnemis().remove(i);
                    }
                }
            }


            int nbenn, lop;
            public void vague () {
                if (!(nbenn == getNbEnnemis())) {
                    if (lop % 75 == 0) {
                        int rand = (int) (Math.random() * 2) + 1;
                        if (rand == 1) {
                            getEnnemis().add(new BarqueCanon());
                        }
                        if (rand == 2) {
                            getEnnemis().add(new PirateFusil());
                        }
                        nbenn++;
                    }

                }
                lop = lop + (int) (Math.random() * 3) + 1;

            }

        }
