package com.pirateswarriors.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public abstract class Map {
    // Balise TilePane du FXML
    private TilePane tilePane;

    // Taille d'une seule Tile
    public final int TILE_SIZE = 64;

    // Nombre de ligne de la map
    public final int ROWS_MAP = 30;

    // Nombre de colonne de la map
    public final int COLUMNS_MAP = 20;

    public Map(TilePane tilePane, String fileCsvName) {
        this.tilePane = tilePane;
        this.genererMap(fileCsvName);
    }

    public void genererMap(String fileCsvName) {
        // Configure la taille de la map
        tilePane.setPrefColumns(ROWS_MAP);
        tilePane.setPrefRows(COLUMNS_MAP);

        try {
            // Overture du fichier CSV
            BufferedReader file = new BufferedReader(new FileReader("assets/MapCSV/" + fileCsvName));

            // Récuperation de l'image tileset
            Image tileSet = new Image(Objects.requireNonNull(getClass().getResource("tiles_sheet@2.png")).openStream());

            // Boucle pour parcourir chaque ligne
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // Récuperation de la ligne
                String line = scanner.nextLine();

                // Transforme la ligne en tableau
                String[] values = line.split(",");

                // Boucle pour parcourir chaque valeur du tableau de la ligne
                for (String value : values) {
                    // On récupère une ImageView avec le tileset entier
                    ImageView tile = new ImageView(tileSet);

                    // !-- Méthode obligatoire pour faire un switch de condition --!
                    parametreViewPort(value, tile);

                    // Ajoute le ImageView à votre GridPane
                    this.tilePane.getChildren().add(tile);
                }
            }

            // Ferme le scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvée");
        }
        catch (IOException e) {
            System.out.println("Une erreur est survenue avec le scanner...");
        }
    }

    /**
     * Méthode qui permet de mettre seulement un switch pour choisir quel tile choisir pour chaque valeur du CSV
     *
     * @param tile L'imageView de la tile
     * @param value Valeur du CSV
     */
    public abstract void parametreViewPort(String value, ImageView tile);
}
