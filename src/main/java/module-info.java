module crud.sistemacrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires java.desktop;

    opens controllers to javafx.fxml;
    exports controllers;

    opens model.entities.enums to javafx.fxml;
    exports model.entities.enums;

    opens views to javafx.fxml;
    exports views;
}