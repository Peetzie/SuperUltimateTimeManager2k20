package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Label currentUser;


    @FXML
    private Label userInAmmountOfProjects;

    @FXML
    private Label totalNumberOfProjects;

    @FXML
    void assignHoursButtonHandler(ActionEvent event) throws IOException {//takes user to assign hours scene
        Launcher.setRoot("User/assignHoursScreen");
    }


    @FXML
    void userScreenEditHoursButtonHandler(ActionEvent event) throws IOException {//takes user to edit hours scene
        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
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
    void userScreenJoinActivityHandler(ActionEvent event) throws IOException {//takes the user to the join activity scene
        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
        Launcher.setRoot("User/joinActivity");

    }

    @FXML
    void userScreenProjectManagerButtonHandler(ActionEvent event) throws IOException {//takes the user o the project manager screen
        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @FXML
    void getProjectInformationButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/getProjectInformationScreen");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for user interface
        HelperMethods.setText(currentUser,Main.getCurrentUser()+"");
        HelperMethods.setText(userInAmmountOfProjects,projectList.size()+"");
        HelperMethods.setText(totalNumberOfProjects,totalProjects.size()+"");
    }




}
