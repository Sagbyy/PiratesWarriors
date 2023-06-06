package com.pirateswarriors.model.map;

import com.pirateswarriors.model.ennemies.CarteModele;

import java.util.*;

public class BFS {
    private CarteModele g;

    private Couple source, objectif;

    private ArrayList<Couple> parcours;

    private int x, y;
    private Map<Couple, Couple> predecesseurs;

    public BFS(CarteModele g){
        this.g = g;
        this.source = new Couple(3, 24) ;
        this.objectif = new Couple(6, 0);
        parcours = new ArrayList<Couple>();
        predecesseurs = new HashMap<Couple, Couple>();
        algoBFS();
    }

    private void algoBFS() {
        LinkedList<Couple> fifo = new LinkedList<>();
        Couple s = this.source;
        predecesseurs.put(s, null);
        System.out.println("test"+predecesseurs);
        parcours.add(s);
        fifo.add(s);

        while(!fifo.isEmpty()){
            //System.out.println(predecesseurs);
            s = fifo.remove();
            //System.out.println(fifo);
            for(Couple t : g.getadjacents(s.getX(), s.getY())){

                //while(!estDedans(this.objectif, parcours)) {
                //System.out.println("test");
                //(g.getPosition(t.getX(), t.getY()) == 148)
                if (!estDedans(this.objectif, parcours)){
                    if (!parcours.contains(t)) {
                        predecesseurs.put(t, s);
                        parcours.add(t);
                        fifo.add(t);
                        //System.out.println(predecesseurs);
                    }
                }
                //}
            }
        }


    }

    public Couple getObjectif() {
        return objectif;
    }

    public static void main(String[] args) {

        //gBfs test = new Bfs()
    }

    public boolean estDedans(Couple c, ArrayList<Couple> list){
        for(int i = 0; i< list.size(); i++){
            if(list.get(i) == c){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Couple> cheminVersSource() {
        ArrayList<Couple> chemin = new ArrayList<>();
        chemin.add(this.source);
        System.out.println(predecesseurs);
        Couple courant = predecesseurs.get(this.objectif);

        chemin.add(courant);
        while(!courant.equals(source)){
            courant = predecesseurs.get(courant);
            chemin.add(courant);
        }
        Collections.reverse(chemin);
        return chemin;
    }
}
