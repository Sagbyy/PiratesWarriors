package com.pirateswarriors.model;

import com.pirateswarriors.Ennemis;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Tresor {
    private int pv;
    private Ennemis ennemis;

    @FXML
    private ImageView imgTresor;

    public Tresor(int pv){
        this.pv = pv;
    }

    //recuperer les pv du tresor
    public int getPv(){
        return this.pv;
    }

    public void damage (int damage){
        this.pv -= damage;
        System.out.println("le tresor à subit " + damage + " dégats !");
        if (pv <= 0){
            pv =0;
        }
    }
    public boolean estPasDetruit(){
        return pv > 0;
    }

//    public void ennemiProche(){
//        double distanceX = Math.abs(ennemis.getPositionX() - imgTresor.getX());
//        double distanceY = Math.abs(ennemis.getPositionY() - imgTresor.getY());
//
//        // Calcul de la distance entre l'ennemi et le trésor
//        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
//        double maxDistance = 30;
//
//        if (distance <= maxDistance) {
//            ennemis.attaque(this);
//            System.out.println("attaque du trésor");
//        }
//        else{
//            return false;
//        }
//
//        if (ennemiProche()){
//            ennemis.attaque(tresor);
//            System.out.println("attaque du trésor");
//        }
//    }
}
