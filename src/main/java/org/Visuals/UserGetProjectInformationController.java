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

public class UserGetProjectInformationController implements Initializable {//Gets info of selected project
    ObservableList<Project> projectList = FXCollections.observableArrayList(Main.getProjects());
    ObservableList<ProjectEmployeeRelation> employeeList;
    ObservableList<Activity> activitiesList;

    @FXML
    private Label currentPM;

    @FXML
    private Label projectDeadline;

    @FXML
    private ChoiceBox<Project> selectProject;

    @FXML
    private Label currentProjectStatus;

    @FXML
    private ListView<ProjectEmployeeRelation> projectBoundEmployees;

    @FXML
    private ListView<Activity> projectActivities;

    @FXML
    void backButtonHandler(ActionEvent event) throws IOException {//takes user back to the menu.
        Launcher.setRoot("User/userScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// Init project selecter
        selectProject.setItems(projectList);
        selectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {//Updates other info on screen depending on project selcted
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                HelperMethods.setTextDependingOnProjectStatus(selectProject.getValue(), currentProjectStatus); // updates label for project status
                Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
                employeeList = FXCollections.observableArrayList(selectProject.getValue().getEmployeeRelations()); // gets assigned employees
                projectBoundEmployees.setItems(employeeList);  // adds them to bound employee list
                currentPM.setText(selectProject.getValue().getProjectManager().toString()); // add project managers to lsit
                HelperMethods.dateTostring(selectProject.getValue().getDeadline(), projectDeadline); // get string date of deadline
                activitiesList = FXCollections.observableArrayList(selectProject.getValue().getActivitiesReal()); // Find and add activities to the list.
                projectActivities.setItems(activitiesList);
            }
        });
    }
}
