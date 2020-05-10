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
import org.Backend.Employee;
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
    ObservableList<ProjectEmployeeRelation> employees;
    ObservableList<Hour> hours;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmSelectProject;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmSelectEmployee;

    @FXML
    private ChoiceBox<Hour> pmPrevEnteredHours;

    @FXML
    private TextField pmEnterHours;

    @FXML
    private TextField pmEnterMinutes;

    @FXML
    private TextField pmEnterDuration;

    @FXML
    void applyButtonHandler(ActionEvent event) {//Connects selected values to backend, with Main.command. Uses UNIX time. If wrong input give error messasges.
            if (Helper.legalInput(pmEnterHours, pmEnterMinutes)) {
                try {
                    int startTime = Integer.parseInt(pmEnterHours.getText()) * 3600 + Integer.parseInt(pmEnterMinutes.getText()) * 60;
                    Main.command("editemployeehours " + Main.getProjects().indexOf(pmSelectProject.getValue().getProject()) + " "
                            + Main.getEmployees().indexOf(pmSelectEmployee.getValue().getEmployee()) + " " +
                            pmSelectEmployee.getValue().getHours().indexOf(pmPrevEnteredHours.getValue()) + " " +
                            startTime + " " + Math.round(Float.parseFloat(pmEnterDuration.getText())));
                    Launcher.setRoot("User/ProjectManager/projectManagerScreen");
                } catch (NumberFormatException | IOException e){
                    Helper.illegalInputAlert("Error editing workhours");
                }
            } else {
                Helper.illegalTimeInputAlert("Error editing workhours");
            }
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//Takes the user back to the previous screen
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// Initialize methods for dropdowns so they have options
        pmSelectProject.setItems(projectList);
        pmSelectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {// Depending on project selected, get assigned employees.
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                 Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
                 employees = FXCollections.observableArrayList(pmSelectProject.getValue().getProject().getEmployeeRelations());
                 pmSelectEmployee.setItems(employees);
            }
        });
        pmSelectEmployee.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
                hours = FXCollections.observableArrayList(((ProjectEmployeeRelation) pmSelectProject.getValue()).getHours());
                pmPrevEnteredHours.setItems(hours);
            }
        });


    }
}
