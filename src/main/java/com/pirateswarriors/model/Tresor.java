package com.pirateswarriors.model;

import com.pirateswarriors.Ennemis;

public class Tresor {
    private int pv;
    private Ennemis ennemis;

    public Tresor(int pv){
        this.pv = pv;
    }

    //recuperer les pv du tresor
    public int getPv(){
        return this.pv;
    }

}
