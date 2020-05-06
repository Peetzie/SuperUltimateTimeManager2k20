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
    void assignHoursButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("assignHoursScreen");
    }


    @FXML
    void userScreenEditHoursButtonHandler(ActionEvent event){
        System.out.println("Pressed edit hours button");
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        Main.command("signout");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Helper.setText(userScreenCurrentUser,Main.getCurrentUser()+"");
    }
}
