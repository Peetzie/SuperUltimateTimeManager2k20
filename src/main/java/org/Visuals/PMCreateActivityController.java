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

public class PMCreateActivityController implements Initializable {
    ObservableList<ProjectEmployeeRelation> projectList = FXCollections.observableArrayList(Main.getEmployees().
            get(Main.getCurrentUser()).getManagerProjects());
    long deadline;

    @FXML
    private ChoiceBox<ProjectEmployeeRelation> chooseProject;

    @FXML
    private DatePicker activityDeadline;

    @FXML
    private TextField activityTitle;

    @FXML
    private TextArea activityDescription;

    @FXML
    private TextField activityTime;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("projectManagerScreen");
    }

    @FXML
    void createButtonHandler(ActionEvent event) throws ParseException, IOException {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(activityDeadline.getValue().toString());
            deadline = (date.getTime() / 1000L);
            Main.command("newactivity" + Main.getProjects().indexOf(chooseProject.getValue().getProject()) + " " +
                    activityTitle.getText() + " " + activityDescription.getText() + " " +  Integer.parseInt(activityTime
                    .getText()) * 60 + " " + deadline);
            Launcher.setRoot("projectManagerScreen");
        } catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error creating new activity");
            alert.setContentText("Error creating new activity. Please check the fields, and make sure they are filled correctly");
            alert.showAndWait();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chooseProject.setItems(projectList);
    }
}
