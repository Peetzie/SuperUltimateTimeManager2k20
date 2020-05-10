package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.Backend.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PMAssignActivityController implements Initializable {// Controller for the project manager assign activity
    // load lists for dropdown menus
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<ProjectEmployeeRelation> employees;
    ObservableList<Activity> activities;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmChooseProject;


    @FXML
    private ChoiceBox<Activity> pmChooseActivity;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmChooseEmployee;

    @FXML
    void assignButtonHandler(ActionEvent event) throws IOException {//assignbuttonhandler, connects to backend with the selected information + scene change
        Main.command("assignactivity " + Main.getProjects().indexOf(pmChooseProject.getValue().getProject()) + " " + Main.getProjects().get(Main.getProjects().indexOf(pmChooseProject.getValue().getProject())).getActivities().indexOf(pmChooseActivity.getValue()) + " " + Main.getEmployees().indexOf(pmChooseEmployee.getValue().getEmployee()));
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {// Changes scene to the previous.
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// Initialize methods, with drop downs
        pmChooseProject.setItems(projectList);
        pmChooseProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() { // depending on project get different activites and emplpoyees assigned to the project.
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                activities = FXCollections.observableArrayList(pmChooseProject.getValue().getProject().getActivitiesReal());
                pmChooseActivity.setItems(activities);
                Main.setPrintProjectInformationOnProjectEmployeeRelations(false); // get employee names.
                employees = FXCollections.observableArrayList(pmChooseProject.getValue().getProject().getEmployeeRelations());
                pmChooseEmployee.setItems(employees);
            }
        });



    }
}
