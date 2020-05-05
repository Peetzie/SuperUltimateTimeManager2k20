package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.Backend.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {


    @FXML
    private Label userScreenCurrentUser;

    @FXML
    private Button userScreenLeaveProject;

    @FXML
    private Button userScreenJoinProject;

    @FXML
    private Button userScreenSignOutButton;

    @FXML
    private Button userScreenAssignHoursButton;

    @FXML
    private Button UserScrenEditHoursButton;

    @FXML
    void assignHoursButtonHandler(ActionEvent event){
        System.out.println("pressed assignhours");
    }


    @FXML
    void userScreenEditHoursButtonHandler(ActionEvent event){
        System.out.println("Pressed edit hours button");
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        Main.signOut();
        Launcher.setRoot("loginScreen");
    }

    @FXML
    void userScreenJoinProjectHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("joinProjectScreen");
    }

    @FXML
    void userScreenLeaveProjectHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("leaveProjectScreen");
    }

    void setText(String username){
        userScreenCurrentUser.setText(username);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setText(Main.getCurrentUser()+"");
    }
}
