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

public class PMSetActivityStatusController implements Initializable {//Project set activity status controller
    // Init observable lists for drop down menus.
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<String> statusList = FXCollections.observableArrayList("Not begun yet", "In progress","Finished");
    ObservableList<Activity> activities;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmChooseProject;

    @FXML
    private ChoiceBox<Activity> pmChooseActivity;

    @FXML
    private ChoiceBox<String> pmChooseStatus;

    @FXML
    void setButtonHandler(ActionEvent event) throws IOException {// Connect set button depending on what status selected with the backend and change scene back to project manager.
        if(pmChooseProject.getValue() !=null && pmChooseActivity.getValue() !=null && ("Not begun yet").equals(pmChooseStatus.getValue())){
            Main.command("setactivitystatus " + Main.getProjects().indexOf(pmChooseProject.getValue().getProject()) + " " + Main.getProjects().get(Main.getProjects().indexOf(pmChooseProject.getValue().getProject())).getActivities().indexOf(pmChooseActivity.getValue()) + " 0");
        }else if (pmChooseProject.getValue() !=null && ("In progress").equals(pmChooseStatus.getValue())) {
            Main.command("setactivitystatus " + Main.getProjects().indexOf(pmChooseProject.getValue().getProject()) + " " + Main.getProjects().get(Main.getProjects().indexOf(pmChooseProject.getValue().getProject())).getActivities().indexOf(pmChooseActivity.getValue()) + " 1");
        } else if (pmChooseProject.getValue() !=null && ("Finished").equals(pmChooseStatus.getValue())) {
            Main.command("setactivitystatus " + Main.getProjects().indexOf(pmChooseProject.getValue().getProject()) + " " + Main.getProjects().get(Main.getProjects().indexOf(pmChooseProject.getValue().getProject())).getActivities().indexOf(pmChooseActivity.getValue()) + " 2");
        }
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");

    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {// Takes the user back to the previous screen (project manager screen)
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//Adds item to the dropdowns, via the observable lists.
        pmChooseStatus.setItems(statusList);
        pmChooseProject.setItems(projectList);
        pmChooseProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {//depeending on the chose project, get the activities.
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                activities = FXCollections.observableArrayList(pmChooseProject.getValue().getProject().getActivitiesReal());
                pmChooseActivity.setItems(activities);
            }
        });






    }
}
