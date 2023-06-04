package com.example.helloworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainSceneController {
    @FXML
    private Label currentDateText;
    @FXML
    private Button historyButton;
    @FXML
    private Button signinButton;
    @FXML
    private Button signupButton;
    @FXML
    private CheckBox milkAddition;
    @FXML
    private CheckBox sugarAddition;
    @FXML
    private CheckBox syurpAddition;
    @FXML
    private CheckBox whippedCreamAddition;
    @FXML
    private ChoiceBox<String> drinkChoiceBox;
    @FXML
    private ChoiceBox<String> sizeChoiceBox;
    @FXML
    private ChoiceBox<String>  tempChoiceBox;
    @FXML
    private ChoiceBox<String> caffeineChoiceBox;

    String[] drinks = {"Mocha", "Americano", "Cappucino", "Latte"};
    String[] sizes = {"Small", "Medium", "Large"};
    String[] temperatures = {"Iced", "Hot"};
    String[] caffeineChoices = {"Regular", "Split-shot", "Decaf"};



    @FXML
    private User user; // the user account which stores order history and balance
    public SignInController SIC;


    @FXML
    protected void onPressHistoryButton(ActionEvent event) throws IOException, SQLException { // When 'history' button is clicked

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
    protected void onSignIn(ActionEvent event) throws IOException {
        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));

        stage.show();
    }
    @FXML
    protected void onSignUp(ActionEvent event) throws IOException {
        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));

        stage.show();
    }

    @FXML
    public void initialize() {

        // display date
        displayCurrentDate();

        // add choices to choicebox
        drinkChoiceBox.getItems().addAll(drinks);
        sizeChoiceBox.getItems().addAll(sizes);
        tempChoiceBox.getItems().addAll(temperatures);
        caffeineChoiceBox.getItems().addAll(caffeineChoices);

        // create drink properties
        HashMap<String, Enum> properties = new HashMap<>();
        properties.put("Size", Enums.Size.MEDIUM);
        properties.put("Temperature", Enums.Temperature.HOT);
        properties.put("Caffeine", Enums.Caffeine.DECAF);



    }
    public void AddOrder(ActionEvent event) throws SQLException
    {
        Database db = new Database();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        StringBuilder str = new StringBuilder();
        String date = formatter.format(LocalDate.now());

        String drinkChoice = drinkChoiceBox.getValue();
        String sizeChoice = sizeChoiceBox.getValue();
        String tempChoice = tempChoiceBox.getValue();
        String caffChoice = caffeineChoiceBox.getValue();

        boolean milkAddon = milkAddition.isSelected();
        boolean sugarAddon = sugarAddition.isSelected();
        boolean whippedCreamAddon = whippedCreamAddition.isSelected();
        boolean syurpAddon = syurpAddition.isSelected();

        if(milkAddon)
        {
            str.append("Milk,");
        }
        if(sugarAddon)
        {
            str.append("Sugar,");
        }
        if(whippedCreamAddon)
        {
            str.append("Whipped Cream,");
        }
        if(syurpAddon)
        {
            str.append("Syrup,");
        }
        String additionString = str.toString();

        if(SIC.getLoggedInCustomerId() > 0)
        {
            if(drinkChoice.equals("Mocha"))
            {
                coffeeDrink mocha = new mocha(milkAddon, sugarAddon, whippedCreamAddon, syurpAddon);

                double price = mocha.getPrice();
                int calories = mocha.getCalories();
                int userID = SIC.getLoggedInCustomerId();
                int drinkCount = db.getMaxDrinkCount();

                db.addOrder(drinkCount, userID, date, drinkChoice, price, calories, additionString, sizeChoice , tempChoice, caffChoice);
                showSuccessAlert();
            }
            else if(drinkChoice.equals("Americano"))
            {
                coffeeDrink Americano = new americano(milkAddon, sugarAddon, whippedCreamAddon, syurpAddon);

                double price = Americano.getPrice();
                int calories = Americano.getCalories();
                int userID = SIC.getLoggedInCustomerId();
                int drinkCount = db.getMaxDrinkCount();

                db.addOrder(drinkCount, userID, date, drinkChoice, price, calories, additionString, sizeChoice , tempChoice, caffChoice);
                showSuccessAlert();
            }
            else if(drinkChoice.equals("Latte"))
            {
                coffeeDrink Latte = new latte(milkAddon, sugarAddon, whippedCreamAddon, syurpAddon);

                double price = Latte.getPrice();
                int calories = Latte.getCalories();
                int userID = SIC.getLoggedInCustomerId();
                int drinkCount = db.getMaxDrinkCount();

                db.addOrder(drinkCount, userID, date, drinkChoice, price, calories, additionString, sizeChoice , tempChoice, caffChoice);
                showSuccessAlert();
            }
            else if(drinkChoice.equals("Cappucino"))
            {
                coffeeDrink cappuccino = new cappuccino(milkAddon, sugarAddon, whippedCreamAddon, syurpAddon);

                double price = cappuccino.getPrice();
                int calories = cappuccino.getCalories();
                int userID = SIC.getLoggedInCustomerId();
                int drinkCount = db.getMaxDrinkCount();

                db.addOrder(drinkCount, userID, date, drinkChoice, price, calories, additionString, sizeChoice , tempChoice, caffChoice);
                showSuccessAlert();
            }
        }
        else
        {
            showFailureAlert("Sign in or Sign up to order");
        }


    }
    public MainSceneController(User user)
    {
        this.user = user;
    }

    private void displayCurrentDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        currentDateText.setText("Current date: " + formatter.format(LocalDate.now()));
    }
    private void showSuccessAlert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Alert");
        alert.setHeaderText(null);
        alert.setContentText("Drink ordered!");
        alert.showAndWait();
    }
    private void showFailureAlert(String failure)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fail Alert");
        alert.setHeaderText(null);
        alert.setContentText(failure);
        alert.showAndWait();
    }
}