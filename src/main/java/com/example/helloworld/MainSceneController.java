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

    /**
     * Goes to the history screen
     * @param event
     * @throws IOException
     * @throws SQLException
     */
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

    /**
     * Goes to the sign in screen
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onSignIn(ActionEvent event) throws IOException {
        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
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
    protected void onSignUp(ActionEvent event) throws IOException {
        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));

        stage.show();
    }

    /**
     * Intilizes everything
     */
    @FXML
    public void initialize()
    {
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

    /**
     * Creates an order and pushes it to the database
     * @param event
     * @throws SQLException
     */
    public void AddOrder(ActionEvent event) throws SQLException
    {
        Database db = new Database();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        StringBuilder str = new StringBuilder();
        String date = formatter.format(LocalDate.now());
        /**
         * Grabs the variables from the selected buttons
         */
        String drinkChoice = drinkChoiceBox.getValue();
        String sizeChoice = sizeChoiceBox.getValue();
        String tempChoice = tempChoiceBox.getValue();
        String caffChoice = caffeineChoiceBox.getValue();
        /**
         * Checks if the addons have been checked
         */
        boolean milkAddon = milkAddition.isSelected();
        boolean sugarAddon = sugarAddition.isSelected();
        boolean whippedCreamAddon = whippedCreamAddition.isSelected();
        boolean syurpAddon = syurpAddition.isSelected();
        /**
         * Checks what addons have been selected
         */
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

        if(additionString.equals(""))
        {
            additionString = "None";
        }
        //Checks if the userID is greater than 0 basically makes it so that you need to sing in to order
        if(SIC.getLoggedInCustomerId() > 0)
        {
            /**
             * Checks drink and orders accordingly
             */
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
            /**
             * Checks drink and orders accordingly
             */
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
            /**
             * Checks drink and orders accordingly
             */
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
            /**
             * Checks drink and orders accordingly
             */
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

    /**
     * Displays current date
     */
    private void displayCurrentDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        currentDateText.setText("Current date: " + formatter.format(LocalDate.now()));
    }

    /**
     * Shows a succes pop up
     */
    private void showSuccessAlert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Alert");
        alert.setHeaderText(null);
        alert.setContentText("Drink ordered!");
        alert.showAndWait();
    }

    /**
     * Shows a fail pop up
     * @param failure
     */
    private void showFailureAlert(String failure)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fail Alert");
        alert.setHeaderText(null);
        alert.setContentText(failure);
        alert.showAndWait();
    }
}