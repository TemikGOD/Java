module com.example.clockshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.google.gson;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    opens com.example.clockshop to com.google.gson, javafx.fxml, org.hibernate.orm.core;

    exports com.example.clockshop;
}