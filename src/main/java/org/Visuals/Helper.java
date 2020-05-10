package org.Visuals;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.w3c.dom.Text;


public class Helper {//class for functions used in a lot of files

    static boolean legalInput(TextField hours, TextField minutes){
        if(Integer.parseInt(hours.getText()) >= 24 || Integer.parseInt(minutes.getText()) >= 60){
            return false;
        } else {
            return true;
        }
    }

    static Alert illegalTimeInputAlert(String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText("Please enter a maximum of 23 hours and 59 minutes in the hour and minutes fields");
        alert.showAndWait();
        return alert;
    }

    static Alert illegalInputAlert(String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText("Please check input for corret format. In inserting time, please enter numbers only");
        alert.showAndWait();
        return  alert;
    }

   static void setText(Label label, String text) {//simplifies the setText function
        label.setText(text);
    }

}
