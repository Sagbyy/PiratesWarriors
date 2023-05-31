package com.pirateswarriors.view;

import com.pirateswarriors.model.PorteMonnaie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PorteMonnaieVue {
    private ImageView imgPorteMonnaie;

    public PorteMonnaieVue(PorteMonnaie porteMonnaie){
        Image image = new Image("porteMonnaie.png");
        imgPorteMonnaie = new ImageView(image);
    }

    public ImageView getImgPorteMonnaie() {
        return imgPorteMonnaie;
    }
}
