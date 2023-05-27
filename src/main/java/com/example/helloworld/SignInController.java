package com.example.helloworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {

    @FXML
    private Button orderButton;
    @FXML
    private Button enterButton;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameField;

    @FXML
    void onEnter(ActionEvent event) {
        String un = usernameField.getText();
        String pw = passwordField.getText();
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
    void onSignUp(ActionEvent event) throws IOException {
        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-up.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

}