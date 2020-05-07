package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import org.Backend.Employee;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/***
 * get project list with projects that have not yet been given a project manager.
 ***/

public class adminAssignProjectManagerController implements Initializable {
    ObservableList<Employee> userList = FXCollections.observableArrayList(Main.getEmployees());
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getprojectRelations());

    @FXML
    private Label adminAssignPMCurrentUser;

    @FXML
    private ChoiceBox adminAssignProjectManagerSelectEmployee;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> adminAssignProjectManagerSelectProject;

    @FXML
    void assignButtonHandler(ActionEvent event) {
        Main.command("assignpm " + Main.getProjects().indexOf(adminAssignProjectManagerSelectProject.getValue().getProject()) + " " + Main.getEmployees().indexOf(adminAssignProjectManagerSelectEmployee.getValue()));

    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("adminScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminAssignProjectManagerSelectEmployee.setItems(userList);
        adminAssignProjectManagerSelectProject.setItems(projectList);


    }
}
