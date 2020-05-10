package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class PMAssignEmployeeHoursController {
    @FXML
    private ChoiceBox<?> pmChooseProject;

    @FXML
    private ChoiceBox<?> pmChooseEmployee;

    @FXML
    private TextField startTimehours;

    @FXML
    private TextField startTimeMinutes;

    @FXML
    private TextField duration;

    @FXML
    void cancelButtonHandler(ActionEvent event) {

    }

    @FXML
    void confirmButtonHandler(ActionEvent event) {

    }
}
