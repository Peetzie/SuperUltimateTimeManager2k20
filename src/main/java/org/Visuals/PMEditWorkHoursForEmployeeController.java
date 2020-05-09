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

public class PMEditWorkHoursForEmployeeController implements Initializable {
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
    void applyButtonHandler(ActionEvent event) {

    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
        pmSelectProject.setItems(projectList);
        pmSelectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                 employees = FXCollections.observableArrayList(pmSelectProject.getValue().getProject().getEmployeeRelations());
                 pmSelectEmployee.setItems(employees);
            }
        });
        pmSelectEmployee.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                hours = FXCollections.observableArrayList(((ProjectEmployeeRelation) pmSelectProject.getValue()).getHours());
                pmPrevEnteredHours.setItems(hours);
            }
        });


    }
}
