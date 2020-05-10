package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.Backend.Main;
import org.Backend.Project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminRemoveProjectController implements Initializable {
    ObservableList<Project> projects = FXCollections.observableArrayList(Main.getProjects());

    @FXML
    private ChoiceBox<Project> removeProject;

    @FXML
    void confirmButtonHandler(ActionEvent event) throws IOException {
        Main.command("removeproject "+Main.getProjects().indexOf(removeProject.getValue()));
        Launcher.setRoot("Admin/adminScreen");
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("Admin/adminScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        removeProject.setItems(projects);
    }
}
