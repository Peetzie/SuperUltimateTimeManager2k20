package org.Visuals;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.Backend.Project;
import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class HelperMethods {//class for functions used in a lot of files

    static boolean legalInput(TextField hours, TextField minutes) {
        if (Integer.parseInt(hours.getText()) >= 24 || Integer.parseInt(minutes.getText()) >= 60) {
            return false;
        } else {
            return true;
        }
    }

    // General error messages
    static Alert illegalTimeInputAlert(String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText("Please enter a maximum of 23 hours and 59 minutes in the hour and minutes fields");
        alert.showAndWait();
        return alert;
    }

    static Alert illegalInputAlert(String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText("Please check input for corret format. In inserting time, please enter numbers only");
        alert.showAndWait();
        return alert;
    }

    // set text method for current user in the different scenes.
    static void setText(Label label, String text) {//simplifies the setText function
        label.setText(text);
    }

    static void setTextDependingOnProjectStatus(Project project, Label statusprint) {
        if (project.getStatus() == 0) {
            statusprint.setText("Not begun yet");
        } else if (project.getStatus() == 1) {
            statusprint.setText("In progress");
        } else if (project.getStatus() == 2) {
            statusprint.setText("Finished");
        }
    }

    static void dateTostring(Long date, Label dateStringRepresenter) {
        Date end = new Date(date * 1000 + 86400000); // + 1 day
        SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
        String java_date = jdf.format(end);
        dateStringRepresenter.setText(java_date);
    }

    static void dateError() {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selecting date before todays date");
            alert.setContentText("You have selected a date that is before the current date");
            alert.showAndWait();
    }
}
