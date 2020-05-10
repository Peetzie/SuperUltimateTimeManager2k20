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
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PMAssignEmployeeHoursController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<ProjectEmployeeRelation> employees;


    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmChooseProject;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> pmChooseEmployee;

    @FXML
    private TextField startTimehours;

    @FXML
    private TextField startTimeMinutes;

    @FXML
    private TextField duration;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @FXML
    void confirmButtonHandler(ActionEvent event) {
        if (Helper.legalInput(startTimehours,startTimeMinutes)){
            int startTime = Integer.parseInt(startTimehours.getText()) * 3600 + Integer.parseInt(startTimeMinutes.getText()) * 60;
            Main.command("assignemployeehours "+Main.getProjects().indexOf(pmChooseProject.getValue())+" "+Main.getEmployees().indexOf(pmChooseEmployee.getValue())+" "+startTime+" "+Math.round(Float.parseFloat(duration.getText())));
        } else {
           Helper.illegalTimeInputAlert("Error assigning hours");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pmChooseProject.setItems(projectList);
        pmChooseProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
                employees = FXCollections.observableArrayList(pmChooseProject.getValue().getProject().getEmployeeRelations());
                pmChooseEmployee.setItems(employees);
            }
        });
    }
}
