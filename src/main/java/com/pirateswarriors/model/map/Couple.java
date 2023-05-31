package com.pirateswarriors.model.map;

import java.util.Objects;

public class Couple {
    private int x, y;

    public Couple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couple couple = (Couple) o;
        return x == couple.x && y == couple.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
