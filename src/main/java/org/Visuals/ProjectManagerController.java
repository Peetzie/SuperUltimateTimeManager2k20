package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectManagerController implements Initializable {

    @FXML
    private Label pmCurrentUser;

    @FXML
    private ChoiceBox<?> pmSelectProject;

    @FXML
    private ChoiceBox<?> pmSetProjectStatus;

    @FXML
    private ChoiceBox<?> pmNewProjectManager;

    @FXML
    private ChoiceBox<?> pmAssignEmployeeToProject;

    @FXML
    private ChoiceBox<?> pmOtherOptions;

    @FXML
    void cancelButtonHandler(ActionEvent event) {

    }

    @FXML
    void confirmButtonHandler(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
