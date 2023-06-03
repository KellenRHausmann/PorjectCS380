package com.example.helloworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class historyController {
    @FXML
    private TableView<historyEntryObject> table;
    @FXML
    private TableColumn<historyEntryObject, String> dateCol;
    @FXML
    private TableColumn<historyEntryObject, String> drinkCol;
    @FXML
    private TableColumn<historyEntryObject, Double> priceCol;
    @FXML
    private TableColumn<historyEntryObject, Integer> caloriesCol;
    @FXML
    private Button backButton;

    private User user;
    @FXML
    protected void onBackButtonPressed(ActionEvent event) throws IOException {

        // load new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-scene.fxml"));

        // inject User into scene
        loader.setControllerFactory( c -> {return new MainSceneController(user);});

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    public void initialize() { // assigns cell factories

        // date column
        dateCol.setCellValueFactory(new PropertyValueFactory<historyEntryObject, String>("date"));

        // drink column
        drinkCol.setCellValueFactory(new PropertyValueFactory<historyEntryObject, String>("drinkType"));

        priceCol.setCellValueFactory(new PropertyValueFactory<historyEntryObject, Double>("price"));

        caloriesCol.setCellValueFactory(new PropertyValueFactory<historyEntryObject, Integer>("calories"));
    }

    protected void inject(User user){ // injects user data into table

        this.user = user;
        // create historyEntryObjects from hashmap entries and add to table
        for (Map.Entry<String, coffeeDrink> entry : user.getOrders().entrySet()) {

            String date = entry.getKey();
            coffeeDrink drink = entry.getValue();

            String drinkType = drink.getDrinkType();
            Double price  = drink.getTotalPrice();
            Integer calories = drink.getTotalCalories();

            table.getItems().add(new historyEntryObject(date, drinkType, price, calories));
        }
    }
}