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

public class LoginController{


    @FXML
    private TextField loginScreenUsername;

    @FXML
    private PasswordField loginScreenPassword;

    @FXML
    private Button loginScreenLoginButton;

    @FXML
    private TextField test;

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
        Main.command("signin " + loginScreenUsername.getText() + " " + loginScreenPassword.getText());
        if (Main.getEmployees().get(Main.getCurrentUser()).isAdmin()){
            Launcher.setRoot("adminScreen");
        }
        else {
            Launcher.setRoot("userScreen");
        }
    }









}
