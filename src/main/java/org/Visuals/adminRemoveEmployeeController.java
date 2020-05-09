package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import org.Backend.Employee;
import org.Backend.Main;
import org.Backend.Project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminRemoveEmployeeController implements Initializable {
    ObservableList<Employee> employees = FXCollections.observableArrayList(Main.getEmployeesReal());



    @FXML
    private ChoiceBox valgbox;

    @FXML
    void ConfirmButtonHandler(ActionEvent event) throws IOException {
        Main.command("removeemployee " + Main.getEmployees().indexOf(valgbox.getValue()));
        Launcher.setRoot("Admin/adminScreen");
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Launcher.setRoot("Admin/adminScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        valgbox.setItems(employees);
    }
}
