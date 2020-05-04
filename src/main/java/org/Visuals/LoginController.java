package org.Visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController{


    @FXML
    private TextField loginScreenUsername;

    @FXML
    private PasswordField loginScreenPassword;

    @FXML
    private Button loginScreenLoginButton;

    @FXML
    void loginButtonHandler(ActionEvent event) throws IOException {
        if (isAdmin(loginScreenPassword,loginScreenUsername)){
            Helper.assignCurrentUser(loginScreenUsername.getText());
            Launcher.setRoot("adminScreen");
        } else {
            Helper.assignCurrentUser(loginScreenUsername.getText());
            Launcher.setRoot("userScreen");
        }
    }


    boolean isAdmin(PasswordField loginScreenPassword, TextField loginScreenUsername){
        if (loginScreenUsername.getText().equals("admin") && loginScreenPassword.getText().equals("admin")){
            return true;
        } else {
            return false;
        }
    }






}
