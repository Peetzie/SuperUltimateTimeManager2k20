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
import javafx.scene.control.TextField;
import org.Backend.Hour;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserEditHoursController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getProjectRelations());
    ProjectEmployeeRelation projectEmployeeRelation;

    @FXML
    private ChoiceBox userEditHoursSelectProject;

    @FXML
    private Label userEditHoursCurrentUser;

    @FXML
    private TextField userEditHoursNewHour;

    @FXML
    private TextField userEditHourNewMinutes;

    @FXML
    private TextField userEditHoursNewDurationTime;

    @FXML
    private ChoiceBox userEditHoursSelectPreviousEnteredHours;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/userScreen");
    }

    @FXML
    void userEditConfirmButtonHandler(ActionEvent event) {
        if (Helper.legalInput(userEditHoursNewHour, userEditHourNewMinutes)) {
            try {
                Main.command("edithours " + Main.getProjects().indexOf(((ProjectEmployeeRelation)userEditHoursSelectProject.getValue()).getProject()) + " " +
                        projectEmployeeRelation.getHours().indexOf(userEditHoursSelectPreviousEnteredHours.getValue())
                        + " " + startTime(userEditHoursNewHour, userEditHourNewMinutes) +
                        " " + (Integer.parseInt(userEditHoursNewDurationTime.getText()) * 60));
                Launcher.setRoot("User/userScreen");
            } catch (NumberFormatException | IOException e) {
                Helper.illegalInputAlert("Error editing hours");
            }
        } else {
           Helper.illegalTimeInputAlert("Error editing hours");
        }
    }

    String startTime(TextField userEditHoursNewHour, TextField userEditHoursNewMinutes){
        return String.valueOf(Integer.parseInt(userEditHoursNewHour.getText()) * 3600 + Integer.parseInt(userEditHoursNewMinutes.getText()) * 60);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Helper.setText(userEditHoursCurrentUser, Main.getCurrentUser()+"");
        userEditHoursSelectProject.setItems(projectList);

        userEditHoursSelectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(userEditHoursSelectProject.getValue());
                ObservableList<Hour> hourList = FXCollections.observableArrayList(((ProjectEmployeeRelation) userEditHoursSelectProject.getValue()).getHours());
                userEditHoursSelectPreviousEnteredHours.setItems(hourList);
                projectEmployeeRelation = (ProjectEmployeeRelation) t1;
            }
        });
    }
}
