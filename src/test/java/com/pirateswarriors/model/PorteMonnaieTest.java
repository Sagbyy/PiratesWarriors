package com.pirateswarriors.model;

import com.pirateswarriors.model.PorteMonnaie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PorteMonnaieTest {

    private PorteMonnaie porteMonnaie;

    @BeforeEach
    void lancement() {
        porteMonnaie = new PorteMonnaie();
    }

    @Test
    void testNbProperty() {
        IntegerProperty nbProperty = porteMonnaie.nbProperty();
        assertNotNull(nbProperty);
    }

    @Test
    void testGetNb() {
        int nb = porteMonnaie.getNb();
        assertEquals(0, nb);
    }

    @Test
    void testSetNb() {
        porteMonnaie.setNb(10);
        int nb = porteMonnaie.getNb();
        assertEquals(10, nb);
    }

    @Test
    void testAjoutMonnaie() {
        porteMonnaie.ajoutMonnaie(5);
        int nb = porteMonnaie.getNb();
        assertEquals(5, nb);
    }

    @Test
    void testEnleverMonnaie() {
        porteMonnaie.setNb(10);
        porteMonnaie.enleverMonnaie(3);
        int nb = porteMonnaie.getNb();
        assertEquals(7, nb);
    }

    @Test
    void testArgentVideSiPasVide() {
        porteMonnaie.setNb(500);
        boolean isEmpty = porteMonnaie.argentVide();
        assertFalse(isEmpty);
    }

    @Test
    void testArgentVideSiVide() {
        porteMonnaie.setNb(400);
        boolean isEmpty = porteMonnaie.argentVide();
        assertTrue(isEmpty);
    }
}
