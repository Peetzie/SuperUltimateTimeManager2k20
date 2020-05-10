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

public class PMAssignEmployeeHoursController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getManagerProjects());
    ObservableList<ProjectEmployeeRelation> employees;
    long startDate;


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
    private DatePicker pmChooseDate;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @FXML
    void confirmButtonHandler(ActionEvent event) throws ParseException, IOException {
        if (Helper.legalInput(startTimehours,startTimeMinutes)){
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(pmChooseDate.getValue().toString());
                startDate = (date.getTime() / 1000L);
                int startTime = (int) (Integer.parseInt(startTimehours.getText()) * 3600 + Integer.parseInt(startTimeMinutes.getText()) * 60 + startDate);
                Main.command("assignemployeehours " + Main.getProjects().indexOf(pmChooseProject.getValue().getProject()) + " " + Main.getEmployees().indexOf(pmChooseEmployee.getValue().getEmployee()) + " " + startTime + " " + Math.round(Float.parseFloat(duration.getText())));
                Launcher.setRoot("User/ProjectManager/ProjectManagerController");
            } catch (NumberFormatException e){
                Helper.illegalInputAlert("Error assigning employee hours");
            }
        } else {
           Helper.illegalTimeInputAlert("Error assigning employee hours");
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
