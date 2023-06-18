package fr.montreuil.iut.pirateswarriors.view;


import fr.montreuil.iut.pirateswarriors.model.Ennemis.Ennemis;
import fr.montreuil.iut.pirateswarriors.model.Ennemis.PackEnnemis.*;
import fr.montreuil.iut.pirateswarriors.model.Ennemis.PackEnnemis.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EnnemiVue {

    private ImageView imageEnnemi;
    private Image image;
    private Ennemis ennemis;
    private ProgressBar progressHealth;

    /**
     * Constructeur de la classe EnnemiVue
     */
    public EnnemiVue(Ennemis ennemi) {
        this.ennemis = ennemi;

        // Progress Health
        this.progressHealth = new ProgressBar();
        this.progressHealth.setPrefWidth(50);
        this.progressHealth.setStyle("-fx-accent: red;");
        this.progressHealth.setProgress(1);

        this.ennemis.pts_vieProperty().addListener((obs, old, nouv) -> {
            this.progressHealth.setProgress((double) this.ennemis.getPts_vie() / this.ennemis.getPvEntier());
        });

        this.ennemis.positionXProperty().addListener((obs, old, nouv) -> {
            this.progressHealth.setLayoutX(this.getMiddlePostionX() - 20);
            this.progressHealth.setLayoutY(this.getMiddlePostionY() - 70);
        });

        this.ennemis.positionYProperty().addListener((obs, old, nouv) -> {
            this.progressHealth.setLayoutX(this.getMiddlePostionX() - 20);
            this.progressHealth.setLayoutY(this.getMiddlePostionY() - 70);
        });

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
        this.progressHealth.setId(ennemi.getId());
    }


    /**
     *Getter et Setter
     */
    public ProgressBar getProgressHealth() {
        return this.progressHealth;
    }
    public ImageView getImageBateau() {
        return imageEnnemi;
    }
    public double getMiddlePostionX() {return this.ennemis.getPositionX() + this.image.getWidth() / 2;}
    public double getMiddlePostionY() {
        return this.ennemis.getPositionY() + this.image.getHeight() / 2;
    }
}
