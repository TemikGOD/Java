module com.example.clockshop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.clockshop to javafx.fxml;
    exports com.example.clockshop;
}