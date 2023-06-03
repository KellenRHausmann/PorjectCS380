package com.example.helloworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainSceneController {
    @FXML
    private Label currentDateText;
    @FXML
    private Button historyButton;

    @FXML
    private User user; // the user account which stores order history and balance


    @FXML
    protected void onPressHistoryButton(ActionEvent event) throws IOException{ // When 'history' button is clicked

        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("history.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));

        // inject User account into scene
        historyController historyController = loader.getController();
        historyController.inject(user);

        stage.show();
    }

    @FXML
    public void initialize() {

        // display date
        displayCurrentDate();

        // Sample Drink creation - the GUI and user input will handle this

        // create drink properties
        HashMap<String, Enum> properties = new HashMap<>();
        properties.put("Size", Enums.Size.MEDIUM);
        properties.put("Temperature", Enums.Temperature.HOT);
        properties.put("Caffeine", Enums.Caffeine.DECAF);

        // create additions
        ArrayList<additions> additions = new ArrayList();
        final additions milk  = new additions(0.25, 25, "milk");
        final additions sugar = new additions(0.50, 15, "sugar");
        final additions syrup = new additions(1.25, 50, "syrup");
        final additions whipCream = new additions(0.80, 75, "whipped cream");

        // create the drink
        coffeeDrink mocha = new coffeeDrink("Mocha", 2.5, 500, properties, additions);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = formatter.format(LocalDate.now());

        // add date and drink to user orders
        user.addOrder(date, mocha);
    }
    public MainSceneController(User user){
        this.user = user;
    } // inject user

    private void displayCurrentDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        currentDateText.setText("Current date: " + formatter.format(LocalDate.now()));
    }
}