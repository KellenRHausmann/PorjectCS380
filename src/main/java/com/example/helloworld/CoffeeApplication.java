package com.example.helloworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class CoffeeApplication extends Application {
    /**
     * Sets the start menu to the main screen
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-scene.fxml"));

        // inject new User account into scene
        User user = new User();
        loader.setControllerFactory( c -> {return new MainSceneController(user);});
        stage.setScene(new Scene(loader.load()));

        // assign alert popup on close request
        stage.setOnCloseRequest(event -> {event.consume(); createAlert(stage, loader, user);});

        stage.setTitle("Java Jive");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {launch();}

    /**
     * Creates an alert on exit of the app
     * @param stage
     * @param loader
     * @param user
     */
    public void createAlert(Stage stage, FXMLLoader loader, User user)
    {// This method creates the alert box that appears on close request

        // create buttons
        ButtonType Exit       = new ButtonType("Exit", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel            = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        // create alert box
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().setAll(Exit, cancel);

        // set alert text
        alert.setTitle("Are you sure?");
        alert.setHeaderText("Do you want to save the current user account before exiting?");
        alert.setContentText("Click 'cancel' to close this window");

        // handle user input
        ButtonType choice = alert.showAndWait().get();
        if(choice == Exit)
        { // save current user info
            stage.close();
        }

    }
}