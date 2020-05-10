package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import org.Backend.Main;

import java.io.IOException;

public class CreateNewUserController {//controller for create new user scene
    // aid for the checkbox
    private boolean CheckBoxValue = false;
    //ids for scene elements
    @FXML
    private TextField createUserUsername;

    @FXML
    private PasswordField createUserPassword;

    @FXML
    private PasswordField createUserPasswordrReentry;

    @FXML
    void createNewUserCheckBoxHandler(ActionEvent event) {//checkbox for admin privilegies
        CheckBoxValue = !CheckBoxValue;
    }

    @FXML
    void createButtonHandler(ActionEvent event) throws IOException {//button for sending a create user attempt and takes the admin back to admin interface
        if (checkPassword(createUserPassword,createUserPasswordrReentry)){
            if (CheckBoxValue){
                Main.command("newemployee " + createUserPassword.getText() + " " + createUserUsername.getText() + " admin");
                Launcher.setRoot("Admin/adminScreen");
            } else{
                Main.command("newemployee " + createUserPassword.getText() + " " + createUserUsername.getText());
                Launcher.setRoot("Admin/adminScreen");
            }
        } else{ // error if passwords are not identical
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error create new user");
            alert.setContentText("Please check the information");
            alert.showAndWait();
        }
    }

    @FXML
    void cancelbuttonHandler(ActionEvent event) throws IOException {//takes admin back to admin interface without creating user
        Launcher.setRoot("Admin/adminScreen");

    }

    boolean checkPassword(PasswordField createUserPassword, PasswordField createUserPasswordrReentry){//checks if password and reentry match
        if(createUserPassword.getText().equals(createUserPasswordrReentry.getText())){
            return true;
        } else{
            return false;
        }
    }



}
