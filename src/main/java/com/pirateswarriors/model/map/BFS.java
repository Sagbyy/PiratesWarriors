package com.pirateswarriors.model.map;

import java.util.*;

public class BFS {

    private CarteModele g;
    private Couple source, objectif;
    private ArrayList<Couple> parcours;
    private Map<Couple, Couple> predecesseurs;

    /**
     * Constructeur de la class BFS
     *  - Prend en argument un modèle de carte et un spawn (apparition)
     */
    public BFS(CarteModele g, Couple spawn){
        this.g = g;
        this.source = spawn ;
        this.objectif = new Couple(6, 0);
        parcours = new ArrayList<Couple>();
        predecesseurs = new HashMap<Couple, Couple>();
        algoBFS();
    }

    /**
     * Méthode algoBFS()
     *  - Parcours les routes en commençant par explorer un nœud source,
     *  puis ses successeurs, puis les successeurs non explorés des successeurs
     */
    private void algoBFS() {
        LinkedList<Couple> fifo = new LinkedList<>();
        Couple s = this.source;
        predecesseurs.put(s, null);
        parcours.add(s);
        fifo.add(s);
        while(!fifo.isEmpty()){
            s = fifo.remove();
            for(Couple t : g.getadjacents(s.getX(), s.getY())){
                if (!parcours.contains(this.objectif)){
                    if (!parcours.contains(t)) {
                        predecesseurs.put(t, s);
                        parcours.add(t);
                        fifo.add(t);
                    }
                }
            }
        }
    }

    /**
     * Méthode cheminVersSource()
     *  - Calcule un chemin en partant de l'arrivée jusqu'a la source
     *  - Return le chemin en une Arraylist contenant les cases
     */
    public ArrayList<Couple> cheminVersSource() {
        ArrayList<Couple> chemin = new ArrayList<>();
        chemin.add(this.source);
        Couple courant = predecesseurs.get(this.objectif);
        chemin.add(courant);
        while(!courant.equals(source)){
            courant = predecesseurs.get(courant);
            chemin.add(courant);
        }
        Collections.reverse(chemin);
        return chemin;
    }

    /**
     * Getter
     * @return ArrayList<Couple>
     */
    public ArrayList<Couple> getParcours() {
        return parcours;
    }

    /**
     * Getter
     * @return Map<Couple, Couple>
     */
    public Map<Couple, Couple> getPredecesseurs() {
        return predecesseurs;
    }

}
