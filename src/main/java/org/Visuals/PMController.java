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

public class PMController implements Initializable {// Controler for the project manager with different options
    // Init obersable lists for the dropdowns in the original screen.
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().
            get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<String> projectStatusList = FXCollections.observableArrayList("Not begun yet", "In progress","Finished");
    ObservableList<Employee> employeeList = FXCollections.observableArrayList(Main.getEmployeesReal());
    ObservableList<String> optionslist = FXCollections.observableArrayList("Create Activities","Remove activity" ,"Assign activity","Set activity status","Assign employee hours","Edit workhours" +" for other \n project bound employee");

    @FXML
    private Label currentUser;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectProject;

    @FXML
    private ChoiceBox setProjectStatus;

    @FXML
    private ChoiceBox setEmployeeToProjectManager;

    @FXML
    private ChoiceBox setEmployeeToProject;

    @FXML
    private ChoiceBox otherOptions;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//Takes the user back to the user screen.
        Launcher.setRoot("User/userScreen");
    }

    @FXML
    void confirmButtonHandler(ActionEvent event) throws IOException {// Confirm, adds changes depending on what values selected in the front manager controller screen. (Status change/ assign employee / and assign project manager
        if (selectProject.getValue() !=null && ("Not begun yet").equals(setProjectStatus.getValue())) {
            Main.command("setstatus " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " + 0);
        } else if (selectProject.getValue() !=null && ("In progress").equals(setProjectStatus.getValue())) {
            Main.command("setstatus " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " + 1);
        } else if (selectProject.getValue() !=null && ("Finished").equals(setProjectStatus.getValue())) {
            Main.command("setstatus " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " + 2);
        } if (selectProject.getValue() != null && setEmployeeToProject.getValue() != null){
            Main.command("assignemployee " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " + Main.getEmployees().indexOf(setEmployeeToProject.getValue()));
        } if (selectProject.getValue() !=null && setEmployeeToProjectManager.getValue() != null) {
            Main.command("assignpm " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " + Main.getEmployees().indexOf(setEmployeeToProjectManager.getValue()));
        }
    }


    @FXML
    void hyperLinkHandler(ActionEvent event) { // Helper for the user manager screen, for the user.
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
    public void initialize(URL url, ResourceBundle resourceBundle) {// Init the different drop downs menus and adding items for use in them
        HelperMethods.setText(currentUser, Main.getCurrentUser()+"");
        selectProject.setItems(projectList);
        setProjectStatus.setItems(projectStatusList);
        setEmployeeToProjectManager.setItems(employeeList);
        setEmployeeToProject.setItems(employeeList);
        otherOptions.setItems(optionslist);
        otherOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() { // For the other options, then depending what selected in the drop down, then change winows
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if (otherOptions.getValue().equals("Create Activities")){
                    try {
                        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
                        Launcher.setRoot("User/ProjectManager/pmCreateActivity");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if (otherOptions.getValue().equals("Edit workhours" +" for other \n project bound employee")){
                    try {
                        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
                        Launcher.setRoot("User/ProjectManager/pmEditWorkHoursForEmployee");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (otherOptions.getValue().equals("Remove activity")){
                    try {
                        Launcher.setRoot("User/ProjectManager/pmRemoveActivity");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if(otherOptions.getValue().equals("Assign activity")){
                    try {
                        Launcher.setRoot("User/ProjectManager/pmAssignActivity");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if(otherOptions.getValue().equals("Set activity status")){
                    try {
                        Launcher.setRoot("User/ProjectManager/pmSetActivityStatus");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if(otherOptions.getValue().equals("Assign employee hours")){
                    try {
                        Main.setPrintProjectInformationOnProjectEmployeeRelations(true);
                        Launcher.setRoot("User/ProjectManager/pmAssignEmployeeHours");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });




    }
}
