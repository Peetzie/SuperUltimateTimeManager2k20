package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.Backend.Employee;
import org.Backend.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminRemoveEmployeeController implements Initializable { // Remove employee scene controller
    ObservableList<Employee> userList = FXCollections.observableArrayList(Main.getEmployeesReal());



    @FXML
    private ChoiceBox selectEmployee;

    @FXML
    void ConfirmButtonHandler(ActionEvent event) throws IOException {// Connects backend to the confirm button
        Main.command("removeemployee " + Main.getEmployees().indexOf(selectEmployee.getValue()));
        Launcher.setRoot("Admin/adminScreen");
    }

    @FXML
    void exit(ActionEvent event) throws IOException {// Scene change to adminscreen again, on exit button
        Launcher.setRoot("Admin/adminScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectEmployee.setItems(userList);
    }
}
