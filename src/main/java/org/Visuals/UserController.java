package org.Visuals;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {


    @FXML
    private Label userScreenCurrentUser;

    void setText(String username){
        userScreenCurrentUser.setText(username);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setText(Helper.getCurrentUser());
    }
}
