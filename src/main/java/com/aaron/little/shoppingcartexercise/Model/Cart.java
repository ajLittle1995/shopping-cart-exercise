package com.aaron.little.shoppingcartexercise.Model;

import com.aaron.little.shoppingcartexercise.Model.Item;
import java.util.ArrayList;

public class Cart {
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    private ArrayList<Item> items;



}
