package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserEditHoursController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getprojectRelations());
    /****
     * Færdiggør
     * bservableList<ProjectEmployeeRelation> hourList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getprojectRelations().get(Ma));
     */
    // ADDED PIKPÆLS!
    @FXML
    private Label userEditHoursCurrentUser;

    @FXML
    private ChoiceBox userEditHoursSelectProject;

    @FXML
    private TextField userEditHoursNewHour;

    @FXML
    private TextField userEditHourNewMinutes;

    @FXML
    private TextField userEditHoursNewDuration;

    @FXML
    private ChoiceBox userEditHoursSelectPreviousEnteredHours;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("userScreen");
    }

    @FXML
    void userEditConfirmButtonHandler(ActionEvent event) {
        Main.command("edithours " + userEditHoursSelectProject.getValue() + "[ENTRY INDEX]" + startTime(userEditHoursNewHour,userEditHourNewMinutes) +
                " " + Integer.parseInt(userEditHoursNewDuration.getText()) * 60 );
    }

    String startTime(TextField userEditHoursNewHour, TextField userEditHoursNewMinutes){
        return String.valueOf(Integer.parseInt(userEditHoursNewHour.getText()) * 3600 + Integer.parseInt(userEditHoursNewMinutes.getText()) * 60);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Helper.setText(userEditHoursCurrentUser, Main.getCurrentUser()+"");
        userEditHoursSelectProject.setItems(projectList);
    }
}
