package org.Visuals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class JoinProjectController {
    /**
     * Jeg skal burge en funktion som kigger på den employee som er logget ind og sammenligner hvilke projekter
     * han eller hun er assigned i, og hvilke vedkommende ikke er assigned i.
     * vi bør også assigne folk som deltager i et projekt på et prjekt.
     */

    @FXML
    private ChoiceBox joinProjectProjectChooser;

    @FXML
    private Button joinProjectCancelButton;

    @FXML
    private Button joinProjectJoinButton;

    @FXML
    void cancelButtonHandler(ActionEvent event) throws IOException {
        Launcher.setRoot("userScreen");

    }

    @FXML
    void joinButtonHandler(ActionEvent event) throws IOException {
        System.out.println("Joined project");
        Launcher.setRoot("userScreen");

    }
}
