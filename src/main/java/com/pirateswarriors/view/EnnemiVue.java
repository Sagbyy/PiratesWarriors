package com.pirateswarriors.view;


import com.pirateswarriors.Ennemis;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EnnemiVue {


    private ImageView imageEnnemi;


    public EnnemiVue(Ennemis ennemi) {

        Image image = ennemi.getImage() ;
        //imageBateau.setImage(image);
        imageEnnemi = new ImageView(image);



    }

    public ImageView getImageBateau() {
        return imageEnnemi;
    }
}
