module com.example.helloworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.helloworld to javafx.fxml;
    exports com.example.helloworld;
}