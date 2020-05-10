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
import org.Backend.ProjectEmployeeRelation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class adminAssignProjectManagerController implements Initializable { // Controller for assigning project manager
    ObservableList<Employee> userList = FXCollections.observableArrayList(Main.getEmployeesReal());
    ObservableList<Project> projectList = FXCollections.observableArrayList(Main.getProjects());

    @FXML
    private Label adminAssignPMCurrentUser;

    @FXML
    private ChoiceBox adminAssignProjectManagerSelectEmployee;

    @FXML
    private ChoiceBox adminAssignProjectManagerSelectProject;

    @FXML
    void assignButtonHandler(ActionEvent event) { // connects to backend and assignes pm of the selected values of the drop down menus.
        Main.command("assignpm " + Main.getProjects().indexOf(adminAssignProjectManagerSelectProject.getValue()) + " "
                + Main.getEmployees().indexOf(adminAssignProjectManagerSelectEmployee.getValue()));

    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//Takes the user back to the admin screen.
        Launcher.setRoot("Admin/adminScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // initiializing values for drop downs ans scene is loaded.
        Helper.setText(adminAssignPMCurrentUser,Main.getCurrentUser()+"");
        adminAssignProjectManagerSelectEmployee.setItems(userList);
        adminAssignProjectManagerSelectProject.setItems(projectList);


    }
}
