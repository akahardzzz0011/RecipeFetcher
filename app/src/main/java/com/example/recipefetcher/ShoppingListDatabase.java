package com.example.recipefetcher;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import android.content.Context;

@Database(entities = ShoppingListItem.class, version = 1)
public abstract class ShoppingListDatabase extends RoomDatabase {

    public abstract Dao Dao();
    private static volatile ShoppingListDatabase shoppingListRoomInstance;

    static ShoppingListDatabase getDatabase(final Context context) {
        if(shoppingListRoomInstance == null) {
            synchronized (ShoppingListDatabase.class) {
                if(shoppingListRoomInstance == null) {
                    shoppingListRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            ShoppingListDatabase.class, "shopping_list_db").build();
                }
            }
        }
        return shoppingListRoomInstance;
    }
}
