module com.pirateswarriors.pirateswarriors {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;


    opens com.pirateswarriors to javafx.fxml;
    exports com.pirateswarriors;
    exports com.pirateswarriors.controller;
    opens com.pirateswarriors.controller to javafx.fxml;
}