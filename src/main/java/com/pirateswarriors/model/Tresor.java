package com.pirateswarriors.model;

import com.pirateswarriors.model.ennemies.Ennemis;
import com.pirateswarriors.model.ennemies.Ennemis;
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

//    public boolean ennemiProche(){
//        double distanceX = Math.abs(this.ennemis.getPositionX() - this.imgTresor.getX());
//        System.out.println("distanceX: " + distanceX);
//        double distanceY = Math.abs(this.ennemis.getPositionY() - this.imgTresor.getY());
//
//        // Calcul de la distance entre l'ennemi et le trésor
//        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
//        System.out.println("distance: " + distance);
//        double maxDistance = 800;
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
