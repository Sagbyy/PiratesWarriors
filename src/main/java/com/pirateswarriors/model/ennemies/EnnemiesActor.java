package com.pirateswarriors.model.ennemies;

public abstract class EnnemiesActor {
    private int pv;
    private int degatAttaque;
    private int vitesse;
    private double pourcentageSpawn;
    private int mancheSpawn;

    public EnnemiesActor(int pv, int degatAttaque, int vitesse, double pourcentageSpawn, int mancheSpawn) {
        this.pv = pv;
        this.degatAttaque = degatAttaque;
        this.vitesse = vitesse;
        this.pourcentageSpawn = pourcentageSpawn;
        this.mancheSpawn = mancheSpawn;
    }
}