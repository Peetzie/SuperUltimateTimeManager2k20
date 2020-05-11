package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class PMAssignEmployeeHoursController implements Initializable {// Project manager employee hours controller
    // Intialize dropdown lists.
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<ProjectEmployeeRelation> employeesList;
    long startDate;


    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectProject;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectEmployee;

    @FXML
    private TextField startTimeHours;

    @FXML
    private TextField startTimeMinutes;

    @FXML
    private TextField duration;

    @FXML
    private DatePicker setDate;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//cancel button changes scenes
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @FXML
    void confirmButtonHandler(ActionEvent event) throws ParseException, IOException {//confirm button to backend, if wrong input send error messages using helper functions.
        // uses UNIX time.
        if (HelperMethods.legalInput(startTimeHours,startTimeMinutes)){
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(setDate.getValue().toString());
                startDate = (date.getTime() / 1000L);
                int startTime = (int) (Integer.parseInt(startTimeHours.getText()) * 3600 + Integer.parseInt(startTimeMinutes.getText()) * 60 + startDate);
                Main.command("assignemployeehours " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " + Main.getEmployees().indexOf(selectEmployee.getValue().getEmployee()) + " " + startTime + " " + Math.round(Float.parseFloat(duration.getText())));
                Launcher.setRoot("User/ProjectManager/ProjectManagerController");
            } catch (NumberFormatException e){
                HelperMethods.illegalInputAlert("Error assigning employee hours");
            }
        } else {
           HelperMethods.illegalTimeInputAlert("Error assigning employee hours");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//Initialize drop down menus.
        selectProject.setItems(projectList);
        selectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {// Depending on project selected, get the assigned employees.
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
                employeesList = FXCollections.observableArrayList(selectProject.getValue().getProject().getEmployeeRelations());
                selectEmployee.setItems(employeesList);
            }
        });
    }
}
