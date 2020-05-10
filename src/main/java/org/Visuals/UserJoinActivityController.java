package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class UserJoinActivityController {

    @FXML
    private ChoiceBox<?> chooseProject;

    @FXML
    private ChoiceBox<?> chooseActivity;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("User/userScreen");

    }

    @FXML
    void joinButtonHandler(ActionEvent event) {

    }
}
