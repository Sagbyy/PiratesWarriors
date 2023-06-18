package fr.montreuil.iut.pirateswarriors.view;

import fr.montreuil.iut.pirateswarriors.model.Tresor;
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
}
