package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.Backend.Employee;
import org.Backend.Main;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CreateNewProjectController implements Initializable {
    ObservableList<Employee> userList = FXCollections.observableArrayList(Main.getEmployees());
    long deadline;

    @FXML
    private TextField createProjectTitle;

    @FXML
    private TextArea createProjectDescription;


    @FXML
    private ChoiceBox createProjectProjectManager;

    @FXML
    private Button createNewProjectCreateButton;

    @FXML
    private TextField createProjectEstimatedHours;

    @FXML
    private DatePicker createProjectDate;

    @FXML
    private Button createNewProjectCancelButton;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
          Launcher.setRoot("adminScreen");
    }

    @FXML
    void createButtonHandler(ActionEvent event) throws IOException, ParseException {
        System.out.println(Main.getEmployees().toString());
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(createProjectDate.getValue().toString());
        deadline = (date.getTime()/1000L);
        Main.command("newproject " + createProjectTitle.getText() + " " + createProjectDescription.getText().replace(" ", "_") + " "
                + Math.round(Float.parseFloat(createProjectEstimatedHours.getText())*3600) + " " + deadline);
        if (createProjectProjectManager.getValue() != null){
            Main.command("assignpm " + (Main.getProjects().size()-1) + " " + Main.getEmployees().indexOf(createProjectProjectManager.getValue()));
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert!");
            alert.setContentText("Creating project with out a project manager");
            alert.showAndWait();
        }
        Launcher.setRoot("adminScreen");

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createProjectProjectManager.setItems(userList);
    }


}
