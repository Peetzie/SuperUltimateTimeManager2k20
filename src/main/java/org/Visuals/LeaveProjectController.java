package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import org.Backend.Employee;
import org.Backend.Main;
import org.Backend.Project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaveProjectController implements Initializable {
    /**
     * Mangler backend funktion til at tage fra hvilken den indloggede employee har af tilknyttede projekter.
     */
    ObservableList<String> projectList = FXCollections.observableArrayList("Lav backend metode til ", "at få informationerne ", "fra hvilke projekter den loggede ind employee er assigned");



    @FXML
    private ChoiceBox leaveProjectChooseProject;

    @FXML
    private Button leaveProjectConfirm;

    @FXML
    private Button leaveProjectCancelButton;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("userScreen");

    }

    @FXML
    void confirmButtonHandler(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        leaveProjectChooseProject.setItems(projectList);
    }
}
