package org.Visuals;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class Launcher extends Application {//launcher for the gui (graphical user interface)
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {//setup for the gui
        scene = new Scene(loadFXML("loginScreen"));
        stage.setScene(scene); 
        stage.setResizable(false);
        stage.setTitle("SUPER ULTIMATE TIME MANAGER 2K20: Fuld kaos pilot edition");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {//sets the correct scene/fxml
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {//loads the correct scene/fxml
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void launchThis(){//launches the gui
        launch();
    }
}