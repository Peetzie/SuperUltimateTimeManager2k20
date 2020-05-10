package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import org.Backend.Employee;
import org.Backend.Main;
import org.w3c.dom.Text;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

public class CreateNewProjectController implements Initializable {//controller for create new project scene
    ObservableList<Employee> userList = FXCollections.observableArrayList(Main.getEmployeesReal());
    long deadline;
    //ids for scene elements
    @FXML
    private TextField createProjectTitle;

    @FXML
    private TextArea createProjectDescription;

    @FXML
    private ChoiceBox createProjectProjectManager;

    @FXML
    private TextField createProjectEstimatedHours;

    @FXML
    private DatePicker createProjectDate;

    @FXML
    void createButtonHandler(ActionEvent event) throws IOException, ParseException {//button for sending a create project attempt and takes the admin back to admin interface
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(createProjectDate.getValue().toString());
            deadline = (date.getTime() / 1000L);
            Main.command("newproject " + createProjectTitle.getText().replace(" ", "_") + " " + createProjectDescription.getText().replace(" ", "_") + " "
                    + Math.round(Float.parseFloat(createProjectEstimatedHours.getText()) * 3600) + " " + deadline);
            if (createProjectProjectManager.getValue() != null) {
                Main.command("assignpm " + (Main.getProjects().size() - 1) + " " + Main.getEmployees().indexOf(createProjectProjectManager.getValue()));
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert!");
                alert.setContentText("Creating project with out a project manager");
                alert.showAndWait();
            }
            Launcher.setRoot("Admin/adminScreen");
        } catch (NumberFormatException e){
            Helper.illegalInputAlert("Error creating new project");
        }
        }


    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//takes admin back to admin interface without creating project
        Launcher.setRoot("Admin/adminScreen");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//starts setup for create project interface
        createProjectProjectManager.setItems(userList);
    }


}
