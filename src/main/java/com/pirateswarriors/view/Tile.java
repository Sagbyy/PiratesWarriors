package com.pirateswarriors.view;

public class Tile {
    private int id;
    private String image;

    public Tile(int id, String image) {
        this.id = id;
        this.image = image;
    }

    // Getters and Setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
