package com.pirateswarriors.model.ennemies;

import com.pirateswarriors.model.map.BFS;
import com.pirateswarriors.model.map.Couple;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CarteModele {


    private int obj = 83;
    private int route = 84;

    public static void main(String[] args) {
        CarteModele c = new CarteModele("newMap1.csv");
        c.getTabCarte();
        c.getPosition(6, 0);
        BFS test = new BFS(c, new Couple(1, 19));
        System.out.println(test.cheminVersSource());
    }

    // Nombre de ligne de la map
    public final int ROWS_MAP = 20;

    // Nombre de colonne de la map
    public final int COLUMNS_MAP = 12;

    int[][] tabCarte = new int[COLUMNS_MAP][ROWS_MAP];

    public CarteModele(String fileCsv){
        this.genererMap(fileCsv);

    }

    public int[][] getTabCarte() {
        return tabCarte;

    }

    public Set<Couple> getadjacents(int i, int j){
        //System.out.println(tabCarte[i][j]);
        Set<Couple> ads = new HashSet<Couple>(4);
        if((i+1) != COLUMNS_MAP) {
            Couple h = new Couple(i + 1, j);
            if(getPosition(h.getX(),h.getY()) == obj || getPosition(h.getX(),h.getY()) == route || getPosition(h.getX(),h.getY()) == 82) {
                ads.add(h);
            }
        }
        if((i-1) != -1) {
            Couple b = new Couple(i - 1, j);
            if(getPosition(b.getX(), b.getY()) == obj || getPosition(b.getX(), b.getY()) == route || getPosition(b.getX(), b.getY()) == 82) {
                ads.add(b);
            }
        }
        if((j-1) != -1) {
            Couple g = new Couple(i, j - 1);
            if(getPosition(g.getX(),g.getY()) == obj || getPosition(g.getX(),g.getY()) == route || getPosition(g.getX(),g.getY()) == 82) {
                ads.add(g);
            }
        }
        if((j+1) != ROWS_MAP) {
            Couple d = new Couple(i, j + 1);
            if(getPosition(d.getX(),d.getY()) == obj || getPosition(d.getX(),d.getY()) == route || getPosition(d.getX(),d.getY()) == 82) {
                ads.add(d);
            }
        }
        return ads;
    }


    public int getPosition(int i, int j){
        System.out.println(tabCarte[i][j]);
        return tabCarte[i][j];
    }

    public void genererMap(String fileCsvName) {

        try {
            // Overture du fichier CSV
            BufferedReader file = new BufferedReader(new FileReader("assets/MapCSV/" + fileCsvName));



            // Boucle pour parcourir chaque ligne
            Scanner scanner = new Scanner(file);
            int i =0 ;
            int[][] tabValues = new int[COLUMNS_MAP][ROWS_MAP];
            while (scanner.hasNextLine()) {

                // Récuperation de la ligne
                String line = scanner.nextLine();

                // Transforme la ligne en tableau
                String[] values = line.split(",");

                for(int j = 0; j < values.length; j++){
                    tabValues[i][j] = Integer.parseInt(values[j]);
                }
                i++;
            }

            System.out.println(tabValues);

            for(int k =0; k< tabValues.length; k++){
                for (int l = 0; l<tabValues.length; l++){
                    System.out.print(tabValues[k][l] + " ");
                }
                System.out.println();
            }

            this.tabCarte = tabValues;
            // Ferme le scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvée");
        }


    }


}
