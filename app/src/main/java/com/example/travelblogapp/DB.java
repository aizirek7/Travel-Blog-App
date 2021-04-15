package com.example.travelblogapp;

import java.util.ArrayList;

public class DB {
    private static ArrayList<Order> orders = new ArrayList<>();


    public static ArrayList<Order> getOrders() {
        return orders;
    }


}
