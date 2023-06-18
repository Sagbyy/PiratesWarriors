//package fr.montreui.iut.pirateswarriors.model;
//
//import fr.montreui.iut.pirateswarriors.controller.ControllerViewChoixMap;
//import fr.montreui.iut.pirateswarriors.model.Ennemis.Ennemis;
//import fr.montreui.iut.pirateswarriors.view.TresorVue;
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
//        Environnement environnement = new Environnement(null, new Pane(), new PorteMonnaie());
//
//        ControllerViewChoixMap.setMap(1);
//        assertEquals("map1.csv", environnement.SelectionMap());
//
//        ControllerViewChoixMap.setMap(2);
//        assertEquals("map2.csv", environnement.SelectionMap());
//
//        ControllerViewChoixMap.setMap(3);
//        assertEquals("map3.csv", environnement.SelectionMap());
//
//        ControllerViewChoixMap.setMap(4);
//        assertEquals(null, environnement.SelectionMap());
//    }
//}
