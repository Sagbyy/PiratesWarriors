package com.pirateswarriors.model.map;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Map_1 {
    private TilePane tilePane;

    public static final int TILE_SIZE = 64;
    public static final int HEIGHT_MAP = 30;
    public static final int WIDTH_MAP = 20;

    public Map_1(TilePane tilePane) throws IOException {
        this.tilePane = tilePane;
        this.genererMap();
    }
    public  void genererMap() {
        tilePane.prefHeight(20.0);
        tilePane.prefWidth(30.0);
        try {
        // Overture du fichier
        BufferedReader file = new BufferedReader(new FileReader("assets/PiratesWarriorTIles_Couche1.csv"));

        // TileSet
        Image tileSet = new Image(Objects.requireNonNull(getClass().getResource("tiles_sheet@2.png")).openStream());

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");

            for (String value : values) {
                ImageView tile = new ImageView(tileSet);

                switch (value) {
                    case "131":
                        tile.setViewport(new Rectangle2D(3 * TILE_SIZE, 4 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
                        break;
                    case "272":
                        tile.setViewport(new Rectangle2D(16 * TILE_SIZE, 8 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
                        break;
                    case "148":
                        tile.setViewport(new Rectangle2D(20 * TILE_SIZE, 4 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
                        break;
                    case "142":
                        tile.setViewport(new Rectangle2D(14 * TILE_SIZE, 4 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
                        break;
                    case "135":
                        tile.setViewport(new Rectangle2D(7 * TILE_SIZE, 5 * TILE_SIZE, 7, 5));
                    default:
                        tile.setViewport(new Rectangle2D(0, 10 * TILE_SIZE, TILE_SIZE, TILE_SIZE));
                        break;
                }
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

}