module fr.montreuil.iut.pirateswarriors {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.media;
    requires junit;


    opens fr.montreuil.iut.pirateswarriors to javafx.fxml;
    exports fr.montreuil.iut.pirateswarriors;
    exports fr.montreuil.iut.pirateswarriors.controller;
    opens fr.montreuil.iut.pirateswarriors.controller to javafx.fxml;

    exports fr.montreuil.iut.pirateswarriors.model;
    opens fr.montreuil.iut.pirateswarriors.model to javafx.fxml;
}