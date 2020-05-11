package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.Backend.Hour;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PMEditWorkHoursForEmployeeController implements Initializable {// Project manager workhours editing of assigned employee
    // Init dropdowns
    ProjectEmployeeRelation projectEmployeeRelation;
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().
            get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<ProjectEmployeeRelation> employeesList;
    ObservableList<Hour> hoursList;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectProject;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectEmployee;

    @FXML
    private ChoiceBox<Hour> selectPreviousEnteredHours;

    @FXML
    private TextField setNewHour;

    @FXML
    private TextField setNewMinutes;

    @FXML
    private TextField setNewDuration;

    @FXML
    void applyButtonHandler(ActionEvent event) {//Connects selected values to backend, with Main.command. Uses UNIX time. If wrong input give error messasges.
            if (HelperMethods.legalInput(setNewHour, setNewMinutes)) {
                try {
                    int startTime = Integer.parseInt(setNewHour.getText()) * 3600 + Integer.parseInt(setNewMinutes.getText()) * 60;
                    Main.command("editemployeehours " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " "
                            + Main.getEmployees().indexOf(selectEmployee.getValue().getEmployee()) + " " +
                            selectEmployee.getValue().getHours().indexOf(selectPreviousEnteredHours.getValue()) + " " +
                            startTime + " " + Math.round(Float.parseFloat(setNewDuration.getText())));
                    Launcher.setRoot("User/ProjectManager/projectManagerScreen");
                } catch (NumberFormatException | IOException e){
                    HelperMethods.illegalInputAlert("Error editing workhours");
                }
            } else {
                HelperMethods.illegalTimeInputAlert("Error editing workhours");
            }
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//Takes the user back to the previous screen
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// Initialize methods for dropdowns so they have options
        selectProject.setItems(projectList);
        selectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {// Depending on project selected, get assigned employees.
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                 Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
                 employeesList = FXCollections.observableArrayList(selectProject.getValue().getProject().getEmployeeRelations());
                 selectEmployee.setItems(employeesList);
            }
        });
        selectEmployee.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
                hoursList = FXCollections.observableArrayList(((ProjectEmployeeRelation) selectProject.getValue()).getHours());
                selectPreviousEnteredHours.setItems(hoursList);
            }
        });


    }
}
