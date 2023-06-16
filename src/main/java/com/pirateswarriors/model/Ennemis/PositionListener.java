package com.pirateswarriors.model.Ennemis;

import com.pirateswarriors.view.EnnemiVue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PositionListener implements ChangeListener<String> {

    private EnnemiVue ennemiVue;

    /**
     * Constructeur de la class PositionListener
     *  - Sert à mettre à jour la position de l'image de l'ennemi selon la direction dans laquelle il va
     */
    public PositionListener(EnnemiVue ennemiVue) {
        this.ennemiVue = ennemiVue;
    }


    /**
     * Méthode changed
     *  - Selon la direction :
     *              haut --> h
     *              bas --> b
     *              gauche --> g
     *    Met à jour le sens de l'image
     */
    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        if(t1.equals("b")){ennemiVue.getImageBateau().rotateProperty().setValue(270);}
        if(t1.equals("g")){ennemiVue.getImageBateau().rotateProperty().setValue(0);}
        if(t1.equals("h")){ennemiVue.getImageBateau().rotateProperty().setValue(90);}
    }
}
