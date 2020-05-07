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

public class UserController implements Initializable {//controller for user scene
    //id for scene elements
    @FXML
    private Label userScreenCurrentUser;

    @FXML
    void assignHoursButtonHandler(ActionEvent event) throws IOException {//takes user to assign hours scene
        Launcher.setRoot("assignHoursScreen");
    }


    @FXML
    void userScreenEditHoursButtonHandler(ActionEvent event) throws IOException {//takes user to edit hours scene
        Launcher.setRoot("editHoursScreen");
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {//takes user to login scene and logs user out
        Main.command("signout");
        Launcher.setRoot("loginScreen");
    }

    @FXML
    void userScreenJoinProjectHandler(ActionEvent event) throws IOException {//takes user to join project scene
        Launcher.setRoot("joinProjectScreen");
    }

    @FXML
    void userScreenLeaveProjectHandler(ActionEvent event) throws IOException {//takes user to leave project scene
        Launcher.setRoot("leaveProjectScreen");
    }


    @FXML
    void userScreenProjectManagerButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("projectManagerScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for user interface
        Helper.setText(userScreenCurrentUser,Main.getCurrentUser()+"");
    }




}
