package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import org.Backend.Employee;
import org.Backend.Main;
import org.Backend.Project;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaveProjectController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getprojectRelations());

    @FXML
    private ChoiceBox leaveProjectChooseProject;

    @FXML
    private Button leaveProjectConfirm;

    @FXML
    private Button leaveProjectCancelButton;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("userScreen");

    }

    @FXML
    void confirmButtonHandler(ActionEvent event) throws IOException {
        Main.command("leaveproject " + Main.getProjects().indexOf(leaveProjectChooseProject.getValue()));
        Launcher.setRoot("userScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        leaveProjectChooseProject.setItems(projectList);
    }
}
