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
import org.Backend.Project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AdminAssignProjectManagerController implements Initializable { // Controller for assigning project manager
    ObservableList<Employee> userList = FXCollections.observableArrayList(Main.getEmployeesReal());
    ObservableList<Project> projectList = FXCollections.observableArrayList(Main.getProjects());


    @FXML
    private ChoiceBox selectEmployee;

    @FXML
    private ChoiceBox selectProject;

    @FXML
    void assignButtonHandler(ActionEvent event) { // connects to backend and assignes pm of the selected values of the drop down menus.
        Main.command("assignpm " + Main.getProjects().indexOf(selectProject.getValue()) + " "
                + Main.getEmployees().indexOf(selectEmployee.getValue()));

    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//Takes the user back to the admin screen.
        Launcher.setRoot("Admin/adminScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // initiializing values for drop downs ans scene is loaded.
        selectEmployee.setItems(userList);
        selectProject.setItems(projectList);


    }
}
