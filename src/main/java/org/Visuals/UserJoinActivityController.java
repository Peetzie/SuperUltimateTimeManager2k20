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

public class UserJoinActivityController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getProjectRelations());
    ObservableList<Activity> activityList;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> chooseProject;

    @FXML
    private ChoiceBox<Activity> chooseActivity;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/userScreen");

    }

    @FXML
    void joinButtonHandler(ActionEvent event) throws IOException {
        Main.command("joinactivity " + Main.getProjects().indexOf(chooseProject.getValue().getProject()) + " " + Main.getProjects().get(Main.getProjects().indexOf(chooseProject.getValue().getProject())).getActivities().indexOf(chooseActivity.getValue()));
        Launcher.setRoot("User/userScreen");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chooseProject.setItems(projectList);
        chooseProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                activityList = FXCollections.observableArrayList(chooseProject.getValue().getProject().getActivitiesReal());
                chooseActivity.setItems(activityList);
            }
        });
    }
}
