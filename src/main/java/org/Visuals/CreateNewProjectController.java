package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.Backend.Employee;
import org.Backend.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewProjectController implements Initializable {
    ObservableList<Employee> userList = FXCollections.observableArrayList(Main.getEmployees());

    @FXML
    private TextField createProjectTitle;

    @FXML
    private TextArea createProjectDescription;

    @FXML
    private TextField createProjectEstimatedHours;

    @FXML
    private ChoiceBox createProjectProjectManager;

    @FXML
    private Button createNewProjectCreateButton;

    @FXML
    private Button createNewProjectCancelButton;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
          Launcher.setRoot("adminScreen");
    }

    @FXML
    void createButtonHandler(ActionEvent event) throws IOException {
        Main.command("newproject " + createProjectTitle.getText() + " " + createProjectDescription.getText().replace(" ", "_") + " " + Integer.parseInt(createProjectEstimatedHours.getText()));
        if (createProjectProjectManager.getValue() != null){
            Main.command("assignpm " + (Main.getProjects().size()-1) + " " + Main.getEmployees().indexOf(createProjectProjectManager.getValue()));
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert!");
            alert.setContentText("Creating project with out a project manager");
            alert.showAndWait();
        }
        Launcher.setRoot("adminScreen");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createProjectProjectManager.setItems(userList);
    }


}
