package com.pirateswarriors.model.ennemies;

import com.pirateswarriors.view.EnnemiVue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;

public class PositionListener implements ChangeListener<String> {

    private EnnemiVue ennemiVue;

    public PositionListener(EnnemiVue ennemiVue) {
        this.ennemiVue = ennemiVue;
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

        if(t1.equals("b")){
            ennemiVue.getImageBateau().rotateProperty().setValue(270);
        }
        if(t1.equals("g")){
            ennemiVue.getImageBateau().rotateProperty().setValue(0);
        }
        if(t1.equals("h")){
            ennemiVue.getImageBateau().rotateProperty().setValue(90);
        }
    }
}
