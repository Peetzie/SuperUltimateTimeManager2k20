package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.Backend.Main;
import org.Backend.Project;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {//controller for user scene
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getProjectRelations());
    ObservableList<Project> totalProjects = FXCollections.observableArrayList(Main.getProjects());
    //id for scene elements
    @FXML
    private Label userScreenCurrentUser;


    @FXML
    private Label inAmmountOfProjects;

    @FXML
    private Label noOfProjects;

    @FXML
    void assignHoursButtonHandler(ActionEvent event) throws IOException {//takes user to assign hours scene
        Launcher.setRoot("User/assignHoursScreen");
    }


    @FXML
    void userScreenEditHoursButtonHandler(ActionEvent event) throws IOException {//takes user to edit hours scene
        Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
        Launcher.setRoot("User/editHoursScreen");
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {//takes user to login scene and logs user out
        Main.command("signout");
        Launcher.setRoot("loginScreen");
    }

    @FXML
    void userScreenJoinProjectHandler(ActionEvent event) throws IOException {//takes user to join project scene
        Launcher.setRoot("User/joinProjectScreen");
    }

    @FXML
    void userScreenLeaveProjectHandler(ActionEvent event) throws IOException {//takes user to leave project scene
        Launcher.setRoot("User/leaveProjectScreen");
    }

    @FXML
    void userScreenJoinActivityHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/joinActivity");

    }

    @FXML
    void userScreenProjectManagerButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for user interface
        Helper.setText(userScreenCurrentUser,Main.getCurrentUser()+"");
        Helper.setText(inAmmountOfProjects,projectList.size()+"");
        Helper.setText(noOfProjects,totalProjects.size()+"");
    }




}
