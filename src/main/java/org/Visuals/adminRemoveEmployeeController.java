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

public class adminRemoveEmployeeController implements Initializable {
    ObservableList<Employee> employees = FXCollections.observableArrayList(Main.getEmployeesReal());


    @FXML
    private ChoiceBox valgbox;

    @FXML
    void ConfirmButtonHandler(ActionEvent event) {
        Main.command("removeemployee " + Main.getEmployees().indexOf(valgbox.getValue()));
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Launcher.setRoot("adminScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        valgbox.setItems(employees);
    }
}
