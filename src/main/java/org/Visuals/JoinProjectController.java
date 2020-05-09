package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import org.Backend.Main;
import org.Backend.Project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JoinProjectController implements Initializable {//controller for join project scene
    ObservableList<Project> projectList = FXCollections.observableArrayList(Main.getProjects());
    //id for scene elements
    @FXML
    private ChoiceBox joinProjectProjectChooser;

    @FXML
    void joinButtonHandler(ActionEvent event) throws IOException {//button for joining a project and returns the to the user interface
        Main.command("joinproject " +  Main.getProjects().indexOf(joinProjectProjectChooser.getValue()));
        Launcher.setRoot("User/userScreen");
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//takes user back to user interface without joining project
        Launcher.setRoot("User/userScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for join project interface
        joinProjectProjectChooser.setItems(projectList);
    }
}
