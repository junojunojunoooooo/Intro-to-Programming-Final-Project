module com.example.whywontyouwork {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.whywontyouwork to javafx.fxml;
    exports com.example.whywontyouwork;
}