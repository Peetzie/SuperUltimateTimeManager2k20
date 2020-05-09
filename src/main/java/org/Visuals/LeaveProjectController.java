package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaveProjectController implements Initializable {//controller for leave project interface
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getProjectRelations());
    //id for scene elements
    @FXML
    private ChoiceBox leaveProjectChooseProject;

    @FXML
    void confirmButtonHandler(ActionEvent event) throws IOException {//button for sending a leave project attempt and takes the user back to user interface
        String string1 = leaveProjectChooseProject.getValue().toString().split(" ")[1];
        string1 = string1.substring(1,string1.length()-1);
        Main.command("leaveproject " + string1);
        Launcher.setRoot("User/userScreen");
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//takes user back to user interface without leaving the project
        Launcher.setRoot("User/userScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for leave project interface
        leaveProjectChooseProject.setItems(projectList);
    }
}
