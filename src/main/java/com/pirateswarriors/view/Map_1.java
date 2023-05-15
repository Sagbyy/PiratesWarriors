package com.pirateswarriors.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Map_1 extends Map {


    public Map_1(TilePane tilePane) {
        super(tilePane, "PiratesWarriorTIles_Couche1.csv");
    }

    @Override
    public void parametreViewPort(String value, ImageView tile) {
        // Pour chaque valeur du CSV attribuer un tile
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
    }
}