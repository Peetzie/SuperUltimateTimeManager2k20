package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.Backend.Employee;
import org.Backend.Main;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminCreateNewProjectController implements Initializable {//controller for create new project scene
    ObservableList<Employee> userList = FXCollections.observableArrayList(Main.getEmployeesReal());
    long deadline;
    //ids for scene elements
    @FXML
    private TextField projectTitle;

    @FXML
    private TextArea projectDescription;

    @FXML
    private ChoiceBox setProjectManager;

    @FXML
    private TextField setEstimatedHours;

    @FXML
    private DatePicker setDeadline;

    @FXML
    void createButtonHandler(ActionEvent event) throws IOException, ParseException {//button for sending a create project attempt and takes the admin back to admin interface
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(setDeadline.getValue().toString());
            deadline = (date.getTime() / 1000L);
            Main.command("newproject " + projectTitle.getText().replace(" ", "_") + " " + projectDescription.getText().replace(" ", "_") + " "
                    + Math.round(Float.parseFloat(setEstimatedHours.getText()) * 3600) + " " + deadline);
            if (setProjectManager.getValue() != null) {
                Main.command("assignpm " + (Main.getProjects().size() - 1) + " " + Main.getEmployees().indexOf(setProjectManager.getValue()));
            } else { // error messages for information with out a project manager.
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert!");
                alert.setContentText("Creating project with out a project manager");
                alert.showAndWait();
            }
            Launcher.setRoot("Admin/adminScreen");
        } catch (NumberFormatException e){ // error message for wrong use of input.
            HelperMethods.illegalInputAlert("Error creating new project");
        }
        }


    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//takes admin back to admin interface without creating project
        Launcher.setRoot("Admin/adminScreen");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for create project interface
        setProjectManager.setItems(userList);
    }


}
