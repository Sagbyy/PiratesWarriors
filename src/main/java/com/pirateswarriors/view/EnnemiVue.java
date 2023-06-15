package com.pirateswarriors.view;


import com.pirateswarriors.model.Ennemis.Ennemis;
import com.pirateswarriors.model.Ennemis.PackEnnemis.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnnemiVue {

    private ImageView imageEnnemi;
    private Image image;
    private Ennemis ennemis;

    /**
     * Constructeur de la classe EnnemiVue
     */
    public EnnemiVue(Ennemis ennemi) {
        this.ennemis = ennemi;

        /**
         * Détermine l'image à associer à l'ennemi selon son type
         */
        if(ennemi instanceof PirateFusil){
            this.image = new Image("piratefusil.png") ;
        }
        else if(ennemi instanceof EmbarcationFortune){
            this.image = new Image("Embarcationfortune.png") ;
        }
        else if(ennemi instanceof BarqueCanon){
            this.image = new Image("barquecanon.png") ;
        }
        else if(ennemi instanceof GrosPirate){
            this.image = new Image("grospirate.png") ;
        }
        else if(ennemi instanceof Voleur){
            this.image = new Image("Voleur.png") ;
        }
        else if(ennemi instanceof GrosNavire){
            this.image = new Image("grosnavire.png") ;
        }

        this.imageEnnemi = new ImageView(image);
        this.imageEnnemi.setId(ennemi.getId()); // Attribut l'iD de l'ennemi à son image
    }


    /**
     *Getter et Setter
     */
    public ImageView getImageBateau() {
        return imageEnnemi;
    }
    public double getMiddlePostionX() {return this.ennemis.getPositionX() + this.image.getWidth() / 2;}
    public double getMiddlePostionY() {
        return this.ennemis.getPositionY() + this.image.getHeight() / 2;
    }
}
