package org.Visuals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.Backend.Main;
import org.Backend.ProjectEmployeeRelation;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class
PMCreateActivityController implements Initializable { // create activity controller of the project managers
    // Dropdown selecting.
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().
            get(Main.getCurrentUser()).getManagerProjects());
    long deadline;
    boolean hasBeenWarned;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> selectProject;

    @FXML
    private DatePicker setDeadline;

    @FXML
    private TextField setTitle;

    @FXML
    private TextArea setDescription;

    @FXML
    private TextField setDuration;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {//cancel button changes scenes
        Launcher.setRoot("User/ProjectManager/projectManagerScreen");
    }

    @FXML
    void createButtonHandler(ActionEvent event) throws ParseException, IOException {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(setDeadline.getValue().toString());
            deadline = (date.getTime() / 1000L);
            if (deadline < System.currentTimeMillis() / 1000L && !hasBeenWarned){
                HelperMethods.dateError();
                hasBeenWarned = true;
            }else {
                Main.command("newactivity " + Main.getProjects().indexOf(selectProject.getValue().getProject()) + " " +
                        setTitle.getText().replace(" ", "_") + " " + setDescription.getText().replace(" ", "_") + " " + Integer.parseInt(setDuration
                        .getText()) * 60 + " " + deadline);
                Launcher.setRoot("User/ProjectManager/projectManagerScreen");
            }
        } catch(NumberFormatException e){
            HelperMethods.illegalInputAlert("Error creating activity");
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectProject.setItems(projectList);
    }
}
