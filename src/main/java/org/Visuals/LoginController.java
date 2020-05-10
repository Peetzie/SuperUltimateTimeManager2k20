package org.Visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.Backend.Employee;
import org.Backend.Main;

public class LoginController {//controller for the login scene
    Employee employee;

    @FXML
    private TextField loginScreenUserID;//input field for userid in interface

    @FXML
    private PasswordField loginScreenPassword;//input field for password in interface

    @FXML
    void loginButtonHandler(ActionEvent event) throws IOException {//used to send login attempts and routes the user to the right screen
        if (!Main.command("signin " + loginScreenUserID.getText() + " " + loginScreenPassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error logging in");
            alert.setContentText("Invalid login credentials");
            alert.showAndWait();
        } else { // Login sucessfull checks whether user has admin previliges and asks for scene if so.
            Main.command("signin " + loginScreenUserID.getText() + " " + loginScreenPassword.getText());
            if (Main.getEmployees().get(Main.getCurrentUser()).isAdmin()) {
                Launcher.setRoot("loginScreenMode");
            } else {
                Launcher.setRoot("User/userScreen");
            }
        }
    }
}
