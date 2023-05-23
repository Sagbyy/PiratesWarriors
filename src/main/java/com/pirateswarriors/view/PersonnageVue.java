package com.pirateswarriors.view;


import com.pirateswarriors.model.ennemies.Personnage;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PersonnageVue{


    private ImageView imageBateau;


    public PersonnageVue(Personnage personnage) {

        Image image = new Image("ship.png");
        //imageBateau.setImage(image);
        imageBateau = new ImageView(image);



    }

    public ImageView getImageBateau() {
        return imageBateau;
    }
}
