package org.Visuals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.Backend.Main;

public class AdminController implements Initializable {
    LoginController loginController;

    @FXML
    private Label adminCurrentUser;

    @FXML
    void createNewProjectButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("createNewProjectScreen");
    }

    @FXML
    void createNewUserButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("createNewUserScreen");
    }

    @FXML
    void signoutButtonHandler(ActionEvent event) throws IOException {
        Main.command("signout");
        Launcher.setRoot("loginScreen");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Helper.setText(adminCurrentUser,Main.getCurrentUser()+"");
    }


}