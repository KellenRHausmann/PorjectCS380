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
        coffeeDrink mocha = new mocha(true, false, true, true);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = formatter.format(LocalDate.now());


        // add date and drink to user orders
        user.addOrder(date, mocha);
    }
    public void AddOrder(ActionEvent event)
    {
        Database db = new Database();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = formatter.format(LocalDate.now());
        String drinkChoice = drinkChoiceBox.getValue();
        StringBuilder str = new StringBuilder();

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

        if(drinkChoice.equals("Mocha"))
        {
            coffeeDrink mocha = new mocha(milkAddon, sugarAddon, whippedCreamAddon, syurpAddon);
            double price = mocha.getPrice();
            int calories = mocha.getCalories();
            int userID = SIC.getLoggedInCustomerId();
            db.addOrder(101, userID, date, drinkChoice, price, calories, additionString);
        }
        else if(drinkChoice.equals("Americano"))
        {
            coffeeDrink Americano = new americano(milkAddon, sugarAddon, whippedCreamAddon, syurpAddon);
            double price = Americano.getPrice();
            int calories = Americano.getCalories();
            int userID = SIC.getLoggedInCustomerId();
            db.addOrder(20, userID, date, drinkChoice, price, calories, additionString);
        }
        else if(drinkChoice.equals("Latte"))
        {
            coffeeDrink Latte = new latte(milkAddon, sugarAddon, whippedCreamAddon, syurpAddon);
            double price = Latte.getPrice();
            int calories = Latte.getCalories();
            int userID = SIC.getLoggedInCustomerId();
            db.addOrder(30, userID, date, drinkChoice, price, calories, additionString);
        }
        else if(drinkChoice.equals("Cappucino"))
        {
            coffeeDrink cappuccino = new cappuccino(milkAddon, sugarAddon, whippedCreamAddon, syurpAddon);
            double price = cappuccino.getPrice();
            int calories = cappuccino.getCalories();
            int userID = SIC.getLoggedInCustomerId();
            db.addOrder(40, userID, date, drinkChoice, price, calories, additionString);
        }


    }

    public void onOrder(ActionEvent event)
    {
        String drinkChoice = drinkChoiceBox.getValue();
        String sizeChoice = sizeChoiceBox.getValue();
        String tempChoice = tempChoiceBox.getValue();
        String caffeineChoice = caffeineChoiceBox.getValue();

    }
    public MainSceneController(User user){
        this.user = user;
    } // inject user

    private void displayCurrentDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        currentDateText.setText("Current date: " + formatter.format(LocalDate.now()));
    }
}