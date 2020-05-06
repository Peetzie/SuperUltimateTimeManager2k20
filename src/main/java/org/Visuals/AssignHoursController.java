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

public class AssignHoursController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getprojectRelations());
    long startDate;

    @FXML
    private Label assignHoursCurrentUser;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> assignHoursChooseProject;

    @FXML
    private DatePicker assignHoursChooseDate;

    @FXML
    private TextField assignHoursAssignStartHour;

    @FXML
    private TextField assignHoursAssignMinute;

    @FXML
    private TextField assignHoursDuration;

    @FXML
    private Button assignHoursAssignButton;

    @FXML
    private Button assignHoursCancelButton;

    @FXML
    void assignButtonHandler(ActionEvent event) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(assignHoursChooseDate.getValue().toString());
        startDate = (date.getTime()/1000L);
        int startTime = Integer.parseInt(assignHoursAssignStartHour.getText())  * 3600 + Integer.parseInt(assignHoursAssignMinute.getText()) * 60;
        Main.command("assignhours " + assignHoursChooseProject.getValue() + " " + startTime + " " + Math.round(Float.parseFloat(assignHoursDuration.getText())*3600));

    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("userScreen");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(projectList);
        assignHoursChooseProject.setItems(projectList);
        Helper.setText(assignHoursCurrentUser,Main.getCurrentUser()+"");
    }
}
