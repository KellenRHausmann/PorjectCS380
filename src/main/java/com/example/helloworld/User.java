package com.example.helloworld;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class User implements Serializable {
    private TreeMap<String, coffeeDrink> orders = new TreeMap<String, coffeeDrink>();
    // basically this object is a recordbook, has all previous orders, can run methods to get info about it, etc

    private int UserID;
    private String username;
    private String password;

    public void addOrder(String date, coffeeDrink drink)
    {
        this.orders.put(date, drink);
    }

    public TreeMap<String, coffeeDrink> getOrders(){ // return the orders in form of hashmap
        return new TreeMap<String, coffeeDrink>(this.orders);
    }
}
