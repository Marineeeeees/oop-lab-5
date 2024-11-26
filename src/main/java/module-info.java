module com.example.mvc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires static lombok;

    opens com.example.mvc to javafx.fxml;
    exports com.example.mvc;
    exports com.example.mvc.controllers;
    opens com.example.mvc.controllers to javafx.fxml;
}