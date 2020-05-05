module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.Visuals to javafx.fxml;
    exports org.Visuals;
}