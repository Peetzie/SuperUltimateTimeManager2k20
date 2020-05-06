package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.Backend.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AssignHoursController implements Initializable {

    @FXML
    private Label assignHoursCurrentUser;

    @FXML
    private ChoiceBox assignHoursChooseProject;

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
    void assignButtonHandler(ActionEvent event) {

    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("userScreen");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Helper.setText(assignHoursCurrentUser,Main.getCurrentUser()+"");
    }
}
