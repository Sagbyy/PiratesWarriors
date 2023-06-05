package com.pirateswarriors.view;

import com.pirateswarriors.model.Tresor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TresorVue {
    private ImageView imgTresor;

    public TresorVue(Tresor tresor){
            Image image = new Image("chest1.png");
            //imageBateau.setImage(image);
            imgTresor = new ImageView(image);



    }

    public ImageView getImgTresor(){
        return imgTresor;
    }

    //remplacement image
//    public ImageView imgTresorDetruit(){
//        Image image2 = new Image("chest2.png");
//        ImageView image2View = new ImageView(image2);
//        return image2View;
//    }
}
