package com.pirateswarriors.model.Ennemis;

import com.pirateswarriors.model.map.Couple;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class CarteModele {

    // Nombre de ligne de la map
    public final int ROWS_MAP = 25;

    // Nombre de colonne de la map
    public final int COLUMNS_MAP = 12;
    public final int TILE_SIZE = 64;
    private int[] greenZone;

    int[][] tabCarte = new int[COLUMNS_MAP][ROWS_MAP];

    /**
     * Constructeur de la class CarteModele
     */
    public CarteModele(String fileCsv){
        this.genererMap(fileCsv);
        this.greenZone = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 128, 129, 130, 131, 133, 160, 161, 162, 163, 164, 165, 235, 236, 237, 238, 239, 240};
    }



    /**
     * Méthode getadjacents()
     *   - Prend en argument un i et un j correspondant à une position sur la map
     *   - Regarde si les cases adjcentes sont des cases disponible pour etre parcourus
     *   - Return un Set des adjacents disponibles
     */
    public Set<Couple> getadjacents(int i, int j){
        Set<Couple> ads = new HashSet<Couple>(4);
        if((i+1) != COLUMNS_MAP) {
            Couple h = new Couple(i + 1, j);
            if(getPosition(h.getX(),h.getY()) == 132 || getPosition(h.getX(),h.getY()) == 54 || getPosition(h.getX(),h.getY()) == 53 || getPosition(h.getX(),h.getY()) == 131 ) {
                ads.add(h);
            }
        }
        if((i-1) != -1) {
            Couple b = new Couple(i - 1, j);
            if(getPosition(b.getX(), b.getY()) == 132 || getPosition(b.getX(), b.getY()) == 54 || getPosition(b.getX(), b.getY()) == 53 || getPosition(b.getX(),b.getY()) == 131) {
                ads.add(b);
            }
        }
        if((j-1) != -1) {
            Couple g = new Couple(i, j - 1);
            if(getPosition(g.getX(),g.getY()) == 132 || getPosition(g.getX(),g.getY()) == 54 || getPosition(g.getX(),g.getY()) == 53 || getPosition(g.getX(),g.getY()) == 131 ) {
                ads.add(g);
            }
        }
        if((j+1) != ROWS_MAP) {
            Couple d = new Couple(i, j + 1);
            if(getPosition(d.getX(),d.getY()) == 132 || getPosition(d.getX(),d.getY()) == 54 || getPosition(d.getX(),d.getY()) == 53 || getPosition(d.getX(),d.getY()) == 131 ) {
                ads.add(d);
            }
        }
        return ads;
    }


    public int getPosition(int i, int j){
        return tabCarte[i][j];
    }

    public boolean isRedZone(double x, double y) {
        int tabRow = (int) y / TILE_SIZE;
        int tabCol = (int) x / TILE_SIZE;

        for (int i = 0 ; i < greenZone.length; i++) {
            if(greenZone[i] == tabCarte[tabRow][tabCol]) {
                return true;
            }
        }
        return false;

    }

    /**
     * Méthode genererMap(String fileCsvName)
     *   - Prend en argument un String qui correspondra à un fichier CSV
     *   - Parcours le CSV et en fait un tableau à double dimension
     */
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
            this.tabCarte = tabValues;
            // Ferme le scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvée");
        }
    }
}
