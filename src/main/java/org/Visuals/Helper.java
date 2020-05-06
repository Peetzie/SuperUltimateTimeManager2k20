package org.Visuals;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;



public class Helper {//class for functions used in a lot of files

    static void closeWindowHelper(ActionEvent event){//closes the instance of the window
        Window window = ((Node) event.getSource()).getScene().getWindow();
        if (window instanceof Stage){
            ((Stage) window).close();
        }
    }

   static void setText(Label label, String text) {//simplifies the setText function
        label.setText(text);
    }

}
