package org.Visuals;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.Backend.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class UserEditHoursController implements Initializable {
    @FXML
    private Label userEditHoursCurrentUser;

    @FXML
    private ChoiceBox userEditHoursSelectProject;

    @FXML
    private TextField userEditHoursNewHour;

    @FXML
    private TextField userEditHourNewMinutes;

    @FXML
    private TextField userEditHoursNewMinutes;

    @FXML
    private ChoiceBox userEditHoursSelectPreviousEnteredHours;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Helper.setText(userEditHoursCurrentUser, Main.getCurrentUser()+"");
    }
}