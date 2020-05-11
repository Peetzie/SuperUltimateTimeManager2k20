package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class UserAssignHoursController implements Initializable {//controller for assign hours scene
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getProjectRelations());
    long startDate;
    //ids for scene elements
    @FXML
    private Label currentUser;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectProject;

    @FXML
    private DatePicker setDate;

    @FXML
    private TextField setStartHour;

    @FXML
    private TextField setStartMinute;

    @FXML
    private TextField setDuration;


    @FXML
    void assignButtonHandler(ActionEvent event) throws ParseException, IOException {//button for sending an assign hours attempt and takes the user back to main user interface
        if (HelperMethods.legalInput(setStartHour, setStartMinute)) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(setDate.getValue().toString());
                startDate = (date.getTime() / 1000L);
                int startTime = (int) (Integer.parseInt(setStartHour.getText()) * 3600 + Integer.parseInt(setStartMinute.getText()) * 60 + startDate);
                Main.command("assignhours " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " + startTime + " " + Math.round(Float.parseFloat(setDuration.getText()) * 3600));
                Launcher.setRoot("User/userScreen");
            } catch (NumberFormatException e) {
                HelperMethods.illegalInputAlert("Error assigning hours");
            }
        } else {
            HelperMethods.illegalTimeInputAlert("Error assigning hors");
        }
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//takes user back to user interface without assigning hours
        Launcher.setRoot("User/userScreen");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for assign hours interface
        System.out.println(projectList);
        selectProject.setItems(projectList);
        HelperMethods.setText(currentUser,Main.getCurrentUser()+"");
    }
}
