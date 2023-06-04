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

public class SignInController {
    private static int loggedInUserId;
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

    /**
     * Signs in the user and sets the ID that you need for the databse
     * @param event
     * @throws IOException
     */
    @FXML
    void onEnter(ActionEvent event) throws IOException
    {
        String un = usernameField.getText();
        String pw = passwordField.getText();

        Database db = new Database();

        String query = "SELECT userID FROM accounts " +
                "WHERE username = '" + un + "' AND pass = '" + pw + "'";
        int id = db.validateUser(query);
        if(id > 0)
        {
            SignInController.setLoggedInCustomerId(id);
            showSuccessAlert(un);
            onOrder(event);
        }
        else
        {
            showFailAlert("Incorrect username or password");
        }
    }

    /**
     * Goes to the main scereen
     * @param event
     * @throws IOException
     */
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

    /**
     * Goes to the sign up screen
     * @param event
     * @throws IOException
     */
    @FXML
    void onSignUp(ActionEvent event) throws IOException {
        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-up.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    /**
     * Alerts of a succesful sign in
     * @param username
     */
    private void showSuccessAlert(String username)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sign In");
        alert.setHeaderText(null);
        alert.setContentText("Successfully signed in as " + username);
        alert.showAndWait();
    }

    /**
     * Alerts of a failed sign in
     * @param failAlert
     */
    private void showFailAlert(String failAlert)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Failure");
        alert.setHeaderText(null);
        alert.setContentText(failAlert);
        alert.showAndWait();
    }

    /**
     * Sets the logged in user id
     * @param userId
     */
    public static void setLoggedInCustomerId(int userId)
    {
        loggedInUserId = userId;
    }
    /**
     * Gets the logged in user id
     * @return loggedInUserID
     */
    public static int getLoggedInCustomerId()
    {
        return loggedInUserId;
    }
}