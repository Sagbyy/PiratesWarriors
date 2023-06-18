package fr.montreuil.iut.pirateswarriors.model.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarteModeleTest {

    private CarteModele carteModele;

    @BeforeEach
    void lancement() {
        carteModele = new CarteModele("map1.csv");
    }

    @Test
    void testGetadjacents() {
        Set<Couple> adjacents = carteModele.getadjacents(11, 22);
        assertEquals(1, adjacents.size());
    }

    @Test
    void testGetPosition() {
        int position = carteModele.getPosition(11, 22);
        assertEquals(53, position);
    }

    @Test
    void testIsRedZone() {
        boolean isRedZone = carteModele.isRedZone(100, 100);
        assertTrue(isRedZone);
    }

    @Test
    void testGenererMap() {
        carteModele.genererMap("map1.csv");
    }
}
