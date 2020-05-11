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

public class UserJoinActivityController implements Initializable {//controller for the join acitivity
    // init of dropdown menus.
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getProjectRelations());
    ObservableList<Activity> activityList;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectProject;

    @FXML
    private ChoiceBox<Activity> selectActivity;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//takes the user back to the previous screen, user screen
        Launcher.setRoot("User/userScreen");

    }

    @FXML
    void joinButtonHandler(ActionEvent event) throws IOException {// connects to backend with the join activity, depending on whats chosen.
        Main.command("joinactivity " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " + Main.getProjects().get(Main.getProjects().indexOf(selectProject.getValue().getProject())).getActivities().indexOf(selectActivity.getValue()));
        Launcher.setRoot("User/userScreen");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// init and set values in the drop down menus
        selectProject.setItems(projectList);
        selectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {// depending on what project selected, find the assigned activities to chose from.
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                activityList = FXCollections.observableArrayList(selectProject.getValue().getProject().getActivitiesReal());
                selectActivity.setItems(activityList);
            }
        });
    }
}
