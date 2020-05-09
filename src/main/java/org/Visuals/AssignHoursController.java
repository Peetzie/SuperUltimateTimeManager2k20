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

public class AssignHoursController implements Initializable {//controller for assign hours scene
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().get(Main.getCurrentUser()).getProjectRelations());
    long startDate;
    //ids for scene elements
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
    void assignButtonHandler(ActionEvent event) throws ParseException, IOException {//button for sending an assign hours attempt and takes the user back to main user interface
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(assignHoursChooseDate.getValue().toString());
            startDate = (date.getTime()/1000L);
            int startTime = Integer.parseInt(assignHoursAssignStartHour.getText())  * 3600 + Integer.parseInt(assignHoursAssignMinute.getText()) * 60;
            Main.command("assignhours " + Main.getProjects().indexOf(assignHoursChooseProject.getValue().getProject()) + " " + startTime + " " + Math.round(Float.parseFloat(assignHoursDuration.getText())*3600));
            Launcher.setRoot("User/userScreen");
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error assigning hours");
            alert.setContentText("Please enter numbers only");
            alert.showAndWait();
        }
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//takes user back to user interface without assigning hours
        Launcher.setRoot("User/userScreen");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for assign hours interface
        System.out.println(projectList);
        assignHoursChooseProject.setItems(projectList);
        Helper.setText(assignHoursCurrentUser,Main.getCurrentUser()+"");
    }
}
