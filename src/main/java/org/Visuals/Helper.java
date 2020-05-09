package org.Visuals;

import javafx.event.ActionEvent;
import javafx.scene.Node;
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

   static void setText(Label label, String text) {//simplifies the setText function
        label.setText(text);
    }

}
