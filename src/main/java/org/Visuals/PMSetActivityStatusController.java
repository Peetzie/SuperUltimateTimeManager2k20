package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.Backend.Employee;
import org.Backend.Main;
import org.Backend.Project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PMSetActivityStatusController implements Initializable {
    ObservableList<Project> projects = FXCollections.observableArrayList(Main.getProjects());
    //activity missing
    ObservableList<String> projectStatusList = FXCollections.observableArrayList("Not begun yet", "In progress","Finished");

    @FXML
    private ChoiceBox<?> pmChooseProject;

    @FXML
    private ChoiceBox<?> pmChooseActivity;

    @FXML
    private ChoiceBox<?> pmChooseStatus;

    @FXML
    void setButtonHandler(ActionEvent event) {
        if(pmChooseProject.getValue() !=null && pmChooseActivity.getValue() !=null && ("Not begun yet").equals(pmChooseStatus.getValue())){
            Main.command("setactivitystatus "+Main.getProjects().indexOf(pmChooseProject.getValue())+" "+Main.getProjects().indexOf(pmChooseActivity.getValue())+" 0");
        }else if (pmChooseProject.getValue() !=null && ("In progress").equals(pmChooseStatus.getValue())) {
            Main.command("setactivitystatus "+Main.getProjects().indexOf(pmChooseProject.getValue())+" "+Main.getProjects().indexOf(pmChooseActivity.getValue())+" 1");
        } else if (pmChooseProject.getValue() !=null && ("Finished").equals(pmChooseStatus.getValue())) {
            Main.command("setactivitystatus "+Main.getProjects().indexOf(pmChooseProject.getValue())+" "+Main.getProjects().indexOf(pmChooseActivity.getValue())+" 2");
        }

    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
