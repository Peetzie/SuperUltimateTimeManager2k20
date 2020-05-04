package org.Visuals;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.Window;


public class Helper {
    private static String currentuser;


    static void closeWindowHelper(ActionEvent event){
        Window window = ((Node) event.getSource()).getScene().getWindow();
        if (window instanceof Stage){
            ((Stage) window).close();
        }
    }

    static void assignCurrentUser(String username){

    }

    static String getCurrentUser(){
        return currentuser;
    }

}
