package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewProjectController implements Initializable {
    ObservableList<String> userList = FXCollections.observableArrayList("User","test","Jackstyle","Do it with u mama");

    @FXML
    private TextField createProjectTitle;

    @FXML
    private TextArea createProjectDescription;

    @FXML
    private TextField createProjectEstimatedHours;

    @FXML
    private ChoiceBox createProjectProjectManager;

    @FXML
    private Button createNewProjectCreateButton;

    @FXML
    private Button createNewProjectCancelButton;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("adminScreen");
    }

    @FXML
    void createButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("adminScreen");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createProjectProjectManager.setValue(userList.get(0));
        createProjectProjectManager.setItems(userList);
    }
}
