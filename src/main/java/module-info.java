module com.pirateswarriors.pirateswarriors {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pirateswarriors to javafx.fxml;
    exports com.pirateswarriors;
    exports com.pirateswarriors.controller;
    opens com.pirateswarriors.controller to javafx.fxml;
}