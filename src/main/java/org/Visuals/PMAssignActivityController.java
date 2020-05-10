package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.Backend.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PMAssignActivityController implements Initializable {
    ObservableList<Project> projects = FXCollections.observableArrayList(Main.getProjects());
    ObservableList<Employee> employees = FXCollections.observableArrayList(Main.getEmployeesReal());
    Activity userAssignActivitySelectProject;

    @FXML
    private ChoiceBox<?> pmChooseProject;
    ObservableList<Activity> activities = FXCollections.observableArrayList(Main.getProjects().get(Main.getProjects().indexOf(pmChooseProject.getValue())).getActivities());

    @FXML
    private ChoiceBox<?> pmChooseActivity;

    @FXML
    private ChoiceBox<?> pmChooseEmployee;

    @FXML
    void assignButtonHandler(ActionEvent event) throws IOException {
        Main.command("assignactivity "+Main.getProjects().indexOf(pmChooseProject.getValue())+" "+Main.getProjects().get(Main.getProjects().indexOf(pmChooseProject.getValue())).getActivities().indexOf(pmChooseActivity.getValue())+" "+Main.getProjects().indexOf(pmChooseEmployee.getValue()));
        Launcher.setRoot("Admin/adminScreen");
    }

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("Admin/adminScreen");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        Helper.setText(userAssignActivitySelectProject, Main.getCurrentUser()+"");
        userAssignActivitySelectProject.setItems(activities);

        userAssignActivitySelectProject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(userAssignActivitySelectProject.getValue());
                userAssignActivitySelectProject.setItems(activities);
                activities = (Activity) t1;
            }
        });

         */

    }
}
