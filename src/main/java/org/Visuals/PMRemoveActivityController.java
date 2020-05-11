package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.Backend.Activity;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PMRemoveActivityController implements Initializable {// Controller for project manager remove activity.
    // Init dropdowns as observable lists.
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<Activity> activityList;


    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectProject;

    @FXML
    private ChoiceBox<Activity> selectActivity;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//Takes the user to the projectManager Screen.
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @FXML
    void removeButtonHandler(ActionEvent event) throws IOException {// Connects backend with remove button, by removing the activity.
        Main.command("removeactivity " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " +
                selectProject.getValue().getProject().getActivitiesReal().indexOf(selectActivity.getValue()));
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// Setting values in the drop down menus.
        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
        selectProject.setItems(projectList);
        selectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() { // depending on selected project get activites.
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                activityList = FXCollections.observableArrayList(selectProject.getValue().getProject().getActivitiesReal());
                selectActivity.setItems(activityList);
            }
        });

    }
}
