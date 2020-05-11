package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.Backend.Hour;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserEditHoursController implements Initializable {// controller for the user edit hours screen
    // init of lists for the drop down menus.
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getProjectRelations());
    ProjectEmployeeRelation projectEmployeeRelation;

    @FXML
    private ChoiceBox selectProject;

    @FXML
    private Label currentUser;

    @FXML
    private TextField setNewHour;

    @FXML
    private TextField setNewMinute;

    @FXML
    private TextField setNewDuration;

    @FXML
    private ChoiceBox selectPreviousEnteredHours;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//takes the user back to the user screen
        Launcher.setRoot("User/userScreen");
    }

    @FXML
    void userEditConfirmButtonHandler(ActionEvent event) {// Connects to the backend and confirms changes of hours, if wrong input then give error.
        if (HelperMethods.legalInput(setNewHour, setNewMinute)) {
            try {
                Main.command("edithours " + Main.getProjects().indexOf(((ProjectEmployeeRelation) selectProject.getValue()).getProject()) + " " +
                        projectEmployeeRelation.getHours().indexOf(selectPreviousEnteredHours.getValue())
                        + " " + startTime(setNewHour, setNewMinute) +
                        " " + (Integer.parseInt(setNewDuration.getText()) * 60));
                Launcher.setRoot("User/userScreen");
            } catch (NumberFormatException | IOException e) {
                HelperMethods.illegalInputAlert("Error editing hours");
            }
        } else {
           HelperMethods.illegalTimeInputAlert("Error editing hours");
        }
    }

    String startTime(TextField userEditHoursNewHour, TextField userEditHoursNewMinutes){ // method for creating the starttime
        return String.valueOf(Integer.parseInt(userEditHoursNewHour.getText()) * 3600 + Integer.parseInt(userEditHoursNewMinutes.getText()) * 60);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// Adds items to the dropdown menus from the observable lists.
        HelperMethods.setText(currentUser, Main.getCurrentUser()+"");
        selectProject.setItems(projectList);

        selectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() { // depending on what project chosen, fill the list of possible hours to edit.
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(selectProject.getValue());
                ObservableList<Hour> hourList = FXCollections.observableArrayList(((ProjectEmployeeRelation) selectProject.getValue()).getHours());
                selectPreviousEnteredHours.setItems(hourList);
                projectEmployeeRelation = (ProjectEmployeeRelation) t1;
            }
        });
    }
}
