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
import org.Backend.Project;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PMRemoveActivityController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().
            get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<Activity> activityList;


    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmChooseProject;

    @FXML
    private ChoiceBox<Activity> pmChooseActivity;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @FXML
    void removeButtonHandler(ActionEvent event) throws IOException {
        Main.command("removeactivity " + Main.getProjects().indexOf(pmChooseProject.getValue().getProject()) + " " +
                pmChooseProject.getValue().getProject().getActivities().indexOf(pmChooseActivity.getValue()));
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
        pmChooseProject.setItems(projectList);
        pmChooseProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                activityList = FXCollections.observableArrayList(pmChooseProject.getValue().getProject().getActivities());
                pmChooseActivity.setItems(activityList);
            }
        });

    }
}
