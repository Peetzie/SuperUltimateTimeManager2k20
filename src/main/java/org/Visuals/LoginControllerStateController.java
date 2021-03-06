package org.Visuals;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import org.Backend.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginControllerStateController implements Initializable {//secondary screen for admin login | user login
    ObservableList<String> optionsList = FXCollections.observableArrayList("Adminstrator mode","User mode");
    @FXML
    private Label currentUser;

    @FXML
    private ChoiceBox<String> loginOptions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {// Start up initialize values of drop down
        loginOptions.setItems(optionsList);
        HelperMethods.setText(currentUser, Main.getCurrentUser()+"");

        loginOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {// Change scene depending on what mode is selected
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if (loginOptions.getValue().equals("Adminstrator mode")){
                    try {
                        Launcher.setRoot("Admin/adminScreen");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else{
                    try {
                        Launcher.setRoot("User/userScreen");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
