package com.pirateswarriors.model.ennemies;

import com.pirateswarriors.model.map.Couple;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CarteModele {


    public static void main(String[] args) {
        CarteModele c = new CarteModele("newMap1.csv");
        c.getTabCarte();
        c.getPosition(2, 29);
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
            if(getPosition(h.getX(),h.getY()) == 148 || getPosition(h.getX(),h.getY()) == 147 || getPosition(h.getX(),h.getY()) == 142) {
                ads.add(h);
            }
        }
        if((i-1) != -1) {
            Couple b = new Couple(i - 1, j);
            if(getPosition(b.getX(), b.getY()) == 148 || getPosition(b.getX(), b.getY()) == 147 || getPosition(b.getX(), b.getY()) == 142) {
                ads.add(b);
            }
        }
        if((j-1) != -1) {
            Couple g = new Couple(i, j - 1);
            if(getPosition(g.getX(),g.getY()) == 148 || getPosition(g.getX(),g.getY()) == 147 || getPosition(g.getX(),g.getY()) == 142) {
                ads.add(g);
            }
        }
        if((j+1) != ROWS_MAP) {
            Couple d = new Couple(i, j + 1);
            if(getPosition(d.getX(),d.getY()) == 148 || getPosition(d.getX(),d.getY()) == 147 || getPosition(d.getX(),d.getY()) == 142) {
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
