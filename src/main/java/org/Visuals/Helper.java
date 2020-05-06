package org.Visuals;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;



public class Helper {

    static void closeWindowHelper(ActionEvent event){
        Window window = ((Node) event.getSource()).getScene().getWindow();
        if (window instanceof Stage){
            ((Stage) window).close();
        }
    }

   static void setText(Label label, String text){
        label.setText(text);
    }

}
