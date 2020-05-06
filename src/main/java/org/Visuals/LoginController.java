package org.Visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.Backend.Main;

public class LoginController{//controller for the login scene


    @FXML
    private TextField loginScreenUserID;//input field for userid in interface

    @FXML
    private PasswordField loginScreenPassword;//input field for password in interface

    @FXML
    private Button loginScreenLoginButton;//button for sending a login attempt

    @FXML
    private TextField test;//remove before version. used for debugging

    @FXML
    private Button cmdbutton;

    @FXML
    void cmdbuttonhandler(ActionEvent event) {
        System.out.println("Test");
        Main.command(test.getText());
        test.setText("");
    }


    @FXML
    void loginButtonHandler(ActionEvent event) throws IOException {
        Main.command("signin " + loginScreenUserID.getText() + " " + loginScreenPassword.getText());
        if (Main.getEmployees().get(Main.getCurrentUser()).isAdmin()){
            Launcher.setRoot("adminScreen");
        }
        else {
            Launcher.setRoot("userScreen");
        }
    }









}
