package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.Backend.Activity;
import org.Backend.Main;
import org.Backend.Project;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GetProjectInformationController implements Initializable {//Gets info of selected project
    ObservableList<Project> projectList = FXCollections.observableArrayList(Main.getProjects());
    ObservableList<ProjectEmployeeRelation> assignedEmployees;
    ObservableList<Activity> activities;

    @FXML
    private Label adminCurrentProjectManager;

    @FXML
    private Label adMinDeadlineOfProject;

    @FXML
    private ChoiceBox<Project> adminChooseProject;

    @FXML
    private Label adminProjectStatus;

    @FXML
    private ListView<ProjectEmployeeRelation> adminBoundEmployee;

    @FXML
    private ListView<Activity> adminActivities;

    @FXML
    void backButtonHandler(ActionEvent event) throws IOException {//takes user back to the menu.
        Launcher.setRoot("User/userScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// Init project selecter
        adminChooseProject.setItems(projectList);
        adminChooseProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {//Updates other info on screen depending on project selcted
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Helper.projectInfoUI(adminChooseProject.getValue(),adminProjectStatus); // updates label for project status
                Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
                assignedEmployees = FXCollections.observableArrayList(adminChooseProject.getValue().getEmployeeRelations()); // gets assigned employees
                adminBoundEmployee.setItems(assignedEmployees);  // adds them to bound employee list
                adminCurrentProjectManager.setText(adminChooseProject.getValue().getProjectManager().toString()); // add project managers to lsit
                Helper.dateTostring(adminChooseProject.getValue().getDeadline(),adMinDeadlineOfProject); // get string date of deadline
                activities = FXCollections.observableArrayList(adminChooseProject.getValue().getActivitiesReal()); // Find and add activities to the list.
                adminActivities.setItems(activities);
            }
        });
    }
}
