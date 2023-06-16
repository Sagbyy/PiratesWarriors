//package com.pirateswarriors.model;
//
//import com.pirateswarriors.controller.ControllerViewChoixMap;
//import com.pirateswarriors.model.Ennemis.Ennemis;
//import com.pirateswarriors.view.TresorVue;
//import javafx.scene.layout.Pane;
//import org.junit.Test;
//
//import javax.sound.sampled.Port;
//
//import static org.junit.Assert.*;
//
//public class EnvironnementTest {
//
//
//    @Test
//    public void testSelectionMap() {
//        // Create an instance of Environnement
//        Environnement environnement = new Environnement(null, new Pane(), new PorteMonnaie());
//
//        // Test selecting map 1
//        ControllerViewChoixMap.setMap(1);
//        assertEquals("map1.csv", environnement.SelectionMap());
//
//        // Test selecting map 2
//        ControllerViewChoixMap.setMap(2);
//        assertEquals("map2.csv", environnement.SelectionMap());
//
//        // Test selecting map 3
//        ControllerViewChoixMap.setMap(3);
//        assertEquals("map3.csv", environnement.SelectionMap());
//
//        // Test selecting invalid map
//        ControllerViewChoixMap.setMap(4);
//        assertEquals(null, environnement.SelectionMap()); // Or specify an expected value for an invalid map
//    }
//}
