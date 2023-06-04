package com.example.helloworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private Button orderButton;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField passwordField1;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameField;

    @FXML
    void onEnter(ActionEvent event) throws IOException
    {
        String un = usernameField.getText();
        String pw = passwordField.getText();

        Database db = new Database();
        String checkQuery = "SELECT userID FROM accounts WHERE username = '" + un + "'";

        int existingUserId = db.validateUser(checkQuery);
        if (existingUserId > 0)
        {
            showFailAlert("Username already exists");
            return;
        }

        // for later
        if (!pw.equals(passwordField1.getText()))
        {
            showFailAlert("Passwords don't match");
        }
        //Registers a new user to the database.
        else
        {
            db = new Database();
            db.addUser(pw, un);
            showSuccessAlert(un);
            onOrder(event);
        }
    }

    @FXML
    void onOrder(ActionEvent event) throws IOException {
        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-scene.fxml"));

        // inject User into scene
        loader.setControllerFactory( c -> {return new MainSceneController(new User());});

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    void onSignIn(ActionEvent event) throws IOException {
        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-in.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();

    }
    private void showSuccessAlert(String username)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sign Up");
        alert.setHeaderText(null);
        alert.setContentText("Successfully signed up as " + username);
        alert.showAndWait();
    }
    private void showFailAlert(String failAlert)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Failure");
        alert.setHeaderText(null);
        alert.setContentText(failAlert);
        alert.showAndWait();
    }

}