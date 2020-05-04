package org.Visuals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminController implements Initializable {
    LoginController loginController;

    @FXML
    private Label adminCurrentUser;

    @FXML
    private Button adminSignoutButton;

    @FXML
    private Button createNewProjectButton;
    @FXML
    private Button createNewUserButton;

    @FXML
    void createNewProjectButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("createNewProjectScreen");
    }

    @FXML
    void createNewUserButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("createNewUserScreen");
    }

    @FXML
    void signoutButtonHandler(ActionEvent event) {
        Helper.closeWindowHelper(event);
    }

    void setText(String text){
        adminCurrentUser.setText(text);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setText(Helper.getCurrentUser());
    }


}