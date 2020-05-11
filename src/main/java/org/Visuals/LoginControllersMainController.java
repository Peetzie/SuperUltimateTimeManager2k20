package org.Visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.Backend.Employee;
import org.Backend.Main;

public class LoginControllersMainController {//controller for the login scene
    Employee employee;

    @FXML
    private TextField userID;//input field for userid in interface

    @FXML
    private PasswordField userPassword;//input field for password in interface

    @FXML
    void loginButtonHandler(ActionEvent event) throws IOException {//used to send login attempts and routes the user to the right screen
        if (!Main.command("signin " + userID.getText() + " " + userPassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error logging in");
            alert.setContentText("Invalid login credentials");
            alert.showAndWait();
        } else { // Login sucessfull checks whether user has admin previliges and asks for scene if so.
            Main.command("signin " + userID.getText() + " " + userPassword.getText());
            if (Main.getEmployees().get(Main.getCurrentUser()).isAdmin()) {
                Launcher.setRoot("loginScreenMode");
            } else {
                Launcher.setRoot("User/userScreen");
            }
        }
    }
}
