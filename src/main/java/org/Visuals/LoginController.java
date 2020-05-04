package org.Visuals;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.Backend.Main;

public class LoginController{


    @FXML
    private TextField loginScreenUsername;

    @FXML
    private PasswordField loginScreenPassword;

    @FXML
    private Button loginScreenLoginButton;

    @FXML
    void loginButtonHandler(ActionEvent event) throws IOException {
        Main.command("signin " + loginScreenUsername.getText());
        if (Main.getEmployees().get(Main.getCurrentUser()).isAdmin())
        Launcher.setRoot("adminScreen");
    }









}
