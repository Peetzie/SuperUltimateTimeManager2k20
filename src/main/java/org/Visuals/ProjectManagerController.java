package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import org.Backend.Employee;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProjectManagerController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().
            get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<String> projectStatusList = FXCollections.observableArrayList("Not begun yet", "In progress","Finished");
    ObservableList<Employee> employeeList = FXCollections.observableArrayList(Main.getEmployeesReal());
    ObservableList<String> optionslist = FXCollections.observableArrayList("Create Activities","Remove activity" ,"Assign activity","Set activity status","Assign employee hours","Edit workhours" +" for other \n project bound employee");

    @FXML
    private Label pmCurrentUser;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmSelectProject;

    @FXML
    private ChoiceBox pmSetProjectStatus;

    @FXML
    private ChoiceBox pmNewProjectManager;

    @FXML
    private ChoiceBox pmAssignEmployeeToProject;

    @FXML
    private ChoiceBox pmOtherOptions;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/userScreen");
    }

    @FXML
    void confirmButtonHandler(ActionEvent event) throws IOException {
        if (pmSelectProject.getValue() !=null && ("Not begun yet").equals(pmSetProjectStatus.getValue())) {
            Main.command("setstatus " + Main.getProjects().indexOf(pmSelectProject.getValue().getProject()) + " " + 0);
        } else if (pmSelectProject.getValue() !=null && ("In progress").equals(pmSetProjectStatus.getValue())) {
            Main.command("setstatus " + Main.getProjects().indexOf(pmSelectProject.getValue().getProject()) + " " + 1);
        } else if (pmSelectProject.getValue() !=null && ("Finished").equals(pmSetProjectStatus.getValue())) {
            Main.command("setstatus " + Main.getProjects().indexOf(pmSelectProject.getValue().getProject()) + " " + 2);
        } if (pmSelectProject.getValue() != null && pmAssignEmployeeToProject.getValue() != null){
            Main.command("assignemployee " + Main.getProjects().indexOf(pmSelectProject.getValue().getProject()) + " " + Main.getEmployees().indexOf(pmAssignEmployeeToProject.getValue()));
        } if (pmSelectProject.getValue() !=null && pmNewProjectManager.getValue() != null) {
            Main.command("assignpm " + Main.getProjects().indexOf(pmSelectProject.getValue().getProject()) + " " + Main.getEmployees().indexOf(pmNewProjectManager.getValue()));
        }
    }


    @FXML
    void hyperLinkHandler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("The projectmanager page is used by small changes, one can select the project that's " +
                "currently being changed options in, in the top. \n " +
                "Next up the user can change individual settings such as setting project status without using the" +
                " other functions. \n " +
                "For more advanced options check the 'other settings' drop down menu. ");
        alert.setTitle("How - to Project Manager");
        alert.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Helper.setText(pmCurrentUser, Main.getCurrentUser()+"");
        pmSelectProject.setItems(projectList);
        pmSetProjectStatus.setItems(projectStatusList);
        pmNewProjectManager.setItems(employeeList);
        pmAssignEmployeeToProject.setItems(employeeList);
        pmOtherOptions.setItems(optionslist);
        pmOtherOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if (pmOtherOptions.getValue().equals("Create Activities")){
                    try {
                        Launcher.setRoot("User/ProjectManager/pmCreateActivity");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if (pmOtherOptions.getValue().equals("Edit workhours" +" for other \n project bound employee")){
                    try {
                        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
                        Launcher.setRoot("User/ProjectManager/pmEditWorkHoursForEmployee");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (pmOtherOptions.getValue().equals("Remove activity")){
                    try {
                        Launcher.setRoot("User/ProjectManager/pmRemoveActivity");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if(pmOtherOptions.getValue().equals("Assign activity")){
                    try {
                        Launcher.setRoot("User/ProjectManager/pmAssignActivity");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });




    }
}
