package com.example.recipefetcher;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_list")
public class ShoppingListItem {

    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private String item;
    @NonNull
    private String amount;

    public ShoppingListItem(String id, String item, String amount) {
        this.id = id;
        this.item = item;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getItem() {
        return item;
    }

    public void setItem(@NonNull String item) {
        this.item = item;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
