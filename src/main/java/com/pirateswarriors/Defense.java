package com.pirateswarriors;

import com.pirateswarriors.model.Environnement;
import javafx.beans.property.IntegerProperty;

public class Defense {
    private int pts_vie; // Points de vie de la defense
    private int pts_attaque; // Valeur de l'attaque de l'ennemi
    private IntegerProperty x,y; // Position
    private String id;
    private int portée; // Portée des attaques
    protected Environnement env;
}
