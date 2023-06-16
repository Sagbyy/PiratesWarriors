package com.pirateswarriors.model;

public class Tresor {
    private int pv;

    public Tresor(int pv){
        this.pv = pv;
    }

    //recuperer les pv du tresor
    public int getPv(){
        return this.pv;
    }

    public void damage (int damage){
        this.pv -= damage;
        if (pv <= 0){
            pv =0;
        }
    }
    public boolean estPasDetruit(){
        return pv > 0;
    }

}
