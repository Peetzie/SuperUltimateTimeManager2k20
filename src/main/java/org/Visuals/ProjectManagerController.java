package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import org.Backend.Main;
import org.Backend.Project;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProjectManagerController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getManagerProjects());

    @FXML
    private Label pmCurrentUser;

    @FXML
    private ChoiceBox pmSelectProject;

    @FXML
    private ChoiceBox<?> pmSetProjectStatus;

    @FXML
    private ChoiceBox<?> pmNewProjectManager;

    @FXML
    private ChoiceBox<?> pmAssignEmployeeToProject;

    @FXML
    private ChoiceBox<?> pmOtherOptions;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
       Launcher.setRoot("userScreen");
    }

    @FXML
    void confirmButtonHandler(ActionEvent event) {


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Helper.setText(pmCurrentUser, Main.getCurrentUser()+"");
        pmSelectProject.setItems(projectList);



    }
}
