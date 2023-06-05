package com.pirateswarriors.view;


import com.pirateswarriors.Ennemis;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnnemiVue {

    private ImageView imageEnnemi;
    private Image image;
    private Label labelPv;
    private Pane paneCentrale;

    public EnnemiVue(Ennemis ennemi, Pane paneCentrale) {
        this.image = ennemi.getImage() ;
        //imageBateau.setImage(image);
        imageEnnemi = new ImageView(image);
        this.labelPv = new Label("PV : " + ennemi.getPts_vie());
        ennemi.getPts_vieProperty().addListener((obs, old, nouv) -> {
            this.labelPv.setText("PV : " + nouv);
        });
        ennemi.positionXProperty().addListener((obs, old, nouv) -> {
            this.labelPv.setLayoutX((Double) nouv + 15);
        });
        ennemi.positionYProperty().addListener((obs, old, nouv) -> {
            this.labelPv.setLayoutY((Double) nouv);
        });
        this.paneCentrale = paneCentrale;
        this.paneCentrale.getChildren().addAll(this.imageEnnemi, this.labelPv);
    }

    public ImageView getImageBateau() {
        return imageEnnemi;
    }
}
