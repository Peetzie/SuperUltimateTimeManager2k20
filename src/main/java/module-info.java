module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.Visuals to javafx.fxml;
    exports org.Visuals;
}