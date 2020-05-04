package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateNewUserController {
    // aid for the checkbox
    private boolean CheckBoxValue = false;

    @FXML
    private TextField createUserUsername;

    @FXML
    private TextField createUserPassword;

    @FXML
    private TextField createUserPasswordrReentry;

    @FXML
    private Button createUserCreateButton;

    @FXML
    private Button createUserCancelButton;

    @FXML
    private CheckBox createNewUserAssignAdmitCheckBox;

    @FXML
    void cancelbuttonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("adminScreen");

    }

    @FXML
    void createButtonHandler(ActionEvent event) throws IOException {
        if (CheckBoxValue){
            System.out.println("Checkbox marked");
        } else{
            System.out.println("Checbox not marked");
        }

    }

    @FXML
    void createNewUserCheckBoxHandler(ActionEvent event) {
        CheckBoxValue = !CheckBoxValue;
    }



}
