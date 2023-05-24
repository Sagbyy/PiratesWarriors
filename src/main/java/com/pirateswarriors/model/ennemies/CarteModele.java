package com.pirateswarriors.model.ennemies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CarteModele {


    public static void main(String[] args) {
        CarteModele c = new CarteModele("PiratesWarriorTIles_Couche1.csv");
        c.getTabCarte();
        c.getPosition(2, 29);
    }

    // Nombre de ligne de la map
    public final int ROWS_MAP = 30;

    // Nombre de colonne de la map
    public final int COLUMNS_MAP = 20;

    int[][] tabCarte = new int[COLUMNS_MAP][ROWS_MAP];

    public CarteModele(String fileCsv){
        this.genererMap(fileCsv);

    }

    public int[][] getTabCarte() {
        return tabCarte;

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
