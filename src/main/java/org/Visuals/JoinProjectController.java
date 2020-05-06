package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import org.Backend.Employee;
import org.Backend.Main;
import org.Backend.Project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JoinProjectController implements Initializable {
    ObservableList<Project> projectList = FXCollections.observableArrayList(Main.getProjects());

    @FXML
    private ChoiceBox joinProjectProjectChooser;

    @FXML
    private Button joinProjectCancelButton;

    @FXML
    private Button joinProjectJoinButton;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("userScreen");

    }

    @FXML
    void joinButtonHandler(ActionEvent event) throws IOException {
        Main.command("joinproject " +  Main.getProjects().indexOf(joinProjectProjectChooser.getValue()));
        Launcher.setRoot("userScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        joinProjectProjectChooser.setItems(projectList);
    }
}
