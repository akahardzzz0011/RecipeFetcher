package com.example.recipefetcher;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_list")
public class ShoppingListItem {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id = 0;
    @NonNull
    private String item = "";
    @NonNull
    private int amount = 0;

    public ShoppingListItem(String item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getItem() {
        return item;
    }

    public void setItem(@NonNull String item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}