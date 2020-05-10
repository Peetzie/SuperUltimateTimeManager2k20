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

/***
 * Delete a user
 *
 */
public class AdminController implements Initializable {//controller for admin interface
    LoginController loginController;

    @FXML
    private Label adminCurrentUser;

    @FXML
    void createProjectButton(ActionEvent event) throws IOException {//button takes admin to "create new project" scene
        Launcher.setRoot("Admin/createNewProjectScreen");
    }

    @FXML
    void createNewUserButtonHandler(ActionEvent event) throws IOException {//button takes admin to "create new user" scene
        Launcher.setRoot("Admin/createNewUserScreen");
    }

    @FXML
    void signoutButtonHandler(ActionEvent event) throws IOException {//log out user and opens the login scene
        Main.command("signout");
        Launcher.setRoot("loginScreen");
    }

    @FXML
    void assignPMButtonHandler(ActionEvent event) throws IOException{//button takes admin to "assign project manager" scene
        Launcher.setRoot("Admin/adminAssignProjectManager");
    }

    @FXML
    void adminRemoveEmployeeButtonHandler(ActionEvent event) throws IOException {//button takes admin to "remove employee" scene
        Launcher.setRoot("Admin/adminRemoveEmployee");
    }

    @FXML
    void removeProjectButtonHandler(ActionEvent event) throws IOException {//button takes admin to "remove project" scene
        Launcher.setRoot("Admin/adminRemoveProject");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for admin interface
        Helper.setText(adminCurrentUser,Main.getCurrentUser()+"");
    }


}