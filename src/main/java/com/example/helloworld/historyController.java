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
import java.sql.*;
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
    public SignInController SIC;
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

    protected void inject(User user) throws SQLException
    {
        String query = "SELECT orderDate, drinkType, price, calories FROM orders WHERE customerID = " + SIC.getLoggedInCustomerId();

        String url = "jdbc:mysql://localhost:3306/projectdatabase";
        String username = "root";
        String password = "cs380";

        try
        {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {
                String date = rs.getString("orderDate");
                String drinkType = rs.getString("drinkType");
                double price = rs.getDouble("price");
                int calories = rs.getInt("calories");

                table.getItems().add(new historyEntryObject(date, drinkType, price, calories));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
