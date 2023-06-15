package com.pirateswarriors.view.map;

import javafx.geometry.Rectangle2D;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public abstract class Carte {
    // Balise TilePane du FXML
    private TilePane tilePane;

    // Taille d'une seule Tile
    public final int TILE_SIZE = 64;

    // Nombre de ligne de la map
    public final int ROWS_MAP = 12;

    // Nombre de colonne de la map
    public final int COLUMNS_MAP = 25;

    public Carte(TilePane tilePane) {
        this.tilePane = tilePane;
    }

    public void genererMap(String fileCsvName) {
        // Configure la taille de la map
        tilePane.setPrefColumns(COLUMNS_MAP);
        tilePane.setPrefRows(ROWS_MAP);

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
    public void parametreViewPort(String value, ImageView tile) {
        // Pour chaque valeur du CSV attribuer un tile
        // Récuperation des positions pour zoomer sur la map
        int x = Integer.parseInt(value) / 32;
        int y = Integer.parseInt(value) - 32 * x;

        tile.setViewport(new Rectangle2D(y * TILE_SIZE, x * TILE_SIZE, TILE_SIZE, TILE_SIZE));

        ColorAdjust filter = new ColorAdjust();
        filter.setSaturation(-1);

        tile.setOnMouseEntered(event -> tile.setEffect(filter));

        ColorAdjust originalFilter = new ColorAdjust();
        originalFilter.setSaturation(0);

        tile.setOnMouseExited(event -> tile.setEffect(originalFilter));
    }
}
