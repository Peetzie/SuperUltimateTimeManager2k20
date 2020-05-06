package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import org.Backend.Main;

import java.io.IOException;

public class CreateNewUserController {
    // aid for the checkbox
    private boolean CheckBoxValue = false;

    @FXML
    private TextField createUserUsername;

    @FXML
    private PasswordField createUserPassword;

    @FXML
    private PasswordField createUserPasswordrReentry;


    @FXML
    void cancelbuttonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("adminScreen");

    }

    @FXML
    void createButtonHandler(ActionEvent event) throws IOException {
        if (checkPassword(createUserPassword,createUserPasswordrReentry)){
            if (CheckBoxValue){
                Main.command("newemployee " + createUserPassword.getText() + " " + createUserUsername.getText() + " admin");
                Launcher.setRoot("adminScreen");
            } else{
                Main.command("newemployee " + createUserPassword.getText() + " " + createUserUsername.getText());
                Launcher.setRoot("adminScreen");
            }
        } else{
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error create new user");
            alert.setContentText("Please check the information");
            alert.showAndWait();
        }
    }

    @FXML
    void createNewUserCheckBoxHandler(ActionEvent event) {
        CheckBoxValue = !CheckBoxValue;
    }

    boolean checkPassword(PasswordField createUserPassword, PasswordField createUserPasswordrReentry){
        if(createUserPassword.getText().equals(createUserPasswordrReentry.getText())){
            return true;
        } else{
            return false;
        }
    }



}
