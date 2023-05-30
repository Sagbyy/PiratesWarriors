package com.pirateswarriors.model.defense;

public abstract class DefenseActor {

        private int pv;
        private int vitesse;
        private int prix;

        public DefenseActor(int pv, int vitesse, int prix) {
            this.pv = pv;
            this.vitesse = vitesse;
            this.prix = prix;
        }
}
